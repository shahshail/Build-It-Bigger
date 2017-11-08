package com.example;

import java.util.Random;

/**
 * Created by shailshah on 11/7/17.
 */

public class TellAJoke {

    private String[] jokes;
    private Random random;

    public TellAJoke() {
       jokes = new String[]{
          "shahshail",
               "qqqqqqqqq",
               "wwwwwwwww",
               "eeeeeeeee",
               "fffffffff"
       };
        random = new Random();
    }

    public String[] jokesMethod() {
        return jokes;
    }

    public String getDifferentJoke() {
        return jokes[random.nextInt(jokes.length)];
    }

}