pipeline {
    agent any

    environment {
        JAVA_HOME = '/usr/lib/jvm/java-17-amazon-corretto.x86_64'
        PATH = "${JAVA_HOME}/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin"
        APP_NAME = 'Webportfolio.jar'
        DEPLOY_PATH = '/home/ec2-user/Webportfolio.jar'
        LOG_PATH = '/home/ec2-user/app.log'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/HanKyoungJong/webportfolio.git'
            }
        }

        stage('Build') {
            steps {
                sh '''
                echo "===== BUILD START ====="
                chmod +x gradlew
                ./gradlew clean build -x test
                echo "===== BUILD END ====="
                ls -l build/libs
                '''
            }
        }

        stage('Deploy') {
            steps {
                sh '''
                echo "===== DEPLOY START ====="
                echo "whoami: $(whoami)"
                echo "pwd: $(pwd)"
                date

                NEW_JAR=$(find build/libs -name "*.jar" | head -n 1)

                if [ -z "$NEW_JAR" ]; then
                  echo "ERROR: jar file not found in build/libs"
                  exit 1
                fi

                echo "NEW_JAR=$NEW_JAR"

                cp "$NEW_JAR" "$DEPLOY_PATH"
                chmod 755 "$DEPLOY_PATH"

                echo "===== STOP OLD PROCESS ====="
                pkill -f "$APP_NAME" || true
                sleep 3

                echo "===== START NEW PROCESS ====="
                nohup java -jar "$DEPLOY_PATH" > "$LOG_PATH" 2>&1 &
                sleep 10

                echo "===== CHECK PROCESS ====="
                ps -ef | grep "$APP_NAME" | grep -v grep || true

                echo "===== CHECK LOG ====="
                tail -n 50 "$LOG_PATH" || true

                echo "===== DEPLOY END ====="
                '''
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: 'build/libs/*.jar', fingerprint: true
        }
        success {
            echo 'Jenkins build and deploy success'
        }
        failure {
            echo 'Jenkins build or deploy failed'
        }
    }
}