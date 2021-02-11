package hello.hellospring.domain;

import javax.persistence.*;

//JPA가 관리하는 entity
@Entity
public class Member {

    // PK설정
    // h2 DB에서 Name을 insert하면 ID를 자동생성되게 설정해 놨다. 이러한것을 identity전략 이라고한다
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 만약 DB컬럼명이 username이라면 @Column(name="username") 이렇게 적어준다. 그럼 db에서 username을 찾아서 맵핑해줌
    private  String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
