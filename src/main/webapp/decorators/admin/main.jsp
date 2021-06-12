<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>

 <script src="<c:url value='/template/admin/vendor/jquery/jquery.min.js' />"></script>
 <script src="<c:url value='/template/admin/sweetalert/sweetalert2.min.js' />"></script>
 <!-- Custom styles for this template-->
    <link href="<c:url value='/template/admin/css/sb-admin-2.min.css' />" rel="stylesheet" type="text/css">
    <link href="<c:url value='/template/admin/css/sb-admin-2.css' />" rel="stylesheet" type="text/css">
     <link href="<c:url value='/template/admin/css/edit.css' />" rel="stylesheet" type="text/css">
   <link href="<c:url value='/template/admin/vendor/fontawesome-free/css/all.min.css' />" rel="stylesheet" type="text/css">
     <!-- Custom styles for this page -->
    <link href="<c:url value='/template/admin/vendor/datatables/dataTables.bootstrap4.min.css' />" rel="stylesheet" type="text/css">
    
    <!-- sweetalert -->
    
    <link rel="stylesheet" href="<c:url value='/template/admin/sweetalert/sweetalert2.min.css' />" />
</head>
<body>

	<%@ include file="/common/admin/header.jsp"%>
	<dec:body/>
	<%@ include file="/common/admin/footer.jsp"%>


 <!-- Bootstrap core JavaScript-->
    
     <script src="<c:url value='/template/admin/vendor/jquery-easing/jquery.easing.min.js' />"></script>
    <script src= "<c:url value='/template/admin/vendor/bootstrap/js/bootstrap.bundle.min.js' />"></script>

    <!-- Core plugin JavaScript-->
   

    <!-- Custom scripts for all pages-->
    <script src="<c:url value='/template/admin/js/sb-admin-2.min.js' />"></script>

    <!-- Page level plugins -->
    <script src="<c:url value='/template/admin/vendor/chart.js/Chart.min.js' />"></script>
    <script src="<c:url value='/template/admin/vendor/datatables/jquery.dataTables.min.js' />"></script>
    <script src="<c:url value='/template/admin/vendor/datatables/dataTables.bootstrap4.min.js' />"></script>

    <!-- Page level custom scripts -->
    <script src="<c:url value='/template/admin/js/demo/chart-area-demo.js' />"></script>
    <script src="<c:url value='/template/admin/js/demo/chart-pie-demo.js' />"></script>
     <script src="<c:url value='/template/admin/js/demo/datatables-demo.js' />"></script>
 
    
</body>
</html>