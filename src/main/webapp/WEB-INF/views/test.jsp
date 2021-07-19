<%@include file="/common/taglib.jsp"%>
 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create Applicant</title>
<style>
.error-message {
   color: red;
   font-size:90%;
   font-style: italic;
}
</style>
</head>
<body>
 
   <h3>${formTitle}</h3>
 
   <form:form action="test" method="POST"
       modelAttribute="model">
  
       <table>
           <tr>
               <td>Name</td>
               <td><form:input path="id" /></td>
               <td><form:errors path="id"
                       class="error-message" /></td>      
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
               <td>
                       <form:checkbox path="converterDisPrice" value="haha" label="haha" />
                   </td>
               <td><form:errors path="converterDisPrice" class="error-message" /></td>
           </tr>
 
           <tr>
               <td>&nbsp;</td>
               <td><input type="submit" value="Submit" />
                  <a href="${pageContext.request.contextPath}/applicantList">Cancel</a>
               </td>
               <td>&nbsp;</td>
           </tr>
       </table>
   </form:form>
 
</body>
</html>