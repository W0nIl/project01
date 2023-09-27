<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
	<head>
		<!-- 합쳐지고 최소화된 최신 CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css?after">
		<!-- 부가적인 테마 -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css?after">
	 	
	 	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<title>회원가입</title>
	</head>
	<script type="text/javascript">
		$(document).ready(function(){
			// 취소
			$(".cencle").on("click", function(){
				
				location.href = "/";
						    
			})
		
			$("#submit").on("click", function(){
				if($("#u_id").val()==""){
					alert("아이디를 입력해주세요.");
					$("#u_id").focus();
					return false;
				}
				if($("#u_pw").val()==""){
					alert("비밀번호를 입력해주세요.");
					$("#u_pw").focus();
					return false;
				}
				if($("#u_pw_again").val() != $("#u_pw").val()){
					alert("비밀번호가 일치하지 않습니다.");
					$("#u_pw").focus();
					return false;
				}
				if($("#u_nickname").val()==""){
					alert("닉네임을 입력해주세요.");
					$("#u_nickname").focus();
					return false;
				}
				if($("#u_phone").val()==""){
					alert("전화번호를 입력해주세요.");
					$("#u_phone").focus();
					return false;
				}
				if($("#u_email").val()==""){
					alert("E메일을 입력해주세요.");
					$("#u_email").focus();
					return false;
				}
				var idChkVal = $("#idChk").val();
				if(idChkVal == "N"){
					alert("중복확인 버튼을 눌러주세요.");
				}else if(idChkVal == "Y"){
					$("#regForm").submit();
				}
			});
		})
		function fn_idChk(){
			$.ajax({
				url : "./idChk",
				type : "post",
				dataType : "json",
				data : {"u_id" : $("#u_id").val()},
				success : function(data){
					if(data == 1){
						alert("중복된 아이디입니다.");
						return false;
					}else if(data == 0){
						$("#idChk").attr("value","Y");
						alert("사용가능한 아이디입니다.");
						$("#u_pw").focus();
					}
				}
			})
		}
		
	</script>
	<body>
		<jsp:include page="./nav.jsp" />
		<section id="container">
			<form action="./register" method="post" id="regForm">
				<div class="form-group has-feedback">
					<label class="control-label" for="u_id">아이디</label>
					<input class="form-control" type="text" id="u_id" name="u_id" />
					<button class="idChk" type="button" id="idChk" onclick="fn_idChk();" value="N">중복확인</button>
				</div>
				<div class="form-group has-feedback">
					<label class="control-label" for="u_pw">패스워드</label>
					<input class="form-control" type="password" id="u_pw" name="u_pw" />
				</div>
				<div class="form-group has-feedback">
					<label class="control-label" for="u_pw_again">패스워드확인</label>
					<input class="form-control" type="password" id="u_pw_again" name="u_pw_again" />
				</div>
				<div class="form-group has-feedback">
					<label class="control-label" for="userName">닉네임</label>
					<input class="form-control" type="text" id="u_nickname" name="u_nickname" />
				</div>
				<div class="form-group has-feedback">
					<label class="control-label" for="u_email">E메일</label>
					<input class="form-control" type="text" id="u_email" name="u_email" />
				</div>
				<div class="form-group has-feedback">
					<label class="control-label" for="u_phone">전화번호</label>
					<input class="form-control" type="text" id="u_phone" name="u_phone" />
				</div>
				<input type="hidden" id="u_auth" name="u_auth"	value="0"> <br><br>
				<div class="form-group has-feedback">
					<button class="btn btn-success" type="submit" id="submit">회원가입</button>
					<button class="cencle btn btn-danger" type="button">취소</button>
				</div>
				
			</form>
		</section>
		
	</body>
	
</html>