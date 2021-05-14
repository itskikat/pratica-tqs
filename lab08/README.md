
# TQS - LAB08

#### Author: Francisca Barros, NMEC-93102

---

  

## 1/

  

  

Jenkins is rather "meh" in terms of compatibility. First of all, it's only capable of running with Java8/Java11... so yeah it's outdated :). 

As I have the most recent Java version installed, I had to switch from Java15 to Java11, using the following command: 


``` zsh
$ export JAVA_HOME=`/usr/libexec/java_home -v 11.0.10`
```


After that, we can run Jenkins in the terminal like this :D 


``` zsh
$ java -jar jenkins.war --httpPort=8081
```


Personally, I chose 8081 as the port since I had my HW running in 8080, oops :p 

So, Jenkins can be accessed via the link *http://localhost:8081/*




##### e) + f) + g)

  

For the *New Job*, I decided to use the *Car Management System* from Lab04, since it had a couple of tests. 

After requesting and finishing the build, I inspected the console output thoroughly, as the build had been flagged as **Unstable**.

```zsh
[INFO] 
[INFO] Results:
[INFO] 
[ERROR] Errors: 
[ERROR]   CarManagerServiceTest.whenInvalidID_thenCarShouldNotBeFound:55 NullPointer
[INFO] 
[ERROR] Tests run: 10, Failures: 0, Errors: 1, Skipped: 0
[INFO] 
[ERROR] There are test failures.
```

As shown in the results section, there was 1 test that had an error. A *java.lang.NullPointerException* had been thrown.

