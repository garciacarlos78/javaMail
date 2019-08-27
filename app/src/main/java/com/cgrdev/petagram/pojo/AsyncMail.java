package com.cgrdev.petagram.pojo;

import android.os.AsyncTask;
import android.util.Log;

import java.util.Properties;

import javax.mail.AuthenticationFailedException;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class AsyncMail extends AsyncTask {

    String asunto;
    String mensaje;

    public AsyncMail (String asunto, String mensaje) {
        this.asunto = asunto;
        this.mensaje = mensaje;
    }

    @Override
    protected Object doInBackground(Object[] objects) {
        try {

            // Creación y configuración clase Session
            Properties props = new Properties();

            // Nombre del host del correo, smtp.gmail.com
            props.setProperty("mail.smtp.host", "smtp.gmail.com");

            // TLS si está disponible
            props.setProperty("mail.smtp.starttls.enable", "true");

            // Puerto de gmail para envío de correos
            props.setProperty("mail.smtp.port", "587");

            // Nombre del usuario
            // TODO indicar aquí el nombre de usuario de la cuenta de correo desde la que se enviará el correo. Dirección de correo de gmail.
            props.setProperty("mail.smtp.user", "usuario@gmail.com");


            // Se requiere usuario y password para conectar
            props.setProperty("mail.smtp.auth", "true");

            // Obtenemos la instancia de Session con este Properties
            Session session = Session.getDefaultInstance(props);

            // Información extra, se puede comentar una vez funcione
            // session.setDebug(true);
            // Fin creación y configuración clase Session

            // Construcción mensaje

            // Instanciamos clase MimeMessage para pasar datos
            MimeMessage message = new MimeMessage(session);

            // Indicamos el remitente del correo (FROM)
            // Se comenta porque Gmail no utiliza este from en el encabezado, lo cambia por el propio
            // message.setFrom(new InternetAddress("carles.garcia4@hotmail.com"));

            // Destinatario
            // El destinatario es el desarrollador, la opción se utiliza para enviar mensaje al desarrollador
            message.addRecipient(Message.RecipientType.TO, new InternetAddress("carles.garcia4@hotmail.com"));

            // Subject
            message.setSubject(this.asunto);

            // Cuerpo del mensaje
            message.setText(this.mensaje);
            // Fin construcción mensaje

            // Envío mensaje

            // Obtenemos instancia de clase Transport con protocolo smtp
            Transport t = session.getTransport("smtp");

            // Establecemos conexión
            // TODO Introducir aquí usuario y password de Gmail
            t.connect("username@gmail.com", "password");

            // Enviamos mensaje
            t.sendMessage(message, message.getAllRecipients());

            // Cerramos la conexión
            t.close();
            // Fin envío mensaje

        } catch (AuthenticationFailedException auth) {
            // TODO Mostrar por pantalla del móvil que ha habido error de user/password
            Log.e("Petagram: ", "Error de autenticación: " + auth.getMessage());
        } catch (Exception e) {
            // TODO Mostrar en terminal error de envío
            Log.e("Petagram: ", "Error al enviar el mensaje: " + e.getMessage());
        }
        return null;
    }
}