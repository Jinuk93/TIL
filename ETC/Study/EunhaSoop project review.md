# EunhaSoop Project CodeReview

### 🔥 코드리뷰가 많이 틀릴 수 있습니다. 계속해서 수정될 문서입니다.

## 📌 상품에 대한 정보를 가져오기 위해 DB를 갔다오는 방법

### MVC2 model

![Untitled](%E1%84%8F%E1%85%A9%E1%84%83%E1%85%B3(MVC%20m%20ea8fe/Untitled.png)

### 📌중간에서 한번 점검하는 DB를 갔다오는 방법

<aside>
📌 **( 사용자 : View에서 Jsp ( ajax → url ) )** → **Controller(Servlet : 자바코드, 비즈니스 로직처리, 모델 호출((데이터요청))**

**JSP(사용자 요청) →**
**Controller → Service(interface) → ServcieImpl(Service 구현 한 친구 = Service) → DAO(interface) → Mybatis(DAO 구현한 친구 = DAO) → Mapper**  

*여기서 Interface는 없다고 보면 된다 쉽게 요약정리를 한다면!!*

- **요청 순서**
    - **JSP → Controller → Serviceimpl(Service) → Mybatis(DAO) → Mapper**
- **Return 순서**
    - **Mapper → Mybatis(DAO) → Serviceimpl(Service) → Controller → JSP**

**MVC2 model은 M(model) V(View, JSP) C(Controller, Servlet)로 구성되있다**

- **JSP → Controller → Serviceimpl(Service) → Mybatis(DAO) → Mapper**

여기서  **Serviceimpl(Service) → Mybatis(DAO) → Mapper는 Model이다**

- DAO는 Interface이고, DAO를 구현한 DAOMybatis 즉, Mybatis가 DAO의 역할을 한다
라고 생각하면 되는데, 
Mybatis는 DB랑 연결하는 클래스이자, Mapper(SQL문 작성하는)랑 연결된다
</aside>

---

## 사용자가 데이터를 요청하고, 가져오기까지의 과정을 시작해볼까?

### JSP ( Java in html )

- **JSP 안에 자바스크립트를 구성하였다.**

### 사용자(User)가 어떤 정보를 요청하기 위해 View(JSP)에서 어떤걸 클릭했어!

![Untitled](%E1%84%8F%E1%85%A9%E1%84%83%E1%85%B3(MVC%20m%20ea8fe/Untitled%201.png)

- **47line에서 $(function() { 을 통해 ‘온로드’ 가 실행되면**
- **48line의 aJax가 실행된다**
- **aJax 실행될 때 가장 먼저 실행되는 것은 url로 이동하는 것이다.**

### 스크립트 언어로 작성된 JSP에서 Onload를 통해, ajax가 실행됬어! url GOGO!!

![Untitled](%E1%84%8F%E1%85%A9%E1%84%83%E1%85%B3(MVC%20m%20ea8fe/Untitled%202.png)

- **url에서 shopping 컨트롤러의 getBeanList로 보낸다 ( jsp → Controller[servlet] )**

### JSP에서 사용자가 요청을 해서 Controller(Servlet)로 왔어!!

![Untitled](%E1%84%8F%E1%85%A9%E1%84%83%E1%85%B3(MVC%20m%20ea8fe/Untitled%203.png)

- **원두(BeanList) 버튼을 클릭하였을 때, 가장 먼저 실행되는 url 이다**

### Controller(Servlet)의 코드를 한 번 살펴보자!!

![Untitled](%E1%84%8F%E1%85%A9%E1%84%83%E1%85%B3(MVC%20m%20ea8fe/Untitled%204.png)

### Controller에서 Servie(Interface)로 보낼거야!

![Untitled](%E1%84%8F%E1%85%A9%E1%84%83%E1%85%B3(MVC%20m%20ea8fe/Untitled%205.png)

- **service의 BeanList로 간다 (controller에서 service로 왔다)**

### Service(Interface) 코드확인!

![Untitled](%E1%84%8F%E1%85%A9%E1%84%83%E1%85%B3(MVC%20m%20ea8fe/Untitled%206.png)

### Service는 인터페이스네? 그럼 인터페이스를 구현할 친구를 찾을꺼야!

![Untitled](%E1%84%8F%E1%85%A9%E1%84%83%E1%85%B3(MVC%20m%20ea8fe/Untitled%207.png)

- **이 친구는 interface이다. 이 interface를 구현해준 친구를 찾아보자!**

### Serviceimpl 이라는 이름을 가진 친구가 Service(Inteface)를 구현한 친구라고!!

![Untitled](%E1%84%8F%E1%85%A9%E1%84%83%E1%85%B3(MVC%20m%20ea8fe/Untitled%208.png)

- **interface를 구현해준 친구를 찾았다! 여기서 위의 원두(BeanList)를 찾아보자 (getBeanList)**

### Serviceimple에서 DAO로 갈거야!!

![Untitled](%E1%84%8F%E1%85%A9%E1%84%83%E1%85%B3(MVC%20m%20ea8fe/Untitled%209.png)

- **BeanList를 DAO.getBeanList로간다 ( Service → DAO )**

### DAO로 와보니깐 이 친구도 Interface 잖아?! 이 친구를 구현한 친구도 찾아보자!

![Untitled](%E1%84%8F%E1%85%A9%E1%84%83%E1%85%B3(MVC%20m%20ea8fe/Untitled%2010.png)

- **DAO 또한 interface이다. 이 친구를 구현한 친구를 찾아보자!**
- **위의 사진보니깐 DAOMybatis가 DAO를 구현해 주었다.  ( DAO → Mybatis 로 갈 것!)**

### DAO(Interface)를 구현해주는 Mybatis라는걸 찾았어!!

![Untitled](%E1%84%8F%E1%85%A9%E1%84%83%E1%85%B3(MVC%20m%20ea8fe/Untitled%2011.png)

- **DAO → Mybatis**

### 나, Mybatis SQL과 연동하기 위한 사나이지! 그럼 Mapper로 한번 가볼까?

![Untitled](%E1%84%8F%E1%85%A9%E1%84%83%E1%85%B3(MVC%20m%20ea8fe/Untitled%2012.png)

- **Mybatis를 보니깐 Mybatis가 DB랑 직접적으로 연동해주는 친구라는 것을 알 수 있다**

**( Mybatis가 Mapper로 보내 줄 것! )**

### Mapper에서 왔어! 이제, DTO로(를 통해) return 시켜주기 위한 과정 
즉, 사용자가 요청한 데이터를 받았어! 이제 이걸 집으로 다시 가져가자!!

![Untitled](%E1%84%8F%E1%85%A9%E1%84%83%E1%85%B3(MVC%20m%20ea8fe/Untitled%2013.png)

- **이렇게 Mybatis가 Mapper로 보내주어서 날라왔다!**
- **드래그 된 코드를 잘 보면, resultType = “shopping”이란 코드가 있다 이게 무엇일까?**

### Mapper에서 적힌 코드가 무슨 의미인지 알려면, mybatis-config.xml 환경설정 파일을 확인해보자!

![Untitled](%E1%84%8F%E1%85%A9%E1%84%83%E1%85%B3(MVC%20m%20ea8fe/Untitled%2014.png)

![Untitled](%E1%84%8F%E1%85%A9%E1%84%83%E1%85%B3(MVC%20m%20ea8fe/Untitled%2015.png)

- **한 블록 위의 사진을 보면 resultType이 shopping이라 적혀있는것을 볼 수 있다**
- **이게 무엇인지 확인하려면, 사진 좌측을 보면 spring 패키지 안의 mybatis-config.xml 환경설정 파일이 있다**
- **alias 별명이 shopping인 친구의 원래 이름을 보면, shopping.bean.ShoppingDTO이다**
- **이는 DTO에 담아서 정보를 보내줄 것(return)이라는 뜻인다**
- **현재까지의 상황을 정리해보면, User(사용자)가 어떤 상품을 클릭했다 (요청) →**
- **요청 ( Controller → Service(interface) → ServiceImpl(inter 구현) → DAO(interface) → Mybatis(DAO(inter) 구현) → Mapper 이렇게 사용자가 요구한 데이터를 요청하기 위해 SQL 집 앞까지 찾아왔다.. ( 데이터좀 듀세요... 안그럼 뚁땅해... )**
- **Mapper에서 “ 나는 DTO란 박스에 정보를 받아서 가져갈 꼬야!! “ 라는 해석이다**
- **참고로 DTO는 비즈니스 로직이 없는 getter, setter만 있는 친구이다.**
- **DTO를 ( 데이터를 주고 받고 할 수 있는 박스 ) 로 보면 굉장히 좋을 듯 싶다**

### DTO라는 박스의 생김새

![Untitled](%E1%84%8F%E1%85%A9%E1%84%83%E1%85%B3(MVC%20m%20ea8fe/Untitled%2016.png)

- **자! 사용자가 요청한 데이터를 받아갈 DTO란 박스를 자세히 살펴볼까?!**
- **DTO는 위에서 말한대로 getter, setter밖에 없는 친구야!**
- **근데 여기는 getter, setter란 친구가 안쓰여있는데?**
- **맞아 위에 어노테이션(Annotation) 골뱅이Data 가 보일꺼야!**
- **그 친구가 getter, setter를 안써도 되게끔 도와주는 Lombok이란 친구야!**

### Mapper에서 집으로 되돌아가려고, Mybatis에 왔어! 근데 여기서 List<ShoppingDTO>라는 코드를 한번 살펴보자!

![Untitled](%E1%84%8F%E1%85%A9%E1%84%83%E1%85%B3(MVC%20m%20ea8fe/Untitled%2017.png)

- **List<shoppingDTO은 return형 type이다. 자바문법으로 치자면, 만약 저기에 String이 써있다면
String 타입으로 return할 데이터가 있다는 뜻이다!**
- **그럼 여기서는 shoppingDTO 라는 타입의 return 데이터가 존재한다는 뜻인데, 이 데이터가 여러개라서 List에 담아서 보내는 것이다!**
- **돌아 갈때는, interface로 가지 않는다! interface는 틀만 잡아주는 친구이기 때문에, 안 돌아가!**

- **Mybatis에서 돌아갈 때는 Controller로 돌아간다 (바로(?))**

### Controller 왔어!!

![Untitled](%E1%84%8F%E1%85%A9%E1%84%83%E1%85%B3(MVC%20m%20ea8fe/Untitled%2018.png)

- **우선 여기 써있는 ResponseBody 가 무엇일까?**
    - **ResponseBody는 Ajax로 컨트롤러에 왔을 때 써준데!!**
    - **쉽게 말하면, 우리가 ajax에서 url를 통해 컨트롤러로 왔잖아!!**
    - **여기서 ResponseBody를 써주면 나를 처음에 부른놈한테 다시 되돌아가는거야!!**
    - **그럼 여기서 ResponseBody 즉, 나를 처음 부른놈이 누구였을까? 기억하지?**
    - **맞아, JSP (스크립트 언어) 안에 ajax가 url를 통해 나를 불렀었어!!**
    

### 그럼 Jsp 안의 Ajax로 가볼까?
나 다시 JSP로 요청한 데이터를 가지고 돌아왔어!!

![Untitled](%E1%84%8F%E1%85%A9%E1%84%83%E1%85%B3(MVC%20m%20ea8fe/Untitled%2019.png)

- **데이터를 가지고 오는데 까지 성공한다면 ajax 안에 있는 success 가 실행된다**

---

### *each문 공부해야된다 (제이쿼리문)*

![Untitled](%E1%84%8F%E1%85%A9%E1%84%83%E1%85%B3(MVC%20m%20ea8fe/Untitled%2020.png)

- **여기는 DOM문법으로서, append할 때 자주 쓰인다**
- **여기서부터는 DB에서 가져온 데이터를 뿌려주는 곳이라고 생각하면 좋다!**

### *Spring Setting도 공부해야 된다*

![Untitled](%E1%84%8F%E1%85%A9%E1%84%83%E1%85%B3(MVC%20m%20ea8fe/Untitled%2021.png)

- **DAO(interface)를 구현한 DAOMybatis(Mybatis)에서 return에 sqlSession.selectOne이라고 쓰여있다. 이렇게 쓰면 Mapper로 가서 처리하게끔 되있는데,**
- **사실, 이렇게 Mapper로 알아서 가게끔 해주는 setting(환경설정)이 매우 힘든부분이다**
- **처음 프로젝트를 만들 때, 한 번 만들면 편하지만 이 한 번이 굉장히 힘들다고 한다**

### 환경설정1. db.properties

![Untitled](%E1%84%8F%E1%85%A9%E1%84%83%E1%85%B3(MVC%20m%20ea8fe/Untitled%2022.png)

### 환경설정2. SpringConfiguration.java

![Untitled](%E1%84%8F%E1%85%A9%E1%84%83%E1%85%B3(MVC%20m%20ea8fe/Untitled%2023.png)

### 바로가기 느낌(?)

![Untitled](%E1%84%8F%E1%85%A9%E1%84%83%E1%85%B3(MVC%20m%20ea8fe/Untitled%2024.png)

### data : ‘’ 이 놈좀 들고가줘~~

![Untitled](%E1%84%8F%E1%85%A9%E1%84%83%E1%85%B3(MVC%20m%20ea8fe/Untitled%2025.png)

- **ajax 아래를 보면, data : 가 있는데, 이것은 ajax가 url로 갈 때, data : 우측에 있는놈들 좀 데리고 가줘~ 로 보면 된다.**

### jsp(ajax) → Controller에서 너(jsp)가 필요한 데이터가 뭔지 나도 알겄다~~

![Untitled](%E1%84%8F%E1%85%A9%E1%84%83%E1%85%B3(MVC%20m%20ea8fe/Untitled%2026.png)

- **Controller를 보면 @RequestParam이 있다 이게 무슨뜻인가?**
- **ajax를 보면 필요한 데이터가 뭔지 보내주는 data : 문이 있다. 이것은 사용자가 필요한 데이터가 뭔지 Mapper까지 들고가야되기 때문에 @RequestParam이 그게 무엇인지 받는 것이다**

**예를 들어,** 

**부모님이 이제 막 첫 심부름을 하는 자식에게 우유를 사오라고 시켰다. 하지만 아이는 이것을 까먹을 수 도 있으니 종이에 ‘우유’라고 적었다.**

![Untitled](%E1%84%8F%E1%85%A9%E1%84%83%E1%85%B3(MVC%20m%20ea8fe/Untitled%2027.png)

- **위의 예시에서 나온, ‘우유’가 여기선 productCode인 셈이다**
- **productCode를 가지고 shoppingServcie(서비스) 안에있는 ClickImg(메소드)로 가라! 이거다**

**마치 메이플 스토리를 보면, 이 장작 50개를 컨닝시티 안에있는 ‘다크로드’에게 가져다주시오**

**라는 느낌으로 보면 좋을 것 같다**

### “shopping.ClickImg” 너는 누구니?

![Untitled](%E1%84%8F%E1%85%A9%E1%84%83%E1%85%B3(MVC%20m%20ea8fe/Untitled%2028.png)

- **여기 Mybatis (DAO) 에서 sqlSession.selectOne(”shoppingSQL.clickImg”, ~)에서**
- **”shoppingSQL.clickImg” 는 무엇일까?**
- **이것이 무엇인지 알려면 Mapper로 가야된다 (Mapper에서 최상단으로 스크롤을 올려보자)**

![Untitled](%E1%84%8F%E1%85%A9%E1%84%83%E1%85%B3(MVC%20m%20ea8fe/Untitled%2029.png)

- **우선 위의 사진과 하나 더 위의 사진을 같이 보면서 알아보자!**
- **Mapper에서 namespace는 “shoppingSQL”이고**
- **Mybatis에서 selecOne 다음에 씌여진것은 shoppingSQL . clickImg 이다**
- **shoppingSQL은 Mapper라고 본다(namespace) 그리고 Mapper안에**
- **.(점) = id 이므로, id가 clickImg인 곳으로 찾아가라! 라는 뜻이다**

❓ 42: 12

---

### 매장찾기

![Untitled](%E1%84%8F%E1%85%A9%E1%84%83%E1%85%B3(MVC%20m%20ea8fe/Untitled%2030.png)

- **지도는 API를 가져와서 쓰되, 자바스크립트로 구성되있을 것이다.**
- **매장 위치는 DB에 저장되있는 것을 가져다 쓴다.**
