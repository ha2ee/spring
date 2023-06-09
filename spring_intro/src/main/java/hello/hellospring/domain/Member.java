package hello.hellospring.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Member {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 고객이 정하는 아이디가 아닌 시퀀스가 오르던 하는 ,임의의 값(시스템에 저장하는 아이디)
    
    private String name;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
