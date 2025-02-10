//给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。 
//
// 例如： 
//
// 
//A -> 1
//B -> 2
//C -> 3
//...
//Z -> 26
//AA -> 27
//AB -> 28 
//...
// 
//
// 
//
// 示例 1： 
//
// 
//输入：columnNumber = 1
//输出："A"
// 
//
// 示例 2： 
//
// 
//输入：columnNumber = 28
//输出："AB"
// 
//
// 示例 3： 
//
// 
//输入：columnNumber = 701
//输出："ZY"
// 
//
// 示例 4： 
//
// 
//输入：columnNumber = 2147483647
//输出："FXSHRXW"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= columnNumber <= 2³¹ - 1 
// 
//
// Related Topics 数学 字符串 👍 693 👎 0


package leetcode.editor.cn;

/**
 * Excel表列名称
 *
 * @author lzb
 * @date 2024-09-21 15:39:30
 */
public class P168_ExcelSheetColumnTitle {
    public static void main(String[] args) {
        Solution solution = new P168_ExcelSheetColumnTitle().new Solution();
        solution.convertToTitle(701);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String convertToTitle(int columnNumber) {
            StringBuilder res = new StringBuilder();
            while (columnNumber > 0) {
                int a0 = (columnNumber - 1) % 26 + 1;
                res.append((char) (a0 - 1 + 'A'));
                columnNumber = (columnNumber - a0) / 26;
            }
            return res.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
