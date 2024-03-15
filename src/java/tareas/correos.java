/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareas;

import java.io.IOException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author camil
 */
public class correos {

    Properties props = System.getProperties();

    public void enviarCorreo(String remitente, String destinatario, String clave, String asunto, String cuerpo) {

        props.setProperty("mail.smtp.host", "smtp.gmail.com"); //El servidor SMTP de Google
        props.put("mail.smtp.user", remitente); //Cuenta del remitente
        props.put("mail.smtp.clave", clave); //La clave de la cuenta
        props.put("mail.smtp.auth", "true"); //Usar autenticación mediante usuario y clave
        props.put("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
        props.put("mail.smtp.port", "587"); //El puerto SMTP seguro de Google

        Session session = Session.getDefaultInstance(props, null);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(remitente));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
            message.setSubject(asunto);
            message.setText(cuerpo);
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", remitente, clave);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (MessagingException me) {
            me.printStackTrace();
        }
        
    }

    public void enviarManualAyudas(String remitente, String correo, String clave, String asunto, String cuerpo) throws IOException {

        props.setProperty("mail.smtp.host", "smtp.gmail.com"); //El servidor SMTP de Google
        props.put("mail.smtp.user", remitente); //Cuenta del remitente
        props.put("mail.smtp.clave", clave); //La clave de la cuenta
        props.put("mail.smtp.auth", "true"); //Usar autenticación mediante usuario y clave
        props.put("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
        props.put("mail.smtp.port", "587"); //El puerto SMTP seguro de Google

        Session session = Session.getDefaultInstance(props, null);

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(remitente));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(correo));
            message.setSubject(asunto);
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setText(cuerpo);
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);
            message.setContent(multipart);
            MimeBodyPart mimeBodyPartAdjunto = new MimeBodyPart();
            mimeBodyPartAdjunto.attachFile("C:/Users/Camilo Alzate Ramire/OneDrive/Documentos/NetBeansProjects/WebTierragricola/web/Manuales/Manual del Sistema.pdf");
            multipart.addBodyPart(mimeBodyPartAdjunto);
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", remitente, clave);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (MessagingException me) {
            me.printStackTrace();
        }
        
    }

    public void enviarCorreoMasivo(String remitente, String destinatario1, String destinatario2, String clave, String asunto, String cuerpo) {

        props.setProperty("mail.smtp.host", "smtp.gmail.com"); //El servidor SMTP de Google
        props.put("mail.smtp.user", remitente); //Cuenta del remitente
        props.put("mail.smtp.clave", clave); //La clave de la cuenta
        props.put("mail.smtp.auth", "true"); //Usar autenticación mediante usuario y clave
        props.put("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
        props.put("mail.smtp.port", "587"); //El puerto SMTP seguro de Google

        Session session = Session.getDefaultInstance(props, null);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(remitente));
            message.addRecipient(Message.RecipientType.CC, new InternetAddress(destinatario1));
            message.addRecipient(Message.RecipientType.CC, new InternetAddress(destinatario2));
            message.setSubject(asunto);
            message.setText(cuerpo);
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", remitente, clave);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (MessagingException me) {
            me.printStackTrace();
        }
    }
    
}
