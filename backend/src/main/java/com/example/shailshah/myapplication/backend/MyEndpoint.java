/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.example.shailshah.myapplication.backend;

import com.example.TellAJoke;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.myapplication.shailshah.example.com",
                ownerName = "backend.myapplication.shailshah.example.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    /**
     * A simple endpoint method that takes a name and says Hi back
     */
    @ApiMethod(name = "giveAJoke")
    public MyBean giveAJoke() {
        TellAJoke obj = new TellAJoke();
        MyBean joke = new MyBean();
        joke.setData(obj.getDifferentJoke());
        return joke;
    }

}
