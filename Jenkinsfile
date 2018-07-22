pipeline{
    agent any    
    stages{
      
       stage("checkout"){
            steps{
                git url:'https://github.com/Egiantsgit/registration-service.git'
            }
        }
     
  /*     stage("Compile"){            
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
                       echo "${DB_KEY}"
                       echo "${DB_S_KEY}"                         
                          sh "docker login --username ${DOCKER_HUB_USERNAME} --password ${DOCKER_HUB_PASSWORD}"        	
                          sh "docker build -t egiantsdocker/registrationservice ."
                         sh "docker push egiantsdocker/registrationservice"
                    }
                }
        }   
    */ 
      stage("Prepare Staging Server"){
            steps{
                sh "chmod u+x ./inventory/ec2.py"
                sh "ansible-playbook ec2_playbook.yml --private-key ../softworldkey.pem"
            }
        }
     

       /*
        stage("Deploy"){
            steps{
                sh "docker pull egiantsdocker/registrationservice"
                sh "docker run -p 8082:8082 --name registrationservice egiantsdocker/registrationservice"
            }
        }
        */
        
    }
 
}        
        
        
