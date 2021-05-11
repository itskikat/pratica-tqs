pipeline {
    agent any
    tools {
        jdk 'openjdk@11'
        maven 'mvn3.6.3'
    }  
    stages {
        stage('Install') {
            steps {
                sh "mvn clean install"
            }   
            post {
                always {
                    junit '**/target/*-reports/TEST-*.xml'
                }
            } 
        }
    }
}