Feature: Gestión de empleados en OrangeHRM
  Como administrador de OrangeHRM
  Quiero crear un empleado y validar su información
  Para asegurar que el sistema almacena correctamente los datos ingresados.

  @E2E
  Scenario Outline: Crear un empleado, subir foto, buscarlo en el directorio y validar información
    When se inicia sesión como administrador en OrangeHRM
    And navega al módulo de "PIM"
    And registra un nuevo empleado con nombre <NOMBRE> y apellido <APELLIDO>
    And sube una foto de perfil válida para el empleado y guarda el registro
    And navega al módulo de "Directory"
    And busca al empleado recién creado por nombre completo
    Then el sistema muestra la información básica del empleado de manera correcta

    Examples:
      | NOMBRE      | APELLIDO    |
      | "Aleatorio" | "Aleatorio" |
      #| "Mariana"   | "Torres"    |
      #| "Carlos"    | "Ramirez"   |