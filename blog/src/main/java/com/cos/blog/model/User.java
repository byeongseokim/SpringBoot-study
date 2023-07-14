package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder // 빌더 패턴!
//ORM  -> Java(다른언어) Object -> 테이블 매핑해주는 기술
@Entity // User클래스가 MySQL에 테이블이 생성이 된다.
//@DynamicInsert  // insert시에 null인 필드를 제외시켜준다.
public class User {

	@Id // Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 프로젝트에서 연결된 DB의 넘버링 전략을 따라감.
	private int id; // 시퀀스, auto_increment // SEQUENCE, TABLE, AUTO등이 있음

	@Column(nullable = false, length=30, unique=true)
	private String username; // 아이디

	@Column(nullable = false,length=50)
	private String email; //myEMail, my_email
	
	@ColumnDefault("'user'") //안쪽에 작은 따옴표
	//DB는 RoleType 이라는 것이 없다.
	//@Enumerated(EnumType.STRING)
	//private RoleType role;  // Enum을 쓰는게 좋다. // ADMIN, USER
	private String role;
	
	//내가 직접 시간을 넣으려면 Timestamp.valueOf(LocalDateTime.now())
	@CreationTimestamp //시간이 자동 입력
	private Timestamp createDate;

}
