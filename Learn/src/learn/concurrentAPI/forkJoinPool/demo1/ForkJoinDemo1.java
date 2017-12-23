package learn.concurrentAPI.forkJoinPool.demo1;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinDemo1 {
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        double[] data = new double[10000];

        for (int i = 0; i < data.length; i++) {
            data[i] = i + 1;
        }

        SqrtTransform sqrtTransform = new SqrtTransform(data, 0, data.length);

        forkJoinPool.invoke(sqrtTransform);

        for (double aData : data) {
            System.out.println(aData + " ");
        }

    }
}
