import java.util.*; //random, scanner, arraylist
import java.io.*; //file, filenotfoundexception
import java.util.Random;
import java.lang.*;

public class WordSearch{
    private char[][]data;
    private ArrayList<String> wordsToAdd;
    private ArrayList<String> wordsAdded;
    private Random randgen;
    private int seed;
    
    public static void main(String[] args){
    	String instructions = "Enter rows cols filename randomSeed answers";
    	if (args.length<3){
    		System.out.println(instructions);
    	}
    	else if(args.length == 3){
    		try{
    			WordSearch a = new WordSearch(Integer.parseInt(args[0]), Integer.parseInt(args[1]), args[2]);
    			System.out.println(a.puzzle());
    			System.out.println(a.getWordsAdded());
    		}catch(NumberFormatException e ){
    			System.out.println(instructions);
    		}
    	}
    	else if (args.length==4){
    		try{
    			WordSearch b = new WordSearch(Integer.parseInt(args[0]), Integer.parseInt(args[1]), args[2], Integer.parseInt(args[3]));
    			System.out.println(b.puzzle());
    			System.out.println(b.getWordsAdded());
    		}catch(NumberFormatException e ){
    			System.out.println(instructions);
    		}
    	}
    	else if (args.length==5){
    		try{
    			WordSearch c = new WordSearch(Integer.parseInt(args[0]), Integer.parseInt(args[1]), args[2], Integer.parseInt(args[3]));
    			if (args[4].equals("key")){
    				System.out.println(c.answers());
    			}
    			System.out.println(c.puzzle());
    			System.out.println(c.getWordsAdded());
    		}catch(NumberFormatException e ){
    			System.out.println(instructions);
    		}
    	}
    }

    /**Initialize the grid to the size specified 
     *fill all of the positions with '_'
     *@param row is the starting height of the WordSearch
     *@param col is the starting width of the WordSearch
     */
    public WordSearch(int rows,int cols, String fileName){
    	data = new char[rows][cols];   
    	clear();
    	wordsToAdd = new ArrayList<String>();
    	wordsAdded = new ArrayList<String>();
    	seed = (int)(Math.random()*100000);
    	randgen = new Random(seed);
    	try{
     		 File f = new File(fileName);//can combine
     		 Scanner in = new Scanner(f);//into one line 
     		 while(in.hasNext()){
        		String line = in.nextLine();
        		wordsToAdd.add(line);
			}     
   		 }catch(FileNotFoundException e){
      		System.out.println("File not found: " + fileName);
      		System.exit(1);
    		}
    	addAllWords();
    	System.out.println(seed + "\n");
    }
    
    public WordSearch(int rows,int cols, String fileName, int seed){
    	data = new char[rows][cols];   
    	clear();
    	wordsToAdd = new ArrayList<String>();
    	wordsAdded = new ArrayList<String>();
    	randgen = new Random(seed);
    	try{
     		 File f = new File(fileName);//can combine
     		 Scanner in = new Scanner(f);//into one line 
     		 while(in.hasNext()){
        		String line = in.nextLine();
        		wordsToAdd.add(line);
			}     
   		 }catch(FileNotFoundException e){
      		System.out.println("File not found: " + fileName);
      		System.exit(1);
    		}
    	addAllWords();
    	
    }

    /**Set all values in the WordSearch to underscores'_'*/
    public void clear(){
    	for (int i = 0; i < data.length; i++){
    		for (int j = 0; j < data[i].length; j++){
    			data[i][j]= '_';
    		}
    	}
    }

    /**The proper formatting for a WordGrid is created in the toString.
     *@return a String with each character separated by spaces, and rows
     *separated by newlines.
     */
    public String toString(){
    	String s = "";
    	for (int i = 0; i< data.length; i++){
    		for (int j = 0; j< data[i].length; j++){
    			s+= Character.toString(data[i][j]) + " ";
    		}
    		s+= "\n";
    	}
    	return s;
    }
	
	public int getSeed(){
		return seed;
	}
	
	public String getWordsAdded(){
		String s = "";
		for (int i = 0; i<wordsAdded.size(); i++){
			s+= wordsAdded.get(i) + " ";
		}
		return s;
	}


    private boolean addWord( int r, int c, String word, int rowIncrement, int colIncrement){
    	int index = wordsToAdd.indexOf(word);
    	if (rowIncrement == 0 && colIncrement == 0){
    		return false;
    	}
    	if (colIncrement*word.length()+c<0 || colIncrement*word.length()+c>=data[r].length ||
    		rowIncrement*word.length()+r<0 || rowIncrement*word.length()+r>=data.length){
    		return false;
    		
    	}
    	for (int i = 0; i<word.length(); i++){
    		if (Character.isLetter(data[r+rowIncrement][c+colIncrement]) && data[r+rowIncrement][c+colIncrement]!=word.charAt(i)){
    			return false;
    		}
    	}
    	for (int i = 0; i<word.length(); i++){
    		data[r][c]= word.charAt(i);
    		r+= rowIncrement;
    		c+= colIncrement;
    		if(i == word.length()-1){
    			wordsAdded.add(wordsToAdd.remove(index));
    			return true;
    		}
    	}
    	return false;
    }
    
    
    private boolean addAllWords(){
    	int increment[] = {-1, 0, 1};
    	int rows = data.length;
    	int cols = data[0].length;
    	for (int i = 0; i< 100; i++){
    		if (wordsToAdd.size()==0){
    			return true;
    		}
    		int r = randgen.nextInt(rows);
    		int c = randgen.nextInt(cols);
    		String word = wordsToAdd.get(randgen.nextInt(wordsToAdd.size()));
    		int rinc = increment[randgen.nextInt(3)];
    		int cinc = increment[randgen.nextInt(3)];
    		addWord(r,c,word, rinc, cinc);
    	}
    	return false;
    }
    
    private boolean fill(){
    	String s = "abcdefghijklmnopqrstuvwxyz";
   		for (int i = 0; i< data.length; i++){
   			for (int j = 0; j<data[i].length; j++){
   				if (data[i][j]=='_'){
   					data[i][j]= s.charAt(randgen.nextInt(26));
   				}
   			}
    	}
    	return true;
    }
    
    public String puzzle(){
    	this.fill();
    	return this.toString();
    }
    
    public String answers(){
    	return this.toString();
    }
    


}
