package org.artemsementsov.udemyspringforbeginners.mail;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
public class MailConfig {

    @Bean
    public DemoBean demoBean() {
        return new DemoBean();
    }

    @Bean
    @ConditionalOnProperty(name = "spring.mail.host", havingValue = "foo", matchIfMissing = true)
    public MailSender mockMailSender() {
        return new MockMailSender();
    }

    @ConditionalOnProperty("spring.mail.host")
    @Bean
    public MailSender smtpMailSender(JavaMailSender javaMailSender, DemoBean demoBean) {
        return new SmtpMailSender(javaMailSender);
    }
}
