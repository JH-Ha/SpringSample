<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Write</title>
</head>
<body>
	<form action="./write" method="post">
		<div>
			<input name="title" placeholder="제목" />
		</div>
		<div>
			<textarea rows="10" cols="10" name="content"></textarea>
		</div>
		<div>
			<button type="submit">작성</button>
			<button type="button">취소</button>
		</div>
	</form>
</body>
</html>