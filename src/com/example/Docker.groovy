#!/user/bin/env groovy
package com.example

class Docker implements Serializable{
    def script
    Docker(script){
        this.script = script
    }
    def dockerLogin(){
        script.withCredentials([script.usernamePassword(credentialsId: "dockerhub-credentials", passwordVariable: "PASS", usernameVariable:"USER")]) {
            script.sh "echo '${script.PASS}' | docker login -u '${script.USER}' --password-stdin"

        }
    }
    def buildImage(){
        script.sh "docker build -t omarriad07/demo-app:'${script.env.IMAGE_NAME}' ."
    }
    def pushImage(){
        script.sh "docker push omarriad07/demo-app:'${script.env.IMAGE_NAME}'"
    }
}
