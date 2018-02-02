package com.example.demo.interview;

/**
 * Created by jiaozhiguang on 2018/1/19.
 */
public class OddEvenSort {

    public static int[]a =new int[]{1,2,3,4,5,6};
    public static void main(String[] args) {
        RecordOddEven();
        display();
    }
    /**
     * 思路是：从前面开始扫描，从前面开始找奇数，从后面开始找偶数，如果找到了就交换，记住交换之前也一定要记住这个条件：begin<end
     */
    public static void display(){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }
    public static void RecordOddEven(){
        int begin=0;
        int end=a.length-1;
        while(begin<end){
            while(!isEven(a[begin])){
                begin++;
            }
            while(isEven(a[end])){
                end--;
            }
            if(begin<end){
                int temp=a[begin];
                a[begin]=a[end];
                a[end]=temp;


                begin++;
                end--;
            }
        }
    }
    //判断是否是偶数
    public static boolean isEven(int b){
        return b%2==0;
    }
}
