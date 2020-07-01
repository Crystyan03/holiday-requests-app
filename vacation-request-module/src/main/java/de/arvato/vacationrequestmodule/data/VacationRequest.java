package de.arvato.vacationrequestmodule.data;


import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "VacationRequests")
public class VacationRequest implements Serializable {

    @Id
    @Generated
    private Long requestID;

    private LocalDateTime fromDate;

    private LocalDateTime toDate;

    private String status;

    @Column(nullable = false)
    private Long empId;
}
