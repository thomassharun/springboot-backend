pipeline {
    agent any
    tools {
        maven 'maven-3.9.6'
    }

    stages {
        stage('Git Checkout') {
            steps {
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/thomassharun/springboot-backend.git']])
                echo 'Git Checkout Completed'
            }
        }
        stage('Maven Build') {
            steps {
                sh 'mvn clean package -DskipTests'
                echo 'Maven build Completed'
            }
        }
        /**
        
        stage('Integration Test') {
            steps {
                // Run integration tests
                script {
                    try {
                        sh 'mvn test -Dtest=com.tus.employees.controllers.IntegrationTests'
                    // junit 'src/reports/*-jupiter.xml'
                    } catch (err) {
                        currentBuild.result = 'FAILURE'
                        echo 'Integration tests failed!'
                        error 'Integration tests failed!'
                    }
                }
            echo 'Integration test Completed'
            }
        }
        */
        stage('JUnit Test') {
            steps {
                // Run Junit tests
                script {
                    try {
                        sh 'mvn clean test surefire-report:report' 
                        //junit 'src/reports/*-jupiter.xml'
                    } catch (err) {
                        currentBuild.result = 'FAILURE'
                        echo 'Unit tests failed!'
                        error 'Unit tests failed!'
                    }
                }
                echo 'JUnit test Completed'
            }
        }

        stage('Copy artifacts to EC2') {
            steps {
                sshPublisher(
                    publishers: [
                        sshPublisherDesc(
                            configName: 'ansible-server1',
                            transfers: [
                                sshTransfer(
                                    cleanRemote: false,
                                    excludes: '',
                                    execCommand: '',
                                    execTimeout: 120000,
                                    flatten: false,
                                    makeEmptyDirs: false,
                                    noDefaultExcludes: false,
                                    patternSeparator: '[, ]+',
                                    remoteDirectory: '//opt//deploy-sharun',
                                    remoteDirectorySDF: false,
                                    removePrefix: 'target',
                                    sourceFiles: 'target/*.jar'
                                )
                            ],
                            usePromotionTimestamp: false,
                            useWorkspaceInPromotion: false,
                            verbose: false
                        )
                    ]
                )
            }
        }
        stage('Deploy') {
            steps {
                sshPublisher(
                    publishers: [
                        sshPublisherDesc(
                            configName: 'ansible-server1',
                            transfers: [
                                sshTransfer(
                                    cleanRemote: false,
                                    excludes: '',
                                    execCommand: '''
                                        cd /opt/deploy-sharun/
                                        ansible-playbook start_container.yml
                                    ''',
                                    execTimeout: 120000,
                                    flatten: false,
                                    makeEmptyDirs: false,
                                    noDefaultExcludes: false,
                                    patternSeparator: '[, ]+',
                                    remoteDirectory: '',
                                    remoteDirectorySDF: false,
                                    removePrefix: '',
                                    sourceFiles: ''
                                )
                            ],
                            usePromotionTimestamp: false,
                            useWorkspaceInPromotion: false,
                            verbose: false
                        )
                    ]
                )
            }
        }

    }
    post {
        failure {
            // This block will execute if any of the previous stages fail, including unit tests
            echo 'One or more stages have failed!'
            echo 'Pipeline Aborted'
        }
        always {
            echo 'always section'
            // Publish Surefire test results
            junit allowEmptyResults: true, testResults: '**/target/surefire-reports/*.xml'
        }
    }
}
