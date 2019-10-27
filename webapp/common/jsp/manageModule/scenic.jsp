<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="scenicList">
	<div class="tableLimit">
		<table>
			<thead>
				<tr>
					<th width="100px">ID</th>
					<th width="150px">景区名称</th>
					<th>景区介绍</th>
					<th width="120px">门票价格(元)</th>
					<th width="200px">地址</th>
					<th>图片</th>
					<th width="150px">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${sessionScope.travelList }" var="scenic">
				<tr class="scenicTr">
					<td>${scenic.id }</td>
					<td>${scenic.name }</td>
					<td><div>${scenic.information }</div></td>
					<td>${scenic.price }</td>
					<td>${scenic.address }</td>
					<td value="${scenic.image }"><img src="/photo/${scenic.image }"/></td>
					<td><a class="mod">修改</a><a class="del">删除</a></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div id="modal-overlay">
		<div id="modal-data">
			<div id="close">X</div>
			<form id="scenicform" class="subList" enctype="multipart/form-data">
				<input class="input" type="hidden" name="id" value="0"/>
				<table>
					<tr>
						<td>景区名称</td>
						<td><input class="input" id="name" type="text" name="name" /></td>
					</tr>
					<tr>
						<td>景区介绍</td>
						<td><textarea class="input ckeditor"  name="information"></textarea></td>
					</tr>
					<tr>
						<td>门票价格</td>
						<td><input class="input" type="number" name="price"/></td>
					</tr>
					<tr>
						<td>地&nbsp; &nbsp;址</td>
						<td><input class="input" type="text" name="address"/></td>
					</tr>
					<tr>
						<td>图&nbsp; &nbsp;片</td>
						<td><input class="input" type="file" name="file"/></td>
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
