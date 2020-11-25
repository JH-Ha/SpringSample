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
	게시글
	<table>
		<thead>
			<tr>
				<th>글번호</th>
				<th>글제목</th>
				<th>글쓴이</th>
				<th>작성시각</th>
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
		<a href="./write"><button>글쓰기</button></a>
	</div>
</body>
</html>