package de.arvato.vacationrequestmodule.data;


import lombok.Data;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "VacationRequests")
public class VacationRequest implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "fromDate")
    private LocalDate from;

    @Column(name = "toDate")
    private LocalDate to;

    private String status;

    @Column(nullable = false)
    private Long employeeId;

    @Column(nullable = false)
    private Long supervisorId;
}
