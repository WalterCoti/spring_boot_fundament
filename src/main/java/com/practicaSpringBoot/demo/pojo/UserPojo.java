package com.practicaSpringBoot.demo.pojo;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "user")
@Data       //lo
@Getter
@Setter
@AllArgsConstructor
@ToString
public class UserPojo {
    private String email;
    private String password;
    private int edad;

}
