//将非负整数 num 转换为其对应的英文表示。 
//
// 
//
// 示例 1： 
//
// 
//输入：num = 123
//输出："One Hundred Twenty Three"
// 
//
// 示例 2： 
//
// 
//输入：num = 12345
//输出："Twelve Thousand Three Hundred Forty Five"
// 
//
// 示例 3： 
//
// 
//输入：num = 1234567
//输出："One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
// 
//
// 
//
// 提示： 
//
// 
// 0 <= num <= 2³¹ - 1 
// 
//
// Related Topics 递归 数学 字符串 👍 348 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
* 整数转换英文表示
* @author lzb
* @date 2025-06-15 16:50:37
  */
  public class P273_IntegerToEnglishWords{
  public static void main(String[] args) {
    Solution solution = new P273_IntegerToEnglishWords().new Solution();
  }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 定义数字对应的英文单词
    private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six",
        "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen",
        "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty",
        "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        String words = "";
        int i = 0;
        while (num > 0) {
            if (num % 1000 != 0) {
                words = helper(num % 1000) + THOUSANDS[i] + " " + words;
            }
            num /= 1000;
            i++;
        }
        return words.trim();
    }

    // 处理三位数以内的数字
    private String helper(int num) {
        if (num == 0) return "";
        if (num < 20) return LESS_THAN_20[num] + " ";
        if (num < 100) return TENS[num / 10] + " " + helper(num % 10);
        return LESS_THAN_20[num / 100] + " Hundred " + helper(num % 100);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}