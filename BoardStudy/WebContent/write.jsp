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
			<input name="title" placeholder="����" />
		</div>
		<div>
			<textarea rows="10" cols="10" name="content"></textarea>
		</div>
		<div>
			<button type="submit">�ۼ�</button>
			<button type="button">���</button>
		</div>
	</form>
</body>
</html>