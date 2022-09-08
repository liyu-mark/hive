import org.apache.hadoop.hive.ql.exec.UDFArgumentException;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDF;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.primitive.PrimitiveObjectInspectorFactory;

public class udf_all_length extends GenericUDF {

    /**
     * hive> add jar /usr/local/hive/lib/hive-1.0-SNAPSHOT.jar;
     * hive> create temporary function udf_all_length as "udf_all_length";
     * hive> select udf_all_length('aaa','ccc');
     * @param arguments
     * @return
     * @throws UDFArgumentException
     */
    public ObjectInspector initialize(ObjectInspector[] arguments) throws UDFArgumentException {
        if(arguments.length==0){
            throw new UDFArgumentException("参数为空");
        }
        return PrimitiveObjectInspectorFactory.javaIntObjectInspector;
    }

    public Object evaluate(DeferredObject[] deferredObjects) throws HiveException {
        int ans = 0;
        for (DeferredObject obj : deferredObjects) {
            ans += obj.get().toString().length();
        }
        return ans;
    }

    public String getDisplayString(String[] strings) {
        return "";
    }
}
