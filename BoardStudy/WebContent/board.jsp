<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Board</title>
</head>
<body>
	�Խñ�
	<table>
		<thead>
			<tr>
				<th>�۹�ȣ</th>
				<th>������</th>
				<th>�۾���</th>
				<th>�ۼ��ð�</th>
			</tr>
		</thead>
		<c:forEach items="${boardList}" var="board">
			<tr>
				<td>${board.no}</td>
				<td>${board.title}</td>
				<td>${board.name}</td>
				<td>${board.writeDate}</td>
			</tr>
		</c:forEach>
	</table>
	<div>
		<a href="./write"><button>�۾���</button></a>
	</div>
</body>
</html>