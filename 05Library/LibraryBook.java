abstract class LibraryBook extends Book implements Comparable<LibraryBook>{

    private String callNumber;

    public LibraryBook(String a, String t, String ISBN, String cNum){
	setAuthor(a);
	setTitle(t);
	setISBN(ISBN);
	callNumber= cNum;
    }
    
    public String getCallNum(){
	return callNumber;
    }

    public boolean setCallNum(String cNum){
	callNumber=cNum;
	return true;
    }

    public int compareTo(LibraryBook a){
	return this.getCallNum()- a.getCallNum();
    }
    
}
