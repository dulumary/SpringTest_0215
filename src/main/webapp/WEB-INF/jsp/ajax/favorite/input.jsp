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
		<div class="d-flex">
			<input type="text" class="form-control col-11" id="addressInput">
			<button type="button" class="btn btn-success" id="duplicateBtn">중복확인</button>
		</div>
		<div class="small text-danger d-none" id="duplicateText">중복된 url 입니다</div>
		<div class="small text-info d-none" id="avaliableText">저장 가능한 url 입니다</div>
		<button type="button" class="btn btn-success btn-block mt-4" id="addBtn">추가</button>
	
	</div>

<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>
<script>
	$(document).ready(function() {
		
		$("#duplicateBtn").on("click", function() {
			let address = $("#addressInput").val();
			
			if(address == "") {
				alert("주소를 입력하세요!");
				return ;
			}
			
			// http:// 로 시작하지 않고 https:// 로도 시작하지 않으면 
			if(!address.startsWith("http://") && !address.startsWith("https://")) {
				alert("주소를 확인하세요!");
				return ;
			}
	
			$.ajax({
				type:"post"
				, url:"/ajax/favorite/duplicate-url"
				, data:{"url":address}
				, success:function(data) {
					// 중복     {"isDuplicate":true} 
					// 중복 안됨 {"isDuplicate":false}
					if(data.isDuplicate) {
						$("#duplicateText").removeClass("d-none");
						$("#avaliableText").addClass("d-none");
					} else {
						$("#avaliableText").removeClass("d-none");
						$("#duplicateText").addClass("d-none");
					}
					
				}
				, error:function() {
					alert("중복확인 에러!");
				}
			});
			
			
		});
		
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
			$.ajax({
				type:"post"
				, url:"/ajax/favorite/create"
				, data:{"name":title, "url":address}
				, success:function(data) {
					// 성공시 : {"result":"success"}
					// 실패시 : {"result":"fail"}
					if(data.result == "success") {
						location.href = "/ajax/favorite/list";
					} else {
						alert("즐겨찾기 추가 실패");
					}
				
				}
				, error:function() {
					alert("즐겨찾기 추가 에러");
				}
			});
			
		});
		
	});

</script>

</body>
</html>