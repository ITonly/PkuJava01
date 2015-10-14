
public class Solution {
	
	public boolean isPalindrome(String s) {
		if(s == null)
			return false;
		
        if(s == "")
        	return true;
        //s.toLowerCase();
        int i = 0;
        int j = s.length()-1;
        while(i<j){
        	/*if(!Character.isAlphabetic(s.charAt(i))){
        		i++;
        	}
        	if(!Character.isAlphabetic(s.charAt(j))){
        		j--;
        	}
        	if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))){
        		return false;
        	}*/
        	//if(!Character.isAlphabetic(s.charAt(i))){
        	if(!Character.isLetterOrDigit(s.charAt(i))){
        		i++;
        	}else if(!Character.isLetterOrDigit(s.charAt(j))){
        		j--;
        	}else if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))){
        		return false;
        	}else{
        		i++;
            	j--;
        	}       	
        }
        return true;
    }

	public static void main(String[] args) {
		String s = "a,b.";
		System.out.println(new Solution().isPalindrome(s));
	}

}
