package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.shailshah.myapplication.backend.myApi.MyApi;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

import app.google.shahshail.jokeandoidlibrary.DisplayJokeActivity;

/**
 * Created by shailshah on 11/8/17.
 */

class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {
    private static MyApi jokeApiService = null;
    private Context mContext;
    private ProgressBar mProgressBar;
    private String mFinalResult;
    private InterstitialAd displayAddonFree;

    public EndpointsAsyncTask(Context context, ProgressBar progressBar) {
        this.mContext = context;
        this.mProgressBar = progressBar;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if (mProgressBar != null) {
            mProgressBar.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected String doInBackground(Pair<Context, String>... params) {
        if (jokeApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/").setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            jokeApiService = builder.build();
        }
        try {
            String name = jokeApiService.giveAJoke().execute().getJoke();
            Log.v(EndpointsAsyncTask.class.getSimpleName()," message is  ::" +  name);
            return name;
        } catch (IOException e) {
            return e.getMessage();
        }
    }


    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);

        mFinalResult = result;

        displayAddonFree = new InterstitialAd(mContext);
        displayAddonFree.setAdUnitId("MyDemoUnitId");
        displayAddonFree.setAdListener(new AdListener() {

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                if (mProgressBar != null) {
                    mProgressBar.setVisibility(View.GONE);
                }
                displayAddonFree.show();
            }

            @Override
            public void onAdClosed() {
                super.onAdClosed();
                displayJokes();
            }

            @Override
            public void onAdFailedToLoad(int i) {
                super.onAdFailedToLoad(i);
                if (mProgressBar != null) {
                    mProgressBar.setVisibility(View.GONE);
                }
                displayJokes();
                Log.v(EndpointsAsyncTask.class.getSimpleName(),"Error Code is : " + i);
            }

        });
        AdRequest adRequest = new AdRequest
                .Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("demoDeviceId")
                .build();
        displayAddonFree.loadAd(adRequest);
        Toast.makeText(mContext, "Success", Toast.LENGTH_SHORT).show();
    }

    private void displayJokes() {
        Intent intent = new Intent(mContext, DisplayJokeActivity.class);
        intent.putExtra("joke_service", mFinalResult);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(intent);
    }
}

