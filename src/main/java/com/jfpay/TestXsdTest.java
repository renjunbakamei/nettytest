package com.jfpay;

import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.io.StringReader;

public class TestXsdTest {
    public static void main(String[] args) throws IOException {
//        String s7 =new StringBuilder("").append("").toString();
//        System.out.println(s7.intern()==s7);
//        String s6=new StringBuilder("r").append("z").append("x").toString();
//        System.out.println(s6.intern()==s6);
//        String s8=new StringBuilder("r").append("z").toString();
//        System.out.println(s8.intern()==s8);
//        String s1=new StringBuilder("go").toString();
//        System.out.println(s1.intern()==s1);
//        String s4=new StringBuilder("ja").append("va").toString();
//        System.out.println(s4.intern()==s4);
//        String s2=new StringBuilder("renjun").append("rzx").toString();
//        System.out.println(s2.intern()==s2);
//        String s3=new String("renjun");
//        String s32="renjun";
//
//        System.out.println(1<<3);

        StringReader stringin=new StringReader("test");
        LineNumberReader in=new LineNumberReader(stringin);
        PrintWriter out=new PrintWriter(System.out);
        out.println(in.readLine());
        out.flush();

    }
}
