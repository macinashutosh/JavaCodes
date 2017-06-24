package codingNinjas24;

public class Sorter  {

	public static <T extends CompareInterface<T>> void sortTheArray(T a[]){
		for(int i=0;i<a.length;++i){
			for(int j=1;j<a.length;++j){
				if(a[j-1].compare(a[j])==-1){
					T temp = a[j-1];
					a[j-1] = a[j];
					a[j] = temp;
				}
			}
		}
	}
	
	public static void main(String args[]){
		Student a[] = new Student[10];
		for(int i=0;i<a.length;++i){
			a[i] = new Student(10-i);
		}
		sortTheArray(a);
		for(int i=0;i<a.length;++i){
			System.out.println(a[i].rollNo);
		}
	}
}
