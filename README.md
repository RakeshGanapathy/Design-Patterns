# DesignPrinciples 

# Solid Principles

* **S** 	[Single Responsibility Principle](https://github.com/RakeshGanapathy/Design-Patterns/blob/master/README.md#single-responsibility-principle)
* **O** 	[Open-Closed Principle](https://github.com/RakeshGanapathy/Design-Patterns/blob/master/README.md#open-closed-principle)
* **L** 	[Liskov-Substitution Principle](https://github.com/RakeshGanapathy/Design-Patterns/blob/master/README.md#liskov-substitution-principle)
* **I** 	[Interface-Segregation Principle](https://github.com/RakeshGanapathy/Design-Patterns/blob/master/README.md#interface-segregation-principle)
* **D** 	[Dependency Inversion Principle](https://github.com/RakeshGanapathy/Design-Patterns/blob/master/README.md#dependency-inversion-principle-dip)

# [Other Principles](https://github.com/RakeshGanapathy/Design-Patterns/blob/master/README.md#other-principles-1)


# Single Responsibility principle

						*A class should have one, and only one, reason to change*

* there should never be more than one reason for a class to change 
this means that everyclass or similar structure in your code should have only
one job to do 

* everything in the class should be related to that single purpose.
it does not mean that your class should only contain one method 
or property.

* there can be a lot of members as long as they relate to the single 
responsibility

* it may be that when the one reason to change occurs, multiple members
of the class may need modification , it may also be that multiple  class 
will require updates for example 

				class Employee{
					public pay calculatePay(){..}
					public void save(){...}
					public String describeEmployee(){}
				}

* we have pay calculation logic with database logic and reporting logic 
all mixed up within one class.

* if you have multiple responsibility combined into one class , it might 
be dificult to change one part without breaking others.

* Mixing responsibility also makes the class harder to understand 
and harder to test. the easiest way to fix this is to split the class into 
3 different classes with each having only one responsibility

					class DataBaseAccess{
					 	public void save(){..}
					} 
					
					class PayCalculation{
						public Pay CalculatePay(){..}
					}
					
					class EmployeeReport{
						public String describeEmployee(){...}
					}

benefits : reducing the coupling between individual component of the application


# Open-Closed principle  

	_“*Software entities (classes, modules, functions, etc.) should be open for extension, but closed for modification.*”

	*“A class is closed, since it may be compiled, stored in a library, baselined, and used by client classes. 
	But it is also open, since any new class may use it as parent,adding new features.
	When a descendant class is defined, there is no need to change the original or to disturb its clients.”*_



* "open to extension " - you should design your class so that new functionality can be added as new requirement by creating a derived class
	1. final ,private access modifiers need to be avoided.
	2. promotes the use of interfaces to enable you to adapt the functionality of your application without changing the existing code.


* "closed for modification" - once developed class should never be modified ,
except to correct bugs
		
					class LogTransformer{
							public void transform(){..}
							// transforms logs into data table 
					}
					
					class JSONLogTransformer extends LogTransformer{
							@override
							public void transform(){...}// transforms logs into json file 
					}

these two parts of the principle appears to contradictory if you correctly structure classes and their dependencies, you can add functionality without editing the existing code 


#  Liskov Substitution principle

* The Liskov substitution principle applies to inheritance hierarchies, specifying that you should design your classes so that dependencies can be substituted with 
  subclasses without the client knowing about the change.
  
* All subclasses must, therefore operate in the same manner as their base classes the specific functionality of the subclass may be different but must conform to the 
  expected behaviour of the base class 
  
* To be true behavioral subtype , the subclass must not only implement the base class's methods and properties, but also confirm to its implied behaviour

* In general, if a subtype of the supertype does something that the client of the supertype does not expect, then this is in violation of LSP.

* *Imagine a derived class throwing an exception that the superclass does not throw* or 
  *if a derived class has some unexpected side effects* basically, derived classes should never do less than their base class.

* A typical example that violates LSP is a Square class that derives from a Rectangle class.

* The Square class always assumes that the width is equal with the height.If a Square object is used in a context where a Rectangle is expected.unexpected behavior may occur because the dimensions of a Square cannot (or rather should not) be modified independently.

Liskov Substitution Principle Example
This problem cannot be easily fixed: if we can modify the setter methods in the Square class so that they preserve the Square invariant (i.e., keep the dimensions equal), then these methods will weaken (violate) the post-conditions for the Rectangle setters, which state that dimensions can be modified independently.


									public class Rectangle {
									  private double height;
									  private double width;

									  public double area();

									  public void setHeight(double height);
									  public void setWidth(double width);
									}
									
**What you see above violates LSP**.

									public class Square extends Rectangle {  
									  public void setHeight(double height) {
									    super.setHeight(height);
									    super.setWidth(height);
									  }

									  public void setWidth(double width) {
									    setHeight(width);
									  }
									}
									
Violations of LSP cause undefined behavior, which can lead to weeks of wasted time trying to find out where the bug is.
  
**SUMMARY**

* enables you to replace objects of a parent class with objects of a subclass without breaking the application. 
* This requires all subclasses to behave in the same way as the parent class. To achieve that, your subclasses need to follow these rules:

	1.Don’t implement any stricter validation rules on input parameters than implemented by the parent class.
	2.Apply at the least the same rules to all output parameters as applied by the parent class.


#  **Interface Segregation principle**

		_“Clients should not be forced to depend upon interfaces that they do not use.”_

* When you apply ISP, classes and their dependencies communicate using tightly-focused interfaces, minimizing dependencies on unused members and reducing coupling accordingly. 

* Smaller interfaces are easier to implement, improving flexibility and the possibility of reuse. As fewer classes share these interfaces, the number of changes that are required in response to an interface modification is lowered, which increases robustness.

**_Interface Segregation Principle Example_**

Picture an ATM, which has a screen where we wish to display different messages. If you want to add a message on the ATM that appears only for withdrawal functionality, 
how would you solve it?_

Perhaps you would add a method to the Messenger interface and be done with it. But this causes you to recompile all the users of this interface and almost all the system needs to be redeployed, which is in direct violation of OCP. 

_What happened here was that changing the withdrawal functionality caused changes to other totally unrelated functionalities as well, which is something we now know we don't want. How did this happen?_

Actually, there is backwards dependency at play, where each functionality that uses this Messengers interface depends on methods it does not need but are needed by other functionalities. Here is what we want to avoid:

								public interface Messenger {
								  askForCard();
								  tellInvalidCard();
								  askForPin();
								  tellInvalidPin();
								  tellCardWasSiezed();
								  askForAccount();
								  tellNotEnoughMoneyInAccount();
								  tellAmountDeposited();
								  tellBalance();
								}
								
Instead, split the Messenger interface up so that different ATM functionality depend on separate Messengers.

								public interface LoginMessenger {
								  askForCard();
								  tellInvalidCard();
								  askForPin();
								  tellInvalidPin();	
								}

								public interface WithdrawalMessenger {
								  tellNotEnoughMoneyInAccount();
								  askForFeeConfirmation();
								}

								publc class EnglishMessenger implements LoginMessenger, WithdrawalMessenger {
								  ...	
								}


# Dependency Inversion principle (DIP)


			Dependency Inversion Principle is based on the Open/Closed Principle and the Liskov Substitution Principle. 
			
			The Dependency Inversion Principle (DIP) states that 
				1.High-level modules should not depend on low-level modules. Both should depend on abstractions.
				2.Abstractions should not depend on details. Details should depend on abstractions
	
* The idea is that we isolate our class behind a boundary formed by the abstractions it depends on. If all the details behind those abstractions change, 
  then our class is still safe. This helps keep coupling low and makes our design easier to change. DIP also allows us to test things in isolation.

   Dependency Inversion Principle Example
   
	A program depends on Reader and Writer interfaces that are abstractions, and Keyboard and Printer are details that depend on those abstractions 
	by implementing those interfaces.
	
	Here CharCopier is oblivious to the low-level details of Reader and Writer implementations and thus you can pass in any Device that implements the Reader and Writer 		interface and CharCopier would still work correctly.
			

									public interface Reader { 
									char getchar(); 
									}
									public interface Writer { 
									void putchar(char c)
									}

									class CharCopier {
									  void copy(Reader reader, Writer writer) {
									    int c;
									    while ((c = reader.getchar()) != EOF) {
									      writer.putchar();
									    }
									  }
									}

									public Keyboard implements Reader {...}
									public Printer implements Writer {…}


# Other Principles 

	6. DRY - Dont Repeat Yourself
		Avoiding duplicate code instead use Abstraction to abstract everyday things in one place 
		eg: Utility Class , Constants
	
	7. Encapsulate Changes 
	 	Encapsulate the code which are expected or suspected to change,its very easy to test and maintain proper encapsulated code 
		Making variables as private and accessing the variables using methods
	
	8. Programming for Interface not Implementation
		eg:
					List num = getNumber();
		instead of 
		
					ArrayList num = getNumber();
	9. Delicate 
		Dont do all the implementation by yourself , do deligate it to respective class 
		
	10. Favour Composition over Inheritance 

# Design Pattern 

A Design pattern is a general reusable solution to a commonly occuring problems in software design 

its a template for how to solve a problem that can be used in many different situation 

Pattern are fomalized best practices that the programmer can use to solve common problems while designing an application or system 

Design Patterns are broadly classified into 3 types namely 
								1. Creational Pattern
								2. Structural Pattern
								3. Behavioural Pattern 
   
1. Creational Design Pattern 
	Creational Design patterns are concerned with the way of creating an object (Instantiation), these design pattern are used 
	when a decision must be made at the time of instantiation of a class 
	
	typically we do hard code like 
	
		Developer dev = new Developer();
		
	types of creational design pattern , 
						1. Singleton Pattern 
						2. Factory Pattern 
						3. Abstract Factory pattern
						4. Prototype pattern
						5. Builder pattern
						6. ObjectPool Pattern




	Singleton :
			Define a class that has only one instance and provide a global point of access to it 
			
	A class must ensure that only single instance should be created and single object can be used by all the other classes
			
	eg:  practical use Singleton patterns are used in logging, caches, thread pools, configuration settings, device driver objects.
	
	How to acheive singleton 
	 1. make the constructor as private 
	 2. create a private static variable of type singleton
	 3. create a synchronized static method as public with return type as Singleton Class

	There are two forms of instantiation 
			1. early
			2. Lazy 
	
	
	

