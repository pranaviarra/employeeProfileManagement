pipeline {
    agent any

    environment {
        DOCKER_IMAGE = "employeeprofilemanagement_image"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/pranaviarra/employeeProfileManagement.git'
                // Replace with your actual repo URL
            }
        }

        stage('Build Docker Image') {
            steps {
                sh """
                    docker build -t ${DOCKER_IMAGE}:${BUILD_NUMBER} .
                """
            }
        }

        stage('Run Container') {
            steps {
                sh """
                    docker rm -f employeeprofilemanagement || true
                    docker run -d --name employeeprofilemanagement -p 8200:8200 ${DOCKER_IMAGE}:${BUILD_NUMBER}
                    docker ps
                """
            }
        }
    }

    post {
        success {
            echo "✅ Jenkins build and Docker container running successfully!"
        }
        failure {
            echo "❌ Build failed!"
        }
    }
}
