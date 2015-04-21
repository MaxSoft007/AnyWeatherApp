package org.maxsoft.weather;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.maxsoft.biz.WeatherCityBiz;
import org.maxsoft.custom.listener.AddCityOnClickListener;
import org.maxsoft.db.DBManager;
import org.maxsoft.util.City;
import org.maxsoft.util.DateUtils;
import org.maxsoft.util.WeatherConstant;
import org.maxsoft.view.utile.ViewUtil;
import org.maxsoft.page.adapter.ViewPagerAdapter;
import org.maxsoft.rss.RSSFeed;
import org.maxsoft.rss.RSSHandler;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import android.app.Activity;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.support.v4.view.ViewPager;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.view.inputmethod.InputMethodManager;
import android.support.v4.view.ViewPager.OnPageChangeListener;

public class HomeActivity extends Activity  implements OnClickListener,OnPageChangeListener {
	// 定义ViewPager对象
	private ViewPager viewPager;
	private static final int VIEW_NUM = 4; 
	public Activity instance = null;
	private String[] cities = null;
	private WeatherCityBiz weatherCityBiz = null;
	private boolean isupdate_new = false;
	private boolean isupdate_location = false;
	private boolean isupdate_me = false;
	// 定义ViewPager适配器
	private ViewPagerAdapter vpAdapter;
	
	// 定义一个ArrayList来存放View
	private ArrayList<View> views;

	// 底部小点的图片
	private ImageView[] points;

