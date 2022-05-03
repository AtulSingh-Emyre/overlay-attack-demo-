# Overlay Attacks In Android

Overlay attacks in mobile applications are quite famous and can be disastrous. We always hear about being careful about what permissions we are granting to the 3rd party applications installed over our devices. Here, I shall be demonstrating how a granting a single permission can be used for performing overlay attacks over your transaction applications.

*PS: Please do note that this is only for educational purposes and going through the source code of the project, it can be seen that no data is being leaked to a server.*

The motivation for this project is that for being able to prevent overlay attacks and other cyber threats, we should first understand how they work exactly. For the demonstration purposes, we shall be making use of a sensitive permission - **Accessibility Service**

## About Accessibility Service
It is a service provided by the Android API which is meant to help people with disabilities. It largely runs in the background and gets callbacks when certain events lead to firing of the AccessibilityEvents. These events can include:
- A button click
- View focused
- Activity State Changed
- Activity Changed
and so on.

### Using the service for overlay attacks

Now here comes the interesting part - using this service, the application can get the exact text that you have entered in any applications (including password fields), can detect the activity of the application which is open, can write into text fields or click buttons for the user and even track which application is open. Since it allows the application to perform gestures on the screen, the service and also grant itself runtime permissions without the user needing to do so!

For this demo, we shall be using two specific events for attempting an overlay attack:
- TYPE_WINDOW_STATE_CHANGED: This is triggered when there is a complete change in the view. Basically, when activity (or rather the screen) of the applications change.
- TYPE_WINDOW_CONTENT_CHANGED: This is triggered when there is any change in the current active activity. This includes typing in a textview, tapping buttons and so on.

Moreover, using the 
```
performGlobalAction(AccessibilityService.GLOBAL_ACTION_HOME);
```
we can also prevent the user from accessing certain activities, such as the app settings page (which the user can use to uninstall the trojan) or the permissions page. The application can also be set so that it does not appear when searched on the application menu of android.

### Their contribution in Overlay attacks

Generally an overlay attack is done by replacing the active activity of the transaction application with a copy activity originated from the trojan. The service here largely works to identify which activity has been accessed and what is the view structure of the same. It can also be used to study a particular application, the activity names, the exact UI, changes per updates and so on in order to plan the potential future attack better.








