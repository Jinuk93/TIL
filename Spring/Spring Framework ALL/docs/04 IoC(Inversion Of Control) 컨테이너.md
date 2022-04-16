# 04 IoC(Inversion Of Control) 컨테이너

## IoC = 조립까지 해주는 부품을 담고있는 컨테이너

### 조립 컴퓨터 구매할 때, → 컴퓨터 가게에 조립맡김 → 조립해서 담아줌

### 조립순서 : 작은 부품에서부터 → 큰 부품 순서로 조립

### *일체형 조립*

```java
//일체형 조립

class C {
    private D d;
    
    public C(){
        d = new D();
    }
}
 
class B {
    private C c;
    
    public B(){
        c = new C();
    }
}
 
class A {
    private B b;
    
    public A(){
        b = new B();
    }
}
```

```java
//호출
A a = new A();
```

- ***조립 순서 : A → B → C → D***

### *조립형*

```java
class C {
    private D d;
    
    public C(D d){
       this.d = d;
    }
}
 
class B {
    private C c;
    
    public B(C c){
        this.c = c;
    }
}
 
class A {
    private B b;
    
    public A(B b){
        this.b = b;
    }
```

호출

```java
D d = new D();
C c = new C(d);
B b = new B(c);
A a = new A(b);
```

- ***조립 순서 : D → C → B → A***

### *일체형의 역순이다*

*IoC 컨테이너는 역순으로 생성 후 **조립**을 실시한다.* 

*즉  **Inversion(역순)으로 생성하는 컨테이너이므로 IoC 컨테이너**라고 한다.*

![Untitled](https://user-images.githubusercontent.com/80089860/163683013-c3b726a0-ac73-4105-9300-7b58c257e6be.png)