	// 记录当前选中位置
	private int currentIndex;
	private TextView v = null;
	private ImageView img = null;
	private WebView webview;
	private View me;
	private View newl;
	private View set;
	private View location;
	private LayoutInflater la;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.manage_page);
		DBManager manager = new DBManager(this);
		cities = manager.findAllCityName();
		DBManager.close();
		instance = this;
		// 初始化组件
		initView();
		// 初始化数据
		initData();
		v = (TextView) findViewById(R.id.page_title);
		getSharedPreferences(WeatherConstant.CONFIG_NAME, Context.MODE_PRIVATE);
		v.setText("气 象 科 技");
		img = (ImageView) findViewById(R.id.web_client_back);
		onPageSelected(0);
	}

	/**
	 * 初始化组件
	 */
	private void initView() {
		// 实例化ArrayList对象
		views = new ArrayList<View>();
		//Drawable drawable = getResources().getDrawable(R.drawable.guide_selector);   
		// 实例化ViewPager
		viewPager = (ViewPager) findViewById(R.id.viewpager);
		// 实例化ViewPager适配器
		vpAdapter = new ViewPagerAdapter(views);
	}

	/**
	 * 初始化数据
	 */
	private void initData() {
		la = getLayoutInflater();
		me = la.inflate(R.layout.me,null);
		views.add(me);
		newl = la.inflate(R.layout.newl, null);
		views.add(newl);
		location = la.inflate(R.layout.location,null);
		views.add(location);
		set = la.inflate(R.layout.set,null);
		views.add(set);
		// 设置数据
		viewPager.setAdapter(vpAdapter);
		// 设置监听
		viewPager.setOnPageChangeListener(this);

		// 初始化底部小点
		initPoint();
		init_cities(set); //初始化设置程序
//		init_news(me,"http://www.cma.gov.cn/2011xwzx/2011xqxkj/2011xkjdt/default_597.xml");
	}
	
	/**
	 * @function 初始化城市自动提示列表
	 * @param view 添加城市View
	 */
	private ArrayAdapter<String> av;
	private void init_cities(final View view) {
		av = new ArrayAdapter<String>(this,R.layout.autocompletetextview_style, cities);
		final AutoCompleteTextView auto = (AutoCompleteTextView)view.findViewById(R.id.city);
		auto.setAdapter(av);
		
		ImageView add_button_bg = (ImageView)view.findViewById(R.id.add_button_name_bg);
		add_button_bg.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				weatherCityBiz = new WeatherCityBiz();
				String city = auto.getText().toString();
				boolean issuccess = weatherCityBiz.addWeatherCity(city, v); //调用业务层增加城市方法
				if(issuccess){
					City city_list = new City(view);
					String temp = "";
					TextView t_view = null;
					ArrayList<TextView> city_name_list = city_list.init_city_name();
					if(city_name_list != null){
						for (int i = 0 ; i < city_name_list.size(); i++) {
							t_view = city_name_list.get(i);
							temp = t_view.getText().toString().replaceAll(" ", "");
							city = WeatherConstant.filterCharacters(city);
							if(temp.equals(city)){
								t_view.setText(city + " √");
							}
							//更新设置列表城市
							ViewUtil.initListView(view,instance);
						}
					}
				}
			}
		});
		
		City city = new City(view);
		ArrayList<ImageView> init_city_bg = city.init_city_bg();
		ArrayList<TextView> init_city_name = city.init_city_name();
		String name = "";
		TextView name_view = null;
		for(int i=0;i<init_city_bg.size();i++){
			name_view = init_city_name.get(i);
			name = name_view.getText().toString();
			weatherCityBiz = new WeatherCityBiz();
			boolean isExists = weatherCityBiz.isExistsWeatherCity(name, name_view);
			if(isExists){
				String temp = name_view.getText().toString();
				if(!temp.contains("√")){
					name_view.setText(name + " √");
				}
			}
			init_city_bg.get(i).setOnClickListener(new AddCityOnClickListener(view,name,name_view,instance));
		}
		//更新设置列表城市
		ViewUtil.initListView(view,instance);
	}

	/**
	 * 初始化底部小点
	 */
	private void initPoint() {
		LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
		points = new ImageView[4];
		// 循环取得小点图片
		for (int i = 0; i < VIEW_NUM; i++) {
			// 得到一个LinearLayout下面的每一个子元素
			points[i] = (ImageView) linearLayout.getChildAt(i);
			// 默认都设为灰色
			points[i].setEnabled(true);
			// 给每个小点设置监听
			points[i].setOnClickListener(this);
			// 设置位置tag，方便取出与当前位置对应
			points[i].setTag(i);
		}
		// 设置当面默认的位置
		currentIndex = 0;
		// 设置为白色，即选中状态
		points[currentIndex].setEnabled(false);
	}

	/**
	 * 当滑动状态改变时调用
	 */
	int currentPageScrollStatus = 0;
	@Override
	public void onPageScrollStateChanged(int arg0) {
		currentPageScrollStatus = arg0;
	}

	/**
	 * 当当前页面被滑动时调用
	 */

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		//TODO
	}
	/**
	 * 当新的页面被选中时调用
	 */
	@Override
	public void onPageSelected(int position) {
		String url = "";
		// 设置底部小点选中状态
		switch (position) {
			case 0:
				v.setText("气 象 科 技");
				if(!isupdate_me){
					url = "http://www.cma.gov.cn/2011xwzx/2011xqxkj/2011xkjdt/default_597.xml";
					init_news(views.get(position),url);
					isupdate_me = true;
				}
				img.setVisibility(View.GONE);
				break;
			case 1:
				v.setText("天 气 快 讯");
				if(!isupdate_new){
					url = "http://www.cma.gov.cn/2011xwzx/2011xqxxw/2011xqxyw/default_597.xml";
					init_news(views.get(position),url);
					isupdate_new = true;
				}
				img.setVisibility(View.GONE);
				break;
			case 2:
				v.setText("媒 体 聚 焦");
				if(!isupdate_location){
					url = "http://www.cma.gov.cn/2011xwzx/2011xmtjj/default_597.xml";
					init_news(views.get(position),url);
					isupdate_location = true;
				}
				img.setVisibility(View.GONE);
				break;
			case 3:
				v.setText("设 置 中 心");
				View view = views.get(position);
				init_cities(view);
				ViewUtil.locationInfo(view);
				break;
			default:
				v.setText("哦，程序神经了...");
				break;
		}
		setCurDot(position);
	}
	
	public void init_news(View view,final String url) {
		webview = (WebView) view.findViewById(R.id.newwebview);
		final StringBuffer html = new StringBuffer();
		commonDisplay(html,"加载中...");
		webview.loadDataWithBaseURL("", html.toString(), "text/html", "utf-8", null);
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					RSSFeed rssFeed = null;
					URL m_url= new URL(url);
					InputStream inputStream = m_url.openStream();
					  BufferedReader bf=new BufferedReader(new InputStreamReader(inputStream,"gb2312"));  
					     StringBuffer buffer=new StringBuffer();  
					     String line="";  
					     while((line=bf.readLine())!=null){  
					         buffer.append(line);  
					     }  
					     String temp = buffer.toString().replaceAll("-", "");
					     temp = temp.replaceAll("\t","");
					     InputStream in = new ByteArrayInputStream(temp.getBytes());
					     rssFeed = getRSSFeed(in);
					     html.setLength(0);
					     html.append("<html> <body style=\"background-color: #F2F2F2;margin-top:0px;\">");
					     for(int i=0;i<rssFeed.getItemcount();i++){
					    	 html.append("<div style=\"padding-top:8px;padding-left:8px;padding-right:8px;padding-bottom:8px;border-bottom: solid 1px #E0E0E0;border-top: solid 1px #E0E0E0;border-left: solid 1px #E0E0E0;border-right: solid 1px #E0E0E0;margin-top:10px;margin-bottom:10px;background-color:#FFFFFF\">");
					    	 html.append("	<table>");
					    	 html.append("		<tr height=\"18px\">");
					    	 html.append("			<td align=\"center\">");
					    	 html.append("				<font style=\"font-size: 34px;font-weight:bold;color: #5f5f5f;\">");
					    	 html.append("					<span>" + rssFeed.getAllItem().get(i).getTitle() + "</span>");
					    	 html.append("				</font>");
					    	 html.append("			</td>");
					    	 html.append("		</tr>");
					    	 html.append("		<tr height=\"12px\">");
					    	 html.append("			<td align=\"center\" >");
					    	 html.append("				<font style=\"font-size: 24px;color: #5f5f5f;\">");
					    	 html.append("					<span>发布时间 : "+ DateUtils.formatStringToDateF(rssFeed.getAllItem().get(i).getPubdate()) +"</span>");
					    	 html.append("				</font>");
					    	 html.append("			</td>");
					    	 html.append("		</tr>");
					    	 html.append("		<tr>");
					    	 html.append("			<td>");
					    	 html.append("				<font style=\"font-size: 30px;color: #5f5f5f;\">");
					    	 html.append( rssFeed.getAllItem().get(i).getDescription().replaceAll("　　", "<br/>　　").replaceFirst("<br/>", ""));
					    	 html.append("				</font>");
					    	 html.append("				<font style=\"font-size: 24px;color: #6495ED;\">");
					    	 html.append("				<a href=\""+ rssFeed.getAllItem().get(i).getLink() +"\">查看更多&gt;&gt;</a>");
					    	 html.append("				</font>");
					    	 html.append("			</td>");
					    	 html.append("		</tr>");
					    	 html.append("	</table>");
					    	 html.append("</div>" );
					     }
					     html.append("</body> </html>");  
				} catch (MalformedURLException e) {
					html.setLength(0);
					commonDisplay(html,"额，请检查网络..." + e.getMessage());
					e.printStackTrace();
				} catch (IOException e) {
					html.setLength(0);
					commonDisplay(html,"额，请检查网络...");
					e.printStackTrace();
				} finally{
					webview.loadDataWithBaseURL(null, html.toString(), "text/html", "utf-8", null);
					WebViewClient web = new WebViewClient(){
					      @Override
					      public boolean shouldOverrideUrlLoading(final WebView view, String url) {
					        view.loadUrl(url);
					        img.setVisibility(View.VISIBLE);
					        img.setImageResource(R.drawable.webviewbackf);
					        img.setOnClickListener(new OnClickListener() {
								@Override
								public void onClick(View v) {
									if(view.canGoBack()){
										view.goBack();
									}else{
										img.setVisibility(View.GONE);
										isupdate_me = false;
										isupdate_new = false;
										isupdate_location = false;
										onPageSelected(currentIndex);
									}
								}
							});
					        return true;
					      }
					    };
					webview.setWebViewClient(web);
					webview.getSettings().setUseWideViewPort(true); 
					webview.getSettings().setLoadWithOverviewMode(true); 
				}
			}
		}).start();
	}

	public void commonDisplay(final StringBuffer html,String msg) {
		html.append("<html>");
		html.append("  <body style=\"background-color: #ececec;\">");
		html.append("   <table width=\"100%\" height=\"100%\">");
		html.append("    	<tr>");
		html.append("    		<td height=\"100%\" width=\"100%\" style=\"vertical-align: middle;text-align: center\">");
		html.append("    			<font color=\"#076ea9\">"+msg+"</font>");
		html.append("    		</td>");
		html.append("    	</tr>");
		html.append("    </table>");
		html.append("  </body>");
		html.append("</html>");
	}

	/**
	 * 通过点击事件来切换当前的页面
	 */
	@Override
	public void onClick(View v) {
		int position = (Integer) v.getTag();
		setCurView(position);
		setCurDot(position);
	}

	/**
	 * 设置当前页面的位置
	 */
	private void setCurView(int position) {
		// 排除异常情况
		if (position < 0 || position >= VIEW_NUM) {
			return;
		}
		viewPager.setCurrentItem(position);
		if(position == 3){
			View view = views.get(position);
			init_cities(view);
		}
	}

	/**
	 * 设置当前的小点的位置
	 */
	private void setCurDot(int positon) {
		// 排除异常情况
		if (positon < 0 || positon > VIEW_NUM - 1 || currentIndex == positon) {
			return;
		}
		points[positon].setEnabled(false);
		points[currentIndex].setEnabled(true);
		currentIndex = positon;
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			Toast.makeText(this, "A", Toast.LENGTH_SHORT).show();
			break;
		case MotionEvent.ACTION_UP:
			Toast.makeText(this, "B", Toast.LENGTH_SHORT).show();
			break;
		default:
			Toast.makeText(this, "C", Toast.LENGTH_SHORT).show();
			break;
		}
		return super.onTouchEvent(event);
	}
	
	@Override  
	public boolean dispatchTouchEvent(MotionEvent ev) {  
	    if (ev.getAction() == MotionEvent.ACTION_DOWN) {  
	        View v = getCurrentFocus();  
	        if (isShouldHideInput(v, ev)) {  
	            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);  
	            if (imm != null) {  
	                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);  
	            }  
	        }  
	        return super.dispatchTouchEvent(ev);  
	    } else if(ev.getAction() == MotionEvent.BUTTON_BACK) {
	    	Toast.makeText(this, "C", Toast.LENGTH_SHORT).show();
	    }
	    // 必不可少，否则所有的组件都不会有TouchEvent了  
	    if (getWindow().superDispatchTouchEvent(ev)) {  
	        return true;  
	    }  
	    return onTouchEvent(ev);  
	}  
	
	/**
	 * @function 是否要隐藏软键盘
	 * @param v 输入框View
	 * @param event 当前的触屏事件
	 * @return Boolean值  (是否隐藏软件)
	 */
	public  boolean isShouldHideInput(View v, MotionEvent event) {  
	    if (v != null && (v instanceof EditText)) {  
	        int[] leftTop = { 0, 0 };  
	        //获取输入框当前的location位置  
	        v.getLocationInWindow(leftTop);  
	        int left = leftTop[0];  
	        int top = leftTop[1];  
	        int bottom = top + v.getHeight();  
	        int right = left + v.getWidth();  
	        if (event.getX()>left && event.getX()<right && event.getY()>top && event.getY()<bottom){  
	            // 点击的是输入框区域，保留点击EditText的事件  
	            return false;  
	        } else {  
	            return true;  
	        }  
	    }  
	    return false;  
	} 
	private Intent intent;
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			intent = new Intent();
			intent.setClass(v.getContext(),WeatherActivity.class);
			v.getContext().startActivity(intent);
			v.destroyDrawingCache();
			HomeActivity.this.finish();
			return true;
		} else {
			return super.onKeyDown(keyCode, event);
		}
	}
	
	private RSSFeed getRSSFeed(InputStream inputStream){
		RSSHandler handler= null;
		SAXParserFactory factory = null;
		SAXParser parser = null;
		XMLReader reader = null;
		Reader r = null;
		InputSource inputSource = null;
		try {
			factory = SAXParserFactory.newInstance();
			parser = factory.newSAXParser();
			reader = parser.getXMLReader();
			handler = new RSSHandler();
			reader.setContentHandler(handler);
			r = new InputStreamReader(inputStream);
			inputSource = new InputSource(r);
			reader.parse(inputSource);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return handler.getFeed();
	}
}
