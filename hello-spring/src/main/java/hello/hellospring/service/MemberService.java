package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


//ctrl + shift + T :: 새로운 테스트

@Transactional
public class MemberService {


    private final MemberRepository memberRepository;

//    DI

    public MemberService( MemberRepository memberRepository) {
        this.memberRepository = memberRepository;

    }


    /**
     * 회원가입
     *
     */
    public Long join(Member member){

//        같은 이름이 있는 중복회원은 안됨
//        ctrl + alt + v
//        optional 때문에 ifPresent메서드 사용이 가능하다
//        과거에는 if == null 로직을 사용했지만 optional로 감싸주면 여러 메서드를 사용할 수 있다!
//        BUT!! optional로 바로 꺼내는것을 권장하지는 않는다!
//        이미 findByName 을 반환할 때  optional타입으로 반환하기때문에!        
//
//        << 1 >>        
//        Optional<Member> result = memberRepository.findByName(member.getName());
//        result.ifPresent(m -> {
//            throw new IllegalStateException("이미 존재하는 회원입니다");
//        });
        
//        << 2 >>
//        findByName 의 로직이 쭉 나오기때문에 ?? 이런 경우에는 메서드로 뽑는게 낫다
//          단축키 : Ctrl+Alt+Shift+T (리팩토링 관련 단축키) /  Extract Method...
//        memberRepository.findByName(member.getName())
//                .ifPresent(m -> {
//                    throw new IllegalStateException("이미 존재하는 회원입니다");
//                });

//        << 3 >>
        validateDuplicateMember(member); // 중복회원검증
        memberRepository.save(member);

        return member.getId();
   }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다");
                });
    }

    /**
     * 전체 회원 조회
     * @return
     */
    public List<Member> findMembers(){
      return   memberRepository.findAll();

    }

    public  Optional<Member> findOne (Long memberID){
        return memberRepository.findById(memberID);
    }


}
