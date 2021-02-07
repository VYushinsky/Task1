package com.com;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
import java.util.Collections;

public class Main {
    public static void main (String[] args) throws IOException {
        ArrayList<Integer> list = new ArrayList<Integer>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(new File("chisla.txt")));
            int c;
            String s;
            while ((s = reader.readLine()) != null) {
                list.add(Integer.parseInt(s));
            }
            reader.close();
            } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(percentile(list));
        System.out.println(median(list));
        System.out.println(Collections.max(list));
        System.out.println(Collections.min(list));
        System.out.println(average(list));
    }

    public static String average (ArrayList<Integer> list){
        double avg = 0;
        if (list.size() > 0){
            double sum = 0;
            for (int j = 0; j < list.size(); j++) {
                sum += list.get(j);
            } avg = sum / list.size();
        }
        String formattedDouble = new DecimalFormat("#0.00").format(avg);
        return formattedDouble;

    }
    public static String median(ArrayList<Integer> list){
        Collections.sort(list);
        int n = list.size()/2;
        double mediana;
        if (list.size() % 2 == 0) {
            mediana = (list.get(n) + list.get(n - 1)) / 2;
        } else
            mediana = list.get(n);
        String formattedDouble = new DecimalFormat("#0.00").format(mediana);
        return formattedDouble;
    }
    public static int percentile(ArrayList<Integer> list){
        Collections.sort(list);
        int index = (int)Math.ceil((90 / 100) * list.size());
        return list.get(index);
    }
}


