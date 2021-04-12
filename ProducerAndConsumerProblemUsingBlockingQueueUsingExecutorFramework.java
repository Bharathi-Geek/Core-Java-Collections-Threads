
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BlockingQueueUsingProducerAndConsumerExampleUsingExecutorFramework {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//size of the blocking queue is 10
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);
		
		ExecutorService producer = Executors.newSingleThreadExecutor();
		ExecutorService consumer = Executors.newSingleThreadExecutor();
		producer.execute(new Producer(queue));
		consumer.execute(new Consumer(queue));

	}

}
class Producer implements Runnable{

	BlockingQueue<Integer> queue=null;
	int capability=10;
	int i=1;
	
	public Producer(BlockingQueue<Integer> queue) {
		super();
		this.queue = queue;
	}

	
	@Override
	public void run() {
		//System.out.println("hello");
		System.out.println(Thread.currentThread().getName());
		//System.out.println(queue.size());
		
		while(queue.isEmpty() || queue.size() < capability) {
			try {
				queue.put(i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			i++;
			if((Thread.currentThread().getName() != "pool-1-thread-1")) {
				//System.out.println("pool2-consumer");
				System.out.println(Thread.currentThread().getName());
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}
			}//end while
		if(queue.size() == capability) {
				System.out.println("queue is full ,stop the producer");
			}
		
	}
}
	
class Consumer implements Runnable{

	BlockingQueue<Integer> queue1=null;
	int capability=10;
	
	public Consumer(BlockingQueue<Integer> queue) {
		super();
		this.queue1 = queue;
	}

	@Override
	public void run() {
		//System.out.println("consumer"+queue1.size());
		//System.out.println(Thread.currentThread().getName());

			while((!queue1.isEmpty())) {
				try {
					queue1.take();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName());
				if(Thread.currentThread().getName() != "pool-2-thread-1") {
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				
			}
			if(queue1.isEmpty()) {
				System.out.println("queue is empty ,stop the consumer");
			}
		}
	}
	