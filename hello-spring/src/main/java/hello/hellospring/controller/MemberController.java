package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

//    필요할 때 마다 객체를 만들어서 쓰는게 아니라 springcontainer에 등록을 하고 꺼내쓰자!
//    private final MemberService memberService = new MemberService();

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public  String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";

    }

    @GetMapping("/members")
    public  String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return"members/memberList";
    }




}
