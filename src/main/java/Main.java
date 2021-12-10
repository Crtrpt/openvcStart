

public class Main {

    static {
        System.load("D:\\private\\openvcstart\\src\\main\\cpp\\build\\Debug\\HelloJNI.dll");
    }


    private native void sayHello();

    static public void  main(String[] argv){
        System.out.println("hellojni");
    }
}
