package org.maxsoft.util;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.Hashtable;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 *
 * @author larson.liu ��������ͼƬ���棬��ֹ�ڴ����
 */
public class BitmapCache {
	static BitmapCache cache;
	/** ����Chche���ݵĴ洢 */
	Hashtable bitmapRefs;
	/** ����Reference�Ķ��У������õĶ����Ѿ������գ��򽫸����ô�������У� */
	ReferenceQueue q;

	/**
	 * �̳�SoftReference��ʹ��ÿһ��ʵ�������п�ʶ��ı�ʶ��
	 */
	class BtimapRef extends SoftReference {
		Integer _key = 0;

		public BtimapRef(Bitmap bmp, ReferenceQueue q, int key) {
			super(bmp, q);
			_key = key;
		}
	}

	BitmapCache() {
		bitmapRefs = new Hashtable();
		q = new ReferenceQueue();

	}

	/**
	 * ȡ�û�����ʵ��
	 */
	public static BitmapCache getInstance() {
		if (cache == null) {
			cache = new BitmapCache();
		}
		return cache;

	}

	/**
	 * �������õķ�ʽ��һ��Bitmap�����ʵ���������ò����������
	 */
	void addCacheBitmap(Bitmap bmp, Integer key) {
		cleanCache();// �����������
		BtimapRef ref = new BtimapRef(bmp, q, key);
		bitmapRefs.put(key, ref);
	}

	/**
	 * ������ָ����drawable�µ�ͼƬ��ԴID�ţ����Ը����Լ�����Ҫ������򱾵�path�»�ȡ�������»�ȡ��ӦBitmap�����ʵ��
	 */
	public Bitmap getBitmap(int resId, Context context) {
		Bitmap bmp = null;
		// �������Ƿ��и�Bitmapʵ���������ã�����У�����������ȡ�á�
		if (bitmapRefs.containsKey(resId)) {
			BtimapRef ref = (BtimapRef) bitmapRefs.get(resId);
			bmp = (Bitmap) ref.get();
		}
		// ���û�������ã����ߴ��������еõ���ʵ����null�����¹���һ��ʵ����
		// �����������½�ʵ����������
		if (bmp == null) {
			bmp = BitmapFactory.decodeResource(context.getResources(), resId);
			this.addCacheBitmap(bmp, resId);
		}
		return bmp;
	}

	void cleanCache() {
		BtimapRef ref = null;
		while ((ref = (BtimapRef) q.poll()) != null) {
			bitmapRefs.remove(ref._key);
		}
	}

	// ���Cache�ڵ�ȫ������
	public void clearCache() {
		cleanCache();
		bitmapRefs.clear();
		System.gc();
		System.runFinalization();
	}

}