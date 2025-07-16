package LeetCode;

public class ContainerWithMostWater {
    public static void main(String[] args) {
//        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        int[] height = new int[]{1,1};

        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        if(height.length<2) return 0;
        int maxval =0;
        int currval=0;
        int left =0;
        int right=height.length-1;
        while (left<right){
            currval = (right-left) * Math.min(height[left],height[right]);
            maxval = Math.max(currval, maxval);
            if(height[left]<height[right]) left++;
            else right--;
        }
        return maxval;
    }
}
