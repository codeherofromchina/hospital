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
    
    <title>dept.jsp</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link href="web/res/tp10/color2/css/products_list.css" rel="stylesheet" type="text/css" />
<link href="web/res/tp10/color2/css/basic.css" rel="stylesheet" type="text/css" />
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
        	<h2>科室列表</h2><div class="r_t_r">当前位置：  ><h1><a href="#">河北省中医院</a></h1></div>
        </div>
        <div class="cb_10"></div>
        <div class="big_pro_wrap">
      		<div class="cb_20"></div>
        	<c:forEach items="${dept}" var="d" varStatus="index">
	        	<div class="pro">
	                <table cellpadding="0" cellspacing="0" width="100" height="142">
	                    <tr><td valign="middle" class="pro_detail"><a href="#"><img src="web/res/tp10/color2/images/010.gif"/></a></td></tr>
	                    <tr><td style="height:10px;"></td></tr>
	                    <tr><td align="center" valign="middle"><h2><a href="hospital/doc!docAction.action?deptId=${d.id }">${d.deptName }</a></h2></td></tr>  
	                </table>
	             </div>
             </c:forEach>
            <!-- <div class="public_pages">
                    <table cellspacing="0" cellpadding="0" border="0" width="100%">
                        <tr>
                            <td>
                                <a href="#">上一页</a><a class="cur" href="">1</a><a href="#">2</a><a href="#">3</a><a href="#">4</a><a href="#">5</a><a href="#">6</a><a href="#">下一页</a>
                            </td>
                        </tr>
                    </table>
			</div>
            <div class="cb_20"></div>
         </div>-->
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
  </body>
</html>