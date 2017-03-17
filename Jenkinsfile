node ("master") {

stage 'Checkout'
       
	   checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'poojabansal607@gmail.com', url: 'https://github.com/poojabansal607/control-repo.git']]])
       def mvnHome = tool 'M3'
   		
stage 'Build'
     
	   sh "${mvnHome}/bin/mvn clean install"
	   step([$class: 'ArtifactArchiver', artifacts: '**/target/*.jar', fingerprint: true])
	   step([$class: 'JUnitResultArchiver', testResults: '**/target/surefire-reports/TEST-*.xml'])		
	   
	   def workspace = pwd()
       echo "workspace=${workspace}"
	   
	   //def var1 = /var/lib/jenkins/jobs/assessment/lastSuccessful/archive/target
	   //def var2 = /etc/puppetlabs/puppet/deploy_files/assessment/target/
	  
	 // sh "scp ${var1}/assessment-1.0-SNAPSHOT.jar root@del2vmpldevop02.sapient.com:${var2}"
	  
		
//stage 'Deploy to QA'
  //     puppet.credentials 'secret'
	//   echo "connection is made with puppet"
	 //  puppet.codeDeploy 'production' 
	  // echo "Code Deployed"
	   
//stage 'Deploy to PROD'
    //   input "Ready to deploy to PROD?"	   

	}


