pipeline {
    agent any

    tools {
        jdk 'Java11'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build & Test') {
            steps {
                bat 'gradlew clean test'
            }
        }

        stage('Verificar logs de pruebas') {
            steps {
                bat 'type build\\reports\\tests\\test.log'
            }
        }

        stage('Publicar reporte Serenity') {
            steps {
                publishHTML(target: [
                    reportDir: 'build/reports/serenity',
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
            junit '**/serenity/*.xml'
        }
    }
}
