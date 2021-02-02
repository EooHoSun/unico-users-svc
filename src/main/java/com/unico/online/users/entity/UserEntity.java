package com.unico.online.users.entity;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
@Builder
@Getter
@Table( name = "TB_UNICO_USERS_M" )
public class UserEntity {
	
	@Id
	String userId;
	String userPwd;
	String userNm;
	boolean useYn;
	LocalDateTime createdAt;
	LocalDateTime updatedAt;


	public void updateUserPwd(String userPwd){
		if( userPwd != ""  && this.userPwd != userPwd){
			this.userPwd = userPwd;
			this.updatedAt = LocalDateTime.now();
		}
	}
	public void updateUserNm(String userNm){
		if( userNm != "" && this.userNm != userNm){
			this.userNm = userNm;
			this.updatedAt = LocalDateTime.now();
		}
	}
	public void updateUseYn(boolean useYn){
		if( this.useYn != useYn ){
			this.useYn = useYn;
			this.updatedAt = LocalDateTime.now();
		}
	}


}
