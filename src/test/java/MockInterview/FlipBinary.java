package MockInterview;

public class FlipBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long n=1l;
		String bit=Long.toBinaryString(n);
		System.out.println(bit);
	       String zero="";
	       for(int i=0;i<32-bit.length();i++){
	           zero+="0";
	       }
	       String binary=zero+bit;
	       System.out.println(binary);
	       char[] ch=binary.toCharArray();
	       
	       for(int i=0;i<ch.length;i++){
	           if(48-ch[i]==0){
	                ch[i]=1; 
	           }else{
	               ch[i]=0;
	           } 
	           System.out.print(ch[i]);
	       }
	       
	       System.out.println();
	       long value=0l;
	       int it=0;
           for(int j=ch.length-1;j>=0;j--){
        	   int i=it;
        	   long pow=1l;
        	   while(i>0){
                   pow=pow*2;
                   i--;
               }
        	   //System.out.println(pow);
               value=value+ch[j]*pow;
               it++;
               System.out.println(value);
           }
           
	              
	}

}
