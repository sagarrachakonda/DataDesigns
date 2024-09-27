package com.datadesign.datadesign.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpConnection {
    public static void main(String[] args) throws Exception {

        // Sending get request
        URL url = new URL("http://localhost:8082/home/data");

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestProperty("Accept", "application/json");
        conn.setRequestProperty("Authorization","Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzYWdhciIsImlhdCI6MTcyNzQ1NDU0OCwiZXhwIjoxNzI3NDcyNTQ4fQ.2NtMuhSyspRkKJWbmv0ESHhiQrQU1BjqFjXSTjNAd1otb90RmBaCX3pKRZwQYXuNWcIup1dZN26wyUFqtMX0Zw");

        //e.g. bearer token= eyJhbGciOiXXXzUxMiJ9.eyJzdWIiOiPyc2hhcm1hQHBsdW1zbGljZS5jb206OjE6OjkwIiwiZXhwIjoxNTM3MzQyNTIxLCJpYXQiOjE1MzY3Mzc3MjF9.O33zP2l_0eDNfcqSQz29jUGJC-_THYsXllrmkFnk85dNRbAw66dyEKBP5dVcFUuNTA8zhA83kk3Y41_qZYx43T

        //conn.setRequestProperty("Content-Type","application/json");

        conn.setRequestMethod("GET");



        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String output;

        StringBuffer response = new StringBuffer();


        while ((output = in.readLine()) != null) {
            System.out.println("Response:-" + output.toString());
            ////you will get output in "output.toString()" ,Use it however you like
        }
        in.close();

    }
}
