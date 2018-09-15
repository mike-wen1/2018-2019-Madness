# How to Git it all working on your computer

 - Clone [`ftc_app`](http://github.com/MidKnightMadness/ftc_app)
```bash
   $ cd /where/you/want/it
   
   $ git clone http://github.com/MidKnightMadness/ftc_app.git
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