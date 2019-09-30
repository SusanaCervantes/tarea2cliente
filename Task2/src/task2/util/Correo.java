/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task2.util;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Correo 
{
    Properties props;
    Session session;
    Message message;
    Transport transport;
    BodyPart messageBodyPart;
    Multipart multipart;
    DataSource source;
	
	
    public Correo()
    {
            props=new Properties();
            messageBodyPart=new MimeBodyPart();
            multipart=new MimeMultipart();
    }
    public void Enviar(String destinatario,String asunto ,String ruta , String nombre) 
    {

        props.put("mail.smtp.host","smtp.gmail.com");
        props.put("mail.smtp.user", "unaprogra32018@gmail.com");
        props.put("mail.smtp.password","una32018");
        props.put("mail.smtp.auth","true");
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.smtp.port","587");

        session=Session.getDefaultInstance(props);
        message=new MimeMessage(session);
        try
        {


            multipart.addBodyPart(messageBodyPart);

            //messageBodyPart=new MimeBodyPart();
            String file=ruta;
            source= new FileDataSource(file);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(nombre);
            multipart.addBodyPart(messageBodyPart);


            message.setFrom(new InternetAddress("unaprogra32018@gmail.com"));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(destinatario));
            message.setSubject(asunto);
            message.setContent(multipart);
            transport=session.getTransport("smtp");
            transport.connect("smtp.gmail.com","unaprogra32018@gmail.com","una32018");
            transport.sendMessage(message,message.getAllRecipients());
            transport.close();
    }
    catch(MessagingException e)
    {
        e.printStackTrace();
    }
}
    public void EnviarTexto(String  destino, String Asunto,String mensaje)
    {
        props.put("mail.smtp.host","smtp.gmail.com");
        props.put("mail.smtp.user", "unaprogra32018@gmail.com");
        props.put("mail.smtp.password","una32018");
        props.put("mail.smtp.auth","true");
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.smtp.port","587");

        session=Session.getDefaultInstance(props);
        message=new MimeMessage(session);

        try
        {
            message.setFrom(new InternetAddress("unaprogra32018@gmail.com"));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(destino));
            message.setSubject(Asunto);
            message.setText(mensaje);
            transport=session.getTransport("smtp");
            transport.connect("smtp.gmail.com","susi0326@gmail.com","rwbmcqsypadbgbkc");
            transport.sendMessage(message,message.getAllRecipients());
            transport.close();

        }
        catch(MessagingException e)
        {
           e.printStackTrace();
        }
    }
	
}
