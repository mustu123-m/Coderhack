package com.crio.coderhack.Mappers;

import com.crio.coderhack.Dto.UserDto;
import com.crio.coderhack.Entities.User;

public class UserMapper {
    public User toEntity(UserDto userDto)
    {
        User user=new User(userDto.getUserId(),userDto.getUsername());
        return user;
    }
}
