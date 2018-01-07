public class SuperArray{
    private String[] data;
    private int size;

    public SuperArray(){
		data = new String[2000];
    }
    
    public SuperArray(int startingCapacity){
    	data = new String[startingCapacity];
    }

    public void clear(){
		for (int i= 0;i<data.length; i++){
	   	 data[i]=null;
		} 
    }

    public int size(){
		return size;
    }

    public boolean isEmpty(){
		return size==0;
    }

    public boolean add(String element){
		data[size]= element;
		size++;
		return true;
    }

    public String toString(){
		String s ="[";
		for (int i = 0; i<size-1; i++){
	  		s+= data[i] + ",";
		}
		s+= data[size-1]+"]";
		return s;
    }
    
    public String get(int index){
		return data[index];
    }
    
    public String set(int index, String element){
		if (index < 0 || index >= size()){
	  	  throw new ArrayIndexOutOfBoundsException();
		}
		String old = data[index];
		data[index]=element;
		return old;
    }

    private void resize(){
		String[] s = new String[size*2];
		for (int i = 0; i<size; i++){
			s[i] = data[i];
		}
		data=s;
   	}
   	
   	public boolean contains(String element){
		for (int i = 0; i<size; i++){
			if (data[i].equals(element)){
				return true;
			}
		}
		return false;
	}

	public int indexOf(String element){
		if (!contains(element)){
			return -1;
		}
		for (int i = 0; i<size; i++){
			if (data[i].equals(element)){
				return i;
			}
		}
		return -1;
	}

	public int lastIndexOf(String element){
		int index=0; 
		if (!contains(element)){
			return -1;
		}
		for (int i = 0; i<size; i++){
			if (data[i].equals(element)){
				index= i;
			}
		}
		return index;
	}
		

	public void add(int index, String element){
		String s="";
		if(size==0 && index==1){
			throw new IndexOutOfBoundsException();
		}else{
			for (int i = size-1; i>=index; i--){
				s=data[i];
				data[i+1]= s;
			} 
			data[index]= element;
		}
		size++;
	}
