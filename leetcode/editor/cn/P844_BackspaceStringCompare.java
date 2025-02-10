//给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。 
//
// 注意：如果对空文本输入退格字符，文本继续为空。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ab#c", t = "ad#c"
//输出：true
//解释：s 和 t 都会变成 "ac"。
// 
//
// 示例 2： 
//
// 
//输入：s = "ab##", t = "c#d#"
//输出：true
//解释：s 和 t 都会变成 ""。
// 
//
// 示例 3： 
//
// 
//输入：s = "a#c", t = "b"
//输出：false
//解释：s 会变成 "c"，但 t 仍然是 "b"。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 200 
// s 和 t 只含有小写字母以及字符 '#' 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以用 O(n) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？ 
// 
//
// Related Topics 栈 双指针 字符串 模拟 👍 739 👎 0


package leetcode.editor.cn;

/**
 * 比较含退格的字符串
 *
 * @author lzb
 * @date 2024-06-18 20:54:19
 */
public class P844_BackspaceStringCompare {
    public static void main(String[] args) {
        Solution solution = new P844_BackspaceStringCompare().new Solution();
        solution.backspaceCompare("xywrrmp", "xywrrmu#p");
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean backspaceCompare(String s, String t) {
            int right1 = s.length() - 1, right2 = t.length() - 1;
            while (right1 >= 0 || right2 >= 0) {
                int count1 = 0, count2 = 0;
                while (right1 >= 0) {
                    if (s.charAt(right1) == '#') {
                        right1--;
                        count1++;
                    } else if (count1 > 0) {
                        count1--;
                        right1--;
                    } else {
                        break;
                    }
                }
                while (right2 >= 0) {
                    if (t.charAt(right2) == '#') {
                        right2--;
                        count2++;
                    } else if (count2 > 0) {
                        count2--;
                        right2--;
                    } else {
                        break;
                    }
                }
                if (right1 >= 0 && right2 >= 0) {
                    if (s.charAt(right1) != t.charAt(right2)) {
                        return false;
                    }
                } else {
                    if (right1 >= 0 || right2 >= 0) {
                        return false;
                    }
                }
                right1--;
                right2--;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
