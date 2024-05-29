Este proyecto contiene pruebas automatizadas de dos páginas web diferentes utilizando Java y el IDE IntelliJ IDEA. Las pruebas incluyen funcionalidades específicas como: 
Hover: Simula el desplazamiento del mouse sobre un elemento específico.
Fluent Wait: Implementa una espera dinámica para elementos que cargan de manera asincrónica.
Loading File: Prueba la funcionalidad de carga de archivos.
Switch Window: Cambia el enfoque entre diferentes ventanas del navegador.
Switch Tab: Cambia entre diferentes pestañas del navegador.

REQUISITOS PARA CREAR ESTE PROYECTO:
instalar las herramientas necesarias que van a utilizar 
Java: Lenguaje de programación.
IntelliJ IDEA: Entorno de desarrollo integrado (IDE).
Selenium WebDriver: Para la automatización de navegadores web.
JUnit/TestNG: Para la ejecución y gestión de pruebas.

Aca dejo los link para la instalacion:
java JDK: https://www.oracle.com/java/technologies/downloads/#java11
IntelliJ IDEA: https://www.jetbrains.com/idea/download/?section=windows
Maven o Gradle: https://maven.apache.org/install.html (yo utilice maven)

Es muy importante configurar las dependencias que se van a utilizar:
Asegúrate de que tu archivo pom.xml (si usas Maven) 
Ejemplo:
<dependencies>
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>3.141.59</version>
    </dependency>
    <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
        <version>7.3.0</version>
        <scope>test</scope>
    </dependency>
</dependencies>

