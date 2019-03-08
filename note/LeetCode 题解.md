# 双指针

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

