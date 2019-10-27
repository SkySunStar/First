<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="prc" value="${pageContext.request.contextPath }" />
<link type="text/css" rel="stylesheet" href="${prc}/common/css/log_reg.css" />
 <div id="modal-overlay"> 
	<span id="close">返回主页&gt;&gt;&gt;</span>
	<div id="modal-data">
		<div id="top">
			<span>登录</span><span>注册</span>
		</div>
		<div id="form">
		<form id="log_form">
			<table class="lrTable">
				<tr>
					<td>用户名</td>
					<td><input id="log_name" class="input" type="text" value="${cookie.username.value}" /></td>
				</tr>
				<tr>
					<td>密&nbsp; &nbsp;码</td>
					<td><input id="log_pwd" class="input" type="password" /></td>
				</tr>
				<tr>
					<td></td>
					<td>
						<input type="checkbox" id="save" checked="checked" />
						<label id="saveTxt" for="save">保存登录信息&nbsp; &nbsp;</label>
						<a id="forget" href="#" >忘记密码?</a>
					</td>
				</tr>
				<tr id="mess">
					<td colspan="2"></td>
				</tr>
				<tr>
					<td colspan="2"><input id="log_btn" class="btn" type="button" value="登录" /></td>
				</tr>
			</table>
		</form>
		<form id="reg_form">
			<table class="lrTable">
				<tr>
					<td>用户名</td>
					<td><input class="input" id="name" type="text" name="name"/></td>
				</tr>
				<tr>
					<td>密&nbsp; &nbsp;码</td>
					<td><input class="input" type="password" name="password"/></td>
				</tr>
				<tr>
					<td>确认密码</td>
					<td><input class="input" type="password" name="confirm_password"/></td>
				</tr>
				<tr>
					<td>真实姓名</td>
					<td><input class="input" type="text" name="realname"/></td>
				</tr>
				<tr>
					<td>电话号码</td>
					<td><input class="input" id="telephone" type="text" name="telephone"/></td>
				</tr>
				<tr>
					<td>地&nbsp; &nbsp;址</td>
					<td><input class="input" type="text" name="address"/></td>
				</tr>
				<tr>
					<td colspan="2"><input id="reg_btn" class="btn" type="submit" value="注册" /></td>
				</tr>
			</table>
		</form>
		</div>
	</div>
</div>
<div id="foundPwd">
	<%@include file="/common/jsp/resetPwd.jsp" %>
</div>
<script type="text/javascript" src="${prc }/common/js/log_reg.js"></script>