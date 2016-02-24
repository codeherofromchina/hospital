<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>doctor.jsp</title>
<link href="web/res/tp10/color2/css/news.css" rel="stylesheet" type="text/css" />
<link href="web/res/tp10/color2/css/basic.css" rel="stylesheet" type="text/css" />
<link href="http://code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<style type="text/css">
	.sch-doctors-wrap{padding-left:20px;}
	.sch-doctors-wrap .tit{ font-size:16px; margin:15px 0;}
	.sch-doctors-bd a.name{ color:#006ab3;}
	.sch-doctors-bd a.name:hover{ color:#f60;}
	.sch-doctors-wrap .typo_gray{ color:#999;}
	.sch-doctors-wrap{ line-height:20px;}
	.sch-doctors-bd li{ border-bottom:1px dotted #ddd; padding:15px 0;}
	.sch-doctors-bd .last-li{ border-bottom:none;}
	.sch-doctors-l{ float:left; width:300px; margin-right:15px;}
	.sch-doctors-r{ float:left; width:388px; background:#f7f7f7;}
	.fl{ float:left}
	.fr{ float:right}
	.schedule-timetable-hd {height: 56px;background-color: #51d5e1;}
	.schedule-timetable-hd-pager {height: 24px;margin: 16px 0;text-align: center;width: 29px;}
	.icon-page-prev_small_on,.icon-page-next_small_on {width:24px; height:24px; display:inline-block; background:url(res/tp10/color1/images/news-icon.png) no-repeat;background-position: left -504px; cursor:pointer}
	.icon-page-next_small_on{background-position: left -476px;}
	.schedule-timetable-date {color: #333;cursor: default;display: block;font-size: 12px;line-height: 21px;height: 42px;margin: 7px 1px;text-align: center;width: 45px;_display: inline;}
	.schedule-timetable-date_holiday {border-radius: 3px;background-color: #28C1D1; color:#fff;}
	.schedule-timetable-time {background-color: #dff2f5;color: #00aec1;height: 47px;line-height: 21px;text-align: center; width:29px;}
    .schedule-timetable-order {background-color: #eefad7;border: 1px solid #eefad7;color: #59aa21;display: block;font-size: 12px;
    height: 45px;line-height: 20px;margin-right: 1px;text-align: center;width: 44px;}
    .schedule-timetable-order:hover{ background:#59aa21; color:#fff;}
	.schedule-timetable-row{ overflow:hidden; padding-bottom:2px;}
	.allday-order{ border-bottom:1px solid #eee; margin-top:11px;}
	.first-allday{ margin-top:0;}
	
</style>
<script type="text/javascript">
$(function(){
	todayStr(2014,1,19);
	
	
	 $( "#dialog-form" ).dialog({
		 autoOpen: false,
		 height: 300,
		 width: 350,
		 modal: true,
		 buttons:{
			 "预约":function(){
				var yyId =  $("#yuyueID").val();
				 var name = $("#name").val();
				 if(name == ""){
					 alert("用户名称不能为空");
					 return ;
				 }
				 var tel = $("#tel").val();
				 if(tel == ""){
					 alert("电话号码不能为空");
					 return ;
				 }
				 var myreg = /^(((13[0-9]{1})|159|153)+\d{8})$/;
				 if (!myreg.test(tel)){
					 alert("电话号码填写不正确");
					 return;
				 }
				 var userId = $("#Uid").val();
				 if(userId == ""){
					 alert("身份证号不能为空");
					 return ;
				 }
				 var reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/; 
				 if (!reg.test(userId)){
					 alert("身份证号填写不正确");
					 return;
				 }
				 var sex = $("#sex").val();
				 
				 
				 
				 $.post("hospital/user!addUser.action",{'user.name':name,"user.sex":sex,"user.identity":userId,"user.tel":tel,"yyid":yyId},function(data){
					 $("#dialog-form").dialog("close");
					 if(data.success){
						 alert("预约成功");
					 }else{
						 alert(data.message);
					 }
				 },"json");
			 },
			 "取消":function(){
				 $(this).dialog("close");
			 }
		 },
		 close: function() {
			$("#userForm")[0].reset();
		}
	 });
});
function todayStr(year,month,day){
  var days=["周日","周一","周二","周三","周四","周五","周六"];
  var today=new Date();
  today.setYear(year);
  today.setMonth(month-1);
  today.setDate(day);
  var str = "";
  for(var i=0;i<7;i++){
  	today.setDate(today.getDate()+1);
  	if(today.getDay()==0 || today.getDay()==6){
  		str += "<div class='schedule-timetable-date schedule-timetable-date_holiday fl'>"+(today.getMonth()+1) + "-" + today.getDate()+"<br>"+days[today.getDay()]+"</div>"
  	}else{
  		str += "<div class='schedule-timetable-date  fl'>"+(today.getMonth()+1) + "-" + today.getDate()+"<br>"+days[today.getDay()]+"</div>"
  	}
  }
  $("#fl_copy_date").append(str);
 }
 function yuyuan(id){
	 $("#yuyueID").val(id);
	 $( "#dialog-form" ).dialog( "open" );
 }
</script>
 </head>
  
  <body>
 <div class="header">
	<div class="head">
            <div class="icons">
                <table cellpadding="0" cellspacing="0" width="100%">
                    <tr align="right">
                    	<td align="left" ><img src="web/res/tp10/color2/images/logo.jpg"/></td>
                    	<td align="center" "><img src="web/res/tp10/color2/images/logo2.png"/></td>
                        <td><table>
                            <tr>
                        		<td class="tel" align="right">河北省石家庄市</td>
                            </tr>
                        </table></td>
                    </tr>
                </table>
            </div>
            <div class="cb_10"></div>
            <div class="menu_wrap">
         	   <ul>
                        <li class="menu_index"><a href="#"><img src="web/res/tp10/color2/images/001.png"/></a><span class="xian"></span></li>
                        <li>
                        	<p><a href="#">名医预约</a><span class="xian"></span></p>
                       </li>
                        <li >
                        	<a href="#">名科预约</a><span class="xian"></span>
                        </li>
                        <li>
                        	<p><a href="#">诊断预约</a><span class="xian"></span></p>
                       </li>
                        <li><a href="#">预约公告</a><span class="xian"></span></li>
        	   </ul>
               <form class="sear">
               			<p>
                    	<input name="" type="text" value="搜索"  class="sear_text" onclick="this.value='';focus()"/>
                        <input name="" type="button" class="sear_btn" />
                        </p>
               </form>
            </div>
          
            
    </div>
</div>

<div class="cb_10"></div>
<div class="main_wrap">
	<div class="mainL">
    	<div class="mainL_wrap">
        	<div class="mainL_t">预约提示</div>
            <ul class="content">
            	<li class="cur"><a href="#">
 
 1. 网上预约挂号采用实名制，可预约 7天内（不含当天）出诊专家号。</br>
 2. 必须填写就诊患者的真实姓名,就诊患者的真实身份证号,并在就诊时携带患者身份证原件,否则您将无法在门诊窗口取号。</br>
 3. 每位专家限约一个号，当天16：00以后停止预约次日号。</br>
 4. 网上预约挂号不收取手续费。</br>
 5. 专家门诊资源有限，如预约成功后因故确定不能按时就诊，请务必于就诊日前一天15：00前及时取消预约，否则按违约处理，累计三次，您将无法进行预约。</br>

</a></li>	
               
                
            </ul>
        </div>
        <div class="cb_10"></div>
        <!--<div class="mainL_wrap_wrap">
            <div class="mainL_wrap">
                <div class="mainL_t">联系我们</div>
                <div class="content">
                   <p class="icon_1">河北省石家庄市</p>
                   <p class="icon_2">0311-888888</p>
                   <p class="icon_3">0311-888888</p>
                   <p class="icon_4">李先生</p>
                   <div class="cb_10"></div>
                  <div style="padding-left:5px;">
                    <table cellpadding="0" cellspacing="0" width="100%">
                      <tr>
                        <td align="left" vlign="middle"><a target="_blank" href="#"><img src="web/res/tp10/color2/images/qq.gif"/></a></td>
                        <td align="left" vlign="middle" style="padding-left:5px;line-height:16px;"><a href="#" style="text-decoration:none;">Mr. 刘(技术支持)</a></td>
                      </tr>
                     </table>
					</div>
                </div>
            </div>
        </div>-->
    </div>
    <div class="mainR">
    	<div class="r_t">
        	<span>新闻资讯</span><div class="r_t_r">当前位置： 网站首页 > <h1><a href="#">新闻资讯</a></h1></div>
        </div>
        <div class="cb_10"></div>
        <div class="news_wrap_s">
        	<div class="cb_20"></div>
        	<div class="sch-doctors-wrap">
            	<div class="sch-doctors-l">
                	<h4 class="tit">专家介绍</h4>
                	<ul class="sch-doctors-bd">
                	<c:forEach items="${doc}" var="d" varStatus="index">
						<li>
                        	<table cellpadding="0" cellspacing="0" width="100%">
                            	<tr>
                                	<td align="center" valign="top"><a href="#"><img src="/static/v2/style/global/m_1.jpg" width="48" height="58"></a></td>
                                    <td align="left" valign="top" style="padding-left:10px;">
                                    	<a href="#" class="name">${d.name }</a><br />
                                        <span class="typo_gray">主任医师</span><br />
                                        <p class="doctor-d"><span class="typo_gray">擅长：</span>擅长妇科内镜诊疗技术，在妇科内分泌疾病、不孕症及宫...</p>
                                    </td>
                                </tr>
                            </table>
                        </li> 
                     </c:forEach>
                    </ul>
                </div>
                <div class="sch-doctors-r">
                	<div class="date-wrap">
                    	<div class="schedule-timetable-hd layout">
                            <div class="schedule-timetable-hd-pager fl">
                                <i class="icon-page-prev_small_on" ></i>
                            </div>
                            <div class="fl_copy_date" id="fl_copy_date">
                            </div>
                            <div class="schedule-timetable-hd-pager fl">
                                <i class="icon-page-next_small_on"></i>
                            </div>
                        </div>
                    </div>
                    <c:forEach items="${doc }" var="doctor" varStatus="index">
	                    <div class='allday-order<c:if test="${index.index==0 }"> first-allday</c:if>'>
                    		<c:forEach items="${doctor.haoYuan }" var="hy" varStatus="status">
	                    		<c:if test="${status.count==1 }">
	                    			<div class="schedule-timetable-row  layout" style="">
                        			<div class="schedule-timetable-time fl patch-float-margin">上<br>午</div>
	                    		</c:if>
                    			<c:if test="${empty hy }">
                    				<!-- <a class="schedule-timetable-order_null fl">d</a> -->
                    				<a class="schedule-timetable-order fl _login_tips_"></a>
                    			</c:if>
                    			<c:if test="${!empty hy }">
                    				<a class="schedule-timetable-order fl _login_tips_"  href="javascript:void(0);" onclick="yuyuan('${hy.id }')"><br/>预约<br/>挂号</a>
                    			</c:if>
                    			<c:if test="${status.count==7 }">
	                    			<div class="schedule-timetable-time fr">上<br/>午</div>
			                       </div>
			                       <div style=" clear:both"></div>
			                        <div class="schedule-timetable-row  layout" style="">
			                        <div class="schedule-timetable-time fl patch-float-margin">下<br/>午</div>
	                    		</c:if>
	                    		<c:if test="${status.count==14 || status.end}">
	                    			<div class="schedule-timetable-time fr">下<br/>午</div>
                      				 </div>
	                    		</c:if>
                    		</c:forEach>
                    	</div>
                    </c:forEach>
                </div>
            </div>
</div>



<div class="cb_15"></div>
<div class="footer">
	<div class="footer_menu">
    	<a href="#" style="float:left;margin-left:55px;"><strong>返回首页</strong></a><a href="#">企业简介</a><a href="#">联系我们</a>
    </div>
 
    <div class="cb_15"></div>
	<div class="foot_content">
    	 预约挂号统一管理平台 http://www.yueyugh.cn<br/>
			  
    </div>
</div>

    <div class="cb_15"></div>
<div>
	<a href="#" class="fanhui" >返回顶部</a>
</div>

<div id="dialog-form" title="填写信息">
<p class="validateTips">全部字段不能为空！</p>
<form id="userForm">
	<fieldset>
		<input type="hidden" id="yuyueID" value=""/>
		<table>
			<tr>
				<td><label for="name">姓名:</label></td>
				<td><input type="text" id="name" class="text ui-widget-content ui-corner-all"/></td>
			</tr>
			<tr>
				<td><label for="sex">性别:</label></td>
				<td><select id="sex"><option value="1">男</option><option value="2">女</option></select></td>
			</tr>
			<tr>
				<td><label for="id">身份证:</label></td>
				<td><input type="text" id="Uid" class="text ui-widget-content ui-corner-all"/></td>
			</tr>
			<tr>
				<td><label for="tel">电话:</label></td>
				<td><input type="text" id="tel" class="text ui-widget-content ui-corner-all"/></td>
			</tr>
		</table>
	</fieldset>
</form>
</div>
  </body>
</html>
