package com.unico.online.users.dto;

import java.time.LocalDateTime;

import lombok.Data;


@Data
public class UserDTO {
	String userId;
	String userPwd;
	String userNm;
	boolean useYn;
	LocalDateTime createdAt;
	LocalDateTime updatedAt;

}
