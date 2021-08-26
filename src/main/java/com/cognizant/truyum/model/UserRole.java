package com.cognizant.truyum.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
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

}
