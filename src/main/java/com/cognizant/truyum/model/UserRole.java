package com.cognizant.truyum.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class UserRole {

	@Id
	@Column(name = "ur_id")
	private long urId;

	@ManyToOne
	@JoinColumn(name = "ur_us_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "ur_ro_id")
	private Role role;

	public UserRole(long urId, User user, Role role) {
		super();
		this.urId = urId;
		this.user = user;
		this.role = role;
	}

	public long getUrId() {
		return urId;
	}

	public void setUrId(long urId) {
		this.urId = urId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
