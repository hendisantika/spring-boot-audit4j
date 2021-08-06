package com.hendisantika.springbootaudit4j.service;

import org.audit4j.core.annotation.Audit;
import org.audit4j.core.annotation.AuditField;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-audit4j
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 07/08/21
 * Time: 05.57
 */
@Service
public class HelloService {

    @Audit(action = "HelloService.hello")
    public String hello(@AuditField(field = "loggedInUsername") String name) {
        return "Welcome " + name;
    }
}