From [Jenkins own Wiki](https://wiki.jenkins.io/display/jenkins/terminology), "A build is unstable if it was built successfully and one or more publishers report it unstable. For example if the JUnit publisher is configured and a test fails then the build will be marked unstable". 



  
  
  

## 2/

  

##### h)

  

For this task I reused the same Git Repository (the one from Practical classes), but chose to alter the project under testing. This time, I used the *Euromillions* project, from Lab06 (after being refactored according to the SonarQube analysis)





##### j)

  

As expected, the job ran seamlessly, and printed the version information of the tools.  

```zsh
[Pipeline] }
[Pipeline] // stage
[Pipeline] withEnv
[Pipeline] {
[Pipeline] stage
[Pipeline] { (Declarative: Tool Install)
[Pipeline] tool
[Pipeline] envVarsForTool
[Pipeline] tool
[Pipeline] envVarsForTool
[Pipeline] }
[Pipeline] // stage
[Pipeline] withEnv
[Pipeline] {
[Pipeline] stage
[Pipeline] { (test java installation)
[Pipeline] tool
[Pipeline] envVarsForTool
[Pipeline] tool
[Pipeline] envVarsForTool
[Pipeline] withEnv
[Pipeline] {
[Pipeline] sh
+ java -version
openjdk version "11.0.10" 2021-01-19
OpenJDK Runtime Environment (build 11.0.10+9)
OpenJDK 64-Bit Server VM (build 11.0.10+9, mixed mode)
[Pipeline] }
[Pipeline] // withEnv
[Pipeline] }
[Pipeline] // stage
[Pipeline] stage
[Pipeline] { (test maven installation)
[Pipeline] tool
[Pipeline] envVarsForTool
[Pipeline] tool
[Pipeline] envVarsForTool
[Pipeline] withEnv
[Pipeline] {
[Pipeline] sh
+ mvn -version
Apache Maven 3.6.3 (cecedd343002696d0abb50b32b541b8a6ba2883f)
Maven home: /usr/local/Cellar/maven/3.6.3_1/libexec
Java version: 11.0.10, vendor: Oracle Corporation, runtime: /usr/local/Cellar/openjdk@11/11.0.10/libexec/openjdk.jdk/Contents/Home
Default locale: en_GB, platform encoding: UTF-8
OS name: "mac os x", version: "11.2.3", arch: "x86_64", family: "mac"
[Pipeline] }
[Pipeline] // withEnv
[Pipeline] }
[Pipeline] // stage
[Pipeline] }
[Pipeline] // withEnv
[Pipeline] }
[Pipeline] // withEnv
[Pipeline] }
[Pipeline] // node
[Pipeline] End of Pipeline
Finished: SUCCESS
```

  

##### k)

  

For the automated polling stategy, I decided to schedule periodically tasks for every fifteen minutes (that is, 4 times every hour)

``` 
H/15 * * * * 
```
 


##### l) 



The following snippet is from the console output. 

``` zsh
[Pipeline] }
[Pipeline] // stage
[Pipeline] withEnv
[Pipeline] {
[Pipeline] stage
[Pipeline] { (Declarative: Tool Install)
[Pipeline] tool
[Pipeline] envVarsForTool
[Pipeline] tool
[Pipeline] envVarsForTool
[Pipeline] }
[Pipeline] // stage
[Pipeline] withEnv
[Pipeline] {
[Pipeline] stage
[Pipeline] { (Install)
[Pipeline] tool
[Pipeline] envVarsForTool
[Pipeline] tool
[Pipeline] envVarsForTool
[Pipeline] withEnv
[Pipeline] {
[Pipeline] dir
Running in /Users/franciscabarros/.jenkins/workspace/TQS_Lab08_JenkinsSimplePipeline/lab06/TQS_Lab06-Euromillions
[Pipeline] {
[Pipeline] sh
+ mvn clean install
[INFO] Scanning for projects...
[INFO] 
[INFO] ---------------------< tqslabs:euromillions-play >----------------------
[INFO] Building euromillions-play 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ euromillions-play ---
[INFO] Deleting /Users/franciscabarros/.jenkins/workspace/TQS_Lab08_JenkinsSimplePipeline/lab06/TQS_Lab06-Euromillions/target
[INFO] 
[INFO] --- jacoco-maven-plugin:0.8.6:prepare-agent (default) @ euromillions-play ---
[INFO] argLine set to -javaagent:/Users/franciscabarros/.m2/repository/org/jacoco/org.jacoco.agent/0.8.6/org.jacoco.agent-0.8.6-runtime.jar=destfile=/Users/franciscabarros/.jenkins/workspace/TQS_Lab08_JenkinsSimplePipeline/lab06/TQS_Lab06-Euromillions/target/jacoco.exec
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ euromillions-play ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /Users/franciscabarros/.jenkins/workspace/TQS_Lab08_JenkinsSimplePipeline/lab06/TQS_Lab06-Euromillions/src/main/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ euromillions-play ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 5 source files to /Users/franciscabarros/.jenkins/workspace/TQS_Lab08_JenkinsSimplePipeline/lab06/TQS_Lab06-Euromillions/target/classes
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ euromillions-play ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /Users/franciscabarros/.jenkins/workspace/TQS_Lab08_JenkinsSimplePipeline/lab06/TQS_Lab06-Euromillions/src/test/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ euromillions-play ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 3 source files to /Users/franciscabarros/.jenkins/workspace/TQS_Lab08_JenkinsSimplePipeline/lab06/TQS_Lab06-Euromillions/target/test-classes
[INFO] 
[INFO] --- maven-surefire-plugin:3.0.0-M5:test (default-test) @ euromillions-play ---
[INFO] 
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running euromillions.DipTest
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.181 s - in euromillions.DipTest
[INFO] Running euromillions.EuromillionsDrawTest
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.062 s - in euromillions.EuromillionsDrawTest
[INFO] Running sets.SetOfNaturalsTest
[INFO] Tests run: 10, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.065 s - in sets.SetOfNaturalsTest
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 13, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] 
[INFO] --- jacoco-maven-plugin:0.8.6:report (report) @ euromillions-play ---
[INFO] Loading execution data file /Users/franciscabarros/.jenkins/workspace/TQS_Lab08_JenkinsSimplePipeline/lab06/TQS_Lab06-Euromillions/target/jacoco.exec
[INFO] Analyzed bundle 'euromillions-play' with 5 classes
[INFO] 
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ euromillions-play ---
[INFO] Building jar: /Users/franciscabarros/.jenkins/workspace/TQS_Lab08_JenkinsSimplePipeline/lab06/TQS_Lab06-Euromillions/target/euromillions-play-1.0-SNAPSHOT.jar
[INFO] 
[INFO] --- maven-install-plugin:2.4:install (default-install) @ euromillions-play ---
[INFO] Installing /Users/franciscabarros/.jenkins/workspace/TQS_Lab08_JenkinsSimplePipeline/lab06/TQS_Lab06-Euromillions/target/euromillions-play-1.0-SNAPSHOT.jar to /Users/franciscabarros/.m2/repository/tqslabs/euromillions-play/1.0-SNAPSHOT/euromillions-play-1.0-SNAPSHOT.jar
[INFO] Installing /Users/franciscabarros/.jenkins/workspace/TQS_Lab08_JenkinsSimplePipeline/lab06/TQS_Lab06-Euromillions/pom.xml to /Users/franciscabarros/.m2/repository/tqslabs/euromillions-play/1.0-SNAPSHOT/euromillions-play-1.0-SNAPSHOT.pom
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  10.319 s
[INFO] Finished at: 2021-05-11T12:28:47+01:00
[INFO] ------------------------------------------------------------------------
[Pipeline] }
[Pipeline] // dir
Post stage
[Pipeline] junit
Recording test results
[Checks API] No suitable checks publisher found.
[Pipeline] }
[Pipeline] // withEnv
[Pipeline] }
[Pipeline] // stage
[Pipeline] }
[Pipeline] // withEnv
[Pipeline] }
[Pipeline] // withEnv
[Pipeline] }
[Pipeline] // node
[Pipeline] End of Pipeline
Finished: SUCCESS
```
  
From the analysis of the console, it is possible to conclude that the Test Report was installed correctly.

After exploring the project's workspace (used by Jenkins), I was able to find both the project and the reports generated, being able to browse all files. 



## 4/

  

##### a)

  

Installing a *Dockerized* Jenkins service was pretty simple. 

First, create a Docker Bridge Network


```zsh
$ docker network create jenkins
```

Then, the Docker Image should be downloaded and run.

```zsh
$ docker run --name jenkins-docker --rm --detach \
  --privileged --network jenkins --network-alias docker \
  --env DOCKER_TLS_CERTDIR=/certs \
  --volume jenkins-docker-certs:/certs/client \
  --volume jenkins-data:/var/jenkins_home \
  --publish 2376:2376 docker:dind --storage-driver overlay2
```


After this, we just need to customize the Docker Image with a Dockerfile

```Dockerfile
FROM jenkins/jenkins:2.277.4-lts-jdk11
USER root
RUN apt-get update && apt-get install -y apt-transport-https \
       ca-certificates curl gnupg2 \
       software-properties-common
RUN curl -fsSL https://download.docker.com/linux/debian/gpg | apt-key add -
RUN apt-key fingerprint 0EBFCD88
RUN add-apt-repository \
       "deb [arch=amd64] https://download.docker.com/linux/debian \
       $(lsb_release -cs) stable"
RUN apt-get update && apt-get install -y docker-ce-cli
USER jenkins
RUN jenkins-plugin-cli --plugins "blueocean:1.24.6 docker-workflow:1.26"
```


and build it!

```zsh
$ docker build -t myjenkins-blueocean:1.1 .
```


We're now able to run Jenkins!

```zsh
docker run --name jenkins-blueocean --rm --detach \
  --network jenkins --env DOCKER_HOST=tcp://docker:2376 \
  --env DOCKER_CERT_PATH=/certs/client --env DOCKER_TLS_VERIFY=1 \
  --publish 8080:8080 --publish 50000:50000 \
  --volume jenkins-data:/var/jenkins_home \
  --volume jenkins-docker-certs:/certs/client:ro \
  --volume "$HOME":/home \
  myjenkins-blueocean:1.1
```
   


