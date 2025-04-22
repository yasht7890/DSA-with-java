package Arrays;
import java.util.ArrayList;

public class ArrayLists {
	public static void main(String args[]) {
		
		// multidimensional array lists 
		ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
		ArrayList<Integer> list1 = new ArrayList<>();
		ArrayList<Integer> list2= new ArrayList<>();
		ArrayList<Integer> list3 = new ArrayList<>();

		for(int i =1;i<=5;i++) {
			list1.add(i*1);
			list2.add(i*2);
			list3.add(i*3);
		}
		mainList.add(list1);
		mainList.add(list2);
		mainList.add(list3);
		System.out.println(mainList);
		
		
//		ArrayList<Integer> list = new ArrayList<>();
//		ArrayList<String>  list2 = new ArrayList<>();
//		ArrayList<Boolean> list3 = new ArrayList<>();
//		
//		list.add(1); //O(1)
//		list.add(2);
//		list.add(3);
//		list.add(4);
//		list.add(5);
//		
//		
//		list.add(1,9);// O(n)
//		System.out.println(list);
//	
//	
//		// get operation  - O(1)
//		int element = list.get(2);
//		System.out.println(element);
//		
//		//remove operation - O(n)
//		
//		list.remove(2);
//		System.out.println(list);
//		
//		// set element at index O(n)
//		list.set(2, 10);
//		System.out.println(list);	
//		
//		// contains O(n)
//		System.out.println(list.contains(13));
		
		
	}
}
