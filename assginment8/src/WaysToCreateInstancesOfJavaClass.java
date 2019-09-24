import java.io.ObjectInputStream;
import java.io.FileInputStream;

public class WaysToCreateInstancesOfJavaClass {
    private static WaysToCreateInstancesOfJavaClass getWaysToCreateInstancesOfJavaClass()
    {
        return new WaysToCreateInstancesOfJavaClass();
    }

    public static void main(String[] args)throws Exception {
        //First way using new keyword.
        WaysToCreateInstancesOfJavaClass referenceVar, referenceVar1 = new WaysToCreateInstancesOfJavaClass();
        //Second way using Class.forName().newInstance();
        referenceVar = (WaysToCreateInstancesOfJavaClass)Class.forName("WaysToCreateInstancesOfJavaClass").newInstance();
        //Third way using clone()
        referenceVar = (WaysToCreateInstancesOfJavaClass)referenceVar1.clone();
        //Fourth way by deserializing an object.
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream());
        referenceVar = (WaysToCreateInstancesOfJavaClass)inputStream.readObject();
        //Fifth way is to use fctory method.
        referenceVar = WaysToCreateInstancesOfJavaClass.getWaysToCreateInstancesOfJavaClass();
    }
}
