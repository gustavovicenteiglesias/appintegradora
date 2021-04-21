package com.unsada.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name="user")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
	private Integer  idUser;
	private String password;
	private String username;
	private Boolean enabled;
	
	 @ManyToMany(mappedBy = "user")
	 private List<Authority>  authority;
	 
	 

	public User() {
		super();
	}



	public Integer getIdUser() {
		return idUser;
	}



	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public Boolean getEnabled() {
		return enabled;
	}



	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}



	public List<Authority> getAuthority() {
		return authority;
	}



	public void setAuthority(List<Authority> authority) {
		this.authority = authority;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	 
	 
	
}	
	
	