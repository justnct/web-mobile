<%@include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create Applicant</title>
<style>
.error-message {
	color: red;
	font-size: 90%;
	font-style: italic;
}

.container-form {
	border: 1px solid;
	padding-bottom: 10px;
	width: 50%;
	padding-top: 10px;
}

.line-one {
	display: flex;
}

.line-one .line-one-left {
	width: 10%;
	text-align: center;
}

.line-one .line-one-right {
	text-align: center;
	width: 90%;
}

.line-one .line-one-right input {
	width: 90%;
}

.line-two {
	display: flex;
}

.line-two .line-two-left {
	width: 10%;
	text-align: center;
}

.line-two .line-two-right {
	margin-left: 5%;
}

.line-three {
	margin-top: 5px;
}

.button1 {
	margin-left: 5px;
}
</style>
</head>
<body>

	<%-- <h3>${formTitle}</h3>

	<form:form action="test" method="POST" modelAttribute="model">

		<table>
			<tr>
				<td>Name</td>
				<td><form:input path="id" /></td>
				<td><form:errors path="id" class="error-message" /></td>
			</tr>
			<tr>
				<td>Gender</td>
				<td><form:select path="name">
						<form:option value="" label="- Gender -" />
						<form:option value="M" label="Male" />
						<form:option value="F" label="Female" />
					</form:select></td>
				<td><form:errors path="nameLittleImg" class="error-message" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><form:input path="des" /></td>
				<td><form:errors path="des" class="error-message" /></td>
			</tr>
			<tr>
				<td>Position</td>
				<td><form:select path="converterPrice">
						<form:options items="${positionMap}" />
					</form:select></td>
				<td><form:errors path="converterPrice" class="error-message" /></td>
			</tr>

			<tr>
				<td>Skills</td>
				<td><form:checkbox path="converterDisPrice" value="haha"
						label="haha" /></td>
				<td><form:errors path="converterDisPrice" class="error-message" /></td>
			</tr>

			<tr>
				<td>&nbsp;</td>
				<td><input type="submit" value="Submit" /> <a
					href="${pageContext.request.contextPath}/applicantList">Cancel</a>
				</td>
				<td>&nbsp;</td>
			</tr>
		</table>
	</form:form> --%>

	<div class="container-form">
		<form:form action="test2" method="POST" modelAttribute="test">
		<div class="line-one">
			<div class="line-one-left">
			<c:forEach var="asd" items="${test.list1}">
							<select id="list1" value="list1">
							<option>${test.list1}</option>
							</select>
			</c:forEach>
			</div>
			<div class="line-one-right">
				<input type="text" />
			</div>
		</div>

		<div class="line-two">
			<div class="line-two-left">
				<label>Title2</label>
			</div>
			<div class="line-two-right">
				<input type="checkbox"> <label>Title Check Box</label>
			</div>
		</div>

		<div class="line-three">
			<input type="button" value="Button1" class="button1"> <input
				type="submit" value="Button1" class="button1">
		</div>
			</form:form>
	</div>
	
	<script type="text/javascript">
	
	</script>


</body>
</html>