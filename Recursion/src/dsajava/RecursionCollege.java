package dsajava;

public class RecursionCollege {
	public static void main(String[] args) {
		System.out.println(sum(1, 10)); 
	}
	public static void printToN(int i,int n) {
		// base case
		if(i==n) {
			System.out.print(i + " ");
			return;
			
		}
		System.out.print(i + " ");
		printToN(i+1, n);
	}
	public static int sum(int i,int n) {
		if(i==n) return i;
		
		return i+sum(i+1,n);
	}
}
