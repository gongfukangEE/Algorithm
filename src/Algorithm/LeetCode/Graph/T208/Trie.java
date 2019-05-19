package Algorithm.LeetCode.Graph.T208;

/**
 * @auther G.Fukang
 * @date 5/19 22:08
 */
public class Trie {

    /**
     * 在每个节点开一个字符集 26 个字母的数组，对应的下标就是子孩子节点所表示的字符，内容则是这个子孩子在数组上的索引
     */

    // 根节点
    private TireNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TireNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        // 从 root 节点向下遍历
        TireNode node = this.root;
        for (char ch : word.toCharArray()) {
            // 如果此位置没有字符，直接插入当前字符
            if (node.children[ch - 'a'] == null) {
                node.children[ch - 'a'] = new TireNode();
            }
            // 此位置有字符，继续往下走
            node = node.children[ch - 'a'];
        }
        // 所有字符插入完毕，记录 String
        node.item = word;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TireNode node = this.root;
        // 遍历
        for (char ch : word.toCharArray()) {
            // 任意一个字符不存在，则 word 不存在
            if (node.children[ch - 'a'] == null) {
                return false;
            }
            node = node.children[ch - 'a'];
        }
        // 比较 string 与 word
        return node.item.equals(word);
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TireNode node = this.root;
        for (char ch : prefix.toCharArray()) {
            // 任意一个字符不存在，则 prefix 不存在
            if (node.children[ch - 'a'] == null) {
                return false;
            }
            node = node.children[ch - 'a'];
        }
        // 所以 prfix 都存在
        return true;
    }

    // 定义数据结构
    class TireNode {
        // 子孩子
        TireNode[] children = new TireNode[26];
        // 子孩子对应的单词
        String item = "";
    }
}
