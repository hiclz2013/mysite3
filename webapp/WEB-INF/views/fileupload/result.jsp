<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath }/assets/css/mysite.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath }/assets/css/gallery.css" rel="stylesheet" type="text/css">

</head>

<body>
	<div id="wrap">

		<!-- header -->
		<c:import url="/WEB-INF/views/include/header.jsp"></c:import>
		<!-- //header -->
		
		<!-- nav -->
		<div id="nav">
			<ul>
				<li><a href="${pageContext.request.contextPath }/guestbook/addList">방명록</a></li>
				<li><a href="${pageContext.request.contextPath }/gallery/list">갤러리</a></li>
				<li><a href="${pageContext.request.contextPath }/board/list4">게시판</a></li>
				<li><a href="">입사지원서</a></li>
			</ul>
			<div class="clear"></div>
		</div>
		<!-- //nav -->


		<div id="container" class="clearfix">
			<!-- 게시판 aside -->
			<c:import url="/WEB-INF/views/include/galleryAside.jsp"></c:import>
			<!-- //게시판 aside -->
			
			
			<div id="content">
		
			<div id="content-head">
				<h3>첨부파일연습</h3>
				<div id="location">
					<ul>
						<li>홈</li>
						<li>갤러리</li>
						<li class="last">첨부파일연습</li>
					</ul>
				</div>
				<div class="clear"></div>
			</div>
			<!-- //content-head -->
			
			
			<div id="file">
				
					<div>
						<img id="resultImg" src="C:\javaStudy\upload\16861970923411ca79328-ac95-4b7c-b9ca-e287ee80720c.jpg">
					</div>
					<p>
						<a id="btnUpload" href="${pageContext.request.contextPath }/fileupload/form"> 다시 업로드 하기 </a>
					</p>
				
			</div>
			<!-- //file -->
		
		</div>
		<!-- //content  -->
		
		</div>
		<!-- //container  -->


		<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
		<!-- //footer -->

	</div>
	<!-- //wrap -->

</body>

</html>