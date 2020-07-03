package de.arvato.vacationrequestmodule.component;

public interface EmailService {

    void sendSimpleMessage(String to, String subject, String text);

}
