<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<link rel="stylesheet" type="text/css" href="//netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</head>
<body>
<hr>
<div class="container bootstrap snippets bootdey">
    <div class="row">
        <div class="col-lg-12">
            <div class="main-box no-header clearfix">
                <div class="main-box-body clearfix">
                    <div class="table-responsive">
                        <table class="table user-list">
                            <thead>
                                <tr>
                                <th class="text-center"><span>SEQ</span></th>
                                <th class="text-center"><span>ID</span></th>
                                <th class="text-center"><span>TITLE</span></th>
                                <th class="text-center"><span>CREATED</span></th>
                                <th>&nbsp;</th>
                                </tr>
                            </thead>
                            <tbody>
                            	<c:forEach items="${list }" var="boardList">
                            		<tr>
	                                    <td class="text-center">${boardList.board_number}</td>
	                                    <td class="text-center">${boardList.id }</td>
	                                    <td class="text-center"><a href="/board/getDetail.do?board_number=${boardList.board_number} ">${boardList.title }</a></td>
	                                    <td class="text-center">${boardList.create_date }</td>
	                                </tr>
                            	</c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="main-box-body clearfix">
                    	<input type="button" value="글작성" onclick="location.href='/board/writeBoard.do'" />
                    	<input type="button" value="로그아웃" onclick="location.href='/logout/logout.do'" />
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


</body>
</html>