package de.arvato.vacationrequestmodule.data;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Year;


@Getter
@Setter
@Entity
@Table(name = "VacationTracking")
public class VacationTracking implements Serializable {

    @Id
    @Column(nullable = false)
    private Long empId;

     private Short year;

    private int allowedVacations;
}
