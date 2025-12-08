# Proyecto de Pruebas Funcionales Automatizadas con Serenity y Gradle

Este proyecto implementa pruebas funcionales automatizadas utilizando **Serenity BDD**, **Screenplay**, **JUnit** y **Gradle**. Está diseñado para ejecutarse en Java 11 y generar reportes detallados de ejecución.

## Características

- **Java 11**
- **Serenity BDD** para reportes y gestión de pruebas
- **Screenplay Pattern** para una mejor mantenibilidad
- **JUnit** como framework de pruebas
- **Gradle** como sistema de construcción
- **Integración con SonarQube** para análisis de calidad
- **Generación de reportes HTML** en la carpeta `build/reports/serenity`
- **Soporte para ejecución en BrowserStack**

## Estructura del proyecto

- `src/main/java`: Código fuente principal
- `src/test/java`: Pruebas automatizadas
- `build.gradle`: Configuración de dependencias y plugins
- `serenity.properties`: Configuración de Serenity y WebDriver
- `build/reports/serenity`: Reportes generados por Serenity

## Ejecución de pruebas

1. Instala Java 11 y Gradle 7.6.1.
2. Configura las variables necesarias en `serenity.properties` (por ejemplo, para BrowserStack).
3. Ejecuta las pruebas con el siguiente comando: 
4. Los reportes se generan en `build/reports/serenity`.

## Dependencias principales

- Serenity BDD
- Serenity Screenplay
- JUnit
- WebDriverManager
- JavaFaker
- Log4j


