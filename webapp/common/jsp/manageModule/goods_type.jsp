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
					<th width="400px">分类名称</th>
					<th width="150px">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${sessionScope.goodsTypeList }" var="goodsType">
				<tr class="goodsTypeTr">
					<td>${goodsType.id }</td>
					<td>${goodsType.name }</td>
					<td><a class="mod">修改</a><a class="del">删除</a></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div id="modal-overlay">
		<div id="modal-data">
			<div id="close">X</div>
			<form id="goodsTypeform" class="subList">
				<input class="input" type="hidden" name="id" value="0"/>
				<table>
					<tr>
						<td>分类名称</td>
						<td><input class="input" type="text" name="name" /></td>
					</tr>
					<tr>
						<td>所属基本类别</td>
						<td><select class="input" name="typeId">
						<option value="1">美食</option><option value="2">特产</option><option value="3">旅馆</option>  
						</select></td>
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
