public class Barcode implements Comparable<Barcode>{

	public static void main(String[] args){
		Barcode a = new Barcode("10309");
		
		System.out.println(a.getZip());
		System.out.println(Barcode.checkSum(a.getZip()));
		System.out.println(Barcode.toCode(a.getZip()));
		System.out.println(a.getCode());
		
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
    	if(code.length()!=32 || code.charAt(0)=='|' && code.charAt(31)=='|'){
    		throw new IllegalArgumentException();
    	}
    	code = code.substring(1,code.length()-1);
    	for (int i = 1; i<code.length(); i++){
    		String current = 
    	}
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
