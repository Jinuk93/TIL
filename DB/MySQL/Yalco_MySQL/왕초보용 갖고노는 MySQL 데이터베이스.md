# 왕초보용! 갖고 노는 MySQL 데이터베이스 강좌

# Section 0. INTRO

## *MySQL은 가장 널리 쓰이는 RDBMS이다*

💡

> **RDBMS**
> 

: ***"Relational Database Management System",
"관계형 데이터베이스 관리 시스템"***

- **SQL 관계형 데이터베이스**
- **NoSQL 비관계형 데이터베이스**

> **RDB**
> 

1.우선 RDB는 **관계형 데이터 모델**에 기초를 둔 데이터 베이스이다
2.모든 데이터를 2차원의 테이블 형태로 표현한다

- **DBMS**
: _"Database Management System", _
*"데이터베이스 관리 시스템"*
- **Database**
: **한 곳에 저장된 정보들을, 원하는 어떤 곳에서든 사용할 수 있다는 것**

> ***DBMS***
> 
- DBMS는 DataBase Management System의 약자로 데이터베이스를 관리하는 시스템이다
- 사용자와 DB사이에서 사용자의 요구에 따라 데이터를 생성해주고 DB를 관리해주는 소프트웨어이다

***DBMS와 RDBMS의 관계***

- ***RDBMS는 DBMS의 한 유형이다.***

> **SQL : Structured Query Language == 'Sequel'**
> 

---

# Section 01. SELECT기초-원하는 정보 가져오기

## ****SELECT 전반기능 훑어보기****

### **1. 테이블의 모든 내용 보기**

### * **(asterisk)는 테이블의 모든 컬럼을 뜻합니다.**

```sql
SELECT * FROM Customers;
-- 이와 같이 주석을 달 수 있습니다.
```

****2. 원하는 column(열)만 골라서 보기****

```sql
SELECT CustomerName FROM Customers;
```

### **테이블의 컬럼이 아닌 값도 선택할 수 있습니다.**

아래 구문의 *1*과 *Hello*, NULL을 확인하세요.

```sql
SELECT
  CustomerName, 1, 'Hello', NULL
FROM Customers;
```

### **3. 원하는 조건의 row(행)만 걸러서 보기**

**WHERE** 구문 뒤에 조건을 붙여 원하는 데이터만 가져올 수 있습니다.

```sql
SELECT * FROM Orders
WHERE EmployeeID = 3;
```

### **4. 원하는 순서로 데이터 가져오기**

**ORDER BY** 구문을 사용해서 특정 컬럼을 기준으로 데이터를 정렬할 수 있습니다.

ASC오름차순✔️

DESC내림차순

```sql
SELECT * FROM Customers
ORDER BY ContactName;
```

### **5. 원하는 만큼만 데이터 가져오기**

**`LIMIT {가져올 갯수}`** 또는 **`LIMIT {건너뛸 갯수}, {가져올 갯수}`** 를 사용하여, 원하는 위치에서 원하는 만큼만 데이터를 가져올 수 있습니다

```sql
SELECT * FROM Customers
LIMIT 10;
```

### **6. 원하는 별명(alias)으로 데이터 가져오기**

**AS**를 사용해서 컬럼명을 변경할 수 있습니다.

```sql
SELECT
  CustomerId AS '아이디',
  CustomerName AS '고객명',
  Address AS '주소'
FROM Customers;
```

****🎯 모두 활용해보기****

```sql
SELECT
  CustomerID AS '아이디',
  CustomerName AS '고객명',
  City AS '도시',
  Country AS '국가'
FROM Customers
WHERE
  City = 'London' OR Country = 'Mexico'
ORDER BY CustomerName
LIMIT 0, 5;
```

---

## ****각종 연산자들****

| 연산자 | 의미 |
| --- | --- |
| +, -, *, / | 각각 더하기, 빼기, 곱하기, 나누기 |
| %, MOD | 나머지 |
| IS | 양쪽이 모두 TRUE 또는 FALSE |
| IS NOT | 한쪽은 TRUE, 한쪽은 FALSE |
| AND, && | 양쪽이 모두 TRUE일 때만 TRUE |
| OR, || | 한쪽은 TRUE면 TRUE |
| = | 양쪽 값이 같음 |
| !=, <> | 양쪽 값이 다름 |
| >, < | (왼쪽, 오른쪽) 값이 더 큼 |
| >=, <= | (왼쪽, 오른쪽) 값이 같거나 더 큼 |
| BETWEEN {MIN} AND {MAX} | 두 값 사이에 있음 |
| NOT BETWEEN {MIN} AND {MAX} | 두 값 사이가 아닌 곳에 있음 |
| IN (...) | 괄호 안의 값들 가운데 있음 |
| NOT IN (...) | 괄호 안의 값들 가운데 없음 |
| LIKE '... % ...' | 0~N개 문자를 가진 패턴 |
| LIKE '... _ ...' | _ 갯수만큼의 문자를 가진 패턴 |

