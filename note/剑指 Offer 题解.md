[TOC]

# 剑指 Offer

## 1. [二维数组中的查找](https://www.nowcoder.com/practice/abc3fe2ce8e146608e868a70efebf62e?tpId=13&tqId=11154&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tPage=1)

**数组**

1. 根据数组的递增特性，选择右上角的初始点 start
2. 如果 target 大于 start，则向下移动；如果 target 小于 start 则向左移动

```java
public static boolean Find(int target, int[][] array) {
    if （array == null || array.length == 0 || array[0].length == 0）{
        return false;
    } else {
        int i = 0;
        int j = array[0].length - 1;
        while (i < array.length && j >= 0) {
            int start = array[i][j];
            if (target > start)
                i++;
            else if (target < start)
                j--;
            else 
                return true;
        }
        return false; 
    }
}
```

## 2. [替换空格](https://www.nowcoder.com/practice/4060ac7e3e404ad1a894ef3e17650423?tpId=13&tqId=11155&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tPage=1)

**字符串**

1. 从前先向后扫描，遇到空格，在尾部补任意两个字符串，使得补充后的字符串长度和替换后的字符串长度相等
2. P1 为原字符串尾部，P2 为现字符串尾部，从后向前扫描，遇到非空格，在 P2 位置补原字符，遇到空格在 P2 位置补 02%


```java
public String replaceSpace(StringBuffer str) {
    int p1 = str.length() - 1;
    for (int i = 0; i <= p1; i++)
        if (str.charAt(i) == ' ')
            str.append("##");
    int p2 = str.length() - 1;
    for (int i = p1; i >= 0; i--) {
        if (str.charAt(i) != ' ') 
            str.setCharAt(p2--, str.charAt(i)); 
        else {
            str.setCharAt(p2--, '0');
            str.setCharAt(p2--, '2');
            str.setCharAt(p2--, '%');
        }
    }
    return str.toString();
}
```

## 3. [从尾到头打印链表值](https://www.nowcoder.com/practice/d0267f7f55b3412ba93bd35cfa8e8035?tpId=13&tqId=11156&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

**递归 && 链表**

1. 递归终止条件：`listNode == null`
2. 不满足终止条件，执行递归，传入 `listNode.next`
3. 递归语句后，将节点值添加到 List 中

```java
public ArryList<Integer> printListFromTailToHead(ListNode listNode) {
    ArrayList<Integer> resList = new ArrayList<Integer>();
    if (listNode != null)
        printListFromTailToHead(listNode, resList);
    return resList;
}
public void printListFromTailToHead(ListNode listNode, ArrayList<Integer> resList) {
    if (listNode != null) {
        printListFromTailToHead(listNode.next, resList);
        resList.add(listNode.val);
    } else {
        return;
    }
}
```

## 4. [根据前序和中序遍历重建二叉树](https://www.nowcoder.com/practice/8a19cbe657394eeaac2f6ea9b0f6fcf6?tpId=13&tqId=11157&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

**递归 && 二叉树**

1. 先序遍历的第一个位置是 root 节点。中序遍历的 root 节点位置在中间 p，在 root 节点左边的肯定是 root 的左子树的中序数组，在 root 节点右边的肯定是 root 的右子树的中序数组。先序遍历的第二个位置到 p，就是 root 左子树的先序数组，p 右边就是 root 右子树的先序数组
2. 存储中序遍历的节点和索引值
3. 找到先序遍历的 root 节点，初始为左边缘节点，递归过程中不断更新
4. 找到 root 节点在中序遍历中的索引，计算出左子树和右子树的大小
5. 模拟先序遍历过程，递归插入左子树和右子树

```java
private HashMap<Integer, Integer> map = new HashMap<>();
public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
    for (int i = 0; i < pre.length; i++) {
        map.put(in[i], i);
    }
    return reConstructBinaryTree(pre, 0, pre.length - 1, 0);
}

private TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int inL) {
    if (preL > preR) {
        return null;
    }
    // 先序遍历的 root 节点
    TreeNode root = new TreeNode(pre[preL]);
    // 找到 root 在中序遍历数组的位置
    int inIndex = map.get(root.val);
    // 中序遍历中左子树的范围
    int leftTreeSize = inIndex - inL;
    root.left = reConstructBinaryTree(pre, preL + 1, preL + leftTreeSize, inL);
    root.right = reConstructBinaryTree(pre, preL + leftTreeSize + 1, preR, inL + leftTreeSize + 1);
    return root;
}
```

## 5. [两个栈实现队列](https://www.nowcoder.com/practice/54275ddae22f475981afa2244dd448c6?tpId=13&tqId=11158&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

**栈和队列**

1. stack1 入栈用来模拟元素入队
2. 出队时，如果 stack2 为空，则先将 stack1 中的元素添加到 stack2 中；如果不为空，直接 stack2 出栈用来模拟元素出队

```java
Stack<Integer> stack1 = new Stack<Integer>();
Stack<Integer> stack2 = new Stack<Integer>();
public void push(int node) {
    stack1.push(node);
}
public int pop() {
    if (stack2.isEmpty()) {
        while(!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    } 
    return stack2.pop();
}
```

## 6. [旋转非减数组的最小数字](https://www.nowcoder.com/practice/9f3231a991af4f55b95579b44b7a01ba?tpId=13&tqId=11159&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tPage=1)

**二分查找 && 数组**

1. mid > right：最小值位于数组右半部分  `4 5 6 7 1 2 3`
2. mid < right：最小值位于数组左半部分  `6 7 1 2 3 4 5 `
3. mid = right：最小值位于当下数组中，且数组左右端点值相等，存在重复值，依次寻找

```java
public int minNumberInRotateArray(int[] array) {
    if (array.length == 0)
        return 0;
    int left = 0;
    int right = array.length -1;
    while(left < right) {
        int mid = (left + right) / 2;
        if (array[mid] > array[right])
            left = mid + 1;
        else if (array[mid] < array[right])
            right = mid;
        else 
            left = left + 1;
    }
    return array[left];
}
```

## 7. [斐波那契数列](https://www.nowcoder.com/practice/c6c7742f5ba7442aada113136ddea0c3?tpId=13&tqId=11160&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

**动态规划**

1. `f(n) = n, n <= 1`
2. `f(n) = f(n - 1) + f(n - 2), n >= 2`
3. 将 `n-1` 和 `n-2` 的结果值缓存

```java
public int Fibonacci(int a) {
    if (a <= 1)
        return a;
    int res1 = 0;
    int res2 = 1;
    int res = 0;
    for (int i = 2; i <= a; i++) {
        res = res1 + res2;
        res1 = res2;
        res2 = res;
    }
    return res;
}
```

## 8. [跳台阶](https://www.nowcoder.com/practice/8c82a5b80378478f9484d87d1c5f12a4?tpId=13&tqId=11161&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

**动态规划**

1. `f(n) = n, n <= 2`
2. `f(n) = f(n - 1) + f(n - 2), n >= 3`

```java
public int JumpFloor(int target) {
    if (target <= 2) 
        return target;
    int res1 = 1;
    int res2 = 2;
    int res = 0;
    for (int i = 3; i <= target; i++) {
        res = res1 + res2;
        res1 = res2;
        res2 = res;
    }
    return res;
}
```

## 9. [变态跳台阶](https://www.nowcoder.com/practice/22243d016f6b47f2a6928b4313c85387?tpId=13&tqId=11162&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

**动态规划**

1. `f(1) = 1`
2. `f(2) = 2 = f(1) + 1  `
3. `f(3) = 4 = f(2) + f(1) + 1`
4. `f(4) = 8 = f(3) + f(2) + f(1) + 1`
5. `f(n - 1) = f(n - 2) + f(n - 3) + ... + f(1) + 1`
6. `f(n) = f(n - 1) + f(n - 2) + ... +f(1) + 1`
7. (5) 和 (6) 相减得 `f(n) = 2 * f(n - 1)`

```java
/* (7) */
public int JumpFloorII(int target) {
    int[] res = new int[target + 1];
    res[1] = 1;
    for (int i = 2; i <= target; i++) 
        res[i] = 2 * res[i - 1];
    return res[target];
}
/* (6) */
public int JumpFloorII(int target) {
    int[] res = new int[target + 1];
    res[1] = 1;
    for (int i = 2; i <= target; i++) {
        for (int j = 1; j < i; j++)
            res[i] += res[j];
        res[i] += 1;
    }
    return res[target];
}
```

## 10. [矩形覆盖](https://www.nowcoder.com/practice/72a5a919508a4251859fb2cfb987a0e6?tpId=13&tqId=11163&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

**动态规划**

1. 第一块放 `2 * 1` 的位置，则剩下有 `f(n - 1)` 种覆盖方式
2. 第一块放 `1 * 2` 的位置，则对应的 `2 * 2` 的矩形中另一块的位置也被确定，剩下 `f(n - 2)` 种覆盖方式
3. `f(n) = f(n - 1) + f(n - 2), n > 2`

```java
public int RectCover(int target) {
    if (target <= 2)
        return target;
    int res1 = 1;
    int res2 = 2;
    int res = 0;
    for (int i = 3; i <= target; i++) {
        res = res1 + res2;
        res1 = res2;
        res2 = res;
    }
    return res;
}
```

## 11. [二进制中的 1 的个数](https://www.nowcoder.com/practice/8ee967e43c2c4ec193b040ea7fbb10b8?tpId=13&tqId=11164&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

**位运算**

1. 1 的二进制为 `0000 0001` 共计 32 位，每次左移一位为 `0010`，`0100`，`1000`
2. 移位后与 n 做 `&` 操作，用来检测 n 的二进制每位上是否为 1

```java
public int NumberOf1(int n) {
    int target = 1;
    int count = 0;
    while(target != 0) {
        if ((target & n) != 0)
            count++;
        target = target << 1;
    }
    return count;
}
```

