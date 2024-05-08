#!/user/bin/env groovy
import com.example.Github
def call(){
    return new Github(this).setUser()
}