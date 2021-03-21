# TQS - LAB01
#### Author: Francisca Barros, NMEC-93102
---
 
## 2

##### d)  
*Interpret the results accordingly. Which classes/methods offer less coverage? Are all possible decision branches being covered?*

74% of all instructions (in our code) were used in some test.
Some of the code was actually never used by any - this doesn't necessarily mean 'bad news', since some of the code generated from the framework doesn't need any testing (for instance, hash code)
Like stated in TP classes, coverage is an important mesurement. However, it's not absolute. 
- Having a very low coverage % is something to be worried about.
- Aiming for a 100% coverage is ~usually~ not our goal.


The class that offers less coverage is *DemoMain*, 0% coverage. The UI itself is never tested, only the methods that are needed for the algorithm to work. 

After that, the class *CuponEuromillions*, offers us only 40% coverage, due to the fact that the method *format()* is always missed. 


Now talking branches.
According to the report JaCoCo generated, most of decision branches are being covered in the following classes
- Class *Dip*, except for those that refer to automatically generated code (*hashcode*) and some in *equals*
- Class *SetOfNaturals*, except for those that refer to automatically generated code (*hashcode*) and some in *equals*

