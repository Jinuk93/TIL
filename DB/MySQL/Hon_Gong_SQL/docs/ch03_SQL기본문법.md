# ch03. SQL 기본문법

📌**순서**

### SELECT - FROM - WHERE - GROUP BY - HAVING - ORDER BY - LIMIT

---

### SELECT ~ FROM ~ WHERE

**SELECT문의 기본형식은 SELECT~FROM~WHERE 입니다.**

**SELECT + 열이름,**

**FROM + 테이블 이름,**

**WHERE + 조건식**

### 기본 조회하기 : SELECT ~ FROM

<aside>
📖 USE 데이터베이스_이름;

</aside>

**SELECT 문을 실행하려면 데이터베이스를 지정해야 하는데, USE문을 사용한다**

**예시. USER market_db;**

### SELECT문의 기본형식

📌📌

**SELECT 열\_이름**

**FROM 테이블\_이름**

**WHERE 조건식**

**GROUP BY 열\_이름**

**HAVING 조건식**

**ORDER BY 열\_이름**

**LIMIT 숫자**

예시

SELECT select_expr

[FROM table_references]

[WHERE where_condition]

[GROUP BY {col_name | expr | position}]

[HAVING where_condition]

[ORDER BY { col_name | expr | position }]

[LIMIT {offsetm] row_count | row_count | row_coint OFFSET offset}]

### SELECT와 FROM

<aside>
📖 SELECT * FROM member;

</aside>

1. **SELET : 테이블 조회할 때(가져올 떄) 쓰는 예약어**
2. **‘\*’ : 모든 열 (column)을 뜻한다**
3. **FROM : FROM 다음에 테이블이름이 나온다, 그 테이블에서 내용을 가져오라는 의미**
4. **member : 조회할 테이블명**

**원래 테이블 전체 이름은 데이터베이스*이름.테이블*이름 형식으로 표현한다**

**ex. SELECT \* FROM market_db.member;**

### 특정 column(열)에서 가져오기

**SELECT addr, debut_data, mem_name FROM member;**

### 특정한 조건만 조회 : SELECT ~ FROM ~ WHERE

**WHERE은 필요한 조건을 고를 수 있는 조건문입니다**

### WHERE

<aside>
📖 SELECT 열_이름 FROM 테이블_이름 WHERE  조건식;

</aside>

**조건식에서 찾는 이름(mem_name)이 ‘블랙핑크’라면**

**문자형(CHAR)이므로 ‘’ (작은 따옴표)로 묶어줬습니다.**

**ex. SELECT \* FROM member WHERE mem_name = ‘블랙핑크’;**

### WHERE(조건문)에서 관계 연산자, 논리 연산자의 사용

**예를 들어 평균 키(height)가 162 이하인 회원을 검색하려면, 관계연산자 ≤(작거나 같다)를 사용해서**

**조회할 수 있습니다**

```sql
SELECT mem_id, mem_name FROM member WHERE height <= 162;
```

```sql
SELECT mem_id, mem_name FROM member WHERE height <= 162 AND mem_number > 6;
```

### BETWEEN ~ AND

**AND를 사용해서 키가 163~165인 회원을 조회해보겠습니다**

```sql
SELECT mem_name, height FROM member WHERE height >= 163 AND height <= 165;
```

**그런데, 범위에 있는 값을 구할 경우에는 BEWTWEEN ~ AND를 사용해도 됩니다**

```sql
SELECT mem_name, height FROM member WHERE height BETWEEN 163 AND 165;
```

### IN()

**예를 들어, 163~165의 숫자범위가 아닌, 경기/전남/서울 중 한 곳에 사는 회원을 검색하려면**

**OR문으로 일일이 써줘야 합니다**

```sql
**SELECT mem_name, addr
FROM member
WHERE addr = '경기' OR addr='전남' OR addr='서울';**
```

**하지만, IN()을 사용하면 코드를 훨씬 간결하게 동일한 SQL문을 작성할 수 있습니다**

```sql
**SELECT mem_name, addr
FROM member
WHERE addr IN('경기', '전남', '서울');**
```

### LIKE

**문자열의 일부 글자를 검색하려면 LIKE를 사용한다 예를 들어, 첫글자가 ‘우’로 시작하는 회원은 다음과 같이 검색할 수 있다**

