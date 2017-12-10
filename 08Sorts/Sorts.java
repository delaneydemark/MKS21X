import java.util.Arrays;
public class Sorts{
    
	public static String name(){                                                    
        return "10,Demark,Delaney";                                                  
    }                                                                               
                                                                                    
    public static boolean isSorted(int[]ary){                                       
        for(int i = 0; i < ary.length - 1 ; i++){                                   
            if(ary[i] > ary[i+1]){                                                  
                return false;                                                       
            }                                                                       
        }                                                                           
        return true;                                                                
    }                                                                               
                                          
                                                                              
                                                                                    
    private static void swap(int[]ary,int a, int b){                                
        int c =ary[a];                                                              
        ary[a] = ary[b];                                                            
        ary[b] = c;                                                                 
    }
    
    public static void insertionSort(int[] ary){
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
    
    
    public static void selectionSort(int[] ary){
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
    
    
    public static void bubbleSort(int[] ary){
    	for (int i = 0; i<ary.length; i++){
    		int swaps = 0;
    		for (int j = 0; j<ary.length-(1+i); j++){
    			if (ary[j]>ary[j+1]){
    				swap(ary,j,j+1);
    				swaps++;
    			}
    		}
    		if (swaps==0){
    			break;
    		}
    	}
    }




 public static void main(String[]artie){                                         
        int[] randish = new int[15];                                                
        for(int i = 0 ; i < randish.length; i++){                                   
            randish[i] =(int)(Math.random()*100);                                   
        }                                                                           
                                                                                                                         
                                                                                    
        System.out.println(Arrays.toString(randish));                               
    	bubbleSort(randish);                                                  
        System.out.println(Arrays.toString(randish));   
        
        int[] sorted = new int[15];
        for (int i = 0; i<sorted.length; i++){
        	sorted[i]=i;
        }                
        
        System.out.println(Arrays.toString(sorted));                               
    	bubbleSort(sorted);                                                  
        System.out.println(Arrays.toString(sorted));            
                                                                                    
    }                                           
}

