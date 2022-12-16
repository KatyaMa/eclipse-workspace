package Jump;

public class String_Last_SecondLast {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(res("bat"));   // output: t a
	}
	public static String res(String word) {
		 String result = "";
		    result += word.charAt(word.length() -1) + " " + word.charAt(word.length() -2);
		    return result;
	}

}
