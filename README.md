# How to Git it all working on your computer

 - Clone [`ftc_app`](http://github.com/MidKnightMadness/ftc_app)
```bash
   cd /where/you/want/it
   
   git clone http://github.com/MidKnightMadness/ftc_app.git
   ```
 - Open a terminal window to `ftc_app` folder
```bash
   cd ftc_app/
   
   git submodule update --init
   ```
 - Open it as an android studio project
 - `Preferences` -> `VCS` -> add `TeamCode/src/main/java/org/firstinspires/ftc/teamcode` as git root and remove all other roots
 - Write assemblies and watch it run!
 - If it does not download to phone correctly, run `ssh-keygen` with all default values ONCE
 - If it still does not work, tell one of the team captains
 
### Writing Assemblies

The simplest assembly can be written like this:

```java

@Assembly
public class Drive {

}
```

And you can add `init`, `start`, `loop`, and `stop` public methods to run at the respective times

```java

@Assembly
public class Drive {

    public void init(Telemetry telemetry, HardwareMap hardwareMap) {
      //Runs when the init button is pressed
    }
    
    public void start() {
      //Runs when start button is pressed, but before the loop starts
    }
    
    public void loop(double time, Gamepad gamepad1, Gamepad gamepad2) {
      //Runs in a loop after start pressed, but before the stop button is pressed
    }
    
    public void stop() {
      //Runs after stop button is pressed
    }
}
```

Example `init` method:

```java
public void init(Telemetry telemetry, HardwareMap hardwareMap) {
    telemetry.addLine("Initialized!");
}
```

Note: All the methods listed above are optional they will simply not be called if they do not exist.
