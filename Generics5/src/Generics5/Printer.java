package Generics5;

public class Printer{
	
	public <T> void printArray(T[] array) {
		for (T x: array) {
			System.out.println(x);
		}
		
	}
}