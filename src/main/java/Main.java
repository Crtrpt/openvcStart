import org.opencv.core.*;
import org.opencv.core.Point;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {


    static public void main(String[] argv) throws IOException {
//        var s=new HelloJNI();
//        s.sayHello();


        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);


        CascadeClassifier faceDetector = new CascadeClassifier("D:\\private\\openvcstart\\src\\main\\resources\\lbpcascades\\lbpcascade_frontalface.xml");
        //CascadeClassifier faceDetector = new CascadeClassifier("D:\\private\\openvcstart\\src\\main\\resources\\lbpcascades\\lbpcascade_frontalface_improved.xml");

        Mat image = Imgcodecs.imread("D:\\private\\openvcstart\\src\\main\\resources\\test.png");
        MatOfRect faceDetections = new MatOfRect();
        System.out.println(faceDetections);
        faceDetector.detectMultiScale(image, faceDetections);
        System.out.println(String.format("检测到 %s 张面孔", faceDetections.toArray().length));
        // 显示相应的面孔
        for (Rect rect : faceDetections.toArray()) {
            Imgproc.rectangle(image, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height), new Scalar(0, 255, 0));
        }
        // 保存到磁盘
        String filename = "output.png";
        System.out.println(String.format("Writing %s", filename));
        Imgcodecs.imwrite(filename, image);

        display(image);

    }


    static void display(Mat image) throws IOException {
        MatOfByte matOfByte = new MatOfByte();
        Imgcodecs.imencode(".jpg", image, matOfByte);
        byte[] byteArray = matOfByte.toArray();

        InputStream in = new ByteArrayInputStream(byteArray);
        BufferedImage bufImage = ImageIO.read(in);
        var dimage=new  ImageIcon(bufImage);
        var dlabel=new JLabel(dimage);
        dlabel.setSize(100,100);
        JFrame frame = new JFrame();
        frame.getContentPane().add(dlabel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
