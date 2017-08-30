# Android Design Pattern Example, Model View Presenter, MVP

This sample app demonstrates the basic example of MVP pattern in Android. The work flow in this app is as follows.
There is a service which will start on the onResume and stop on the onDestroy of the MainActivity. Every K seconds, this service will **randomly add votes to various types of fruit**, such as Apple, Banana, Cherry, etc. Then it **counts the total number of votes for each types of fruit**, and display the **top N fruits with the most votes**. Since the votes are generated randomly, the top N fruits will change from time to time. 


The **Models** in this example are in the package com.example.androidmvp.data

The **Views** in this example are the Activity classes.

The **Presenters** in this example are the classes with the "Presenter" in their class names.

The **views** are the entry points for user inputs. When the views get the input from the user, it calls a method in the **presenter**, and the presenter fetches the data from the **models** and send back the results to the **Views**, and the Views then displays the results. The relationship among View, Presenter and Model are that **Presenter is like a middle man between the View and the Model**, there is no direct connection between the View and the Model. The View only sends user requests to the Presenter, and updates the ui when Presenter asks it to do so. The Presenter gets user requests from the View, and fetches data from the Model and then tell the View to update the ui accordingly.


In this sample app:
1. The update button is clicked in the **View** (on the activity class)
2. The View calls a method in the **Presenter** for fetching the data
3. The Presenter fetches the data from the **Model** and then calls a display method on the View
4. The View displays the data



