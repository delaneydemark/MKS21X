public class Driver{
    public static void main(String[] args){
	Book test = new Book("Me","no", "55555");

	System.out.println(test.getAuthor());
	System.out.println(test.getTitle());
	System.out.println(test.getISBN());

	test.setAuthor("You");
	test.setTitle("yes");
	test.setISBN("7777");

	System.out.println(test.toString());
       
    }

    
}
