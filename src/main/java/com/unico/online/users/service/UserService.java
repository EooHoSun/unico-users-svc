package com.unico.online.users.service;

import com.unico.online.users.dto.UserDTO;
import com.unico.online.users.entity.UserEntity;
import com.unico.online.users.repository.UserMapper;
import com.unico.online.users.repository.UserRepository;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;


@Transactional
@Service
@AllArgsConstructor
public class UserService {
	UserRepository repository;
	UserMapper mapper;

	
	public List<UserDTO> findAll(){
		repository.findAll();
		System.out.println("a");
		return mapper.toDTOList(repository.findAll());
	}

	public UserDTO saveUser(UserDTO dto){
		
		if( repository.existsById(dto.getUserId()) ){
			return null;
		} else {
			UserEntity entity = UserEntity.builder()
					.userId(dto.getUserId())
					.userPwd(dto.getUserPwd())
					.userNm(dto.getUserNm())
					.useYn(true)
					.createdAt(LocalDateTime.now())
					.updatedAt(null)
					.build();

			return mapper.toDTO( repository.save( entity ) );
		}

	}

	public UserDTO updateUser( UserDTO dto){
		if( repository.existsById(dto.getUserId()) ){
			UserEntity entity = repository.findById(dto.getUserId()).orElse(null);
			entity.updateUserNm(dto.getUserNm());
			entity.updateUserPwd(dto.getUserPwd());
			entity.updateUseYn(dto.isUseYn());
			return mapper.toDTO(entity);
		} else {
			return null;
		}
	}


	public boolean delete(String userId){
		if( repository.existsById( userId ) ){
			repository.deleteById(userId);
			return !repository.existsById(userId);
		} else {
			return false;
		}
	}
}
