package de.arvato.vacationrequestmodule.data;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;

@Getter
@Setter
@Entity
@Table(name = "VacationTracking")
public class VacationTracking implements Serializable {

    @Id
    @Column(nullable = false)
    private Long empId;

    private Date year;

    private int allowedVacations;
}
