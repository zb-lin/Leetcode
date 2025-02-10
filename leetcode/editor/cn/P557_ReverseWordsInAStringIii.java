//给定一个字符串
// s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "Let's take LeetCode contest"
//输出："s'teL ekat edoCteeL tsetnoc"
// 
//
// 示例 2: 
//
// 
//输入： s = "Mr Ding"
//输出："rM gniD"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 5 * 10⁴ 
// 
// s 包含可打印的 ASCII 字符。 
// 
// s 不包含任何开头或结尾空格。 
// 
// s 里 至少 有一个词。 
// 
// s 中的所有单词都用一个空格隔开。 
// 
//
// Related Topics 双指针 字符串 👍 589 👎 0


package leetcode.editor.cn;

/**
 * 反转字符串中的单词 III
 *
 * @author lzb
 * @date 2024-07-28 23:55:26
 */
public class P557_ReverseWordsInAStringIii {
    public static void main(String[] args) {
        Solution solution = new P557_ReverseWordsInAStringIii().new Solution();
        solution.reverseWords("Let's take LeetCode contest");
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseWords(String s) {
            int length = s.length();
            char[] array = s.toCharArray();
            int left = 0, right = 0;
            while (left < length) {
                while (s.charAt(left) == ' ') {
                    left++;
                }
                right = left;
                while (right < length && s.charAt(right) != ' ') {
                    right++;
                }
                reverse(array, left, right - 1);
                left = right;
            }
            return new String(array);
        }

        public void reverse(char[] array, int left, int right) {
            while (right < array.length && left < right) {
                char temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
                right--;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
