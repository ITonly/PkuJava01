public class Solution {
    public String addBinary(String a, String b) {
        char [] s1=a.toCharArray();
        char []s2=b.toCharArray();
        // if(s1.length>=s2.length){
        //     char[] s_result=new[s1.length+1];
        // }else{
        //     char[] s_result=new[s2.length+1];
        // }
        // if(s1[0]==s2[0]==1){
        //         char carry='1';
        // }else{
        //     char carry='0';
        // }
        char[] scopy=new char[maxLength(a,b)];
        char[] sorigin=null;
        int m=s1.length;
    	int n=s2.length;
        if(s1.length>s2.length){
        	scopy=Arrays.copyOf(s2, m);
        	for(int j=n-1;j>=0;j--){
        		scopy[m-1]=s2[j];
        		m--;
        	}
        	//Arrays.fill(scopy, 0, m-1, '0');
        	for(int k=0;k<=m-1;k++){
        		scopy[k]='0';
        	}
           sorigin=s1;
        	
        }else{
        	scopy=Arrays.copyOf(s1, n);
        	for(int j=m-1;j>=0;j--){
        		scopy[n-1]=s1[j];
        		n--;
        	}
        	//Arrays.fill(scopy, 0, n-1, '0');
        	for(int k=0;k<=n-1;k++){
        		scopy[k]='0';
        	}
        	 sorigin=s2;
        }
        char[] s_result=new char[maxLength(a,b)+1];
        char carry='0';
        if(scopy[scopy.length-1]==sorigin[sorigin.length-1]&&scopy[scopy.length-1]=='1'){
                 carry='1';
                 s_result[maxLength(a,b)]='0';
        }else if(scopy[scopy.length-1]==sorigin[sorigin.length-1]&&scopy[scopy.length-1]=='0'){
        	s_result[maxLength(a,b)]='0';}
        	else{
        		s_result[maxLength(a,b)]='1';
        	}
        
             
        
                
        //char carry='0';
       
        //for(int i=1;i<maxLength(a,b);i++){
        for(int i=scopy.length-2;i>=0;i--){
            if(scopy[i]==sorigin[i]){
                //carry='1';
                s_result[i+1]=carry;
                if(scopy[i]=='1')carry='1';
                else carry='0';
            }
            else{
                if(carry=='1'){
                   s_result[i+1]='0'; 
                   carry='1';
                }
                else{
                    s_result[i+1]='1'; 
                    carry='0';
                }
                
            }
        }
       if(carry=='1'){
                   s_result[0]='1'; 
                   String str1=String.valueOf(s_result);
                   //for(int i=0;i<str1.length();i++){
                     //  System.out.println(str1);
                   //}
                   return str1;
                   
                }
       else{
                s_result[0]='0'; 
                String str2=String.valueOf(s_result,1,s_result.length-1);
                  // for(int i=1;i<str1.length();i++){
                  //     System.out.print(str2);
                 //  }
                   // carry='0';
                       return str2;
                }
        
        
        
    }
   
    public int maxLength(String a, String b){
        return a.length()>=b.length()?a.length():b.length();
    }
}