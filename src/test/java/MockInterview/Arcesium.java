package MockInterview;

import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.LinkedHashSet;

public class Arcesium {
	@Test
	public void DoubleInMatch(){
		int arr[]={1,2,4,11,10,8};
		Arrays.sort(arr);
		int num=2;
		for(int i=0;i<arr.length;i++){
			if(arr[i]==num){
				num*=2;
			}
		}
		System.out.println(num);
	}
	
	@Test
	public void uniqueSubString(){
		String s="abab";
		LinkedHashSet<Character> set=new LinkedHashSet<>();
		for(int i=0;i<s.length();i++){
			set.add(s.charAt(i));
		}
		System.out.println(s.length()-set.size());
	}
}
