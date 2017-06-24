package codingNinjas10;

public class DynamicArrayUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DynamicArray arr = new DynamicArray();
		for(int i=0;i<40;++i)
			arr.add(i+10);
		while(!arr.isEmpty())
			System.out.println(arr.removeAtLast());
		
	}

}
