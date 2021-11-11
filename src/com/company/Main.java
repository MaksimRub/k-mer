package com.company;

import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);

    public static void Count(String text, int pattern) {
        String str = "";
        int[] args=new int[text.length()-pattern+1];
        int r=0;
        for (int i = 0; i < text.length() - pattern; i++) {
            int pat = pattern;
            String shortText1 = text.substring(i, pat + i);
            int t = 0;
            for (int j = 0; pat < text.length(); j++) {
                String shortText2 = text.substring(j, pat);
                boolean retVal = shortText2.equals(shortText1);

                if (retVal) {
                    t++;
                }
                pat++;
            }
            args[i]=t;
        }
        int first=args[0];
        for (int i = 1; i < args.length; i++) {
            if(args[i]>first){
                first=args[i];
            }
        }
        for (int i = 0; i < text.length() - pattern; i++) {
            int pat = pattern;
            String shortText1 = text.substring(i, pat + i);
            int t = 0;
            for (int j = 0; pat < text.length(); j++) {
                String shortText2 = text.substring(j, pat);
                boolean retVal = shortText2.equals(shortText1);
                if (retVal) {
                    t++;
                }
                pat++;
            }
            if(r==0&&t==first){
                str = str +shortText1+" ";
            }
            if(r>0&&t==first){
                int f=0;
                for (int j = 0; j <= str.length(); j=j+1+pattern) {
                    String shortText3;
                    if(j<str.length()){
                        if(j==0){
                            shortText3=str.substring(0,pattern);
                        }else{
                            shortText3=str.substring(j,pattern+j+1);
                        }
                        boolean retVal=shortText1.equals(shortText3);
                        if(!retVal){
                            f++;
                            //System.out.println(f);
                        }else{
                            break;
                        }
                    }
                }
                if(r==f){
                    str = str +shortText1+" ";
                }
            }
            if(t==first){
                r++;
            }
        }
        System.out.println(str);
    }

        public static void main (String[]args){
            // write your code here
            String text = in.nextLine();
            int pattern = in.nextInt();
            Count(text, pattern);

        }

}
//ACGTTGCATGTCGCATGATGCATGAGAGCT