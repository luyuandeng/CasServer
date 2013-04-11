<%@ page session="false" %><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %><cas:serviceResponse xmlns:cas='http://www.yale.edu/tp/cas'>

	
			
	<cas:authenticationSuccess>
		<cas:user>${fn:escapeXml(assertion.chainedAuthentications[fn:length(assertion.chainedAuthentications)-1].principal.id)}</cas:user>

		<c:if
			test="${fn:length(assertion.chainedAuthentications[fn:length(assertion.chainedAuthentications)-1].principal.attributes)> 
				0}">
			<cas:attributes>
				<c:if test="${not empty loginuser}">
					<c:forEach var="attr" items="${loginuser}" varStatus="loopStatus"
						begin="0" end="${fn:length(loginuser)-1}" step="1">
						<cas:${fn:escapeXml(attr.key)}>${fn:escapeXml(attr.value)}</cas:${fn:escapeXml(attr.key)}>
					</c:forEach>
				</c:if>
			</cas:attributes>
		</c:if>

		<c:if test="${not empty userCompany}">
					<cas:casUserCompany>
						<c:forEach var="attr" items="${userCompany}" varStatus="loopStatus"
							begin="0" end="${fn:length(userCompany)-1}" step="1">
							<cas:${fn:escapeXml(attr.key)}>${fn:escapeXml(attr.value)}</cas:${fn:escapeXml(attr.key)}>
						</c:forEach>
					</cas:casUserCompany>
				</c:if>
		
			<c:if test="${not empty userfunmodels}">
				<cas:casUserFuncModels>
					<c:forEach items="${userfunmodels}" var="modelMap"
						varStatus="status">
						<c:if test="${not empty modelMap}">
							<cas:casFuncModel>
								<c:forEach var="attr" items="${modelMap}" varStatus="loopStatus"
									begin="0" end="${fn:length(modelMap)-1}" step="1">
									<cas:${fn:escapeXml(attr.key)}>${fn:escapeXml(attr.value)}</cas:${fn:escapeXml(attr.key)}>
								</c:forEach>
							</cas:casFuncModel>
						</c:if>
					</c:forEach>
				</cas:casUserFuncModels>
			</c:if>

		<c:if test="${not empty pgtIou}">
				<cas:proxyGrantingTicket>${pgtIou}</cas:proxyGrantingTicket>
		</c:if>
		<c:if test="${fn:length(assertion.chainedAuthentications) > 1}">
				<cas:proxies>
		<c:forEach var="proxy" items="${assertion.chainedAuthentications}" varStatus="loopStatus" begin="0" end="${fn:length(assertion.chainedAuthentications)-2}" step="1">
					<cas:proxy>${fn:escapeXml(proxy.principal.id)}</cas:proxy>
		</c:forEach>
				</cas:proxies>
		</c:if>
	</cas:authenticationSuccess>
</cas:serviceResponse>
