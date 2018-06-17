pipeline{
    agent any    
    stages{
      
        stage("checkout"){
            steps{
                git url:'https://github.com/Egiantsgit/registration-service.git'
            }
        }
        
        stage("Compile"){
            dir('registration-service'){
                steps{                
                        sh "sh ./mvnw compile"                      
                }
            }
        }
        
        stage("Unit test"){
            dir('registration-service'){
                steps{                
                    sh "sh ./mvnw test"
                }
            }                
        }
        
        stage("Package"){
            dir('registration-service'){
                steps{
                    sh "sh ./mvnw package"
                }
            }
        }        
        
        
        
        stage("Docker build"){
            dir('registration-service'){
                steps{
                    sh "docker login --username egiantsdocker --password Egaints#1"        	
                    sh "docker build -t egiantsdocker/registrationservice ."
                    sh "docker push egiantsdocker/registrationservice"
                }
            }
        }
      }
 
}        
        
        
