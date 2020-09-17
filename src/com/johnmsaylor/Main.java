package com.johnmsaylor;

import com.johnmsaylor.sportsradar.Test;

import java.util.concurrent.ExecutionException;

public class Main {

    public static void main(String[] args) {
        try {
            Test.request();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
