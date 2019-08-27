package com.cgrdev.petagram.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cgrdev.petagram.R;
import com.cgrdev.petagram.pojo.AsyncMail;
import com.cgrdev.petagram.pojo.SendMail;

import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Contacto extends AppCompatActivity {

    Button btComentario;
    EditText etContactoNombre;
    EditText etContactoCorreo;
    EditText etContactoComentario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        // Incluimos toolbar con posibilidad de subir a activity padre
        Toolbar miActionBar = (Toolbar) findViewById(R.id.contactoActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Obtenemos elementos de la vista que necesitaremos
        btComentario = (Button) findViewById(R.id.btComentario);
        etContactoNombre = findViewById(R.id.etContactoNombre);
        etContactoCorreo = findViewById(R.id.etContactoCorreo);
        etContactoComentario = findViewById(R.id.etContactoComentario);

        btComentario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Comprobamos que no haya ningún campo vacío
                if (!etContactoNombre.getText().toString().isEmpty() && !etContactoCorreo.getText().toString().isEmpty() && !etContactoComentario.getText().toString().isEmpty()) {
                    // Creamos el texto del asunto del correo
                    StringBuilder asunto = new StringBuilder("Petagram - Mensaje de usuario " + etContactoNombre.getText().toString() + " <" + etContactoCorreo.getText().toString() + ">");
                    try {
                        enviaMensaje(asunto.toString(), etContactoComentario.getText().toString());
                    } catch (MessagingException e) {
                        e.printStackTrace();
                    }
                }

            }
        });
    }

    public void enviaMensaje(String asunto, String mensaje) throws MessagingException {

        new AsyncMail(asunto, mensaje).execute();

/*
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
        session.setDebug(true);
        // Fin creación y configuración clase Session

        // Construcción mensaje

        // Instanciamos clase MimeMessage para pasar datos
        MimeMessage message = new MimeMessage(session);

        // Indicamos el remitente del correo (FROM)
        // TODO indicar remitente que el usuario haya indicado en la app
        message.setFrom(new InternetAddress("carles.garcia4@hotmail.com"));

        // Destinatario
        message.addRecipient(Message.RecipientType.TO,  new InternetAddress("garciacarlos78@gmail.com"));

        // Subject
        message.setSubject("PetaTest");

        // Texto
        message.setText("Mensaje con Java Mail" + "de peta peta." + "poque si");
        // Fin construcción mensaje

        // Envío mensaje

        // Obtenemos instancia de clase Transport con protocolo smtp
        Transport t = session.getTransport("smtp");

        // Establecemos conexión
        // TODO Ojo aquí eliminar el password
        t.connect("garciacarlos78@gmail.com", "MU4461tk");

        // Enviamos mensaje
        t.sendMessage(message, message.getAllRecipients());

        // Cerramos la conexión
        t.close();

        // Fin envío mensaje
*/


        // new SendMail().execute(null, null, null);

//        String to = "cuenta.chorra@hotmail.com";
//        String from = "cuenta.chorra@hotmail.com";
//        String host = "smtp.office365.com";
//
//        // create some properties and get the default Session
//        Properties props = new Properties();
//        props.put("mail.smtp.host", host);
//
//        Session session = Session.getInstance(props, null);
//
//        try {
//            // create a message
//            MimeMessage msg = new MimeMessage(session);
//            msg.setFrom(new InternetAddress(from));
//            InternetAddress[] address = {new InternetAddress(to)};
//            msg.setRecipients(Message.RecipientType.TO, address);
//            msg.setSubject("JavaMail APIs Test");
//            msg.setSentDate(new Date());
//            // If the desired charset is known, you can use
//            // setText(text, charset)
//            msg.setText("Texto del mensaje");
//
//            Transport.send(msg);
//        } catch (MessagingException mex) {
//            Log.d("Mascotas: ", "--Exception handling in msgsendsample.java");
//
//            mex.printStackTrace();
//            Exception ex = mex;
//            do {
//                if (ex instanceof SendFailedException) {
//                    SendFailedException sfex = (SendFailedException)ex;
//                    Address[] invalid = sfex.getInvalidAddresses();
//                    if (invalid != null) {
//                        Log.d("Mascotas: ", "--Exception handling in msgsendsample.java");
//                        for (int i = 0; i < invalid.length; i++) {
//                            Log.d("Mascotas: ", "--Exception handling in msgsendsample.java");
//                            Log.d("Mascotas: ", "         " + invalid[i]);
//                            }
//                    }
//                    Address[] validUnsent = sfex.getValidUnsentAddresses();
//                    if (validUnsent != null) {
//                        Log.d("Mascotas: ", "    ** ValidUnsent Addresses");
//                        for (int i = 0; i < validUnsent.length; i++)
//                            Log.d("Mascotas: ", "         "+validUnsent[i]);
//                    }
//                    Address[] validSent = sfex.getValidSentAddresses();
//                    if (validSent != null) {
//                        Log.d("Mascotas: ", "    ** ValidSent Addresses");
//                        for (int i = 0; i < validSent.length; i++)
//                            Log.d("Mascotas: ", "         "+validSent[i]);
//                    }
//                }
//                if (ex instanceof MessagingException)
//                    ex = ((MessagingException)ex).getNextException();
//                else
//                    ex = null;
//            } while (ex != null);
//        }

//        Properties props = new Properties();
//        props.put("mail.smtp.host", "smtp.office365.com");
//        Session session = Session.getInstance(props, null);
//
//        try {
//            MimeMessage msg = new MimeMessage(session);
//            msg.setFrom("cuenta.chorra@hotmail.com");
//            msg.setRecipients(Message.RecipientType.TO,
//                    "cuenta.chorra@hotmail.com");
//            msg.setSubject("JavaMail hello world example");
//            msg.setSentDate(new Date());
//            msg.setText("Hello, world!\n");
//            Transport.send(msg, "cuenta.chorra@hotmail.com", "");
//        } catch (MessagingException mex) {
//            System.out.println("send failed, exception: " + mex);
//        }
    }
}
