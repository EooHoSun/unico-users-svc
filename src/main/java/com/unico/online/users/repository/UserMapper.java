package com.unico.online.users.repository;

import java.util.List;

import com.unico.EntityMapper;
import org.mapstruct.Mapper;

import com.unico.online.users.dto.UserDTO;
import com.unico.online.users.entity.UserEntity;

@Mapper(componentModel = "spring")
public interface UserMapper extends EntityMapper<UserEntity,UserDTO> {
}
