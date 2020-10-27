<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"   
    	integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="   
    	crossorigin="anonymous">
</script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script type="text/javascript">

	function loginCheck() {
		// ajax 통신
		var param = {
				id: UserLoginForm.id.value,
    			password: UserLoginForm.password.value
		}
		$.ajax ({
			type: "POST",
			url: "/login/loginCheck.do",
			data: param,
			dataType: "json",
		}).done((responseData) => {
			if (responseData.result) {
				location.href = "/board/list.do";
			} else {
				alert("로그인 정보를 확인해주세요");
			}
		}).fail((jqXHR, textStatus, errorThrown) => {
			alert("통신 실패");
		})
	}

</script>
</head>
<body>
<hr>
<div class="container bootstrap snippets bootdey">
  <div style="height:auto;min-height:300px;" class="jumbotron">
    <div class="col-md-4">
       <img class="img-responsive center-block img-user" src="https://bootdey.com/img/Content/Manbrown2.png"> 
    </div>
    <div class="col-md-6 form-content">
      <form accept-charset="utf-8" id="UserLoginForm" class="form-signin">    	
        <h1 class="form-signin-heading text-muted">Login</h1>
        <input type="text" id="id" autofocus="autofocus" placeholder="id를 입력하세요" class="form-control" required="required">
        <input type="password" id="password" placeholder="비밀번호를 입력하세요" class="form-control" required="required">	
        <input type="button" class="btn btn-lg btn-info btn-block" onclick="loginCheck()" value="Login" />
      </form>    
    </div>
  </div>
</div>
</body>
</html>