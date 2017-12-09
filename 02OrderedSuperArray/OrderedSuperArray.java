public class OrderedSuperArray extends SuperArray{

  public OrderedSuperArray(){
      super();
  }

  public OrderedSuperArray(int capacity){
	super(capacity);
  }
  
  public OrderedSuperArray(String[] ary){
  	super(ary.length);
  	for (int i = 0; i<ary.length; i++){
  		add(ary[i]);
  	}
  }
  
  public void add(int index, String value){
    add(value);
  }

  public boolean add(String value){
      int index=findIndexBinary(value);
      super.add(index,value);
      return true;
  }
  private int findIndex(String value){
      int index=0;
      if (size()==0 || value.compareTo(get(0))<0){
      	index= 0;
      	}
      else if (value.compareTo(get(size()-1))>0){
      	index= size();
      }
      for (int i = 0; i<size(); i++){
      	if (size()<2 && value.compareTo(get(i))>0){
      		index=i+1;
      	}
      	else if (value.compareTo(get(i))==0){
      		index = i;
      	}
	  	else if (value.compareTo(get(i))>0 && value.compareTo(get(i+1))<0){
	      index=i+1;
	  	}
      }	
      return index;
  }
  public String set(int index, String element){
      throw new UnsupportedOperationException();
  }

  public int indexOfBinary(String element){
      boolean done = false;
      int start = 0;
      int end = size()-1;
      int current;
      int index = 0;
      if (!contains(element)){
	      return -1;
	  }
      while (!done){
	  	current = (start + end)/2;
	  	if (element.equals(get(start))){
	    	  index = start;
	    	  done = true;
	  	}
	 	 else if (element.equals(get(end))){
	     	 index = end;
	     	 done = true;
	    }
	  	else if (element.equals(get(current))){
	      	index = current;
	     	done = true;
	  	}
	  	else if (element.compareTo(get(current))>0){
	      	start = current +1;
	  	}
	  	else if (element.compareTo(get(current))<0){
	      	end = current-1;
	  	}
	  
      }
      return index;
  }
  public int lastIndexOfBinary(String element){
  	int index=0; 
  	boolean done = false;
    int start = 0;
    int end = size()-1;
    int current;
    boolean last = false;
	if (!contains(element)){
		return -1;
	}
	while (!done){
	  	current = (start + end)/2;
	  	if (element.equals(get(start))){
	    	  index = start;
	    	  done = true;
	  	}
	 	 else if (element.equals(get(end))){
	     	 index = end;
	     	 done = true;
	    }
	  	else if (element.equals(get(current))){
	      	index = current;
	     	done = true;
	  	}
	  	else if (element.compareTo(get(current))>0){
	      	start = current +1;
	  	}
	  	else if (element.compareTo(get(current))<0){
	      	end = current-1;
	  	}
	  
      }
    while (!last){
    	if (get(index).equals(get(index+1))){
    		index++;
    	}
    	else{
    		last = true;
    	}
    }
    return index;
  }
  
  private int findIndexBinary(String value){
  	int index = 0;
  	boolean done = false;
    int start = 0;
    int end = size()-1;
    int current;
  	if (size()==0 || value.compareTo(get(0))<0){
      	index= 0;
      	done = true;
    }
    else if (size()==1 && value.compareTo(get(0))>0){
    	index = size();
    	done = true;
    }
    else if (value.compareTo(get(size()-1))>0){
      	index= size();
      	done = true;
    }
    while (!done){
    	current = (start + end)/2 ;
    	if(current==0){
    		index = start;
    		done = true;
    	}
    	else if (value.compareTo(get(current))<0){
    		end = current-1;
    	}
    	else if (value.compareTo(get(current))>0){
    		start = current+1;
    	}
    	else if (value.compareTo(get(current))==0){
    		index = current;
    		done = true;
    	}
    	if (size()>1 && value.compareTo(get(current))>0 && value.compareTo(get(current+1))<0){
    		index = current+1;
    		done = true;
    	}
    }
    return index;
  }


}

