<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath }/assets/css/mysite.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath }/assets/css/guestbook.css" rel="stylesheet" type="text/css">

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

		<!-- aside -->
		<div id="aside">
			<h2>방명록</h2>
			<ul> 
				<li><a href="${pageContext.request.contextPath }/guestbook/addList">일반방명록</a></li>
				<li><a href="${pageContext.request.contextPath }/api/guestbook/addList2">ajax방명록</a></li>
			</ul>
		</div>
		<!-- //aside -->

		<div id="content">
			
			<div id="content-head">
            	<h3>일반방명록</h3>
            	<div id="location">
            		<ul>
            			<li>홈</li>
            			<li>방명록</li>
            			<li class="last">일반방명록</li>
            		</ul>
            	</div>
                <div class="clear"></div>
            </div>
            <!-- //content-head -->

			<div id="guestbook">
				<form action="${pageContext.request.contextPath }/guestbook/delete" method="get">
					<table id="guestDelete">
						<colgroup>
							<col style="width: 10%;">
							<col style="width: 40%;">
							<col style="width: 25%;">
							<col style="width: 25%;">
						</colgroup>
						<tr>
							<td>비밀번호</td>
							<td><input type="password" name="password"></td>
							<td class="text-left"><button type="submit">삭제</button></td>
							<td><a href="/guestbook2/gbc">[메인으로 돌아가기]</a></td>
						</tr>
					</table>
					<input type="text" name="no" value="${param.no }">
					
				</form>
				
			</div>
			<!-- //guestbook -->
		</div>
		<!-- //content  -->
		<div class="clear"></div>
		
		<!-- //footer -->
		<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
		<!-- //footer -->

	</div>
	<!-- //wrap -->

</body>

</html>
