package org.maxsoft.pojo;

import java.io.Serializable;

/**
 * @function 生活指数信息实体，数据信息源于中国气象局。
 * 			 http://www.weather.com.cn/data/zs/101010100.html
 * @author MaxSoft
 * @date 2014-12-21
 * @version 1.0.0
 */
public class LifeIndexInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String date =""; //2014122120",
	private String ac_name =""; //空调开启指数",
	private String ac_hint =""; //开启制暖空调",
	private String ac_des =""; //您将感到有些冷，可以适当开启制暖空调调节室内温度，以免着凉感冒。",
	private String ac_des_s =""; //体感略冷，建议开启暖空调调节室温。",
		
	private String ag_name =""; //过敏指数",
	private String ag_hint =""; //极不易发",
	private String ag_des =""; //天气条件极不易诱发过敏，可放心外出，享受生活。",
	private String ag_des_s =""; //无需担心过敏，可放心外出，享受生活。",
		
	private String be_name =""; //海滨浴场",
	private String be_hint =""; //较不宜",
	private String be_des =""; //较不宜下海，今天天气晴朗，但温度很低，有风，不推荐下海游玩。",
	private String be_des_s =""; //",
		
	private String cl_name =""; //晨练指数",
	private String cl_hint =""; //适宜",
	private String cl_des =""; //天气不错，空气清新，是您晨练的大好时机，建议不同年龄段的人们积极参加户外健身活动。",
	private String cl_des_s =""; //天气不错，空气清新，是晨练的好时机。",
		
	private String co_name =""; //舒适度指数",
	private String co_hint =""; //较舒适",
	private String co_des =""; //白天虽然天气晴好，但早晚会感觉偏凉，午后舒适、宜人。",
	private String co_des_s =""; //白天晴好，早晚偏凉，午后舒适。",
		
	private String ct_name =""; //穿衣指数",
	private String ct_hint =""; //较冷",
	private String ct_des =""; //建议着厚外套加毛衣等服装。年老体弱者宜着大衣、呢外套加羊毛衫。",
	private String ct_des_s =""; //建议着厚外套加毛衣等服装。",
		
	private String dy_name =""; //钓鱼指数",
	private String dy_hint =""; //较适宜",
	private String dy_des =""; //较适合垂钓，但天气稍凉，会对垂钓产生一定的影响。",
	private String dy_des_s =""; //天气稍凉会对垂钓产生一定影响。",
		
	private String fs_name =""; //防晒指数",
	private String fs_hint =""; //较弱",
	private String fs_des =""; //紫外线强度较弱，建议涂擦SPF在12-15之间，PA+的防晒护肤品。",
	private String fs_des_s =""; //涂抹12-15SPF，PA+护肤品。",
		
	private String gj_name =""; //逛街指数",
	private String gj_hint =""; //较适宜",
	private String gj_des =""; //天气较好，较适宜逛街，不过出门前要穿暖和一点，千万别着凉了。",
	private String gj_des_s =""; //逛街要穿暖和一点避免着凉。",
		
	private String gl_name =""; //太阳镜指数",
	private String gl_hint =""; //必要",
	private String gl_des =""; //白天天气晴朗，太阳辐射较强，建议佩戴透射比1级且标注UV380-UV400的遮阳镜",
	private String gl_des_s =""; //建议佩戴透射比为1级的遮阳镜",
		
	private String gm_name =""; //感冒指数",
	private String gm_hint =""; //较易发",
	private String gm_des =""; //昼夜温差较大，较易发生感冒，请适当增减衣服。体质较弱的朋友请注意防护。",
	private String gm_des_s =""; //温差较大，较易感冒，注意防护。",
		
	private String gz_name =""; //干燥指数",
	private String gz_hint =""; //非常干燥",
	private String gz_des =""; //空气湿度低，皮肤易感觉干燥，应及时补充身体水分；预防手脚等部位皴裂，涂抹高保湿强滋润型护肤品；适当减少淋浴次数，不用过热的水洗澡。",
	private String gz_des_s =""; //",
		
	private String hc_name =""; //划船指数",
	private String hc_hint =""; //较适宜",
	private String hc_des =""; //白天较适宜划船，但气温稍低，请注意加衣，小心着凉。",
	private String hc_des_s =""; //气温低注意及时添衣，小心着凉。",
		
	private String jt_name =""; //交通指数",
	private String jt_hint =""; //良好",
	private String jt_des =""; //天气较好，路面干燥，交通气象条件良好，车辆可以正常行驶。",
	private String jt_des_s =""; //气象条件良好，车辆可以正常行驶。",
		
	private String lk_name =""; //路况指数",
	private String lk_hint =""; //干燥",
	private String lk_des =""; //天气较好，路面比较干燥，路况较好。",
	private String lk_des_s =""; //天气较好，路面较干燥，路况较好。",
		
	private String ls_name =""; //晾晒指数",
	private String ls_hint =""; //基本适宜",
	private String ls_des =""; //天气不错，午后温暖的阳光仍能满足你驱潮消霉杀菌的晾晒需求。",
	private String ls_des_s =""; //天气不错，抓紧时机让衣物晒太阳吧。",
		
	private String mf_name =""; //美发指数",
	private String mf_hint =""; //适宜",
	private String mf_des =""; //干燥的空气易带走头发的水分并产生静电，以致头发打结发涩，发质变干变脆，失去光泽，最好使用内含滋润成分的洗发露和护发素。",
	private String mf_des_s =""; //空气干燥，建议使用滋润成分的护发素。",

	private String nl_name =""; //夜生活指数",
	private String nl_hint =""; //较适宜",
	private String nl_des =""; //天气较好，虽然有点风，比较适宜夜生活，您可以放心外出。",
	private String nl_des_s =""; //只要您稍作准备就可以放心外出。",
		
	private String pj_name =""; //啤酒指数",
	private String pj_hint =""; //不适宜",
	private String pj_des =""; //寒冷的天气可能会减弱啤酒对您的诱惑，可少量饮用常温啤酒。",
	private String pj_des_s =""; //天气寒冷，可少量饮用常温啤酒。",
		
	private String pk_name =""; //放风筝指数",
	private String pk_hint =""; //不宜",
	private String pk_des =""; //天气寒冷，不适宜放风筝。",
	private String pk_des_s =""; //天气寒冷，不适宜放风筝。",
		
	private String pl_name =""; //空气污染扩散条件指数",
	private String pl_hint =""; //较差","
	private String pl_des =""; //气象条件较不利于空气污染物稀释、扩散和清除，请适当减少室外活动时间。",
	private String pl_des_s =""; //气象条件较不利于空气污染物扩散。。",
		
	private String pp_name =""; //化妆指数",
	private String pp_hint =""; //滋润保湿",
	private String pp_des =""; //天气较冷、空气干燥，用滋润保湿型化妆品，少扑粉，使用润唇膏。",
	private String pp_des_s =""; //请选用滋润保湿型化妆品。",
		
	private String pt_name =""; //环境污染防护指数",
	private String pt_hint =""; //低",
	private String pt_des =""; //白天天气晴朗，空气质量较好，无需防护",
	private String pt_des_s =""; //空气质量好，无需防护",
		
	private String sg_name =""; //一句话提示指数",
	private String sg_hint =""; //暂缺",
	private String sg_des =""; //夜间有风，但不影响出门游玩。",
	private String sg_des_s =""; //",
		
	private String tr_name =""; //旅游指数",
	private String tr_hint =""; //适宜",
	private String tr_des =""; //天气较好，气温稍低，会感觉稍微有点凉，不过也是个好天气哦。适宜旅游，可不要错过机会呦！",
	private String tr_des_s =""; //气温稍低，感觉略凉，但仍是个好天气。",
		
	private String uv_name =""; //紫外线强度指数",
	private String uv_hint =""; //弱",
	private String uv_des =""; //紫外线强度较弱，建议出门前涂擦SPF在12-15之间、PA+的防晒护肤品。",
	private String uv_des_s =""; //辐射较弱，涂擦SPF12-15、PA+护肤品。",
		
	private String xc_name =""; //洗车指数",
	private String xc_hint =""; //较适宜",
	private String xc_des =""; //较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。",
	private String xc_des_s =""; //无雨且风力较小，易保持清洁度。",
		
	private String xq_name =""; //心情指数",
	private String xq_hint =""; //较好",
	private String xq_des =""; //天气较好，柔和的阳光透过寒冷的空气给大地带来了温暖，也驱除了您身心的疲惫，让您的心情亮丽得几乎能触摸到成功与幸福的影子。",
	private String xq_des_s =""; //晴朗天气，将为您的身心带来温暖。",
		
	private String yd_name =""; //运动指数",
	private String yd_hint =""; //较适宜",
	private String yd_des =""; //天气较好，无雨水困扰，较适宜进行各种运动，但因气温较低，在户外运动请注意增减衣物。",
	private String yd_des_s =""; //气温较低，在户外运动请注意增减衣物。",
		
	private String yh_name =""; //约会指数",
	private String yh_hint =""; //适宜",
	private String yh_des =""; //天气较好，和恋人携手出游，实在是增进感情、享受浪漫的人生乐事。",
	private String yh_des_s =""; //天气较好，适宜约会。",
		
	private String ys_name =""; //雨伞指数",
	private String ys_hint =""; //不带伞",
	private String ys_des =""; //天气较好，您在出门的时候无须带雨伞。",
	private String ys_des_s =""; //天气较好，不用带雨伞。",
		
	private String zs_name =""; //中暑指数",
	private String zs_hint =""; //无",
	private String zs_des =""; //温度不高，其他各项气象条件适宜，中暑机率极低。",
	private String zs_des_s =""; //气温不高，中暑几率极低。"
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
