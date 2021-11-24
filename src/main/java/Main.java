import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.osgi.OpenCVInterface;

public class Main {
    static public void  main(String[] argv){
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);


        //Reading the Image from the file
        Mat src = Imgcodecs.imread("./test.png");
        HighGui.imshow("", src);
        //Converting color to gray scale
        Mat gray = new Mat(src.rows(), src.cols(), src.type());
        Imgproc.cvtColor(src, gray, Imgproc.COLOR_RGB2GRAY);
        HighGui.imshow("Gray Scale Image", gray);
        //Applying canny
        Mat dst = new Mat(src.rows(), src.cols(), src.type());
        Imgproc.Canny(gray, dst, 100, 100*3);
        HighGui.imshow("Edges", dst);
        HighGui.waitKey();
    }
}
