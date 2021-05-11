pipeline {
    agent any
    tools {
        jdk 'openjdk@11'
        maven 'mvn3.6.3'
    }  
    stages {
        stage('change directory') {
            steps {
                dir('lab04/TQS_Lab04-CarInfoSystem')
                sh '$PWD'
            }
        }
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