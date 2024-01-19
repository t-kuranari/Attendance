<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List" %>
<%@ page import="entity.AttendanceBean"%>
<% ArrayList<AttendanceBean> attendanceList = (ArrayList<AttendanceBean>) request.getAttribute("attendanceList"); %>
<% List<AttendanceBean> searchList = (List<AttendanceBean>) request.getAttribute("searchList"); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>勤怠一覧</title>
	<script>
		function alertDate() {
			var date = document.getElementById('searchWord').value;
			if (date.trim() !== "") {
				var datePattern = /^\d{4}-\d{2}-\d{2}$/;
				
				if (!datePattern.test(date)) {
					var message = '日付の形式は\nyyyy-MM-ddで入力してください。';
					window.confirm(message);
					return false;
				}
			}
			return true;
		}
		function clearDate() {
			document.getElementById('searchWord').value = "";
		}
	</script>
	<style>
		table {
			margin: 0 auto;
			border-style: dotted;
			width: auto;
		}
		table, th, td {
			border: 1px solid black;
		}
		th, td {
			padding: 8px;
			text-align: left;
		}
		body {
			text-align: center;
		}
	</style>
</head>
<body>
	<header>
		<%@ include file="/header.jsp" %>
	</header>
	<h2>勤怠一覧</h2>
	<form action="/Attendance/attendance_search" method="post" onsubmit="return alertDate();" >
		<label for="searchWord">検索ワード：</label>
		<input type="text" name="date" id="searchWord" placeholder="yyyy-MM-dd" >
		<input type="submit" value="検索">
		<button type="button" onclick="clearDate()">クリア</button>
	</form>
    <% if (searchList != null) { %>
		<table>
			<% if (!searchList.isEmpty()) { %>
				<tr>
					<th>id</th>
					<th>employee_id</th>
					<th>date</th>
					<th>start_time</th>
					<th>end_time</th>
					<th>break_time</th>
					<th>work_time</th>
					<th>編集</th>
					<th>削除</th>
				</tr>
			    <% for (AttendanceBean ab : searchList) { %>
					<tr>
						<td><%= ab.getId() %></td>
						<td><%= ab.getEmployeeId() %></td>
						<td><%= ab.getDate() %></td> 
						<td><%= ab.getStartTime() %></td>
						<td><%= ab.getEndTime() %></td>
						<td><%= ab.getBreakTime() %></td>
						<td><%= ab.getWorkTime() %></td>
						<td>
							<form action="<%= request.getContextPath() %>/attendance_edit" method="post">
								<input type="hidden" name="attendanceId" value="<%= ab.getId() %>">
								<input type="submit" value="編集">
							</form>
						</td>
						<td>
							<form action="<%= request.getContextPath() %>/attendance_delete" method="post">
								<input type="hidden" name="attendanceId" value="<%= ab.getId() %>">
								<input type="submit" value="削除">
							</form>
						</td>
					</tr>
			    <% } %>
			<% } else { %>
				<h2>検索結果はありません</h2>
			<% } %>
		</table>
    <% } else if (attendanceList != null) { %>
		<table>
			<tr>
				<th>id</th>
				<th>employee_id</th>
				<th>date</th>
				<th>start_time</th>
				<th>end_time</th>
				<th>break_time</th>
				<th>work_time</th>
				<th>編集</th>
				<th>削除</th>
			</tr>
			<% for (AttendanceBean ab : attendanceList) { %>
				<tr>
					<td><%= ab.getId() %></td>
					<td><%= ab.getEmployeeId() %></td>
					<td><%= ab.getDate() %></td> 
					<td><%= ab.getStartTime() %></td>
					<td><%= ab.getEndTime() %></td>
					<td><%= ab.getBreakTime() %></td>
					<td><%= ab.getWorkTime() %></td>
					<td>
						<form action="<%= request.getContextPath() %>/attendance_edit" method="post">
							<input type="hidden" name="attendanceId" value="<%= ab.getId() %>">
							<input type="submit" value="編集">
						</form>
					</td>
					<td>
						<form action="<%= request.getContextPath() %>/attendance_delete" method="post">
							<input type="hidden" name="attendanceId" value="<%= ab.getId() %>">
							<input type="submit" value="削除">
						</form>
					</td>
				</tr>
			<% } %>
		</table>
	<% } %>
</body>
</html>