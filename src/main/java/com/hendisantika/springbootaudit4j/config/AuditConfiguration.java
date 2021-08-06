package com.hendisantika.springbootaudit4j.config;

import org.audit4j.core.MetaData;
import org.audit4j.core.handler.file.FileAuditHandler;
import org.audit4j.core.layout.Layout;
import org.audit4j.core.layout.SimpleLayout;
import org.audit4j.handler.db.DatabaseAuditHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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

    @Bean
    public Layout layout() {
        return new SimpleLayout();
    }

    @Bean
    public MetaData metaData() {
        return new MyMetaData();
    }

    @Bean
    public DatabaseAuditHandler databaseHandler() {
        DatabaseAuditHandler databaseHandler = new DatabaseAuditHandler();
        databaseHandler.setEmbedded("false");
        databaseHandler.setDb_user(environment.getRequiredProperty("DB_ROOT_USER"));
        databaseHandler.setDb_password(environment.getRequiredProperty("DB_PASS"));
        databaseHandler.setDb_url(environment.getRequiredProperty("DB_URL"));
        databaseHandler.setDb_driver(environment.getRequiredProperty("DB_DRIVER"));
        return databaseHandler;
    }

    @Bean
    public FileAuditHandler fileAuditHandler() {
        FileAuditHandler fileAuditHandler = new FileAuditHandler();
        return fileAuditHandler;
    }
}
