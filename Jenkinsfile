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
                sh "cd registration-service && sh ./mvnw test"
            }
        }
        
        stage("Package"){
        	steps{
        		sh "cd registration-service && sh ./mvnw package"
        	}
        }        
        
        
        
        stage("Docker build"){
        	steps{
        	    sh "docker login --username egiantsdocker --password Egaints#1"        	
        		sh "cd registration-service && docker build -t egiantsdocker/registrationservice ."
        		sh "cd registration-service && docker push egiantsdocker/registrationservice"
        	}
        }
 }
}        
        
        
