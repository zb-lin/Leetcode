//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。 
//
// 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。 
//
// 
//
// 示例 1: 
//
// 
//输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出: [["bat"],["nat","tan"],["ate","eat","tea"]] 
//
// 示例 2: 
//
// 
//输入: strs = [""]
//输出: [[""]]
// 
//
// 示例 3: 
//
// 
//输入: strs = ["a"]
//输出: [["a"]] 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 10⁴ 
// 0 <= strs[i].length <= 100 
// strs[i] 仅包含小写字母 
// 
//
// Related Topics 数组 哈希表 字符串 排序 👍 1910 👎 0


package leetcode.editor.cn;

import java.util.*;

/**
 * 字母异位词分组
 *
 * @author lzb
 * @date 2024-06-10 21:25:33
 */
public class P49_GroupAnagrams {
    public static void main(String[] args) {
        Solution solution = new P49_GroupAnagrams().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> record = new HashMap<>();
            for (String str : strs) {
                char[] chars = str.toCharArray();
                Arrays.sort(chars);
                String key = new String(chars);
                if (!record.containsKey(key)) {
                    List<String> itemList = new ArrayList<>();
                    itemList.add(str);
                    record.put(key, itemList);
                } else {
                    record.get(key).add(str);
                }
            }
            return new ArrayList<>(record.values());
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
