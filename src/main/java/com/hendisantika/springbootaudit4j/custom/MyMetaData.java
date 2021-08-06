package com.hendisantika.springbootaudit4j.custom;

import org.audit4j.core.MetaData;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-audit4j
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 07/08/21
 * Time: 05.55
 */
public class MyMetaData implements MetaData {

    public String getActor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            return ((UserDetails) authentication.getPrincipal()).getUsername();
        }
        return "anonymous";
    }

    public String getOrigin() {
        try {
            return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getRemoteAddr();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "unidentified";
    }
}
