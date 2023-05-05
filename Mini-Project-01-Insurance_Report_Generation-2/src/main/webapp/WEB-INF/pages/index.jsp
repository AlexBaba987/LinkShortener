<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
  </head>
<body>
<div class="container">
	<h1 class="pb-3 pt-3" style="color:red;text-align:center">Insurance Report Generation</h1>
	<form:form action="search" modelAttribute="search" method="POST">
		<table class="table table-secondary">
				<tr class="pb-3 pt-3">
					<td scope="col">Plan Name : </td>
					<td>
						<form:select path="planName">
							<form:option value="">-select-</form:option>
							<form:options items="${planName }"/>
						</form:select>
					</td>
					<td>Plan Status : </td>
					<td>
						<form:select path="planStatus">
							<form:option value="">-select-</form:option>
							<form:options items="${planStatus }"/>
							<form:options />
						</form:select>
					</td>
					<td>Gender : </td>
					<td>
						<form:select path="gender">
							<form:option value="">-select-</form:option>
							<form:option value="Male">Male</form:option>
							<form:option value="Female">Female</form:option>
							<form:options />
						</form:select>
					</td>
				</tr>
				<tr class="pb-3 pt-3">
					<td>Start Date : </td>
					<td><form:input path="planStartDate" type="date"/></td>
					<td>End Date : </td>
					<td><form:input path="planEndDate" type="date"/></td>
				</tr>
				<tr class="pb-3 pt-3">
					<td><input type="submit" value="Search" class="btn btn-primary"/></td>
				</tr>
		</table>
	</form:form>
	<hr/>
		<table class="table">
			<thead style="text-align:center">
				<tr>
					<th>S.No</th>
					<th>Citizen Name</th>
					<th>Gender</th>
					<th>Plan Name</th>
					<th>Status</th>
					<th>Start Date</th>
					<th>End Date</th>
					<!-- <th>benefit Amount</th>
					<th>denialReason</th>
					<th>terminatedDate</th>
					<th>terminatedReason</th> -->
				</tr>
			</thead>
			<tbody>
				<c:forEach var="report" items="${recordList }" >
			<tr style="text-align: center;">
				<td>${report.citizenId}</td>
				<td>${report.citizenName}</td>
				<td>${report.planName}</td>
				<td>${report.gender}</td>
				<td>${report.planStatus}</td>
				<td>${report.planStartDate}</td>
				<td>${report.planEndDate}</td>
				
				</tr>
			</c:forEach>
			</tbody>
		</table>
	
	<hr/>
	<h3 style="text-align:center">
		Export : &nbsp;&nbsp;<a href="excel">Excel</a> &nbsp;&nbsp;&nbsp; <a href="pdf">Pdf</a>
	</h3>
	</div>
</body>
</html>