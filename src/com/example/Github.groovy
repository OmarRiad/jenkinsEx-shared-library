#!/user/bin/env groovy
package com.example

class Github {
    def script
    Github(script){
        this.script = script
    }

    def setUser(){
        script.sh 'git config --global user.email "jenkins@example.com"'
        script.sh 'git config user.name "jenkins"'
    }
    def gitPush(){
        script.withCredentials([script.string(credentialsId: 'github-token', variable: 'GITHUB_API_TOKEN')]) {
            script.sh "git remote set-url origin https://'${script.GITHUB_API_TOKEN}'@github.com/OmarRiad/jenkins-exercises.git"
            script.sh 'git add .'
            script.sh 'git commit -m "ci: version bump"'
            script.sh 'git push origin HEAD:main'
        }
    }
}
