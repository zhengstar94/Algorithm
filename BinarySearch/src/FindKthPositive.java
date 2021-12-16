/**
 *
 * 力扣1539
 *
 * 给你一个 严格升序排列 的正整数数组 arr 和一个整数 k 。
 *
 * 请你找到这个数组里第 k 个缺失的正整数。
 *
 *
 *
 * 示例 1：
 * 输入：arr = [2,3,4,7,11], k = 5
 * 输出：9
 * 解释：缺失的正整数包括 [1,5,6,8,9,10,12,13,...] 。第 5 个缺失的正整数为 9 。
 *
 * 示例 2：
 * 输入：arr = [1,2,3,4], k = 2
 * 输出：6
 * 解释：缺失的正整数包括 [5,6,7,...] 。第 2 个缺失的正整数为 6 。
 *
 *
 *
 * 提示：
 *
 *     1 <= arr.length <= 1000
 *     1 <= arr[i] <= 1000
 *     1 <= k <= 1000
 *     对于所有 1 <= i < j <= arr.length 的 i 和 j 满足 arr[i] < arr[j]
 **/



/**
 * @author zxx
 * @date 2021/12/16 14:17
 **/
public class FindKthPositive {

    public static int findKthPositive(int[] arr, int k) {

        if(arr[0] > k)
        {
            return k;
        }

        int len = arr.length -1;

        int left = 0 ;
        int right = len;

        while (left <= right)
        {
            int mid = left + (right - left)/2;

            //arr[mid]- mid -1 的原因是因为
            //比如 2,3,4,7,11
            //缺失的数据是
            // 数组下标 |  实际值  | 丢失的数据个数
            //    0         2           1
            //    1         3           1
            //    2         4           1
            //    3         7           3
            //    4         11          6

            //由此可知arr[i] - i - 1 = k(丢失的个数)

            //如果中间丢失的个数少于输入的数据，说明left需要往右移动，
            if(arr[mid]- mid -1 < k)
            {
                left = mid + 1;
            }else
            {
                //如果中间丢失的个数大于输入的数据，说明left需要往右移动，
                right = mid - 1;
            }
        }

        //k+下标即为需要寻找的数字，这个下标为第一个大于等于 k 的 坐标
        return k + left;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,4,7,11};
        int target = 3;

        System.out.println(findKthPositive(nums,target));
    }
}
