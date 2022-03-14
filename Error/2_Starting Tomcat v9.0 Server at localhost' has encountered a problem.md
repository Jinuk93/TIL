# 2.Starting Tomcat v9.0 Server at localhost' has encountered a problem

# [2. 'Starting Tomcat v9.0 Server at localhost' has encountered a problem에러 해결방법](https://dlagusgh1.tistory.com/316)

![https://blog.kakaocdn.net/dn/djPBOP/btqE9cn2DkB/IFXx188LxgZB073yLVgd31/img.png](https://blog.kakaocdn.net/dn/djPBOP/btqE9cn2DkB/IFXx188LxgZB073yLVgd31/img.png)

# 2-1. 첫번째 해결방법

- Servers의 Tomcat v9.0 Server at localhost 더블클릭 > Ports의 HTTP 항목 옆 Port Number 변경 8080 > 8081 등으로 변경 후 저장한 뒤 실행하면 해결.

# 2-2. 두번째 해결방법

- 상단에 Windows > Preferences > Runtime Environments > 해당 톰캣 선택 후 Remove > 새로 추가 Add > 버전 선택 등 진행 후 저장
- 실행하려는 패키지 우 클릭 > Propertise > Java Build Path 상단에 Librarise 클릭 > 아파치 톰캣 서버 라이브러리 잘 설치되어있는지 확인 후 실행.

( 라이브러리 적용 안되어있으면 패키지 실행 시 publishing to tomcat v9.0 server at localhost...' has encountered a problem 에러가 발생된다. )

- 라이브러리가 적용되어있지 않으면 해당 패키지 우 클릭 > Propertise > Targeted Runtimes > 해당 톰캣 클릭 후 적용해주면 된다.