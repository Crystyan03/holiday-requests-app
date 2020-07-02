package de.arvato.vacationrequestui.domain;

import lombok.Data;

import java.time.LocalDate;

@Data
public class VacationRequest {

    private LocalDate from;

    private LocalDate to;

    private Long supervisorId;

    private Long employeeId;

    private String status;

}
