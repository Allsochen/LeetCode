//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
// Related Topics 数组 双指针 排序 👍 4897 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
        int[] nums = new int[] {-1,0,1,2,-1,-4};
        List<List<Integer>> ans = solution.threeSum(nums);
        System.out.println(ans);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            int n = nums.length;
            Arrays.sort(nums);
            List<List<Integer>> ans = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int k = nums.length - 1;
                int target = -nums[i];
                for (int j = i + 1; j < n; j++) {
                    if (j > i + 1 && nums[j] == nums[j - 1]) {
                        continue;
                    }
                    while (j < k && nums[j] + nums[k] > target) {
                        k--;
                    }
                    if (j == k) {
                        break;
                    }
                    if (nums[k] + nums[j] == target) {
                        List<Integer> result = new ArrayList<>();
                        result.add(nums[i]);
                        result.add(nums[j]);
                        result.add(nums[k]);
                        ans.add(result);
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}