pipeline {
    agent any
    
    tools {
        // Ensure Maven is installed and available for the pipeline
        maven 'Maven_3.8.1' // Make sure this matches the name of the Maven installation in Jenkins Global Tool Configuration
    }

    stages {
        stage('Pull') {
            steps {
                // Clone the repository
                git 'https://github.com/vaibhavkolase20/ram-2.git'
            }
        }
        
        stage('Build') {
            steps {
                // Run the Maven build command
                script {
                    // If Maven isn't installed on the agent, you can install it here
                    sh 'mvn clean package'
                }
            }
        }
        
        stage('Test') {
            steps {
                // Running tests with Maven (if any tests are configured in the project)
                script {
                    sh 'mvn test'
                }
            }
        }
        
        stage('Deploy') {
            steps {
                // Deploy the artifact (can be customized based on your actual deploy process)
                echo 'Deploying the application'
                // You can add your deploy commands here, like `sh 'mvn deploy'` or a custom deploy script
            }
        }
    }
}
