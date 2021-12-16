/**
 *
 * 力扣1385
 *
 * 给你两个整数数组 arr1 ， arr2 和一个整数 d ，请你返回两个数组之间的 距离值 。
 *
 * 「距离值」 定义为符合此距离要求的元素数目：对于元素 arr1[i] ，不存在任何元素 arr2[j] 满足 |arr1[i]-arr2[j]| <= d 。
 *
 * 示例 1：
 * 输入：arr1 = [4,5,8], arr2 = [10,9,1,8], d = 2
 * 输出：2
 * 解释：
 * 对于 arr1[0]=4 我们有：
 * |4-10|=6 > d=2
 * |4-9|=5 > d=2
 * |4-1|=3 > d=2
 * |4-8|=4 > d=2
 * 所以 arr1[0]=4 符合距离要求
 *
 * 对于 arr1[1]=5 我们有：
 * |5-10|=5 > d=2
 * |5-9|=4 > d=2
 * |5-1|=4 > d=2
 * |5-8|=3 > d=2
 * 所以 arr1[1]=5 也符合距离要求
 *
 * 对于 arr1[2]=8 我们有：
 * |8-10|=2 <= d=2
 * |8-9|=1 <= d=2
 * |8-1|=7 > d=2
 * |8-8|=0 <= d=2
 * 存在距离小于等于 2 的情况，不符合距离要求
 *
 * 故而只有 arr1[0]=4 和 arr1[1]=5 两个符合距离要求，距离值为 2
 *
 * 示例 2：
 * 输入：arr1 = [1,4,2,3], arr2 = [-4,-3,6,10,20,30], d = 3
 * 输出：2
 *
 * 示例 3：
 * 输入：arr1 = [2,1,100,3], arr2 = [-5,-2,10,-3,7], d = 6
 * 输出：1
 *
 *
 *
 * 提示：
 *
 *     1 <= arr1.length, arr2.length <= 500
 *     -10^3 <= arr1[i], arr2[j] <= 10^3
 *     0 <= d <= 100
 *
 **/


import java.util.Arrays;

/**
 * @author zxx
 * @date 2021/12/16 09:48
 **/
public class FindTheDistanceValue {

    public static int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        // 先对arr2 进行排序
        Arrays.sort(arr2);
        int cnt = 0;

        //遍历
        for(int target : arr1){
            //依次比较，符合+1，不符合为0
            cnt += binarySearch(arr2, target, d) ? 1 : 0;
        }
        return cnt;
    }

    /**
    * 检查target 是否与 arr[] 中的每个元素的差的绝对值都大于 d
    */
    public static boolean binarySearch(int[] arr, int target, int d){
        // 二分法
        int left = 0, right = arr.length - 1;
        while(left <= right){
            int mid =left + (right - left ) / 2;
            int tmp = arr[mid] - target;
            //大于d的情况符合，说明mid右边的数不需要进行比较
            //即right变成mid-1
            if(tmp > d) {
                right = mid - 1;
            //小于-d,说明mid左边的数都不需要进行比较
            //即left= mid+1
            } else if(tmp < -d) {
                left = mid + 1;
            } else {
                //如果不大于d或者不小于-d，都是不符合要求，直接退出
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr1 = {2,1,100,3};
        int[] arr2 = {-5,-2,10,-3,7};
        int d = 6;

        System.out.println(findTheDistanceValue(arr1,arr2,d));
    }
}
