package Arrays;
import java.util.Arrays;

public class ArraysCC {
	public static void main(String[] args) {
		int marks[] = {2,-1,1,1};
		int key = 59;
		System.out.println(maxProduct(marks)); 
		
	}
	public static int maxProduct(int[] arr) {
        int n = arr.length;
        int maxProduct = 0;
        for(int i=0;i<n;i++){
            int currProduct = arr[i];
            maxProduct = Math.max(currProduct,maxProduct);
            for(int j=i+1;j<n;j++){
                currProduct = currProduct*arr[j];
                maxProduct = Math.max(currProduct,maxProduct);
            }
            
        }
        if(maxProduct == 0){
            int max = Integer.MIN_VALUE;
            for(int i=0;i<n;i++){
                if(arr[i]>max){
                    max =arr[i];
                }
            }
            return max;
        }
        return maxProduct;
    }

	
	
	
	//pair sum equals target in sorted and rotated array
	public static boolean pairSumSortedAndRotated(int arr[],int target) {
		int n = arr.length;
		int bp =-1;
		for(int i=0;i<n;i++) {
			if(arr[i]>arr[i+1]) {
				bp=i;
				break;
			}
		}
		int rp=bp;
		int lp=bp+1;
		while(lp!=rp) {
			if(arr[lp] + arr[rp] == target) {
				return true;
			}
			
			if(arr[lp] + arr[rp] < target) {
				lp = (lp+1)%n;
			}else {
				rp =(n+rp-1)%n;
			}
		}
		
		return false;
	}
	
	
	
	// pair sum equals target in sorted array
	public static boolean pairSumOne(int arr[],int target) {
		int lp = 0;
		int rp = arr.length-1;
		while(lp!=rp) {
			if(arr[lp] + arr[rp] == target) {
				return true;
			}
			
			if(arr[lp] + arr[rp] < target) {
				lp++;
			}else {
				rp--;
			}
		}
		
		return false;
	}
	
	
	//trapping rain water
	public static int trappingRainWater(int height[]) {
		// calculate left max boundary array
		int n = height.length;
		
		int leftMax[] = new int[n];
		leftMax[0] = height[0];
		for(int i =1;i<n;i++) {
			leftMax[i] = Math.max(height[i], leftMax[i-1]);
		}
		//calculate right max array
		int rightMax[] = new int[n];
		rightMax[n-1] = height[n-1];
		for(int i =n-2;i>=0;i--) {
			rightMax[i] = Math.max(height[i], rightMax[i+1]);
		}
		int trappedWater = 0;
		for(int i =0;i<n;i++) {
			int waterLevel = Math.min(leftMax[i], rightMax[i]);
			trappedWater += waterLevel - height[i];
		}
		return trappedWater;
	}
	
	
	
	
	// max sum of sub array kadanes
	
	public static void kadanes(int arr[]) {
		int ms = Integer.MIN_VALUE;
		int cs = 0;
		
		for(int i =0;i<arr.length;i++) {
			cs = cs + arr[i];
			if(cs<0) 
				cs =0;
			ms = Math.max(cs, ms);
		}
		if(ms==0) {
			ms = Arrays.stream(arr).max().getAsInt();
		}
		System.out.println(ms);
	}
	
	
	
	//print sub arrays
	public static void pairsOfArray(int arr[]) {
		for(int i=0;i<arr.length;i++) {
			for(int j=i;j<arr.length;j++) {
				for(int k =i;k<j;k++) {
					System.out.print(arr[k]+" ");
				}
				System.out.println();
			}
//			System.out.println();
			
		}
	}
	
	
	//pairs in array
	
	public static void pairsInArray(int arr[]) {
		for(int i=0;i<arr.length;i++) {
			int curr =arr[i];
			for(int j = i+1;j<arr.length;j++) {
				System.out.print("(" + curr + "," + arr[j]+")");
			}
			System.out.println();
		}
	}
	
	
	
	//reverse an array
	public static void reverseArray(int arr[]) {
		int end = arr.length-1;
		for(int i=0; i<arr.length/2;i++) {
			int temp = arr[i];
			arr[i] = arr[end];
			arr[end] = temp;
			end--;
		}
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	
	//binary search program array must be sorted
	public static int binarySearch(int arr[],int key) {
		int start =0;
		int end = arr.length -1;
		int mid = (start+end)/2;
		
		while(start<=end) {
			if(key>arr[mid]) {
				start = mid+1;
				mid = (start+end)/2;
			}else if(key==arr[mid]) {
				return mid;
			}else {
				end = mid-1;
				mid = (start+end)/2;
			}
		}
		
		return -1;
	}
	
	
	
	public static int largestNumber(int arr[]) {
		int largest = Integer.MIN_VALUE;
		for(int i =0;i<arr.length;i++) {
			if(arr[i]>largest) {
				largest = arr[i];
			}
			
		}
		return largest;
	}
	public static int smallestNumber(int arr[]) {
		int smallest = Integer.MAX_VALUE;
		for(int i =0;i<arr.length;i++) {
			if(arr[i] <smallest) {
			  smallest = arr[i];
			}
			
		}
		return smallest;
	}
	public  static int linearSearch(int arr[],int key) {
		for(int i =0;i<arr.length;i++) {
			if(arr[i]==key) {
				return i;
			}
		}
		return -1;  
	}
	
	public static void update(int marks[]) {
		for(int i=0;i<marks.length;i++) {
			marks[i] = marks[i] +1;
		}
	}
}
