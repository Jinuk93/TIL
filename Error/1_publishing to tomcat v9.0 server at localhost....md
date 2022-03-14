# 1.publishing to tomcat v9.0 server at localhost...

# [1. publishing to tomcat v9.0 server at localhost... 에러 해결방법](https://dlagusgh1.tistory.com/316)

- Package Explorer > Servers > Tomcat v9.0 Server at localhost-config > Server.xml 우 클릭 > Properties > Location에서 해당 폴더 열기
- Server.xml 파일을 Code로 열기 한 후 Ctrl + F 눌러스 Context 찾기해서 가보면 동일한게 여러번 선언되어있다.
- Context를 한개만 남기고 중복되는 Context를 제거 한 뒤 저장하면 해결.