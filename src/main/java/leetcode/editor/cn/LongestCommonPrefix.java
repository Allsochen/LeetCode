//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
// Related Topics 字符串 👍 2308 👎 0


package leetcode.editor.cn;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) {
                return "";
            }
            String prefix = strs[0];
            for (int i = 1; i < strs.length; i++) {
                prefix = computePrefix(prefix, strs[i]);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
            return prefix;
        }

        public String computePrefix(String str1, String str2) {
            int len = Math.min(str1.length(), str2.length());
            int i = 0;
            while (i < len && str1.charAt(i) == str2.charAt(i)) {
                i++;
            }
            return str1.substring(0, i);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}