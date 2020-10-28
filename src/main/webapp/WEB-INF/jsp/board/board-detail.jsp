<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script type="text/javascript">
    var type = "";
    var id = "";
    var user_number = "";
    var param = {};
	var url = "";
	
	$(document).ready(() => {
	    type = ("${type}");
		
		if (type == "detail") {
			$('#saveBtn').hide();
			if ("${boardDTO.user_number}" != "${userInfo.user_number}" ) {
				$('#modifyBtn').hide();
				$('#deleteBtn').hide();
			}
		} else {
			$('#modifyBtn').hide();
			$('#deleteBtn').hide();
		}

	})
	
	function modify() {
		$('#title').attr("readonly", false);
		$('#content').attr("readonly", false);
		$('#modifyBtn').hide();
		$('#saveBtn').show();
	}

	function save() {
		if (type == "detail") {
			param = {
				board_number: "${boardDTO.board_number}",
				user_number: "${boardDTO.user_number}",
				id: "${boardDTO.id}",
				title: $('#title').val(),
				content: $('#content').val()
			}	
			url = "/board/modifyBoard.do";
		} else {
			param = {
				user_number: "${info['user_number']}",
				id: "${info['id']}",
				title: $('#title').val(),
				content: $('#content').val()
			}
			url = "/board/insertBoard.do";
		}
		ajax();
	}

	function deleteBoard() {
		var result = confirm("게시물을 삭제하시겠습니까?");

		if(result) {
			param = {
				board_number: "${boardDTO.board_number}",
				user_number: "${boardDTO.user_number}"
			};
			url = "/board/deleteBoard.do";

			ajax();
		}
	}

	function ajax() {
		$.ajax ({
			type: 'POST',
			url: url,
			data: param,
			dataType: "json",
		}).done((requestData) => {
			if (requestData.result > 0) {
				location.href = "/board/list.do";
			}
		}).fail(() => {
			alert("통신 실패");
		})
	}
	
	function back() {
		history.back();	
	}
	
</script>
</head>
<body>
	<div class="container">
		<table border="1">
			<tr>
				<td>작성자</td>
				<c:choose>
					<c:when test="${type eq 'detail' }">
						<td>${boardDTO.id }
					</c:when>
					<c:otherwise>
						<td>${info['id']}</td>
					</c:otherwise>
				</c:choose>
			</tr>
			<tr>
				<td>글제목</td>
				<c:choose>
					<c:when test="${type eq 'detail' }">
						<td><input type="text" id="title" value="${boardDTO.title }" readonly/></td>
					</c:when>
					<c:otherwise>
						<td><input type="text" id="title"/></td>
					</c:otherwise>
				</c:choose>
			</tr>
			<tr>
				<td>내용</td>
				<c:choose>
					<c:when test="${type eq 'detail' }">
						<td><textarea id="content" rows="20" cols="50" readonly>${boardDTO.content }</textarea></td>
					</c:when>
					<c:otherwise>
						<td><textarea id="content" rows="20" cols="50"></textarea></td>
					</c:otherwise>
				</c:choose>
			</tr>
		</table>
	</div>
	<div>
		<input type="button" id="backBtn" value="이전" onclick="back()" />
		<input type="button" id="modifyBtn" value="수정" onclick="modify()" />
		<input type="button" id="saveBtn" value="저장" onclick="save()" />
		<input type="button" id="deleteBtn" value="삭제" onclick="deleteBoard()" />
	</div>
</body>
</html>