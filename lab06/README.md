
# TQS - LAB06

#### Author: Francisca Barros, NMEC-93102

---

  

## 1/

  

##### a)

  

Installing SonnarQube in MacOS is pretty straight-forward when having *Homebrew* installed. 


``` zsh
$ brew install sonarqube
```


After that, in order to run it, it's also very simple


``` zsh
$ brew services start sonarqube
```


And that's it! It is accessible via the default link :D *http://localhost:9000/*



##### c)

  

The Maven-based, Java application project selected was *Euromillions*, from the first lab. 


  
  

##### e)

  

*Has your project passed the defined quality gate? Elaborate your answer.*

  

![Default Quality Gate](https://i.ibb.co/BGptfy7/image.png)

The (default) defined quality gate considered was the one in the above image. 
The project did pass it; however, the metrics shown were far bellow the gate values (i.e. Coverage was only 73.5%, and it should be >80% in order to pass; there were no Security Hotspots reviewed.)


![Project Metrics](https://i.ibb.co/1TsLZv9/image.png)

This is due to the fact that Sonar is considering the code for the first time, passing it as it is. 

  

##### f)

  

*Results Analysis*

  

| ISSUE | PROBLEM DESCRIPTION | HOW TO SOVE |
| ----- | ------------------- | ----------- |
| *BUG*   | "Save and reuse this 'Random'" ("Creating a new Random object each time a random value is needed is inefficient and may produce numbers which are not random depending on the JDK.") | "For better efficiency and randomness, create a single Random, then store, and reuse it.” |
| *VULNERABILITY*     | ---       | ---      |
| *CODE SMELL (MAJOR)*     | "Refactor the code in order to not assign to this loop counter from within the loop body." | "this means that the stop condition is set to a local variable just before the loop begins." |
| *CODE SMELL (MAJOR)*     | "Replace this use of System.out or System.err by a logger" | "defining and using a dedicated logger is highly recommended to comply with the following requirements (The user must be able to easily retrieve the logs; The format of all logged message must be uniform to allow the user to easily read the log; Logged data must actually be recorded; Sensitive data must only be logged securely)" |
| *SECURITY HOTSPOT*     | "Make sure that using this pseudorandom number generator is safe here; Using pseudorandom number generators (PRNGs) is security-sensitive" | "Recommended Secure Coding Practices (Use a cryptographically strong random number generator (RNG) like "java.security.SecureRandom" in place of this PRNG; Use the generated random values only once; You should not expose the generated random value. If you have to store it, make sure that the database or file is secure)." |


<br>  
  
  
  

## 2/

  

##### a)

  

The project being used is the same as the exercise above, Euromillions.


According to several sources, **Technical Debt** can be defined as the effort to fix all maintainability issues (via SonarQube documentation), the sum of the technical debt of every code smell in the project, not considering bugs nor vulnerabilities (via Stackoverflow).



Picking up the project as is, the debt found was of 2h15min, with a ratio of 1.6%. 



##### b)

  

After correcting the severe code smells reported, the debt found was down to only 32min, with a ratio of 0.9%.

As shown bellow, the project keeps passing the quality gate, and even improved some metrics!.


![Fixed Issues Analysis](https://i.ibb.co/mvY6zGQ/After-fixing-the-code-smells.png)

  

##### d)

  

![Coverage Values](https://i.ibb.co/yYfrNQJ/Coverage-Analysis.png)
 
There are 41 lines uncovered (mostly, like stated in the previous lab, in *hashCode()*, framework-related functions; and some conditions in the main).

There are 14 uncovered conditions.
 
  
  

## 3/

  

##### a)

  

*Custom quality gate defined for the project.*


In this exercise, I collaborated with a colleague (Margarida), in order to define the quality gate for our IES project. 

We defined the following metrics: 

![Custom Metrics](https://i.ibb.co/fDRr0jb/IES-Project-Conditions.png)
  

This is due to the fact that I recall having a lot of issues with *Spring Security* while developing the project. Besides that, we must also have a ton of duplicated lines. 

No Coverage metric was defined, since we did not implement any testing. 


The results of the analysis are the following:

![Results IES](https://i.ibb.co/k5Cj6nN/Results-IES.png)


   

##### b)

  

*Try to break the custom defined quality gate.*



This task was rather easy - since there were a lot of code smells, and a few vulnerabilities, just by correcting a few and adding others in different places made the test fail. 

Adding more duplicate lines would also do that.

