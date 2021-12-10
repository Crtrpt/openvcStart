public class HelloJNI {

    static {
        try {
            System.load("D:\\private\\openvcstart\\src\\main\\cpp\\build\\Debug\\HelloJNI.dll");
        }catch (UnsatisfiedLinkError e) {
            System.err.println("Native code library failed to load.\n" + e);
            System.exit(1);
        }
    }

    native void sayHello();

}