## 12. [浮点数值的整数方](https://www.nowcoder.com/practice/1a834e5e3e1a4b7ba251417554e07c00?tpId=13&tqId=11165&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

1. for 循环模拟幂运算
2. 注意 exponent 的正负号

```java
public double Power(double base, int exponent) {
    if (exponent == 0)
        return 1;
    double res = base;
    for (int i = 1; i < Math.abs(exponent); i++)
        res *= base;
    if(exponent > 0)
        return res;
    else 
        return (double)1 / res;
}
```

## 13. [调整数组顺序使奇数位于偶数前面](https://www.nowcoder.com/practice/beb5aa231adc45b2a5dcc5b62c93f593?tpId=13&tqId=11166&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

**数组**

1. 计算数组中奇数的个数
2. 新开一个复制数组，遍历数组，奇数从 0 开始添加，偶数从计数后开始添加

```java
public void reOrderArray(int[] array) {
    int oddCount = 0;
    for (int item : array) 
        if (item % 2 == 1)
            oddCount++;
    int[] copy = array.clone();
    int index = 0;
    for (int item : copy) {
        if (item % 2 == 1)
            array[index++] = item;
        else 
            array[oddCount++] = item;
    }
}
```

## 14. [链表中倒数第 k 个节点](https://www.nowcoder.com/practice/529d3ae5a407492994ad2a246518148a?tpId=13&tqId=11167&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

**双指针 && 链表**

1. 指针 first 指向 head，指针 last 指向正数第 K 个节点
2. first 和 last 同时向前运动，当 last 走到最后一个节点时，first 指向的节点就是倒数第 K 个节点

```java
public ListNode FindKthToTail(ListNode head,int k) {
    if (head == null || k == 0) {
        return null;
    }
    ListNode fast = head;
    int count = 1;
    while (fast.next != null) {
        fast = fast.next;
        count++;
        if (count > k) {
            head = head.next;
        }
    }
    return count >= k ? head : null;
}
```

## 15. [反转链表](https://www.nowcoder.com/practice/75e878df47f24fdc9dc3e400ec6058ca?tpId=13&tqId=11168&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

**递归 && 三指针 && 链表**

1. 三个指针，pre，cur，last 平行推进，每次 `cur.next = pre`，当 `cur` 为空时，`pre` 为新的头节点
2. 递归实现：保存每个节点的 nextNode 节点信息，将每个节点断开 `head.next = null`，将 nextNode 节点传入递归方法，递归结束后，`nextNode.next = head`

```java
/* 三指针 */
public ListNode ReverseList(ListNode head) {
    if (head == null || head.next == null)
        return head;
    ListNode pre = null;
    ListNode cur = head;
    ListNode last = null;
    while(cur != null) {
        last = cur.next;
        cur.next = pre;
        pre = cur;
        cur = last;
    }
    return pre;
}
/* 递归 */
public ListNode ReverseList(ListNode head) {
    if (head == null || head.next == null) 
        return head;
    ListNode nextNode = head.next;
    head.next = null;
    ListNode newHead = ReverseList(nextNode);
    nextNode.next = head;
    return newHead;
}
```

## 16. [合并两个排序的链表](https://www.nowcoder.com/practice/d8b6b4358f774294a89de2a6ac4d9337?tpId=13&tqId=11169&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

**递归 && 链表**

1. 两值相比，讨论大小两种情况
2. 若 `list1.val` 小，则当前插入的节点为 `list1`，后续节点为 `list1.next = Merge()`
3. 若 `list2.val` 小，则当前插入的节点为 `list2`，后续节点为 `list2.next = Merge()`

