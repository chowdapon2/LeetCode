# 243-245 Shortest Word Distance I, II, III
###### tags: `LeetCode` `Easy` `Medium`

## 243. I
Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

Example:

Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
```
Input: word1 = “coding”, word2 = “practice”
Output: 3

Input: word1 = "makes", word2 = "coding"
Output: 1
```
Note:
You may assume that word1 **does not equal** to word2, and word1 and word2 are both in the list.

## 題目要求
給你一個String Array找兩個字最相近的距離為何?

## 想法
暴力解
```java
class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        // brute force
        List<Integer> w1_list = new ArrayList<>();
        List<Integer> w2_list = new ArrayList<>();
        
        for(int i= 0; i<words.length; i++){
            if(words[i].equals(word1)){
                w1_list.add(i);
            }
            if(words[i].equals(word2)){
                w2_list.add(i);
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<w1_list.size(); i++){
            for(int j=0; j<w2_list.size(); j++){
                ans = Math.min(ans, Math.abs(w1_list.get(i)-w2_list.get(j)));
            }
        }
        return ans;
    }
}
```

### 想法 2
官方解 (One-pass)
```java
public int shortestDistance(String[] words, String word1, String word2) {
    int i1 = -1, i2 = -1;
    int minDistance = words.length;
    int currentDistance;
    for (int i = 0; i < words.length; i++) {
        if (words[i].equals(word1)) {
            i1 = i;
        } else if (words[i].equals(word2)) {
            i2 = i;
        }

        if (i1 != -1 && i2 != -1) {
            minDistance = Math.min(minDistance, Math.abs(i1 - i2));
        }
    }
    return minDistance;
}
```

---

##  244. II
Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list. Your method will be called repeatedly many times with different parameters. 

Example:
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
```
Input: word1 = “coding”, word2 = “practice”
Output: 3

Input: word1 = "makes", word2 = "coding"
Output: 1
```
Note:
You may assume that word1 **does not equal** to word2, and word1 and word2 are both in the list.

## 題目要求
設計一個class來去儲存丟進來的字串, 並實作一個function找兩個字的最近距離

## 想法
在建立字串的時候用map, 直接在建立map時把字串的出現欄位list建立出來, 每一次只要去用map.get就可以
```java
class WordDistance {
    HashMap<String, List<Integer>> map;
    public WordDistance(String[] words) {
        map = new HashMap();
        for(int i=0; i<words.length; i++){
            String word = words[i];
            if(!map.containsKey(word)){
                map.put(word, new ArrayList<Integer>());
            }
            map.get(word).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<list1.size(); i++){
            for(int j=0; j<list2.size(); j++){
                ans = Math.min(ans, Math.abs(list1.get(i)-list2.get(j)));
            }
        }
        return ans;
    }
}
```
## 想法 2更新找最小值的方式  不要用兩個for去找
```java
class WordDistance {
    HashMap<String, List<Integer>> map;
    public WordDistance(String[] words) {
        map = new HashMap();
        for(int i=0; i<words.length; i++){
            String word = words[i];
            if(!map.containsKey(word)){
                map.put(word, new ArrayList<Integer>());
            }
            map.get(word).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int ans = Integer.MAX_VALUE;
        int p1 = 0;
        int p2 = 0;
        
        while(p1<list1.size() && p2<list2.size()){
            int v1 = list1.get(p1);
            int v2 = list2.get(p2);
            ans = Math.min(Math.abs(v1-v2),ans);
            if(v1>v2){
                p2++;
            }
            else{
                p1++;
            }
        }
        return ans;
    }
}
```
### 圖解
![](https://i.imgur.com/j3Npxd2.png)
--
![](https://i.imgur.com/kGviM58.png)
--
![](https://i.imgur.com/73y3j98.png)
--
![](https://i.imgur.com/ht8WLTi.png)
--
![](https://i.imgur.com/o0x0uIk.png)
--
![](https://i.imgur.com/VJ1LYOv.png)
--
![](https://i.imgur.com/0IH2x8m.png)
--
![](https://i.imgur.com/svdO059.png)
--
![](https://i.imgur.com/rQWAwsh.png)
--
![](https://i.imgur.com/X6jlmO0.png)

---

## 245. III
Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

word1 and word2 may be **the same** and they represent two individual words in the list.

Example:
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
```
Input: word1 = “makes”, word2 = “coding”
Output: 1
Input: word1 = "makes", word2 = "makes"
Output: 3
```
Note:
You may assume word1 and word2 are both in the list.
## 想法
根據 **II** 直接衍伸個暴力解出來
只要多判斷一個word1 == word2這樣
```java
class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        HashMap<String, List<Integer>> map = new HashMap();
        for(int i=0; i<words.length; i++){
            String word = words[i];
            if(!map.containsKey(word)){
                map.put(word, new ArrayList<Integer>());
            }
            map.get(word).add(i);
        }
        int res = Integer.MAX_VALUE;
        if(word1.equals(word2)){
            List<Integer> list3 = map.get(word1);
            for(int i=0; i<list3.size()-1; i++){
                for(int j=i+1; j<list3.size(); j++){
                    res = Math.min(res, Math.abs(list3.get(i)-list3.get(j)));
                }
            }
            return res;
        }else{
            List<Integer> list1 = map.get(word1);
            List<Integer> list2 = map.get(word2);
            
            int p1 = 0;
            int p2 = 0;
            while(p1<list1.size() && p2<list2.size()){
                int v1 = list1.get(p1);
                int v2 = list2.get(p2);
                if(v1>v2){
                    ++p2;
                }
                else{
                    ++p1;
                }
                res = Math.min(Math.abs(v1-v2),res);
            }
            return res;
        }
        
    }
}
```

但是太慢, 速度只排在在13.08%

## 想法2
進階版的解法是根據 **I** 的解答改版的, 在 **I** 的解答中加上word1 == word2的判斷
```java
public int shortestWordDistance(String[] words, String word1, String word2) {
        int i1 = -1;
        int i2 = -1;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (word1.equals(word2)) {  //case 1: word1 and word2 are the same
                if (words[i].equals(word1)) {
                    i2 = i1;
                    i1 = i;
                }
            } else {    //case 2: word1 and word2 are not the same
                if (words[i].equals(word1)) {
                    i1 = i;
                } else if (words[i].equals(word2)) {
                    i2 = i;
                }
            }
            if (i1 != -1 && i2 != -1) {
                res = Math.min(res, Math.abs(i1 - i2));
            }
        }
        return res;
}
```

**I** 的解答
```java
public int shortestDistance(String[] words, String word1, String word2) {
    int i1 = -1, i2 = -1;
    int minDistance = words.length;
    int currentDistance;
    for (int i = 0; i < words.length; i++) {
        if (words[i].equals(word1)) {
            i1 = i;
        } else if (words[i].equals(word2)) {
            i2 = i;
        }

        if (i1 != -1 && i2 != -1) {
            minDistance = Math.min(minDistance, Math.abs(i1 - i2));
        }
    }
    return minDistance;
}
```