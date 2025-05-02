import java.util.*;

public class CarQueue {

		private Queue<Integer> queue;
		private Random random;

		public CarQueue() {
			queue = new LinkedList<>();
			random = new Random();
		
			for (int i = 0; i < 6; i++) {
				queue.add(random.nextInt(4));
			}
		}
	public void addToQueue () {
		class MyRunnable implements Runnable {
			public void run() {
				try {
					queue.add(random.nextInt(4));
					Thread.sleep(200);					
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}
		}
		Runnable r = new MyRunnable();
		Thread t = new Thread(r);
		t.start();
	}
	
	public int deleteQueue() {
		return queue.remove();
	}
}
