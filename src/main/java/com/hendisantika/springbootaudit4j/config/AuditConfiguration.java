package com.hendisantika.springbootaudit4j.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.env.Environment;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-audit4j
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 07/08/21
 * Time: 05.51
 */
@Configuration
@EnableAspectJAutoProxy
public class AuditConfiguration {

    @Autowired
    private Environment environment;
}
