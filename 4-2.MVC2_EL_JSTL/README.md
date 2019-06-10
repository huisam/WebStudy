## EL

> 특징
>* Experssion Language : 웹 개발에서 속성값을 편하게 가져오기 위해서 사용하는 언어
> 내장 객체들
>* Scope : 해당 영역에 존재하는 Attribute와 이름과 객체
>* param : request.Parameter에 존재하는 객체와 동일
>* header : request.Header에 존재하는 객체와 동일
>* cookie : Servlet에 존재하는 쿠키 객체와 동일
```java
${param.id} // 1.접근자 : 파라미터 내장 객체의 id Attribute를 Get한다
${empty param.id} // 2.연산자 : 다른 것과 동일함,,, 다만 타당섬검사 empty가 있음 => param.id가 있으면 false, 객체 없으면 true
```

## Jstl

> 특징
>* Jstl(Jsp Standard Tag Library) : JSP에서 Tag를 생성하여 사용하기 위한 서비스를 제공하는 라이브러리
```html
<%@ taglib uri="http://java.sun.com/sjp/jstl/core" prefix="c" %> <!-- uri의 별칭을 c로 지정하자 -->
<c:set var="num" value="100"/>  <!-- 값을 가져오기!! 혹은 param객체 안에 것으로 불러들이기 -->
<c:set var="id" value="${param.id }"/>
<c:if test="${ empty id or empty pass }"> <!-- id 혹은 pass가 비어있다면 -->
	<c:redirect url="login.jsp"/>     <!-- 메인 페이지로 리다이렉트!! -->
</c:if>
<c:forEach items="${list2 }" var="idx"> <!-- 반복문을 쓰는 2가지 방법 -->
	${idx.num } : 
	${idx.name } : 
	${idx.address }<br>
</c:forEach>
<c:forEach begin="1" end="10" step="1" var="i"/>
<c:import url="Login.html"/> <!-- <%@ import %> 방식과 동일하다 -->
```

## Filter

> 특징
>* 사용자 인증 & 로깅에 대한 처리후에 서블릿을 호출하기 위해 사용하는 요소
>* chainFilter()를 통해서 연속적인 필터링 작업을 지시할 수 있다.

> 사용되는 용도
>* 웹 팝업창을 띄울 때
>* 데이터를 인코딩할 때
>* 세션 데이터를 인증할 때
```java
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    // 1.사전처리작업
    System.out.println("before...");
    chain.doFilter(request, response); // 2.해당 Servlet
    // 3.사후 처리작업
    System.out.println("after...");
}
```

## MVC Model Architecture

>1.Filter : 데이터 가공을 위한 filter 컴포넌트

>2.Controller : 필터로부터 받은 데이터를 해당 역할에 맞는 DAO로 가서 역할 수행

>3.Service Interface : Controller에게 어떠한 기능이 있는지 알려주기 위한 인터페이스

>4.DAO <- 인터페이스 상속 : Data에 대한 Access를 하기 위한 컴포넌트

>5.VO : 데이터 객체

> **해보면서 알게된 것들**
>* Requset와 Redirect의 정확한 사용 구분을 하자!
>* Redirect : 시스템(Session DB)의 변화가(*회원가입*) 생기는 경우에 대한 응답일 경우 -> Redirect로 응답!
>* Request : 단순조회(검색, 게시판)에 대한 응답일 경우 -> Request로 응답!
