package de.arvato.employeemodule.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Entity
@Table(name = "employee")
public class Employee implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name="name")
	private String name;

	@Column(name="surname")
	private String surname;

	@Column(name="supervisor")
	private boolean supervisor;

	@Column(name="email")
	private String email;

}
