pipeline{
    agent any    
    stages{
      
        stage("checkout"){
            steps{
                git url:'https://github.com/Egiantsgit/registration-service.git'
            }
        }
        
        stage("Compile"){            
                steps{   
                    dir('registration-service'){
                        sh "sh ./mvnw compile"                      
                    }
                }
        }
        
        stage("Unit test"){            
                steps{     
                    dir('registration-service'){
                        sh "sh ./mvnw test"
                    }
                }                
        }
        
        stage("Package"){            
                steps{
                    dir('registration-service'){
                        sh "sh ./mvnw package"
                    }
                }
        }        
        
        
        
        stage("Docker build"){            
                steps{
                    dir('registration-service'){
                        sh "docker login --username egiantsdocker --password Egaints#1"        	
                        sh "docker build -t egiantsdocker/registrationservice ."
                        sh "docker push egiantsdocker/registrationservice"
                    }
                }
        }
    }
 
}        
        
        
