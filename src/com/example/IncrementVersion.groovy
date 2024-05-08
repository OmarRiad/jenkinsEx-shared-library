#!/user/bin/env groovy
package com.example

class IncrementVersion {
    def script
    IncrementVersion(script){
        this.script = script
    }
    def increment(){
        script.sh 'npm version minor'
        def packageJson = script.readJSON file:'package.json'
        def version = packageJson.version
        script.echo "$version"
        env.IMAGE_NAME = "$version-$env.BUILD_NUMBER"
        script.echo "$env.IMAGE_NAME"
    }
}
