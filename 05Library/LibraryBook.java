abstract class LibraryBook extends Book implements Comparable<LibraryBook>{

    private String callNumber;

    public LibraryBook(String a, String t, String ISBN, String cNum){
        super(a,t,ISBN);
	callNumber= cNum;
    }
    
    public String getCallNum(){
	return callNumber;
    }

    public boolean setCallNum(String cNum){
	callNumber=cNum;
	return true;
    }

    abstract void checkout(String patron, String due);

    abstract void returned();

    abstract String circulationStatus()

    public int compareTo(LibraryBook a){
	return this.getCallNum()- a.getCallNum();
    }

    public String toString(){
	return getTitle()+", " + getAuthor() + ", " +getISBN()+ ", ";
    }
    
}
