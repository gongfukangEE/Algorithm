## 双指针

[T167. 两数之和 II - 输入有序数组](https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/)

```java
public int[] twoSum(int[] numbers, int target) {
    int[] res = new int[2];
    int n = numbers.length;
    for (int start = 0, end = n - 1; start < n && end >= 0; ) {
        if (numbers[start] + numbers[end] > target)
            end--;
        else if (numbers[start] + numbers[end] < target)
            start++;
        else {
            res[0] = start + 1;
            res[1] = end + 1;
            break;
        }
    }
    return res;
}
```

[T633. 平方数之和](https://leetcode-cn.com/problems/sum-of-square-numbers/)

```java
public boolean judgeSquareSum(int c) {
    int sqrt = (int) Math.sqrt(c);
    for (int start = 0, end = sqrt; start <= sqrt && sqrt >= 0; ) {
        int sum = start * start + end * end;
        if (sum == c)
            return true;
        else if (sum < c)
            start++;
        else
            end--;
    }
    return false;
}
```

[T345. 反转字符串中的元音字母](https://leetcode-cn.com/problems/reverse-vowels-of-a-string/)

```java
private HashSet<Character> set = 
    new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
public String reverseVowels(String s) {
    int i = 0;
    int j = s.length() - 1;
    char[] chars = s.toCharArray();
    while (i <= j) {
        char ci = chars[i];
        char cj = chars[j];
        if (!set.contains(ci))
            chars[i++] = ci;
        else if (!set.contains(cj))
            chars[j--] = cj;
        else {
            chars[i++] = cj;
            chars[j--] = ci;
        }
    }
    return new String(chars);
}
```

[T680 验证回文字符串 II](https://leetcode-cn.com/problems/valid-palindrome-ii/)

```java
public boolean validPalindrome(String s) {
    int start = -1;
    int end = s.length();
    while (++start < --end)
        if (s.charAt(start) != s.charAt(end))
            return isValidPalindrome(s, start, end - 1) 
            || isValidPalindrome(s, start + 1, end);
    return true;
}

private boolean isValidPalindrome(String s, int i, int j) {
    while (i < j)
        if (s.charAt(i++) != s.charAt(j--))
            return false;
    return true;
}
```

[T88 合并两个有序数组](https://leetcode-cn.com/problems/merge-sorted-array/)

```java
public void merge(int[] nums1, int m, int[] nums2, int n) {
    int i = m - 1, j = n - 1;
    int index = m + n - 1;
    while (i >= 0 && j >= 0) {
        int num1 = nums1[i];
        int num2 = nums2[j];
        if (num1 >= num2) {
            nums1[index] = num1;
            i--;
        } else {
            nums1[index] = num2;
            j--;
        }
        index--;
    }
    while (j >= 0)
        nums1[index--] = nums2[j--];
}
```

[T141 判断链表有环](https://leetcode-cn.com/problemset/all/?search=141)

```java
public boolean hasCycle(ListNode head) {
    if (head == null || head.next == null)
        return false;
    ListNode fast = head.next;
    ListNode slow = head;
    while (slow != null && fast != null) {
        if (fast.next == null)
            return false;
        slow = slow.next;
        fast = fast.next.next;
        if (slow == fast)
            return true;
    }
    return false;
}
```

[T524M 通过删除字母匹配到字典里的最长单词](https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting/)

```java
private char[] chars;

public String findLongestWord(String s, List<String> d) {
    String res = "";
    if (s != null && s.length() != 0) {
        chars = s.toCharArray();
        for (String target : d) {
            int resLength = res.length();
            int targetLength = target.length();
            if (resLength > targetLength || (resLength == targetLength 
                                             && res.compareTo(target) < 0))
                continue;
            if (isCommonWord(target.toCharArray()))
                res = target;
        }
    }
    return res;
}

private boolean isCommonWord(char[] dchars) {
    int i = 0, j = 0;
    while (i < chars.length && j < dchars.length) {
        if (chars[i] == dchars[j]) {
            j++;
        }
        i++;
    }
    return j == dchars.length;
}
```

## 排序

## 贪心思想

## 二分查找

## 分治

## 搜索

## 动态规划

## 数学

## 链表

[T160 ]()

## 树

## 栈和队列

## 哈希表

## 字符串

## 数组和矩阵

## 图

## 位运算