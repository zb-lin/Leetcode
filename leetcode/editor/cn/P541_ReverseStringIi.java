//给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。 
//
// 
// 如果剩余字符少于 k 个，则将剩余字符全部反转。 
// 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abcdefg", k = 2
//输出："bacdfeg"
// 
//
// 示例 2： 
//
// 
//输入：s = "abcd", k = 2
//输出："bacd"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由小写英文组成 
// 1 <= k <= 10⁴ 
// 
//
// Related Topics 双指针 字符串 👍 602 👎 0


package leetcode.editor.cn;

/**
 * 反转字符串 II
 *
 * @author lzb
 * @date 2024-06-21 18:04:33
 */
public class P541_ReverseStringIi {
    public static void main(String[] args) {
        Solution solution = new P541_ReverseStringIi().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseStr(String s, int k) {
            int n = s.length();
            char[] array = s.toCharArray();
            int left = 0;
            while (left < n) {
                int right = left + 2 * k - 1;
                if (right < n) {
                    reverse(array, left, left + k - 1);
                } else if (n - left + 1 > k) {
                    reverse(array, left, left + k - 1);
                } else {
                    reverse(array, left, n - 1);
                }
                left = right + 1;
            }
            return new String(array);
        }

        public void reverse(char[] array, int left, int right) {
            for (; left < right; left++, right--) {
                char temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
