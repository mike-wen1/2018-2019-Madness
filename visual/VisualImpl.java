package org.firstinspires.ftc.teamcode.visual;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.os.Environment;

import com.vuforia.Frame;
import com.vuforia.PIXEL_FORMAT;
import com.vuforia.Vuforia;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by Gregory on 9/14/18.
 */

public class VisualImpl implements Visual {

    private VuforiaLocalizer vuforia;
    Telemetry telemetry;

    @Override
    public void init(Telemetry telemetry) {
        this.telemetry = telemetry;
        // Init the VuforiaLocalizer parameters object with the camera View ID
        VuforiaLocalizer.Parameters params = new VuforiaLocalizer.Parameters(com.qualcomm.ftcrobotcontroller.R.id.cameraMonitorViewId);

        // Set the Back camera active
        params.cameraDirection = VuforiaLocalizer.CameraDirection.BACK;

        // License Key obtained from Vuforia website
        params.vuforiaLicenseKey = "ATqSvW7/////AAAAGSbUe3emc0NmiwFnhuicf+c4388daBpHukK2NzjANrVvP6h1rJRTExnNRD8RBZJqsu5tuVVn+AuayqO2UEZbxp0+ZUbFnXPssyKkV4q8YmYB4AkxHwaJCIxCdd1cCWR9F0xuvve5OOzddkh13v/3T1DSh7vrBuFHurMZF8SLQrwQqMf5ubyit0BRHbtX5GLWwm6hCEOX8ZykrK0UbA8+kyGwSqkWbb5IjUMQrlQpItk1emrxo0S2Mj7z+LCNXBNw9wPvTs4TXnpHvcA/7W0vGFxnbXUcUArUBztNHywpD+rVHjFZYuGJwMsWfHAFKH/OfePAstqGnl3GSJjCrEJqVujQo1cqmC7NmyWd2gxPnqHK";

        // Display axes on top of visual matches
        params.cameraMonitorFeedback = VuforiaLocalizer.Parameters.CameraMonitorFeedback.AXES;

        // Create Vuforia instance with params: -- takes 1-2s
        vuforia = ClassFactory.createVuforiaLocalizer(params);

        // Save an rgb565 image for further processing each frame and only save current frame
        Vuforia.setFrameFormat(PIXEL_FORMAT.RGB565, true);
        vuforia.setFrameQueueCapacity(1);

        // Unable to use Vuforia Targets for minerals :(
    }

    public void inspectFrame(boolean debug) throws InterruptedException {
        VuforiaLocalizer.CloseableFrame frame = vuforia.getFrameQueue().take();

        // One frame contains multiple image formats. Loop through all formats for RGB565
        for (int i = 0; i < frame.getNumImages(); i++) {
            if (frame.getImage(i).getFormat() == PIXEL_FORMAT.RGB565) {

                // Make a Bitmap object out of the vuforia frame (vertically mirrored)
                Bitmap unflippedBmp = Bitmap.createBitmap(frame.getImage(i).getWidth(), frame.getImage(i).getHeight(), Bitmap.Config.RGB_565);
                unflippedBmp.copyPixelsFromBuffer(frame.getImage(i).getPixels());

                Matrix m = new Matrix();
                m.postScale(1, -1);
                Bitmap srcBmp = Bitmap.createBitmap(unflippedBmp, 0, 0, unflippedBmp.getWidth(), unflippedBmp.getHeight(), m, false);
                // Output the height and width of the source image
                telemetry.addLine("Height: " + srcBmp.getHeight());
                telemetry.addLine("Width: " + srcBmp.getWidth());
                int WIDTH = 10;
                int HEIGHT = 6;
                telemetry.addLine("Modified Width: " + WIDTH);
                telemetry.addLine("Modified Height: " + HEIGHT);

                // Scale the Bitmap to a smaller, more reasonable size. (src, width, height, filter?)
                Bitmap outBmp = Bitmap.createScaledBitmap(srcBmp, WIDTH, HEIGHT, false);


                if (debug) {
                    try {
                        // Save Src
                        String name = "Output_" + Math.random();
                        File srcFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), name + "Src.png");
                        FileOutputStream srcStream = new FileOutputStream(srcFile);
                        srcBmp.compress(Bitmap.CompressFormat.PNG, 100, srcStream);
                        srcStream.close();
                        // Save Out
                        File outFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), name + "Out.png");
                        FileOutputStream outStream = new FileOutputStream(outFile);
                        outBmp.compress(Bitmap.CompressFormat.PNG, 100, outStream);
                        outStream.close();
                    } catch (Exception e) {
                        telemetry.addLine(e.toString());
                        telemetry.update();
                    }
                }

                // Eventually store the text image here after processing (letter-representation)
                String[] textImage = new String[HEIGHT];

                // Use letters and telemetry to get a sense of what color ranges we want to look for in the final test
                // Iterate the width of the image


                for (int fx = 0; fx < HEIGHT; fx++) {
                    textImage[fx] = "";
                    for (int fy = WIDTH - 1; fy >= 0; fy--) {
                        if (valueTest(outBmp.getPixel(fy, fx)) < 25) {
                            textImage[fx] += 'A';
                        } else if (valueTest(outBmp.getPixel(fy, fx)) < 50) {
                            textImage[fx] += 'B';
                        } else if (valueTest(outBmp.getPixel(fy, fx)) < 90) {
                            textImage[fx] += 'C';
                        } else if (valueTest(outBmp.getPixel(fy, fx)) < 120) {
                            textImage[fx] += 'D';
                        } else if (valueTest(outBmp.getPixel(fy, fx)) < 150) {
                            textImage[fx] += 'E';
                        } else if (valueTest(outBmp.getPixel(fy, fx)) < 170) {
                            textImage[fx] += 'F';
                        } else {
                            textImage[fx] += 'G';
                        }
                    }
                }

                telemetry.addLine("Letters describe blue-value:");
                for (String line : textImage) {
                    telemetry.addLine(line);
                }
                telemetry.update();
            }
        }
    }

    private int valueTest(int color) {
        return (Color.blue(color) + Color.red(color) + Color.green(color))/3 - 90;
    }

}
