#!/user/bin/env groovy
package com.example

class Test {
    def script
    Test(script){
        this.script = script
    }
    def test(){
        script.sh "npm install"
        script.sh "npm test"
    }
}
