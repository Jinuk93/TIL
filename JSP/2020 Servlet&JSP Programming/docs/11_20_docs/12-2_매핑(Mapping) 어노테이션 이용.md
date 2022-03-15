# 12-2. 매핑(Mapping) 어노테이션 이용

## Case: annotation😍

`web.xml`을 이용한 mapping은 Servlet이 많아질수록 코드량이 많아지고 가독성이 떨어지므로 비효율적이다.

이번은 Java EE의 annotation을 이용한 servlet mapping 해보겠다.

훨씬 간단하다. 아까 만들은 servlet위에 @WebServlet을 추가하면된다.

### mapping 정보 삭제

정확한 테스트를 위해 이전에 작성한 `web.xml`의 mapping 정보와 Servlet은 삭제하도록 한다.

![https://media.vlpt.us/images/ruddms936/post/a24542ae-f8fa-42fd-93ae-8423f04dc095/image.png](https://media.vlpt.us/images/ruddms936/post/a24542ae-f8fa-42fd-93ae-8423f04dc095/image.png)

![https://media.vlpt.us/images/ruddms936/post/6d34ea97-0040-4746-8674-d025d5f12bc9/image.png](https://media.vlpt.us/images/ruddms936/post/6d34ea97-0040-4746-8674-d025d5f12bc9/image.png)

### Servlet 생성

![https://media.vlpt.us/images/ruddms936/post/d9979a06-8916-4835-9c4e-b22da801113b/image.png](https://media.vlpt.us/images/ruddms936/post/d9979a06-8916-4835-9c4e-b22da801113b/image.png)

이번엔 annotation을 사용하므로 생성시 `Create Java EE 6 annotated class` 체크한다.

![https://media.vlpt.us/images/ruddms936/post/bce5dbf8-172e-4bd6-bcb3-2bb16ecb89ec/image.png](https://media.vlpt.us/images/ruddms936/post/bce5dbf8-172e-4bd6-bcb3-2bb16ecb89ec/image.png)

> Create Java EE 6 annotated class를 체크하지 않아도 기능은 동작하지만 체크하게되면 IDE에서 자동으로 필요한 속성을 불러오기 때문에 편리하다.
> 

### Servlet Test Code 작성

아까와 동일하게 작성한다.

### Servlet Mapping

- @WebServlet
    - name: `web.xml`의 `<servlet-name>`와 일치함.
    - urlPatterns: `web.xml` `<url-pattern>`와 일치함.

![https://media.vlpt.us/images/ruddms936/post/c2c137d9-1969-402e-8b41-74da3d56e6b5/image.png](https://media.vlpt.us/images/ruddms936/post/c2c137d9-1969-402e-8b41-74da3d56e6b5/image.png)

### 실행

동일하게 실행되는 것을 확인할 수 있다.

![https://media.vlpt.us/images/ruddms936/post/4642bc80-edb8-49bd-8c16-70613fc0e581/image.png](https://media.vlpt.us/images/ruddms936/post/4642bc80-edb8-49bd-8c16-70613fc0e581/image.png)