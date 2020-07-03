package de.arvato.vacationrequestmodule.data;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
@Getter
@Setter
public class Employee implements Serializable {


    private Long id;

    private String name;

    private String surname;

    private boolean supervisor;

    private String email;

    private String username;

}