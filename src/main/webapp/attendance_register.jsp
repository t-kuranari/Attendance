<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String error = (String) request.getAttribute("error"); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>勤怠登録</title>
	<style>
		body {
			text-align: center;
		}
		body .form-container {
			margin: 20px auto;
			width: 50%;
		}
		label {
			display: inline-block;
			width: 100px;
			text-align: right;
			margin-right: 10px;
		}
		
		input {
		    width: 100px;
		}
	</style>
</head>
<body>
	<header>
		<%@ include file="/header.jsp" %>
	</header>
	<main>
		<% if (error != null) { %>
			<p><%= error %></p>
		<% } %>
		<h2>勤怠登録</h2>
		<form action="<%= request.getContextPath() %>/attendance_register" method="post">
			<label for="employeeId">社員ID：</label>
			<input type="text" name="employeeId" required>
			<br>
			<label for="date">日付：</label>
			<input type="date" name="date" required>
			<br>
			<label for="startTime">開始時刻：</label>
			<input type="time" name="startTime" required>
			<br>
			<label for="endTime">終了時刻：</label>
			<input type="time" name="endTime" required>
			<br>
			<label for="breakTime">休憩時間：</label>
			<input type="time" name="breakTime" required>
			<br>
			<label for="workTime">勤務時間：</label>
			<input type="time" name="workTime" required>
			<br>
			<input type="submit" value="登録">
		</form>
	</main>
</body>
</html>
