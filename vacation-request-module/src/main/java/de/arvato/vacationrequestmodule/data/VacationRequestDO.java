package de.arvato.vacationrequestmodule.data;


import lombok.Generated;
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
@Table(name = "VacationRequests")
public class VacationRequestDO implements Serializable {

    @Id
    @Generated
    private String requestID;

    private Date fromDate;

    private Date toDate;

    private String status;

    @Column(nullable = false)
    private String empId;
}
