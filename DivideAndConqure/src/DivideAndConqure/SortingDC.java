package DivideAndConqure;



public class SortingDC {
	public static void main(String args[]) {
		int arr[] = {4,5,6,7,0,1,2};
		int target=0;
		int ans = search(arr,target,0,arr.length-1);
		System.out.println(ans);
		
	}
	public static int search(int arr[],int tar,int si,int ei) {
		if(si>ei){
			return -1;
		}
		int mid = si + (ei-si)/2;
		 if(arr[mid] == tar) {
			 return mid;
		 }
		 // for line 1 
		 if(arr[si]<=arr[mid]) {
			 if(arr[si] <= tar && tar <= arr[mid]) {
				 return search(arr,tar,si,mid-1);
			 }else 
				 return search(arr,tar,mid+1,ei);
		 }
		 
		 
		 // for line 2
		 else {
			 if(arr[mid] <= tar && tar<=arr[ei])
				 return search(arr,tar,mid+1,ei);
			 else
				 return search(arr,tar,si,mid-1);
		 }
		 
	}
	
	
	
	
	
	// quick sort
	public static void quickSort(int arr[],int si,int ei) {
		if(si>=ei) {
			return;
		}
		
		int pIdx = partition(arr,si,ei);
		quickSort(arr,si,pIdx-1);
		quickSort(arr,pIdx+1,ei);
	}
	
	public static int partition(int arr[],int si, int ei) {
		int pivot = arr[ei];
		int i = si-1;
		
		for(int j=si;j<ei;j++) {
			if(arr[j]<=pivot) {
				i++;
				int temp = arr[j];
				arr[j]=arr[i];
				arr[i]=temp;
			}
		}
		i++;
		int temp = arr[ei];
		arr[ei]=arr[i]; //pivot = arr[i]
		arr[i]=temp;
		return i;
	}
	
	///////////////////////////////////////
	////////////////////////////////////////
	////////////////////////////////////////
	/////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////
	public static void mergeSort(int arr[],int si,int ei) {
		//base
		if(si>=ei) {
			return;
		}
		//kaam
		int mid = si + (ei-si)/2;
		mergeSort(arr,si,mid);
		mergeSort(arr,mid+1,ei);
		merge(arr,si,mid,ei);
	}
	
	public static void merge(int arr[],int si,int mid,int ei) {
		int temp[] = new int[ei-si+1];
		int i = si;
		int j = mid+1;
		int k =0;
		while(i <= mid && j <= ei) {
			if(arr[i]<arr[j]) {
				temp[k] = arr[i];
				i++;
			}else {
				temp[k]=arr[j];
				j++;
			}
			k++;
		}
		//left part
		while(i<=mid) {
			temp[k++] = arr[i++];
		}
		
		//right part
		while(j<=ei) {
			temp[k++] = arr[j++];
		}
		
		//copy temp to arr
		for(k=0,i=si;k<temp.length;k++,i++) {
			arr[i] = temp[k];
		}
	}
	
	
	
	public static void printArr(int arr[]) {
		for(int i =0;i<arr.length;i++) {
			System.out.print(arr[i]+ " ");
		}
		System.out.println();
	}
	
	
}

