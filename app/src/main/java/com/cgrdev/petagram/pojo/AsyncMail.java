package com.cgrdev.petagram.pojo;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.util.Properties;

import javax.mail.AuthenticationFailedException;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class AsyncMail extends AsyncTask {

    String mensaje;

    public AsyncMail (String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    protected Object doInBackground(Object[] objects) {
        try {

            Log.d("Petagram: ", "Entrada a doInBackground.");

            // Creación y configuración clase Session

            Properties props = new Properties();

            // Nombre del host del correo, smtp.gmail.com
            props.setProperty("mail.smtp.host", "smtp.gmail.com");

            // TLS si está disponible
            props.setProperty("mail.smtp.starttls.enable", "true");

            // Puerto de gmail para envío de correos
            props.setProperty("mail.smtp.port", "587");

            // Nombre del usuario
            props.setProperty("mail.smtp.user", "garciacarlos78@gmail.com");

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
            // TODO indicar remitente que el usuario haya indicado en la app
            // message.setFrom(new InternetAddress("carles.garcia4@hotmail.com"));

            // Destinatario
            message.addRecipient(Message.RecipientType.TO, new InternetAddress("carles.garcia4@hotmail.com"));

            // Subject
            message.setSubject("PetaTest - Mensaje de usuario <Nombre> <direcion@dominio.tal>ls" +
                    "");

            // Texto
            message.setText(this.mensaje);
            // Fin construcción mensaje

            // Envío mensaje

            // Obtenemos instancia de clase Transport con protocolo smtp
            Transport t = session.getTransport("smtp");

            // Establecemos conexión
            // TODO Ojo aquí eliminar el password
            t.connect("usuario@dominio", "password");

            // Enviamos mensaje
            t.sendMessage(message, message.getAllRecipients());

            // Cerramos la conexión
            t.close();

            // Fin envío mensaje

            Log.d("Petagram: ", "Fin doInBackground.");


        } catch (AuthenticationFailedException auth) {
            Log.e("Petagram: ", "Usuario o password incorrecto: " + auth.getMessage());
        } catch (Exception e) {
            Log.e("Petagram: ", "Error al enviar el mensaje.");
            e.printStackTrace();
        }
        return null;
    }
}
