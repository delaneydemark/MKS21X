public class Book{

    private String author;
    private String title;
    private String ISBN;

    public Book(){
	
    }

    public Book(String a, String t, String num){
	author=a;
	title=t;
	ISBN=num;
    }

    public String getAuthor(){
	return author;
    }

    public String getTitle(){
	return title;
    }

    public String getISBN(){
	return ISBN;
    }

    public boolean setAuthor(String a){
	author=a;
	return true;
    }

    public boolean setTitle(String t){
	title=t;
	return true;
    }

    public boolean setISBN(String num){
	ISBN=num;
	return true;
    }

    public String toString(){
	return title + ", " + author + ", " + ISBN;
    }
}
