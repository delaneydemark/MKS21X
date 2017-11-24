public class ReverseCharSeq implements CharSequence{

    private char[] reversed;

    public ReverseCharSeq(String a){
		reversed = new char[a.length()];
		for (int i = a.length()-1, j=0; i>=0; i--, j++){
	  	  reversed[j]= a.charAt(i);
		}
    }
    
    public int length(){
    	return reversed.length;
    }
   
   public char charAt(int index){
   		if (index<0 || index>= reversed.length){
   			throw new IndexOutOfBoundsException();
   		}
   		return reversed[index];
   }
   
   public CharSequence subSequence(int start, int end){
   		String s ="";
   		if (start<0 || end> reversed.length || start>end){
   			throw new IndexOutOfBoundsException();
   		}
   		for (int i = start; i< end; i++){
   			s+= reversed[i];
   		}
   		return s;
   }
   
   public String toString(){
   		String s = "";
   		for (int i = 0; i<reversed.length; i++){
   			s+= reversed[i];
   		}
   		return s;
   }
}
