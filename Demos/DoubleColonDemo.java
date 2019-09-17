/*
The double colon (::) operator, also known as method reference operator in Java, 
is used to call a method by referring to it with the help of its class directly. 
They behave exactly as the lambda expressions. The only difference it has from lambda expressions
is that this uses direct reference to the method by name instead of providing a delegate to the method. 
*/


import java.util.stream.*; 

class DoubleColonDemo{
	public static void main(String args[]){
		Stream<String> stream = Stream.of("a","b","c");
		stream.forEach(System.out::println);
	}
}
