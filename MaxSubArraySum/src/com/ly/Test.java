package com.ly;

import java.util.Scanner;

/**
 * Created by Lo_oY on 2016/9/8.
 */
public class Test {

        public static void main(String args[]){


            Scanner sc = new Scanner(System.in);
            while(sc.hasNext()){
                String res = MoveString(sc.nextLine().toCharArray());
                System.out.println(res);
            }
        }

        public static String MoveString(char[] str){

            for(int i = str.length-1; i >= 0 ; i--){
                if('A'<= str[i] && str[i] <='Z'){

                    for(int j = i+1 ; j < str.length; j++)
                    {
                        if('a'<= str[j] && str[j]<= 'z')
                        {
                            char temp = str[j];
                            str[j] = str[i];
                            str[i] = temp;
                            i = j;
                        }else{
                            break;
                        }
                    }

                }

            }

            return new String(str);
        }

}
