package com.example;

import java.util.Random;

/**
 * Created by shailshah on 11/7/17.
 */

public class TellAJoke {

    private String[] jokes;

    public TellAJoke() {
       jokes = new String[]{
          "Q: How many programmers does it take to change a light bulb? \n" +
                  "A: None. It's a hardware problem. \n",
               "Q: Why do programmers always mix up Halloween and Christmas? \n" +
                       "A: Because 31 OCT = 25 DEC. ",
               "There are 10 types of people in the world: those who understand binary, and those who don't. ",
               "Q: What does a proud computer call his little son? \n" +
                       "A: A microchip off the old block. ",
               "Q: Why did the programmer use the entire bottle of shampoo during one shower? \n" +
                       "A: Because the bottle said \"Lather, Rinse, Repeat.\" ",
               "Q: How does a network administrator nerd greet people who come to his house? \n" +
                       "A: Welcome to 127.0.0.1 "
       };

    }

    public String[] jokesMethod() {
        return jokes;
    }

    public String getDifferentJoke() {
        Random randomJoke = new Random();
        return jokes[randomJoke.nextInt(jokes.length)];
    }

}