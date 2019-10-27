<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="user" value="${sessionScope.userVO}"></c:set>
<a id="title" href="home.do">随风旅行网</a>
<div id="searchDiv">
	<select name="table">
		<option value="scenic;">景点</option>
		<option value="goods;1">美食</option>
		<option value="goods;2">特产</option>
		<option value="goods;3">旅馆</option>
	</select>
	<input id="content" type="search" maxlength="10"/><input id="search" type="button" value="搜索"/>
</div>
<c:choose>
	<c:when test="${user.rights==0 }">
		<span>你好，${user.name }&nbsp;|&nbsp;<a href="">我的预订</a>&nbsp;|&nbsp;<a href="logout.do">注销</a></span>
	</c:when>
	<c:when test="${user.rights==1 }">
		<span>你好，${user.name }&nbsp;|&nbsp;<a href="">我的预订</a>&nbsp;|&nbsp;<a href="manage.do">后台管理</a>&nbsp;|&nbsp;<a href="logout.do">注销</a></span>
	</c:when>
	<c:when test="${user.rights==2 }">
		<span>你好，${user.name }&nbsp;|&nbsp;<a href="manage.do">后台管理</a>&nbsp;|&nbsp;<a href="logout.do">注销</a></span>
	</c:when>
	<c:otherwise>
		<span>你好，请<a id="login">登录</a>&nbsp; <a id="register">注册</a></span>
	</c:otherwise>
</c:choose>
<a id="home" href="home.do">首页</a>