package monitors;

import java.util.logging.Level;
import java.util.logging.Logger;

import objeto.QueueSpace;

public class Consumer implements Runnable {
	private QueueSpace queueSpace;
	
	public Consumer(QueueSpace queueSpace) {
		this.queueSpace = queueSpace;
	}
	
	private int consume() throws InterruptedException {
		while(queueSpace.getCount() == 0) {
			synchronized(queueSpace) {
				System.out.println("Queue is empty " + Thread.currentThread().getName()
                        + " is waiting , size: " + queueSpace.getCount());
				queueSpace.wait();
			}
		}
		synchronized(queueSpace) {
			int r = queueSpace.remove();
			queueSpace.notifyAll();
			return(r);
		}
	}

	public void run() {
		while (true) {
            try {
                System.out.println("Consumed: " + consume());
                Thread.sleep(50); //O consumo é mais rápido que a produção
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
            }
		}
	}
}
