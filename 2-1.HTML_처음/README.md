## 02.11 HTML5에 대해 배워보자!!

>특징
>* HTML5 = HTML + CSS + Javascript를 이용한 웹 개발 표준 방식
>* **GUI** = **Front-end** 라고 불려지는 것이 일반적
>* [*HTML 기본 구조*](https://hunit.tistory.com/172) : Header, Section, Footer

### HTML5의 전체적인 큰 틀
```html
<html>
<head></head> 헤더
    <title></title> 웹 사이트 제목
<body></body> 내용
    <header></header> body의 헤더
    <nav></nav> body의 이동 안내창
    <section></section> body의 섹션(구역)
        <article></article> 섹션의 항목
    <footer></footer> body의 밑바닥
</html>
```

### 세부적으로 들어가보자!
```html
<!-- 우선 문단 나누기 부터! -->
    <h1></h1> 큰 타이틀 = 기본적으로 줄바꿈과 굵은 글씨체 지원
    <h2></h2> ...
    <h6></h6> 작은 타이틀 

    <p></p> 한 문단을 구분해줌
    <br> 단순 줄바꿈
    <hr> 줄로 구분자로 바꾸기!

<!-- 리스트 만들기! -->
    <ol> ordered List = 1,2,3 순서대로 리스트 나열
        <li>경찰서</li>
        <li>학교</li>
    </ol>
    <ul> unordered List = * 구분자로 리스트 나열
        <li>경찰서</li>
        <li>학교</li>
    </ul>
    <dl> description List = 그냥 설명을 나열
        <dd>주저리주저리</dd>
    </dl>

<!-- 테이블(표) 만들기! -->
    <table>
        <thead> 표의 윗부분
            <tr>
                <td></td> 열1
                <td></td> 열2
            </tr>
        </thead>
        <tbody> 표의 내용
            <tr>
                <td>개 봉</td>
                <td>2011. 5. 26</td>
            </tr>
            <tr>
                <td>감 독</td>
                <td><a href="#">여 인 영</a></td> 이 친구는 링크!!
            </tr>
            <tr>
                <td>등 급</td>
                <td>[국 내]전체 관람가</td>
            </tr>
        </tbody>
        <tfoot style="background: yellow"> 표의 밑바닥
            <tr>
                <td rowspan="1">하.면.된.다 - 포.스.작.렬</td> rowspan은 열을 합친다!!
            </tr>
        </tfoot>
    </table> 
```

### 중요한 Form 태그도 있다구!!
```html
    <form method="post" action="welcome.jsp" > post혹은 get(get은 파라미터를 넘김)
                        action = 미들웨어로 향하는 통로!!!
        autofocus = 커서로 자동 생성
        placeholder = 입력창 뒤에 설명 만들기
        required = 반드시 입력하라고 알림!!
        autocomplete = 자동완성 on off
        
        on/off:<input type="button" id="hi"><br> 버튼을 생성
        id:<input type="text" id="here"><br> 텍스트 입력창
        color:<input type="color" id="color"><br> 색깔 고르기창
        date:<input type="date" id="date"><br> 날짜 고르기창
        email:<input type="email" id="email"><br> 이메일 입력창
        <input type="hidden" id="x"><br> 숨겨진 값 전송
        password:<input type="password" id ="password"><br> 비밀번호 폼
        url:<input type="url" id="url"><br> url 입력창
        range:<input type="range" id="range"><br> 좌우로 조절 가능한 폼
        radio:<input type="radio"><br> 선택 목록창들
        <select>
            <option>junior</option>
            <option>senior</option>
        </select>
        <input type="submit" value="Submit"><br> 미들웨어로 전송
        <input type="reset" value="Reset"> 입력된거 전부 리셋
    </form>
```

### 마지막 field 태그!
```html
    <fieldset> 네모모양의 필드
        <legend></legend> 제목 만들기
            <label></label> 해당 제목을 만지면 input으로 바로 연결시켜줌!
            <input></input> 설명생략
    </fieldset>
```



