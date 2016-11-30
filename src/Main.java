import monitors.Consumer;
import monitors.Producer;
import objeto.QueueSpace;


public class Main {
	public static void main(String args[]) {
		 int size = 4;
		 QueueSpace e = new QueueSpace(size);
		 Thread prodThread = new Thread(new Producer(e), "Producer");
		 Thread consThread = new Thread(new Consumer(e), "Consumer");
		 prodThread.start();
		 consThread.start();
	}
}
