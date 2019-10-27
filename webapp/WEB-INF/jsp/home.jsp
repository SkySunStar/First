<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:set var="prc" value="${pageContext.request.contextPath }" />
<link type="text/css" rel="stylesheet" href="${prc}/common/css/extra.css" />
<link type="text/css" rel="stylesheet" href="${prc}/common/css/home.css" />
<script type="text/javascript" src="${prc }/common/js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="${prc }/common/js/jquery.validate.js"></script>
<title>随风旅行网</title>
</head>
<body onselectstart="return false">
	<div id="header">
		<%@include file="/common/jsp/header.jsp" %>
	</div>
	<div id="homeBody">
		<ul id="navigate">
			<li>
			<span class="homeTitle">景区</span>
			<c:forEach items="${scenicList }" begin="0" end="3" var="scenic">
				<div class="homeContent">
					<img alt="${scenic.name }" src="/photo/${scenic.image }"/>
				</div>
			</c:forEach>
			<span class="more"><span name="scenic;">查看更多</span></span>
			</li>
			
			<li>
			<span class="homeTitle">美食</span>
			<c:forEach items="${foodList}" begin="0" end="3" var="food">
				<div class="homeContent">
					<img alt="${food.name }" src="/photo/${food.image }"/>
				</div>
			</c:forEach>
			<span class="more"><span name="goods;1">查看更多</span></span>
			</li>
			
			<li>
			<span class="homeTitle">特产</span>
			<c:forEach items="${specialtyList}" begin="0" end="3" var="shop">
				<div class="homeContent">
					<img alt="${shop.name }" src="/photo/${shop.image }"/>
				</div>
			</c:forEach>
			<span class="more"><span name="goods;2">查看更多</span></span>
			</li>
			
			<li>
			<span class="homeTitle">旅馆</span>
			<c:forEach items="${roomList}" begin="0" end="3" var="room">
				<div class="homeContent">
					<img alt="${room.name }" src="/photo/${room.image }"/>
				</div>
			</c:forEach>
			<span class="more"><span name="goods;3">查看更多</span></span>
			</li>
		</ul>
	</div>
	<div id="footer">
		<%@include file="/common/jsp/footer.jsp" %>
	</div>
<%@include file="/common/jsp/log_reg.jsp" %>
<script type="text/javascript" src="${prc }/common/js/header.js"></script>
</body>
</html>