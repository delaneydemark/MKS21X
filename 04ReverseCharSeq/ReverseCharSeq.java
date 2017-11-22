public class ReverseCharSeq implements CharSequence{

    private String reversed;

    public ReversedCharSeq(String a){
	reversed = "";
	for (int i = a.length()-1; i>=0; i++){
	    reversed+= a.substring(i, i+1);
	}
    }
   
}
