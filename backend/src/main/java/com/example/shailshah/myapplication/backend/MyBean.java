package com.example.shailshah.myapplication.backend;

import com.example.TellAJoke;

/**
 * The object model for the data we are sending through endpoints
 */
public class MyBean {

    private TellAJoke tellAJoke;

   public MyBean()
   {
       tellAJoke = new TellAJoke();

   }

   public String getJoke()
   {
       return tellAJoke.getDifferentJoke();

   }
}