### JSP에 대해 자세히 배워보자
> 특징
>* 주로 **프레젠테이션(View)** 역할을 담당하며, 웹을 동적으로 처리하는데에 유용하다


> 요소
>* 1. Directive Element : 웹 컨테이너에 특정한 정보를 전달하는 역할
>>* 1 - page Directive = 어떻게 처리할 것인가에 대한 정보를 전달
>> ```html
>> <% @page contentType='text/html; charset=UTF-8' %>
>> ```
>>* 2 - include Directive = 어떤 헤더파일을 참조할 것인가
>>* **import**를 제외하고는 한번씩만 사용가능
>> ```html
>> <% @include file='header.jsp' %> <!-- 이친구는(header가 바뀌면 계속 바뀐다) 복붙 효과 = 성능 구데기? -->
>> <% @import="java.util.*" %>
>> ```
>>* 3 - taglib Directive = 사용자가 만든 커스텀 tag를 사용할 때 
>> ```html
>> <% @taglib uri="WEB-INF/taglib.tld" prefix="soccer" %>
>> ```
>* 2. Scripting Element : jsp의 멤버필드나 메소드 선언 시 사용
>>* 1 - 선언
>>```html
>><%! String name = "Hong Hwi Jin"; %>
>>```
>>* 2 - 표현식
>>```html
>><%= name %>
>>```
>>* 3 - 스크립트렛(scriptlet) = 최소한으로 줄여야 성능이 **향샹**!!!!
>>```html
>><% for(int i = 0; i<=10; i++){
>>      out.println(i); %>
>>```
>* 3. Action 원소 : JSP 태그들 -> Scriptlet의 기능을 태그로 대신하는 역할
>> 1 - <jsp:include /> : 페이지 포함할 때, 한번만 복사해오기 때문에 성능이 조금 더 좋음
>>```html
>> <jsp:include />
>>```
>> 2 - <jsp:forward /> : Servlet의 forward기능을 그대로 간직하고 있다.
>>```html
>> <jsp:forward page="이동할 페이지"/>
>> <jsp:forward page=""> <jsp:param .../><!-- 파라미터 방식으로 value지정 해서 보냄 -->  </jsp:forward>
>>```
>> 3 - <jsp:useBean /> : 자바 객체를 생성하거나 기존에 이미 만들어진 객체를 리턴
>>```html
>> <jsp:useBean id="c" class="Car" scope="page"/> == <% Car c = new Car(); %>
>>```
>>```
>> jsp useBean 객체 생성시 생성자는 Default생성자로만 생성이 됨
>> jsp useBean으로 만든 객체는 scope(application,page,session) 특성으로 먼저 구분하고, id로 구분한다 !!
>> * application : 동일 앱 내, * session : 같은 client시(로그인) 객체가 공유,
>> * request : forward시 공유 될 때 사용 가능, * page : 같은 페이지 내
>>```