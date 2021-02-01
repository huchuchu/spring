package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
     public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello";

     }

     @GetMapping("hello-mvc")
     public String helloMvc(@RequestParam(value = "name")String name, Model model){
        model.addAttribute("name",name);
        return "hello-template";
     }

     /*
     * ResponseBody
     * http에서 header, body로 나누어져있음
     * body부에 내가 데이터를 직접 넣어주겠다
     * */
     @GetMapping("hello-string")
     @ResponseBody
    public String helloString(@RequestParam("name") String name){

        return "hello" + name;
     }

     @GetMapping("hello-api")
     @ResponseBody

     public Hello helloApi(@RequestParam("name") String name){
         Hello hello = new Hello();
         hello.setName(name);

         return hello;

     }

    // 프로퍼티 접근방식
    // 자바빈 규약
    static class Hello{
         private String name;

         public String getName() {
             return name;
         }

         public void setName(String name) {
             this.name = name;
         }
     }





}