**이 조건은 제일 앞글자가 ‘우’이고, 그 뒤는 무엇이든(%) 허용한다는 의미이다**

```sql
**SELECT * FROM member
WHERE mem_name '우%';**
```

혹은 \_(언더바)를 이용해서 찾을 수 있다

```sql
**SELECT * FROM member
WHERE mem_name LIKE '__핑크';
예시. 블랙핑크, 에이핑크**
```

### 서브쿼리

**SELECT 안에 또 다른, SELECT가 들어갈 수 있습니다. 이것을 서브 쿼리 또는 하위쿼리라고 부릅니다**

**여기서는 mem_name이 ‘에이핑크’인 회원의 평균 키(height)보다 큰 회원을 검색하고 싶다고 가정해보겠습니다.**

**우선, 에이핑크의 평균 키(height)를 알아내야 합니다.**

```sql
**SELECT hieght FROM member WHERE mem_name ='에이핑크';**
```

**이제는 164보다 평균 키가 큰 회원을 조회하면 됩니다**

```sql
**SELECT mem_name, height FROM member WHERE height > 164;**
```

**이 두 개의 SQL문을 합치면,**

```sql
**SELECT mem_name, height FROM member
WHERE height > (SELECT height FROM member WHERE mem_name = '에이핑크');**
```

- **서브쿼리의 장점은 2개의 SQL문을 하나로 만듬으로써, 관리하기도 쉽고 보기에도 더 간결하다**

### 용어

- **주석 : remart : 하이픈(—) 2개로 구성**
- **VARCHAR : 문자형으로 CHAR와 거의 비슷함**
- **AUTO_INCREMENT : 자동으로 숫자를 입력시켜줌, 테이블을 생성할 때 지정함**
- **\* : 모든 열을 지정할 때 사용하는 기호**
- **별칭 : alias : SELECT문에서 실제 열 이름 대신에 출력되도록 설정하는 문자**
- **% : 문자열에서 여러 문자에 대응하는 기호**
- **\_ : 문자열에서 한 문자에 대응하는 기호**

---

### 좀 더 깊게 알아보는 SELECT문

- **ORDER BY : 정렬을 위한**
- **LIMIT : 결과의 개수를 제한**
- **DISTINCT : 중복된 데이터를 제거하는**
- **GROUP BY : 지정한 열의 데이터들을 같은 데이터끼리 묶어서 결과를 추출**
- **HAVING : WHERE절과 비슷해 보이지만, GROUP BY절과 함께 사용되는것이 차이점**

### ORDER BY절

```sql
SELECT mem_id, mem_name, debut_date FROM member
ORDER BY debut_date
```

**기본값은 ACS인데 ‘오름차순’을 의미하고, DESC는 내림차순을 의미한다**

**ORDER BY절은 WHERE절과 함께 사용할 수 있습니다.**

**ORDER BY절은 WHERE절 다음에 나와야 합니다.**

```sql
SELECT mem_id, mem_name, debut_date, height
FROM member
WHERE height >= 164
ORDER BY height DESC;
```

```sql
SELECT mem_id, mem_name, debut_date, height
FROM member
WHERE height >= 164
ORDER BY height DESC, debut_date ACS;
```

### LIMIT : 출력의 개수제한 //LIMIT 시작,개수

**LIMIT은 출력하는 개수를 제한합니다. 예를 들어, 테이블을 조회하는데 전체 중 앞에서 3건만**

**조회할 수 있습니다.**

```sql
SELECT * FROM
member
LIMIT 3; = LIMIT 0,3;

LImIT 3,2; -- 3번째부터 2건만 조회할 수 있다
```

### DISTINCT 중복제거

**중복된 데이터를 1개만 남깁니다.**

**예시**

**SELECT DISTINCT addr FROM member;**

### GROUP BY절

**그룹으로 묶어주는 역할을 합니다.**

```sql
SELECT mem_id, amount FROM buy ORDER BY mem_id;
```

### 집계함수

**GROUP BY와 함께 주로 사용되는 집계함수는 다음과 같습니다**

- **SUM() : 합계**
- **AVG() : 평균**
- **MIN() : 최소값**
- **MAX() : 최대값**
- **COUNT() : 행의 개수**
- **COUNT(DISTINCT) : 행의 개수, 중복은1개만 인정**

