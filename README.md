# RepTracker

### An Android app that tracks voting info on members of Congress to help citizens stay informed on their public officials.
by: Mick Sexton

## Description

Users can search for representatives and view their voting record on bills. These bills will be ordered from most recent to oldest (their may be a limit on how many listed). Users can click on an individual vote to learn more details about the bill proposed. Users can also flag or save a chosen representative for quicker access next time they want to view their voting record.

## Prerequisites

You will need access to Android Studio or an Android phone to run the app.

## Installation

You will need to download the RepTracker app from the Google Play Store, or if it is not yet available, you can download from my GitHub repo at:
    https://github.com/PioneerX1/RepTracker
Load on an Android emulator or your Android phone and run the app.

## Code Specs

|Behavior - Plain English|Input|Output|
|---|---|---|
|User is on login screen.|User enters their login info correctly into the username and password fields.|User is then directed to the main activity where they can begin using the app.|
|User is on login screen.|User does not have an account so they hit create an account / register.|User is sees a sign up form.|
|User sees the sign up form to register a new account.|User completes their info and credentials to create an account and submits.|User is then logged in with their new account and directed to the main activity.|
|User is on the main activity.|User starts typing in a rep name or state into search field.|User sees a list of results below.|
|User sees list of search results for a rep.|User taps on their rep of choice.|User is directed to a rep detail activity.|
|User is on Rep Detail Activity, where they see information on the rep, and below is a list of bills they have voted on, along with YEA, NEH, or ABSENT listed in bright colors.|User taps on an individual vote from the list.|User is directed to a Bill Detail Activity where they see more details on the bill proposed (data on the rep's name and voting choice persist here.|
|User is on Rep Detail Activity again.|User taps on Save this Rep button to keep track of them.|User sees a Toast confirmation that rep is saved.|
|User is on Main Activity again.|User selects View Saved Reps.|User sees a List of their Saved Reps, mainly name, title, and state or location.|
|User is on Saved Rep List Activity where they see their saved reps.|User taps on a specific rep.|User sees the Rep Detail Activity again with list of their votes beneath.|


## Known Bugs

There are no known bugs at this time.

## Support and Contact Details

Please contact the developer, Mick Sexton, at lacrookedbeat@hotmail.com for any questions, feedback, or concerns.

## Technologies Used

Technologies used include Java, Android Studio, XML, Git, Firebase, and the Vote API.

## License

This software operates under the MIT license.

Copyright (c) 2017 - Mick Sexton



