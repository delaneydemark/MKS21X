public class CirculatingBook extends LibraryBook{

	private String currentHolder;
	private String dueDate;
	
	public CirculatingBook(String a, String t, String ISBN, String callNum){
		super(a,t,ISBN,callNum);
		currentHolder = null;
		dueDate = null;
	}
	
	public String getCurrent(){
		return currentHolder;
	}
	
	public String getDueDate(){
		return dueDate;
	}
	
	public boolean setCurrent(String name){
		currentHolder=name;
		return true;
	}
	
	public boolean setDueDate(String date){
		dueDate=date;
		return true;
	}
	
	public void checkout(String patron, String due){
		currentHolder=patron;
		dueDate=due;
	}
	
	public void returned(){
		currentHolder=null;
		dueDate=null;
	}
	
	public String circulationStatus(){
		if (currentHolder==null){
			return "book available on shelves";
		}
		return currentHolder+ ", " + dueDate;
	}
	
	public String toString(){
		if(currentHolder==null){
			return super.toString();
		}
		return super.toString()+ ", "+ currentHolder+", "+ dueDate;
	}

}
