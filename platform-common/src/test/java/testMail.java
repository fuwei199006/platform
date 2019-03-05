import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class testMail {
	volatile boolean isStart=true;
	@Test
	public void testMailExcel() throws Exception {
		
		ExecutorService executor =  Executors.newFixedThreadPool(10);
		Thread th=new Thread(()->{
			while (isStart) {
				executor.execute(()->{
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				});
				
			}
		});
		th.start();
		Thread.sleep(10000);
		isStart=false;
		
		Thread.currentThread().join();
		
	}
}
