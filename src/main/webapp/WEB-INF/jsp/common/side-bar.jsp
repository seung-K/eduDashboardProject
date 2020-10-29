<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
.open > .dropdown-menu {
  -webkit-transform: scale(1, 1);
  transform: scale(1, 1);  
  opacity:1;
}
  
.dropdown-menu {
  opacity:.3;
  -webkit-transform-origin: top;
  transform-origin: top;
  -webkit-animation-fill-mode: forwards;  
  animation-fill-mode: forwards; 
  -webkit-transform: scale(1, 0);
  display: block; 
  transition: all 0.3s linear;
  -webkit-transition: all 0.3s linear;
}
</style>
<meta charset="UTF-8">
<title></title>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script type="text/javascript">

	function getList(url, type) {
		$.ajax ({
			type: 'POST',
			url: url,
			dataType: 'json'
		}).done((responseData) => {
			if (type == 'list') {
				// list 출력페이지
			} else {
				// history 출력페이지
			}
		}).fail(() => {
			alert('통신 실패');
		})
	}
</script>
</head>
<body>
<div class="navbar navbar-default navbar-static-top">
  <div class="container bootstrap snippets bootdey">
    <div class="collapse navbar-collapse">
   		<ul class="nav navbar-nav">
        <li><a href="#">DashBoard</a></li>
        <li class="dropdown"><a href="#" id="drop1" data-toggle="dropdown" class="dropdown-toggle" role="button">History<b class="caret"></b></a>
            <ul role="menu" class="dropdown-menu" aria-labelledby="drop1">
                <li role="presentation"><a href="#" role="menuitem">UserHistory</a></li>
                <li role="presentation"><a href="#" role="menuitem">BoardHistory</a></li>
            </ul>
        </li>
      </ul>
    </div>
  </div>
</div>
</body>
</html>