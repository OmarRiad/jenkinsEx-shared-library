#!/user/bin/env groovy
import com.example.Docker
def call(repo){
    return new Docker(this).buildImage(repo)
}
