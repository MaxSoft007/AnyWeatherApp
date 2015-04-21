package org.maxsoft.pojo;

import java.io.Serializable;

/**
 * @function ����ָ����Ϣʵ�壬������ϢԴ���й�����֡�
 * 			 http://www.weather.com.cn/data/zs/101010100.html
 * @author MaxSoft
 * @date 2014-12-21
 * @version 1.0.0
 */
public class LifeIndexInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String date =""; //2014122120",
	private String ac_name =""; //�յ�����ָ��",
	private String ac_hint =""; //������ů�յ�",
	private String ac_des =""; //�����е���Щ�䣬�����ʵ�������ů�յ����������¶ȣ�����������ð��",
	private String ac_des_s =""; //������䣬���鿪��ů�յ��������¡�",
		
	private String ag_name =""; //����ָ��",
	private String ag_hint =""; //�����׷�",
	private String ag_des =""; //���������������շ��������ɷ���������������",
	private String ag_des_s =""; //���赣�Ĺ������ɷ���������������",
		
	private String be_name =""; //����ԡ��",
	private String be_hint =""; //�ϲ���",
	private String be_des =""; //�ϲ����º��������������ʣ����¶Ⱥܵͣ��з磬���Ƽ��º����档",
	private String be_des_s =""; //",
		
	private String cl_name =""; //����ָ��",
	private String cl_hint =""; //����",
	private String cl_des =""; //���������������£����������Ĵ��ʱ�������鲻ͬ����ε����ǻ����μӻ��⽡����",
	private String cl_des_s =""; //���������������£��ǳ����ĺ�ʱ����",
		
	private String co_name =""; //���ʶ�ָ��",
	private String co_hint =""; //������",
	private String co_des =""; //������Ȼ������ã��������о�ƫ����������ʡ����ˡ�",
	private String co_des_s =""; //������ã�����ƫ����������ʡ�",
		
	private String ct_name =""; //����ָ��",
	private String ct_hint =""; //����",
	private String ct_des =""; //�����ź����׼�ë�µȷ�װ���������������Ŵ��¡������׼���ë����",
	private String ct_des_s =""; //�����ź����׼�ë�µȷ�װ��",
		
	private String dy_name =""; //����ָ��",
	private String dy_hint =""; //������",
	private String dy_des =""; //���ʺϴ�������������������Դ�������һ����Ӱ�졣",
	private String dy_des_s =""; //����������Դ�������һ��Ӱ�졣",
		
	private String fs_name =""; //��ɹָ��",
	private String fs_hint =""; //����",
	private String fs_des =""; //������ǿ�Ƚ���������Ϳ��SPF��12-15֮�䣬PA+�ķ�ɹ����Ʒ��",
	private String fs_des_s =""; //ͿĨ12-15SPF��PA+����Ʒ��",
		
	private String gj_name =""; //���ָ��",
	private String gj_hint =""; //������",
	private String gj_des =""; //�����Ϻã������˹�֣���������ǰҪ��ů��һ�㣬ǧ��������ˡ�",
	private String gj_des_s =""; //���Ҫ��ů��һ�����������",
		
	private String gl_name =""; //̫����ָ��",
	private String gl_hint =""; //��Ҫ",
	private String gl_des =""; //�����������ʣ�̫�������ǿ���������͸���1���ұ�עUV380-UV400��������",
	private String gl_des_s =""; //�������͸���Ϊ1����������",
		
	private String gm_name =""; //��ðָ��",
	private String gm_hint =""; //���׷�",
	private String gm_des =""; //��ҹ�²�ϴ󣬽��׷�����ð�����ʵ������·������ʽ�����������ע�������",
	private String gm_des_s =""; //�²�ϴ󣬽��׸�ð��ע�������",
		
	private String gz_name =""; //����ָ��",
	private String gz_hint =""; //�ǳ�����",
	private String gz_des =""; //����ʪ�ȵͣ�Ƥ���׸о����Ӧ��ʱ��������ˮ�֣�Ԥ���ֽŵȲ�λ���ѣ�ͿĨ�߱�ʪǿ�����ͻ���Ʒ���ʵ�������ԡ���������ù��ȵ�ˮϴ�衣",
	private String gz_des_s =""; //",
		
	private String hc_name =""; //����ָ��",
	private String hc_hint =""; //������",
	private String hc_des =""; //��������˻������������Եͣ���ע����£�С��������",
	private String hc_des_s =""; //���µ�ע�⼰ʱ���£�С��������",
		
	private String jt_name =""; //��ָͨ��",
	private String jt_hint =""; //����",
	private String jt_des =""; //�����Ϻã�·������ͨ�����������ã���������������ʻ��",
	private String jt_des_s =""; //�����������ã���������������ʻ��",
		
	private String lk_name =""; //·��ָ��",
	private String lk_hint =""; //����",
	private String lk_des =""; //�����Ϻã�·��Ƚϸ��·���Ϻá�",
	private String lk_des_s =""; //�����Ϻã�·��ϸ��·���Ϻá�",
		
	private String ls_name =""; //��ɹָ��",
	private String ls_hint =""; //��������",
	private String ls_des =""; //�������������ů����������������������ùɱ������ɹ����",
	private String ls_des_s =""; //��������ץ��ʱ��������ɹ̫���ɡ�",
		
	private String mf_name =""; //����ָ��",
	private String mf_hint =""; //����",
	private String mf_des =""; //����Ŀ����״���ͷ����ˮ�ֲ��������磬����ͷ����ᷢɬ�����ʱ�ɱ�࣬ʧȥ�������ʹ���ں�����ɷֵ�ϴ��¶�ͻ����ء�",
	private String mf_des_s =""; //�����������ʹ������ɷֵĻ����ء�",

	private String nl_name =""; //ҹ����ָ��",
	private String nl_hint =""; //������",
	private String nl_des =""; //�����Ϻã���Ȼ�е�磬�Ƚ�����ҹ��������Է��������",
	private String nl_des_s =""; //ֻҪ������׼���Ϳ��Է��������",
		
	private String pj_name =""; //ơ��ָ��",
	private String pj_hint =""; //������",
	private String pj_des =""; //������������ܻ����ơ�ƶ������ջ󣬿��������ó���ơ�ơ�",
	private String pj_des_s =""; //�������䣬���������ó���ơ�ơ�",
		
	private String pk_name =""; //�ŷ���ָ��",
	private String pk_hint =""; //����",
	private String pk_des =""; //�������䣬�����˷ŷ��ݡ�",
	private String pk_des_s =""; //�������䣬�����˷ŷ��ݡ�",
		
	private String pl_name =""; //������Ⱦ��ɢ����ָ��",
	private String pl_hint =""; //�ϲ�","
	private String pl_des =""; //���������ϲ����ڿ�����Ⱦ��ϡ�͡���ɢ����������ʵ���������ʱ�䡣",
	private String pl_des_s =""; //���������ϲ����ڿ�����Ⱦ����ɢ����",
		
	private String pp_name =""; //��ױָ��",
	private String pp_hint =""; //����ʪ",
	private String pp_des =""; //�������䡢�������������ʪ�ͻ�ױƷ�����˷ۣ�ʹ���󴽸ࡣ",
	private String pp_des_s =""; //��ѡ������ʪ�ͻ�ױƷ��",
		
	private String pt_name =""; //������Ⱦ����ָ��",
	private String pt_hint =""; //��",
	private String pt_des =""; //�����������ʣ����������Ϻã��������",
	private String pt_des_s =""; //���������ã��������",
		
	private String sg_name =""; //һ�仰��ʾָ��",
	private String sg_hint =""; //��ȱ",
	private String sg_des =""; //ҹ���з磬����Ӱ��������档",
	private String sg_des_s =""; //",
		
	private String tr_name =""; //����ָ��",
	private String tr_hint =""; //����",
	private String tr_des =""; //�����Ϻã������Եͣ���о���΢�е���������Ҳ�Ǹ�������Ŷ���������Σ��ɲ�Ҫ��������ϣ�",
	private String tr_des_s =""; //�����Եͣ��о������������Ǹ���������",
		
	private String uv_name =""; //������ǿ��ָ��",
	private String uv_hint =""; //��",
	private String uv_des =""; //������ǿ�Ƚ������������ǰͿ��SPF��12-15֮�䡢PA+�ķ�ɹ����Ʒ��",
	private String uv_des_s =""; //���������Ϳ��SPF12-15��PA+����Ʒ��",
		
	private String xc_name =""; //ϴ��ָ��",
	private String xc_hint =""; //������",
	private String xc_des =""; //������ϴ����δ��һ�����꣬������С����ϴһ�µ����������ܱ���һ�졣",
	private String xc_des_s =""; //�����ҷ�����С���ױ������ȡ�",
		
	private String xq_name =""; //����ָ��",
	private String xq_hint =""; //�Ϻ�",
	private String xq_des =""; //�����Ϻã���͵�����͸������Ŀ�������ش�������ů��Ҳ�����������ĵ�ƣ�������������������ü����ܴ������ɹ����Ҹ���Ӱ�ӡ�",
	private String xq_des_s =""; //������������Ϊ�������Ĵ�����ů��",
		
	private String yd_name =""; //�˶�ָ��",
	private String yd_hint =""; //������",
	private String yd_des =""; //�����Ϻã�����ˮ���ţ������˽��и����˶����������½ϵͣ��ڻ����˶���ע���������",
	private String yd_des_s =""; //���½ϵͣ��ڻ����˶���ע���������",
		
	private String yh_name =""; //Լ��ָ��",
	private String yh_hint =""; //����",
	private String yh_des =""; //�����Ϻã�������Я�ֳ��Σ�ʵ�����������顢�����������������¡�",
	private String yh_des_s =""; //�����Ϻã�����Լ�ᡣ",
		
	private String ys_name =""; //��ɡָ��",
	private String ys_hint =""; //����ɡ",
	private String ys_des =""; //�����Ϻã����ڳ��ŵ�ʱ���������ɡ��",
	private String ys_des_s =""; //�����Ϻã����ô���ɡ��",
		
	private String zs_name =""; //����ָ��",
	private String zs_hint =""; //��",
	private String zs_des =""; //�¶Ȳ��ߣ��������������������ˣ�������ʼ��͡�",
	private String zs_des_s =""; //���²��ߣ�����ʼ��͡�"
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getAc_name() {
		return ac_name;
	}
	public void setAc_name(String ac_name) {
		this.ac_name = ac_name;
	}
	public String getAc_hint() {
		return ac_hint;
	}
	public void setAc_hint(String ac_hint) {
		this.ac_hint = ac_hint;
	}
	public String getAc_des() {
		return ac_des;
	}
	public void setAc_des(String ac_des) {
		this.ac_des = ac_des;
	}
	public String getAc_des_s() {
		return ac_des_s;
	}
	public void setAc_des_s(String ac_des_s) {
		this.ac_des_s = ac_des_s;
	}
	public String getAg_name() {
		return ag_name;
	}
	public void setAg_name(String ag_name) {
		this.ag_name = ag_name;
	}
	public String getAg_hint() {
		return ag_hint;
	}
	public void setAg_hint(String ag_hint) {
		this.ag_hint = ag_hint;
	}
	public String getAg_des() {
		return ag_des;
	}
	public void setAg_des(String ag_des) {
		this.ag_des = ag_des;
	}
	public String getAg_des_s() {
		return ag_des_s;
	}
	public void setAg_des_s(String ag_des_s) {
		this.ag_des_s = ag_des_s;
	}
	public String getBe_name() {
		return be_name;
	}
	public void setBe_name(String be_name) {
		this.be_name = be_name;
	}
	public String getBe_hint() {
		return be_hint;
	}
	public void setBe_hint(String be_hint) {
		this.be_hint = be_hint;
	}
	public String getBe_des() {
		return be_des;
	}
	public void setBe_des(String be_des) {
		this.be_des = be_des;
	}
	public String getBe_des_s() {
		return be_des_s;
	}
	public void setBe_des_s(String be_des_s) {
		this.be_des_s = be_des_s;
	}
	public String getCl_name() {
		return cl_name;
	}
	public void setCl_name(String cl_name) {
		this.cl_name = cl_name;
	}
	public String getCl_hint() {
		return cl_hint;
	}
	public void setCl_hint(String cl_hint) {
		this.cl_hint = cl_hint;
	}
	public String getCl_des() {
		return cl_des;
	}
	public void setCl_des(String cl_des) {
		this.cl_des = cl_des;
	}
	public String getCl_des_s() {
		return cl_des_s;
	}
	public void setCl_des_s(String cl_des_s) {
		this.cl_des_s = cl_des_s;
	}
	public String getCo_name() {
		return co_name;
	}
	public void setCo_name(String co_name) {
		this.co_name = co_name;
	}
	public String getCo_hint() {
		return co_hint;
	}
	public void setCo_hint(String co_hint) {
		this.co_hint = co_hint;
	}
	public String getCo_des() {
		return co_des;
	}
	public void setCo_des(String co_des) {
		this.co_des = co_des;
	}
	public String getCo_des_s() {
		return co_des_s;
	}
	public void setCo_des_s(String co_des_s) {
		this.co_des_s = co_des_s;
	}
	public String getCt_name() {
		return ct_name;
	}
	public void setCt_name(String ct_name) {
		this.ct_name = ct_name;
	}
	public String getCt_hint() {
		return ct_hint;
	}
	public void setCt_hint(String ct_hint) {
		this.ct_hint = ct_hint;
	}
	public String getCt_des() {
		return ct_des;
	}
	public void setCt_des(String ct_des) {
		this.ct_des = ct_des;
	}
	public String getCt_des_s() {
		return ct_des_s;
	}
	public void setCt_des_s(String ct_des_s) {
		this.ct_des_s = ct_des_s;
	}
	public String getDy_name() {
		return dy_name;
	}
	public void setDy_name(String dy_name) {
		this.dy_name = dy_name;
	}
	public String getDy_hint() {
		return dy_hint;
	}
	public void setDy_hint(String dy_hint) {
		this.dy_hint = dy_hint;
	}
	public String getDy_des() {
		return dy_des;
	}
	public void setDy_des(String dy_des) {
		this.dy_des = dy_des;
	}
	public String getDy_des_s() {
		return dy_des_s;
	}
	public void setDy_des_s(String dy_des_s) {
		this.dy_des_s = dy_des_s;
	}
	public String getFs_name() {
		return fs_name;
	}
	public void setFs_name(String fs_name) {
		this.fs_name = fs_name;
	}
	public String getFs_hint() {
		return fs_hint;
	}
	public void setFs_hint(String fs_hint) {
		this.fs_hint = fs_hint;
	}
	public String getFs_des() {
		return fs_des;
	}
	public void setFs_des(String fs_des) {
		this.fs_des = fs_des;
	}
	public String getFs_des_s() {
		return fs_des_s;
	}
	public void setFs_des_s(String fs_des_s) {
		this.fs_des_s = fs_des_s;
	}
	public String getGj_name() {
		return gj_name;
	}
	public void setGj_name(String gj_name) {
		this.gj_name = gj_name;
	}
	public String getGj_hint() {
		return gj_hint;
	}
	public void setGj_hint(String gj_hint) {
		this.gj_hint = gj_hint;
	}
	public String getGj_des() {
		return gj_des;
	}
	public void setGj_des(String gj_des) {
		this.gj_des = gj_des;
	}
	public String getGj_des_s() {
		return gj_des_s;
	}
	public void setGj_des_s(String gj_des_s) {
		this.gj_des_s = gj_des_s;
	}
	public String getGl_name() {
		return gl_name;
	}
	public void setGl_name(String gl_name) {
		this.gl_name = gl_name;
	}
	public String getGl_hint() {
		return gl_hint;
	}
	public void setGl_hint(String gl_hint) {
		this.gl_hint = gl_hint;
	}
	public String getGl_des() {
		return gl_des;
	}
	public void setGl_des(String gl_des) {
		this.gl_des = gl_des;
	}
	public String getGl_des_s() {
		return gl_des_s;
	}
	public void setGl_des_s(String gl_des_s) {
		this.gl_des_s = gl_des_s;
	}
	public String getGm_name() {
		return gm_name;
	}
	public void setGm_name(String gm_name) {
		this.gm_name = gm_name;
	}
	public String getGm_hint() {
		return gm_hint;
	}
	public void setGm_hint(String gm_hint) {
		this.gm_hint = gm_hint;
	}
	public String getGm_des() {
		return gm_des;
	}
	public void setGm_des(String gm_des) {
		this.gm_des = gm_des;
	}
	public String getGm_des_s() {
		return gm_des_s;
	}
	public void setGm_des_s(String gm_des_s) {
		this.gm_des_s = gm_des_s;
	}
	public String getGz_name() {
		return gz_name;
	}
	public void setGz_name(String gz_name) {
		this.gz_name = gz_name;
	}
	public String getGz_hint() {
		return gz_hint;
	}
	public void setGz_hint(String gz_hint) {
		this.gz_hint = gz_hint;
	}
	public String getGz_des() {
		return gz_des;
	}
	public void setGz_des(String gz_des) {
		this.gz_des = gz_des;
	}
	public String getGz_des_s() {
		return gz_des_s;
	}
	public void setGz_des_s(String gz_des_s) {
		this.gz_des_s = gz_des_s;
	}
	public String getHc_name() {
		return hc_name;
	}
	public void setHc_name(String hc_name) {
		this.hc_name = hc_name;
	}
	public String getHc_hint() {
		return hc_hint;
	}
	public void setHc_hint(String hc_hint) {
		this.hc_hint = hc_hint;
	}
	public String getHc_des() {
		return hc_des;
	}
	public void setHc_des(String hc_des) {
		this.hc_des = hc_des;
	}
	public String getHc_des_s() {
		return hc_des_s;
	}
	public void setHc_des_s(String hc_des_s) {
		this.hc_des_s = hc_des_s;
	}
	public String getJt_name() {
		return jt_name;
	}
	public void setJt_name(String jt_name) {
		this.jt_name = jt_name;
	}
	public String getJt_hint() {
		return jt_hint;
	}
	public void setJt_hint(String jt_hint) {
		this.jt_hint = jt_hint;
	}
	public String getJt_des() {
		return jt_des;
	}
	public void setJt_des(String jt_des) {
		this.jt_des = jt_des;
	}
	public String getJt_des_s() {
		return jt_des_s;
	}
	public void setJt_des_s(String jt_des_s) {
		this.jt_des_s = jt_des_s;
	}
	public String getLk_name() {
		return lk_name;
	}
	public void setLk_name(String lk_name) {
		this.lk_name = lk_name;
	}
	public String getLk_hint() {
		return lk_hint;
	}
	public void setLk_hint(String lk_hint) {
		this.lk_hint = lk_hint;
	}
	public String getLk_des() {
		return lk_des;
	}
	public void setLk_des(String lk_des) {
		this.lk_des = lk_des;
	}
	public String getLk_des_s() {
		return lk_des_s;
	}
	public void setLk_des_s(String lk_des_s) {
		this.lk_des_s = lk_des_s;
	}
	public String getLs_name() {
		return ls_name;
	}
	public void setLs_name(String ls_name) {
		this.ls_name = ls_name;
	}
	public String getLs_hint() {
		return ls_hint;
	}
	public void setLs_hint(String ls_hint) {
		this.ls_hint = ls_hint;
	}
	public String getLs_des() {
		return ls_des;
	}
	public void setLs_des(String ls_des) {
		this.ls_des = ls_des;
	}
	public String getLs_des_s() {
		return ls_des_s;
	}
	public void setLs_des_s(String ls_des_s) {
		this.ls_des_s = ls_des_s;
	}
	public String getMf_name() {
		return mf_name;
	}
	public void setMf_name(String mf_name) {
		this.mf_name = mf_name;
	}
	public String getMf_hint() {
		return mf_hint;
	}
	public void setMf_hint(String mf_hint) {
		this.mf_hint = mf_hint;
	}
	public String getMf_des() {
		return mf_des;
	}
	public void setMf_des(String mf_des) {
		this.mf_des = mf_des;
	}
	public String getMf_des_s() {
		return mf_des_s;
	}
	public void setMf_des_s(String mf_des_s) {
		this.mf_des_s = mf_des_s;
	}
	public String getNl_name() {
		return nl_name;
	}
	public void setNl_name(String nl_name) {
		this.nl_name = nl_name;
	}
	public String getNl_hint() {
		return nl_hint;
	}
	public void setNl_hint(String nl_hint) {
		this.nl_hint = nl_hint;
	}
	public String getNl_des() {
		return nl_des;
	}
	public void setNl_des(String nl_des) {
		this.nl_des = nl_des;
	}
	public String getNl_des_s() {
		return nl_des_s;
	}
	public void setNl_des_s(String nl_des_s) {
		this.nl_des_s = nl_des_s;
	}
	public String getPj_name() {
		return pj_name;
	}
	public void setPj_name(String pj_name) {
		this.pj_name = pj_name;
	}
	public String getPj_hint() {
		return pj_hint;
	}
	public void setPj_hint(String pj_hint) {
		this.pj_hint = pj_hint;
	}
	public String getPj_des() {
		return pj_des;
	}
	public void setPj_des(String pj_des) {
		this.pj_des = pj_des;
	}
	public String getPj_des_s() {
		return pj_des_s;
	}
	public void setPj_des_s(String pj_des_s) {
		this.pj_des_s = pj_des_s;
	}
	public String getPk_name() {
		return pk_name;
	}
	public void setPk_name(String pk_name) {
		this.pk_name = pk_name;
	}
	public String getPk_hint() {
		return pk_hint;
	}
	public void setPk_hint(String pk_hint) {
		this.pk_hint = pk_hint;
	}
	public String getPk_des() {
		return pk_des;
	}
	public void setPk_des(String pk_des) {
		this.pk_des = pk_des;
	}
	public String getPk_des_s() {
		return pk_des_s;
	}
	public void setPk_des_s(String pk_des_s) {
		this.pk_des_s = pk_des_s;
	}
	public String getPl_name() {
		return pl_name;
	}
	public void setPl_name(String pl_name) {
		this.pl_name = pl_name;
	}
	public String getPl_hint() {
		return pl_hint;
	}
	public void setPl_hint(String pl_hint) {
		this.pl_hint = pl_hint;
	}
	public String getPl_des_s() {
		return pl_des_s;
	}
	public void setPl_des_s(String pl_des_s) {
		this.pl_des_s = pl_des_s;
	}
	public String getPp_name() {
		return pp_name;
	}
	public void setPp_name(String pp_name) {
		this.pp_name = pp_name;
	}
	public String getPp_hint() {
		return pp_hint;
	}
	public void setPp_hint(String pp_hint) {
		this.pp_hint = pp_hint;
	}
	public String getPp_des() {
		return pp_des;
	}
	public void setPp_des(String pp_des) {
		this.pp_des = pp_des;
	}
	public String getPp_des_s() {
		return pp_des_s;
	}
	public void setPp_des_s(String pp_des_s) {
		this.pp_des_s = pp_des_s;
	}
	public String getPt_name() {
		return pt_name;
	}
	public void setPt_name(String pt_name) {
		this.pt_name = pt_name;
	}
	public String getPt_hint() {
		return pt_hint;
	}
	public void setPt_hint(String pt_hint) {
		this.pt_hint = pt_hint;
	}
	public String getPt_des() {
		return pt_des;
	}
	public void setPt_des(String pt_des) {
		this.pt_des = pt_des;
	}
	public String getPt_des_s() {
		return pt_des_s;
	}
	public void setPt_des_s(String pt_des_s) {
		this.pt_des_s = pt_des_s;
	}
	public String getSg_name() {
		return sg_name;
	}
	public void setSg_name(String sg_name) {
		this.sg_name = sg_name;
	}
	public String getSg_hint() {
		return sg_hint;
	}
	public void setSg_hint(String sg_hint) {
		this.sg_hint = sg_hint;
	}
	public String getSg_des() {
		return sg_des;
	}
	public void setSg_des(String sg_des) {
		this.sg_des = sg_des;
	}
	public String getSg_des_s() {
		return sg_des_s;
	}
	public void setSg_des_s(String sg_des_s) {
		this.sg_des_s = sg_des_s;
	}
	public String getTr_name() {
		return tr_name;
	}
	public void setTr_name(String tr_name) {
		this.tr_name = tr_name;
	}
	public String getTr_hint() {
		return tr_hint;
	}
	public void setTr_hint(String tr_hint) {
		this.tr_hint = tr_hint;
	}
	public String getTr_des() {
		return tr_des;
	}
	public void setTr_des(String tr_des) {
		this.tr_des = tr_des;
	}
	public String getTr_des_s() {
		return tr_des_s;
	}
	public void setTr_des_s(String tr_des_s) {
		this.tr_des_s = tr_des_s;
	}
	public String getUv_name() {
		return uv_name;
	}
	public void setUv_name(String uv_name) {
		this.uv_name = uv_name;
	}
	public String getUv_hint() {
		return uv_hint;
	}
	public void setUv_hint(String uv_hint) {
		this.uv_hint = uv_hint;
	}
	public String getUv_des() {
		return uv_des;
	}
	public void setUv_des(String uv_des) {
		this.uv_des = uv_des;
	}
	public String getUv_des_s() {
		return uv_des_s;
	}
	public void setUv_des_s(String uv_des_s) {
		this.uv_des_s = uv_des_s;
	}
	public String getXc_name() {
		return xc_name;
	}
	public void setXc_name(String xc_name) {
		this.xc_name = xc_name;
	}
	public String getXc_hint() {
		return xc_hint;
	}
	public void setXc_hint(String xc_hint) {
		this.xc_hint = xc_hint;
	}
	public String getXc_des() {
		return xc_des;
	}
	public void setXc_des(String xc_des) {
		this.xc_des = xc_des;
	}
	public String getXc_des_s() {
		return xc_des_s;
	}
	public void setXc_des_s(String xc_des_s) {
		this.xc_des_s = xc_des_s;
	}
	public String getXq_name() {
		return xq_name;
	}
	public void setXq_name(String xq_name) {
		this.xq_name = xq_name;
	}
	public String getXq_hint() {
		return xq_hint;
	}
	public void setXq_hint(String xq_hint) {
		this.xq_hint = xq_hint;
	}
	public String getXq_des() {
		return xq_des;
	}
	public void setXq_des(String xq_des) {
		this.xq_des = xq_des;
	}
	public String getXq_des_s() {
		return xq_des_s;
	}
	public void setXq_des_s(String xq_des_s) {
		this.xq_des_s = xq_des_s;
	}
	public String getYd_name() {
		return yd_name;
	}
	public void setYd_name(String yd_name) {
		this.yd_name = yd_name;
	}
	public String getYd_hint() {
		return yd_hint;
	}
	public void setYd_hint(String yd_hint) {
		this.yd_hint = yd_hint;
	}
	public String getYd_des() {
		return yd_des;
	}
	public void setYd_des(String yd_des) {
		this.yd_des = yd_des;
	}
	public String getYd_des_s() {
		return yd_des_s;
	}
	public void setYd_des_s(String yd_des_s) {
		this.yd_des_s = yd_des_s;
	}
	public String getYh_name() {
		return yh_name;
	}
	public void setYh_name(String yh_name) {
		this.yh_name = yh_name;
	}
	public String getYh_hint() {
		return yh_hint;
	}
	public void setYh_hint(String yh_hint) {
		this.yh_hint = yh_hint;
	}
	public String getYh_des() {
		return yh_des;
	}
	public void setYh_des(String yh_des) {
		this.yh_des = yh_des;
	}
	public String getYh_des_s() {
		return yh_des_s;
	}
	public void setYh_des_s(String yh_des_s) {
		this.yh_des_s = yh_des_s;
	}
	public String getYs_name() {
		return ys_name;
	}
	public void setYs_name(String ys_name) {
		this.ys_name = ys_name;
	}
	public String getYs_hint() {
		return ys_hint;
	}
	public void setYs_hint(String ys_hint) {
		this.ys_hint = ys_hint;
	}
	public String getYs_des() {
		return ys_des;
	}
	public void setYs_des(String ys_des) {
		this.ys_des = ys_des;
	}
	public String getYs_des_s() {
		return ys_des_s;
	}
	public void setYs_des_s(String ys_des_s) {
		this.ys_des_s = ys_des_s;
	}
	public String getZs_name() {
		return zs_name;
	}
	public void setZs_name(String zs_name) {
		this.zs_name = zs_name;
	}
	public String getZs_hint() {
		return zs_hint;
	}
	public void setZs_hint(String zs_hint) {
		this.zs_hint = zs_hint;
	}
	public String getZs_des() {
		return zs_des;
	}
	public void setZs_des(String zs_des) {
		this.zs_des = zs_des;
	}
	public String getZs_des_s() {
		return zs_des_s;
	}
	public void setZs_des_s(String zs_des_s) {
		this.zs_des_s = zs_des_s;
	}
	public String getPl_des() {
		return pl_des;
	}
	public void setPl_des(String pl_des) {
		this.pl_des = pl_des;
	}
}
