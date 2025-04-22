package Arrays;
import java.util.*;

public class ArraysPract {
	
	void insertAt(int arr[], int n, int p) {
	    for (int i = arr.length - 1; i > p; i--) {
	        arr[i] = arr[i - 1];
	    }
	    arr[p] = n;
	}
	static int[] merge(int arr[],int nums[]) {
		int n=arr.length;
		int m=nums.length;
		
		int temp[] = new int[n+m];
		int i =0;
		int j=0;
		int k =0;
		while(i<n && j<m) {
			if(arr[i] <= nums[j])
				temp[k++] = arr[i++];
			else
				temp[k++] = nums[j++];
		}
		while(i<n)
			temp[k++] = arr[i++];
		
		while(j<m)
			temp[k++] = arr[j++];
		
		return temp;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,3,5,7};
		int nums[] = {2,4,6};
		
		int temp[] = merge(arr,nums);
		for(int num:temp) {
			System.out.print(num + " ");
		}
		System.out.println();
		
		
	}

}
