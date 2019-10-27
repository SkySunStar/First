<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="userList">
	<div class="tableLimit">
		<table>
			<thead>
				<tr>
					<th width="100px">ID</th>
					<th width="120px">登录名</th>
					<th width="100px">用户权限</th>
					<th width="120px">真实姓名</th>
					<th width="150px">电话号码</th>
					<th width="300px">地址</th>
					<th width="150px">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${sessionScope.travelList }" var="user">
				<tr class="userTr">
					<td>${user.id }</td>
					<td>${user.name }</td>
					<td value="${user.rights}">
						<c:if test="${user.rights==0 }">普通用户</c:if>
						<c:if test="${user.rights==1 }">管理员</c:if>
					</td>
					<td>${user.realname }</td>
					<td>${user.telephone }</td>
					<td>${user.address }</td>
					<td><a class="mod">修改</a>
					<c:if test="${sessionScope.userVO.id!=user.id }"><a class="del">删除</a></c:if></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div id="modal-overlay">
		<div id="modal-data">
			<div id="close">X</div>
			<form id="userform" class="subList">
				<input class="input" type="hidden" name="id" value="0"/>
				<table>
					<tr>
						<td>用户名</td>
						<td><input class="input" id="name" type="text" name="name"/></td>
					</tr>
					<tr>
						<td>密&nbsp; &nbsp;码</td>
						<td><input type="password" name="password"/></td>
					</tr>
					<tr>
						<td>用户权限</td>
						<td><select class="input" name="rights">
						<option value="0">普通用户</option><option value="1">管理员</option> 
						</select></td>
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
						<td colspan="2"><input id="btn" type="button" value="添加" />
						<input id="clear" type="reset" value="清空" /></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</div>