```sql
SELECT mem_id "회원아이디", SUM(amount) "총 구매 개수"
FROM buy GROUP BY mem_id;
```

```sql
SELECT mem_id "회원 아이디", SUM(price*amount) "총 구매 금액"
FROM buy GROUP BY mem_id;
```

```sql
SELECT AVG(amount) "평균 구매 개수" FROM buy;
```

### HAVING절

**HAVING은 WHERE와 비슷한 개념으로 조건을 제한하는 것이지만,**

**집계함수에 대해서 조건을 제한하는 것이라고 생각하면 됩니다**

**HAVING절은 꼭 GROUP BY절 다음에 나와야 합니다.**

```sql
SELECT mem_id "회원 아이디", SUM(price*amount) "총 구매 금액"
FROM buy
GROUP BY mem_id

**HAVING SUM(price*amount) > 1000;**
📌
**여기서 WHERE SUM(price*amouint) > 1000;은 에러뜬다
집계함수에 대해서는 HAVING절을 써야한다**

```

---

### 데이터 변경을 위한 SQL문

- **INSERT 문은 테이블에 데이터를 입력하는 명령입니다**
- **AUTO_INCREMENT는 1부터 증가하는 값을 자동으로 입력해줍니다. 해당열은 PRIMARY KEY로 지정해야 합니다.**
- **INSERT INTO ~ SELECT는 다른 테이블의 데이터를 가져와서 한번에 대량으로 입력합니다**
- **UPDATE는 기존에 입력되어 있는 값을 수정하며 주로 WHERE와 함께 사용합니다.**
- **DELETE는 행 단위로 삭제하며, WHERE가 없으면 전체 행이 삭제됩니다**

