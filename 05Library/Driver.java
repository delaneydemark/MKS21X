public class Driver{
    public static void main(String[] args){
	/*Book test = new Book("Me","no", "55555");

	System.out.println(test.getAuthor());
	System.out.println(test.getTitle());
	System.out.println(test.getISBN());

	test.setAuthor("You");
	test.setTitle("yes");
	test.setISBN("7777");

	System.out.println(test.toString());
       */
    /*ReferenceBook a = new ReferenceBook("Me", "heck yea", "999999", "55443", "math");
    
    a.setColl("news");
    System.out.println(a.toString());
    a.checkout("dude", "11/29");
    a.returned();*/
    
    CirculatingBook b = new CirculatingBook("beyonce", "buzz", "8675309", "22222");
    
    b.checkout("me", "never");
    System.out.println(b.toString());
    b.returned();
    System.out.println(b.toString());

    }
    
    
    
}
