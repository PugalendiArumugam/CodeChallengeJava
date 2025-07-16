package DSA;

public class CalculateTimeAlgo {
    public static void main(String[] args) throws InterruptedException {

        long start = System.nanoTime();

        Thread.sleep(3000);

        long elapsedTime = (System.nanoTime() - start) / 1000000;

        System.out.println(elapsedTime+" ms");

    }
}
