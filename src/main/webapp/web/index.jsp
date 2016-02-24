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
    <title>My JSP 'index.jsp' starting page</title>
<link href="web/res/tp10/color2/css/index.css" rel="stylesheet" type="text/css" />
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
	<div class="main_wrapL">
        <div class="content_wrap1">
        	<div class="wrap1_bg_t">
            	<span>名院介绍</span>	<a href="#"><img src="web/res/tp10/color2/images/009.png"/></a>
            </div>
        	<div class="wrap1_detail">
            	<div class="detail_left">
                	<div class="pic_box">
                    	<table cellpadding="0" cellspacing="0" width="250" height="160">
                        	<tr>
                        	  <td style="text-align:center;" valign="middle"><img src="web/res/tp10/color2/images/hbszyy.png"/></td></tr>
                        </table>
                        <p>
                        	<a href="#"><img src="web/res/tp10/color2/images/006.gif"/></a>
                            <a href="#"><img src="web/res/tp10/color2/images/007.gif"/></a>
                            <a href="#"><img src="web/res/tp10/color2/images/007.gif"/></a>
                        </p>
                    </div>
                </div>
                <div class="detail_right">
                <p>
                   河北省中医院创建于上世纪70年代，占地面积5.3万平方米，建筑面积7.05万平方米，是一座集医疗、教学、科研、预防、急救、康复为一体的综合性“三级甲等”中医院。现有职工821人，其中高级职称230人，博士、硕士生导师61人。医院设临床医技科室42个，专科门诊54个，国家名老中医传承工作室4个，省级名老中医传承工作室1个。医院环境优美、设备精良、设施先进、综合实力雄厚。
                    <br />
                   医院先后获得“全国卫生先进集体”、“全国先进基层党组织”、省、市“文明单位” 、“河北省示范中医院” 、“ 驻省会省属高校先进基层党组织”等多项荣誉称号。
    </p>
                </div>
            </div>
            <img class="lt1" src="web/res/tp10/color2/images/yuanjiao1.gif" />
            <img class="rt2" src="web/res/tp10/color2/images/yuanjiao2.gif" />
            <img class="rb3" src="web/res/tp10/color2/images/yuanjiao3.gif" />
            <img class="lb4" src="web/res/tp10/color2/images/yuanjiao4.gif" />
    	</div>
  </div>  	
    	   <div class="main_wrapR">
    	<div class="r_wrap1">
        	<div class="wrap1_bg_t">
                 <span>最新公告</span><a href="#"><img src="web/res/tp10/color2/images/009.png"/></a>	
            </div>
            <div class="r_wrap1_detail">
                <h2><a href="#">参加医院名单</a></h2>
               <h2><a href="#"> </a></h2>
               <h2><a href="#"> </a></h2>
               <h2><a href="#"> </a></h2>
                <img class="lt1" src="web/res/tp10/color2/images/yuanjiao1.gif" />
                <img class="rt2" src="web/res/tp10/color2/images/yuanjiao2.gif" />
                <img class="rb3" src="web/res/tp10/color2/images/yuanjiao3.gif" />
                <img class="lb4" src="web/res/tp10/color2/images/yuanjiao4.gif" />
            </div>
        
    </div>
</div>

    	<div class="cb_10"></div>
        <div class="content_wrap2">
            <div class="wrap1_bg_t">
                        <span>医院介绍</span>	
                        <div class="qiehuan">
                            <a href="#" class="prev"></a>
                            <a href="#" class="next"></a>
                            
                        </div>
                        <ul class="pagination">
                           <li class="current"><a href="#0"> 1 </a></li>
                           <li class="cur"><a href="#1"> 2 </a></li>
                        </ul>
                    </div>
            <div class="pro_wrap">
            	<c:forEach items="${hos}" var="h" varStatus="index">
            		<div class="pro">
                         <table cellpadding="0" cellspacing="0" width="100%" height="100%">
                             <tr><td valign="middle" class="pro_detail"><a href="hospital/dept!deptAction.action"><img src="web/res/tp10/color2/images/010.gif"/></a></td></tr>
                             <tr><td style="height:10px;"></td></tr>
                             <tr><td align="center" valign="middle"><h2><a href="hospital/dept!deptAction.action?hosId=${h.id }">${h.name }</a></h2></td></tr>  
                         </table>
                     </div>
                     <c:if test="${index.count%3==0}">
                     	<div class="cb_20"></div>
                     </c:if>
			   </c:forEach>
                        
                      
                        
                    </div>
            <img class="lt1" src="web/res/tp10/color2/images/yuanjiao1.gif" />
            <img class="rt2" src="web/res/tp10/color2/images/yuanjiao2.gif" />
            <img class="rb3" src="web/res/tp10/color2/images/yuanjiao3.gif" />
            <img class="lb4" src="web/res/tp10/color2/images/yuanjiao4.gif" />
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
  </body>
</html>
