package com.ly;

/**
 * Created by Lo_oY on 2016/9/3.
 */
public class HeapSort {


    private void heapAdjust(int[] arr,int i,int length){

        int childNode;
//        if(2*i+1>=length) return;
        for(;2*i+1<length;i=childNode) {
             childNode = 2 * i + 1;
            if (childNode < length - 1 && arr[childNode + 1] > arr[childNode]) childNode++;
            if (arr[childNode] > arr[i]) {

                int temp = arr[childNode];
                arr[childNode] = arr[i];
                arr[i] = temp;
            }
            else break;
        }
    }


    private  void headSort(int[] arr,int length){

        for(int i = length/2-1; i >= 0 ; i-- ){
            heapAdjust(arr,i,length);
        }


        for(int i = length-1; i>0; --i){

            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapAdjust(arr,0,i);
        }
    }

    public static void main(String[] args){

        HeapSort heapSort= new HeapSort();
        int[] arr = {3,4,7,9,2,1,8,12,34};
        heapSort.headSort(arr,arr.length);

        for(int i:arr){
            System.out.println(i);
        }
    }


}
