pipeline {
    agent any

    environment {
        DOCKER_IMAGE = "employeeprofilemanagement_image"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/pranaviarra/employeeProfileManagement.git'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh """
                    docker build -t ${DOCKER_IMAGE}:${BUILD_NUMBER} -f Dockerfile .
                """
            }
        }

        stage('Run Container') {
            steps {
                script {
                    // Stop & remove old container if it exists
                    sh """
                        if [ \$(docker ps -aq -f name=employeeprofilemanagement) ]; then
                            docker rm -f employeeprofilemanagement || true
                        fi

                        docker run -d --name employeeprofilemanagement -p 8200:8200 ${DOCKER_IMAGE}:${BUILD_NUMBER}
                    """
                }
            }
        }
    }

    post {
        success {
            echo "✅ Checkout, Build, Dockerize & Deploy completed successfully!"
        }
        failure {
            echo "❌ Build failed!"
        }
    }
}
