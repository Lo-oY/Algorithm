package com.ly;

import java.util.Scanner;

/**
 * Created by Lo_oY on 2016/9/8.
 */
public class TestSol {

        public static int getMaxLen(char[] str){

            int[][] MaxLen= new int[str.length+1][str.length+1];
            for(int i = 0;i<str.length;i++)
                MaxLen[i][0] = 0;
            for(int j = 0;j<str.length;j++)
                MaxLen[0][j] = 0;

            for(int i = 1 ; i<= str.length;i++){
                for(int j = 1;j<=str.length;j++){

                    if(str[i-1] == str[str.length-j])
                        MaxLen[i][j] = MaxLen[i-1][j-1] + 1;
                    else{
                        MaxLen[i][j] = MaxLen[i-1][j] > MaxLen[i][j-1]? MaxLen[i-1][j]:MaxLen[i][j-1];
                    }

                }
            }


            return MaxLen[str.length][str.length];
        }
        public static void  main(String args[]){

            Scanner sc = new Scanner(System.in);
            while(sc.hasNext()){

                String str = sc.nextLine();
                System.out.println(getMaxLen(str.toCharArray()));
            }

        }
    }

