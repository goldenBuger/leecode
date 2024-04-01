package leecode100;

public class L011盛最多水的容器 {
    /**
     * 双指针
     * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
     * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     * 返回容器可以储存的最大水量。
     */
    //O(nlog(n))
    public int maxArea1(int[] height) {
        int n = height.length;
        if(n==2)    return 2* Math.min(height[0],height[1]);
        int max = 0;
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n ; j++) {
                int cur = Math.min(height[i],height[j]);
                if(max <cur * (j-i))
                    max = cur * (j-i);
            }
        }
        return max;
    }
    //O(n)
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n-1;
        int max = 0;
        while(right>left){
            int cur = (right - left) * Math.min(height[left],height[right]);
            if(max <cur){
                max = cur;
            }
            if(height[left] > height[right]){
                right--;
            }else{
                left++;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        L011盛最多水的容器 l = new L011盛最多水的容器();
        int[] que = new int[]{1,8,6,2,5,4,8,3,7};
        int i = l.maxArea(que);
        System.out.println(i);
    }
}
