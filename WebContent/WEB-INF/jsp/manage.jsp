<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:set var="prc" value="${pageContext.request.contextPath }" />
<link type="text/css" rel="stylesheet" href="${prc}/common/css/extra.css"/>
<link type="text/css" rel="stylesheet" href="${prc }/common/css/manage.css"/>
<script type="text/javascript" src="${prc }/common/js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="${prc }/ckeditor/ckeditor.js"></script>
<title>后台管理</title>
</head>
<body onselectstart="return false">
	<div>
		<div id="header">
			<%@include file="/common/jsp/header.jsp" %>
		</div>
		<hr id="firstHr"/>
		<div id="manageBody">
			<h2>信息管理</h2>
		    <dl id="manageTitle">
		    	<dt class="queryList" name="user;">用户</dt>
		    	<dt class="queryList" name="scenic;">景点</dt>
		    	<dt class="queryList" name="goods;1">美食</dt>
		    	<dt class="queryList" name="goods;2">特产</dt>
		    	<dt class="queryList" name="goods;3">旅馆</dt>
		    	<dt id="other">其他</dt>
		    </dl>
			<div id="pageForm">
				<span id="add"></span>
				<%@include file="/common/jsp/page.jsp" %>
			</div>
			<div id="module"></div>
		</div>
		<hr id="lastHr"/>
		<div id="footer">
			<%@include file="/common/jsp/footer.jsp" %>
		</div>
		<dl id="otherDetail">
		    <dt class="queryList" name="seller;">商家</dt>
		    <dt class="queryList" name="goods_type;">商品分类</dt>
		    <dt class="queryList" name="planning;">预订表</dt>
	    </dl>
	</div>
<script type="text/javascript" src="${prc }/common/js/extra.js"></script> 
<script type="text/javascript" src="${prc }/common/js/manage.js"></script>
</body>
</html>