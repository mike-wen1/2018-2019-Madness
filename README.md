# MidKnight Mayhem Team Code 2018-2019!

## Setting up the development environment
1. Open Terminal.app (in `/Applications/Utilities/` or by using spotlight `Cmd-Space 'Terminal'`)
2. Run `open ~/Robotics`. If you have a folder named `ftc_app` there, skip to step 8.
3. Run `mkdir Robotics ; cd Robotics` in the Terminal (creates a Robotics folder in your home directory and enters it)
4. Run `git clone --recursive https://github.com/MidKnightMadness/ftc_app.git` (pulls the latest copy of the SDK from github)
5. If the clone begins to download, you may skip to step 8.
6. If the clone fails and asks to install Developer Tools, follow the instructions until the installation fails or succeeds. If it succeeds, repeat step 4 and continue from there.
7. If the Developer Tools installation fails, download [this CLT.zip file](https://drive.google.com/file/d/1hbAylHCBn1czBi7pAyXGC19QpKIXGkVK/view?usp=sharing), decompress it, drag the file named RUNME onto the Terminal window, and run it (press enter). When it completes (there may be a no process error), you must quit and reopen terminal, and you may delete both the CLT folder and zip file and return to step 4 to continue from there.
8. Run `cd ftc_app ; git pull`
8. Run `cd TeamCode/src/main/java/org/firstinspires/ftc/teamcode` (check spelling)
9. Run `git config push.default upstream`
9. Run `git remote set-url origin https://github.com/MidKnightMadness/2018-2019-{TeamName}.git` where `{TeamName}` is either `Mayhem` or `Madness`.
10. Run `git pull`
11. Run `mkdir ~/Applications ; open ~/Applications`
11. If you already have Android Studio installed, (look in ~/Applications folder you just opened), you may open it and skip to step 20. Otherwise download [Android Studio](https://developer.android.com/studio/)
12. Open `Android Studio.dmg` that you just downloaded.
13. Copy the `Android Studio.app` into the folder  that opened in step 12. (Replace earlier version if any)
14. Eject and delete `Android Studio.dmg`
15. Open `Android Studio.app` that you just copied.
16. If you have had a previous installation of Android Studio, import settings from previous version, otherwise do not import settings.
17. You may choose your theme, but you ___must___ select a __custom install__. When it asks about what components to install, __Deselect Intel HAXM__. We do not need hardware acceleration and it messes with the installation.
18. Finish the installation and `Import project (Gradle, Eclipse ADT, etc.)`
19. Navigate to the Robotics folder (sibling to your Desktop folder) and select the ftc_app folder we cloned earlier.
20. Give it time to index (loading bar at the bottom of the project workspace) and go in the menu bar to `Android Studio > Preferences` and click `Version Control`. Click the plus in the bottom-left corner of the list of version control roots to add a new root.
21. Navigate to `~/Robotics/ftc_app/TeamCode/src/main/java/org/firstinspires/ftc/teamcode` and click ok with type `git`.
22. Remove the other root (named `<Project>` or `ftc_app` or similar) with the minus at the bottom-left and click ok in bottom right.
23. Try to build the project (click hammer in the toolbar) and click any blue links that come up in the log panel at the bottom-right of the workspace. When it says `Gradle build finished`, your installation is working and ready to go!
24. If you encounter any other issues, let me know.

## Troubleshooting
 - Developer Tools does not install: follow step 7.
 - Android Studio gives error on build: Cannot Find valid certification path to requested target: Quit Android Studio, connect to a non-school wifi, then try again.
 - Android Studio gives warning on build: Configuration 'compile' is obsolete and has been replaced with 'implementation' and 'api': This is FTC's problem and can be ignored.

## Introduction to the code
1. I would recommend https://www.tutorialspoint.com/java/ for java language help as well as https://codecademy.org/learn-java, and https://codingame.com/ for more practice learning Java.
2. Open the code in Android Studio and read the comments at the beginnings of the files to understand the layout.

### Notes
 - Each Assembly is contained in a package with an abstract class (Drive...) which describes its abilities (moveBot...) and an implementation that extends the abstract class (TankDrive...).
 - Assembly Interfaces must include a `void init()` method. Otherwise the init method is not visible to Autonomous Programs.
 - The `Config.{Assembly}.NEW` method initializes the Assembly. There is __no need to call init__ in Autonomous programs.
 - If you need to use a loop, add a condition if  `Thread.currentThread().isInterrupted()` then you must exit immediately to prevent App Crash. The Robot Controller is set to crash if an autonomous program takes too long to stop after the stop button is pressed or timeout reached. Ensure your code will stop immediately if it is interrupted.
 - If you need to wait, use `Thread.sleep(long millis)` instead of a while loop. It is easier to understand and will throw InterruptedException if interrupted which will not cause the RC to crash.
