# 18. 입력할 내용이 많은 경우는 POST 요청

![Untitled](https://user-images.githubusercontent.com/80089860/158416985-bed8646d-aa77-49da-b70b-f9ac6ea3b5e6.png)

![Untitled 1](https://user-images.githubusercontent.com/80089860/158417003-b6148413-0159-4cf2-b70b-a5ffdf5a9459.png)

1. **Mapping 명(form안의 action명과 Java에서 어노테이션명)을 똑같이 할 것**
2. **html의 form안에 있는 name명을 똑같이 할 것**
3. **실행은 html에서 실행할 것**

---

![Untitled 2](https://user-images.githubusercontent.com/80089860/158417042-4e67c11d-abf4-4e75-86ce-bc038f92fcb2.png)

### GET방식의 단점

![Untitled 3](https://user-images.githubusercontent.com/80089860/158417060-da5583d7-7570-4fef-baa0-7014d669a58b.png)

**Parameter 구간에서 쿼리스트링의 길이가 길어지는대로**

**주소의 길이가 늘어난다**

**쿼리(스트링)의 데이터가 엄청나게 많아진다면,**

**주소의 길이도 방대하게 길어지는 단점이 있다**

쿼리스트링이 길어지면 POST방식을 사용하는것이 좋을듯싶다

---

![Untitled 4](https://user-images.githubusercontent.com/80089860/158417100-db443761-ac95-47f1-babb-d97c8e34fa57.png)

**Request 방식에서 GET, POST 방식이 아닌,** 

**위처럼 아무것도 안적혀있는 방법으로 요청할때는**

**입력받은 쿼리값으로 전달된다**

- **POST방식**

![Untitled 5](https://user-images.githubusercontent.com/80089860/158417122-f64509ff-6eba-4989-a32e-e9bdd6f02183.png)

**처럼 주소의 길이가 간결하다**
