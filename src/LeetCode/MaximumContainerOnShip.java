package LeetCode;

public class MaximumContainerOnShip {
    public static void main(String[] args) {
        int n = 2;
        int w = 3;
        int maxw=15;
        System.out.println(maxContainers(n,w,maxw));
    }

    public static int maxContainers(int n, int w, int maxWeight) {
        if(n==0||w==0||maxWeight==0) return 0;
        int capacity = (n*n)*w;
        if (capacity<=maxWeight) {
            return n*n;
        } else {
            return maxWeight/w;
        }
    }
}
