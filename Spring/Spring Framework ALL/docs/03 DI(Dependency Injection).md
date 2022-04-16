# 03 DI(Dependency Injection)

### Sping Framework Core Function : 종속 객체를 생성, 조립해주는 도구

## **DI(Dependency Injection)**

- **사전적 의미 :** 종속성 주입
- **실질적 의미** : ***부품조립 == 부품(종속성, Dependency)  / 조립(주입, Injection)***

```sql
**Composition has a '일체형 부품' (붙박이)**

class A
  {
    private B b;    // B는 A의 종속되어 있다. B는 A의 부품이다.
										// B는 종속객체.종속성 == 부품
    public A(){
      **b = new B()**;   // 직접 만들어 끼우는 일체형 부품
 **// 클래스 A를 만들 때, B도 따라 만들어진다 (일체형처럼)**
    }
  }
```

```sql
**Association has a '조립형 부품'
// 일체형에 비해 느슨한 결합(약한 결합) == 조립형 결합**

class B
  {
    private B b;    // 

    public A(){
      ~~b = new B();~~   // 
    }
  }

	**public void setB(B b) {
		this.b = b;
	}**
}
```

- **조립형 결합**
    - **장점 : 부품을 쉽게 바꿀 수 있다. 즉, upadte에 용이함**
    - **단점 : 부품을 생성해서 조립해야 하는 번거로움**

*단점의 예시*

```html
B b = new B(); // **부품(dependency)**
A a = new A(); // A입장에서 B는 부품이다

a.setB(b); // 이렇게 직접 부품을 꽃아주어야 한다 B를 a에다가 조립(주입)
```

### 부품을 조립방법

1. *setter 함수를 통해 조립할 수 있다*

![Untitled](03%20DI(Depe%20b8dd5/Untitled.png)

1. *생성자를 통해 조립할 수 있다*

![Untitled](03%20DI(Depe%20b8dd5/Untitled%201.png)

![Untitled](03%20DI(Depe%20b8dd5/Untitled%202.png)