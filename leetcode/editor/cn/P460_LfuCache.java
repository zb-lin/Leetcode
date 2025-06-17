//请你为 最不经常使用（LFU）缓存算法设计并实现数据结构。 
//
// 实现 LFUCache 类： 
//
// 
// LFUCache(int capacity) - 用数据结构的容量 capacity 初始化对象 
// int get(int key) - 如果键 key 存在于缓存中，则获取键的值，否则返回 -1 。 
// void put(int key, int value) - 如果键 key 已存在，则变更其值；如果键不存在，请插入键值对。当缓存达到其容量 
//capacity 时，则应该在插入新项之前，移除最不经常使用的项。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除 最久未使用 的键。 
// 
//
// 为了确定最不常使用的键，可以为缓存中的每个键维护一个 使用计数器 。使用计数最小的键是最久未使用的键。 
//
// 当一个键首次插入到缓存中时，它的使用计数器被设置为 1 (由于 put 操作)。对缓存中的键执行 get 或 put 操作，使用计数器的值将会递增。 
//
// 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。 
//
// 
//
// 示例： 
//
// 
//输入：
//["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", 
//"get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
//输出：
//[null, null, null, 1, null, -1, 3, null, -1, 3, 4]
//
//解释：
//// cnt(x) = 键 x 的使用计数
//// cache=[] 将显示最后一次使用的顺序（最左边的元素是最近的）
//LFUCache lfu = new LFUCache(2);
//lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
//lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
//lfu.get(1);      // 返回 1
//                 // cache=[1,2], cnt(2)=1, cnt(1)=2
//lfu.put(3, 3);   // 去除键 2 ，因为 cnt(2)=1 ，使用计数最小
//                 // cache=[3,1], cnt(3)=1, cnt(1)=2
//lfu.get(2);      // 返回 -1（未找到）
//lfu.get(3);      // 返回 3
//                 // cache=[3,1], cnt(3)=2, cnt(1)=2
//lfu.put(4, 4);   // 去除键 1 ，1 和 3 的 cnt 相同，但 1 最久未使用
//                 // cache=[4,3], cnt(4)=1, cnt(3)=2
//lfu.get(1);      // 返回 -1（未找到）
//lfu.get(3);      // 返回 3
//                 // cache=[3,4], cnt(4)=1, cnt(3)=3
//lfu.get(4);      // 返回 4
//                 // cache=[3,4], cnt(4)=2, cnt(3)=3 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 10⁴ 
// 0 <= key <= 10⁵ 
// 0 <= value <= 10⁹ 
// 最多调用 2 * 10⁵ 次 get 和 put 方法 
// 
//
// Related Topics 设计 哈希表 链表 双向链表 👍 842 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * LFU 缓存
 *
 * @author lzb
 * @date 2024-09-06 13:58:40
 */
public class P460_LfuCache {
    public static void main(String[] args) {
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    // 节点类，存储缓存项的信息
    class Node implements Comparable<Node> {
        int count;    // 使用计数
        int time;     // 最近使用时间
        int key;      // 键
        int value;    // 值

        // 比较方法：先比较使用次数，次数相同再比较使用时间
        @Override
        public int compareTo(Node node) {
            return count == node.count ? time - node.time : count - node.count;
        }

        // 构造函数
        public Node(int count, int time, int key, int value) {
            this.count = count;
            this.time = time;
            this.key = key;
            this.value = value;
        }
    }

    // LFU缓存实现类
    class LFUCache {
        int capacity;           // 缓存容量
        int time;               // 全局时间戳
        Map<Integer, Node> cache;  // 哈希表存储键值对
        TreeSet<Node> treeSet;     // 平衡二叉搜索树，用于快速找到LFU节点

        // 构造函数
        public LFUCache(int capacity) {
            cache = new HashMap<>();  // 初始化哈希表
            treeSet = new TreeSet<>(); // 初始化平衡树
            time = 0;                 // 初始化时间戳
            this.capacity = capacity;  // 设置缓存容量
        }

        // 获取键对应的值
        public int get(int key) {
            Node node = cache.get(key);
            if (node == null) {
                return -1;  // 键不存在返回-1
            }
            // 更新节点信息
            treeSet.remove(node);  // 先从树中移除
            node.count++;         // 增加使用计数
            node.time = ++time;    // 更新最近使用时间
            treeSet.add(node);     // 重新加入树中
            return node.value;     // 返回值
        }

        // 插入或更新键值对
        public void put(int key, int value) {
            Node node = cache.get(key);
            if (node != null) {
                // 键已存在，更新值
                treeSet.remove(node);  // 先从树中移除
                node.value = value;    // 更新值
                node.count++;         // 增加使用计数
                node.time = ++time;    // 更新最近使用时间
                treeSet.add(node);     // 重新加入树中
            } else {
                // 键不存在，需要插入
                if (cache.size() == capacity) {
                    // 缓存已满，需要淘汰
                    Node first = treeSet.first();  // 获取使用最少且最久未使用的节点
                    cache.remove(first.key);       // 从哈希表中移除
                    treeSet.remove(first);         // 从树中移除
                }
                // 创建新节点并加入
                node = new Node(1, ++time, key, value);  // 新节点初始计数为1
                cache.put(key, node);  // 加入哈希表
                treeSet.add(node);     // 加入树中
            }
        }
    }

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
