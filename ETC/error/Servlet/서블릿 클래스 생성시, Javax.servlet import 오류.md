# 서블릿 클래스 생성시, Javax.servlet import 오류

---

![https://blog.kakaocdn.net/dn/brauzv/btqDKUikFgi/9pWs07jVlRZI84mG1JnjxK/img.png](https://blog.kakaocdn.net/dn/brauzv/btqDKUikFgi/9pWs07jVlRZI84mG1JnjxK/img.png)

**이클립스에서 HttpServlet 를 사용하려고 할때 javax.servlet import가 안될때가 있다.**

**이런 오류가 발생하는 이유는** 

**이클립스 내 프로젝트에 Server 라이브러리가 설정이 안되어 있기 때문에 발생한다.**

**프로젝트 라이브러리 설정하는 방법은 아래의 그림대로 프로젝트 우클릭 해서** 

**Porperties 를 클릭한다.**

![https://blog.kakaocdn.net/dn/bN87UX/btqDNncvWsL/arlSrxmfgDudpDTM9n2Ez1/img.png](https://blog.kakaocdn.net/dn/bN87UX/btqDNncvWsL/arlSrxmfgDudpDTM9n2Ez1/img.png)

**Java Build Path 를 클릭하고 Libraries 를 들어온다.**

![https://blog.kakaocdn.net/dn/ehmTTE/btqDOHBw844/rAXL99tqXeHMxo8dOGiY20/img.png](https://blog.kakaocdn.net/dn/ehmTTE/btqDOHBw844/rAXL99tqXeHMxo8dOGiY20/img.png)

**Classpath 를 선택한다.**

![https://blog.kakaocdn.net/dn/bCStsq/btqDMGQVvdY/aS0eXDUWkkxwIwdH1qxANK/img.png](https://blog.kakaocdn.net/dn/bCStsq/btqDMGQVvdY/aS0eXDUWkkxwIwdH1qxANK/img.png)

**Add Libray... 를 클릭하고 Server Runtime 를 클릭한다.**

![https://blog.kakaocdn.net/dn/b1kNdZ/btqDKUbxyKj/ub6KQp5KILJDkMa25bEkYk/img.png](https://blog.kakaocdn.net/dn/b1kNdZ/btqDKUbxyKj/ub6KQp5KILJDkMa25bEkYk/img.png)

**내가 원하는 서버를 클릭하고 finish를 클릭한다.**

![https://blog.kakaocdn.net/dn/kNejk/btqDO1fthxE/akrijnw0YRCKq0RHcgx6k1/img.png](https://blog.kakaocdn.net/dn/kNejk/btqDO1fthxE/akrijnw0YRCKq0RHcgx6k1/img.png)

**추가한걸 확인하고 Apply and Close 를 선택한다.**

![https://blog.kakaocdn.net/dn/copDS2/btqDLEzygVC/Wph6sv0plQSnfSl9ovBJxk/img.png](https://blog.kakaocdn.net/dn/copDS2/btqDLEzygVC/Wph6sv0plQSnfSl9ovBJxk/img.png)

**다시 소스코드를 가보면 빨간 줄이 없어진것을 확인 할 수 있다.**

![https://blog.kakaocdn.net/dn/m6rWC/btqDL5jecSi/qqLTYC5jiQ8oo7CoxxtEek/img.png](https://blog.kakaocdn.net/dn/m6rWC/btqDL5jecSi/qqLTYC5jiQ8oo7CoxxtEek/img.png)

**오류를 해결하였다.**