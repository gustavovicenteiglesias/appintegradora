package com.unsada.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.*;


/**
 * The persistent class for the authority database table.
 * 
 */
@Entity
@Table(name="authority")
@NamedQuery(name="Authority.findAll", query="SELECT a FROM Authority a")
public class Authority implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idAuthority;

	private String role;
	
	 @ManyToMany(cascade = {
	            CascadeType.PERSIST,
	            CascadeType.MERGE
	    })
	    @JoinTable(
	            name = "user_authority",
	            joinColumns = {@JoinColumn(name = "id_authority")},
	            inverseJoinColumns = {@JoinColumn(name = "id_user")}
	    )
	    private List<User> user;

	public Authority() {
	}

	public int getIdAuthority() {
		return idAuthority;
	}

	public void setIdAuthority(int idAuthority) {
		this.idAuthority = idAuthority;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}