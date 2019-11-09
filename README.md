# Descripción
Entrega semana 4 curso Desarrollo de aplicaciones con Android (Coursera).

https://www.coursera.org/learn/desarrollo-de-aplicaciones

# Objetivo
Crear app estilo Instagram con las siguientes características:
  - Utilización de menú de opciones, mostrando las opciones "Contacto" y "Acerca de", las cuales abrirán activity para poder enviar correo al desarrollador, y activity con información del mismo, respectivamente.
  - Utilización de librería javaMail.
    - Desde "Contacto" se accederá a activity donde se mostrará formulario solicitando nombre, correo y mensaje, utilizando EditText de Material Design.
    - Esta activity incorpora botón "Enviar Comentario", que enviará correo al desarrollador, con nombre y correo del formulario en el asunto y mensaje del formulario en el cuerpo.
  - Utilización Fragments y ViewPager.
    - Se incorporará un ViewPager, con ocultación automática al hacer scroll, que permitirá alternar entre 2 fragments:
      - Fragment 1: ReyclerView con fotos de las mascotas (CardView), con su correspondiente botón "like" (hueso blanco), y su contador de likes (hueso amarillo).
      - Fragment 2: este fragment contiene la información de la mascota propia. Incorpora su foto de perfil, redondeada con librería https://github.com/lopspower/CircularImageView, y bajo la foto de perfil un RecyclerView en forma de Grid con todas sus fotos subidas. Cada foto incorporará número de likes recibidos, representado por icono hueso amarillo. Todos estos datos (fotos y likes), son dummy.
      
     
    

# Consideraciones

## Contacto
  
Se asume que la finalidad es contactar con el desarrollador de la app, y la dirección de correo que se introduce en el formulario es la de respuesta.
Como el código fuente es público, se han dejado sin introducir dirección de correo y contraseña desde la que se enviará el correo.
Para que el envío del correo funcione hay que autenticarse con el servidor. Para esto se debe introducir una dirección de correo válida de Gmail y su contraseña en la siguiente
línea de Contacto.java (línea 142):
    
                    t.connect("usuario@gmail.com", "password");
    
También se debe modificar la línea 102:
   
                    props.setProperty("mail.smtp.user", "usuario@gmail.com");
  
Otra opción sería solicitar usuario y contraseña en la app al usuario, pero no se hace por seguridad: podría enviarme esos datos por correo a mi dirección de correo.
   
La siguiente instrucción debería sustituir el "from" del header del correo por el indicado, con lo que el desarrollador podría responder directamente al correo.
   
                    message.setFrom(new InternetAddress("carles.garcia4@hotmail.com"));
   
Realizadas pruebas, el correo llega igualmente desde la cuenta autenticada. Gmail sustituye la dirección, podemos encontrar la siguiente línea en el header original del correo:
  
                    From: <cuenta de autenticación>
                    X-Google-Original-From: <cuenta introducida en la app>
      
Actualmente, llega un correo el siguiente asunto:
   
                    Petagram - Mensaje de usuario usuario_introducido <dirección de correo introducida>
    
El contenido del correo es el indicado en el campo correspondiente de la app.
   
Si me envías un correo trataré de responder a la mayor brevedad y podrás comprobar que los datos son los que introdujiste (usuario, dirección de correo y contenido).
   
## CircularImageView

Se utiliza la siguiente librería, en lugar de la última versión, ya que la última versión requiere de androidx:

                    implementation 'com.mikhaellopez:circularimageview:3.0.2'

Con esta versión no es necesario.

# Capturas de pantalla
