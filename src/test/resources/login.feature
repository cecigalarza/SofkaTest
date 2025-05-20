Feature: Pruebas de Login

  Scenario: Usuario y password correctos
    Given url 'https://api.demoblaze.com/login'
    And request { username: 'nuevoUsuario', password: 'passwordSeguro' }  # El usuario creado en signup.feature
    When method post
    Then status 200
    And match response contains { success: true }

  Scenario: Usuario y password incorrectos
    Given url 'https://api.demoblaze.com/login'
    And request { username: 'nuevoUsuario', password: 'passwordIncorrecto' }
    When method post
    Then status 200
    And match response contains { success: false }
