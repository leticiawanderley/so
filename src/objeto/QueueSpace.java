package objeto;

import java.util.ArrayList;

public class QueueSpace {
	private int SIZE;
	private ArrayList<Integer> q;
	
	public QueueSpace(int sizeQueue) {
		this.SIZE = sizeQueue;
		this.q = new ArrayList<Integer>();
	}
	
	public int getCount() {
		return this.q.size();
	}
	
	public int add(int i) {
		q.add(i);
		return i;
	}
	
	public int remove() {
		return q.remove(getCount() - 1)	;
	}

	public int getSIZE() {
		return SIZE;
	}
}