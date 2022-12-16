package Jump;

public class Jump {

	public static void main(String[] args) {
		
		System.out.println(jump(8, 3));    // output: 4
	}
	public static int jump(int flagHeight, int bigJump) {
        int count = 0;
        count += (int)(flagHeight / bigJump + (flagHeight % bigJump));
        return count; 

	}

}
