# section2 스프링 웹 개발 기초

## 정적 컨텐츠

### 1. 정적 컨텐츠

- ***파일 그대로 뿌려주는 것을 의미한다***

*스프링 부트는 Controller(C)와 View(V)가 Mapping이 안되있으면, 
정적 컨텐츠 그 자체를 뿌려준다*

### 2. MVC와 템플릿 엔진

- ***서버에서 변형을 해서 html 으로 내려주는 방식***

MVC는 Model(데이터) View(JSP단) Controller(컨트롤러)로 구분된다

@RequestParam이라는 어노테이션(Annotation)을 사용하여 파라미터(인자)를 받을 수 있다.

![Untitled](https://user-images.githubusercontent.com/80089860/163218641-66ed70cf-2cea-4be7-96cc-47424e254f62.png)

### 3. API

- ***JSON이라는 데이터 구조 포맷을 이용해서 클라이언트한테 전달해주는 방식을 요즘 API방식이라고 부른다.***

![Untitled 1](https://user-images.githubusercontent.com/80089860/163218658-c08a1539-e71c-475b-997d-706a733f0aa8.png)
