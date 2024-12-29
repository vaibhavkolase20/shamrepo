pipeline {
    agent any
    
    tools {
        maven 'Maven_3.8.1' // यासाठी Maven_3.8.1 नावाची Maven स्थापना Jenkins मध्ये केली पाहिजे
    }

    stages {
        stage('Pull') {
            steps {
                git 'https://github.com/vaibhavkolase20/shamrepo.git'
            }
        }

        stage('Build') {
            steps {
                script {
                    sh 'mvn clean package'
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    sh 'mvn test'
                }
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying the application'
            }
        }
    }
}
