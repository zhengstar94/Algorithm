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



```java
//力扣378 找到


```

