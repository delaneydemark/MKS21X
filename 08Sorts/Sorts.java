import java.util.Arrays;
public class Sorts{
    
	public static String name(){                                                    
        return "10.Chen.Mohammad";                                                  
    }                                                                               
                                                                                    
    public static boolean isSorted(int[]ary){                                       
        for(int i = 0; i < ary.length - 1 ; i++){                                   
            if(ary[i] > ary[i+1]){                                                  
                return false;                                                       
            }                                                                       
        }                                                                           
        return true;                                                                
    }                                                                               
                                          

    public static void bogoSort(int[] ary){                                         
        while(!isSorted(ary)){                                                      
            for(int i = 0 ; i < ary.length; i++){                                   
                int temp = ary[i];                                                  
                int newSpot = (int)(Math.random()*ary.length);                      
                ary[i] = ary[newSpot];                                              
                ary[newSpot] = temp;                                                
            }                                                                       
        }                                                                           
    }                                                                               
                                                                                    
    private static void swap(int[]ary,int a, int b){                                
        int c =ary[a];                                                              
        ary[a] = ary[b];                                                            
        ary[b] = c;                                                                 
    }
    
    public static void insertionSort(int[] ary){
    	while(!isSorted(ary)){
    		for (int i = 1; i<ary.length; i++){
    			int current = i;
    			for (int j = i-1; j>=0; j--){
    				if(ary[j]>ary[current]){
    					swap(ary,j,current);
    					current = j;
    				}
    			}
    		}
    	}
    }
    
    public static void selectionSort(int[] ary){
    	while (!isSorted(ary)){
    		int smallest=0;
       		for (int i = 0; i<ary.length; i++){
            	for (int j=i; j< ary.length; j++){
            		if (ary[j]<ary[smallest]){
                	     smallest=j;
                	}
            	}
            	swap(ary,i, smallest);
       }
    }


}

 public static void main(String[]artie){                                         
        int[] randish = new int[15];                                                
        for(int i = 0 ; i < randish.length; i++){                                   
            randish[i] =(int)(Math.random()*100);                                   
        }                                                                           
                                                                                    
        //int a = 10, b = 20;                                                         
        //swap(a,b);                                                                  
        //System.out.println(a + " " + b );                                           
                                                                                    
        System.out.println(Arrays.toString(randish));                               
    	selectionSort(randish);                                                  
        System.out.println(Arrays.toString(randish));                               
                                                                                    
    }                                           
}
