# T勢考古
###### tags: `LeetCode` `easy`

## 英文題目本身
![](https://i.imgur.com/x9sMb61.jpg)

## 題目要求

## 想法

#### 結果
```javascript
// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{10, -10, -1, -1, 10})); // 1
        System.out.println(solution(new int[]{-1, -1, -1, 1, 1, 1, 1})); // 3
        System.out.println(solution(new int[]{5, -2, -3, 1}));  // 0
        System.out.println(solution(new int[]{5, 2, -8, 1}));  // 1
        System.out.println(solution(new int[]{-3, 5, -2, 3}));  // 1
        System.out.println(solution(new int[]{3, 5, -100, -5,101}));  // 1
        // System.out.println(solution(new int[]{3, 5, -100, -50,101}));  // 2
    }
    private static int solution(int[] A){
        int step=0;
        int cur =0;
        // add to queue
        Queue<Integer> queue = new LinkedList<>();
        for(int a: A){
            queue.add(a);
        }
        
        while(!queue.isEmpty()){
            int temp = queue.poll();
            if((cur+temp)<0){
                queue.add(temp);
                step++;
            }else  if((cur+temp)== 0){
               if(!queue.isEmpty() && queue.peek()<0){
                    queue.add(temp);
                    step++;
               }
            }else{
                cur+=temp; 
            }
        }
        return step;
    }
}
```

### 想法 2
#### 結果
```javascript
```