Banco Pichincha - Prueba Tecnica E2E OpenCart

1. Objetivo
Este proyecto automatiza con Serenity BDD, Cucumber y Screenplay el flujo de compra en http://opencart.abstracta.us/ agregando dos productos al carrito, visualizando el carrito, completando el Guest Checkout y validando el mensaje final "Your order has been placed!".

2. Prerrequisitos
- Java 17 instalado y disponible en PATH.
- Maven 3.9 o superior instalado y disponible en PATH.
- Google Chrome instalado.
- Conexion a Internet para acceder al sitio y descargar dependencias Maven.

3. Archivos relevantes
- pom.xml: dependencias y configuracion de Maven/Serenity.
- run-tests.bat: script rapido de ejecucion.
- src/test/resources/serenity.conf: configuracion del navegador y reportes.
- src/test/resources/features/opencart_guest_checkout.feature: escenario funcional en Cucumber.
- src/test/java/co/com/bancopichincha/opencart/runner/OpenCartGuestCheckoutRunner.java: runner principal de ejecucion.
- src/test/java/co/com/bancopichincha/opencart/stepdefinitions: definiciones de pasos y hooks.
- src/test/java/co/com/bancopichincha/opencart/constants: datos y constantes del flujo.
- conclusiones.txt: hallazgos y observaciones de la prueba.

4. Ejecucion paso a paso
1. Clonar el repositorio.
2. Abrir una terminal en la raiz del proyecto.
3. Validar herramientas:
   - java -version
   - mvn -version
4. Ejecutar la automatizacion con una de estas opciones:
   - run-tests.bat
   - mvn clean verify
   - mvn clean verify -Dit.test=OpenCartGuestCheckoutRunner
5. Si deseas correrlo desde el IDE, ejecuta el runner:
   - src/test/java/co/com/bancopichincha/opencart/runner/OpenCartGuestCheckoutRunner.java

5. Resultado esperado
- La prueba debe terminar en estado SUCCESS.
- Maven debe generar el reporte interactivo de Serenity.

6. Ubicacion del reporte
- target/site/serenity/index.html

7. Datos del flujo automatizado
- Producto 1: MacBook
- Producto 2: iPhone
- Tipo de checkout: Guest Checkout
- Metodo de envio: Flat Shipping Rate
- Metodo de pago: Cash On Delivery
- Datos del comprador invitado: definidos en el paquete constants

8. Notas
- La aplicacion usa pasos de checkout cargados dinamicamente por AJAX.
- El sitio redirige a HTTPS durante el checkout; la configuracion del navegador acepta el certificado del entorno para permitir la automatizacion.
- La estructura del proyecto sigue el estilo clasico con runner, stepdefinitions, features, constants, ui y tasks.
- Si deseas forzar otro navegador compatible con Selenium Manager, puedes intentar:
  mvn clean verify -Dwebdriver.driver=edge
