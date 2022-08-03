//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。 
//
// 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。 
//
// 
//
// 示例 1: 
//
// 
//输入: num1 = "2", num2 = "3"
//输出: "6" 
//
// 示例 2: 
//
// 
//输入: num1 = "123", num2 = "456"
//输出: "56088" 
//
// 
//
// 提示： 
//
// 
// 1 <= num1.length, num2.length <= 200 
// num1 和 num2 只能由数字组成。 
// num1 和 num2 都不包含任何前导零，除了数字0本身。 
// 
//
// Related Topics 数学 字符串 模拟 👍 1001 👎 0


package leetcode.editor.cn;

public class MultiplyStrings {

    public static void main(String[] args) {
        Solution solution = new MultiplyStrings().new Solution();
        String num1 = "12";
        String num2 = "12";
        String ans = solution.multiply(num1, num2);
        System.out.println(ans);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String multiply(String num1, String num2) {
            if ("0".equals(num1) || "0".equals(num2)) {
                return "0";
            }
            String ans = "0";
            int m = num1.length(), n = num2.length();
            for (int i = n - 1; i >= 0; i--) {
                StringBuffer curr = new StringBuffer();
                int add = 0;
                for (int j = n - 1; j > i; j--) {
                    curr.append("0");
                }
                int y = num2.charAt(i) - '0';
                for (int j = m - 1; j >= 0; j--) {
                    int x = num1.charAt(j) - '0';
                    int product = x * y + add;
                    curr.append(product % 10);
                    add = product / 10;
                }
                if (add != 0) {
                    curr.append(add % 10);
                }
                ans = addString(ans, curr.reverse().toString());
            }
            return ans;
        }

        // 两个字符串相加
        // https://leetcode.cn/problems/add-strings/
        public String addString(String num1, String num2) {
            int i = num1.length() - 1;
            int j = num2.length() - 1;
            int add = 0;
            StringBuffer ans = new StringBuffer();
            while (i >= 0 || j >= 0 || add != 0) {
                int x = i >= 0 ? num1.charAt(i) - '0' : 0;
                int y = j >= 0 ? num2.charAt(j) - '0' : 0;
                int result = x + y + add;
                ans.append(result % 10);
                add = result / 10;
                i--;
                j--;
            }
            ans.reverse();
            return ans.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}