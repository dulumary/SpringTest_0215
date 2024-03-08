<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>통나무 펜션</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/ajax/css/style.css" type="text/css">
</head>
<body>
	<div id="wrap" >
	    <header class="mt-4">
	        <div class="text-center display-4">통나무 팬션</div>
	        <nav class="mt-4">
	            <ul class="nav nav-fill">
	                <li class="nav-item"><a class="nav-link" href="#">팬션소개</a></li>
	                <li class="nav-item"><a class="nav-link" href="#">객실보기</a></li>
	                <li class="nav-item"><a class="nav-link" href="/ajax/booking/input">예약하기</a></li>
	                <li class="nav-item"><a class="nav-link" href="/ajax/booking/list">예약목록</a></li>
	            </ul>
	        </nav>
	    </header>
	
	    
	    <section>
	         <h2 class="my-4 text-center">예약 하기</h2>
	        
	        <div class="d-flex justify-content-center">
	            <div class="w-50">
	                <label>이름</label>
	                <input type="text" class="form-control">
	
	                <label class="mt-3">예약날짜</label>
	                <input type="text" class="form-control">
	
	                <label class="mt-3">숙박일수</label>
	                <input type="text" class="form-control">
	
	                <label class="mt-3">숙박인원</label>
	                <input type="text" class="form-control">
	
	                <label class="mt-3">전화번호</label>
	                <input type="text" class="form-control">
	
	                <button class="btn btn-warning btn-block mt-3">예약하기</button>
	            </div>
	        </div>
	    </section>
	
	    <footer class="mt-3 ml-4">
	        <address>
	            제주특별자치도 제주시 애월읍  <br>
	            사업자등록번호: 111-22-255222 / 농어촌민박사업자지정 / 대표:김통목 <br>
	            Copyright 2025 tongnamu All right reserved
	        </address>
	
	    </footer>
	
	
	</div>
</body>
</html>