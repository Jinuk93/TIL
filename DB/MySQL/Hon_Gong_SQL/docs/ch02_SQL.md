# ch02. 실전용SQL 미리맛보기

### 건물을 짓기 위한 설계도 : 데이터모델링

**데이터모델링은 테이블의 구조를 미리 설계하는 개념으로 건축 설계도를 그리는 과정과 비슷합니다**

**건물에서 설계도가 아주 중요하듯, 프로젝트에서도 데이터베이스 모델링이 잘 되어야 제대로 된 데이터베이스를 구축할 수 있습니다.**

**대표적으로는 폭포수 모델(waterfall model)을 사용하며, 데이터베이스 모델링은 폭포수 모델의 업무 분석과 시스템 설계 단계에 해당합니다. 이 단계를 거치면 가장 중요한 데이터베이스 개체인 테이블 구조가 결정되는 것입니다.**

![Untitled](https://user-images.githubusercontent.com/80089860/156728558-cac485b7-ee66-412f-a130-43d08471652b.png)

- **데이터모델링 : 현실세계의 사물이나 작업을 DBMS의 데이터베이스 개체로 옮기기 위한 과정**

**즉, 각각의 테이블이라는 개체로 변환하는 것을 말한다**

![Untitled 1](https://user-images.githubusercontent.com/80089860/156728610-eb53dc40-6220-4133-9cf6-eca6aa09aea8.png)

---

## 프로젝트 진행단계

### 폭포수 모델(waterfall model)

**각 단계가 폭포가 떨어지듯 진행되기 때문에 붙여진 이름이다**

![Untitled 2](https://user-images.githubusercontent.com/80089860/156728652-bf37e3c7-df85-49aa-9be6-712dbdab44d6.png)

- **프로젝트 계획 : 슈퍼마켓의 물건들을 온라인으로 판매하기 위한 계획 단계**
- **업무 분석 : 슈퍼마켓에서 업무가 어떻게 돌아가는지 파악하는 것입니다. 예로 물건은 어디서 들어오는지, 물건은 어떻게 계산하는지, 재고는 어떻게 관리하는지 드으이 업무에 대해서 정리하는 단계**
- **시스템 설계 : 앞에서 정리한 업무 분석을 컴퓨터에 적용 시키기 위해서 알맞은 형태로 다듬는 과정**
- **프로그램 구현 : 앞에서 완성한 시스템 설계의 결과를 실제 프로그래밍 언어로 코딩하는 단계**
- **테스트 : 코딩된 프로그램에 오류가 없는지 확인하는 과정**
- **유지보수 : 실제 온라인 쇼핑몰을 운영하면서 문제점을 보완하고 기능을 추가하는 과정**

---

![Untitled 3](https://user-images.githubusercontent.com/80089860/156728708-3d0962df-25ed-4841-9fac-f0ec27284184.png)

### 용어

- **데이터 : 하나하나의 단편적인 정보를 말한다 예를 들어, 아이유, 바나나와 같은 개별적인 정보를 말한다**
- **테이블 : 데이터를 입력하기 위해 표 형태로 표현한것을 말한다.**
- **데이터베이스 : 테이블이 저장되는 저장소를 말한다. 테이블과 데이터베이스 관계는 파일과 폴더의 개념과 비슷하다. 폴더 안에 파일이 있듯이, 데이터 베이스안에 테이블이 있다고 보면된다**
- **DBMS : 데이터베이스 관리 시스템 또는 소프트웨어를 말한다**
- **열(column) : 가로, 테이블의 세로를 말한다. 각 테이블은 여러개의 컬럼, 필드로 구성된다**
- **행(row) : 세로, 실질적인 진짜 데이터, 다른말로 ‘행 데이터’라고 말하며, 행의 개수가 곧, 데이터의 개수이다. 예를 들어, 행의 데이터가 4개가 있으면 4명의 회원정보 데이터가 들어있는 것이다**
- **기본 키(Primary Key, PK) : 기본 키 또는 주 키, 열은 각 행을 구분하는 유일한 열을 말한다 예를 들어, 네이버의 회원 아이디, 학번, 주민등록번호 같은 것이다. 그래서 기본키는 중복되어서는 안되며, 비어있어서도 안된다.**
  **테이블에는 열이 여러개이지만, 기본 키는 1개만 지정해야 하며, 일반적으로 1개의 열에 지정합니다**
- **SQL(Structured Query Language) : 구조화된 질의 언어 즉, SQL은 사람과 DBMS가 소통하기 위한 언어이다**

### 데이터베이스 구축절차

<aside>
📖 데이터베이스 만들기 → 테이블 만들기 → 데이터 입력/수정/삭제 → 데이터 조회/활용

</aside>

---

**SELECT \* FROM member;**

**// member 테이블의 \* ( 모든 행, column )의 데이터를 선택**

**SELECT member_name, member_addr FROM member;**

**// member 테이블의 member_name, member_addr 콜럼(열)을 선택해라**

**SELECT \* FROM member WHERE member_name = ‘아이유’;**

**// member 테이블에서 member_name이 ‘아이유’인것을 선택해라**

**// WHERE은 조건절**

### 핵심 포인트

- **스키마 : = 데이터베이스**
- **데이터 형식 : 문자형(CHAR), 정수형(INT)등과 같이 열에 저장될 데이터 형식**
- **예약어 : SELECT, FROM, WHERE 같은 기존에 약속된 SQL 문**
- **기본 키 : 열에 지정하며, 각 행을 구분하는 유일한 값**

<aside>
📖 INSERT : 입력 /  UPDATE : 수정  /  SELECT : 조회  /  WHERE : 조건

</aside>

---

### 데이터베이스 개체

![Untitled 4](https://user-images.githubusercontent.com/80089860/156728811-32cdd750-23b6-4b1b-a9e5-8460a3c99e5a.png)

### 인덱스

**데이터를 조회할 때, 테이블에 데이터가 적다면 결과가 금방 나오지만 데이터가 많아질수록 결과가 나오는 시간이 많이 소요됩니다. 인덱스는 이런 경우의 결과가 나오는 시간을 대폭 줄여줍니다**

<aside>
📖 CREATE INDEX idx_member_name ON member(member_name);

</aside>

**인덱스가 없을 경우 : Full Table Scan을 통해 “전체 테이블 검색” 으로 나오지만,**

**인덱스를 생성하고 찾을 경우 : “Non-Unique Key Lookup”으로 나온다.**

### 뷰(가상의 테이블)

**뷰는 ‘가상의 테이블’로서, 일반 사용자의 입장에서는 테이블과 뷰를 구분할 수 없습니다.**

**즉, 일반 사용자는 테이블과 동일하게 뷰를 취급하면 된다**

**다만 뷰는 실제 데이터가 없으며, 바로가기 아이콘처럼 테이블에 링크된 개념으로 본다**

<aside>
	
📖 CREATE VIEW member_view AS SELECT * FROM member;

</aside>

- **뷰를 생성했지만, 실질적으로는 member 테이블과 링크 시킨 것이다**

### 스토어드 프로시저(stored procedure)

**MySQL에서 제공하는 프로그래밍 기능으로, 여러 개의 SQL문을 하나로 묶어서 편리하게 사용할 수 있다.**

![Untitled 5](https://user-images.githubusercontent.com/80089860/156728871-ce63d7c1-a570-4b66-b155-ce8fa64cabe7.png)

**하고 실행**

**CALL myProc();**

```
SELECT * FROM member;

SELECT member_name, member_addr FROM member;

SELECT * FROM member WHERE member_name = '아이유' ;

-- ------------------------------
-- 3절
-- ------------------------------

SELECT * FROM member WHERE member_name = '아이유' ;

CREATE INDEX idx_member_name ON member(member_name);

SELECT * FROM member WHERE member_name = '아이유' ;

CREATE VIEW member_view
AS
	SELECT * FROM member;

SELECT * FROM member_view;

SELECT * FROM member WHERE member_name = '나훈아';
SELECT * FROM product WHERE product_name = '삼각김밥';

DELIMITER //
CREATE PROCEDURE myProc()
BEGIN
	SELECT * FROM member WHERE member_name = '나훈아';
	SELECT * FROM product WHERE product_name = '삼각김밥';
END //
DELIMITER ;

CALL myProc();
```

- **데이터베이스 개체 : Database Object : 테이블, 뷰, 인텍스, 스토어드 프로시저 등 데이터베이스 안에 저장되있는 개체**
- **인덱스 검색 : Index Scan : 인덱스를 통해서 데이터를 찾는 것을 말함, 책 뒤의 찾아보기를 사용한 것과 비슷함**
- **구분 문자 : DELIMITER : 스토어드 프로시저를 묶어주는 예약어**
- **호출 : CALL : 스토어드 프로시저를 호출하는 예약어**
- **개체 생성문 : CREATE : 데이터베이스 개체를 생성할 때 사용하는 예약어**
- **개체 삭제문 : DROP : 데이터베이스 개체를 삭제할 때 사용하는 예약어**
