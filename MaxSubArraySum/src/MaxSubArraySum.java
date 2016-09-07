/**
 * Created by Lo_oY on 2016/9/6.
 */
public class MaxSubArraySum {



    private int Merge(int[] a , int low, int high){
        int middle = (low+high)/2;
        int leftMaxSum = Integer.MIN_VALUE;
        int rightMaxSum = Integer.MIN_VALUE;
        int leftSum = 0;
        int rightSum = 0;
        for(int i = middle ; i >= 0;i--){
            leftSum += a[i];
            if(leftSum > leftMaxSum)
                leftMaxSum = leftSum;
        }

        for(int i = middle+1;i <= high;i++){
            rightSum += a[i];
            if(rightSum > rightMaxSum)
                rightMaxSum = rightSum;
        }

        return leftMaxSum+rightMaxSum;
    }

    public int  FindMaxArraySum(int[] a,int low,int high){

        if(low == high)
            return a[low];
        else{
            int mid = (low+high)/2;
            int leftSum = FindMaxArraySum(a,low,mid);
            int rightSum = FindMaxArraySum(a,mid+1,high);
            int mergeSum = Merge(a,low,high);
            return Math.max(Math.max(leftSum,rightSum),mergeSum);
        }

    }

    public static void main(String args[]){


        MaxSubArraySum ms = new MaxSubArraySum();
        int[] a = {1,2,3,4,5,6,-1,-2,88,1};
        int i = ms.FindMaxArraySum(a, 0, a.length-1);
        System.out.println(i);
    }
}
