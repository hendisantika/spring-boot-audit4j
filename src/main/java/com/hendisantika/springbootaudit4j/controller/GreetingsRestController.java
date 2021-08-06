package com.hendisantika.springbootaudit4j.controller;

import com.hendisantika.springbootaudit4j.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-audit4j
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 07/08/21
 * Time: 05.58
 */
@RestController
public class GreetingsRestController {

    @Autowired
    HelloService helloService;

    @GetMapping(value = {"/", "/welcome"}, produces = "application/json")
    public String welcome() {
        String name = "anonymous";
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            name = ((UserDetails) authentication.getPrincipal()).getUsername();
        }
        return helloService.hello(name);
    }
}
