package com.cognizant.truyum.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class MenuItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="me_id")
	private long id;

	@NotBlank(message = "Name is required")
	@Pattern(regexp = "^[a-zA-Z][a-zA-Z\\s]{2,65}$", message ="Name should have 2 to 65 characters")
	@Column(name="me_name")
	private String name;

	@Column(name="me_price")
	@NotNull
    @Digits(integer=5, fraction=2, message = "price should respect the following format xxxxx.xx")
	private float price;

	@Column(name="me_active")
	private boolean active;

	@NotNull(message = "Launch Date required")
	@Column(name="me_date_of_launch")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date dateOfLaunch;

	@Column(name="me_category")
	private String category;
	
	@Column(name="me_free_delivery")
	private boolean freeDelivery;

}
