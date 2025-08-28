Automatización del registro de UTest

Este proyecto proporciona un conjunto de pruebas automatizadas para el proceso de registro de nuevos usuarios de UTest, desarrollado con Selenium WebDriver, Cucumber y Java. Las pruebas están diseñadas para ser robustas, legibles y fáciles de mantener, siguiendo los principios del Desarrollo Basado en el Comportamiento (BDD) y el Modelo de Objetos de Página (POM).

🚀 Primeros pasos
Siga estas instrucciones para obtener una copia del proyecto en funcionamiento en su máquina local.

Prerrequisitos
Necesitará tener instalado el siguiente software:

Kit de desarrollo de Java (JDK) 8 o superior

Apache Maven

Navegador Google Chrome

Instalación
Clone el repositorio en su máquina local:

Intento

git clone https://github.com/hectorhiguera44/RegistroUtest.git
Asegúrese de tener todas las dependencias necesarias compilando el proyecto con Maven. Esto descargará Selenium, Cucumber y otras bibliotecas.

Intento

mvn clean install
⚙️ Estructura del proyecto
El proyecto está organizado utilizando una estructura Maven estándar:

src/

├── main/

│   └── java/

│        └── org.example/

│            └── utest/

│                ├── pages/  

│                │   └── UTestRegistrationPage.java

│                │ 

│                └── utils/  

│                    ├── ConfigurationReader.java   

│                    ├── ScreenshotHelper.java  

│                    └── WebDriverFactory.java

├── test/

|   ├── java/

|   │   └── org.example/

|   │        └── utest/

|   │            ├── runners/    

|   │            │   └──TestRunner.java

|   │            ├── StepDefinitions/   

|   │                └── RegistroStepDefinitions.java

|   └── resources/

|       ├── features/  

|       │   └── RegistroUtest.feature

|       └── config.properties

├── .gitignore

├── chromedriver.exe    

├── configuration.properties

└── pom.xml


🧪 Cómo ejecutar las pruebas
Puede ejecutar las pruebas desde su IDE (como IntelliJ IDEA o Eclipse) o desde la línea de comandos usando Maven.

Ejecutar desde un IDE
Abra el proyecto en su IDE.

Navegar hasta el src/test/java/org.example/utest/runners/TestRunner.java

Haga clic derecho en el archivo y seleccione "Ejecutar 'TestRunner'".

Ejecutar desde la línea de comandos
Abra una terminal o un símbolo del sistema en el directorio raíz del proyecto.

Ejecute el siguiente comando Maven:

Intento

mvn test
📖 Componentes clave
registroUtest.feature:Este archivo Gherkin describe el escenario de prueba en lenguaje sencillo.

RegistroStepDefinitions.java:Esta clase contiene la lógica que vincula cada paso de Gherkin a una acción específica en el navegador.

UTestRegistrationPage.java:Esta clase de modelo de objeto de página contiene todos los localizadores y métodos para interactuar con los elementos web en todas las páginas del formulario de registro de UTest.

TestRunner.java:Esta clase está configurada para ejecutar las pruebas de Cucumber.

pom.xmlEste archivo gestiona todas las dependencias del proyecto, incluyendo Selenium y Cucumber. También WebDriverManagergestiona automáticamente la configuración del controlador del navegador, por lo que no es necesario descargarlo manualmente.

🤝 Contribuyendo
Si desea contribuir, bifurque el repositorio y cree una nueva rama para sus cambios. Agradecemos las mejoras y los nuevos casos de prueba.
