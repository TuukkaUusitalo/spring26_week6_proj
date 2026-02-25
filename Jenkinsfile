pipeline {
    agent any

    tools {
        maven 'Maven3912'
    }

    environment {
        PATH = "/usr/local/bin:/opt/homebrew/bin:/usr/bin:/bin:/usr/sbin:/sbin:${PATH}"
        DOCKERHUB_CREDENTIALS_ID = 'Docker_hub'
        DOCKERHUB_REPO = 'tuusitalo/lecture25_02_2026'
        DOCKER_IMAGE_TAG = 'latest'
    }

    stages {

        stage ('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/TuukkaUusitalo/spring26_week6_proj'
            }
        }

        stage ('build'){
            steps {
                sh 'mvn clean install'
            }
        }

        stage ('Generate report') {
            steps {
                sh 'mvn jacoco:report'
            }
        }

        stage('Publish Test Results') {
            steps {
                junit '**/target/surefire-reports/*.xml'
            }
        }

        stage('Publish Coverage Report') {
            steps {
                jacoco()
            }
        }

        stage('Check Docker') {
            steps {
                sh 'echo PATH=$PATH'
                sh 'which docker || echo "docker not found"'
                sh 'docker info || echo "docker info failed"'
            }
        }

        stage('Build Docker Image') {
            steps {
            script {
                    docker.build("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}")
                }
            }
        }

        stage('Push Docker Image to Docker Hub') {
            steps {
                script {
                        docker.withRegistry('https://index.docker.io/v1/', DOCKERHUB_CREDENTIALS_ID) {
                            docker.image("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}").push()
                    }
                }
            }
        }
    }
}