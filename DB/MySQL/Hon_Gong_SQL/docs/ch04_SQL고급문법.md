# ch04. SQL 고급문법

## MySQL의 데이터 형식

- **정수형은 소수점이 없는 숫자이며, TINYINT, SMALLINT, INT, BIGINT 등이 있습니다**
- **문자형은 <고정형 문자형인 CHAR>와 <가변형 문자형인 VARCHAR>가 있습니다**
- **실수형은 소수점 아래 7자리까지 표현되는 FLOAT와 소수점 아래 15자리까지 표현되는 DOUBLE형이 있습니다**
- **날짜형은 날짜를 저장하는 DATE, 시간을 저장하는 TIME, 날짜와 시간을 저장하는 DATETIME이 있습니다**
- **MySQL에서 제공되는 변수앞에는 @를 붙입니다**
- **데이터 형식을 변경하는 형변환 함수에는 CAST(), CONVERT()가 있습니다.**

---

### 데이터형식

1. **정수형**
 
    ![Untitled](https://user-images.githubusercontent.com/80089860/157651205-215ccf3a-d3e9-49fc-9139-f471d36e343c.png)
    
2. **문자형**

    ![Untitled 1](https://user-images.githubusercontent.com/80089860/157651280-a025005d-effe-43db-b6a8-90768c8de0bd.png)

    ![Untitled 2](https://user-images.githubusercontent.com/80089860/157651335-d045dfb3-5164-415b-8b06-2bd6c8f128d7.png)

    ![Untitled 3](https://user-images.githubusercontent.com/80089860/157651361-0532aa81-dbff-44db-a1bc-0a3b37f3aaff.png)

    
    **CHAR(고정형)과 VARCHAR(가변형)의 장,단점은 서로 존재한다**
    
    **CAHR는 공간낭비가 있지만, 속도가 약간 빠른편이다**
    
    **VARCHAR는 공간을 효율적으로 사용할 수 있다, VARCHAR는 길이의 유동이 큰 편일때 사용하면 좋다**
    
    - ***대량의 데이터 형식 (예시. 넷플릭스)***

    ![Untitled 4](https://user-images.githubusercontent.com/80089860/157651457-f70737a2-0454-4340-a163-30c7bc8ac709.png)
    
    ```sql
    CREATE DATABASE netflix_db;
    USE netflix_db;
    CREATE TABLE movie
    	(movie_id       INT,
    	 movie_title    VARCHAR(30),
    	 movie_director VARCHAR(20), 
    	 movie_star     VARCHAR(20),
    	 movie_script   LONGTEXT,
    	 movie_film     LONGBLOB --BLOB 2진
    	)
    ```
    
3. **실수형**
 
   ![Untitled 5](https://user-images.githubusercontent.com/80089860/157651514-72c37332-9396-4a5a-849a-e9943dc34762.png)
 
4. **날짜형**
    
   ![Untitled 6](https://user-images.githubusercontent.com/80089860/157651569-91082b7b-1f4a-4fe1-9b7b-f589318535f3.png)

### 변수의 사용

   ![Untitled 7](https://user-images.githubusercontent.com/80089860/157651640-3e13e2fa-4b86-4a23-bcc9-49cf27b4ca74.png)

### 데이터 형변환 = ‘형식 변환’

![Untitled 8](https://user-images.githubusercontent.com/80089860/157651715-771ef919-7350-48c9-bfd2-05b420afbb31.png)

---

## 📌📌두 테이블을 묶는 조인

- **일대다 관계란 한쪽 테이블에는 하나의 값만, 다른 쪽 테이블에는 여러개의 값이 존재할 수 있는관계를 말합니다**
- **조인은 두 개의 테이블을 서로 묶어서 하나의 결과를 만들어 내는 것을 말합니다**
- **내부조인(INNER JOIN)은 두 테이블을 조인할 때, 두 테이블에 모두 지정한 열의 데이터가 있어야 합니다**
- **외부조인(<LEFT | OUTER | FULL> OUTER JOIN)은 두 테이블을 조인할 때, 1개의 테이블에만 데이터가 있어도 결과가 나옵니다**
- **상호조인(CROSS JOIN)은 한쪽 테이블의 모든 행과 다른 쪽 테이블의 모든 행을 조인시키는 기능입니다**
- **자체 조인(SELF JOIN)은 자신이 자신과 조인된다는 의미로, 1개의 테이블을 사용한다**

- **관계 : 두 테이블이 서로 연관되는 것**
- **기본키(PK)-외래키(FK)의 관계 : 두 테이블이 ‘일대다 관계’로 연결되기 위한 조건**
- **별칭(alias) : 조인에서 두 테이블의 이름을 짧게 표현하는 이름**
- **DISTINCT문 : 중복된 열의 값을 1개만 표현하는 구문**
- **LEFT OUTER JOIN : 왼쪽 테이블의 모든 값이 출력되는 조인**
- **RIGHT OUTER JOIN : 오른쪽 테이블의 모든 값이 출력되는 조인**
- **FULL OUTER JOIN : 왼쪽 또는 오른쪽 테이블의 모든 값이 출력되는 조인**
- **CREATE TABLE ~ SELECT : SELECT의 결과가 테이블로 생성되는 구문**

---

**조인이란 두 개의 테이블을 서로 묶어서 하나의 결과를 만들어 내는 것을 말합니다. 두 테이블을 묶어야만 원하는 형태가 나오는 경우가 많습니다. 인터넷 마켓 데이터베이스의 회원 테이블과 구매 테이블을 예로 들 수 있습니다.**

**회원 테이블에는 회원의 이름과 연락처가 있고, 구매 테이블에는 회원이 구매한 물건이 있습니다. 물건을 배송하려면 회원 테이블의 회원 이름과 연락처, 구매 테이블의 회원이 구매한 물건에 대한 정보가 함께 필요합니다. 이렇게 두 개의 테이블을 엮어서 하나의 배송을 위한 정보를 추출하는 것이 대표적인 조인입니다 ⇒ 인터넷 쇼핑몰**

![Untitled 9](https://user-images.githubusercontent.com/80089860/157651758-339e561f-8ad1-4656-986a-f38b9d5d9871.png)

### 내부조인

**두 테이블을 연결할 때 가장 많이 사용되는 것이 내부 조인입니다.**

**그냥 조인이라 부르면 내부 조인을 의미하는 것입니다.**

### 일대다 관계의 이해

**두 테이블의 조인을 위해서는 일대다(one to many) 관계로 연결되어야 합니다.**

**데이터베이스의 테이블은 하나로 구성되는것보다 주제에 따라서 분리해서 저장하는 것이 효율적입니다. 이 분리된 테이블은 서로 관계를 맺고있습니다.**

**예를 들어, 인터넷쇼핑몰에서의 회원 테이블과 구매 테이블 등이 있습니다.** 

**일대다 테이블은, 한 쪽 테이블은 하나의 값만 존재해야만 하고**

**연결된 다른 테이블은 여러개의 값이 존재할 수 있습니다**

**회원테이블과 구매테이블에서는 회원테이블이 ‘일’, 구매테이블이 ‘다’가 될 수 있습니다.**

**예시. ‘김모군’이 여러개의 ‘구매’품목 데이터를 가질 수 있다**

**이 때, 회원테이블은 기본키(Primary Key, PK)로 지정하고**

    구매테이블은 외래키(Foreign Key, FK)로 설정했습니다.

***기본키(PK)-외래키(FK)로 관계로 맺어져야 한다. (예외 : 상호 조인)**

### 내부 조인의 기본

**일반적으로 조인이라 부르는 것은 내부조인(inner join)을 말하는 것으로,**

**조인 중에서 가장 많이 사용됩니다.**

**조인은 3개 이상의 테이블로도 할 수 있지만, 대부분 2개로 조인하므로**

**2개에 대해서 설명하겠다**

### 📌내부 조인의 형식

```sql
**SELECT <column 목록>
FROM <첫번째 테이블>
	INNER JOIN <두번째 테이블>
	ON <조인될 조건>
[WHERE 검색조건] *--생략가능***
```

- INNER JOIN을 그냥 JOIN이라 작성해도 인식된다

📌**예시 코드**

```sql
**USE market_db;
SELECT * --모든 column
FROM buy --첫번째 테이블
	INNER JOIN member --두번째 테이블
	ON buy.mem_id = member.mem_id --조인될 조건
	--구매 테이블의 ID와 회원 테이블의 ID가 같아야 한다(조건)
WHERE buy.mem_id = 'GRL';
-- 구매테이블에서 ID가 GRL인 친구의 구매 테이블의 db와 회원 테이블의 db를 가져온다**
```
![Untitled 10](https://user-images.githubusercontent.com/80089860/157651841-28d2f5fb-0eb7-46d2-b967-905007c98263.png)

**위 처럼 두 테이블에 mem_id 열이 중복된 게 있으면, 오류가 뜬다**

**그래서 어느 테이블의 ‘열’인지 구분해주어야한다**

**예를 들어. buy.mem_id 혹은 member.mem_id**

```sql
SELECT buy.mem_id ~~ AS '연락처'
```

### INNER JOIN(내부 조인)의 한계점

**회원 테이블과 구매 테이블에서 (내부) 조인을 하게 되면,**

**구매 하지 않은 회원 정보(회원 테이블의)들은 나오지 않게된다 (당연한거 아닌가 싶겠지만...)**

**외부조인을 할 경우, ‘구매하지 않는 회원’들에 대한 DB도 출력할 수 있다.** 

### 중복된 결과 1개만 출력하기

**예를 들어, 인터넷 쇼핑몰에서 ‘ 한 번이라도 구매한 회원들에게 감사인사 문구를 보내려고 한다 ‘**

**분명, 한 회원 당 여러번 구매했었을 수 도 있다**

**따라서, 이 때 DISTINCT문을 사용한다**

**예시**

```sql
SELECT DISTINCT buy.mem_id, buy.mem_name, buy.addr
FROM buy M
	INNER JOIN MEMBER buy
	ON M.mem_id = buy.mem_id
ORDER BY buy.mem_id;
```

---

### 외부조인

**내부조인은 두 테이블에 모두 데이터가 있어야만 결과가 나옵니다. 이와 달리, 외부 조인은**

**한쪽에만 데이터가 있어도 결과가 나옵니다**

### 외부조인의 기본

**외부조인은 두 테이블을 조인할 때 필요한 내용이 한쪽 테이블에만 있어도 결과를 추출할 수 있습니다. 자주 사용되지는 않지만, 가끔 사용되는 방식이므로 알아두면 유용합니다**

### 외부조인의 형식

```sql
SELECT <column>
FROM <첫 번째 테이블(LEFT 테이블)>
	<LEFT | RIGHT | FULL> OUTER JOIN <두 번째 테이블(RIGHT 테이블)>
	ON M.mem_id = B.mem_id
ORDER BY M.mem_id;
```

**먼저 내부 조인에서 해결하지 못한**

**‘(구매기록이 없는 회원의 정보도 함께)출력’을 외부 조인으로 만들어보겠습니다.**

 ⇒

1. **왼쪽에는 모든 회원 (member)테이블을 두고, 오른쪽을 구매(buy)테이블을 둔다**
2. **외부조인 할 때는 LEFT OUTER JOIN을 사용해서 왼쪽 테이블의 모든 DB를 출력하게 한다**
3. **회원 테이블이 모두 출력되므로, 구매를 했던, 안했던, 모든 회원들이 출력되게 되므로**
4. **구매기록이 없는 회원정보들도 함께 출력된다.**

```sql
SELECT M.mem_id, M.mem_name, B.prod_name, M.addr
	FROM member M --왼쪽에 있는 회원 테이블을 기준으로 외부조인을 한다
	 LEFT OUTER JOIN buy B --왼쪽에 있는 회원 테이블을 기준으로 외부조인을 한다
	 ON M.mem_id = B.mem_id
ORDER BY M.mem_id;
```

- **LEFT OUTER JOIN : 왼쪽 테이블의 내용은 모두 출력되어야 한다 라는 의미로 보면쉽다**

```sql
SELECT M.mem_id, M.mem_name, B.prod_name, M.addr
	FROM member M --오른쪽에 있는 회원 테이블을 기준으로 외부조인을 한다
	 RIGHT OUTER JOIN buy B --오른쪽에 있는 회원 테이블을 기준으로 외부조인을 한다
	 ON M.mem_id = B.mem_id
ORDER BY M.mem_id;
```

### 외부조인의 활용

**내부 조인으로 구매한 기록이 있는 회원들의 목록만 추출해서 감사문을 보냈었습니다.**

**이번에는 반대로, 회원만 가입하고 한 번도 구매한 적이 없는 회원의 목록을 추출해보겠습니다.**

```sql
SELECT DISTNCT M.mem_id, B.prod_name, M.mem_name, M.addr

	FROM member M
	
		LEFT OUTER JOIN buy B
		
		ON M.mem_id = B.mem_id
	
	WHERE B.prod_name IS NULL

ORDER BY M.mem_id;
```

- **FULL OUTER JOIN은 왼쪽 외부 조인과 오른쪽 외부 조인이 합쳐진 것이라고 생각하면 됩니다**

**왼쪽이든 오른쪽이든 한 쪽에 들어있는 내용이면 출력한다 *자주사용하지 않는다**
