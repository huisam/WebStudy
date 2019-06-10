<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function check() {
		form = document.bookadd;
		
		if(form.book.value==null)
			alert("도서 번호를 입력해주세요!");
		else if(form.bookName.value=="")
			alert("도서제목을 입력해주세요!!");
		else if(form.booktype.value=="")
			alert("도서종류를 골라주세요!!!");
		else if(form.writer.value=="")
			alert("저자를 입력해주세요!!");
		
	}

</script>
</head>
<body>
<div class="container">
	<h1>도서 등록 화면</h1>
	<div>
	<form method="post" action="/bookmvc/insert.bookmvc" name="bookadd">
		<fieldset>
			<legend> * 표시가 된 항목은 필수 입력 항목입니다. </legend>
			<p></p>
			<p>
				<span>* 도서번호</span>
				<input type="text" name="book">-<input type="text" name="book">-<input type="text" name="book">
			</p>
			<p>
				<span>* 도서제목</span>
				<input type="text" name="bookName">
			</p>
			<p>
				<span>* 도서종류</span>
				<select name="booktype">
					<option value="소설">소설</option>
					<option value="수필">수필</option>
					<option value="자기계발서">자기계발서</option>
					<option value="베스트셀러">베스트셀러</option>
				</select>
			</p>
			<p>
				<span>출판국가</span>
				<input type="radio" name="nation" value="국내">국내도서
				<input type="radio" name="nation" value="외국">외국도서
			</p>
			<p>
				<span>출 판 일</span>
				<input type="date" name="date">
			</p>
			<p>
				<span>출 판 사</span>
				<select name="publisher">
					<option value="문학수첩">문학수첩</option>
					<option value="좋은땅">좋은땅</option>
					<option value="들녘">들녘</option>
					<option value="길벗">길벗</option>
				</select>
			</p>
			<p>
				<span>* 저 자</span>
				<input type="text" name="writer">
			</p>
			<p>
				<span>* 도서가격</span>
				<input type="text" name="price">
				<select name="money">
					<option value="원">원</option>
					<option value="달러">달러</option>
					<option value="엔">엔</option>
				</select>
			</p>
			<p>
				<span>요약내용</span>
				<textarea rows="3" cols="30" name="content"></textarea>
			</p>
			<p>
				<input type="submit" value="도서등록" onclick="check()">
				<input type="reset" value="취 소">
			</p>
		</fieldset>
	</form>
	</div>
	</div>
</body>
</html>