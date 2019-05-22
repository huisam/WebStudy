## 02.19 Json형식과 JQuery 좀 써볼까..?

> 특징
>* JSON : *Javascript Object Notation* javascript에서 사용하는 객체 표현 방식!!
>* 데이터를 주고 받을 때 JSON 형식을 이용하여 주고 받는다.
>* Ajax : ( HTML + CSS + Javascript ) + XHR( XmlHTTPRequest ) = Ajax!!
>* JQuery : Javascript를 통한 **Web 개발**을 조금 더 편리하게 도와주는 **Framework**!!

### 1. 우선 명시를 해야한다!!
```html
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> Openapi를 가져온 후에 사용하자!!
```

### 2.우선 XHR에 대해 써볼께!!
```javascript
function getData(){ // 1.action이벤트 함수 생성
    var xhr = new XMLHttpRequest(); // 2.XHR객체 생성
    xhr.open("get", "xxx.jsp", true) // 3.요청을 준비하자 open(method, jsp_server, 동기/비동기)
    xhr.onereadystatechange = callback // 4.readystate가 바뀔 때마다 callback함수 실행 
    // readystate = 0 - request초기화 전 / 1 - request 셋업 / 2 - request 진행중 / 3 - request 일부만 끝 / 4 - request 모두 끝!!
    // HTTP status = 200 - 정상응답 / 404 - 서버가 없음 / 405 - 요청방식 잘못 / 500 - 서버오류
    // responseText = request로부터 응답 온 메세지 / requestXML = request로부터 응답 온 xml
    xhr.send(null); // get방식 
    xhr.send(params); // post방식
}
```
* 자세한 정리는 [이쪽](https://myeonguni.tistory.com/1526)으로!!

### 3.JQuery
* 편하게 Ajax를 이용하자!!
```javascript
$(document).ready(function() { // 1.JQuery의 시작은 ready!!! - 웹 페이지 로딩이 다 끝나면 준비한다
    $(Selector).action(param) // Selector로 다양하게 태그를 가져오고, action으로 행동, 마지막 parameter설정하면 끝!!
    $('h1').css("color", "green"); // 1.설정하는 생성자
    $('<h1>go</h1>') // 2.태그를 새로 생성하는 생성자
});
```
* [Selector 정리](https://www.w3schools.com/jquery/jquery_selectors.asp)
```text
* Selector 종류
 $('p,h1,div') 모든 p,h1,div 태그 / $("#lastname") 모든 lastname id속성 / $(".test") 모든 test class속성
 $("[href]") 모든 href 속성 요소 / $(":text") 모든 input type="text"
! 속성 옵션 설명 !
- $("E[A]") :  속성 A를 포함한 모든 E노드 선택.
- $("E[A=V]") :  속성 A의 값이 V인 모든 E 노드 선택.
- $("E[A^=V]") :  속성 A의 값이 V로 시작하는 모든 E 노드 선택.
- $("E[A$=V]") :  속성 A의 값이 V로 끝나는 모든 E 노드 선택.
- $("E[A*=V]") :  속성 A의 값이 V를 포함하고 있는 모든 E 노드 찾기.
```
* [Event 정리](https://www.w3schools.com/jquery/jquery_events.asp)
```text
! 그 외 이벤트들 !
- text(), html(), val() : 해당 태그의 값 가져옴 - 디폴트=getter
- text(msg) : 해당 태그의 텍스트 셋팅
- html(msg) : 해당 태그를 html로 셋팅
- val(msg) : 입력이 가능한 태그의 value = msg로 셋팅
- on(이벤트명, 실행함수) : 해당 태그의 이벤트 등록
- off(이벤트명) : 해당 태그의 이벤트 해지
- addClass(클래스명) : 해당 태그의 클래스 등록
- removeClass(클래스명) : 해당 태그의 클래스 삭제
- toggleClass(클래스명) : 해당 태그의 클래스 등록 해제 반복
```
* [JQuery Ajax](https://www.w3schools.com/jquery/ajax_ajax.asp)
```javascript
$('#all').click(function(){
    $.ajax({
        url: 'xxx.jsp',
        method: 'get',
        success: function(result, status, xhr){ // 응답시 콜백 메서드
        // result = request한 결과, status = 상태 응답 코드, xhr = 동일
            $("#div1").html(result);
        }
    });
});
```