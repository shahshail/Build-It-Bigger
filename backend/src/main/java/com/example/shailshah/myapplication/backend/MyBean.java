package com.example.shailshah.myapplication.backend;

/**
 * The object model for the data we are sending through endpoints
 */
public class MyBean {

    private String data;


   public String getJoke()
   {
       return data;

   }

    public void setData(String data) {
        this.data = data;

    }
}