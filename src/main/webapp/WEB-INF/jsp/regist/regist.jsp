<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<link rel="stylesheet" type="text/css" href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script type="text/javascript">
	var isDuplicateCheck = false;
	
	function duplicateCheck() {
		$.ajax ({
			type: 'POST',
			url: '/regist/duplicateCheck.do',
			data: { id: $('#id').val() },
			dataType: 'json'
		}).done((responseData) => {
			if (!responseData.result) {
				alert('사용 가능한 ID입니다.');
				isDuplicateCheck = true;
			} else {
				alert('사용 불가능한 ID입니다.');
			}
		}).fail(() => {
			alert('통신 실패');
		})
	}
	
	function regist() {
		if (isDuplicateCheck) {
			$.ajax ({
				type: 'POST',
				url: '/regist/regist.do',
				data: {
					id: $('#id').val(),
					password: $('#password').val()
				},
				dataType: 'json'
			}).done((responseData) => {
				if (responseData.result > 0) {
					location.href = '/login/main.do';
				}
			}).fail(() => {
				alert('통신 실패');
			})
		} else {
			alert('ID 중복체크를 해주세요');
		}
	}

	function ajax() {
		
		$.ajax ({
			type: 'POST',
			url: url,
			data: param,
			dataType: 'json'
		}).done((responseData) => {
			if (responseData.type == 'duplicate') {
				if (!responseData.result) {
					alert('사용 가능한 ID입니다.');
					isDuplicate = true;
				} else {
					alert('사용 불가능한 ID입니다.');
					$('#id').val() = '';
				}
			} else {
				if (responseData.result && !isDuplicate) {
					location.href = "/regist/regist.do";
				} else if (isDuplicate) {
					alert('ID를 중복체크 해주세요');
				}
			}
		}).fail(() => {
			alert('통신 실패');
		})
	}
</script>
</head>
<body>
<div class="container bootstrap snippets bootdey">
  <div class="jumbotron text-center" style="min-height:400px;height:auto;">
    <div class="col-md-10 col-md-offset-2">
        <form class="form-horizontal" role="form">
            <div class="form-group text-center">
                <div class="col-sm-10 reg-icon">
                    <span class="fa fa-user fa-3x">Register</span>
                </div>
            </div>
            <br/>
            <div class="form-group">
                <div class="col-sm-10">
                  <input type="text" class="form-control" id="id" placeholder="ID" required="required">
                </div>
                <span><input class="btn btn-sm btn-default" type="button" value="중복체크" onclick="duplicateCheck()"></span>
              </div>
              <div class="form-group">
                <div class="col-sm-10">
                  <input type="password" class="form-control" id="password" placeholder="Password" required="required">
                </div>
              </div>
              <br/>
              <div class="form-group">
                <div class="col-sm-10">
                  <input type="button" class="btn btn-lg btn-info btn-block" value="Register" onclick="regist()" >
                </div>
              </div>
        </form>
    </div>
  </div>
</div>                                        
</body>
</html>