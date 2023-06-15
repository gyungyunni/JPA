package com.example.jpa;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
// @Controller
@RestController // 모든 메소드에 @ResponseBody를 붙이는 용도
public class AppController {
    // 사용자의 입력을 받는 요소 MVC 의 C역할을 맡는다.
    // RequestMapping과 같이 사용

    private final AppService service;

    public AppController(AppService service) {
        this.service = service;
    }
    /*

    @RequestMapping("students")
    public void students(){
        List<Object> result = service.readStudentAll();
    }
    @GetMapping("home") // HTML / DATA
    public String home(){
        return "home"; // 어떤 html을 찾아야하는데 없다 물결이 경고의뜻
    }
    @GetMapping("body")
    public String body(){
        return "body"; // 더이상 html이 아니다?
    }
    */

    @GetMapping("create")
    public @ResponseBody String create(){
        this.service.createStudent(
                "alex",
                35,
                "010-1234-5678",
                "alex@gmail.com"

        );
        return "done";
    }

    @GetMapping("read-all")
    public @ResponseBody String readAll(){
        this.service.readStudentAll();
        return "done-read-all";

    }
    @GetMapping("read")
    public @ResponseBody String readOne(){
        this.service.readStudentAll();
        return "done-read-one";

    }

    @GetMapping("update")
    public @ResponseBody String update() {
        this.service.updateStudent(1L, "alexander");
        return "done-update";
    }

    @GetMapping("delete")
    public @ResponseBody String delete() {
        this.service.deleteStudent(1L);
        return "done-delete";
    }

    @GetMapping("find")
    public @ResponseBody String find() {
        this.service.findAllByTest();
        return "done-find";
    }
}