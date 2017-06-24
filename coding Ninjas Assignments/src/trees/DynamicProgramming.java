package trees;
import java.util.*;
public class DynamicProgramming {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sn = new  Scanner(System.in);
		String s1 = sn.nextLine();
		String s2 = sn.nextLine();
		HashMap<String,Integer> map1 = SubSequenceOfString(s1);
		HashMap<String,Integer> map2 = SubSequenceOfString(s2);
		System.out.println(map1);
		for(String a : map1.keySet()){
			System.out.println(a);
		}
		for(String a : map2.keySet()){
			System.out.println(a);
		}
	}
	public static HashMap<String,Integer> SubSequenceOfString(String input){
		HashMap<String,Integer> set = new HashMap<String,Integer>();
		set.put("",0);
		set.put(input.charAt(input.length()-1)+"",1);
		for(int i = input.length()-2;i>=0;--i){
			for(String a:set.keySet()){
				set.put(a+input.charAt(i), a.length()+1);
			}
			set.put(input.charAt(i)+"",1);
		}
		return set;
	}
}
