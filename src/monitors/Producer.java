package monitors;

import java.util.logging.Level;
import java.util.logging.Logger;

import objeto.QueueSpace;

public class Producer implements Runnable {
	private QueueSpace queueSpace;
	
	public Producer(QueueSpace queueSpace) {
		this.queueSpace = queueSpace;
	}
	
	private int produce(int i) throws InterruptedException {
		while(queueSpace.getCount() == queueSpace.getSIZE()) {
			synchronized(queueSpace) {
				queueSpace.wait();
			}
		}
		synchronized(queueSpace) {
			queueSpace.add(i);
			queueSpace.notifyAll();
			return i;
		}
	}

	public void run() {
		for (int i = 0; i < 7; i++) {
            try {
            	System.out.println("Produced: " + produce(i));
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }

        }	
	}
}