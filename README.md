<h1>Test Falabella</h1>

<p>En este proyecto se adjunta el codigo de un crud cumpliendo con los requisitos 
planteados en el test de la entrevista con Falabella.</p>

<h3>Como levantar el proyecto desde IDE</h3>

1.- Importar proyecto Gradle en IntelliJ. <br>
2.- Ejecutar run en clase Application.java.

<h3>Como levantar el proyecto desde CMD</h3>

1.- Posicionarse sobre raiz del proyecto.<br>
2.- Ejecutar comando -> "./gradlew bootRun".

<h3>Métodos disponibles en API</h3>

URL de Prueba -> localhost:8080/product

<ul>
  <li>Para guardar un producto -> URL: localhost:8080/product VERBO: POST</li>
  <li>Para actualizar un producto -> URL: localhost:8080/product VERBO: PUT</li>
  <li>Para obtener info de un producto -> URL: localhost:8080/product/{SKU} VERBO: GET </li>
  <li>Para obtener todos los productos disponibles -> URL: localhost:8080/product VERBO: GET </li>
  <li>Para eliminar un producto -> URL: localhost:8080/product/{SKU} VERBO: DELETE </li>
</ul>

<p>Para mayor información sobre testing, usar el archivo postman collection 
dentro del repo, e importarlo dentro de aplicacion POSTMAN.</p>