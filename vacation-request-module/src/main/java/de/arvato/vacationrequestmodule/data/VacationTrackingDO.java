package de.arvato.vacationrequestmodule.data;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "VacationTracking")
public class VacationTrackingDO implements Serializable {

    @Id
    @Column(nullable = false)
    private String empId;

    private String year;

    private int allowedVacations;
}
