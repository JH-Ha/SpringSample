<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Login Page</title>
</head>
<body>
	<div>
		<form action="./login" method="post">
			<div>
				<input name="id" placeholder="id" />
			</div>
			<div>
				<input name="password" placeholder="password" type="password"/>
			</div>
			<div>
				<button type="submit">로그인</button>
				<button type="button">회원가입</button>
			</div>
		</form>
	</div>
</body>
</html>