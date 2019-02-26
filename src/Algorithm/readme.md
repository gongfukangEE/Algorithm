# 剑指 Offer 和 LeetCode 题解

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
private HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
    for (int i = 0; i < in.lenght; i++)
        map.put(in[i], i);
    return reConstructBinaryTree(pre, 0, pre.length - 1, 0);
}
public TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int inL) {
    if (preR < preL)
        return null;
    TreeNode root = new TreeNode(pre[preL]);
    int index = map.get(root.val);
    int leftSize = index - inL;
    root.left = reConstructBinaryTree(pre, preL + 1, preL + leftSize, inL);
    root.right = reConstructBinaryTree(pre, preL + leftSize + 1, inL + leftSise + 1);
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

1. mid > right：最小值位于数组右半部分
2. mid < right：最小值位于数组左半部分
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
public ListNode FindKthToTail(ListNode head, int k) {
    if(head == null || k == 0)
        return null;
    ListNode first = head;
    ListNode last = head;
    int count = 1;
    while (last.next != null) {
        last = last.next;
        ++count;
        if (count > k)
            first = first.next;
    }
    if (count < k)
        return null;
    else 
        return first;
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
public boolean HasSubtree(TreeNode root1, TreeNode root2) {
    boolean isSubtree = false;
   if (root1 == null || root2 == null)
       return false;
    if (root1.val == root2.val) 
        isSubtree = HasSubtreeRecursion(root1, root2);
    if (!isSubtree)
        isSubtree = HasSubtreeRecursion(root1.left, root2);
    if (!isSubtree)
        isSubtree = HasSubtreeRecursion(root1.right, root2);
    return isSubtree;
}
private boolean HasSubtreeRecursion(TreeNode root1, TreeNode root2) {
    if (root2 == null) 
        return true;
    if (root1 == null && root2 != null)
        return false;
    if (root1.val != root2.val)
        return false;
    boolean left = HasSubtreeRecursion(root1.left, root2.left);
    boolean right = HasSubtreeRecursion(root1.right, root2.right);
    return left & right;
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
private ArrayList<ArrayList<Integer>> resList = new ArrayList<>();
private ArrayList<Integer> list = new ArrayList<Integer>();
private int sum = 0;
public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
   if (root == null || target == 0)
       return resList;
    doFindPath(root, target);
    return resList;
}
private void doFindPath(TreeNode root, int target) {
    if (root == null || sum > target)
        return;
    int val = root.val;
    list.add(val);
    sum += val;
    if (root.left == null && root.right == null) {
        if (sum == target)
            resList.add(new ArrayList<Integer>(list));
    } else {
        doFindPath(root.left, target);
        doFindPath(root.right, target);
    }
    list.remove((Object) val);
    sum -= val;
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

```java
public ArrayList<String> Permutation(String str) {
    //TODO
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
    int count;
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
/* HashTable */
public int MoreThanHalfNum_Solution(int[] array) {
    Hashtable<Integer, Integer> table = new Hashtable<>();
    for (Integer item : array){
        int count = 1;
        if (table.containsKey(item)) {
            count = table.get(item);
            table.put(item, ++count);
        } else {
            table.put(item, count);
        }
        if (count > array.length / 2)
            return item;
        else
            continue;
    }
    return 0;
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
/* lambda */
PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, (o1, o2) -> o2 - o1);
```

##30. [连续子数组的最大和](https://www.nowcoder.com/practice/459bd355da1549fa8a49e350bf3df484?tpId=13&tqId=11183&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

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

**数组 && 排列组合 && 回溯法**

1. 重写比较器实现自定义排序

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

2. 回溯法

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
    Arrays.sort(str, (o1, o2) -> (o1 + "" + 02).compareTo(o2 + "" + o1));
    for (String item : str)
        res += item;
    return res;
}
/* 回溯法 */
public String PrintMinNumber(int[] numbers) {
    // TODO
}
```

## 33. [丑数](https://www.nowcoder.com/practice/6aa9e04fc3794f68acf8778237ba065b?tpId=13&tqId=11186&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

**动态规划**

// TODO

## 34. [第一个只出现一次的字符](https://www.nowcoder.com/practice/1c82e8cf713b4bbeb2a5b31cf5b0417c?tpId=13&tqId=11187&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

**字符串**

1. 统计字符出现的次数
2. 遍历字符串，如果字符出现的次数为 1，则返回字符

```java
public int FirstNotRepeatingChar(String str) {
    if (str == null || str.length() == 0)
        return -1;
    HashMap<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < str.length(); i++) {
        int val = 0;
        if (map.containsKey(str.charAt(i))) {
            val = map.get(str.charAt(i));
        }
        map.put(str.charAt(i), ++val);
    }
    for (int i = 0; i < str.length(); i++) {
        if (map.get(str.charAt(i)) == 1)
            return i;
    }
    return -1;
}
```

## 35. [数组中的逆序对](https://www.nowcoder.com/practice/96bd6684e04a44eb80e6a68efc0ec6c5?tpId=13&tqId=11188&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

// TODO

## 36. [两个链表的第一个公共节点](https://www.nowcoder.com/practice/6ab1d9a29e88450685099d45c9e31e46?tpId=13&tqId=11189&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

**链表**

1. 两个链表 p1 和 p2 同时走
2. p1 走到末尾时，再从 p2 的头开始走
3. p2 走到末尾时，再从 p1 的头开始走
4. p1 和 p2 在链表的第一个公共节点相遇

```java
public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
    
}
```

## 37. [数字在排序数组中出现的次数](https://www.nowcoder.com/practice/70610bf967994b22bb1c26f9ae901fa2?tpId=13&tqId=11190&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

## 38. [二叉树的深度](https://www.nowcoder.com/practice/435fb86331474282a3499955f0a41e8b?tpId=13&tqId=11191&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

## 39. [平衡二叉树](https://www.nowcoder.com/practice/8b3b95850edb4115918ecebdf1b4d222?tpId=13&tqId=11192&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

## 40. [数组中只出现一次的数字](https://www.nowcoder.com/practice/e02fdb54d7524710a7d664d082bb7811?tpId=13&tqId=11193&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

## 41. [和为 S 的连续正数序列](https://www.nowcoder.com/practice/c451a3fd84b64cb19485dad758a55ebe?tpId=13&tqId=11194&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

## 42. [和为 S 的两个数](https://www.nowcoder.com/practice/390da4f7a00f44bea7c2f3d19491311b?tpId=13&tqId=11195&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

## 43. [左选择字符串](https://www.nowcoder.com/practice/12d959b108cb42b1ab72cef4d36af5ec?tpId=13&tqId=11196&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

## 44. [翻转单词顺序列](https://www.nowcoder.com/practice/3194a4f4cf814f63919d0790578d51f3?tpId=13&tqId=11197&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

## 45. [扑克牌顺子](https://www.nowcoder.com/practice/762836f4d43d43ca9deb273b3de8e1f4?tpId=13&tqId=11198&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

## 46. [圆圈中最后剩下的数](https://www.nowcoder.com/practice/f78a359491e64a50bce2d89cff857eb6?tpId=13&tqId=11199&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

## 47. [1+2+3+...+n](https://www.nowcoder.com/practice/7a0da8fc483247ff8800059e12d7caf1?tpId=13&tqId=11200&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

## 48. [不用加减乘除做加法](https://www.nowcoder.com/practice/59ac416b4b944300b617d4f7f111b215?tpId=13&tqId=11201&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

## 49. [字符串转换成整数](https://www.nowcoder.com/practice/1277c681251b4372bdef344468e4f26e?tpId=13&tqId=11202&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

## 50. [数组中重复的数字](https://www.nowcoder.com/practice/623a5ac0ea5b4e5f95552655361ae0a8?tpId=13&tqId=11203&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

## 51. [构建乘积数组](https://www.nowcoder.com/practice/94a4d381a68b47b7a8bed86f2975db46?tpId=13&tqId=11204&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

## 52. [正则表达式匹配](https://www.nowcoder.com/practice/45327ae22b7b413ea21df13ee7d6429c?tpId=13&tqId=11205&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

## 53. [表示数值的字符串](https://www.nowcoder.com/practice/6f8c901d091949a5837e24bb82a731f2?tpId=13&tqId=11206&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

## 54. [字符流中第一个不重复的字符](https://www.nowcoder.com/practice/00de97733b8e4f97a3fb5c680ee10720?tpId=13&tqId=11207&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

## 55. [链表中环的入口节点](https://www.nowcoder.com/practice/253d2c59ec3e4bc68da16833f79a38e4?tpId=13&tqId=11208&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

## 56. [删除链表的重复节点](https://www.nowcoder.com/practice/fc533c45b73a41b0b44ccba763f866ef?tpId=13&tqId=11209&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

## 57. [二叉树的下一个节点](https://www.nowcoder.com/practice/9023a0c988684a53960365b889ceaf5e?tpId=13&tqId=11210&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

## 58. [对称二叉树](https://www.nowcoder.com/practice/ff05d44dfdb04e1d83bdbdab320efbcb?tpId=13&tqId=11211&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

## 59. [之字形打印二叉树](https://www.nowcoder.com/practice/91b69814117f4e8097390d107d2efbe0?tpId=13&tqId=11212&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

## 60. [二叉树打印成多行](https://www.nowcoder.com/practice/445c44d982d04483b04a54f298796288?tpId=13&tqId=11213&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

## 61. [序列化二叉树](https://www.nowcoder.com/practice/cf7e25aa97c04cc1a68c8f040e71fb84?tpId=13&tqId=11214&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

## 62. [二叉搜索树的第 K 个节点](https://www.nowcoder.com/practice/ef068f602dde4d28aab2b210e859150a?tpId=13&tqId=11215&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

## 63. [数据流中位数](https://www.nowcoder.com/practice/9be0172896bd43948f8a32fb954e1be1?tpId=13&tqId=11216&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

## 64. [滑动窗口的最大值](https://www.nowcoder.com/practice/1624bc35a45c42c0bc17d17fa0cba788?tpId=13&tqId=11217&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

## 65. [矩阵中的路径](https://www.nowcoder.com/practice/c61c6999eecb4b8f88a98f66b273a3cc?tpId=13&tqId=11218&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

## 66. [机器人的运动范围](https://www.nowcoder.com/practice/6e5207314b5241fb83f2329e89fdecc8?tpId=13&tqId=11219&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

# LeetCode





