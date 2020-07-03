package de.arvato.vacationrequestmodule.data;


import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "VacationRequests")
public class VacationRequest implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long requestID;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="fromDate")
    private LocalDate from;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="toDate")
    private LocalDate to;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RequestStatus status;

    @Column(nullable = false)
    private Long empId;

    @Column(nullable = false)
    private Long supervisorId;
}
