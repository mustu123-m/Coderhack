package com.crio.coderhack.Dto;

import org.springframework.data.annotation.Id;

import lombok.Data;
@Data
public class UserDto {
    @Id
    private String userId;
    private String username;
}
