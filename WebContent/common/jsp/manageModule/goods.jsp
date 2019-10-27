<%@page import="java.util.List"%>
<%@page import="com.travel.entity.Goods"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="goodsList">
	<div class="tableLimit">
		<table>
			<thead>
				<tr>
					<th width="100px">ID</th>
					<th width="120px"><span class="goodsName"></span>名称</th>
					<th width="150px"><span class="goodsName"></span>信息</th>
					<th width="100px">单价(元)</th>
					<th>图片</th>
					<th width="200px"><span class="goodsName"></span>类别</th>
					<th width="120px">所属商家</th>
					<th width="150px">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${sessionScope.goodsList }" var="goods" >
				<tr class="goodsTr">
					<td>${goods.id }</td>
					<td>${goods.name }</td>
					<td>${goods.information }</td>
					<td>${goods.price }</td>
					<td value="${goods.image }"><img src="/photo/${goods.image }"/></td>
					<td value="${goods.goodsType.id }">${goods.goodsType.name }</td>
					<td>${goods.seller.name }</td>
					<td style="display: none">${goods.seller.id }</td>
					<td style="display: none">${goods.goodsType.typeId }</td>
					<td><a class="mod">修改</a><a class="del">删除</a></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div id="modal-overlay">
		<div id="modal-data">
			<div id="close">X</div>
			<form class="subList" enctype="multipart/form-data">
				<input class="input" type="hidden" name="id" value="0"/>
				<table>
					<tr>
						<td><span class="goodsName"></span>名称</td>
						<td><input class="input" type="text" name="name" /></td>
					</tr>
					<tr>
						<td><span class="goodsName"></span>信息</td>
						<td><textarea class="input ckeditor"  name="information"></textarea></td>
					</tr>
					<tr>
						<td>价&nbsp; &nbsp;格</td>
						<td><input class="input" type="number" name="price"/></td>
					</tr>
					<tr>
						<td>图&nbsp; &nbsp;片</td>
						<td><input class="input" type="file" name="file"/></td>
					</tr>
					<tr>
						<td><span class="goodsName"></span>类别</td>
						<td><select id="goodsType" class="input" name="goodsTypeId">
						</select></td>
					</tr>
					<tr>
						<td>所属商家</td>
						<td><input id="keyword" class="input" type="text" /></td>
					</tr>
					<tr>
						<td colspan="2"><input id="btn" type="button" value="添加" />
						<input id="clear" type="reset" value="清空" /></td>
					</tr>
				</table>
				<input id="sellerId" class="input" type="hidden" name="sellerId" value=""/>
				<input id="typeId" class="input" type="hidden" name="typeId" value=""/>
				<dl id="souSeller"></dl>
			</form>
		</div>
	</div>
</div>