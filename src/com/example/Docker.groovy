#!/user/bin/env groovy
package com.example

class Docker implements Serializable{
    def script
    String repo
    Docker(script){
        this.script = script
    }
    def dockerLogin(){
        script.withCredentials([script.usernamePassword(credentialsId: "dockerhub-credentials", passwordVariable: "PASS", usernameVariable:"USER")]) {
            script.sh "echo '${script.PASS}' | docker login -u '${script.USER}' --password-stdin"

        }
    }
    def buildImage(String repo){
        script.sh "docker build -t $repo:'${script.env.IMAGE_NAME}' ."
    }
    def pushImage(String repo){
        script.sh "docker push $repo:'${script.env.IMAGE_NAME}'"
    }
}
