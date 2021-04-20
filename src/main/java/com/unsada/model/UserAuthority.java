package com.unsada.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the user_authority database table.
 * 
 */
@Entity
@Table(name="user_authority")
@NamedQuery(name="UserAuthority.findAll", query="SELECT u FROM UserAuthority u")
public class UserAuthority implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UserAuthorityPK id;

	public UserAuthority() {
	}

	public UserAuthorityPK getId() {
		return this.id;
	}

	public void setId(UserAuthorityPK id) {
		this.id = id;
	}

}