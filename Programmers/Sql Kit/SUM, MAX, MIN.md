# SUM, MAX, MIN

### [최대값 구하기](https://programmers.co.kr/learn/courses/30/lessons/59415)

```sql
SELECT MAX(DATETIME) AS '시간'
FROM ANIMAL_INS;
```

### [최솟값 구하기](https://programmers.co.kr/learn/courses/30/lessons/59038)

```sql
SELECT MIN(DATETIME) AS '시간'
FROM ANIMAL_INS;
```

### [동물 수 구하기](https://programmers.co.kr/learn/courses/30/lessons/59406)

```sql
SELECT COUNT(*) AS 'count'
FROM ANIMAL_INS;
```

### [중복 제거하기](https://programmers.co.kr/learn/courses/30/lessons/59408)

```sql
SELECT COUNT(DISTINCT NAME) as 'count'
FROM ANIMAL_INS
WHERE NAME IS NOT NULL;
```