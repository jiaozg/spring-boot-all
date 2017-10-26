package com.example.demo.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by jiaozhiguang on 2017/10/25.
 */
public class ProcessTest {

    public static void main(String[] args) throws IOException {



        Process process = Runtime.getRuntime().exec("ifconfig -a");

        BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line = null;
        while ((line = input.readLine()) != null) {
            System.out.println(line);
        }
    }

}
