package dsajava;

public class LinkedList {
	public static class Node{
		int data;
		Node next;
		public Node(int data) {
			this.data= data;
			this.next=null;
		}
	}
	public static Node head;
	public static Node tail;
	public static int size;
	
	public void addFirst(int data) {
		//step-1 create a new node
		Node newNode = new Node(data);
		size++;
		if(head == null) {
			head = tail = newNode;
			return;
		}
		
		// step 2 newNode ka next purana head
		newNode.next = head;
		
        //step 3 nya head hai newNode
		head = newNode;
		
	}
	public void addLast(int data) {
		//step-1 create a new node
		Node newNode = new Node(data);
		size++;
		if(head == null) {
			head = tail = newNode;
			return;
		}
		// step 2 tail ka next bnega newNode
		tail.next = newNode;
		
		// step 3 tail bnagi newNode
		tail = newNode;
	}
	
	public void print() {
		if(head == null) {
			System.out.println("LL is empty");
			return;
		}
		Node temp = head;
		while(temp!=null) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
		System.out.println("Null");
	}
	public void add(int idx,int data) {
		if(idx ==0) {
			addFirst(data);
			return;
		}
		Node newNode = new Node(data);
		size++;
		Node temp = head;
		int i =0;
		while(i<idx-1) {
			temp = temp.next;
			i++;
		}
		// i = index-1 ; temp->prev
		newNode.next=temp.next;
		temp.next = newNode;
		
		
	}
	public int removeFirst() {
		if(size ==0) {
			System.out.println("list in empty");
			return Integer.MIN_VALUE;
		}else if(size==1) {
			int val = head.data;
			head=tail=null;
			size =0;
			return val;
		}
		
		int val = head.data;
		head = head.next;
		size--;
		return val;
	}
	
	public int removeLast() {
		if(size ==0) {
			System.out.println("list in empty");
			return Integer.MIN_VALUE;
		}else if(size==1) {
			int val = head.data;
			head=tail=null;
			size =0;
			return val;
		}
		
		Node prev = head;
		for(int i=0;i<size-2;i++) {
			prev = prev.next;
		}
		
		int val = tail.data;
		prev.next=null;
		tail=prev;
		size--; 
		return val;
	}
	
	public int itrSearch(int key) {
		Node temp = head;
		int i =0;
		while(temp != null) {
			if(temp.data == key ) {
				return i;
				
			}else {
				i++;
				temp = temp.next;
			}
			
		}
		return -1;
		
	}
	
	
	
	public int helper(Node head,int key) {
		if(head ==null) {
			return -1;
		}
		if(head.data == key) {
			return 0;
		}
		int idx = helper(head.next,key);
		if(idx==-1) {
			return -1;
		}
		
		return idx+1;
	}
	public int recSearch(int key) {
		return helper(head,key);
	}
	
	public void reverse() {
		Node prev =null;
		Node curr = tail=head;
		Node next;
		
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head = prev;
	}
	
	public void deleteNthNode(int n) {
		int sz = 0;
		Node temp = head;
		while(temp != null) {
			temp = temp.next;
			sz++;
		}
		
		if(n==sz) {
			head = head.next;
			return;
		}
		
		//sz-n
		int i=1;
		int iToFind = sz-n;
		Node prev =head;
		while(i<iToFind) {
			prev = prev.next;
			i++;
		}
		prev.next = prev.next.next;
		return;
		
		
	}
	
	
	public Node findmid(Node head) {
		Node slow =head;
		Node fast =head;
		while(fast !=null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow; // slow is my mid node 
	}
	
	
	public boolean checkPalidrone() {
		if(head==null||head.next ==null) {
			return true;
		}
		// Step - 1 find mid
		Node midNode = findmid(head);
		// step-2 reverse second half
		Node prev = null;
		Node curr = midNode;
		Node next;
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		Node right = prev;// right half ka head
		Node left = head; 
		// step-3 compare left and right half
		while(right != null) {
			if(left.data != right.data)
				return false;
			left = left.next;
			right = right.next;
		}
		return true;
		
	}
	public static boolean isCycle() {
		Node slow = head;
		Node fast = head;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow==fast) {
				return true; // cycle hai
			}
		}
		return false; //  cycle nhi hai
	}
	
	public static void removeCycle() {
		Node slow = head;
		Node fast = head;
		boolean cycle = false;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow==fast) {
					cycle = true;
					break;
			}
		}
		if(cycle == false)
			return;
		
		slow = head;
		Node prev = null;
		while(slow != fast)
			prev =fast;
			slow = slow.next;
			fast = fast.next;
			
		prev.next = null;
	}
	// mid for merge sort
	public Node getmid(Node head) {
		Node slow =head;
		Node fast =head.next;
		while(fast !=null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow; // slow is my mid node 
	}
	public Node mergeTwoLists(Node head1, Node head2) {
        Node mergedll = new Node(-1);
        Node temp = mergedll;

        while(head1 !=null && head2 != null){
            if(head1.data <= head2.data){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        while(head1 != null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while(head2 != null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return mergedll.next;
    }
	public Node mergeSort(Node head) {
		if(head==null || head.next==null) {
			return head;
		}
		// find mid
		Node mid = getmid(head);
		// left and right merge sort
		
		Node rightHead = mid.next;
		mid.next = null;
		Node newLeft = mergeSort(head);
		Node newRight = mergeSort(rightHead);
		
		// merge
		return mergeTwoLists(newLeft,newRight);
	}
	
	public  void zigzag() {
		// find mid
		Node slow = head;
		Node fast = head.next;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			
		}
		Node mid = slow;
		
		// reverse second half
		Node curr = mid.next;
		mid.next =null;
		Node prev =null;
		Node next;
		
		while(curr != null) {
			next = curr.next;
			curr.next=prev;
			prev = curr;
			curr = next;
		}
		
		// alternate merge
		Node left = head;
		Node right = prev;
		Node nextL,nextR;
		
		while(left != null && right != null) {
			nextL = left.next;
			left.next = right;
			nextR = right.next;
			right.next = nextL;
			
			left = nextL;
			right = nextR;
		}
		
	}
	
	
	
	
	public static void main(String args[]) {
		LinkedList ll = new LinkedList();
		ll.addFirst(2);
		ll.addFirst(1);
		ll.addLast(2);
		ll.addLast(1);
//		head =new Node(0);
//		ll.add(2, 9);
//		ll.mergeSort(1);
		ll.print();
//		ll.reverse();
//		ll.deleteNthNode(2);
//		ll.print();
		
//		System.out.println(ll.checkPalidrone());	
	}
}