- **NULL : 아무것도 없는 값, AUTO_INCREMENT 열에 값을 입력할 때는 NULL로 지정**
- **PRIMARY KEY(PK) : 기본 키, AUTO_INCREMENT 열은 ‘기본 키’로 지정**
- **ALTER TABLE : 테이블의 구조를 변경하는 SQL문**
- **시스템 변수 : MySQL에서 자체적으로 가지고 있는 설정값이 저장된 변수**
- **[@auto_increment_increment](https://www.notion.so/auto_increment_increment-5d8020da63de430eaae4d185d50b49a3) : AUTO_INCREMENT의 증가값을 지정하는 시스템변수**
- **DESCRIBE : 테이블의 구조를 확인하는 SQL**
- **TRUNCATE : DELETE와 비슷한 기능이지만, “전체 행”을 삭제할 때 사용**

---

**데이터베이스와 테이블을 만든 후에는 데이터를 변경하는**

**입력/수정/삭제 (INSERT, UPDATE, DELECTE) 기능이 필요합니다**

- **INSERT : 새로 가입한 회원을 테이블에 입력할 때**

<aside>
📖 INSERT INTO 테이블명 [ (column1, column2, ...) ], VALUES (값1, 값2, ...)

</aside>

- **UPDATE : 회원의 주소나 연락처가 변경되어 정보를 수정할 때**
- **DELETE : 회원이 탈퇴해서 회원을 삭제할 때**

### 데이터 입력 : INSERT

**테이블에 “행” 데이터를 입력하는 기본적인 SQL문**

<aside>
📖 INSERT INTO 테이블명 [ (column1, column2, ...) ], VALUES (값1, 값2, ...)

</aside>

**예시**

**INSERT INTO hongong1 (toy_name, age, toy_id) VALUES (’제시’, 20, 3);**

### 자동으로 증가하는 AUTO_INCREMENT

**AUTO_INCREMENT는 열을 정의할 때 ‘1’부터 증가하는 값을 입력해줍니다.**

**INSERT에서는 해당열이 없다고 생각하고 입력하면 됩니다. 단, 주의할점은**

**AUTO_INCREMENT로 지정하는 열은 PRIMARY KEY로 지정해줘야 합니다**

```sql
CREATE TABLE hongong2 (
	toy_id, INT AUTO_INCREMENT PRIMARY KEY,
	toy_name CHAR(4),
	age INT);

INSERT INTO hongong2 VALUES (NULL, ''보핍', 24);
INSERT INTO hongong2 VALUES (NULL, '슬링키', 30);
--이런식으로 toy_id는 AUTO_INCREMENT로서 K로 지정 => NULL값 지정

```

**만약 AUTO_INCREMENT로 입력되는 다음값을 100부터 시작하도록 변경하고 싶다면,**

**ALTER TABLE hongong2 AUTO_INCREMENT=100; 으로 하면된다**

**증가값을 1이 아닌 3씩 증가하도록 변경하려면, 시스템 변수를 변경해야한다**

**@@auto_increment_increment를 변경**

**SET @@auto_increment_increment=3; 이런식으로 변경하면된다**

### 데이터를 한번에 입력하는 INSERT INTO ~ SELECT

**다른 테이블에 이미 데이터가 입력되어 있다면**

**INSERT INTO ~ SELECT 구문을 사용해 해당 테이블의 데이터를 가져와서 한번에 입력할 수 있다**

<aside>
📖 INSERT INTO 테이블명 ( column1, column2, column3, ...)                                                              SELECT문 ;

</aside>

**여러개인 데이터의 개수를 확인을 먼저 하면은**

<aside>
📖 SELECT COUNT(*) FROM world.city;

</aside>

**이 때, [world.city](http://world.city) 테이블의 구조를 살펴보겠다**

**DESC 명령으로 테이블 구조를 확인할 수 있다**

**DESC는 Describe의 약자로 테이블의 구조를 출력해주는 기능이다**

<aside>
📖 DESC world.city

</aside>

---

### 데이터 수정 : UPDATE

**데이터를 수정해야 하는 경우도 빈번하게 발생한다. 이를 위해, UPDATE를 사용해서 수정한다**

### UPDATE 문의 기본문법

```sql
UPDATE 테이블명
	SET 열1=값1, 열2=-값2...
WHERE 조건;
```

```sql
USE market_db;
UPDATE city_popul
		SET city_name = '서울'--바꾼 후
	WHERE city_name = 'Seoul'; --바꿀 조건
-- 영문 Seoul을 한글 서울로 바꾸라는 명령문

SELECT * FROM city_popul WHERE city_name ='서울';
```

### WHERE가 없는 UPDATE문

**UPDATE문에서 WHERE 절은 문법상 생략이 가능하지만, WHERE절을 생략하면**

**테이블의 모든 행의 값이 변경된다**

**일반적으로 전체 행의 값을 변경하는 경우는 별로 없으므로, 주의해야 한다**

### 데이터 삭제 : DELETE

**회원이 탈퇴한 경우에 해당하는 회원의 정보를 삭제해야 합니다.**

**이럴 때 DELETE를 사용해서 행 데이터를 삭제합니다**

**DELETE도 UPDATE와 거의 비슷하게 사용할 수 있습니다.**

**DELETE는 행 단위로 삭제하며 형식은 다음과 같다**

<aside>
📖 DELETE FROM 테이블명 WHERE 조건;

</aside>

```sql
DELETE FROM city_pupul
	WHERE city_name LIKE 'New%';
```

### 대용량 테이블의 삭제

**만약 몇억 건의 데이타기 있는 대용량 테이블이 더 이상 필요없다면 어떻게 삭제하는 것이 좋을까요?**

**우선, DELETE, DROP, TRUNCATE 의 각각의 테이블 삭제방법이 있다**

1. **DELETE문은 삭제가 오래 걸립니다. 대용량일 경우, 상당히 오래걸릴 수 있습니다**
2. **DROP문은 테이블 자체를 삭제한다 그러기에, 순식간에 삭제할 수 있다**
3. **TRUNCATE문도 DELETE문과 동일한 효과를 내지만 속도가 무척 빠릅니다**

**DROP은 테이블 자체가 사라지지만, DELETE문과 TRUNCATE은 ‘빈 테이블’을 남깁니다**

```sql
**DELETE FROM big_table1;
DROP TABLE big_table2;
TRUNCATE TABLE big_table3; --DELETE와 달리.WHERE문 사용불가, 따라서 전체삭제만 가능**
```

**결론적으로, 테이블자체가 필요없을 경우 DROP으로 테이블을 날리고**

**테이블이 필요할 시, TRUNCATE으로 삭제하는것이 효율적이다**
