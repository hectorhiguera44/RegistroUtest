Feature: Registro de un nuevo usuario en UTest

  Scenario: Registro exitoso de un nuevo usuario
    Given me encuentro en la página principal de UTest
    When el usuario completa el formulario personal con los siguientes datos
      | nombre | apellido |   mes   | dia | año  |
      | Héctor |  Higuera | January |  4  | 1990 |
    And el usuario avanza a la pagina locacion
    And el usuario completa el formulario de ubicación con los siguientes datos
      | postalCode | countryId |
      |   9274944  |   Chile   |
    And el usuario avanza a la pagina dispositivo
    And el usuario completa el formulario de dispositivos con los siguientes datos
      |  mobile  |       modelo     | sistema_operativo |
      | Samsung | Galaxy S22 Ultra |     Android 15    |
    And el usuario avanza a la pagina seguridad
    And el usuario completa el formulario de seguridad con los siguientes datos
      |   password    |
      | Hhiguera1234. |
    And el usuario confirma los datos registrados
    Then el usuario debería ver el mensaje de confirmación "Welcome to the world's largest community of freelance software testers!"