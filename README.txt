JavaMail:

El enlace de Coursera (https://javaee.github.io/javamail/) indica que el proyecto ahora es
parte de EE4J, envía a https://www.eclipse.org/ee4j/status.php para comprobar estado de transición.
Dicha página indica que el estado es 100%.
De aquí https://projects.eclipse.org/proposals/eclipse-project-javamail se obtiene que el proyecto
asociado es Jakarta Mail (https://projects.eclipse.org/projects/ee4j.javamail).
Documentación del proyecto: https://eclipse-ee4j.github.io/javamail/#Download_JavaMail_Release
Jakarta Mail for Android: https://eclipse-ee4j.github.io/javamail/Android

Actualización 27 de Agosto de 2019:
-Empezamos comprobando requisitos de https://javaee.github.io/javamail/Android (build.gradle)
-Seguimos luego las instrucciones de http://www.chuidiang.org/java/herramientas/javamail/enviar-correo-javamail.php
-Asumimos:
  -La cuenta desde la que se envía el correo es la del desarrollador
  -Es por ello que se pide la dirección de correo del sender, para poder responder


CircularImageView:

Se utiliza la siguiente librería, en lugar de la última versión, ya que la última versión requiere de androidx:

implementation 'com.mikhaellopez:circularimageview:3.0.2'

Con esta versión no es necesario.

