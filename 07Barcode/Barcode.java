public class Barcode{

	public static void main(String[] args){
		Barcode a = new Barcode("10309");
		
		System.out.println(a.getZip());
		System.out.println(a.checkSum());
		System.out.println(a.getCode());
		
		Barcode b = new Barcode("10319");
		
		System.out.println(a.equals(b));
		
		System.out.println(a.toString());
		System.out.println(b.toString());
	}

    private String zip;
    private String[] codes={"||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::", "|:::|","|::|:","|:|::"};

    public Barcode(String z){
		zip = z;
    }
    
    public String getZip(){
    	return zip;
    }
    
    public int checkSum(){
    	int sum = 0;
    	for (int i = 0; i<zip.length(); i++){
    		sum+= Integer.parseInt(zip.substring(i,i+1));
    	}
    	return sum % 10;
    }
    
    public String getCode(){
    	String s = "|";
    	for (int i = 0; i<zip.length(); i++){
    		s+= codes[Integer.parseInt(zip.substring(i,i+1))];
    	}
    	s+= ""+ codes[this.checkSum()]+ "|";
    	return s;
    }
    
    public boolean equals(Barcode a){
    	return zip.equals(a.getZip());
    }
    
    public String toString(){
    	return getZip() + "   " +getCode();
    }

}
