This is a programming exercise – a RPN Calculator

The running environment needs JRE 1.8x

To run the calculator: **java -jar ./bin/airwallex.calculator.jar** 
  
All java source code is in the directory **./calculator/src**, I have created a gradle file to build or test the java code.

Before you build this calculator, please make sure the gradle has been installed. Replace "your_gradle_home" to your gradle home.

To build the app:
  _your_gradle_home_**/bin/gradle build**
  
You can see the jar file and class files in the ./calculator/build/
  
To run the junit test:
  _your_gradle_home_**/bin/gradle test**  
  
To see the test report, please open the index.html in the ./calculator/build/reports/tests/test/

According to the OCP (Open–closed principle), I designed a flexible application, it is easy to be add new functionality to handle new operators, such as: Power, Log etc.

TODO:
  1. can quit application in the command line, eg: the app quits if input '.'
  2. do not rounding when print the value in the stack, eg: in the requirement, input "2 sqrt", output is "stack: 1.4142135623", in the demo, it outputs "Stack: 1.4142135624"
  3. add prompts for inputting the calculator rpn text.  
  