## 01.29 Gson 라이브러리를 이용한 json 파싱

> 특징
>* 사회에서 주로 주고 받는 데이터 형식은 json을 따른다. ex) REST API (data 포맷)
>* 주고 받는 패킷에서 순수히 데이터만 뽑기 위해 사용한다

>* 1.Json 데이터를 파싱해보자!!
```java
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.Gson;

public static void parse() {
    String json = "{ 'hi': { 'gogo' : 'nono'}}"; // 1.json형식 데이터를 받았다
    JsonParser parser = new JsonParser(); // 2.parser 만들기
    JsonObject obj = parser.parse(json).getAsJsonObject(); // 3.파싱해서 jsonObject로 뽑자!!
    JsonObject hi = obj.get("hi").getAsJsonObject(); // 4.해당 key값을 다시 Object로 뽑기
    System.out.println(hi);

    // java object로 바꾸기
    Gson = new Gson(); // 1.GSON 객체 선언
    Person p = gson.fromJson(json, Person.class); // 2.클래스로 파싱하기
}
```
>* 2.Json 데이터를 만들어보자
```java
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public static void makeJson() {
    Person p = new Person(123, "kim", "seoul"); // 1.객체 생성
    GsonBuilder gb = new GsonBuilder(); // 2.빌더 생성
    gb.setPrettyPrinting(); // 3.이쁘게 포맷팅
    Gson gson = gb.create(); // 4. Gson으로 빌더로 생성
    
    String str = gson.toJson(p); // 5.json으로 바꾸자!!!
    System.out.println(str);
}
```