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

        stage('Generar reporte Serenity') {
            steps {
                bat 'gradlew serenityAggregate'
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
            junit '**/serenity/*.xml'
        }
    }
}