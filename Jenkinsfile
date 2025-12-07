pipeline {
    agent any

    tools {
        // Usa el nombre del JDK que configuraste en "Global Tool Configuration"
        jdk 'Java11'
    }

    stages {
        stage('Checkout') {
            steps {
                // Clona el mismo repo/branch que configuraste en el job
                checkout scm
            }
        }

        stage('Build & Test') {
            steps {
                // Como Jenkins está en Windows, usamos bat
                bat 'gradlew clean test'
            }
        }

        stage('Publicar reporte Serenity') {
            steps {
                publishHTML(target: [
                    reportDir: 'target/site/serenity',
                    reportFiles: 'index.html',
                    reportName: 'Serenity Report',
                    keepAll: true,
                    alwaysLinkToLastBuild: true
                ])
            }
        }
    }

    post {
        always {
            // Opcional: si quieres que Jenkins muestre también los tests como JUnit
            junit '**/serenity/*.xml'
        }
    }
}