
# cs480-queue-rhythm
===

## Table of Contents
1. [Overview](#Overview)
1. [Product Spec](#Product-Spec)
1. [Wireframes](#Wireframes)
2. [Schema](#Schema)

## Overview

### Description

QueueRhythm is a simple app that allows users to create a collaborative Spotify playlist to share and listen to music  together. 

### App Evaluation

- **Category:** Social / Music
- **Mobile:** This app will only be developed for mobile devices.
- **Story:** The user can search for music on Spotify, then add to playlist. The user then can invite others to contribute songs and listen to the same playlist synchronously. 
- **Market:** This app will be available to everyone.  
- **Scope:**If user base grows large enough more advanced features could be implemented. Things like public playlist and chat boxes.

### Build Instructions 

Open terminal and type:

```
git clone https://github.com/humboldt-cs/cs480-queue-rhythm.git

cd  ~/Desktop/cs480-queue-rhythm

keytool -list -v -keystore ~/.android/debug.keystore -alias androiddebugkey -storepass android -keypass android

```
You should expect to receive a fingerprint that looks like this: 
```
SHA1: E7:47:B5:45:71:A9:B4:47:EA:AD:21:D7:7C:A2:8D:B4:89:1C:BF:75
```
Copy the fingerprint and your package name and enter it in the Spotify Developer Dashboard.

### Additional Github Repos in dependencies
- https://github.com/spotify/android-sdk

## Product Spec

### 1. User Stories (Required and Optional)

**Required Must-have Stories**

* User can access current playlist and media player/home-screen

* User searches music on spotify then adds to playlist.

* User invites others to contribute songs and listen to the same playlist.


**Optional Nice-to-have Stories**

* User can set queue to public so it does not require session ID.

* Profile Page - Allows user to personalize their page

* Public Queues - Make queues accessible without session ID

* Chat Room - Each queue comes with its own chat room

* Favorites List/Auto-add - Saves favorite songs to a list, allowing them to be auto-added to your current queue


### 2. Screen Archetypes

* Media Players/main queue screen
   *  Allows the control of media playback
   *  Allows user to create or join queues
* Create Queue Analyzes users music choices, and connects them to other users with similar choices. The user can then decide to message this person and befriend them if wanted.
   *  Allows user to create a queue: create queue name
*  Creating a queue generates a session ID, allowing user to invite others to queue.

* Search Music
   *  User can search music to add to queue

* Detail Page
   *  User can see the list of music on queue
   *  User can see a frame of current song info(video or album cover, Song Title, Artist, and current position in song.

* Edit Page
   *  User can edit queue information
   *  User can delete queue
   
### 3. Navigation

**Tab Navigation** (Tab to Screen)

* Queue Changer
* Media Playback

**Flow Navigation** (Screen to Screen)

* Create Queue
   *  Home 
* Change Queue 
   *  Home

* Settings Page
   *  Login Page
   *  Edit Queue

* Search Music
   *  Home

* Detail Page
   *  Edit Page 
   *  Invite
   *  Settings
   *  Search Music
 
* Edit Page
   *  Home 

## Wireframes

<img src="extra content/handdrawn_Page_1.png" width=600> &nbsp;
<img src="extra content/handdrawn_Page_2.png" width=600> &nbsp;
<img src="extra content/handdrawn_Page_3.png" width=600> <br>


### [BONUS] Digital Wireframes & Mockups

<img src="extra content/1 authentication pages.png" width=600> &nbsp;
<img src="extra content/2 queue action pages.png" width=600> &nbsp;
<img src="extra content/3 User Pages.png" width=600> &nbsp;
<img src="extra content/4 Guest Pages.png" width=600> <br>

