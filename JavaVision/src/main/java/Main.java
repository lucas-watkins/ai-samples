package JavaVision;

import JavaVision.Python;
import nu.pattern.OpenCV;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.videoio.VideoCapture;

import javax.swing.*;

import java.io.IOException;

import static org.opencv.imgcodecs.Imgcodecs.imencode;

public class Main {
    public static void main(String[] args) throws IOException {
        // load opencv
        /*
        OpenCV.loadLocally();
        VideoCapture camera = new VideoCapture(1);
        Mat frame = new Mat();
        camera.read(frame);
        JFrame jFrame = new JFrame();

        MatOfByte buffer = new MatOfByte();
        imencode(".png", frame, buffer);

        ImageIcon image = new ImageIcon(buffer.toArray());
        JLabel label = new JLabel(image);
        jFrame.add(label);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setSize(500,500);
        jFrame.setVisible(true);
         */

        String objects = Python.getString(Python.getInputStreamArg("src/main/onetime_prediction.py", "/Users/lucas/Documents/MyScripts/YOLO_ObjectDetection/JavaVision/src/test/bus.jpg").readAllBytes());
        System.out.println(objects);
    }
}
