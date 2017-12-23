package learn.concurrentAPI.forkJoinPool.demo1;

import java.util.concurrent.RecursiveAction;

public class SqrtTransform extends RecursiveAction{

    private static final int THRESHOLD = 1000;

    private double[] data;
    private int start;
    private int end;

    SqrtTransform(double[] data, int start, int end) {
        this.data = data;
        this.start = start;
        this.end = end;
    }


    @Override
    protected void compute() {
        if ((end - start) < THRESHOLD) {
            for (int i = start; i < end; i++) {
                data[i] = Math.sqrt(data[i]);
            }
        }
        else {
            int mid = (start + end)/2;

            invokeAll(new SqrtTransform(data, start, mid));
            invokeAll(new SqrtTransform(data, mid, end));
        }
    }
}
