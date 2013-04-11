<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<meta http-equiv="Pragma" content="no-cache" />
		<meta http-equiv="Expires" content="-1" />
		<meta http-equiv="Cache-Control" content="no-cache" />
		<title>广州电子口岸</title>
		<%String root=request.getContextPath();%>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" type="text/css">
		<style type="text/css">
		.main .s3{float:left; padding:0px 0 0 2px;}
		.main .s3 input{height:22px; width:48px; background:url(<%=root%>/images/login/input_bg.gif) 0px 0 no-repeat; border:0; padding:2px 0 0; font-size:12px;}
		.main .s4 input{height:22px; width:60px; background:url(<%=root%>/images/login/input_bg.gif) 0px 0 no-repeat; border:0; padding:2px 0 0; font-size:12px;}
		</style>
	<script type="text/javascript">	
	function Index_onsubmit2(){

			var userPassWD =  document.fm2.pwd.value ;
			//alert(userPassWD);
			caocx.userPWD = userPassWD;// userPassWD为用户输入的密码
			caocx.verifyPassWD();	//验证密码
			 result=caocx.nResult;
			if(result!=0){
				 errmsg=caocx.strResult;
				 caocx.CloseCpuCard(); //关闭卡
			 	  alert("验证不成功！"+errmsg);//验证密码失败，弹出错误信息
				if(event.keyCode == 13) {
		           return false();
		        }
		        return false;
			}
	      	caocx.getItemUserInfo();//获取卡的信息
	      	result=caocx.nResult;
	      	if(result!=0){
				 errmsg=caocx.strResult;
				 caocx.CloseCpuCard(); //关闭卡
			 	  alert("获取卡信息出错！"+errmsg);//验证密码失败，弹出错误信息
				
			if(event.keyCode == 13) {
		        return false();
		        }  
		        return false;
			}
		//	alert("result="+result);
			var UserInfo=caocx.multiUserCertInfo;// 获取信息至UserInfo
			//alert("userInfo="+UserInfo);
			document.fm2.certThumbPrint.value = UserInfo;
			document.fm2.username.value = userPassWD;
			document.fm2.password.value = userPassWD;
			//alert(UserInfo);
			caocx.CloseCpuCard(); //关闭卡
		  	fm2.submit();
	
	}
	</script>
		
	</head>
	<body>
	<div id="loginPage">
 	<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
   	  <tr>
      	<td align="center" valign="middle">
	<br>
        <table width="500" border="0" cellpadding="0" cellspacing="0" class="login_area">
          <tr>
            <td height="57" colspan="3" class="section_loginbar"><table width="100%" border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td width="202" height="14"><img src="${pageContext.request.contextPath}/images/login/1x1.gif"></td>
                <td width="274"><img src="${pageContext.request.contextPath}/images/login/1x1.gif"></td>
                <td width="16"><img src="${pageContext.request.contextPath}/images/login/icon_titleClose.gif" style="cursor:hand" align="right" onClick="window.close();"></td>
              </tr>
              <tr>
                <td><img src="${pageContext.request.contextPath}/images/login/1x1.gif"></td>
                <td class="section_loginbarname">&nbsp;</td>
                <td><img src="${pageContext.request.contextPath}/images/login/1x1.gif"></td>
              </tr>
              <tr>
                <td><img src="${pageContext.request.contextPath}/images/login/1x1.gif"></td>
                <td class="section_loginbarip"><table border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td class="section_loginbarip"><div id='clientIpLayer'></div></td>
                    <td class="section_loginbarip"><div>版本: 3.0</div></td>
                  </tr>
                </table></td>
                <td><img src="${pageContext.request.contextPath}/images/login/1x1.gif"></td>
              </tr>
            </table></td>
          </tr>
          <tr>
            <td colspan="3"><object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="lib/swflash.cab#version=7,0,19,0" width="500" height="254">
              <param name="movie" value="${pageContext.request.contextPath}/images/login/login_dianzi.swf">
              <param name="quality" value="high">
              <param name="wmode" value="transparent">
              <embed src="${pageContext.request.contextPath}/images/login/login_dianzi.swf" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="500" height="254"></embed>
            </object></td>
          </tr>
          
          <form:form method="post" id="fm1" name="fm1" cssClass="fm-v clearfix" commandName="${commandName}" htmlEscape="true">
          <tr class="form_bar">
          <td colspan="3">
		  <table border="0" cellpadding=0 cellspacing=0 align=center class='announce' id=announce>
				<tr><td class='announce_content'>
				<form:errors path="*" id="msg" element="div"/>
				</td>
				</tr></table>
          </td>
          </tr>
          
     
		  
          <tr class="form_bar" id="normalLogin">
            <td valign="top"><!-- start to show configuration -->
              <!-- end to show configuration --></td>
            <td width="350" height="60"><table border="0" cellspacing="0">
              <tr>
                <td  width="40"><div align="right"></div></td>
                <td  nowrap><div align="right">用户名：</div></td>
				<td  width="5"><div align="right"></div></td>
                <td><div align="right">
                 <input id="username" name="username" class="required" tabindex="1" type="text" value="" size="16" autocomplete="false"/> </div></td>
                <td width="160">
                <div align="right">
                  <table border="0" cellspacing="0">
                    <tr>
                            <td nowrap><div align="justify">密 码：</div></td>
							<td  width="5"><div align="right"></div></td>
                            <td>               
                              <div align="left">
                                <input id="password" name="password" class="required" tabindex="2" type="password" value="" size="16" autocomplete="off"/>
                   			 </div></td>
							  
                          </tr>
                  </table>
                </div></td>
                </tr>
            </table></td>
            <td width="140">
            <div class="main" align="left">
            	<div class="s3" >
            		<input type="hidden" name="lt" value="${loginTicket}" />
					<input type="hidden" name="execution" value="${flowExecutionKey}" />
					<input type="hidden" name="_eventId" value="submit" />
						
		           	<input class="btn-submit" name="submit" accesskey="l" value="登 录" tabindex="4" type="submit" />&nbsp;
	            </div>
