# Consideraciones

## Contacto
  
   Se asume que la finalidad es contactar con el desarrollador de la app, y la dirección que se introduce es la de respuesta.
   Para autenticarse con el servidor, se debe introducir una dirección de correo válida de Gmail y su contraseña en la siguiente
   línea de Contacto.java (línea 142):
    
                    t.connect("usuario@gmail.com", "password");
    
   Si la App estuviera en producción no sería necesario, se enviaría desde la cuenta del desarrollador directamente.
   No se puede hacer así por tener que compartir el código fuente, tendría que exponer mi usuario y contraseña.
   
   Otra opción sería solicitar usuario y contraseña en la app al usuario, pero no se hace por seguridad: podría enviarme esos datos
   por correo a mi dirección de correo.
   
   La siguiente instrucción debería sustituir el "from" del header del correo por el indicado, con lo que el desarrollador podría
   responder directamente al correo.
   
                  message.setFrom(new InternetAddress("carles.garcia4@hotmail.com"));
   
   Realizadas pruebas, el correo llega igualmente desde la cuenta autenticada. Gmail sustituye la dirección, podemos encontrar la
   siguiente línea en el header original del correo:
  
      From: <cuenta de autenticación>
      X-Google-Original-From: <cuenta introducida en la app>
      
   Actualmente, llega un correo el siguiente asunto:
   
    Petagram - Mensaje de usuario usuario_introducido <dirección de correo introducida>
    
   El contenido del correo es el indicado en el campo correspondiente de la app.
   
## CircularImageView

Se utiliza la siguiente librería, en lugar de la última versión, ya que la última versión requiere de androidx:

    implementation 'com.mikhaellopez:circularimageview:3.0.2'

Con esta versión no es necesario.
