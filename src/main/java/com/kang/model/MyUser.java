package com.kang.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

/**
　 * <p>Title: User</p> 
　 * <p>Description: 用户实体类</p> 
　 * @author CK 
　 * @date 2020年4月20日
 */
@Setter
@Getter
@Entity
@Table(name="tb_user")
public class MyUser implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7492073808779282862L;

	@Id
	private Long id;

	private String loginName;

	private String pwd;
	
	
	private String userName;

	private String tel;
	
	private String icon;

	private Boolean gender;

	private Date birthday;

	private String email;

	private String addr;

	private Date createTime;

	private Boolean isDel;
	
	private Long roleId;
	
	@Transient
	private String roleName;
	
	private boolean accountNonExpired = true;

    private boolean accountNonLocked= true;

    private boolean credentialsNonExpired= true;

    private boolean enabled= true;

}
