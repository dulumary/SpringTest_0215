<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨찾기 추가</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
</head>
<body>

	<div class="container">
	
		<h2>즐겨찾기 추가하기</h2>
		
		<label class="mt-3">제목</label>
		<input type="text" class="form-control" id="titleInput">
		<label class="mt-3">주소</label>
		<input type="text" class="form-control" id="addressInput">
		<button type="button" class="btn btn-success btn-block mt-4" id="addBtn">추가</button>
	
	</div>

<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>
<script>
	$(document).ready(function() {
		
		$("#addBtn").on("click", function() {
			
			let title = $("#titleInput").val();
			let address = $("#addressInput").val();
			
			if(title == "") {
				alert("제목을 입력하세요!");
				return ;
			}
			
			if(address == "") {
				alert("주소를 입력하세요!");
				return ;
			}
			
			// http:// 로 시작하지 않고 https:// 로도 시작하지 않으면 
			if(!address.startsWith("http://") && !address.startsWith("https://")) {
				alert("주소를 확인하세요!");
				return ;
			}
			
			// 즐겨찾기 추가 API 요청
			$.ajax();
			
		});
		
	});

</script>

</body>
</html>