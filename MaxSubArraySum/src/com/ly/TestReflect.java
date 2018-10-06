package com.ly;

import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;
import java.util.Arrays;

/**
 * Created by Lo_oY on 2016/9/7.
 */
public class TestReflect {


    public static void main(String args[]) throws MalformedURLException, IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {

        String path = System.getProperty("user.dir");
        System.out.println(path);
        URLStreamHandler urlStreamHandler = null;
        String repository = new URL("file",null,path+ File.separator+"out"+File.separator+"production"+File.separator+"com.ly.MaxSubArraySum").toString();
        URL[] urls = new URL[1];
        urls[0] = new URL(null,repository,urlStreamHandler);
        ClassLoader cl = new URLClassLoader(urls);

        Class clzz = cl.loadClass("com.ly.MaxSubArraySum");
       Method method =  clzz.getDeclaredMethod("FindMaxArraySum",null);
//       MaxSubArraySum maxSubArraySum = (MaxSubArraySum) clzz.newInstance();

//        Method[] method =  clzz.getDeclaredMethods();
//        System.out.println(method.toString());
        int[] a = {1,2,3,4,5,6,-1,-2,88,1};

        int i = (int)method.invoke(a,0,a.length-1);
//        int i = maxSubArraySum.FindMaxArraySum(a, 0, a.length-1);

        System.out.println(i);
//        com.ly.MaxSubArraySum maxSubArraySum = (com.ly.MaxSubArraySum)clzz.newInstance();

//        int i = maxSubArraySum.FindMaxArraySum(a, 0, a.length-1);
//         System.out.println(i);

    }
}
