## 二分查找答题

> 使用左闭合右开
>
> [left,right)

### 答题模板

```java
while(left < right){
    mid = left +(right - right)/2;
    if(mid == key){
        return mid;
    }else if(mid < key){
        //[left,mid)
        right = mid;
    } else{
        //[mid+1,right)
        left = mid + 1;
    }
}

```



#### 例子1

```java
A = [1,2,5,7,8,12]
search(8) = 4，search(6)= -1；

binary_search(A,8,left,len(A))


binary_search(A,key,left,right){
    while(left < right){
        mid = left +(right - left)/2;
        if(mid == key){
            return mid;
        }else if(mid < key){
            //[left,mid)
            right = mid;
        } else{
            //[mid+1,right)
            left = mid + 1;
        }
    }
    //not found
    return -1；
}

```

#### 例子2

```java
lower_bound(x): first index of i, such that A[i] >= x 大于等于x
upper_bồund(x): first index of i, such that A[i] > x 严格大于x


A = [1,2,2,2,4,4,5]
lower_bound(A,2) = 1,lower_bound(A,3) = 4 (does not exist)
upper_bound(A,2) = 4,upper_bound(A,5) = 7 (does not exist)


lower_bound(A,key，left，right){
	while(left < right){
        mid = left +(right - left)/2;
        //与upper_bound最大区别就是这个，>= 大于等于
        if(A[mid] >= key){
            //[left,mid)
            right = mid;
        } else{
            //[mid+1,right)
            left = mid + 1;
        }
    }
    //not found
    return left；
}

upper_bound(A,key，left，right){
	while(left < right){
        mid = left +(right - left)/2;
        //与upper_bound最大区别就是这个，> 大于
        if(A[mid] > key){
            //[left,mid)
            right = mid;
        } else{
            //[mid+1,right)
            left = mid + 1;
        }
    }
    //not found
    return left；
}

```



#### 例子3

```java
//力扣69 sqrt(4)=2，sqrt(8) = 2
sqrt(x){
    left = 0;
    right = x+1;
    while(left < right){
        mid = left +(right - left)/2;
        //m最小的平方大于x
        if(m*m > x){
            //[left,mid)
            right = mid;
        } else{
            //[mid+1,right)
            left = mid + 1;
        }
    }
    //因为比较是m*m>2 
    //也就是left*left>X,所以需要left-1
    return left - 1; 
}

```



```java
//力扣278 找到第一个错的版本
bool isBadVersion(int version)

firstBadVersion(n){
    left = 0;
    right = n;
    while(left < right){
        mid = left +(right - left)/2;
        //m最小的平方大于x
        if(isBadVersion(n)){
            //[left,mid)
            right = mid;
        } else{
            //[mid+1,right)
            left = mid + 1;
        }
    }
    return left;
}


```



```java
//力扣 875，找到一个最小的k时间，需要在H小时完成吃香蕉

eat(piles,H){
    left = 1;
    right = max(piles)+1;
    
     while(left < right){
        //mid为吃香蕉的速度
         mid = left +(right - left)/2;
        
        h=0;
         for(P p :piles){
             h+=(p+m-1);
         }
         
        if(h<=H){
            //[left,mid)
            right = mid;
        } else{
            //[mid+1,right)
            left = mid + 1;
        }
    }
    return left;
}


```

### 总结
```java
    /**
     * 范围查询规律
     * 初始化:
     *   int left = 0;
     *   int right = nums.length - 1;
     * 循环条件
     *   left <= right
     * 右边取值
     *   right = mid - 1
     * 左边取值
     *   left = mid + 1
     * 查询条件
     *   >= target值, 则 nums[mid] >= target时, 都减right = mid - 1
     *   >  target值, 则 nums[mid] >  target时, 都减right = mid - 1
     *   <= target值, 则 nums[mid] <= target时, 都加left = mid + 1
     *   <  target值, 则 nums[mid] <  target时, 都加left = mid + 1
     * 结果
     *   求大于(含等于), 返回left
     *   求小于(含等于), 返回right
     * 示例(求> 或 >=)
     *     private int search(int[] nums, int target) {
     *         int left = 0;
     *         int right = nums.length - 1;
     *         while (left <= right){
     *             int mid = (right - left) / 2 + left;
     *             if (nums[mid] 查询条件 target){
     *                 right = mid - 1;
     *             } else {
     *                 left = mid + 1;
     *             }
     *         }
     *         return left(根据查询条件确认);
     *     }
     * 核心思想: 要找某个值, 则查找时遇到该值时, 当前指针(例如right指针)要错过它, 让另外一个指针(left指针)跨过他(体现在left <= right中的=号), 则找到了
     */

```

#### 示例

```java
    /**
 * 找数组中第一个 >= 目标值的索引
 * 没找到则返回数组长度值
 * 思路:
 *   大于等于都满足, 则不能取right值, 只能取与left相关的
 *   由于可以最大值都没有 >= 目标值, 故left要在遍历过程中达到 left > right
 *   故循环结束条件 left <= right
 *   left要大于right, 则nums[mid] >= target时 right = mid - 1, 是right降到小于目标值的位置, 然后left跨过去
 *   left 固定必须为 mid + 1
 * 没找到则返回数组长度值
 */

public class TEST {
    public static int searchGeTarget(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = (right - left) / 2 + left;
            if (nums[mid] >= target){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * 找数组中第一个 > 目标值的索引
     * 没找到则返回数组长度值
     */
    public static int searchGtTarget(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = (right - left) / 2 + left;
            if (nums[mid] > target){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * 找数组第一个 <= 目标值的索引(4,4,4,4)的右边界
     * 没有则返回-1
     */
    public static int searchLeTarget(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = (right - left) / 2 + left;
            if (nums[mid] > target){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    /**
     * 找数组第一个 < 目标值的索引(4,4,4,4,5)的右边界5
     * 没有则返回-1
     */
    public static int searchLtTarget(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = (right - left) / 2 + left;
            if (nums[mid] >= target){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

}

```

#### 代码

```java
class Solution {
    /**
     * 二分查找
     */
    public int[] searchRange(int[] nums, int target) {
        //寻找左边界(这里寻找第一个 >= target的索引)
        int leftIndex = search(nums, target);
        if (leftIndex >= nums.length || nums[leftIndex] != target){
            return new int[]{-1, -1};
        }
        //寻找右边界(这里寻找第一个 >= target+1的索引)
        int rightIndex = search(nums, target + 1);
        return new int[]{leftIndex, rightIndex - 1};
    }

    /**
     * 寻找第一个>=目标值的索引, 找不到则返回数组长度
     */
    private int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = (right - left) / 2 + left;
            if (nums[mid] >= target){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}

```