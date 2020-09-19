package com.johnmsaylor;

import com.johnmsaylor.sportsradar.Test;
import com.johnmsaylor.sportsradar.Utility;

import java.time.Instant;


public class Main {

    public static void main(String[] args) {
        String example = "2020-12-20T18:00:00+00:00";

        Instant instant = Utility.formatDate(example);

        System.out.println(instant);
    }


}
