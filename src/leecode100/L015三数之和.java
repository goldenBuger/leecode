package leecode100;

import 数据结构.ListNode;

import javax.jnlp.ClipboardService;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 双指针 + 去重 问题
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 * 你返回所有和为 0 且不重复的三元组。
 */
public class L015三数之和 {
    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        // 找出a + b + c = 0
        // a = nums[i], b = nums[left], c = nums[right]
        for (int i = 0; i < nums.length; i++) {
            // 排序之后如果第一个元素已经大于零，那么无论如何组合都不可能凑成三元组，直接返回结果就可以了
            if (nums[i] > 0) {
                return result;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {  // 去重a
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while (right > left) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 去重逻辑应该放在找到一个三元组之后，对b 和 c去重
                    right--;
                    left++;
                    while (right > left && nums[right] == nums[right + 1]) right--;
                    while (right > left && nums[left] == nums[left - 1]) left++;

                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        L015三数之和 l = new L015三数之和();
        int[] nums = new int[]{-3,-3,-1,6};
        List<List<Integer>> lists = l.threeSum1(nums);
        System.out.println(lists);
    }
}