<!--            	<div>-->
<!--            		<input class="btn-reset" name="reset" accesskey="c" value="重 置" tabindex="5" type="reset" />-->
<!--	            </div>-->
	           <div class="s4">
		            <input onClick="document.getElementById('normalLogin').style.display='none';
		            				document.getElementById('cerLogin').style.display='';
		            	  " type="button" value="证书登录" />            	
	            </div>	 	            
	        </div>
          </tr>
          </form:form> 
      
      
        
          <form:form method="post" id="fm2" name="fm2" cssClass="fm-v clearfix" commandName="${commandName}" htmlEscape="true">
          <tr class="form_bar">
          <td colspan="3">
<!--		  <table border="0" cellpadding=0 cellspacing=0 align=center class='announce' id=announce>-->
<!--				<tr><td>-->
<!--				<form:errors path="*" id="msg" cssClass="errors" element="div" />-->
<!--				</td>-->
<!--				</tr></table>-->
          </td>
          </tr>    
		 <tr class="form_bar" id="cerLogin" style="display:'none'"> 
<!--            <html:hidden property="certThumbPrint" value="1333" />   -->
		<input type="hidden"  name="certThumbPrint" value="1333"/>
            <td valign="top"></td>
            <td width="350" height="60"><table border="0" cellspacing="0">
              <tr>
                <td  width="140"></td>
                <td width="260">
                <div align="right">
                  <table border="0" cellspacing="0">
                    <tr>
                          <td ><div align="justify" >证书密码:</div></td>
						  <td width="5"><div align="right"></div></td>
                          <td>               
                            <div align="left">
                            <input type="hidden" name="lt" value="${loginTicket}" />
							<input type="hidden" name="execution" value="${flowExecutionKey}" />
							<input type="hidden" name="_eventId" value="submit" />
                            <input type="hidden"  name="username" value=""/>
                            <input type="hidden"  name="password" value=""/>
<!--                         	  <html:password property="pwd" styleClass="textfield" maxlength="22" redisplay="false" size="22" onkeydown="onKeyCa()"/>-->
                           <input id="pwd" name="pwd" class="required" tabindex="1" type="password" value="" maxlength="22" size="22" autocomplete="off" onkeydown="onKeyCa()"/>
                            </div>
                          </td>
                    </tr>
                  </table>
                </div></td>
                </tr>
            </table></td>
            <td width="140">
            <div class="main" align="left">
            	<div class="s4">
		            <input onclick="javascript:Index_onsubmit2();" type="button" value="证书登录" />
		            <input onclick="document.getElementById('normalLogin').style.display='';
		            				document.getElementById('cerLogin').style.display='none';
		            	  " type="button" value="返回" />
	            </div>         
	        </div>
          </tr>  
		  </form:form>
        </table>

        <!-- <br><a href="userguide.rar">运抵报告系统用户指南[下载]</a>   <a href="arrivalDoc.rar">运抵报告报文格式[下载]</a> -->
        
      </td>
    </tr>

  </table>
</div>
<script type="text/javascript">	
function doReset()
{
    document.fm1.reset();
    document.fm1.username.focus();
}
//function changeImage(){
  //  var image = document.getElementById("code"); 
  //  now = new Date(); 
  //  image.src="random.jsp?code="+now.getTime();
//}
function onKey()
{
	if(event.keyCode == 13) {
		return doSubmit();
		}
}
function onKeyCa()
{
	if(event.keyCode==13) {
		//Index_onsubmit();
		Index_onsubmit2();
	}
}
function doSubmit()
{
	if(!isNotNull(document.fm1.username.value, "用户名"))
	{
		document.userForm.username.focus();
		return false;
	}
	
	if(!isNotNull(document.fm1.password.value, "密码"))
	{
		document.fm1.password.focus();
		return false;
	}
	
	//if(!isNotNull(document.userForm.random.value, "验证码"))
	//{
		//document.userForm.random.focus();
		//return false;
//	}
	
	document.fm1.submit();
}

function isNotNull(inputStr,description) {
    if (inputStr==null)
        {
       if ( (description!=null) && (description.length>0) )
            alert(description+"不许为空!");
       return false;
        }

    for (;inputStr.substring(0,1)==" ";)
    {
         inputStr=inputStr.substring(1,inputStr.length);
    }
    for (;inputStr.substring(inputStr.length-1,inputStr.length)==" ";)
    {
          inputStr=inputStr.substring(0,inputStr.length-1);
    }

    if (   (inputStr!=null) && ( inputStr.length > 0 )) {
            return true;
       }
    else
    {
       if ( (description!=null) && (description.length>0) )
            alert(description+"不许为空!");
       return false;
     }
}
</script>
		<OBJECT id="caocx" style="LEFT: 0px; VISIBILITY: hidden; TOP: 0px" height="14" width="14"
			border="0" classid="clsid:16F2448E-8C16-11D1-9A11-0080C8E1561F" VIEWASTEXT>
			<PARAM NAME="_Version" VALUE="65536">
			<PARAM NAME="_ExtentX" VALUE="370">
			<PARAM NAME="_ExtentY" VALUE="370">
			<PARAM NAME="_StockProps" VALUE="0">
		</OBJECT>
    </body>
</html>
