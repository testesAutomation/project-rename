pipeline {

  agent any

    triggers {
              cron('H 20 * * *')
          }


  tools {

    maven 'maven3.6'

    jdk 'jdk11'

    git 'Default'

  }

  options {

    withAWS()

  }


  stages {

    stage('Java Integration Tests') {

      steps {


          sh "mvn test"

      }

    }

  }

}