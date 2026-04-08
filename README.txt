Banco Pichincha - Prueba Tecnica E2E OpenCart

1. Objetivo
Este proyecto automatiza con Serenity BDD el flujo de compra en http://opencart.abstracta.us/ agregando dos productos al carrito, visualizando el carrito, completando el Guest Checkout y validando el mensaje final "Your order has been placed!".

2. Prerrequisitos
- Java 17 instalado y disponible en PATH.
- Maven 3.9 o superior instalado y disponible en PATH.
- Google Chrome instalado.
- Conexion a Internet para acceder al sitio y descargar dependencias Maven.

3. Archivos relevantes
- pom.xml: dependencias y configuracion de Maven/Serenity.
- run-tests.bat: script rapido de ejecucion.
- src/test/resources/serenity.conf: configuracion del navegador y reportes.
- src/test/resources/checkout-data.properties: datos de prueba del flujo.
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

8. Notas
- La aplicacion usa pasos de checkout cargados dinamicamente por AJAX.
- El sitio redirige a HTTPS durante el checkout; la configuracion del navegador acepta el certificado del entorno para permitir la automatizacion.
- Si deseas forzar otro navegador compatible con Selenium Manager, puedes intentar:
  mvn clean verify -Dwebdriver.driver=edge
