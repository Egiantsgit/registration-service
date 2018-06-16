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
                sh "cd registration-service && sh ./mvnw compile"                
            }
        }
        
        stage("Unit test"){
            steps{
                sh "sh ./mvnw test"
            }
        }
        
        stage("Package"){
        	steps{
        		sh "sh ./mvnw package"
        	}
        }        
        
        
        
        stage("Docker build"){
        	steps{
        	    sh "docker login --username egiantsdocker --password Egaints#1"        	
        		sh "docker build -t egiantsdocker/registrationservice ."
        		sh "docker push egiantsdocker/registrationservice"
        	}
        }
 }
}        
        
        
