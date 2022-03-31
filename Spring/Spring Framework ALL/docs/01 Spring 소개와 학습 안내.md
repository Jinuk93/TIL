# 01 Spring 소개와 학습 안내

### 1. 스프링 주요 기능

### Dependency Injection(D.I)

> 스프링 프레임워크의 핵심 기능
> 

### Transaction management

> 트랜잭션을 관리해주는 것
> 

---

### 2. 기업형 응용 프로그램을 보조하기 위한 쉬운 프레임워크

### Java EE

- 분산형, 기업형 응용 프로그램 개발을 위한 API
- 결합력을 낮추는 DI, DB Transaction처리, 로그 처리....

### Java SE

- 일반적인 로컬 응용 프로그램 개발을 위한 API
- 파일 I/O, 콘솔 I/O, 윈도우 I/O, 네트워크 I/O, Thread, ....

> Java EE를 대신해서 Spring이 사용된다고 생각하면 됨.
> 

> Java SE + Spring 을 사용하여 웹개발
> 

Java EE(**Enterprise Edition)**와 함께 사용하는 경우도 있지만

Java EE의 대부분의 기능을 Spring으로 사용가능하다

---

### 3. 웹을 위한 스프링 프레임워크 모듈

### MVC ← DI를 활용 ← 느슨한 결합력과 인터페이스

### 트랜잭션 ← AOP을 활용

### 인증과 권한 ← Servlet Filter를 활용

---

1. ***Interface***

**서로 상관없는 객체들이 특정 service를 사용하려 할 때, 그 service가 요구하는**

**기능을 구현 및 재정의 한 후 사용하려는 것이다**

**이 때, service가 요구하는 기능이 interface**

**interface는 반드시 함수의 몸체가 비어야 하고, 이를 구현하는 쪽에서 override 할 것**

1. ***Transaction Management***

**Transaction이란, 작업이 한 번 작동할 때마다 움직이는 ‘처리단위’를 뜻한다**

- **Atomicity** : 전체 작업이 모두 성공하거나, 모두 실패해야만 한다
- **Consistency** : data 일관성을 위해 primary key가 table에 존재해야 한다
- **Isolation** : 트랜잭션 processing 시, 동일한 시간내에 중복된 data set이 작업될 수 있다

data corruption을 막기 위해 각 transaction은 고

- **Programmatic** : 프로그래밍 방식으로 우리가 직접 제어한다. 매우 유연하나, 유지가 어렵다
- **Declarative** : 우리는 annotation을 통한 제어 혹은 XML파일 설정 기반으로한 제어만 수행하면 된다 이 방식은 덜 유연하나, Spring AOP를 통해 모듈화가 더 쉽다는 장점이 있다