---

## ****숫자와 문자열을 다루는 함수들****

### 1. 숫자관련 함수들

| 함수 | 설명 |
| --- | --- |
| ROUND | 반올림 |
| CEIL | 올림 |
| FLOOR | 내림 |

```sql
SELECT 
  ROUND(0.5),
  CEIL(0.4),
  FLOOR(0.6);
```

| 함수 | 설명 |
| --- | --- |
| ABS | 절대값 |

```sql
SELECT ABS(1), ABS(-1), ABS(3 - 10);
```

| 함수 | 설명 |
| --- | --- |
| GREATEST | (괄호 안에서) 가장 큰 값 |
| LEAST | (괄호 안에서) 가장 작은 값 |

```sql
SELECT 
  GREATEST(1, 2, 3), -- 괄호안에서 기준으로 가장 큰 것
  LEAST(1, 2, 3, 4, 5);
```

### **💡 그룹 함수 - 조건에 따라 집계된 값을 가져옵니다.**

| 함수 | 설명 |
| --- | --- |
| MAX | 가장 큰 값 |
| MIN | 가장 작은 값 |
| COUNT | 갯수 (NULL값 제외) |
| SUM | 총합 |
| AVG | 평균 값 |

```sql
SELECT
  MAX(Quantity),
  MIN(Quantity),
  COUNT(Quantity),
  SUM(Quantity),
  AVG(Quantity)
FROM OrderDetails
WHERE OrderDetailID BETWEEN 20 AND 30;
```

| 함수 | 설명 |
| --- | --- |
| POW(A, B), POWER(A, B) | A를 B만큼 제곱 |
| SQRT | 제곱근 |

```sql
SELECT
  POW(2, 3),
  POWER(5, 2),
  SQRT(16);
```

| 함수 | 설명 |
| --- | --- |
| TRUNCATE(N, n) | N을 소숫점 n자리까지 선택 |

```sql
SELECT
  TRUNCATE(1234.5678, 1),
  TRUNCATE(1234.5678, 2),
  TRUNCATE(1234.5678, 3),
  TRUNCATE(1234.5678, -1),
  TRUNCATE(1234.5678, -2),
  TRUNCATE(1234.5678, -3);
```

