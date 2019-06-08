## MVC Model 구조

> 특징
>* **Model** + **View** + **Controller** 3가지 구조로 이루어진 웹 아키텍쳐
>* 과거에는 *Model1* 방식과 현재는 *Model2*방식으로 이루어져 있다.

> *사용하는 이유?*
>- 컴포넌트마다 각각의 역할을 분리하여 제작하면, 재사용성과 유지보수에 있어서 크게 유리해지기 때문이다<br>
>- 복잡성과 연관성을 줄여서 기능을 명확하게 제작할 수 있다.<br>
>- jsp에 **Scriptlet**이 많아질 수록 jsp페이지는 점점 **복잡해**지는 결과가 초래되기 때문이다.

* **Model1**
>* jsp가 Controller와 view를 한번에 모두 역할하는 방식
* **Model2**
>* jsp와 Servlet의 역할을 분리하여 웹을 구성한다
>* jsp는 View를 담당하고, Servlet는 Controller를 담당한다!!
>* Framework로 들어가면... **2중 Controller** 방식으로 구동되고 있다.


## Cookie 

> 특징
>* HTTP 통신방식은 Stateless의 특징을 띠고 있어서, Client쪽에 서버에 접속한 기록을 저장하는 것
>* Cookie를 바탕으로 다음번에 빠르게 접속할 수 있음
```java
Cookie idcookie= new Cookie("cnt", "1"); // 1. 쿠키 생성
idcookie.setMaxAge(-1); // 2. 쿠키 최대 한계치 지정
response.addCookie(idcookie); // 3. client에 쿠키 저장
Cookie[] cookies = request.getCookies(); // 쿠키에 대한 모든 정보 꺼내오기!!
```

## Session

> 특징
>* 서버쪽에 저장하는 Client에 대한 정보
>* 단, Client가 접속을 해제하면 세션은 소멸된다!!!
```java
HttpSession session = request.getSession(false); // 세션이 있다면 이전세션, 없으면 null
HttpSession session = request.getSession(); // 세션이 있다면 이전 세션, 없으면 새로운 세션 생성
// 세션 꺼내기
if(session.isNew()) { // 세션이 새롭게 생성됫니?
    session.setAttribute("apple", new int[] {0}); // 만들고
    session.setAttribute("tomato", new int[] {0});
}
int []apple = (int[])session.getAttribute("apple"); // 그럼 꺼내오자!
session.invalidate(); // 사용한 세션에 대하여 모든 정보를 삭제 = 세션 무효
response.setHeader("pragma", "no-cache"); // 브라우저에 캐쉬정보 삭제, 브라우저 껏다 켰을때 저장된 정보 삭제해주기
```