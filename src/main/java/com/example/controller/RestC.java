package com.example.controller;

/**
 * @author w00990
 */

import cn.hutool.core.lang.Console;
import com.example.dto.Person;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Slf4j
@RestController
@RequestMapping("/RestC/")
@RequiredArgsConstructor
public class RestC {
  

    @GetMapping("login")
    public String login(@NotBlank String username, String password) {
        Person build = Person.builder()
                .username(username)
                .password(password)
                .build();
        Console.log("build=>" + build);
        return build.getUsername();
    }

    @PostMapping("register")
    public String register(@Valid Person person, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        Console.log("requ=>" + request.getMethod());
        response.setStatus(101);
        Console.log("resp=>" + response.getHeader("JSESSIONID"));
        Console.log("resp=>" + session.getId());
        Console.log("person=>" + person);
        return person.getUsername();
    }

}
