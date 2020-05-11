package com.kang.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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
public class MyUser implements UserDetails, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7492073808779282862L;

	@Id
	private Long id;

	private String loginName;

	private String pwd;
	
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

    private boolean enabled = true;
    
    private Set<GrantedAuthority> authorities;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return pwd;
	}

	@Override
	public String getUsername() {
		return loginName;
	}

}
