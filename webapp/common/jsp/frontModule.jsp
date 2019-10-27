<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<ul>
<c:forEach items="${sessionScope.travelList }" var="travel">
	<li class="travelTr" style="background-image: url('/photo/${travel.image }');">
		<div class="detail">
		<table>
			<tr><td>${travel.information }</td></tr>
			<tr><td><c:catch var="error">地址：${travel.address }</c:catch></td></tr>
			<tr><td>价格：${travel.price }元</td></tr>
		</table>
		</div>
 		<div class="simple">${travel.name }</div>
	</li> 
</c:forEach>
</ul>