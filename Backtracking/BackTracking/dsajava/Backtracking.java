	package dsajava;

public class Backtracking {
	public static void main(String args[]) {
		int sudoko[][] = {{0,0,8,0,0,0,0,0,0},
				{4,9,0,1,5,7,0,0,2},
				{0,0,3,0,0,4,1,9,0},
				{1,8,5,0,6,0,0,2,0},
				{0,0,0,0,2,0,0,6,0},
				{9,6,0,4,0,5,3,0,0},
				{0,3,0,0,7,2,0,0,4},
				{0,4,9,0,3,0,0,5,7},
				{8,2,7,0,0,9,0,1,3}
		};	
		if(sudokoSolver(sudoko, 0, 0)) {
			System.out.println("solution found ");
			printSudoko(sudoko);
		}else {
			System.out.println("Solution not found");
		}
	}
	public static void printSudoko(int[][] sudoku) {
	    for (int i = 0; i < 9; i++) {
	        if (i % 3 == 0 && i != 0) {
	            System.out.println("---------------------");
	        }
	        for (int j = 0; j < 9; j++) {
	            if (j % 3 == 0 && j != 0) {
	                System.out.print("| ");
	            }
	            System.out.print(sudoku[i][j] + " ");
	        }
	        System.out.println();
	    }
	}

	public static boolean sudokoSolver(int sudoko[][],int row,int col) {
		//base case
		if(row==9) return true;
		
		//recursion
		int nextRow = row,nextcol=col+1;
		if(col+1 ==9 ) {
			nextRow = row+1;
			nextcol =0;
		}
		
		if(sudoko[row][col] != 0) {
			return sudokoSolver(sudoko, nextRow, nextcol);
		}
		
		for(int digit=1;digit<=9;digit++) {
			if(isSafeSudoko(sudoko,row,col,digit)) {
				sudoko[row][col] = digit; 
				if(sudokoSolver(sudoko, nextRow, nextcol)) {
					return true;
				}
				sudoko[row][col] = 0; 
			}
		}
		return false;
	}
	public static boolean isSafeSudoko(int sudoko[][],int row,int col,int digit) {
		// Check column
		for (int i = 0; i <= 8; i++) {
		    if (sudoko[i][col] == digit) return false;
		}

		// Check row
		for (int j = 0; j <= 8; j++) {
		    if (sudoko[row][j] == digit) return false;
		}

		// Check 3x3 grid
		int sr = (row / 3) * 3;
		int sc = (col / 3) * 3;
		for (int i = sr; i < sr + 3; i++) {
		    for (int j = sc; j < sc + 3; j++) {
		        if (sudoko[i][j] == digit) return false;
		    }
		}
		return true;

	}
	
	
	public static void findPermutations(String str,String ans) {
		//base case
		if(str.length()==0) {
			System.out.println(ans);
			return;
		}
		// Recursion
		for(int i=0;i<str.length();i++) {
			char curr = str.charAt(i);
			String newstr = str.substring(0,i) + str.substring(i+1);
			findPermutations(newstr, ans+curr);
		}
		
	}
	public static void findSubsets(String s,String n,int i) {
		//base case
		if(i == s.length()) {
			if(n.length() ==0) {
				System.out.println("NULLLLLLL");
			}
			System.out.println(n);
			return;
		}
		
		findSubsets(s,n+ s.charAt(i),i+1);
		findSubsets(s,n,i+1);
		
	}
	public static void changeArr(int arr[],int i,int val) {
		if(i == arr.length) {
			printArr(arr);
			return;
		}
		arr[i] = val;
		changeArr(arr,i+1,val+1);
		arr[i]=arr[i]-2;
		
	}
	public static void printArr(int arr[]) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+ " ");
		}
		System.out.println();
	}
}
