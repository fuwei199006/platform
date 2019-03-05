import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadTest {
	
	public static void main(String[] args) {
		TestObj testObj=new TestObj();
		for(int i=0;i<10;i++){
			testObj.testThread();
			ThreadGroup currentGroup = Thread.currentThread().getThreadGroup();
			int noThreads = currentGroup.activeCount();
			System.out.println(noThreads);
		}
		try {
			while (true){
				ThreadGroup currentGroup = Thread.currentThread().getThreadGroup();
				int noThreads = currentGroup.activeCount();
				System.out.println(noThreads);
				Thread.sleep(1000);
			}
 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	
}

  class  TestObj{
	public void testThread(){
		Executor executor= Executors.newFixedThreadPool(10);
		AtomicInteger index= new AtomicInteger(10);
		Thread thread=new Thread(()->{
			while (index.getAndIncrement() <10){
				try {
					
					executor.execute(()->{
						try {
							Thread.sleep(3000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					});
				} catch ( Exception e) {
					e.printStackTrace();
				}
			}
		});
		thread.start();
	}
}




