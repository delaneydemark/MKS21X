import java.util.Iterator;

public class SuperArrayIterator implements Iterator<String>{

	private SuperArray data;
	private int current;
	
	public SuperArrayIterator(SuperArray arr){
		data=arr;
		current=0;
	
	}
	
	public boolean hasNext(){
		return current<=data.size();
	}
	
	public String next(){
		current++;
		return data.get(current-1);
	}
	
	public void remove(){
            throw new UnsupportedOperationException();
    }


}
