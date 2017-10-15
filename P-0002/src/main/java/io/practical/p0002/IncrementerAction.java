package io.practical.p0002;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.RecursiveAction;

public class IncrementerAction extends RecursiveAction {

	int id;
	int start;
	int count;

	// CyclicBarrier barrier ;

	// public IncrementerAction(int id, int start, int count, CyclicBarrier barrier) {
	public IncrementerAction(int id, int start, int count) {
		this.id = id;
		this.start = start;
		this.count = count;
		// this.barrier = barrier;
	}

	@Override
	protected void compute() {
		System.out.println("#" + id + " Starting from : " + start);
		for (int i = 0; i < count; i++, start++) {
			// try {
			// Thread.sleep(1);
			// } catch (InterruptedException e) {
			// e.printStackTrace();
			// }
		}
//		try {
			System.out.println("#" + id + " to : " + start);
//			barrier.await();
//		} catch (InterruptedException | BrokenBarrierException e) {
//			e.printStackTrace();
//		}
	}

}
