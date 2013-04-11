<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.gzeport.portal.to.User" %>
<%@ page import="com.gzeport.portal.to.FuncModel" %>
<jsp:directive.include file="includes/top.jsp" />
			<%User user =null; %>
			<%if(request.getSession().getAttribute("LOGIN_USER")!=null){
				user = (User) request.getSession().getAttribute("LOGIN_USER");
			  }
			ArrayList funcSysList =(ArrayList)request.getSession().getAttribute("LOGIN_USER_SYSTEM");
			%>
		<div id="msg" class="success">
			<h2><% if(user!=null) { out.write(user.getUserCode());}%>
			<spring:message code="screen.success.header" /></h2>
			<p><spring:message code="screen.success.success" /></p>
			<p><spring:message code="screen.success.security" /></p>
			<a href="<%=request.getContextPath()%>/logout">logOut casServer system</a> 
		
			<%
			if(funcSysList!=null &&funcSysList.size()>0){
	
				for (int i=0;i<funcSysList.size();i++){
						FuncModel funcMOdel =(FuncModel)funcSysList.get(i);%>
				<p><a><%=funcMOdel.getFuncId() +"|" +funcMOdel.getFuncName() %></a> </p>				
				<%}
			}
			%>
			
			
			
		</div>
		
<jsp:directive.include file="includes/bottom.jsp" />

