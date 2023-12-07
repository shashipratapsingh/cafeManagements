package com.ecommerce.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JwtResponse {

    private User user;
    private String jwtToken;
}
