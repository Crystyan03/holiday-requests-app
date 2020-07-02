package de.arvato.vacationrequestui.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class VacationRequest {

    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate from;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate to;

    private Long supervisorId;

    private Long employeeId;

    private String status;

}
