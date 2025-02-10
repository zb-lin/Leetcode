//给你一个字符串 s ，请你反转字符串中 单词 的顺序。 
//
// 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。 
//
// 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。 
//
// 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "the sky is blue"
//输出："blue is sky the"
// 
//
// 示例 2： 
//
// 
//输入：s = "  hello world  "
//输出："world hello"
//解释：反转后的字符串中不能存在前导空格和尾随空格。
// 
//
// 示例 3： 
//
// 
//输入：s = "a good   example"
//输出："example good a"
//解释：如果两个单词间有多余的空格，反转后的字符串需要将单词间的空格减少到仅有一个。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 包含英文大小写字母、数字和空格 ' ' 
// s 中 至少存在一个 单词 
// 
//
// 
// 
//
// 
//
// 进阶：如果字符串在你使用的编程语言中是一种可变数据类型，请尝试使用 O(1) 额外空间复杂度的 原地 解法。 
//
// Related Topics 双指针 字符串 👍 1163 👎 0


package leetcode.editor.cn;

/**
 * 反转字符串中的单词
 *
 * @author lzb
 * @date 2024-06-21 18:22:56
 */
public class P151_ReverseWordsInAString {
    public static void main(String[] args) {
        Solution solution = new P151_ReverseWordsInAString().new Solution();
        solution.reverseWords("the sky is blue");
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String reverseWords(String s) {
            StringBuilder sb = new StringBuilder(s).reverse();
            StringBuilder result = new StringBuilder();
            int right = 0, left = 0;
            while (right < sb.length()) {
                while (right < sb.length() && sb.charAt(right) == ' ') {
                    right++;
                }
                if (right < sb.length()) {
                    left = right;
                    while (right < sb.length() && sb.charAt(right) != ' ') {
                        right++;
                    }
                    result.append(new StringBuffer(sb.substring(left, right)).reverse()).append(" ");
                }
            }
            result.deleteCharAt(result.length() - 1);
            return result.toString();
        }


        /*public String reverseWords(String s) {
            int n = s.length();
            char[] array = s.toCharArray();
            reverse(array, 0, n - 1);
            StringBuilder sb = new StringBuilder();
            int left = 0;
            while (left < n) {
                while (left < n && array[left] == ' ') left++;
                if (left >= n) break;
                int right = left;
                while (right < n && array[right] != ' ') right++;
                reverse(array, left, right - 1);
                while (left != right) {
                    sb.append(array[left]);
                    left++;
                }
                sb.append(" ");
            }
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }

        public void reverse(char[] array, int left, int right) {
            for (; left < right; left++, right--) {
                char temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }*/
    }
//leetcode submit region end(Prohibit modification and deletion)

}