****[더 많은 숫자 함수 보러가기 ▶️](https://dev.mysql.com/doc/refman/8.0/en/numeric-functions.html)****

---

### 2. 문자열관련 함수들

| 함수 | 설명 |
| --- | --- |
| UCASE, UPPER | 모두 대문자로 |
| LCASE, LOWER | 모두 소문자로 |

```sql
SELECT
  UPPER('abcDEF'),
  LOWER('abcDEF');
```

| 함수 | 설명 |
| --- | --- |
| CONCAT(...) | 괄호 안의 내용 이어붙임 |
| CONCAT_WS(S, ...) | 괄호 안의 내용 S로 이어붙임 |

```sql
SELECT CONCAT('HELLO', ' ', 'THIS IS ', 2021)
```

| 함수 | 설명 |
| --- | --- |
| SUBSTR, SUBSTRING | 주어진 값에 따라 문자열 자름 |
| LEFT | 왼쪽부터 N글자 |
| RIGHT | 오른쪽부터 N글자 |

```sql
SELECT
  SUBSTR('ABCDEFG', 3),
  SUBSTR('ABCDEFG', 3, 2),
  SUBSTR('ABCDEFG', -4),
  SUBSTR('ABCDEFG', -4, 2);
```

| 함수 | 설명 |
| --- | --- |
| LENGTH | 문자열의 바이트 길이 |
| CHAR_LENGTH, CHARACTER_LEGNTH | 문자열의 문자 길이 |

```sql
SELECT
  LENGTH('ABCDE'),
  CHAR_LENGTH('ABCDE'),
  CHARACTER_LENGTH('ABCDE');
```

| 함수 | 설명 |
| --- | --- |
| TRIM | 양쪽 공백 제거 |
| LTRIM | 왼쪽 공백 제거 |
| RTRIM | 오른쪽 공백 제거 |

```sql
SELECT
  CONCAT('|', ' HELLO ', '|'),
  CONCAT('|', LTRIM(' HELLO '), '|'),
  CONCAT('|', RTRIM(' HELLO '), '|'),
  CONCAT('|', TRIM(' HELLO '), '|');
```

| 함수 | 설명 |
| --- | --- |
| LPAD(S, N, P) | S가 N글자가 될 때까지 P를 이어붙임 |
| RPAD(S, N, P) | S가 N글자가 될 때까지 P를 이어붙임 |

```sql
SELECT
  LPAD('ABC', 5, '-'),
  RPAD('ABC', 5, '-');
```

| 함수 | 설명 |
| --- | --- |
| REPLACE(S, A, B) | S중 A를 B로 변경 |

```sql
SELECT
  REPLACE('맥도날드에서 맥도날드 햄버거를 먹었다.', '맥도날드', '버거킹');
```

| 함수 | 설명 |
| --- | --- |
| INSTR(S, s) | S중 s의 첫 위치 반환, 없을 시 0 |

```sql
SELECT
  INSTR('ABCDE', 'ABC'),
  INSTR('ABCDE', 'BCDE'),
  INSTR('ABCDE', 'C'),
  INSTR('ABCDE', 'DE'),
  INSTR('ABCDE', 'F');
```

| 함수 | 설명 |
| --- | --- |
| CAST(A, T) | A를 T 자료형으로 변환 |

```sql
SELECT
  '01' = '1',
  CONVERT('01', DECIMAL) = CONVERT('1', DECIMAL);
```

****[더 많은 문자열 함수 보러가기 ▶️](https://dev.mysql.com/doc/refman/8.0/en/string-functions.html)****

---

## ****시간/날짜 관련 및 기타함수들****

### 1. 시간/날짜 관련 함수들

| 함수 | 설명 |
| --- | --- |
| CURRENT_DATE, CURDATE | 현재 날짜 반환 |
| CURRENT_TIME, CURTIME | 현재 시간 반환 |
| CURRENT_TIMESTAMP, NOW | 현재 시간과 날짜 반환 |

```sql
SELECT CURDATE(), CURTIME(), NOW();
```

| 함수 | 설명 |
| --- | --- |
| DATE | 문자열에 따라 날짜 생성 |
| TIME | 문자열에 따라 시간 생성 |

```sql
SELECT
  '2021-6-1' = '2021-06-01',
  DATE('2021-6-1') = DATE('2021-06-01'),
  '1:2:3' = '01:02:03',
  TIME('1:2:3') = TIME('01:02:03');
```

| 함수 | 설명 |
| --- | --- |
| YEAR | 주어진 DATETIME값의 년도 반환 |
| MONTHNAME | 주어진 DATETIME값의 월(영문) 반환 |
| MONTH | 주어진 DATETIME값의 월 반환 |
| WEEKDAY | 주어진 DATETIME값의 요일값 반환(월요일: 0) |
| DAYNAME | 주어진 DATETIME값의 요일명 반환 |
| DAYOFMONTH, DAY | 주어진 DATETIME값의 날짜(일) 반환 |

```sql
SELECT
  OrderDate,
  YEAR(OrderDate) AS YEAR,
  MONTHNAME(OrderDate) AS MONTHNAME,
  MONTH(OrderDate) AS MONTH,
  WEEKDAY(OrderDate) AS WEEKDAY,
  DAYNAME(OrderDate) AS DAYNAME,
  DAY(OrderDate) AS DAY
FROM Orders;
```

| 함수 | 설명 |
| --- | --- |
| HOUR | 주어진 DATETIME의 시 반환 |
| MINUTE | 주어진 DATETIME의 분 반환 |
| SECOND | 주어진 DATETIME의 초 반환 |

```sql
SELECT
  HOUR(NOW()), MINUTE(NOW()), SECOND(NOW());
```

| 함수 | 설명 |
| --- | --- |
| ADDDATE, DATE_ADD | 시간/날짜 더하기 |
| SUBDATE, DATE_SUB | 시간/날짜 빼기 |
|  |  |

```sql
SELECT 
  ADDDATE('2021-06-20', INTERVAL 1 YEAR),
  ADDDATE('2021-06-20', INTERVAL -2 MONTH),
  ADDDATE('2021-06-20', INTERVAL 3 WEEK),
  ADDDATE('2021-06-20', INTERVAL -4 DAY),
  ADDDATE('2021-06-20', INTERVAL -5 MINUTE),
  ADDDATE('2021-06-20 13:01:12', INTERVAL 6 SECOND);
```

| 함수 | 설명 |
| --- | --- |
|  |  |
| DATE_DIFF | 두 시간/날짜 간 일수차 |
| TIME_DIFF | 두 시간/날짜 간 시간차 |

```sql
SELECT
  OrderDate,
  NOW(),
  DATEDIFF(OrderDate, NOW())
FROM Orders;
```

| 함수 | 설명 |
| --- | --- |
| LAST_DAY | 해당 달의 마지막 날짜 |

```sql
SELECT
  OrderDate,
  LAST_DAY(OrderDate),
  DAY(LAST_DAY(OrderDate)),
  DATEDIFF(LAST_DAY(OrderDate), OrderDate)
FROM Orders;
```

| 함수 | 설명 |
| --- | --- |
| DATE_FORMAT | 시간/날짜를 지정한 형식으로 반환 |

| 형식 | 설명 |
| --- | --- |
| %Y | 년도 4자리 |
| %y | 년도 2자리 |
| %M | 월 영문 |
| %m | 월 숫자 |
| %D | 일 영문(1st, 2nd, 3rd...) |
| %d, %e | 일 숫자 (01 ~ 31) |
| %T | hh:mm:ss |
| %r | hh:mm:ss AM/PM |
| %H, %k | 시 (~23) |
| %h, %l | 시 (~12) |
| %i | 분 |
| %S, %s | 초 |
| %p | AM/PM |

```sql
SELECT
  DATE_FORMAT(NOW(), '%M %D, %Y %T'),
  DATE_FORMAT(NOW(), '%y-%m-%d %h:%i:%s %p'),
  DATE_FORMAT(NOW(), '%Y년 %m월 %d일 %p %h시 %i분 %s초');
```

```sql
SELECT REPLACE(
  REPLACE(
    DATE_FORMAT(NOW(), '%Y년 %m월 %d일 %p %h시 %i분 %초'),
    'AM', '오전'
  ),
  'PM', '오후'
)
```

| 함수 | 설명 |
| --- | --- |
| STR _ TO _ DATE(S, F) | S를 F형식으로 해석하여 시간/날짜 생성 |

```sql
SELECT
  DATEDIFF(
    STR_TO_DATE('2021-06-04 07:48:52', '%Y-%m-%d %T'),
    STR_TO_DATE('2021-06-01 12:30:05', '%Y-%m-%d %T')
  ),
  TIMEDIFF(
    STR_TO_DATE('2021-06-04 07:48:52', '%Y-%m-%d %T'),
    STR_TO_DATE('2021-06-01 12:30:05', '%Y-%m-%d %T')
  );
```

****[🐬 더 많은 시간/날짜 함수 보러가기 ▶️](https://dev.mysql.com/doc/refman/8.0/en/string-functions.html)****

---

## ****2. 기타 함수들****

| 형식 | 설명 |
| --- | --- |
| IF(조건, T, F) | 조건이 참이라면 T, 거짓이면 F 반환 |

```sql
SELECT IF (1 > 2, '1는 2보다 크다.', '1은 2보다 작다.');
```

****💡 보다 복잡한 조건은 CASE문을 사용합니다.****

```sql
SELECT
CASE
  WHEN -1 > 0 THEN '-1은 양수다.'
  WHEN -1 = 0 THEN '-1은 0이다.'
  ELSE '-1은 음수다.'
END;
```

| 형식 | 설명 |
| --- | --- |
| IFNULL(A, B) | A가 NULL일 시 B 출력 |

```sql
SELECT
  IFNULL('A', 'B'),
  IFNULL(NULL, 'B');
```

---

## ****조건에 따라 그룹으로 묶기****

### **1-3 복습 - 💡 그룹 함수**

⭐ *NULL*값은 집계하지 않습니다.

| 함수 | 설명 |
| --- | --- |
| MAX | 가장 큰 값 |
| MIN | 가장 작은 값 |
| COUNT | 갯수 (NULL값 제외) |
| SUM | 총합 |
| AVG | 평균 값 |

## ****1. GROUP BY - 조건에 따라 집계된 값을 가져옵니다.****

```sql
SELECT Country FROM Customers
GROUP BY Country;
```

****💡 여러 컬럼을 기준으로 그룹화할 수도 있습니다.****

```sql
SELECT 
  Country, City,
  CONCAT_WS(', ', City, Country)
FROM Customers
GROUP BY Country, City;
```

### ****📚 그룹 함수 활용하기****

```sql
SELECT
  COUNT(*), OrderDate
FROM Orders
GROUP BY OrderDate;
```

```sql
SELECT
  CategoryID,
  MAX(Price) AS MaxPrice, 
  MIN(Price) AS MinPrice,
  TRUNCATE((MAX(Price) + MIN(Price)) / 2, 2) AS MedianPrice,
  TRUNCATE(AVG(Price), 2) AS AveragePrice
FROM Products
GROUP BY CategoryID;
```

### ****💡 WITH ROLLUP - 전체의 집계값****

```sql
SELECT
  Country, COUNT(*)
FROM Suppliers
GROUP BY Country
WITH ROLLUP;
```

- 위의 각 집계함수 쿼리 끝에 *WITH ROLLUP* 을 추가해보세요.
- ⚠️ *ORDER BY* 와는 함께 사용될 수 없습니다.

### ****HAVING - 그룹화된 데이터 걸러내기****

```sql
SELECT
  Country, COUNT(*) AS Count
FROM Suppliers
GROUP BY Country
HAVING Count >= 3;
```

### ****💡 WHERE는 그룹하기 전 데이터, HAVING은 그룹 후 집계에 사용합니다.****

```sql
SELECT
  COUNT(*) AS Count, OrderDate
FROM Orders
WHERE OrderDate > DATE('1996-12-31')
GROUP BY OrderDate
HAVING Count > 2;
```

## ****2. DISTINCT - 중복된 값들을 제거합니다.****

- *GROUP BY* 와 달리 집계함수가 사용되지 않습니다.
- *GROUP BY* 와 달리 정렬하지 않으므로 더 빠릅니다.

```sql
SELECT DISTINCT CategoryID --SELECT 구간에서 쓴다
FROM Products;
-- 위의 GROUP BY를 사용한 쿼리와 결과 비교
```

```sql
SELECT DISTINCT Country
FROM Customers
ORDER BY Country;
```

### ****💡 GROUP BY와 DISTINCT 함께 활용하기****

```sql
SELECT
  Country,
  COUNT(DISTINCT CITY)
FROM Customers
GROUP BY Country;
```

---

# Section 02. SELECT 더 깊이 파보기

## ****쿼리 안에 서브쿼리****

### ****1. 비상관 서브쿼리****

```sql
SELECT
  CategoryID, CategoryName, Description,
  (SELECT ProductName FROM Products WHERE ProductID = 1)
FROM Categories;
```

```sql
SELECT * FROM Products
WHERE Price < (
  SELECT AVG(Price) FROM Products
);
```

```sql
SELECT
  CategoryID, CategoryName, Description
FROM Categories
WHERE
  CategoryID =
  (SELECT CategoryID FROM Products
  WHERE ProductName = 'Chais');
```

| 연산자 | 의미 |
| --- | --- |
| ~ ALL | 서브쿼리의 모든 결과에 대해 ~하다 |
| ~ ANY | 서브쿼리의 하나 이상의 결과에 대해 ~하다 |

```sql
SELECT * FROM Products
WHERE Price > ALL (
  SELECT Price FROM Products
  WHERE CategoryID = 2
);
```

```sql
SELECT
  CategoryID, CategoryName, Description
FROM Categories
WHERE
  CategoryID = ANY
  (SELECT CategoryID FROM Products
  WHERE Price > 50);
```

### ****2. 상관 서브쿼리****

```sql
SELECT
  ProductID, ProductName,
  (
    SELECT CategoryName FROM Categories C
    WHERE C.CategoryID = P.CategoryID --여기때문에 상관 서브쿼리?
  ) AS CategoryName
FROM Products P;
```

```sql
SELECT
  SupplierName, Country, City,
  (
    SELECT COUNT(*) FROM Customers C
    WHERE C.Country = S.Country
  ) AS CustomersInTheCountry,
  (
    SELECT COUNT(*) FROM Customers C
    WHERE C.Country = S.Country 
      AND C.City = S.City
  ) AS CustomersInTheCity
FROM Suppliers S;
```

```sql
SELECT
  CategoryID, CategoryName,
  (
    SELECT MAX(Price) FROM Products P
    WHERE P.CategoryID = C.CategoryID
  ) AS MaximumPrice,
  (
    SELECT AVG(Price) FROM Products P
    WHERE P.CategoryID = C.CategoryID
  ) AS AveragePrice
FROM Categories C;
```

### ****EXISTS / NOT EXISTS 연산자****

```sql
SELECT
  CategoryID, CategoryName
  -- ,(SELECT MAX(P.Price) FROM Products P
  -- WHERE P.CategoryID = C.CategoryID
  -- ) AS MaxPrice
FROM Categories C
WHERE EXISTS ( --조건절안에 존재하는가
  SELECT * FROM Products P
  WHERE P.CategoryID = C.CategoryID
  AND P.Price > 80
);
```

---

## ****JOIN - 여러 테이블 조립하기****

### ****1. JOIN(INNER JOIN) - 내부 조인****

- 양쪽 모두에 값이 있는 행(NOT NULL) 반환
- '*INNER* '는 선택사항

```sql
SELECT * FROM Categories C
JOIN Products P 
  ON C.CategoryID = P.CategoryID; --ON은 조건문과 비슷
```

```sql
SELECT C.CategoryID, C.CategoryName, P.ProductName
FROM Categories C
JOIN Products P 
  ON C.CategoryID = P.CategoryID; 

-- ambiguous 주의!
```

```sql
SELECT
  CONCAT(
    P.ProductName, ' by ', S.SupplierName
  ) AS Product,
  S.Phone, P.Price
FROM Products P
JOIN Suppliers S
  ON P.SupplierID = S.SupplierID
WHERE Price > 50
ORDER BY ProductName;
```

💡 여러 테이블을 **JOIN**
할 수 있습니다.

```sql
SELECT 
  C.CategoryID, C.CategoryName, 
  P.ProductName, 
  O.OrderDate,
  D.Quantity
FROM Categories C
JOIN Products P 
  ON C.CategoryID = P.CategoryID
JOIN OrderDetails D
  ON P.ProductID = D.ProductID
JOIN Orders O
  ON O.OrderID = D.OrderID;
```

💡 JOIN한 테이블 GROUP하기

```sql
SELECT 
  C.CategoryName,
  MIN(O.OrderDate) AS FirstOrder,
  MAX(O.OrderDate) AS LastOrder,
  SUM(D.Quantity) AS TotalQuantity
FROM Categories C
JOIN Products P 
  ON C.CategoryID = P.CategoryID
JOIN OrderDetails D
  ON P.ProductID = D.ProductID
JOIN Orders O
  ON O.OrderID = D.OrderID
GROUP BY C.CategoryID;
```

```sql
SELECT 
  C.CategoryName, P.ProductName,
  MIN(O.OrderDate) AS FirstOrder,
  MAX(O.OrderDate) AS LastOrder,
  SUM(D.Quantity) AS TotalQuantity
FROM Categories C
JOIN Products P 
  ON C.CategoryID = P.CategoryID
JOIN OrderDetails D
  ON P.ProductID = D.ProductID
JOIN Orders O
  ON O.OrderID = D.OrderID
GROUP BY C.CategoryID, P.ProductID;
```

### ****💡 SELF JOIN - 같은 테이블끼리****

```sql
SELECT
  E1.EmployeeID, CONCAT_WS(' ', E1.FirstName, E1.LastName) AS Employee,
  E2.EmployeeID, CONCAT_WS(' ', E2.FirstName, E2.LastName) AS NextEmployee
FROM Employees E1 JOIN Employees E2
ON E1.EmployeeID + 1 = E2.EmployeeID;

-- 1번의 전, 마지막 번호의 다음은?
```

### ****2. LEFT/RIGHT OUTER JOIN - 외부 조인****

- 반대쪽에 데이터가 있든 없든(NULL), 선택된 방향에 있으면 출력 - 행 수 결정
- '*OUTER* '는 선택사항

```sql
SELECT
  E1.EmployeeID, CONCAT_WS(' ', E1.FirstName, E1.LastName) AS Employee,
  E2.EmployeeID, CONCAT_WS(' ', E2.FirstName, E2.LastName) AS NextEmployee
FROM Employees E1
LEFT JOIN Employees E2
ON E1.EmployeeID + 1 = E2.EmployeeID
ORDER BY E1.EmployeeID;

-- LEFT를 RIGHT로 바꿔서도 실행해 볼 것
```

```sql
SELECT
  C.CustomerName, S.SupplierName,
  C.City, C.Country
FROM Customers C
LEFT JOIN Suppliers S
ON C.City = S.City AND C.Country = S.Country;

-- LEFT를 RIGHT로 바꿔서도 실행해 볼 것
```

```sql
SELECT
  IFNULL(C.CustomerName, '-- NO CUSTOMER --'),
  IFNULL(S.SupplierName, '-- NO SUPPLIER --'),
  IFNULL(C.City, S.City),
  IFNULL(C.Country, S.Country)
FROM Customers C
LEFT JOIN Suppliers S
ON C.City = S.City AND C.Country = S.Country;

-- LEFT를 RIGHT로 바꿔서도 실행해 볼 것
```

### ****3. CROSS JOIN - 교차 조인****

• 조건 없이 모든 조합 반환(A * B)

```sql
SELECT
  E1.LastName, E2.FirstName
FROM Employees E1
CROSS JOIN Employees E2
ORDER BY E1.EmployeeID;
```

---

## ****UNION - 집합으로 다루기****

| 연산자 | 설명 |
| --- | --- |
| UNION | 중복을 제거한 집합 |
| UNION ALL | 중복을 제거하지 않은 집합 |

```sql
SELECT CustomerName AS Name, City, Country, 'CUSTOMER'
FROM Customers
UNION
SELECT SupplierName AS Name, City, Country, 'SUPPLIER'
FROM Suppliers
ORDER BY Name;
```

### ****합집합****

```sql
SELECT CategoryID AS ID FROM Categories
WHERE CategoryID > 4
UNION
SELECT EmployeeID AS ID FROM Employees
WHERE EmployeeID % 2 = 0;

-- UNION ALL로 바꿔볼 것
```

### ****교집합****

```sql
SELECT CategoryID AS ID
FROM Categories C, Employees E
WHERE 
  C.CategoryID > 4
  AND E.EmployeeID % 2 = 0
  AND C.CategoryID = E.EmployeeID;
```

### ****차집합****

```sql
SELECT CategoryID AS ID
FROM Categories
WHERE 
  CategoryID > 4
  AND CategoryID NOT IN (
    SELECT EmployeeID
    FROM Employees
    WHERE EmployeeID % 2 = 0
  );
```

### ****대칭차집합****

```sql
SELECT ID FROM (
  SELECT CategoryID AS ID FROM Categories
  WHERE CategoryID > 4
  UNION ALL
  SELECT EmployeeID AS ID FROM Employees
  WHERE EmployeeID % 2 = 0
) AS Temp 
GROUP BY ID HAVING COUNT(*) = 1;
```

---

# Section 03. 데이터 조작하기

## ****테이블 만들고 데이터 입력하기****

### **1. 테이블 생성/수정/삭제**

### **CREATE TABLE - 테이블 만들기**

```sql
CREATE TABLE people (
  person_id INT,
  person_name VARCHAR(10),
  age TINYINT,
  birthday DATE
);
```

### ****ALTER TABLE - 테이블 변경****

```sql
-- 테이블명 변경
ALTER TABLE people RENAME TO  friends,
-- 컬럼 자료형 변경
CHANGE COLUMN person_id person_id TINYINT,
-- 컬럼명 변경
CHANGE COLUMN person_name person_nickname VARCHAR(10), 
-- 컬럼 삭제
DROP COLUMN birthday,
-- 컬럼 추가
ADD COLUMN is_married TINYINT AFTER age;
```

### ****DROP TABLE - 테이블 삭제****

```sql
DROP TABLE friends;
```

---

### ****2. INSERT INTO - 데이터 삽입****

```sql
INSERT INTO people
  (person_id, person_name, age, birthday)
  VALUES (1, '홍길동', 21, '2000-01-31');
```

```sql
-- 모든 컬럼에 값 넣을 때는 컬럼명들 생략 가능
INSERT INTO people
  VALUES (2, '전우치', 18, '2003-05-12');
```

```sql
-- 여러 행을 한 번에 입력 가능
INSERT INTO people
  (person_id, person_name, age, birthday)
  VALUES 
    (4, '존 스미스', 30, '1991-03-01'),
    (5, '루피 D. 몽키', 15, '2006-12-07'),
    (6, '황비홍', 24, '1997-10-30');
```

### ****3. 테이블 생성시 제약 넣기****

```sql
CREATE TABLE people (
  person_id INT AUTO_INCREMENT PRIMARY KEY,
  person_name VARCHAR(10) NOT NULL,
  nickname VARCHAR(10) UNIQUE NOT NULL,
  age TINYINT UNSIGNED,
  is_married TINYINT DEFAULT 0
);
```

| 제약 | 설명 |
| --- | --- |
| AUTO_INCREMENT | 새 행 생성시마다 자동으로 1씩 증가 |
| PRIMARY KEY | 중복 입력 불가, NULL(빈 값) 불가 |
| UNIQUE | 중복 입력 불가 |
| NOT NULL | NULL(빈 값) 입력 불가 |
| UNSIGNED | (숫자일시) 양수만 가능 |
| DEFAULT | 값 입력이 없을 시 기본값 |

### **💡 PRIMARY KEY (기본키)**

- 테이블마다 하나만 가능
- 기본적으로 인덱스 생성 (기본키 행 기준으로 빠른 검색 가능)
- 보통 **AUTO_INCREMENT**와 함께 사용
- ⭐ 각 행을 고유하게 식별 가능 - 테이블마다 하나씩 둘 것

```sql
INSERT INTO people 
  (person_name, nickname, age)
  VALUES ('김철수', '아이언워터', 10);
```

```sql
INSERT INTO people 
  (person_name, nickname, age)
  VALUES ('이불가', '임파서블', -2);
```

```sql
INSERT INTO people 
  (person_name, nickname, age, is_married)
  VALUES ('박쇳물', '아이언워터', NULL, 1);
  -- nickname에 NULL, '아이언수' 넣어보기
```

---

## ****자료형 (+ 예제 데이터)****

### ****1. 숫자 자료형****

### **[정수](https://dev.mysql.com/doc/refman/8.0/en/integer-types.html)**

| 자료형 | 바이트 | SIGNED | UNSIGNED |
| --- | --- | --- | --- |
| TINYINT | 1 | -128 ~ 127 | 0 ~ 255 |
| SMALLINT | 2 | -32,768 ~ 32,767 | 0 ~ 65,535 |
| MEDIUMINT | 3 | -8,388,608 ~ 8,388,607 | 0 ~ 16,777,215 |
| INT | 4 | -2,147,483,648 ~ 2,147,483,647 | 0 ~ 4,294,967,295 |
| BIGINT | 8 | -2^63 ~ 2^63 - 1 | 0 ~ 2^64 - 1 |

### **[고정 소수점(Fixed Point) 수](https://dev.mysql.com/doc/refman/8.0/en/fixed-point-types.html)**

- 좁은 범위의 수 표현 가능, 정확한 값

| 자료형 | 설명 | 범위 |
| --- | --- | --- |
| DECIMAL( s, d ) | 실수 부분 총 자릿수( s ) & 소수 부분 자릿수 ( d ) | s 최대 65 |

### **[부동 소수점(Floating Point) 수](https://dev.mysql.com/doc/refman/8.0/en/floating-point-types.html)**

- 넓은 범위의 수 표현 가능, 정확하지 않은 값 *(일반적으로 충분히 정확)*

| 자료형 | 표현 범위 |
| --- | --- |
| FLOAT | -3.402...E+38 ~ -1.175...E-38 , 0 , 1.175...E-38 ~ 3.402...E+38 |
| DOUBLE | -1.797...E+308 ~ -2.225E-308 , 0 , 2.225...E-308 ~ 1.797...E+308 |

---

### ****2. 문자 자료형****

### **[문자열](https://dev.mysql.com/doc/refman/8.0/en/char.html)**

- 위 링크에서 **Storage Required** 관련 표 비교

| 자료형 | 설명 | 차지하는 바이트 | 최대 바이트 |
| --- | --- | --- | --- |
| CHAR( s ) | 고정 사이즈 (남는 글자 스페이스로 채움) | s (고정값) | 255 |
| VARCHAR ( s ) | 가변 사이즈 | 실제 글자 수[최대 s] + 1 [글자수 정보] | 65,535 |
- 검색시 CHAR가 더 빠름
- VARCHAR 컬럼 길이값이 **4글자**보다 적을 경우 CHAR로 자동 변환

### **[텍스트](https://dev.mysql.com/doc/refman/8.0/en/blob.html)**

| 자료형 | 최대 바이트 크기 |
| --- | --- |
| TINYTEXT | 255 |
| TEXT | 65,535 |
| MEDIUMTEXT | 16,777,215 |
| LONGTEXT | 4,294,967,295 |

## **3. 시간 자료형**

### **[️🔗 참고페이지](https://dev.mysql.com/doc/refman/8.0/en/date-and-time-types.html)**

| 자료형 | 설명 | 비고 |
| --- | --- | --- |
| DATE | YYYY-MM-DD |  |
| TIME | HHH:MI:SS | HHH: -838 ~ 838까지의 시간 |
| DATETIME | YYYY-MM-DD HH:MI:SS | 입력된 시간을 그 값 자체로 저장 |
| TIMESTAMP | YYYY-MM-DD HH:MI:SS | MySQL이 설치된 컴퓨터의 시간대를 기준으로 저장 |
- 시간 데이터를 가감없이 기록할 때 **DATETIME**
- 시간 자동기록, 국제적인 서비스를 할 경우 **TIMESTAMP** 사용

---

## ****데이터 변경, 삭제하기****

## **1. DELETE - 주어진 조건의 행 삭제하기**

⭐ *Preferences* > *SQL Editor* > **Safe Updates** 항목 체크오프하고 다시 접속

```sql
DELETE FROM businesses
WHERE status = 'CLS';
```

### ****DELETE 문으로 행 전체 삭제****

```sql
DELETE FROM businesses;
```

```sql
INSERT INTO businesses (fk_section_id, business_name, status, can_takeout)
VALUES  (3, '화룡각', 'OPN', 1),
        (2, '철구분식', 'OPN', 1),
        (5, '얄코렐라', 'RMD', 1);
```

### ****💡 TRUNCATE 문으로 테이블 초기화****

```sql
TRUNCATE businesses;
```

```sql
INSERT INTO businesses (fk_section_id, business_name, status, can_takeout)
VALUES  (3, '화룡각', 'OPN', 1),
        (2, '철구분식', 'OPN', 1),
        (5, '얄코렐라', 'RMD', 1);
```

### ****2. UPDATE - 주어진 조건의 행 수정하기****

```sql
UPDATE menus
SET menu_name = '삼선짜장'
WHERE menu_id = 12;
```

### ****여러 컬럼 수정하기****

```sql
UPDATE menus
SET 
  menu_name = '열정떡볶이',
  kilocalories = 492.78,
  price = 5000
WHERE 
  fk_business_id = 4
  AND menu_name = '국물떡볶이';
```

### ****컬럼 데이터 활용하여 수정하기****

```sql
UPDATE menus
SET price = price + 1000
WHERE fk_business_id = 8;
```

```sql
UPDATE menus
SET menu_name = CONCAT('전통 ', menu_name)
WHERE fk_business_id IN (
  SELECT business_id 
  FROM sections S
  LEFT JOIN businesses B
    ON S.section_id = B.fk_section_id 
  WHERE section_name = '한식'
);
```

### ****⚠️ 조건문 없이는 모든 행 변경****

```sql
UPDATE menus
SET menu_name = '획일화';
```
