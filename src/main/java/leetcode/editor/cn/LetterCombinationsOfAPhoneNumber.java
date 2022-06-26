//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 哈希表 字符串 回溯 👍 1971 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
        String digits = "23";
        List<String> ans = solution.letterCombinations(digits);
        System.out.println(ans);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Map<Character, String> table = new HashMap<>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        public List<String> letterCombinations(String digits) {
            List<String> ans = new ArrayList<>();
            if (digits == null || digits.isEmpty()) {
                return ans;
            }
            backtrack(ans, digits, 0, new StringBuffer());
            return ans;
        }

        public void backtrack(List<String> ans, String digits, int index, StringBuffer combination) {
            if (index == digits.length()) {
                ans.add(combination.toString());
            } else {
                char ch = digits.charAt(index);
                String letters = table.get(ch);
                for (int i = 0; i < letters.length(); i++) {
                    combination.append(letters.charAt(i));
                    backtrack(ans, digits, index + 1, combination);
                    combination.deleteCharAt(index);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}