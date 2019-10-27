<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:set var="prc" value="${pageContext.request.contextPath }" />
<link type="text/css" rel="stylesheet" href="${prc}/common/css/extra.css" />
<link type="text/css" rel="stylesheet" href="${prc}/common/css/front.css" />
<script type="text/javascript" src="${prc }/common/js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="${prc }/common/js/jquery.validate.js"></script>

<title>随风旅行网</title>
</head>
<body onselectstart="return false">
	<div id="header">
		<%@include file="/common/jsp/header.jsp" %>
	</div>
	<div id="frontBody">
		<ul id="frontTitle">
			<li name="scenic;">景点</li>
			<li name="goods;1">美食</li>
			<li name="goods;2">特产</li>
			<li name="goods;3">旅馆</li>
		</ul>
		<div id="module">
			<%@include file="/common/jsp/frontModule.jsp" %>
		</div>
		<div id="pageForm">
			<%@include file="/common/jsp/page.jsp" %>
		</div>
	</div>
	<div id="footer">
		<%@include file="/common/jsp/footer.jsp" %>
	</div>
<%@include file="/common/jsp/log_reg.jsp" %>
<script type="text/javascript" src="${prc }/common/js/extra.js"></script>
<script type="text/javascript" src="${prc }/common/js/header.js"></script>
<script type="text/javascript" src="${prc }/common/js/front.js"></script>
</body>
</html>