import java.util.stream.*; 

class DoubleColonDemo{
	public static void main(String args[]){
		Stream<String> stream = Stream.of("a","b","c");
		stream.forEach(System.out::println);
	}
}
