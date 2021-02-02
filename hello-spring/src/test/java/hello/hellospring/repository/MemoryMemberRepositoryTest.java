package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;


class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

//    테스트가 끝날때마다 메모리를 지워주는 메소드
//    메서드가 실행 끝날때마다 어떤 동작을 하는 메서드
//    테스트는 서로 의존관계가 없이 설계되어야한다. 매우중요!!
//    test 먼저 만들고 구현체만드는 개발이 TDD!!! 테스트 주도개발. 이번시간에 한건 그냥 테스트를 만들어본 것
    @AfterEach
    public void afterEach(){

        repository.clearStore();

    }

    @Test
    public void save(){

        Member member = new Member();
        member.setName("spring");

        repository.save(member);

//        findById 반환타입 : optional (get()으로 꺼낼 수 있다)
       Member result =  repository.findById(member.getId()).get();

//      검증
//       <<1>>
//        System.out.println("result = " + (result==member));

//       <<2>>
//        Assertions.assertEquals(member,null);

//        << 3 >>
//        Assertions static import 함
        assertThat(member).isEqualTo(result);

    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        //shift + F6 rename
        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);


    }

    @Test
    public void findAll(){

        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);

    }



}
