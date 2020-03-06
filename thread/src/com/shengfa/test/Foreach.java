package com.shengfa.test;
import java.util.Collections;
import java.util.List;
/**
 * <p>Title:Foreach</p>
 * <p>Description:TODO</p>
 *
 * @author 郭亮
 * @date 2020/3/4 15:54
 */
public class Foreach {
    public static void main(String[] args) {
//        List<String> list = Collections.emptyList();
////        for(String s:list) {
////            System.out.println("aaa..."+s);
////        }
////        System.out.println("end...");
        String[] str = {"a","b"};

        for(String s:str) {
            System.out.println("aaa..."+s);
        }
        System.out.println("end...");
    }
}
