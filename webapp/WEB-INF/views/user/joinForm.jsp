<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath }/assets/css/mysite.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath }/assets/css/user.css" rel="stylesheet" type="text/css">


<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery/jquery-1.12.4.js"></script>


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
			<h2>회원</h2>
			<ul>
				<li><a href="${pageContext.request.contextPath }/user/modifyForm">회원정보수정</a></li>
				<li><a href="${pageContext.request.contextPath }/user/loginForm">로그인</a></li>
				<li><a href="${pageContext.request.contextPath }/user/joinForm">회원가입</a></li>
			</ul>
		</div>
		<!-- //aside -->

		<div id="content">

			<div id="content-head">
				<h3>회원가입</h3>
				<div id="location">
					<ul>
						<li>홈</li>
						<li>회원</li>
						<li class="last">회원가입</li>
					</ul>
				</div>
				<div class="clear"></div>
			</div>
			<!-- //content-head -->

			<div id="user">
				<div id="joinForm">
					<form id="joinSubmitForm" action="${pageContext.request.contextPath }/user/join" method="get">

						<!-- 아이디 -->
						<div class="form-group">
							<label class="form-text" for="input-uid">아이디</label> <input type="text" id="input-uid" name="id" value=""
								placeholder="아이디를 입력하세요">
							<button type="button" id="btnIdCheck">중복체크</button>
							<span id="idcheckMsg"></span>
						</div>

						<!-- 비밀번호 -->
						<div class="form-group">
							<label class="form-text" for="input-pass">패스워드</label> <input type="text" id="input-pass" name="password"
								value="" placeholder="비밀번호를 입력하세요">
						</div>

						<!-- 이메일 -->
						<div class="form-group">
							<label class="form-text" for="input-name">이름</label> <input type="text" id="input-name" name="name" value=""
								placeholder="이름을 입력하세요">
						</div>

						<!-- //나이 -->
						<div class="form-group">
							<span class="form-text">성별</span> <label for="rdo-male">남</label> <input type="radio" id="rdo-male" name="gender"
								value="male"> <label for="rdo-female">여</label> <input type="radio" id="rdo-female" name="gender"
								value="female">

						</div>

						<!-- 약관동의 -->
						<div class="form-group">
							<span class="form-text">약관동의</span> <input type="checkbox" id="chk-agree" value="" name=""> <label
								for="chk-agree">서비스 약관에 동의합니다.</label>
						</div>

						<!-- 버튼영역 -->
						<div class="button-area">
							<button type="submit" id="btn-submit">회원가입</button>
						</div>

					</form>
					
					<!-- 예제 -->
					<a id="naver" href="https://www.naver.com/">네이버</a>
					
				</div>
				<!-- //joinForm -->
			</div>
			<!-- //user -->
		</div>
		<!-- //content  -->
		<div class="clear"></div>

		<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
		<!-- //footer -->

	</div>
	<!-- //wrap -->

</body>

<script type="text/javascript">
//예제 
//원래의 태그의 기능을 사용하지 않을때
$("#naver").on("click", function(event){
	event.preventDefault();
});


//회원가입 버튼을 눌렀을때:  전송submit은 form에 이벤트
$("#joinSubmitForm").on("submit", function(){
	console.log("전송버튼 클릭");
	
	//아이디 체크
	var id = $("#input-uid").val();
	if(id.length < 1){ //입력안했으면
		alert("아이디를 입력해주세요");
		return false;
	}
	
	//패스워드 체크...
	
	//약관동의 유무
	var agree = $("#chk-agree").is(":checked");
	if(agree == false){
		alert("약관에 동의해 주세요");
		return false;
	}	
	
	return true; 
});


//아이디 체크 버튼 클릭했을때
$("#btnIdCheck").on("click", function(){
	console.log("버튼 클릭");
	
	//id 추출
	var id = $("[name=id]").val();
	
	console.log(id);
	
	//통신  id////////////////////////////////////////////
	$.ajax({
		url : "${pageContext.request.contextPath }/user/idcheck",		
		type : "post",
		/* contentType : "application/json", */
		data : {id : id},

		dataType : "json",
		success : function(jsonResult){
			console.log(jsonResult);
			
			if(jsonResult.result == 'success'){ //처리성공
				//사용가능한지 불가능 한지 표현한다
				if(jsonResult.data == true){
					//사용가능
					$("#idcheckMsg").html( id+ "는 사용가능 합니다.");    
				}else {
					//사용불가
					$("#idcheckMsg").html( id+ "는 사용중입니다.");    
				}
				
			}else {
				//메세지 출력
				var msg = jsonResult.failMsg;
				alert(msg);
			}
		},
		error : function(XHR, status, error) {
			console.error(status + " : " + error);
		}
	});
	
});

</script>



</html>