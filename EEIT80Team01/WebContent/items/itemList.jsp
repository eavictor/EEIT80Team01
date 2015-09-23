<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>
<%@ page import="items.model.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的商品清單</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>商品圖片</th>
			<th>商品名稱</th>
			<th>最高出價金額</th>
			<th>最高出價者</th>
			<th>出價人數</th>
			<th>結標時間</th>
		</tr>
		
		<c:forEach var="item" items="${list }">
			<tr>
				<td>
					<c:if test="${!empty item.image}">
						<img src="${pageContext.request.contextPath}/items/showImage?imageNo=${item.image}">
					</c:if>
					<c:if test="${empty item.image}">
						<img src="${pageContext.request.contextPath}/items/showImage">
					</c:if>
				</td>
				<td>${item.itemsBean.title }</td>
				<td>${item.price}</td>
				<td>${item.buyer}</td>
				<td>${item.count }</td>
				<td>${item.itemsBean.endTime }</td>
				<td>
			 	 <FORM METHOD="post" ACTION="${pageContext.request.contextPath }/items/itemSelectOne.controller">
				    <input type="submit" value="修改商品">
				    <input type="hidden" name="itemId" value="${item.itemId}">
					<input type="hidden" name="itemCategory" value="${item.itemCategory}">
					<input type="hidden" name="title" value="${item.title}">
					<input type="hidden" name="startPrice" value="${item.startPrice}">
					<input type="hidden" name="directPrice" value="${item.directPrice}">
					<input type="hidden" name="bid" value="${item.bid}">
					<input type="hidden" name="endTime" value="${item.endTime}">
					<input type="hidden" name="itemDescribe" value="${item.itemDescribe}">
				    <input type="hidden" name="action"	value="getOne_For_Update">
			     </FORM>
			     
			</td>
				<td>
					<form method="post" action="${pageContext.request.contextPath }/items/itemList.controller">
						<input type="submit" value="刪除">
					    <input type="hidden" name=itemId value="${item.itemId}">
					    <input type="hidden" name="action"value="delete">
					</form>
				</td>
		</c:forEach>
	</table>
</body>
</html>