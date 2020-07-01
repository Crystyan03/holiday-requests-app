package de.arvato.employeemodule.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;



@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "employee")
public class EmployeeDO implements Serializable {

	@Id
	@Generated
	private Long id;

	@Column(name="name")
	String name;

	@Column(name="sure_name")
	String sureName;

	@Column(name="supervisor")
	String supervisor;

	@Column(name="email")
	String email;

}
