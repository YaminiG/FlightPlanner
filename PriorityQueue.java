package class8;

import java.util.ArrayList;

public class PriorityQueue<V> {
	ArrayList<PQPair<V>> tree;
	
	public PriorityQueue() {
		tree = new ArrayList<>();
		tree.add(null);
	}
	
	public int size() {
		return tree.size() - 1;
	}
	
	public boolean isEmpty() {
		if (size() == 0) {
			return true;
		}
		return false;
	}
	
	public PQPair<V> getMin() {
		if (size() == 0) {
			return null;
		}
		return tree.get(1);
	}
	
	public PQPair<V> removeMin() {
		if (size() == 0) {
			return null;
		}
		
		PQPair<V> toBeReturned = tree.get(1);
		
		int lastIndex = tree.size() - 1;
		tree.set(1, tree.get(lastIndex));
		tree.remove(lastIndex);
		
		
		int parentIndex = 1;
		while (2*parentIndex < tree.size()) {
			int rightIndex = 2*parentIndex + 1;
			int leftIndex = 2*parentIndex;
			
			int childIndexForSwapping = leftIndex;
			if (rightIndex < tree.size()) {
				if (tree.get(rightIndex).priority < tree.get(leftIndex).priority) {
					childIndexForSwapping = rightIndex;
				}
			}
			
			if (tree.get(parentIndex).priority <= tree.get(childIndexForSwapping).priority) {
				break;
			}
			
			PQPair<V> temp = tree.get(childIndexForSwapping);
			tree.set(childIndexForSwapping, tree.get(parentIndex));
			tree.set(parentIndex, temp);
			
			parentIndex = childIndexForSwapping;
			
		}
		return toBeReturned;
	}
	
	public void insert(int priority, V value) {
		PQPair<V> p = new PQPair<>();
		p.priority = priority;
		p.value= value;
		
		tree.add(p);
		
		int childIndex = tree.size() - 1;
		int parentIndex = childIndex/2;
		
		while (childIndex != 1) {
			if (tree.get(childIndex).priority 
					>= tree.get(parentIndex).priority) { 
				break;
			}
			
			PQPair<V> temp = tree.get(childIndex);
			tree.set(childIndex, tree.get(parentIndex));
			tree.set(parentIndex, temp);
			childIndex = parentIndex;
			parentIndex = childIndex/2;
		}
	}
}
