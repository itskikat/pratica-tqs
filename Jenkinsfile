pipeline {
    agent any
    tools {
        jdk 'openjdk@11'
        maven 'mvn3.6.3'
    }  
    stages {
        stage('test java installation') {
            steps {
                sh 'java -version'
            }   
        }   
        stage('test maven installation') {
            steps {
                sh 'mvn -version'
            }
        } 
    }
}