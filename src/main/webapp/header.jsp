<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>ヘッダー</title>
	<style>
		.header {
			display: flex;
			align-items: center;
			justify-content: flex-end;
			text-align: right;
		}
		
		.header form {
			margin-left: 10px;
		}
	</style>
</head>
<body>
	<div class="header">
		<form action="attendance_register.jsp" method="POST">
            <button type="submit" name="attendanceRegister">勤怠登録</button>
        </form>
		<form action="<%= request.getContextPath() %>/attendance_index" method="POST">
			<button type="submit" name="attendanceIndex">勤怠一覧</button>
		</form>
		<form action="<%= request.getContextPath() %>/logout" method="post">
			<button type="submit" name="logout">ログアウト</button>
		</form>
	</div>
</body>
</html>