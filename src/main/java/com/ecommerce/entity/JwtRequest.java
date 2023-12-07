package com.ecommerce.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JwtRequest {

    private String userName;
    private String userPassword;
}
