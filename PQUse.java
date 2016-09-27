package class8;

import java.io.ObjectInputStream.GetField;

public class PQUse {

	public static int removeMin(int[] heap, int lastIndex) {
		int toBeReturned = heap[1];
		heap[1] = heap[lastIndex];
		
		lastIndex--;
		int parentIndex = 1;
		while (2 * parentIndex <= lastIndex) {
			int rightIndex = 2*parentIndex + 1;
			int leftIndex = 2*parentIndex;
			
			int childIndexForSwap = leftIndex;
			if (rightIndex <= lastIndex) {
				if (heap[rightIndex] < heap[leftIndex]) {
					childIndexForSwap = rightIndex;
				}
			}
			
			if (heap[parentIndex] <= heap[childIndexForSwap]) {
				break;
			}
			
			int temp = heap[childIndexForSwap];
			heap[childIndexForSwap] = heap[parentIndex];
			heap[parentIndex] = temp;
			
			parentIndex = childIndexForSwap;
		}
		return toBeReturned;
	}
	
	// Assumes its a min heap from 1 to index - 1 
	//and its going to add element at index to the heap
	public static void addToHeap(int[] heap, int index) {
		int childIndex = index;
		int parentIndex = childIndex/2;
		
		while (childIndex != 1) {
			if (heap[childIndex] >= heap[parentIndex]) {
				break;
			}
			int temp = heap[childIndex];
			heap[childIndex] = heap[parentIndex];
			heap[parentIndex] = temp;
			
			childIndex = parentIndex;
			parentIndex = childIndex/2;
		}
	}
	
	
	public static void sortAlmostSortedArray(int [] input, int k) {
		PriorityQueue<Void> heap = new PriorityQueue<>();
		for (int i = 0; i < k; i++) {
			heap.insert(input[i], null);
		}
		int j = 0;
		for (j = k; j < input.length; j++) {
			PQPair<Void> lowest = heap.removeMin();
			input[j -k] = lowest.priority;
			heap.insert(input[j], null);
		}
		
		for (int i = j - k; i < input.length; i++) {
			PQPair<Void> lowest = heap.removeMin();
			input[i] = lowest.priority;
		}
		
	}
	
	public static void main(String[] args) {
		
//		int[] a = {4,1,5,2,3,8,6,9,7,10};
//		sortAlmostSortedArray(a, 4);
//		for (int i : a)
//			System.out.println(i);
		int[] a= {-1, 5,6,7,8,1,2,3,4,10,9};
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i: a) {
			pq.insert(i, i);
		}
//		Integer min = getMin();
		
//		
//		for (int i = 1; i < a.length; i++) {
//			addToHeap(a, i);
//		}
//		
//		for (int lastIndex = a.length - 1; lastIndex >= 1; lastIndex--) {
//			int min = removeMin(a, lastIndex);
//			a[lastIndex] = min;
//		}
//		
//		for (int lastIndex = a.length - 1; lastIndex >= 1; lastIndex--) {
//			System.out.println(a[lastIndex]);
//		}
//		
		while (!pq.isEmpty()) {
			System.out.println(pq.removeMin().priority);
		}
	}

}
