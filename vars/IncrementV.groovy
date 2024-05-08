#!/user/bin/env groovy
import com.example.IncrementVersion
def call(){
    return new IncrementVersion(this).increment()
}