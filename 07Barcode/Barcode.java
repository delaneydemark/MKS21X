public class Barcode implements Comparable<Barcode>{

	public static void main(String[] args){
		Barcode a = new Barcode("10309");
		
		System.out.println(a.getZip());
		System.out.println(Barcode.checkSum(a.getZip()));
		System.out.println(Barcode.toCode(a.getZip()));
		System.out.println(a.getCode().length());
		System.out.println(Barcode.toZip(a.getCode()));
		
		Barcode b = new Barcode("10319");
		
		System.out.println(a.equals(b));
		
		System.out.println(a.toString());
		System.out.println(b.toString());
	}

    private String zip;
   
    public Barcode(String z){
    	if (z.length()!=5){
    		throw new IllegalArgumentException();
    	}
		zip = z;
    }
    
    public String getZip(){
    	return zip;
    }
    
    public static String toZip(String code){
    	String[] codes={"||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::", "|:::|","|::|:","|:|::"};
    	if(code.length()!=32) {
    		throw new IllegalArgumentException();
    	}
    	if (!(code.charAt(0)=='|') && !(code.charAt(code.length()-1)=='|')){
    		throw new IllegalArgumentException();
    	}
    	code = code.substring(1,code.length()-1);
		int i = 0;
		int counter = 0;
		String zip="";
    	while (i<code.length()){
	    	String current = code.substring(i,i+5);
	    	for (int j = 0; j<codes.length; j++){
	    		if (codes[j].equals(current)){
	    			zip+=j;
	    		}
	    		else{
	    			counter++;
	    		}
	    	}
	    	if (counter==10){
	    		throw new IllegalArgumentException();
	    	}
	    	counter=0;
	    	i+=5;	
    	}
    	int check = checkSum(zip.substring(0,5));
    	int end = Integer.parseInt(zip.substring(5,6));
    	if(!(end==check)){
    		throw new IllegalArgumentException();
    	}
    	return zip.substring(0,5);
    }
    
    public static int checkSum(String zip){
    	int sum = 0;
    	for (int i = 0; i<zip.length(); i++){
    		sum+= Integer.parseInt(zip.substring(i,i+1));
    	}
    	return sum % 10;
    }
    
    public String getCode(){
    	return toCode(this.getZip());
    }
    
    public static String toCode(String zip){
    	String[] codes={"||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::", "|:::|","|::|:","|:|::"};
    	String s = "|";
    	for (int i = 0; i<zip.length(); i++){
    		s+= codes[Integer.parseInt(zip.substring(i,i+1))];
    	}
    	s+= ""+ codes[Barcode.checkSum(zip)]+ "|";
    	return s;
    }
    
    public boolean equals(Barcode a){
    	return zip.equals(a.getZip());
    }
    
    public int compareTo(Barcode other){
    	String a = this.getZip();
    	return a.compareTo(other.getZip());
    }
    
    public String toString(){
    	return getCode()+ "\n("+ getZip()+")"  ;
    }

}
