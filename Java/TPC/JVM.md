# 자바의 구동방식(JVM)

### ***1-1. JVM이란?***

Java Virtual Machine의 줄임말

직역하면 '자바를 실행하기 위한 가상 기계(컴퓨터)'라고 할 수 있다

Java 는 OS에 종속적이지 않다는 특징을 가지고 있다. 

OS에 종속받지 않고 실행되기 위해선 OS 위에서 Java 를 실행시킬 무언가가 필요하다. 
그게 바로 JVM이다.
즉, OS에 종속받지 않고 CPU 가 Java를 인식, 실행할 수 있게 하는 가상 컴퓨터이다.

![https://images.velog.io/images/rlawlsdnr03/post/b192ab7c-177f-4312-a8e9-f41c4117fb16/%EB%8B%A4%EC%9A%B4%EB%A1%9C%EB%93%9C.png](https://images.velog.io/images/rlawlsdnr03/post/b192ab7c-177f-4312-a8e9-f41c4117fb16/%EB%8B%A4%EC%9A%B4%EB%A1%9C%EB%93%9C.png)

***1-2. 컴파일 과정***

Java 소스코드, 즉 원시코드(*.java)는 CPU가 인식을 하지 못하므로 기계어로 컴파일을 해줘야한다.

```
??? : 기껏 컴파일해서 줬는데, 아 내 컴퓨터에서는 안 돌아가면, 이 C 프로그래밍!!
```

하지만 Java는 이 JVM 이라는 가상머신을 거쳐서 OS에 도달하기 때문에 
OS가 인식할 수 있는 기계어로 바로 컴파일 되는게 아니라, 
JVM이 인식할 수 있는 Java bytecode(*.class, 클래스파일)로 변환된다.

```
자바 코딩 -> 컴파일( 바이트코드 생성 = '자바코드와 기계어의 중간단계 언어' ) 
-> Hello.java 코딩 -> javac (자바 컴파일러)를 통한 컴파일 -> Hello.class 생성
																       * 여기서 '.class' 파일 = '바이트 코드'

여기서 생성된, 바이트코드(.class)를 JVM에 주면, 바이트코드를 기계어로 번역
```

### *자바를 컴파일해서 .class(바이트 코드)를 JVM에 넘겨주면 기계어로 번역*

💡***여기서 Java compiler는 JDK를 설치하면 bin 에 존재하는 javac.exe를 말한다. 
(즉, JDK에 Java compiler가 포함되어 있다는 소리임 )
javac 명령어를 통해 .java를 .class(클래스파일)로 컴파일 할 수 있다***

변환된 bytecode는 기계어가 아니기 때문에 OS에서 바로 실행되지 않는다.

이 때, JVM이 OS가 bytecode를 이해할 수 있도록 해석해준다. 

따라서 Byte Code는 JVM 위에서 OS 상관없이 실행될 수 있는 것이다.

OS에 종속적이지 않고, Java 파일 하나만 만들면 어느 디바이스든 JVM 위에서 실행할 수 있다.

### ***1-3. 정리***

JVM의 구동순서

> 💡 
: **.java -----------javac.exe(컴파일)-----------> 
  .class 클래스파일---java.exe(실행)---> "Hello" 출력**
> 

JVM 요약정리

> 💡 
: **JVM은 Java로 짜서, 컴파일한 소프트웨어들을
어떤 종류의 컴퓨터에서든 실행할 수 있게 해준다!**
>