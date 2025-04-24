package dsajava;

public class ArrayRecursion {
	public static void main(String args[]) {
		int arr[] = {1,2,3,4,57,6,2};
		String str = "appnnacollege";
		removeDuplicates(str, 0, new StringBuilder(""), new boolean[26]);
//		System.out.println(tilingProblem(10));
	}
	static void removeDuplicates(String str,int idx,StringBuilder newStr,boolean[] map) {
		if(idx == str.length()) {
			System.out.println(newStr);
			return;
		}
		char currChar = str.charAt(idx);
		if(map[currChar -'a'] == true) {
			removeDuplicates(str, idx+1, newStr, map);
		}else {
			map[currChar -'a'] = true;
			removeDuplicates(str, idx+1, newStr.append(currChar), map);
		}
		
	}
	
	
	
	static int tilingProblem(int n) {
		//base case
		if(n==1 || n==0) {
			return 1;
			
		}
		//vertical choice 
		int fnm1 = tilingProblem(n-1);
		
		// horizontal choice
		int fnm2 = tilingProblem(n-2);
		
		int totalways= fnm1 + fnm2;
		return totalways;
	}
	
	static int power(int x,int n) {
		if(n==0) {
			return 1;
		}
		return x * power(x,n-1);
	}
	
	static int firstOccurence(int arr[],int key,int i) {
		if(i==arr.length) {
			return -1;
		}
		if(arr[i]==key) {
			return i;
		}
		
		return firstOccurence(arr, key, i+1);
		
	}
	static int lastOccurence(int arr[],int key,int i) {
		if(i==arr.length) {
			return -1;
		}
		int isFound = lastOccurence(arr, key, i+1);
		if(isFound==-1 && arr[i]==key) {
			return i;
		}
		return isFound;
		
	}
	
	
	
	
	static boolean isSorted(int arr[]) {
		return helper(arr,0);
	}
	static boolean helper(int arr[],int index) {
		if(index==arr.length-1) return true;
		
		return arr[index]<arr[index+1] && helper(arr,index+1);
	}
	static boolean linerSearch(int arr[],int target,int index) {
		if(index==arr.length-1) return arr[arr.length-1] == target;
		return arr[index] ==target || linerSearch(arr,target,index+1);
		
	}
}
