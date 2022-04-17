package hello.hellospring.domain;

public class Member {

    private long id;
    private String name;

    // 생성하는 단축키 : 알트 + insert
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
