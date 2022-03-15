# 12-1. 매핑(Mapping) Web.xml이용

---

출처 : [https://velog.io/@ruddms936/Servlet-Mapping-cqqwi4v9](https://velog.io/@ruddms936/Servlet-Mapping-cqqwi4v9)

## Case: web.xml

### Servlet 생성

servlet을 하나 생성한다.

![https://media.vlpt.us/images/ruddms936/post/6833dda4-a91f-4d7b-9fe3-812b530c073f/image.png](https://media.vlpt.us/images/ruddms936/post/6833dda4-a91f-4d7b-9fe3-812b530c073f/image.png)

- annotation을 사용하지 않기 위해 생성시 `Create Java EE 6 annotated class` 의 체크박스는 해제한다.
- 이유은 모르겠지만. 패키지로 구분하지 않으면 `url-pattern`이 실패한다. 패키지를 지정하도록 하자.

![https://media.vlpt.us/images/ruddms936/post/7d5cb018-73d8-4b3e-8188-807f08ef8766/image.png](https://media.vlpt.us/images/ruddms936/post/7d5cb018-73d8-4b3e-8188-807f08ef8766/image.png)

그러면 자동으로 IntellJ에서 기초적인 servlet-mapping 스키마가 자동완성해 준다.

![https://media.vlpt.us/images/ruddms936/post/ce7e4768-cc05-4be3-bc01-dc8f0cca2b95/image.png](https://media.vlpt.us/images/ruddms936/post/ce7e4768-cc05-4be3-bc01-dc8f0cca2b95/image.png)

### Servlet Test Code 작성

먼저, mapping 확인을 위해, PrintWriter를 추가하여 간단한 문장을 적어준다.

```
import java.io.PrintWriter;

PrintWriter out = response.getWriter();
out.println("<p>Servlet Test</p>");
```

![https://media.vlpt.us/images/ruddms936/post/80218746-fb6c-4062-ada9-18f87c967f66/image.png](https://media.vlpt.us/images/ruddms936/post/80218746-fb6c-4062-ada9-18f87c967f66/image.png)

### Servlet Mapping

이제 web.xml에서 mapping 해보도록 하겠다.

- `<servlet-name>`은 이 servlet의 별칭이기 때문에 임의로 바꿔주어도 된다.
- `<servlet-class>`는 이 servlet의 저장위치이다.

servlet mapping을 해주려면, `<servlet></servlet>`아래에 `<servlet-mapping></servlet-mapping>`을 추가해준다.

- `<servlet-mapping>`의 `<servlet-name>`은 위의 `<servlet></servlet>`의 `<servlet-name>`과 같은 값이 들어가야한다.
- `<url-pattern></url-pattern>`은 해당 servlet의 경로를 간단히 나타내주는 것이다. **이 값을 브라우저 url 뒤에 추가해주는 것이다.**

![https://media.vlpt.us/images/ruddms936/post/4d90822c-b264-4b9f-8cf9-a5aedf8b2bd8/image.png](https://media.vlpt.us/images/ruddms936/post/4d90822c-b264-4b9f-8cf9-a5aedf8b2bd8/image.png)

> 위의 mapping 정보로는 /test를 입력하면 해당 서블릿이 실행되는것이다.
> 

---

### 실행

정상적으로 실행되는 것을 확인할 수 있다.

![https://media.vlpt.us/images/ruddms936/post/b94dd7f6-018a-4de9-aa9e-60b4eacfd90b/image.png](https://media.vlpt.us/images/ruddms936/post/b94dd7f6-018a-4de9-aa9e-60b4eacfd90b/image.png)