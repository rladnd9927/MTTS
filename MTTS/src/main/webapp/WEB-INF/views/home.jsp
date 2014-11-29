<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>Movie Ticket Total System</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<link href="./static/css/bootstrap.css" rel="stylesheet">
<link href="./static/css/bootstrap-responsive.css" rel="stylesheet">
<link href="./static/manager/body.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="./common/header.jsp"></jsp:include>
	<div class="container-fluid">
		<div class="row-fluid">
			<jsp:include page="./common/submenu.jsp"></jsp:include>
			
			<div class="span9">
			<div class="row">
				<c:forEach var="info" items="${info }">
				<div class="col-sm-6 col-md-4" style="padding:10px;">
			    	<div class="thumbnail">
			      	<img src="./static/images/iu.jpg" alt="영화 포스터">
			      	<div class="caption">
				      	<div class="list-group">
						 	<a href="#" class="list-group-item">
		   						<h3>영화 제목(${info.seq })</h3>
							</a>
						</div>
				        <p>내용1(${info.name })</p>
				        <p>내용2(${info.age })</p>
				        <p><a href="#" class="btn btn-primary">예매 하기</a> <a href="#" class="btn btn-default">예고편 보기</a></p>
			      	</div>
			      	</div>
			  	</div>
			  	</c:forEach>
			</div>
			</div>
		</div>
	</div>
	<jsp:include page="./common/footer.jsp"></jsp:include>
</body>
<script type="text/javascript" src="./resources/js/jquery-1.7.2.min.js"></script>
</html>