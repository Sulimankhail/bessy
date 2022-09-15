package bessy.hzb.application.machine;

public class NativeBridgeWithCPP {

    static {
        System.loadLibrary("native");
    }
    public native double[] sayHello(double [] ps, String name ,String type, double length);

}
