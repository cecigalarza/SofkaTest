Feature: Pruebas de Signup

  Scenario: Crear un nuevo usuario
    Given url 'https://api.demoblaze.com/signup'
    And request { username: 'nuevoUsuario', password: 'passwordSeguro' }
    When method post
    Then status 200
    And match response == { success: true, message: 'User added' }
    # Asegúrate de que 'nuevoUsuario' no exista antes de ejecutar este test
    # O que tengas un mecanismo para limpiar los usuarios de prueba

  Scenario: Intentar crear un usuario ya existente
    Given url 'https://api.demoblaze.com/signup'
    And request { username: 'nuevoUsuario', password: 'passwordSeguro' }  # El mismo usuario del caso anterior
    When method post
    Then status 200
    And match response == { success: false, message: 'This user already exist.' }
