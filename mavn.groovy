pipeline {
    agent any
    stages {
        stage('pull') {
            steps {
                git 'https://github.com/vaibhavkolase20/shamrepo.git'
            }
        }
        stage('build') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('test') {
            steps {
                echo 'test sucessful'
            }
        }
        stage('deploy') {
            steps {
                echo'deploy is sucessful'
            }
        }
    }
}
