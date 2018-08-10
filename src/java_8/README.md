## Get taste of Lambdas & Streams - Venkat Subramaniam

### Table of Contents

* [Taste of Lambda](#taste-of-lambda)
	* [Replace anonymous inner classes](#replace-anonymous-inner-classes)
* [Iterating using lambdas](#iterating-using-lambdas)


#### Taste of Lambda
First lets compare function with lambdas
Function has four things
	1. name
	2. parameter
	3. body
	4. return type

Where Lambdas have only parameter and body


#### Replace anonymous inner classes
We can rapidly use lambdas instead of using anonymous inner classes

We are creating a thread with anonymous inner class
```java
Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Another thread");
				
			}
		});
```

##### With lambdas
```java
Thread thread2 = new Thread(() -> System.out.println("Lambda thread"));
```
##### Actual benifit of using lambdas
When we use anonymous inner classes compiler create dot(.) class file for each anonymous inner classes
The more inner classes the more dot class file we have mean more memory footprint on the JVM.
But lambdas dont work that way it uses <b>invoke dynamic<b> to attach and detach the function you wana invoke at runtime

#### Iterating using lambdas
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
numbers.forEach((Integer value) -> System.out.println(value));
```
