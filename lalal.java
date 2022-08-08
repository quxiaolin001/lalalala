package com.decathlon.facade.order.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class lalal {

    public static  String getURLContent(String urlStr,Charset charset){
        StringBuilder sb = new StringBuilder();
        try{
            URL url = new URL(urlStr);

            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), charset));
            String temp="";
            while((temp=reader.readLine())!=null){
                sb.append(temp).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static List<String> getMatherSubstrs(String destStr,String regexStr){
        Pattern p = Pattern.compile(regexStr);

        List<String> result=new ArrayList<>();
        Matcher m = p.matcher(destStr);
        while(m.find()){
            result.add(m.group(1));
        }
        return result;
    }


    public static void main(String[]args){

        String urlStr="url needs to be configured here";
        String destStr = getURLContent(urlStr,Charset.forName("utf-8"));

        List<String> list=getMatherSubstrs(destStr,"href=\"(http[\\w\\s./:]+?)\"");

        for(String string:list){
            System.out.println(string);
        }
    }
}
