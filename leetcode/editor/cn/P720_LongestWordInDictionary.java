//给出一个字符串数组 words 组成的一本英语词典。返回 words 中最长的一个单词，该单词是由 words 词典中其他单词逐步添加一个字母组成。 
//
// 若其中有多个可行的答案，则返回答案中字典序最小的单词。若无答案，则返回空字符串。 
//
// 请注意，单词应该从左到右构建，每个额外的字符都添加到前一个单词的结尾。 
//
// 
//
// 示例 1： 
//
// 
//输入：words = ["w","wo","wor","worl", "world"]
//输出："world"
//解释： 单词"world"可由"w", "wo", "wor", 和 "worl"逐步添加一个字母组成。
// 
//
// 示例 2： 
//
// 
//输入：words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
//输出："apple"
//解释："apply" 和 "apple" 都能由词典中的单词组成。但是 "apple" 的字典序小于 "apply" 
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 1000 
// 1 <= words[i].length <= 30 
// 所有输入的字符串 words[i] 都只包含小写字母。 
// 
//
// Related Topics 字典树 数组 哈希表 字符串 排序 👍 355 👎 0


package leetcode.editor.cn;

/**
 * 词典中最长的单词
 *
 * @author lzb
 * @date 2024-09-19 17:18:13
 */
public class P720_LongestWordInDictionary {
    public static void main(String[] args) {
        Solution solution = new P720_LongestWordInDictionary().new Solution();
        String[] words = {"w", "wo", "wor", "worl", "world"};
        solution.longestWord(words);
    }


    //leetcode submit region begin(Prohibit modification and deletion)

    class Trie {
        Trie[] children;
        boolean isEnd;

        public Trie() {
            this.children = new Trie[26];
            this.isEnd = false;
        }

        public void insert(String word) {
            Trie node = this;
            for (char ch : word.toCharArray()) {
                int index = ch - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new Trie();
                }
                node = node.children[index];
            }
            node.isEnd = true;
        }

        public boolean search(String word) {
            Trie node = this;
            for (char ch : word.toCharArray()) {
                int index = ch - 'a';
                if (node.children[index] == null || !node.children[index].isEnd) {
                    return false;
                }
                node = node.children[index];
            }
            return node != null && node.isEnd;
        }
    }

    class Solution {


        public String longestWord(String[] words) {
            Trie trie = new Trie();
            for (String word : words) {
                trie.insert(word);
            }
            String longestWord = "";
            for (String word : words) {
                if (trie.search(word)) {
                    if (word.length() > longestWord.length()
                            || (word.length() == longestWord.length() && word.compareTo(longestWord) < 0)) {
                        longestWord = word;
                    }
                }
            }
            return longestWord;
        }


        /*Set<String> cache;

        public String longestWord(String[] words) {
            Arrays.sort(words, (a, b) -> a.length() != b.length() ? b.length() - a.length() : a.compareTo(b));
            System.out.println(Arrays.toString(words));
            cache = new HashSet<>(Arrays.asList(words));
            for (String word : words) {
                if (check(word)) {
                    return word;
                }
            }
            return "";
        }

        public boolean check(String word) {
            if (word.length() == 1) return true;
            String sub = word.substring(0, word.length() - 1);
            if (!cache.contains(sub)) {
                return false;
            }
            return check(sub);
        }*/

    }
//leetcode submit region end(Prohibit modification and deletion)

}
