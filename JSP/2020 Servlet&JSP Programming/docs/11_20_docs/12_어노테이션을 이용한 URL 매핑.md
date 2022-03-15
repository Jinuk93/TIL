# 12. 어노테이션을 이용한 URL 매핑

---

📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌📌

**이전에 URL을 서블릿에 매핑하기 위해서는 다음과 같이 web.xml에 매핑 정보를 입력했습니다.**

예시

web.xml 경로는 {프로젝트 경로}\WebContent\WEB-INF\web.xml 입니다.

```
<servlet>
	<servlet-name>hello</servlet-name>
	<servlet-class>com.seung.HelloServlet</servlet-class>
</servlet>
<servlet-mapping>
	<servlet-name>hello</servlet-name>
	<url-pattern>/hello</url-pattern>
</servlet-mapping>
```

**Servlet 2.* 에서는 web.xml 파일에서만 url 매핑이 가능했지만,** 

**Servlet 3.0이상에서는 어노테이션(Annotation)으로 매핑하는 것도 가능해졌습니다.**

**현재 저희는 4.0 버전을 사용하고 있습니다.**

**이번에는 매핑(Mapping) 정보를 servlet 클래스에서 할 수 있는 방법을 소개하겠습니다.**

📌

***여기까지 정리***

**어노테이션을 이용하기 전까지는 위의 코드처럼**

**Web.xml 파일에서 서블릿태그안에 가고자하는 url 주소(패키지명.클래스명)를 적음으로써**

**매핑(Mapping)하였다**

**하지만 @(어노테이션)을 통해서 매핑(Mapping)을 좀 더 간편하게 할 수 있다.**

---

### 📌매핑(Mapping)이란?

**특정 Servlet을 요청할 때, 전체 경로의 URL을 요청하면 복잡하고 보안에도 취약하기 때문에**

**간단하게 경로를 표현해주는 것이다.**

**Servlet 매핑 방법은 두 가지가 있다.**

**1. web.xml 이용**📌📌

