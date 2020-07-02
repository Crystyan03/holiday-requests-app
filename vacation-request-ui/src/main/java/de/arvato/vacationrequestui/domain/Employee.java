package de.arvato.vacationrequestui.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Employee {

    private Long id;
    private String name;
    private String surname;
    private boolean supervisor;
    private String email;
    private String username;
}
