package com.company;

import java.util.Scanner;

class CipherDecipher {

    public String ciphering(String normal) {
        StringBuffer ns = new StringBuffer(normal);
        for (int i = 0; i < normal.length(); i++) {
            if (Character.isLowerCase(normal.charAt(i))) {
                char x = Character.toUpperCase(normal.charAt(i));
                ns.setCharAt(i, x);
            } else if (Character.isUpperCase(normal.charAt(i))) {
                char x = Character.toLowerCase(normal.charAt(i));
                ns.setCharAt(i, x);
            }
        }
        ns = ns.reverse();
        String nn = ns.toString();
        nn.replace(' ', '*');
        StringBuffer nst = new StringBuffer(nn);
        for (int i = 0; i < normal.length(); i++) {
            if (i % 2 == 1) {
                int ascii = (int) nn.charAt(i);
                nst.setCharAt(i, (char) ascii);
            }
        }
        nst.append('3');
        String p = nst.toString();


        return p;
    }

    public String deciphering(String ciphered) {

        StringBuilder a = new StringBuilder(ciphered);
        StringBuilder b = a.deleteCharAt(a.length() - 1);
        int n = b.length();
        char[] ch = new char[n + 1];
        StringBuilder c = new StringBuilder();
        for (int i = 0; i < n; i++) {
            ch[i] = b.charAt(i);
        }
        String temp = "";
        for (int i = 0; i < n; i++) {
            if (!Character.isDigit(ch[i])) {
                c.append(ch[i]);
                System.out.println(c);
            } else {
                temp = temp + ch[i];
                if (!Character.isDigit(ch[i + 1])) {
                    int number = Integer.parseInt(temp);
                    char p = (char) number;
                    c.append(p);
                    temp = "";
                    System.out.println(c);
                }
            }
        }
        System.out.println(c);
        String d = c.toString();
        String e = d.replace('*', ' ');
        StringBuffer f = new StringBuffer(e);
        StringBuffer g = f.reverse();
        for (int i = 0; i < g.length(); i++) {

            if (Character.isLowerCase(g.charAt(i))) {
                char x = Character.toUpperCase(g.charAt(i));
                g.setCharAt(i, x);
            } else if (Character.isUpperCase(g.charAt(i))) {
                char x = Character.toLowerCase(g.charAt(i));
                g.setCharAt(i, x);
            }
        }

        return g.toString();

    }

}

public class Solution {

    public static void main(String[] args) {

        Scanner readInput = new Scanner(System.in);
        String normal = readInput.nextLine();
        //String ciphered = readInput.nextLine();

        CipherDecipher cipherDecipher = new CipherDecipher();
        System.out.println(cipherDecipher.ciphering(normal));
        // System.out.println(cipherDecipher.deciphering(ciphered));
    }
}
