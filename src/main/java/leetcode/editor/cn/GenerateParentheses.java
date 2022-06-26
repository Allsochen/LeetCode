//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 动态规划 回溯 👍 2721 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
        int n = 3;
        List<String> ans = solution.generateParenthesis(3);
        System.out.println(ans);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList<>();
            if (n <= 0) {
                return result;
            }
            backtrack(result, n, 0, 0, new StringBuffer());
            return result;
        }

        public void backtrack(List<String> result, int max, int open, int close, StringBuffer buffer) {
            if (buffer.length() == max * 2) {
                result.add(buffer.toString());
            }
            if (open < max) {
                buffer.append('(');
                backtrack(result, max, open + 1, close, buffer);
                buffer.deleteCharAt(buffer.length() - 1);
            }
            if (close < open) {
                buffer.append(')');
                backtrack(result, max, open, close + 1, buffer);
                buffer.deleteCharAt(buffer.length() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}