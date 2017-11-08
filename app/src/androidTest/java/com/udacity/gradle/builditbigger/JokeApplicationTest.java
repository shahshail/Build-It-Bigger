package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;
import android.test.ApplicationTestCase;
import android.util.Pair;
import android.widget.ProgressBar;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by shailshah on 11/8/17.
 */

public class JokeApplicationTest extends ApplicationTestCase {

    private ProgressBar mProgressbar = null;

    public JokeApplicationTest() {
        super(Application.class);

    }

    public void  testJokeAppication()
    {
        CountDownLatch countDownLatch;
        String data = null;
        EndpointsAsyncTask task = new EndpointsAsyncTask(getContext(),mProgressbar);

        final AsyncTask<Pair<Context, String>, Void, String> execute = task.execute();
        try
        {
            data = task.get(18, TimeUnit.SECONDS);
            countDownLatch = new CountDownLatch(1);


        } catch (InterruptedException e) {
            e.printStackTrace();
            fail();
        } catch (ExecutionException e) {
            e.printStackTrace();
            fail();
        } catch (TimeoutException e) {
            e.printStackTrace();
            fail();
        }
        assertNotNull("Data is Not available" , data);
    }
}
