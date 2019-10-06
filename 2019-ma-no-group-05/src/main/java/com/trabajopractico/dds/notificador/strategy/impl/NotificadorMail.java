package com.trabajopractico.dds.notificador.strategy.impl;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.smtp.SMTPTransport;
import com.trabajopractico.dds.exceptions.SugerenciasInvalidasException;
import com.trabajopractico.dds.notificador.strategy.INotificador;

public class NotificadorMail implements INotificador {

    private static NotificadorMail nm;

    private NotificadorMail(){

    }

    public static NotificadorMail instanceofNotificadorMail(){
        if (nm == null){
            nm= new NotificadorMail();
        }

        return nm;
    }

    @Override
    public int notificar (String destino, String mensaje) {

        String SMTP_SERVER = "smtp.gmail.com";
        String USERNAME = "ddsvestite@gmail.com";
        String PASSWORD = "Dds12345"; //poner el password del mail para probar

        String EMAIL_FROM = "ddsvestite@gmail.com";
        String EMAIL_TO = destino;
        String EMAIL_TO_CC = "";

        String EMAIL_SUBJECT = "Test Send Email via SMTP";
        String EMAIL_TEXT = mensaje;

        System.out.println("Enviò el messaje: \n" + mensaje + "\nAl destino: \n" + destino);

        Properties prop = System.getProperties();
        prop.put("mail.smtp.starttls.enable","true");
        prop.put("mail.smtp.host", SMTP_SERVER); //optional, defined in SMTPTransport
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.port", "587"); // default port 25
        prop.put("mail.smtp.user",USERNAME);
        prop.put("mail.smtp.user",PASSWORD);
        prop.put("mail.smtp.ssl.trust","*");


        Session session = Session.getInstance(prop, null);
//        session.getProperties().put("mail.smtp.ssl.truest","smtp.gmail.com");
        session.getProperties().put("mail.smtp.starttls.enable","true");
        Message msg = new MimeMessage(session);

        try {

            // from
            msg.setFrom(new InternetAddress(EMAIL_FROM));

            // to
            msg.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(EMAIL_TO, false));

            // cc
            msg.setRecipients(Message.RecipientType.CC,
                    InternetAddress.parse(EMAIL_TO_CC, false));

            // subject
            msg.setSubject(EMAIL_SUBJECT);

            // content
            msg.setText(EMAIL_TEXT);

            msg.setSentDate(new Date());

            // Get SMTPTransport
            SMTPTransport t = (SMTPTransport) session.getTransport("smtp");

            // connect
            t.connect(SMTP_SERVER, USERNAME, PASSWORD);

            // send
            t.sendMessage(msg, msg.getAllRecipients());

            System.out.println("Response: " + t.getLastServerResponse());

            t.close();

        } catch (MessagingException e) {
            e.printStackTrace();
            throw new SugerenciasInvalidasException("Hubo un error al armar la sugerencia");
        }

        return 0;
    }
}