**[合并 K 个有序链表](<https://leetcode-cn.com/problems/merge-k-sorted-lists/submissions/>)**

1. 递归分治将链表两两划分
2. 递归合并两个有序链表

```java
/* 递归 */
public ListNode Merge(ListNode list1, ListNode list2) {
    if (list1 == null)
        return list2;
    if (list2 == null)
        return list1;
    if (list1.val <= list2.val) {
        list1.next = Merge(list1.next, list2);
        return list1;
    } else {
        list2.next = Merge(list1, list2.next);
        return list2;
    }
}
/* 非递归 */
public ListNode Merge(ListNode list1, ListNode list2) {
    ListNode res = new ListNode(-1);
    if (list1 == null) 
        return list2;
    if (list1 != null)
        return list1;
    ListNode cur = res;
    while(list1 != null && list2 != null) {
        int val1 = list1.val;
        int val2 = list2.val;
        if(val1 <= val2) {
            cur.next = new ListNode(val1);
            list1 = list1.next;
        } else {
            cur.next = new ListNode(val2);
            list2 = list2.next;
        }
         cur = cur.next;
    }
    if (list1 != null) 
        cur.next = list1;
    if (list2 != null)
        cur.next = list2;
    return res.next;
}
/* 合并 K 个有序链表 */
public ListNode mergeKLists(ListNode[] lists) {
    return helpMerge(lists, 0, lists.length - 1);
}
// 划分链表
private ListNode helpMerge(ListNode[] lists, int start, int end) {
    if (start > end)	return null;
    if (start == end)	return lists[start];
    int mid = (start + end) / 2;
    ListNode left = helpMerge(lists, start, mid);
    ListNode right = helpMerge(lists, mid + 1, end);
    return merge(left, right);
}
// 合并两个有序链表
private ListNode merge(ListNode l1, ListNode l2) {
    if (l1 == null)	return l2;
    if (l2 == null)	return l1;
    if (l1.val <= l2.val) {
        l1.next = merge(l1.next, l2);
        return l1;
    } else {
        l2.next = merge(l1, l2.next);
        return l2;
    }
}
```

## 17. [判断树的子结构](https://www.nowcoder.com/practice/6e196c44c7004d15b1610b9afca8bd88?tpId=13&tqId=11170&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

**递归 && 二叉树**

1. 不论树 A 还是 树 B，只要初始为空，均为不是子树结构
2. 初始时，如果树 A 的值与树 B 的值相等，则递归匹配
3. 如果树 A 的值与树 B 的值不相等，则树 B 不变，分别在树 A 的左子树和右子树递归匹配
4. 匹配递归
   1. 如果树 B 为空，即表示匹配成功
   2. 如果树 A 为空，树 B 不为空；或者树 A  的值和树 B 的值不相等，则表示匹配失败
   3. 分别在对树 A 和树 B 的左右子树进行匹配，两者均为 true 才是匹配成功

```java
public boolean HasSubtree(TreeNode root1,TreeNode root2) {
    boolean res = false;
    if ((root1 != null && root2 == null) || (root1 == null))    return false;
    if (root1.val == root2.val)    res = isSubtree(root1, root2);
    if (res)    return true;
    else    return isSubtree(root1.left, root2) | isSubtree(root1.right, root2);
}
private boolean isSubtree(TreeNode t1, TreeNode t2) {
    if (t2 == null)    return true;
    if ((t1 == null && t2 != null) || (t1.val != t2.val))     return false;
    return isSubtree(t1.left, t2.left) & isSubtree(t1.right, t2.right);
}
```

## 18. [二叉树的镜像](https://www.nowcoder.com/practice/564f4c26aa584921bc75623e48ca3011?tpId=13&tqId=11171&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

**递归 && 二叉树**

1. 交换左右子树
2. 左右子树分别递归

```java
public void Mirror(TreeNode root) {
    if (root != null) {
        swap(root);
        Mirror(root.left);
        Mirror(root.right);
    } else 
        return;
}

private void swap(TreeNode node) {
    TreeNode tempNode = node.left;
    node.left = node.right;
    node.right = tempNode;
}
```

## 19. [顺时针打印矩阵](https://www.nowcoder.com/practice/9b4c81a02cd34f76be2659fa0d54342a?tpId=13&tqId=11172&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

**数组**

1. 上 -> 右 -> 下 -> 左
2. 上下边界判定和左右边界判定

```java
public ArrayList<Integer> printMatrix(int[][] matrix) {
    ArrayList<Integer> res = new ArrayList<>();
    int rowStart = 0;
    int rowEnd = matrix.length - 1;
    int colStart = 0;
    int colEnd = matrix[0].length - 1;
    while (rowStart <= rowEnd && colStart <= colEnd) {
        for (int i = colStart; i<= colEnd; i++)
            res.add(matrix[rowStart][i]);
        for (int i = rowStart + 1; i <= rowEnd; i++)
            res.add(matrix[i][colEnd]);
        if (rowEnd != rowStart)
            for (int i = colEnd - 1; i >= colStart; i--)
                res.add(matrix[rowEnd][i]);
        if (colEnd != colStart)
            for (int i = rowEnd - 1; i > rowStart; i--)
                res.add(matrix[i][colStart]);
        ++rowStart;
        --rowEnd;
        ++colStart;
        --colEnd;
    }
    return res;
}
```

## 20. [包含 min 函数的栈](https://www.nowcoder.com/practice/4c776177d2c04c2494f2555c9fcc1e49?tpId=13&tqId=11173&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

**栈和队列**

1. 主栈顺序存储元素，辅助栈每次存储当前栈的最小元素
2. 主栈 Push，辅助栈压入 `min(peek, node)`
3. 主栈和辅助栈同时 pop
4. 对于 min 方法，辅助栈 peek

```java
private Stack<Integer> stack1 = new Stack<>();
private Stack<Integer> stack2 = new Stack<>();
public void push(int node){
    stack1.push(node);
    if (stack2.empty())
        stack2.push(node);
    else
        if (stack2.peek() >= node)
            stack2.push(node);
    	else
            stack2.push(stack2.peek());
}
public void pop() {
    stack1.pop();
    stack2.pop();
}
public int top() {
    return stack1.peek();
}
public int min() {
    return stack2.peek();
}
```

## 21. [栈的压入、弹出序列](https://www.nowcoder.com/practice/d77d11405cc7470d82554cb392585106?tpId=13&tqId=11174&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

**栈和队列**

1. 构建一个辅助栈实现
2. pushA 按顺序压栈
3. 如果栈顶元素与 popA 当前元素相等，则不断出栈，直到不相等
4. 如果栈为空，pushA 和 popA 索引均为数组最右值，则匹配成功，否则失败

```java
private Stack<Integer> stack = new Stack<>();
public boolean IsPopOrder(int[] pushA, int[] popA) {
    int popIndex = 0;
    int pushIndex = 0;
    for (Integer item : pushA) {
        ++pushIndex;
        stack.push(item);
        while(!stack.isEmpty() && stack.peek() == popA[popIndex]) {
            stack.pop();
            ++popIndex;
        }
    }
    if (pushIndex == pushA.length && popIndex == pushIndex && stack.isEmpty())
        return true;
    else 
        return false;
}
```

## 22. [从上往下打印二叉树](https://www.nowcoder.com/practice/7fe2212963db4790b57431d9ed259701?tpId=13&tqId=11175&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

**二叉树**

1. 边界检测，空与非空
2. root 节点入队
3. 队列不为空，出队，出队节点的左右子树入队

```java
public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
    ArrayList<Integer> resList = new ArrayList<Integer>();
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    if (root == null) 
        return resList;
    else {
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode tempNode = queue.remove();
            resList.add(tempNode.val);
            if (tempNode.left != null)
                queue.offer(tempNode.left);
            if (tempNode.right != null)
                queue.offer(tempNode.right);
        }
        return resList;
    }
}
```

## 23. [二叉树的后序遍历序列](https://www.nowcoder.com/practice/a861533d45854474ac791d90e447bafd?tpId=13&tqId=11176&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

**二叉树**

1. 后序遍历序列为左右根，因此数组中最后一个值为 root，左子树值均小于 root，右子树值均大于 root
2. 确定 root
3. 找到第一个大于 root 节点的值为右子树起点
4. 遍历右子树，如果小于 root 返回 false
5. 左右子树分别递归验证
6. 递归终止条件：左边界与右边界差值小于等于 1

```java
public boolean VerifySquenceOfBST(int[] sequence) {
    if (sequence == null || sequence.length == 0)
        return false;
    return doVerifySquenceOfBST(sequence, 0, sequence.length - 1);
}
private boolean doVerifySquenceOfBST(int[] sequence, int left, int right){
	if (right - left <= 1)
        return true;
    int root = sequence[right];
    int index = left;
    while(index < right && sequence[index] < root)
        index++;
    for (int i = index; i < right; i++)
        if (sequence[i] <= root)
            return false;
    return doVerifySquenceOfBST(sequence, left + 1, index - 1) & doVerifySquenceOfBST(sequence, index, right - 1);
}
```

## 24. [二叉树中和为某一值的路径](https://www.nowcoder.com/practice/b736e784e3e34731af99065031301bca?tpId=13&tqId=11177&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

**递归 && 二叉树**

1. 遍历到一个节点，list 中添加节点，sum 加上节点值
2. 首先判断是不是叶节点，如果是叶节点，判断 `sum == target`，是就添加到 list 中
3. 如果不是叶节点，左右子树分别递归
4. 递归退出一层后，从 list 中删除当前节点，并在 sum 中减去节点值

```java
private ArrayList<ArrayList<Integer>> res = new ArrayList<>();
private ArrayList<Integer> list = new ArrayList<>();
public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
    if (root == null || target <= 0)    return res;
    doFindPath(root, target);
    return res;
}
private void doFindPath(TreeNode root, int target) {
    if (root == null && target != 0)    return;
    list.add(root.val);
    if (root.left == null && root.right == null) {
        if (target == root.val) {
            res.add(new ArrayList(list));
        }
    } else {
        doFindPath(root.left, target - root.val);
        doFindPath(root.right, target - root.val);
    }
    list.remove(list.size() - 1);
}
```

## 25. [复杂链表的复制](https://www.nowcoder.com/practice/f836b2c43afc4b35ad6adc41ec941dba?tpId=13&tqId=11178&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

**链表**

1. 复制每个节点，并依次插入，比如：A -> A1 -> B -> B1
2. 将每个节点的 Random 值复制到 copy 节点上
3. 将链表拆分为源链表和 copy 链表
   1. 确保拆分成完全不相干的两个完整链表，`newHead = pHead.next` 来记录 copy 链表头
   2. 保存节点的 next 信息，首先与第三个节点相连，再迭代到 next 节点

```java
public RandomListNode Clone(RandomListNode pHead) {
    if (pHead == null)
        return null;
    RandomListNode copyHead = pHead;
    while(copyHead != null) {
        RandomListNode node = new RandomListNode(copyHead.label);
        node.next = copyHead.next;
        copyHead.next = node;
        copyHead = node.next;
    }
    copyHead = pHead;
    while (copyHead != null) {
        if (copyHead.random != null)
            copyHead.next.random = copyHead.random.next;
        copyHead = copyHead.next.next;
    }
    copyHead = pHead;
    RandomListNode newHead = pHead.next;
    while (copyHead.next != null) {
        RandomListNode tmp = copyHead.next;
        copyHead.next = tmp.next;
        copyHead = tmp;
    }
    return newHead;
}
```

## 26. [二叉树与双向链表](https://www.nowcoder.com/practice/947f6eb80d944a84850b0538bf0ec3a5?tpId=13&tqId=11179&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

**链表 && 二叉树**

1. 二叉树的中序遍历为排序数组
2. 中序遍历为左根右，则若当前元素 `cur` 为根，`cur.pre = left;cur.next = right`。将其转换为双向链表，只需将 `cur.left = pre`，同时将 `cur` 节点为 `right`，`pre` 节点为根

```java
private TreeNode pre = null;
private TreeNode head = null;
public TreeNode Convert(TreeNode pRootOfTree) {
    inOrder(pRootOfTree);
    return head;
}
private void inOrder(TreeNode node) {
    if (node == null)
        return;
    inOrder(node.left);
    node.left = pre;
    if (pre != null)
        pre.right = node;
    pre = node;
    if (head == null)
        head = node;
    inOrder(node.right);
}
```

## 27. [字符串排序](https://www.nowcoder.com/practice/fe6b651b66ae47d7acce78ffdd9a96c7?tpId=13&tqId=11180&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

**字符串 && 排列组合 && 回溯法**

1. marked 数组标记字符
2. 递归终止条件：`s.length() == chars.length`
3. 循环直接跳过：
   1. 当前字符被标记
   2. 当前字符未被标记，但是和前一个字符相同（字符串已排序），同时前一个字符已经被标记
4. 递归结束：
   1. 重置字符串标记
   2. 删除最后一个拼接的字符

```java
private ArrayList<String> list = new ArrayList<>();
private boolean[] marked;
public ArrayList<String> Permutation(String str) {
    if (str == null || str.length() == 0)
        return list;
    char[] chars = str.toCharArray();
    marked = new boolean[str.length()];
    backtracing(chars, new StringBuilder());
    return list;
}
private void backtracing(char[] chars, StringBuilder s) {
    if (s.length() == chars.length) {
        list.add(s.toString());
        return;
    }
    for (int i = 0; i < chars.length; i++) {
        if (marked[i])
            continue;
        if (i != 0 && chars[i] == chars[i - 1] && marked[i - 1])
            continue;
        s.append(chars[i]);
        marked[i] = true;
        backtracing(chars, s);
        s.deleteCharAt(s.length() - 1);
        marked[i] = false;
    }
}
```

## 28. [数组中出现次数超过一半的数字](https://www.nowcoder.com/practice/e8a1b01a2df14cb2b228b30ee6a92163?tpId=13&tqId=11181&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

**数组**

1. 摩尔投票算法：核心在于每次选择两个不相同的元素删掉，`count--` 相当于不同元素的抵消。由于存在超过半数的元素，因此抵消后，必然剩下的就是出现次数超过半数的元素
2. 使用 `count` 来统计一个元素出现的次数，当遍历到的元素和统计的元素相等时，令 `count++`，否则 `count--`
3. 如果前面查找到 i 个元素，且 `count == 0`，说明前 i 个元素没有 Majority，或者存在但是小于 `1/2`
4. 剩下的 `n - i` 个元素中，Majority 的数组依然多于 `(n - i) / 2`

```java
/* 摩尔投票算法 */
public int MoreThanHalfNum_Solution(int[] array) {
    int majority = array[0];
    int i;
    int count = 0;
    for (i = 1, count = 1; i < array.length; i++) {
        if (array[i] == majority) 
            count++;
        else 
            count--;
        if (count == 0) {
            majority = array[i];
            count = 1;
        }
    }
    count = 0;
    for (Integer item : array) {
        if (item == majority)
            count++;
    }
    return count > (array.length / 2) ? majority : 0;
}
```

## 29. [最小的 k 个数](https://www.nowcoder.com/practice/6a296eb82cf844ca8539b57c23e6e9bf?tpId=13&tqId=11182&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

**数组 && 栈和队列**

1. 最小 K 个数，应该使用大小为 K 的小顶堆，如果直接使用小顶堆，在插入新元素后，无法删除元素使得堆仍然满足条件
2. 维护一个大小为 K 的大顶堆，插入新元素后，如果堆大小超过 K，则删除堆顶元素，剩下的堆仍然满足当前输入数组的最小 K 个数字
3. PriorityQueue 默认是小顶堆，应该重写 `compare` 方法来实现大顶堆

```java
public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
    ArrayList<Integer> list = new ArrayList<Integer>();
    if (k == 0 || k > input.length)
        return list;
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, (o1, o2) -> o2 - o1);
    for (Integer item : input) {
        maxHeap.offer(item);
        if (maxHeap.size() > k)
            maxHeap.poll();
    }
    list.addAll(maxHeap);
    return list;
}
/* Tips：大顶堆 */
PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
   @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1;
    }
});
```

## 30. [连续子数组的最大和](https://www.nowcoder.com/practice/459bd355da1549fa8a49e350bf3df484?tpId=13&tqId=11183&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

**数组 && 滑动窗口**

1. `sum` 记录连续数组元素的和，`res` 记录 `array[i]` 的最大和
2. 每累加一个元素后，更新 `res` 值
3. 如果累加一个元素后 `sum` 值为负数，则后面的累加只会让 `sum` 值更小，令此时 `sum = 0`

```java
public int FindGreatestSumOfSubArray(int[] array) {
    int sum = 0;
    int res = Integer.MIN_VALUE;
    for (Integer item : array) {
        sum += item;
        res = Math.max(res, sum);
        if (sum <= 0) 
            sum = 0;
    }
    return res;
}
```

## 31. [从 1 到 n 整数中 1 出现的次数](https://www.nowcoder.com/practice/bd7f978302044eee894445e244c7eee6?tpId=13&tqId=11184&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

1. 归纳总结
2. 如果计算百位上 1 出现的次数：百位上的数字，百位以下的数字，百位以上的数字
3. 如果百位上的数字为 0，百位上可能出现 1 的次数由更高位决定，为高位 * 当前位
4. 如果百位上数字为 1，百位上可能出现 1 的次数由高位和低位决定，为高位 * 当前位 + 低位 + 1
5. 如果百位上数字大于 1，则百位上出现 1 的情况仅由更高位决定，为（高位 + 1）* 当前位

```java
/* 公式推导 */
public int NumberOf1Between1AndN_Solution(int n) {
    int count = 0, i = 1, high = 0, current = 0, low = 0;
    while ((n / i) != 0) {
        high = (n / i) % 10;
        low = n / (i * 10);
        current = n - (n / i) * i;
        if (high == 0)
            count += low * i;
        else if (high == 1)
            count += low * i + current + 1;
        else
            count += (low + 1) * i;
        i *= 10;
    }
    return count;
}
/* 暴力解法 */
public int NumberOf1Between1AndN_Solution(int n) {
    int count = 0;
    StringBuffer s = new StringBuffer();
    for (int i = 0; i < n + 1; i++) 
        s.append(i);
    for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == '1')
            count++;
    }
    return count;
}
```

## 32. [把数组排成最小的数](https://www.nowcoder.com/practice/8fecd3f8ba334add803bf2a06af1b993?tpId=13&tqId=11185&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

**数组 && 重写比较器**

1. 比较 S1+S2 和 S2+S1，小的排前面，重写比较器，将数组排序

2. **Collections.sort：** `o1` 小于`o2`，返回负数，升序排列；`o1` 小于`o2`，返回正数，升序排列

   ```java
   Collections.sort(List, (o1, o2) -> o1.compareTo(o2));
   Collections.sort(List, (o1, o2) -> o2.compareTo(o1));
   ```

3. **Arrays.sort：**`o1` 小于`o2`，返回负数，升序排列；`o1` 小于`o2`，返回正数，升序排列

   ```java
   Arrays.sort(T[], (o1, o2) -> o1.compareTo(o2));
   Arrays.sort(T[], (o1, o2) -> o2.compareTo(o1));
   ```

```java
/* 排序比较 */
public String PrintMinNumber(int[] numbers) {
    String res = "";
    if (numbers.length == 0)
        return res;
    int n = numbers.length;
    String[] str = new String[n];
    for (int i = 0; i < n; i++) {
        str[i] = numbers[i] + "";
    }
    Arrays.sort(str, (o1, o2) -> (o1 + "" + o2).compareTo(o2 + "" + o1));
    for (String item : str)
        res += item;
    return res;
}
```

## 33. [丑数](https://www.nowcoder.com/practice/6aa9e04fc3794f68acf8778237ba065b?tpId=13&tqId=11186&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

1. 丑数的定义：`P=2^x*3^y*5^z`

2. 暴力求解：

   1. 维护一个小顶堆，由于 1 是最小的丑数，则堆的初始为 {2，3，5} 
   2. 每次移除堆顶元素为下一个丑数，同时添加 `2 * minHeap.peek()`、`3 * minHeap.peek()`、`5 * minHeap.peek()`
   3. 直到取得第 N 个元素

3. 动态规划

   1. 维护三个数组（同一个数组的三个指针）分别是 2、3、5 三个指向 P2，P3，P5，用`|`表示

   2. 下一个丑数为三个中最小的 P，先在数组中添加 2P、3P、5P，元素，再将 P 的索引加 1

   3. 直到取得第 N 个元素

      ```java
           丑数 1
           队列：|2
                |3
                |5
           丑数 1，2
           队列：2，|4
                |3，6
                |5，10
           丑数 1，2，3
           队列：2，|4，6
                3，|6，9
               |5，10，15
      ```

```java
/* 维护一个数组的三个指针 */
public int GetUglyNumber_Solution(int index) {
    if (index <= 6)	return index;
    int[] dp = new int[index];
    dp[0] = 1;
    int p2 = 0, p3 = 0, p5 = 0;
    for (int i = 1; i < index; i++) {
        int val2 = dp[p2] * 2;
        int val3 = dp[p3] * 3;
        int val5 = dp[p5] * 5;
        dp[i] = Math.min(val2, Math.min(val3, val5));
        if (dp[i] == val2)	p2++;
        if (dp[i] == val3)	p3++;
        if (dp[i] == val5)	p5++;
    }
    return dp[index - 1];
}
/* 分别维护三个链表 */
public int GetUglyNumber_Solution(int index) {
    if (index <= 6) {
        return index;
    }
    int[] ret = new int[index];
    ArrayList<Integer> list2 = new ArrayList<>();
    ArrayList<Integer> list3 = new ArrayList<>();
    ArrayList<Integer> list5 = new ArrayList<>();
    ret[0] = 1;
    list2.add(2);
    list3.add(3);
    list5.add(5);
    for (int i = 1; i < index; i++) {
        int next2 = list2.get(0);
        int next3 = list3.get(0);
        int next5 = list5.get(0);
        ret[i] = Math.min(next2, Math.min(next3, next5));
        if (ret[i] == next2) {
            list2.remove(0);
        }
        if (ret[i] == next3) {
            list3.remove(0);
        }
        if (ret[i] == next5) {
            list5.remove(0);
        }
        list2.add(ret[i] * 2);
        list3.add(ret[i] * 3);
        list5.add(ret[i] * 5);
    }
    return ret[index - 1];
}
```

## 34. [第一个只出现一次的字符](https://www.nowcoder.com/practice/1c82e8cf713b4bbeb2a5b31cf5b0417c?tpId=13&tqId=11187&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

**字符串**

1. 统计字符出现的次数
2. 遍历字符串，如果字符出现的次数为 1，则返回字符

```java
public int FirstNotRepeatingChar(String str) {
    if (str == null || str.length() == 0)	return -1;
    HashMap<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < str.length(); i++) {
        int count = map.getOrDefault(str.charAt(i), 0);
        map.put(str.charAt(i), ++count);
    }
    for (int i = 0; i < str.length(); i++) {
        if (map.get(str.charAt(i)) == 1)	return i;
        else	continue;
    }
    return -1;
}
```

## 35. [数组中的逆序对](https://www.nowcoder.com/practice/96bd6684e04a44eb80e6a68efc0ec6c5?tpId=13&tqId=11188&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

**归并排序**

1. 归并排序的改进
2. 归并比较大小过程中，如果前面 i 位置大于后面 j 位置，则当前逆序对为 `m - i + 1`

```java
private long count = 0;
private int[] copy;
public int InversePairs(int[] array) {
    copy = new int[array.length];
    mergeSort(array, 0, array.length - 1);
    return (int) (count % 1000000007);
}
private void mergeSort(int[] arr, int l, int h) {
    if (l >= h)
        return;
    int mid = l + (h - l) / 2;
    mergeSort(arr, l, mid);
    mergeSort(arr, mid + 1, h);
    merge(arr, l, mid, h);
}
private void merge(int[] arr, int l , int m, int h) {
    int i = l;
    int j = m + 1;
    for (int k = l; k <= h; k++)
        copy[k] = arr[k];
    for (int k = l; k <= h; k++) {
        if (i > m)
            arr[k] = copy[j++];
        else if (j > h)
            arr[k] = copy[i++];
        else if (copy[i] < arr[j])
            arr[k] = copy[i++];
        else {
            arr[k] = copy[j++];
            count += m - i + 1;
        }
    }
}
```

## 36. [两个链表的第一个公共节点](https://www.nowcoder.com/practice/6ab1d9a29e88450685099d45c9e31e46?tpId=13&tqId=11189&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

**链表**

1. 两个链表 p1 和 p2 同时走
2. p1 走到末尾 `NULL` 节点时，再从 p2 的头开始走
3. p2 走到末尾 `NULL`节点时，再从 p1 的头开始走
4. p1 和 p2 在链表的第一个公共节点相遇

```java
public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
    if (pHead1 == null || pHead2 == null)	return null;
    ListNode p1 = pHead1;
    ListNode p2 = pHead2;
    while (p1 != p2) {
        p1 = p1 == null ? pHead2 : p1.next;
        p2 = p2 == null ? pHead1 : p2.next;
    }
    return p1;
}
```

## 37. [数字在排序数组中出现的次数](https://www.nowcoder.com/practice/70610bf967994b22bb1c26f9ae901fa2?tpId=13&tqId=11190&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

**数组 && 二分查找**

1. 找到 K 要插入的位置

2. 找到 K + 1 要插入的位置

3. 两者相减

4. `Tips:`重复数字的二分查找

   1. 非重复数字的二分查找，`==` 直接 `return mid`
   2. 重复数字的二分查找，`==` 时，如果返回最左边的元素 `right = mid`，如果返回最右边的元素 `left = mid`

5. 二分查找：左闭右开区间 `[0, length)`

   ```java
   private int binSearch(int[] arr, int target) {
       int left = 0;
       int right = arr.length;
       while (left < right) {
           int mid = left + (right - left) / 2;
           if (arr[mid] >= target)	right = mid;
           else	left = mid + 1;
       }
       return left;
   }
   ```

```java
public int GetNumberOfK(int [] array , int k) {
    if (array == null || array.length == 0)	return 0;
    int left = binSearch(array, k);
    int right = binSearch(array, k + 1);
    if (left == array.length || array[left] != k)	return 0;
    else	return right - left;
}
private int binSearch(int[] arr, int target) {
    int left = 0;
    int right = arr.length;
    while (left < right) {
        int mid = left + (right - left) / 2;
        if (arr[mid] >= target)	right = mid;
        else	left = mid + 1;
    }
    return left;
}
```

## 38. [二叉树的深度](https://www.nowcoder.com/practice/435fb86331474282a3499955f0a41e8b?tpId=13&tqId=11191&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

**二叉树 && 递归**

1. 递归终止条件：如果节点为 NULL，返回 0
2. 递归求左子树的高度和右子树的高度，`High = Max(leftHigh, rightHigh) + 1`

```java
public int TreeDepth(TreeNode root) {
    if (root == null)
        return 0;
    int left = TreeDepth(root.left);
    int right = TreeDepth(root.right);
    return Math.max(left, right) + 1;
}
```

## 39. [平衡二叉树](https://www.nowcoder.com/practice/8b3b95850edb4115918ecebdf1b4d222?tpId=13&tqId=11192&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

**二叉树 && 递归**

1. 平衡二叉树：左右子树的节点高度差不超过 1
2. 空树为平衡二叉树
3. 左右子树高度差超过 1 为非平衡二叉树

```java
public boolean IsBalanced_Solution(TreeNode root) {
    if (root == null)
        return true;
    int leftHigh = TreeDepth(root.left);
    int rightHigh = TreeDepth(root.right);
    if (Math.abs(leftHigh - rightHigh) > 1)
        return false;
    return IsBalanced_Solution(root.left) & IsBalanced_Solution(root.right);
}
public int TreeDepth(TreeNode root) {
    if (root == null)
        return 0;
    int left = TreeDepth(root.left);
    int right = TreeDepth(root.right);
    return Math.max(left, right) + 1;
}
```

## 40. [数组中只出现一次的数字](https://www.nowcoder.com/practice/e02fdb54d7524710a7d664d082bb7811?tpId=13&tqId=11193&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

**数组**

1. HashMap 统计数组中数字出现的次数
2. 遍历数组，如果出现次数为奇数，则保存

```java
public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < array.length; i++) {
        if (map.containsKey(array[i])) 
            map.put(array[i], ++(map.get(array[i])));
        else 
            map.put(array[i], 1);
    }
    boolean flag = false;
    for (int i = 0; i < array.length; i++) {
        if (map.get(array[i]) % 2 == 1) {
            if (!flag) {
                num1[0] = array[i];
                flag = true;
            } else
                num2[0] = array[i];
        }
    }
}
```

## 41. [和为 S 的连续正数序列](https://www.nowcoder.com/practice/c451a3fd84b64cb19485dad758a55ebe?tpId=13&tqId=11194&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

**数组 && 滑动窗口 && 链表**

1. 链表：维护一个链表，当链表和大于 sum，就不断删除链表头元素，直到链表和小于等于 sum
2. 双指针：totalSum 为 `start` 指针到当前 i 元素的和，如果和大于 sum，`start` 不短向前移动，直到和小于 sum；当 totalSum == sum 时，遍历 `start` 到当前元素 i，添加到链表中 

```java
/* 链表实现滑动窗口 */
public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    ArrayList<Integer> list = new ArrayList<>();
    if (sum <= 1)	return res;
    int curSum = 0;
    for (int i = 1; i < sum; i++) {
        curSum += i;
        list.add(i);
        while (curSum > sum) {
            curSum -= list.get(0);
            list.remove(0);
        }
        if (curSum == sum) {
            res.add(new ArrayList(list));
        }
    }
    return res;
}
/* 双指针实现滑动窗口 */
public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    if (sum <= 1)	return res;
    int start = 1, curSum = 0;
    for (int i = 0; i < sum; i++) {
        curSum += i;
        while (curSum > sum) {
            curSum -= start;
            start--;
        }
        if (curSum == sum) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = start; j <= i; j++)	list.add(i);
            res.add(list);
        }
    }
    return res;
}
```

## 42. [和为 S 的两个数](https://www.nowcoder.com/practice/390da4f7a00f44bea7c2f3d19491311b?tpId=13&tqId=11195&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

**数组 && 二分查找 && 双指针**

1. 二分查找
   1. 遍历数组，依次取得第一个数 A
   2. 二分查找剩下元素中是否存在 `S - A`
   3. 存在多组数据则输出乘积最小的，此处利用数学方法，和相等，差值越大的两个数乘积越小，因此找到的第一组数据就是所求结果
2. 双指针
   1. low 指针为最左边，high 指针为最右边，totalSum 记录两个指针指向的数组数字和
   2. 如果 totalSum 比 sum 小，则 low 左移；如果 totalSum 比 sum 大，则 high 右移

```java
/* 双指针 */
public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
    ArrayList<Integer> list = new ArrayList<Integer>();
    if (array == null)
        return list;
    int low = 0;
    int high = array.length - 1;
    while (low < high) {
        int totalSum = array[low] + array[high];
        if (totalSum < sum)
            low++;
        else if (totalSum > sum)
            high--;
        else {
            list.add(array[low]);
            list.add(array[high]);
            break;
        }
    }
    return list;
}
/* 二分查找 */
public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
    ArrayList<Integer> list = new ArrayList<Integer>();
    if (array == null)
        return list;
    for (int i = 0; i < array.length - 1; i++) {
        int res = BinaySearch(array, i + 1, array.length, sum - array[i]);
        if (array[res] != (sum - array[i])) {
            continue;
        } else {
            list.add(array[i]);
            list.add(array[res]);
            break;
        } 
    }
    return list;
}
private int BinaySearch(int[] array, int low, int high, int target) {
    while (low < high) {
        int mid = low + (high - low) / 2;
        if (target > array[mid]) 
            low = mid + 1;
        else
            high = mid;
    }
    return low;
}
```

**[三数之和为 0](<https://leetcode-cn.com/problems/3sum/>)**

```java
public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> resList = new ArrayList<>();
    if (nums == null || nums.length == 0)	return resList;
    // 排序去重
    Arrays.sort(nums);
    for (int i = 0; i < nums.length; i++) {
        // 剪枝
        if (nums[i] > 0)	break;
        // 外层去重
        if (i > 0 && nums[i] == nums[i - 1])	continue;
        int start = i + 1, end = nums.length - 1;
        while (start < end) {
            if (nums[i] + nums[start] + nums[end] > 0)	end--;
            else if (nums[i] + nums[start] + nums[end] < 0)	start++;
            else {
                List<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                list.add(nums[start]);
                list.add(nums[end]);
                resList.add(list);
                // 内层去重
                while (start < end && nums[start] == nums[start + 1])	start++;
                while (start < end && nums[end] == nums[end - 1])	end--;
                // 更新直到不重复
                start++;
                end--;
            }
        }
    }
    return resList;
}
```

## 43. [左旋转字符串](https://www.nowcoder.com/practice/12d959b108cb42b1ab72cef4d36af5ec?tpId=13&tqId=11196&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

**字符串 && 递归**

1. 递归
   1. 反转 n 前半部分的字符串，反转 n 后半部分的字符串，得到新的字符串 temp
   2. 反转 temp
2. 模拟循环
   1. 左移次数对数组长度取模，则是最终移动次数 index
   2. 先添加 index 后的元素，再添加 index 前的元素

```java
/* 递归 */
public String LeftRotateString(String str,int n) {
    if (str == null || str.length() == 0)	return "";
    if (n == 0)	return str;
    int length = str.length();
    n = n % length;
    char[] chars = str.toCharArray();
    resver(chars, 0, n - 1);
    resver(chars, n, length - 1);
    resver(chars, 0, length - 1);
    return String.valueOf(chars);
}
private void resver(char[] chars, int start, int end) {
    if (start >= end)	return;
    while (start < end)	swap(chars, start++, end--);
}
private void swap(char[] chars, int i, int j) {
    char temp = chars[i];
    chars[i] = chars[j];
    chars[j] = temp;
}
/* 模拟循环 */
public String LeftRotateString(String str,int n) {
    if (str == null || str.length() == 0)	return "";
    if (n == 0)	return str;
    int length = str.length();
    n = n % length;
    StringBuilder sb = new StringBuilder();
    for (int i = n; i < length; i++)	sb.append(str.charAt(i));
    for (int i = 0; i < n; i++)	sb.append(str.charAt(i));
    return sb.toString();
}
```

## 44. [翻转单词顺序列](https://www.nowcoder.com/practice/3194a4f4cf814f63919d0790578d51f3?tpId=13&tqId=11197&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

1. 不使用额外的空间
2. 先反转每个单词，使用 `start` 和 `end` 来标记每个单词，`end` 走到空格时，反转 `start - end-1`；`end` 走到最后时，反转 `start - end`
3. 再反转整个字符串

```java
public String ReverseSentence(String str) {
    if (str == null || str.length() == 0)	return null;
    char[] chars = str.toCharArray();
    int indexe = 0;
    while (index < chars.length) {
        int start = index;
        int end = index;
        while (chars[end] != ' ' && end < chars.length - 1)	end++;
        if (end < chars.length - 1) {
            reverse (chars, start, end - 1);
            index = end + 1;
        } else {
            reverse (chars, start, end);
            break;
        }
    }
    reverse(chars, 0, chars.length - 1);
    return String.valueOf(chars);
}
private void reverse(char[] chars, int start, int end) {
    if (start >= end)	return;
    while (start < end)	swap(chars, start++, end--);
}
private void swap(char[] chars, int i, int j) {
    char temp = chars[i];
    chars[i] = chars[j];
    chars[j] = temp;
}
```

## 45. [扑克牌顺子](https://www.nowcoder.com/practice/762836f4d43d43ca9deb273b3de8e1f4?tpId=13&tqId=11198&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

**数组**

1. 排序
2. 统计大小王出现次数
3. 大小王补有序数列

```java
public boolean isContinuous(int[] numbers) {
    if (numbers.length < 5) 
        return false;
    Arrays.sort(numbers);
    int count = 0;
    for (int item : numbers)
        if (item == 0)
            count++;
    for (int i = count; i < numbers.length - 1; i++) {
        if (numbers[i + 1] == numbers[i])
            return false;
        else
            count -= (numbers[i + 1] - numbers[i] - 1);
    }
    return count >= 0;
}
```

## 46. [圆圈中最后剩下的数](https://www.nowcoder.com/practice/f78a359491e64a50bce2d89cff857eb6?tpId=13&tqId=11199&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

**数组模拟环 && 链表模拟环**

1. 数组模拟链表
   1. i 为每次可以报数的人的序号，当 i 走到进头时 i 置为 0，i 遍历所有的数组
   2. count 为剩下未删除的人，每出去一个人 count 减 1
   3. step 为报数的人数，step 等于 m 时，标记删除（数组置为 -1）和重置
2. 链表模拟环
   1. count 从 0 开始计数，没间隔 m - 1 删除一个元素
   2. `count = (count + m -1) % list.size()` 模拟环，记录下一个 m - 1 元素在当前链表的位置

```java
public int LastRemaining_Solution(int n, int m) {
    int[] arr = new int[n];
    int i = -1, count = n, step = 0;
    while (count > 0) {
        // 判读尽头
        if (++i == n)	i = 0;
        // 去掉已经出去的
        if (arr[i] == -1)	continue;
        // 判断出去
        if (++step == m) {
            arr[i] = -1;
            step = 0;
            --count;
        }
    }
    return i;
}
/* 链表 */
public int LastRemaining_Solution(int n, int m) {
    if (n < 1 || m < 1)		return -1;
    ArrayList<Integer> list = new ArrayList<Integer>();
    for (int i = 0; i < n; i++)		list.add(i);
    int count = 0;
    while (list.size() > 1) {
        count = (count + m - 1) % list.size();
        list.remove(count);
    }
    return list.size() == 1 ? list.get(0) : -1;
}
```

## 47. [1+2+3+...+n](https://www.nowcoder.com/practice/7a0da8fc483247ff8800059e12d7caf1?tpId=13&tqId=11200&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

**递归**

1. `&&` 具有短路原则，即在第一个条件语句为 false 的情况下不会去执行第二个条件语句
2. 递归终止条件取非作为 `&&` 的第一个语句，递归的主体转换作为第二个条件语句
3. 当递归的返回条件为 true 的情况下就不会执行递归的主体部分，递归返回

```java
public int Sum_Solution(int n) {
    int sum = n;
    boolean b = (n > 0) && ((sum += Sum_Solution(n - 1)) > 0);
    return sum;
}
```

## 48. [不用加减乘除做加法](https://www.nowcoder.com/practice/59ac416b4b944300b617d4f7f111b215?tpId=13&tqId=11201&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

**位运算**

```java
public int Add(int num1, int num2) {
    return num2 == 0 ? num1 : Add(num1 ^ num2, (num1 & num2) << 1);
}
```

## 49. [字符串转换成整数](https://www.nowcoder.com/practice/1277c681251b4372bdef344468e4f26e?tpId=13&tqId=11202&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

**字符串**

```java
public int StrToInt(String str) {
    if (str == null || str.length() == 0)
        return 0;
    int ret = 0;
    for (int i = 0; i < str.length(); i++) {
        char c = str.charAt(i);
        if (i == 0 && (c == '-' || c == '+'))
            continue;
        if (c < '0' || c > '9')
            return 0;
        ret = ret * 10 + (c - '0');
    }
    return str.charAt(0) == '-' ? -ret : ret;
}
```

## 50. [数组中重复的数字](https://www.nowcoder.com/practice/623a5ac0ea5b4e5f95552655361ae0a8?tpId=13&tqId=11203&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

**数组**

1. HashSet

2. 辅助数组记录

   1. 新开一个长为 length 的数组 arr，遍历 numbers，将数组中的数字作为索引在 arr 中实时统计数字出现的次数
   2. 如果出现的次数等于 2，则表示此数字重复

3. 调整交换位置

   1. O(N) + O(1)

   2. 将值为 i 的元素调整到第 i 个位置上，若该位置有数字，则说明重复

      ```java
      [0]: 2 3 1 0 2 5 3
      [1]: 1 3 2 0 2 5 3	// 2->[2]
      [2]: 1 0 2 3 2 5 3	// 3->[3]
      [3]: 1 0 2 3 2 5 3	// 2==[2]
      [4]: 1 0 2 3 2 5 3	// 3==[3]
      [5]: 1 0 2 3 2 5 3	// 2->[2]X，2 重复
      ```

```java
/* HashSet */
public boolean duplicate(int[] numbers,int length,int [] duplication) {
    HashSet<Integer> set = new HashSet<>();
    for (int i = 0; i < length; i++) {
        if(set.add(numbers[i]))
            continue;
        else {
            duplication[0] = numbers[i];
            return true;
        }
    }
    return false;
}
/* 辅助数组 */
public boolean duplicate(int[] numbers,int length,int[] duplication) {
    if (numbers == null || numbers.length == 0)
        return false;
    int[] arr = new int[length];
    duplication[0] = -1;
    for (int i = 0; i < length; i++) {
        if (++arr[numbers[i]] == 2) {
            duplication[0] = numbers[i];
            break;
        }
    }
    return duplication[0] != -1;
}
/* 调整交换 */
public boolean duplicate(int[] numbers,int length,int[] duplication) {
    if (numbers == null || numbers.length == 0)
        return false;
    int i = 0;
    while (numbers[i] != i && i < length) {
        if (numbers[i] == numbers[numbers[i]]) {
            duplication[0] = numbers[i];
            return true;
        }
        swap(numbers, i, numbers[i]);
    }
    return false;
}
private void swap(int[] arr, int i, int j) {
    int t = arr[i];
    arr[i] = arr[j];
    arr[j] = t;
}
```

## 51. [构建乘积数组](https://www.nowcoder.com/practice/94a4d381a68b47b7a8bed86f2975db46?tpId=13&tqId=11204&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

**数组**

1. 不包含 A[i]
2. 从左向右累乘，从右向左累乘

```java
public int[] multiply(int[] A) {
    int n = A.lenght;
    int[] B = new int[n];
    for (int i = 0, product = 1; i < n; product *= A[i], i++)
        B[i] = product;
    for (int i = n -1, product = 1; i >= 0; product *= A[i], i--)
        B[i] *= product;
    return B;
}
```

## 52. [正则表达式匹配](https://www.nowcoder.com/practice/45327ae22b7b413ea21df13ee7d6429c?tpId=13&tqId=11205&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

**动态规划**

1. 基本思想：从前向后，维护两个指针（一个指针遍历 S，一个指针遍历 P，并不断判断当前两指针的子串是否匹配）。利用一个 `boolean[s.length+1][p.length+1]` 来表示，`dp[i][j]` 表示，若 S 的子串 `[0, i-1]` 和 P 的子串 `[0, j-1]` 相匹配为 `true`，不匹配则为 `false`，以下表中 `dp[4][3] = 1`为例子，表示 `aa` 和 `ab*a` 相匹配。由于 `dp[0][0]` 表示 P 和 S 均为空串，则 `P[i - 1]` 表示当前字符
2. 填充数组第一行：S 为空串，若要匹配
   1. P 为空串
   2. P 为 `x*y*` 形式， `P[i - 1] == *` 时，`dp[0][i] = dp[0][i - 2]`
3. 填充剩下的部分：每次 S 字符往下走一个字符，然后和所有的 P 子串匹配
   1. `P[i - 1] != *`：P 和 S 的字符相等，或者 P 的字符为 `.`
   2. `P[i - 1] == *`：[1] `*` 代表空串 [2] `*` 代表对前一个字符串的复制（0 或多个）
4. 动态规划表
    | S\P  |   ""    |    a    |    b    |    *    |    a    |    c    |    *    |    a    |
    | :--: | :-----: | :-----: | :-----: | :-----: | :-----: | :-----: | :-----: | :-----: |
    |  ""  | ***1*** |    0    |    0    |    0    |    0    |    0    |    0    |    0    |
    |  a   |    0    | ***1*** | ***0*** | ***1*** |    0    |    0    |    0    |    0    |
    |  a   |    0    |    0    |    0    |    0    | ***1*** | ***0*** | ***1*** |    0    |
    |  a   |    0    |    0    |    0    |    0    |    0    |    0    |    0    | ***1*** |

```java
public boolean match(char[] str, char[] pattern) {
    int m = str.length;
    int n = pattern.length;
    boolean[][] dp = new boolean[m + 1][n + 1];
    dp[0][0] = true;
    for (int i = 1; i <= n; i++)
        if (pattern[i - 1] == '*')
            dp[0][i] = dp[0][i - 2];

    for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
            if (str[i - 1] == pattern[j - 1] || pattern[j - 1] == '.') {
                dp[i][j] = dp[i - 1][j - 1];
            } else if (pattern[j - 1] == '*'){
                if (pattern[j - 2] == str[i - 1] || pattern[j - 2] == '.') {
                    // 匹配 0 个
                    dp[i][j] |= dp[i][j - 2];
                    // 匹配 1 个
                    dp[i][j] |= dp[i][j - 1];
                    // 匹配多个
                    dp[i][j] |= dp[i - 1][j];
                } else {
                    // 仅仅匹配 0 个
                    dp[i][j] = dp[i][j - 2];
                }
            }
        }
    }
    return dp[m][n];
}
```

## 53. [表示数值的字符串](https://www.nowcoder.com/practice/6f8c901d091949a5837e24bb82a731f2?tpId=13&tqId=11206&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

**正则表达式**

1. `()`标记一个子表达式的开始和结束位置，分组
2. `*` 匹配前面的子表达式零次或者多次
3. `+` 匹配前面的子表达式一次或者多次
4. `?` 匹配前面的子表达式零次或者一次
5. `[]` 字符集合
6. `\\.` 转义后
7. `\\d` 数字

```java
public boolean isNumeric(char[] str) {
    if (str == null || str.length == 0) {
        return false;
    }
    return new String(str).matches("[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?");
}
```

## 54. [字符流中第一个不重复的字符](https://www.nowcoder.com/practice/00de97733b8e4f97a3fb5c680ee10720?tpId=13&tqId=11207&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

**字符串 && 栈和队列**

1. int[256] 标记字符出现的次数
2. Queue 将输入流的字符入队
3. 当队头元素出现重复时，一直出队，直到队头元素不重复
4. 队列为空，无不重复字符；队列不为空，输出队头

```java
private Queue<Character> queue = new LinkedList<Character>();
int[] arr = new int[256]; 
public void Insert(char ch) {
    ++arr[ch];
    queue.add(ch);
    while (!queue.isEmpty() && arr[queue.peek()] > 1) {
        queue.remove();
    }
}
public char FirstAppearingOnce() {
    return queue.isEmpty() ? '#' : queue.peek();
}
```

## 55. [链表中环的入口节点](https://www.nowcoder.com/practice/253d2c59ec3e4bc68da16833f79a38e4?tpId=13&tqId=11208&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

**快慢指针**

1. fast 指针一次 2 个节点，slow 指针一次 1 个节点

2. 链表环前面部分为 x， fast 与 slow 相遇在 z，x 与 z 之间的是 y

3. 由于 fast 是 slow 的两倍，则 fast 走过一圈半，slow 走不到一圈相遇

4. fast 走过：x+y+z+y；slow 走过的 x+y

5. x+y+z+y = 2(x+y)  => x=z

6. 相遇后，slow 接着走，fast 从头开始走，两者在环入口处再次相遇

   ```java
   1->2->3->4->5->6->4	: 4 为环的第一个节点，假设快慢指针在 4 相遇
   x: {1,2,3}  z: {4,5,6}  y:{4}
   ```

```java
// 更加严谨：判断链表是否有环，如果有环则给出环的入口节点
public ListNode EntryNodeOfLoop(ListNode pHead) {
    if (pHead == null || pHead.next == null)	return null;
    ListNode p1 = pHead, p2 = pHead;
    while (p2 != null && p2.next != null) {
        p1 = p1.next;
        p2 = p2.next.next;
        if (p1 == p2)	break;
    }
    if (p2 == null || p2.next == null)	return null;
    p2 = pHead;
    while (p1 != p2) {
        p1 = p1.next;
        p2 = p2.next;
    }
    return p1;
}
```

## 56. [删除链表的重复节点](https://www.nowcoder.com/practice/fc533c45b73a41b0b44ccba763f866ef?tpId=13&tqId=11209&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

**链表 && 递归 && 双指针**

1. 递归
   1. 0 || 1 个节点，直接返回
   2. 当前节点重复节点，while 删除，然后从第一个与当前节点不同的节点开始递归
   3. 当前节点不是重复节点，保留节点递归
2. 快慢指针
   1. 新建一个 `newHead.next = pHead`
   2. 快指针 `fast = pHead`，慢指针 `slow = newHead`
   3. 首先判断 `fast != null && fast.next != null`，满足条件进入循环
   4. 如果当前节点不重复，`fast` 和 `slow` 依次向前平移
   5. 如果当前节点重复，即 `fast.val = fast.next.val`，记录 `value = fast.val`，与 `value` 相等的节点，全部删除，再移动 `slow`

```java
/* 递归 */
public ListNode deleteDuplication(ListNode pHead) {
    if (pHead == null || pHead.next == null)	return pHead;
    if (pHead.val == pHead.next.val) {
        ListNode node = pHead.next;
        while (node != null && node.val == pHead.val)	node = node.next;
        return deleteDuplication(node);
    } else {
        pHead.next = deleteDuplication(pHead.next);
        return pHead;
    }
}
/* 快慢指针 */
public ListNode deleteDuplication(ListNode pHead) {
    ListNode newHead = new ListNode(-1);
    newHead.next = pHead;
    ListNode slow = newHead;
    ListNode fast = pHead;
    while(fast != null && fast.next != null) {
        if (fast.val == fast.next.val) {
            int value = fast.val;
            while(fast != null && fast.val == value) 
                fast = fast.next;
            slow.next = fast;
        } else {
            slow = fast;
            fast = fast.next;
        }
    }
    return newHead.next;
}
```

**[删除链表的重复节点仅保留一个](<https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/submissions/>)**

```java
public ListNode deleteDuplicates(ListNode head) {
    if (head == null || head.next == null)	return head;
    if (head.val == head.next.val) {
        ListNode node = head.next;
        while (node != null && node.next != null && node.next.val == head.val)	node = node.next;
        return deleteDuplicates(node);
    } else {
        head.next = deleteDuplicates(head.next);
        return head;
    }
}
```

## 57. [二叉树的下一个节点](https://www.nowcoder.com/practice/9023a0c988684a53960365b889ceaf5e?tpId=13&tqId=11210&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

**二叉树**

1. 中序遍历中下一个节点出现的情况
2. 当前节点为叶节点
   1. 如果为 **root** 节点，直接返回 **null**
   2. 如果当前节点在**左叶子**节点，出现在**父节点**
   3. 如果当前节点在**右叶子**节点，向上遍历父节点，直到**父节点为左节点**
3. 当前节点围殴 root 节点
   1. **右节点存在**，沿着**右节点的左节点**一直寻找，直到**叶子节点**
   2. **右节点不存在**，向上遍历父节点，直到**父节点为左节点**
4. 总结
   1. 右子树不为空时，沿着右子树的左节点一直寻找，直到找到叶子节点
   2. 右子树为空时，向上遍历父节点，直到父节点为左节点，输出父节点

```java
public TreeLinkNode GetNext(TreeLinkedNode pNode) {
    if (pNode.right == null) {
        while(pNode.next != null) {
            if (pNode.next.left == pNode)
                return pNode.next;
            else
                pNode = pNode.next;
        }
    } else {
        TreeLinkNode node = pNode.right;
        while(node.left != null)
            node = node.left;
        return node;
    }
    return null;
}
```

## 58. [对称二叉树](https://www.nowcoder.com/practice/ff05d44dfdb04e1d83bdbdab320efbcb?tpId=13&tqId=11211&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

**二叉树 && 递归**

1. pRoot 的左子树 left 和右子树 right
2. left 的右子树 == right 的左子树 && left 的左子树 == right 的右子树，不断递归
3. 递归终止条件：左右子树均为空，返回 true；其他均返回 false

```java
boolean isSymmetrical(TreeNode pRoot) {
    if (pRoot == null || (pRoot.left == null && pRoot.right == null))
        return true;
    return doIsSymmetrical(pRoot.left, pRoot.right);
}
private boolean doIsSymmetrical(TreeNode left, TreeNode right) {
    if (left == null && right == null)
        return true;
    if (left != null && right != null && left.val == right.val)
        return doIsSymmetrical(left.left, right.right) 
        && doIsSymmetrical(left.right, right.left);
    return false;
}
```

## 59. [之字形打印二叉树](https://www.nowcoder.com/practice/91b69814117f4e8097390d107d2efbe0?tpId=13&tqId=11212&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

**二叉树 && 栈和队列**

1. 利用 `Queue` 进行层序遍历
2. 奇数行`List` 直接添加到 `resList`
3. 偶数行 `List` 反转后再添加到 `resList`

```java
public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    if (pRoot == null)	return res;
    queue.add(pRoot);
    boolean reverse = false;
    while (!queue.isEmpty()) {
        ArrayList<Integer> list = new ArrayList<>();
        int size = queue.size();
        while(size-- > 0) {
            TreeNode node = queue.remove();
            list.add(node.val);
            if (node.left != null)	queue.add(node.left);
            if (node.right != null)	queue.add(node.right);
        }
        if (list.size() != 0) {
            if (reverse) 	Collections.reverse(list);
            res.add(list);
            reverse = !reverse;
        }
    }
    return res;
}
```

## 60. [二叉树打印成多行](https://www.nowcoder.com/practice/445c44d982d04483b04a54f298796288?tpId=13&tqId=11213&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

**二叉树 && 栈和队列**

```java
ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    if (pRoot == null)	return res;
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.add(pRoot);
    while (!queue.isEmpty()) {
        ArrayList<Integer> list = new ArrayList<>();
        int size = queue.size();
        while (size-- > 0) {
            TreeNode node = queue.remove();
            list.add(node.val);
            if (node.left != null)	queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        if (list.size() != 0)	res.add(list);
    }
    return res;
}
```

## 61. [序列化二叉树](https://www.nowcoder.com/practice/cf7e25aa97c04cc1a68c8f040e71fb84?tpId=13&tqId=11214&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

**二叉树 && 递归 && 字符串**

1. 序列化：二叉树前序遍历，遇到 `Null` 补上 `#`，数字之间用 `!` 分割
2. 反序列化
   1. 将序列化后得到的字符串直接分割成字符数组
   2. 全局变量 index 用于在数组索引
   3. 如果 index 指向的索引为 `#`，则返回 `NULL`，否则按照前序遍历重建二叉树
3. Tips：`substring(int beginIndex, int endIndex)` 返回字符串的字串

```java
private StringBuffer stringbuffer = new StringBuffer();
public String Serialize(TreeNode root) {
    preOrder(root);
    return stringbuffer.toString();
}
private void preOrder(TreeNode node) {
    if (node == null)
        stringbuffer.append("#").append("!");
    else {
        stringbuffer.append(node.val).append("!");
        preOrder(node.left);
        preOrder(node.right);
    }
}
private int index = -1;
public TreeNode Deserialize(String str) {
    return Deserialize(str.split("!"));
}
private TreeNode Deserialize(String[] dStr) {
    index++;
    if (dStr[index].equals("#")){
        return null;
    } else {
        TreeNode node = new TreeNode(Integer.valueOf(dStr[index]));
        node.left = Deserialize(dStr);
        node.right = Deserialize(dStr);
        return node;
    }
}
```

## 62. [二叉搜索树的第 K 个节点](https://www.nowcoder.com/practice/ef068f602dde4d28aab2b210e859150a?tpId=13&tqId=11215&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

**二叉树中序非递归遍历**

1. 二叉树的中序遍历是有序数组，中序遍历后找到第 K 个数
   1. 节点不为空，沿着左子树一直压栈，直到节点为空
   2. 节点为空，则出栈（出栈值为从小到大），沿着出栈节点的右子树走一步
   3. 栈为空，节点为空，则结束循环

```java
public TreeNode KthNode(TreeNode pRoot, int k) {
    if (pRoot == null || k <= 0)	return null;
    Stack<TreeNode> stack = new Stack<>();
    int count = 0;
    while (pRoot != null || !stack.isEmpty()) {
        while (pRoot != null) {
            stack.push(pRoot);
            pRoot = pRoot.left;
        }
        pRoot = stack.pop();
        if (--k == 0)	return pRoot;
        pRoot = pRoot.right;
    }
    return null;
}
/* 中序递归 */
private int count = 0;
TreeNode KthNode(TreeNode pRoot, int k) {
    if (pRoot == null)  return null;
    TreeNode left = KthNode(pRoot.left, k);
    if (left !=  null)  return left;
    count++;
    if (count == k)     return pRoot;
    TreeNode right = KthNode(pRoot.right, k);
    if (right != null)  return right;
    return null;
}
```

## 63. [数据流中位数](https://www.nowcoder.com/practice/9be0172896bd43948f8a32fb954e1be1?tpId=13&tqId=11216&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

**数组 && 栈和队列**

1. 小顶堆存储右边元素，大顶堆存储左边元素，并且大顶堆的堆顶小于小顶堆的堆顶
2. 奇数：先放入 maxHeap，然后取出 maxHeap 的堆顶元素放入 minHeap，返回 `minHeap().peek()`
3. 偶数：先放入 minHeap，然后取出 minHeap 的堆定元素放入 maxHeap，返回 `minHeap.peek() + maxHeap.peek() / 2`

```java
private int count = 0;
private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> (o2 - o1));
public void Insert(Integer num) {
    // 计数
    count++;
    if (count % 2 == 1) {
        maxHeap.add(num);
        minHeap.add(maxHeap.remove());
    } else {
        minHeap.add(num);
        maxHeap.add(minHeap.remove());
    }
}

public Double GetMedian() {
    if (count % 2 == 1)	return (double)minHeap.peek();
    else 	return (double)(maxHeap.peek() + minHeap.peek()) / 2;
}
```

## 64. [滑动窗口的最大值](https://www.nowcoder.com/practice/1624bc35a45c42c0bc17d17fa0cba788?tpId=13&tqId=11217&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

- 双端队列：双端队列可以从两端添加删除元素，双端队列存储的是元素下标
  - 新加入的元素 item，与双端队列中的元素对比
  - 小于 item 的，则不可能是滑动窗口的最大值，直接移出队列
  - 大于 item 的，判断元素是否还在窗口内，如果不在了直接移除，在则保留元素
  - 双端队列从大到小存储元素，队首元素就是滑动窗口中的最大值
- 堆：维护一个大小为 size 的大顶堆，窗口滑动一次，左边元素移除堆，右边元素加入堆，返回堆顶元素

```java
/* 双端队列 */
public ArrayList<Integer> maxInWindows(int [] num, int size) {
    ArrayList<Integer> res = new ArrayList<>();
    if (num == null || size < 1 || size > num.length) 	return res;
    LinkedList<Integer> list = new LinkedList<>();
    for (int i = 0; i < size; i++) {
        while (!list.isEmpty() && num[i] > num[list.getLast()]) 	list.removeLast();
        list.add(i);
    }
    res.add(num[list.getFirst()]);
    for (int i = size; i < num.length; i++) {
        while (!list.isEmpty() && num[i] > num[list.getLast()]) 	list.removeLast();
        list.add(i);
        if (i - list.getFirst() + 1 > size) 	list.removeFirst();
        res.add(num[list.getFirst()]);
    }
    return res;
}
/* MaxHeap */
public ArrayList<Integer> maxInWindows(int [] num, int size) {
    ArrayList<Integer> list = new ArrayList<>();
    if (num == null || size <= 0 || size > num.length) 	return list;
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(size, (o1, o2) -> (o2 - o1));
    for (int i = 0; i < size; i++) 	maxHeap.add(num[i]);
    list.add(maxHeap.peek());
    for (int i = size; i < num.length; i++) {
        maxHeap.remove(new Integer(num[i - size]));
        maxHeap.add(num[i]);
        list.add(maxHeap.peek());
    }
    return list;
}
```

## 65. [矩阵中的路径](https://www.nowcoder.com/practice/c61c6999eecb4b8f88a98f66b273a3cc?tpId=13&tqId=11218&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

**回溯法 && 深度优先搜索**

1. `index` 用于索引字符数组中的字符，当 `index` 走到字符数组末尾，则完全匹配成功
2. 递归终止条件：四个边界条件，超出边界返回 false
3. 递归主体：字符未被标记 && 上下左右四个方向，索引前移一个 `index + 1`
4. 递归结束：字符重置为未标记

```java
private int[][] next = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
    if (matrix == null || matrix.length == 0 || str == null || str.length == 0) 	return false;
    boolean[][] marked = new boolean[rows][cols];
    char[][] resMatrix = buildMatrix(matrix, rows, cols);
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            if (resMatrix[i][j] == str[0]) {
                if (dfs(resMatrix, i, j, 0, rows, cols, str, marked))   return true;
            }
        }
    }
    return false;
}
private boolean dfs(char[][] matrix, int i, int j, int index, int rows, int cols, char[] target, boolean[][] marked) {
    if (index == target.length) 	return true;
    if (i < 0 || j < 0 || i >= rows || j >= cols || marked[i][j] 
        || matrix[i][j] != target[index])	return false;
    if (matrix[i][j] == target[index]) {
        // 标记
        marked[i][j] = true;
        // 递归
        for (int[] dir : next) {
            if (dfs(matrix, i + dir[0], j + dir[1], index + 1, rows, 
                    cols, target, marked)) 	return true;
        }
        // 取消标记
        marked[i][j] = false;
        return false;
    }
    return false;
}
private char[][] buildMatrix(char[] matrix, int rows, int cols) {
    char[][] wordMatrix = new char[rows][cols];
    int index = -1;
    for (int i = 0; i < rows; i++)
        for (int j = 0; j < cols; j++)
            wordMatrix[i][j] = matrix[++index];
    return wordMatrix;
}
```

## 66. [机器人的运动范围](https://www.nowcoder.com/practice/6e5207314b5241fb83f2329e89fdecc8?tpId=13&tqId=11219&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

**深度优先搜索**

1. 首先建立机器人运动数组，在建立数组的同时计算出每个方格坐标对应的数字之和
2. 递归终止条件：
   1. 四个边界 && 当前位置被标记 
   2. 先标记当前位置，再判断条件，不符合直接返回
3. 满足条件累加计数，然后四个方向分别递归

```java
private int count = 0;
boolean[][] mark;
private int rows;
private int cols;
private int threshold;
private final static int[][] next = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
public int movingCount(int threshold, int rows, int cols) {
    int[][] matrix = buildSumMatrix(rows, cols);
    this.rows = rows;
    this.cols = cols;
    this.mark = new boolean[rows][cols];
    this.threshold = threshold;
    dfs(matrix, 0, 0);
    return count;
}
private void dfs(int[][] matrix, int row, int col) {
    if (row < 0 || col < 0 || row >= rows || col >= cols || mark[row][col]) 	return;
    mark[row][col] = true;
    if (matrix[row][col] > threshold)	return;
    count++;
    for (int[] item : next) 	dfs(matrix, row + item[0], col + item[1]);
}
private int[][] buildSumMatrix(int rows, int cols) {
    int[] sumOne = new int[Math.max(rows, cols)];
    for (int i = 0; i < sumOne.length; i++) {
        int t = i;
        while (t > 0) {
            sumOne[i] += t % 10;
            t /= 10;
        }
    }
    int[][] sumMatrix = new int[rows][cols];
    for (int i = 0; i < rows; i++)
        for (int j = 0; j < cols; j++)
            sumMatrix[i][j] = sumOne[i] + sumOne[j];
    return sumMatrix;
}
```







