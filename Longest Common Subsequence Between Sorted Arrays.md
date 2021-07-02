# Longest Common Subsequence Between Sorted Arrays
###### tags: `LeetCode` `medium`

## 英文題目本身
Given an array of integer  `arrays` where each `arrays[i]` is **sorted** in **strictly increasing** order, return an integer array representing the longest common subsequence between all the arrays.

A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.

 

Example 1:
```
Input: arrays = [[1,3,4],
               [1,4,7,9]]
Output: [1,4]
Explanation: The longest subsequence which in the two arrays is [1,4].
```
Example 2:
```
Input: arrays = [[2,3,6,8],
               [1,2,3,5,6,7,10],
               [2,3,4,6,9]]
Output: [2,3,6]
Explanation: The longest subsequence which in all of the three arrays is [2,3,6].
```
Example 3:
```
Input: arrays = [[1,2,3,4,5],
               [6,7,8]]
Output: []
Explanation: There is no common subsequence between the two arrays.
 
 ```

Constraints:

- `2 <= arrays.length <= 100`
- `1 <= arrays[i].length <= 100`
- `1 <= arrays[i][j] <= 100`
- `arrays[i] is sorted in strictly increasing order.`
## 題目要求
給你一個二維array 裡面的數列都是遞增排序, 回傳list, 裡面存在的數字是在每一個數列都出現過的
## 想法
暴力解, 用map紀錄每個數值的出現次數, 每達到  `arrays.length` 的時候就加到答案裡面
#### 結果
```javascript
class Solution {
    public List<Integer> longestCommomSubsequence(int[][] arrays) {
        // brute force
        int n = arrays.length;
        // use map to count every element #
        Map<Integer, Integer> counts = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for(int[] a : arrays) {
            for(int v : a) {
                counts.put(v, counts.getOrDefault(v, 0) + 1);
                if(counts.get(v) == n) {
                    res.add(v);
                }
            }
        }
        return res;
    }
}
```
