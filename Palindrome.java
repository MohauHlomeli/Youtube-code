
public class Palindrome {
	
	
	static boolean finalresults = false;
	

		
	    public static boolean isPalindrome(String word) {
	      
	    	char[]result = new char[word.length()];
	    	char[]reverse = new char[word.length()];
	    	
	 
	    	for(int  i=0;i<word.length();i++){ // i = i +1;
	    		result[i] = Character.toLowerCase(word.charAt(i));
	    		reverse[i]= Character.toLowerCase(word.charAt((word.length() - 1) - i));
	    		
	    		if(result[i] == reverse[i]){
	    			finalresults = true;
	    		}else{
	    			finalresults = false;
	    		}
	    		
	    	}
	    	
	    	
	    	return finalresults;
	    
	    }
	    
	   
	    
	    public static void main(String[] args) {
	        System.out.println(Palindrome.isPalindrome("Rotator"));
	    }

}
