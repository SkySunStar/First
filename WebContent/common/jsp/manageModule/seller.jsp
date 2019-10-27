<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div id="sellerList">
	<div class="tableLimit">
		<table>
			<thead>
				<tr>
					<th width="100px">ID</th>
					<th width="150px">商家名称</th>
					<th width="150px">电话号码</th>
					<th width="250px">地址</th>
					<th width="150px">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${sessionScope.sellerList }" var="seller">
				<tr class="sellerTr">
					<td>${seller.id }</td>
					<td>${seller.name }</td>
					<td>${seller.telephone }</td>
					<td>${seller.address }</td>
					<td><a class="mod">修改</a><a class="del">删除</a></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div id="modal-overlay">
		<div id="modal-data">
			<div id="close">X</div>
			<form id="sellerform" class="subList">
				<input class="input" type="hidden" name="id" value="0"/>
				<table>
					<tr>
						<td>商家名称</td>
						<td><input class="input" type="text" name="name" /></td>
					</tr>
					<tr>
						<td>电话号码</td>
						<td><input class="input" type="text" name="telephone"/></td>
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
