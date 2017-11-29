public class ReferenceBook extends LibraryBook{

	private String collection;
	
	public ReferenceBook(String a, String t, String ISBN, String callNum, String coll){
		super(a,t,ISBN,callNum);
		collection=coll;
	}
	
	public String getColl(){
		return collection;
	}
	
	public boolean setColl(String coll){
		collection=coll;
		return true;
	}
	
	public void checkout(String patron, String due){
		System.out.println("cannot check out a reference book");
	}
	
	public void returned(){
		System.out.println("reference book could not have been checked out -- return impossible");
	}
	
	public String circulationStatus(){
		return "non-circulating reference book";
	}
	
	public String toString(){
		return super.toString()+ ", "+ collection;
	}

}
