package MockInterview;

public class Pangram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="We promptly judged antique ivory buckles for the next prize";
		String str=s.toLowerCase();
        boolean flag=true;
        for(char i='a';i<='z';i++){
            if(!str.contains(String.valueOf(i))){
            	flag=false;
            	break;
            	}
        }
        if(flag==true){
            System.out.println("pangram");
        }else{
           System.out.println("not pangram");
        }
	}

}
