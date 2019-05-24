### 웹 어플리케이션

> 특징
>* 3 Tier Architecture = Client + Server + Data
>* Client는 웹 브라우저(HTML + CSS + Javascript= **클라이언트 스크립트** ), Server는 jsp(**서버 스크립트**), Data는 DB(**Database** = ex)mysql) 
>* 1. Client Script는 소스가 공개되서 보임
>* 2. Server Script는 소스가 공개되지 않음

### 서버 스크립트 중에서 Servlet 과 JSP의 차이?
> Servlet
>* 1. 자바 코드로 구현하고 컴파일해서 배포해야 된다
>* 2. 코드가 수정되면 다시 컴파일해야 됨!!!

> JSP
>* 1. HTML처럼 태그를 사용하여 자바코드를 사용할 수 있다
>* 2. <% %> 태그안에 java 코드를 작성

> 현재 MVC 패턴 모델 구조
>* 과거에는 Model 1(**only JSP**)구조로 작성했지만,
>* 현재는 유지보수가 용이한 Model 2(**JSP Servlet 구조**)로 작성중이다
>* View = JSP, Controller = Servlet
>* 보여지는 부분은 **JSP**, 데이터를 넘겨주는 부분은 **Servlet**

### Servlet
> 특징
> 전체로직은 1.init() -> 2.service() -> 3.destroy()
>* 1.init : *Tomcat*이 해당 클래스를 인스턴스 객체 생성한다.( **처음 쓰레드에만 수행!!** )
>* 2.service : doGet()와 같은 메소드를 통해 로직을 수행한다.
>* 3.detroy : 모든 작업이 끝나면 객체 소멸하여 **가비지 컬렉터**가 이를 수집해간다.

### Redirect와 Forward방식 그리고 Include의 차이
>* Redirect는 클라이언트로부터 받은 request객체를 전달하지 못함
>* 반면에, Forward 방식은 클라이언트로부터 받은 request객체를 전달한다
>* Include는 해당 페이지에 연동할 페이지를 포함한다!!!!
> 1.Forward
```java
    RequestDispatcher dispatcher = request.getRequestDispatcher("Result"); // 화면 넘길 준비
    request.setAttribute("city", "osaka"); // data 저장
    request.setAttribute("age", "22"); // data 저장
    dispatcher.forward(request, response); // 화면 넘김
```
> 2.Redirect
```java
    response.sendRedirect("Result");
```
> 3.Include
```java
    RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/result.jsp"); // 화면 넘길 준비
    dispatcher.include(request, response);
```
