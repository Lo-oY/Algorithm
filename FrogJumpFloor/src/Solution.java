import java.net.Socket;

/**
 * Created by Lo_oY on 2016/9/7.
 */
//public class Solution {
//
//    public int JumpFloor(int target) {
//
//        int sum = 1;
//        for(int i = 1 ; i <= target/2 ; i++){
//
//            sum += getSum(i,target);
//        }
//
//        return sum;
//    }
//
//
//    public int getSum(int i,int target){
//
//        int a = 1;
//        int b = 1;
//        int temp = i;
//        for(int j = 0;j<i;j++,temp++ )
//            a *= (target-temp);
//        for(int j = i;j>0;j--)
//            b*=j;
//
//        return a/b;
//    }
//
//public static void main(String args[]){
//    Solution s = new Solution();
//    int i = s.JumpFloor(29);
//    System.out.println(i);
//}
//}


/**
 * 斐波那契数列
 */
public class Solution {
    public int JumpFloor(int target) {
        int result = 0;
        if (target > 0) {
            if (target <= 2)
                return target;
            else
                return result = JumpFloor(target - 1) + JumpFloor(target - 2);
        }
        return result;
    }
    public static void main(String args[]) {
        Solution s = new Solution();
        int i = s.JumpFloor(29);
        System.out.println(i);
    }
}

