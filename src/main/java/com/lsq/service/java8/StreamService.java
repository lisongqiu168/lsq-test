package com.lsq.service.java8;

import java.util.Random;

public class StreamService {

    public static void main(String[] args) {
        Random random = new Random();
        random.ints().limit(10).sorted().forEach(System.out::println);
    }
}
