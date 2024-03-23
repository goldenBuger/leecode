package leecode100;

import java.util.Arrays;
import java.util.HashMap;

public class L001两数之和 {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] ans = new int[2];
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if(map.containsKey(target - nums[i])){
                ans[0] = map.get(target - nums[i]);
                ans[1] = i;
                return ans;
            }else{
                map.put(nums[i],i);
            }
        }
        return ans;
    }
//    public int[] twoSum2(int[] nums, int target) {
//        int n = nums.length;
//        int[] ans = new int[2];
//        Arrays.sort(nums);
//        int left = 0;
//        int right = n-1;
//        while(left<right){
//            if(nums[left] + nums[right] <target){
//                left++;
//            }else if(nums[left] + nums[right] >target){
//                right--;
//            }else{
//                ans[0] = left;
//                ans[1] = right;
//                return  ans;
//            }
//        }
//        return ans;
//    }
}