[12-1. 매핑(Mapping) Web.xml이용 (1)](https://www.notion.so/12-1-Mapping-Web-xml-1-88466c883c4842488efb321576162c41)

**2. annotation 이용**📌📌

[12-2. 매핑(Mapping) 어노테이션 이용 (1)](https://www.notion.so/12-2-Mapping-1-9530fb534b804bafb0c9e5cce1ebea7d)

### 📌어노테이션(Annotation)이란?

- **Class(클래스) 혹은 Method(메소드)에 붙여지는 주석**
    - **일반적인 주석은 컴파일과정에서 사라져서 생략처리가 가능한데, 어노테이션은 컴파일해도 남게된다 그래서 더이상 Web.xml 파일에서 따로 매핑(Mapping)을 할 필요가 없다**
    

---

![Untitled](https://user-images.githubusercontent.com/80089860/158413160-ec66bd52-6f67-471b-9be4-58ce0d5222a9.png)

**어노테이션(Annotation) 사용시, web.xml에 가서**

**<web-app xmlns=” ~~~ metadata-complete="true"> 에서**

**"true"를 "false" 로 변경하여야 한다. → 매핑을 어노테이션에서도 하겠다!**

**true  → web.xml에서만 찾아라!**

**false → web.xml + 다른 곳 = 전부 뒤져봐라!**

**(설정을 web.xml 이외에도 어노테이션(Annotation)을 이용해서 설정한게 있으니, 잘 찾아봐라!)**

**쉽게 말해, false로 하면 Web.xml + Annotation도 읽게한다는 뜻이다!**

---

### Web.xml에서 matadata-complete=”false”로 바꾼 뒤,

false로 바꿨으니

이제 설정을 꼭 web.xml에서 할 필요가 없다

전에 입력했던 매핑정보를 주석처리한다

![Untitled 1](https://user-images.githubusercontent.com/80089860/158413184-dd842d1a-4c9f-40d8-9234-c4f3ccda4044.png)


![https://postfiles.pstatic.net/MjAyMTA2MTFfMjAz/MDAxNjIzMzg0MjQwODYx.C5MQHdaGeL3SJIgSZFccKtYeylZzODuZBor_4SCwQoUg.7-d8fHoRcchAhVYjXDy1ayhPXgmXcgGZSGBVemyIo6kg.PNG.ttb190926/image.png?type=w773](https://postfiles.pstatic.net/MjAyMTA2MTFfMjAz/MDAxNjIzMzg0MjQwODYx.C5MQHdaGeL3SJIgSZFccKtYeylZzODuZBor_4SCwQoUg.7-d8fHoRcchAhVYjXDy1ayhPXgmXcgGZSGBVemyIo6kg.PNG.ttb190926/image.png?type=w773)

![https://postfiles.pstatic.net/MjAyMTA2MTFfMjc0/MDAxNjIzMzg0Mjg2Mjcz.kUjScl02FO5Dt9FCndenbg3s-NPgg4aonzjEZWO8JrMg.Kl4oNCfRhNKBhxUxn1vQWUcA5W926lKpkbwR8ydBwi8g.PNG.ttb190926/image.png?type=w773](https://postfiles.pstatic.net/MjAyMTA2MTFfMjc0/MDAxNjIzMzg0Mjg2Mjcz.kUjScl02FO5Dt9FCndenbg3s-NPgg4aonzjEZWO8JrMg.Kl4oNCfRhNKBhxUxn1vQWUcA5W926lKpkbwR8ydBwi8g.PNG.ttb190926/image.png?type=w773)

매핑정보가 사라졌기 때문에

Nana를 실행하면 에러가난다

매핑정보가 없기때문에 황당하게도 서블릿이 갖고있는 클래스명을 갑자기 내보낸다

![https://postfiles.pstatic.net/MjAyMTA2MTFfMTQ1/MDAxNjIzMzg0MzE5MjA5.MiXiQtl4VkAzhgjGoufV-2pud7omkWZKuPTj3tPf3pgg.8vNq4tWH_OUraLo9hwADaupUKrU3nJH01gBRHCErICIg.PNG.ttb190926/image.png?type=w773](https://postfiles.pstatic.net/MjAyMTA2MTFfMTQ1/MDAxNjIzMzg0MzE5MjA5.MiXiQtl4VkAzhgjGoufV-2pud7omkWZKuPTj3tPf3pgg.8vNq4tWH_OUraLo9hwADaupUKrU3nJH01gBRHCErICIg.PNG.ttb190926/image.png?type=w773)

hello라고 하는 것으로는 더이상 호출할 수 없게 됐다

**매핑정보가 사라졌으니**

**매핑정보의 두번째방법 Annotation을 이용해 매핑을 해본다**

![https://postfiles.pstatic.net/MjAyMTA2MTFfMjU2/MDAxNjIzMzg0NDEzMzQ5.Iy7vLfVZKrpV6dLP85Kg41WNXcQwp2_AXZA2IQtz1mEg.i2QwOfXUAFvi5omEWjOPd8caFAVDPyjrp4I2ljuZSWsg.PNG.ttb190926/image.png?type=w773](https://postfiles.pstatic.net/MjAyMTA2MTFfMjU2/MDAxNjIzMzg0NDEzMzQ5.Iy7vLfVZKrpV6dLP85Kg41WNXcQwp2_AXZA2IQtz1mEg.i2QwOfXUAFvi5omEWjOPd8caFAVDPyjrp4I2ljuZSWsg.PNG.ttb190926/image.png?type=w773)

**/hello 라는 이름으로 매핑을 하면 전에했던 이름과 똑같기 때문에**

**제대로 되는건지 헷갈릴 수 있다**

![https://postfiles.pstatic.net/MjAyMTA2MTFfMjEx/MDAxNjIzMzg0NTA3NTgw.1q2s-Nr_x0oJlOyk1LvW7ZTaYClvT9uOlX5OhA3a9a8g.VwtKB1ONwAw_Za-EeKPVEsL_T2B-vtsXGe2UKpmNvOwg.PNG.ttb190926/image.png?type=w773](https://postfiles.pstatic.net/MjAyMTA2MTFfMjEx/MDAxNjIzMzg0NTA3NTgw.1q2s-Nr_x0oJlOyk1LvW7ZTaYClvT9uOlX5OhA3a9a8g.VwtKB1ONwAw_Za-EeKPVEsL_T2B-vtsXGe2UKpmNvOwg.PNG.ttb190926/image.png?type=w773)

**/hi 로 바꿔서 실행해본다**

![https://postfiles.pstatic.net/MjAyMTA2MTFfMTgx/MDAxNjIzMzg0NTg5NDEz.qNPwaUkkHkF5cvEUJ7Efy9OLBkrhkQuxDaq_TlYx-tgg.lbVsJMfhv1LlkErhbbERTztM5Ve7_KyXgUpqG6-tOmIg.PNG.ttb190926/image.png?type=w773](https://postfiles.pstatic.net/MjAyMTA2MTFfMTgx/MDAxNjIzMzg0NTg5NDEz.qNPwaUkkHkF5cvEUJ7Efy9OLBkrhkQuxDaq_TlYx-tgg.lbVsJMfhv1LlkErhbbERTztM5Ve7_KyXgUpqG6-tOmIg.PNG.ttb190926/image.png?type=w773)

**hi 라고 하는 url로** 

**전에 만들었던 서블릿클래스의 출력결과를 볼 수 있다**

**web.xml로도 설정이 가능하고**

**Annotation으로도 설정이 가능한데**

**어떤방법이 좋을까?**

**당연히 Annotation이 좋다**

**물론 코딩량이 적어서 깔끔하다고 볼 수도 있지만**

**기업형 어플리케이션을 만들때는 혼자가아닌 여럿이서 만들게되는데**

**각자 부여받은 프로그램이 서로 엉켜있는상태였으면 좋을까? 아니면**

**각자 깔끔하게 분리된 상태에서 업무를 받으면 좋을까?**

**web.xml에 매핑한다고 하면**

**만약 서블릿을 나눠서 만들경우 만드는 사람마다**

**web.xml을 손댈려고 할 것이다 어떻게보면 공유파일이기 때문이다**

**web.xml도 쪼개가지고 분배할 수 있긴 하다 그렇지만 설정파일이 쪼개지는것도 문제다**

**그래서 Annotation을 쓰게되면**

**각자 분업화된 내용들을 각자 처리할 수 있기때문에**

**훨씬 더 깔끔하게 협업을 할 수 있다**
