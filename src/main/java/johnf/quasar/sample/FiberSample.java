package johnf.quasar.sample;

import java.util.concurrent.ExecutionException;

import co.paralleluniverse.fibers.Fiber;
import co.paralleluniverse.fibers.SuspendExecution;

public class FiberSample {

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		Fiber<Void> a = new Fiber<Void>() {
			@Override
			protected Void run() throws InterruptedException, SuspendExecution {
				for (int i = 0; i < 10; i++) {
					System.out.print("a");
					sleep(1000L);
				}
				return null;
			}
		}.start();

		Fiber<Void> b = new Fiber<Void>() {
			@Override
			protected Void run() throws InterruptedException, SuspendExecution {
				for (int i = 0; i < 10; i++) {
					System.out.print("b");
					sleep(1000L);
				}
				return null;
			}
		}.start();
		a.join();
		b.join();
	}
}
