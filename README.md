# Build-It-Bigger
Build-IT-Bigger is simple joke telling android app deployed on GCE(Google Cloud Endpoints). Instead of fetching jokes directly from java library, This app uses GCE development server to pull jokes from server via async task. 

This app contains adMob test ad in Free flavor. 

## Modules
This app consists of four modules:
- A Java library that provides jokes
- A Google Cloud Endpoints (GCE) project that serves those jokes
- An Android Library containing an activity for displaying jokes
- An Android app that fetches jokes from the GCE module and passes them to the Android Library for display

## Features
- Shared code between Paid and Free Flavors.
- This app has factor reusable functionality into a java library
- This app has factor reusable Android functionality for an Android library
- Gradle App Engine plugin to deploy backend
- Configured Test suits runs against the local App Engine development server.

## Google Cloud Endpoints:
GCE has a straight forward workflow and it is optimized for docker container environment, so we can host our app anywhere docker is supported.

Advantage of using this app is we can use Google Cloud Endpoints AppEngine with ios, Android or web client.

For this app GCE runs on localhost 8080 port. and uses API version "v-1"

### GCE Logs
![atp txt](https://github.com/shahshail/Build-It-Bigger/blob/master/Screenshots/gec.png)

### Abstract Module startup Page
![atp txt](https://github.com/shahshail/Build-It-Bigger/blob/master/Screenshots/gec_page.png)

## Getting Started
* Clone the repository :

    ``` git clone https://github.com/shahshail/Build-It-Bigger.git ```
* Build this project, using either the gradlew build command or using Import Project in Android Studio

## Flavors 
- This app contains two Flavors Paid and Free.
- In Paid flavor the adMob ad will be hidden and it will show in free version.
![atp txt](https://github.com/shahshail/Build-It-Bigger/blob/master/Screenshots/flavors.png)

## Screenshots

### Free Version HomeScreen
![atp txt](https://github.com/shahshail/Build-It-Bigger/blob/master/Screenshots/free.png)

### Paid Version HomeScreen
![atp txt](https://github.com/shahshail/Build-It-Bigger/blob/master/Screenshots/paid.png)

### Joke Screen
![atp txt](https://github.com/shahshail/Build-It-Bigger/blob/master/Screenshots/joke1.png)

