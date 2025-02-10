//闯关游戏需要破解一组密码，闯关组给出的有关密码的线索是： 
//
// 
// 一个拥有密码所有元素的非负整数数组 password 
// 密码是 password 中所有元素拼接后得到的最小的一个数 
// 
//
// 请编写一个程序返回这个密码。 
//
// 
//
// 示例 1: 
//
// 
//输入: password = [15, 8, 7]
//输出: "1578" 
//
// 示例 2: 
//
// 
//输入: password = [0, 3, 30, 34, 5, 9]
//输出: "03033459" 
//
// 
//
// 提示: 
//
// 
// 0 < password.length <= 100 
// 
//
// 说明: 
//
// 
// 输出结果可能非常大，所以你需要返回一个字符串而不是整数 
// 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0 
// 
//
// 
//
// Related Topics 贪心 字符串 排序 👍 696 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 破解闯关密码
 *
 * @author lzb
 * @date 2024-09-28 18:59:32
 */
public class PLCR164_BaShuZuPaiChengZuiXiaoDeShuLcof {
    public static void main(String[] args) {
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String crackPassword(int[] password) {
            String[] passwords = Arrays.stream(password).mapToObj(String::valueOf).toArray(String[]::new);
            Arrays.sort(passwords, (s1, s2) -> {
                String s3 = s1 + s2;
                String s4 = s2 + s1;
                return s3.compareTo(s4);
            });
            StringBuilder sb = new StringBuilder();
            for (String str : passwords) {
                sb.append(str);
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
