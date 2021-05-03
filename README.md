# DesignPrinciples 

# Solid Principles

S Single Responsibility Principle
O Open-Closed Principle
L Liskov Substitution Principle 
I Interface Segregation Principle
D Dependency Inversion Principle 


# Single Responsibility Principle

* A class should have only one responsibility 

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

* clases should be open for extendsion but closed for modification 

* "open to extension " - you should design your class so that new functionality
can be added as new requirement by creating a derived class 

* "closed for modification" - once developed class should never be modified ,
except to correct bugs
		
					class LogTransformer{
							transform(){..}
							// transforms logs into data table 
					}
					
					class JSONLogTransformer extends LogTransformer{
							@override
							transform(){...}// transforms logs into json file 
					}

these two parts of the principle appears to contradictory 
if you correctly structure classes and their dependencies, you can add
functionality without editing the existing code 


#  Liskov Substitution principle :


#  Design Pattern