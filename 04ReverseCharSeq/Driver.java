public class Driver{
	public static void main(String[] args){
		ReverseCharSeq test = new ReverseCharSeq("abcd");
	
		System.out.println(test.length());
		System.out.println(test.charAt(2));
		System.out.println(test.toString());
		System.out.println(test.subSequence(0,3));
	}
}
