//有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。 
//
// 
// 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 
//和 "192.168@1.1" 是 无效 IP 地址。 
// 
//
// 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新
//排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "25525511135"
//输出：["255.255.11.135","255.255.111.35"]
// 
//
// 示例 2： 
//
// 
//输入：s = "0000"
//输出：["0.0.0.0"]
// 
//
// 示例 3： 
//
// 
//输入：s = "101023"
//输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 20 
// s 仅由数字组成 
// 
//
// Related Topics 字符串 回溯 👍 1423 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 复原 IP 地址
 *
 * @author lzb
 * @date 2024-06-28 17:19:17
 */
public class P93_RestoreIpAddresses {
    public static void main(String[] args) {
        Solution solution = new P93_RestoreIpAddresses().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
       List<String> res = new ArrayList<>();
        public List<String> restoreIpAddresses(String s) {
            int len = s.length();
            if (len < 4 || len > 12) return res;
            backtrack(s, new LinkedList<>(), 0);
            return res;
        }

        public void backtrack(String s, LinkedList<String> itemList, int index) {
            if (itemList.size() == 4) {
                if (index < s.length()) return;
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 4; ++i) {
                    sb.append(itemList.get(i)).append('.');
                }
                sb.deleteCharAt(sb.length() - 1);
                res.add(sb.toString());
                return;
            }
            for (int j = index; j < s.length(); ++j) {
                String str = s.substring(index, j + 1);
                if (check(str)) {
                    itemList.addLast(str);
                    backtrack(s, itemList, j + 1);
                    itemList.removeLast();
                }
            }
        }

        public boolean check(String str) {
            int len = str.length();
            if (len == 1) return true;
            if (len == 2) return str.charAt(0) != '0';
            if (len == 3) return str.charAt(0) != '0' && Integer.parseInt(str) <= 255;
            return false;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
