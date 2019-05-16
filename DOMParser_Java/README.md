## 01-28 DOM(Document Object Model) parser를 이용한 xml parsing 작업

> 특징
>* 전체 xml의 네임태그를 트리구조로 하여 파싱이 가능하다!
>* 최소한의 객체만으로 xml 문서를 조작할 수 있다!

> *Code*

### 1단계 : 일단 기초정보를 가져오자
```java
public static void parse() {
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance(); // 1. dbf 객체 생성
    String url = "http://rss.etnews.com/Section902.xml"; // 2. xml 데이터 정보가 담긴 url
    DocumentBuilder parser = dbf.newDocumentBuilder();  // 3. paser 객체 생성
    Document doc = parser.parse(url); // 4. xml이 담긴 url 파싱
    Element root = doc.getDocumentElement(); // 5. root 객체 생성
    NodeList nl = root.getElementsByTagName("item"); // 6. 특정 태그를 검색해서 리스트로 반환!
}
``` 
### 2단계 : 맛깔나게 쓰면 된다~!
```java
public static void getNode(Node nl){
    String title = null;
    String urls = null;
    String dec = null;
    String pubDate = null;
    for (Node ch = item_n.getFirstChild(); ch != null; ch = ch.getNextSibling()) { // 해당 Node에 자식들 순차 접근 방식
        if (ch.getNodeName().equals("title"))
            title = ch.getFirstChild().getNodeValue();
        else if (ch.getNodeName().equals("link"))
            urls = ch.getFirstChild().getNodeValue();
        else if (ch.getNodeName().equals("description"))
            dec = ch.getFirstChild().getNodeValue();
        else if (ch.getNodeName().equals("pubDate"))
            pubDate = ch.getFirstChild().getNodeValue();
        }
	System.out.println(title + urls + dec + pupDate);
}
```
