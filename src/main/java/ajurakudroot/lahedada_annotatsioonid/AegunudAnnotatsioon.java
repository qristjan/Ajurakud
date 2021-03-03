package ajurakudroot.lahedada_annotatsioonid;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@java.lang.Deprecated(since = "EI OLE TEGELT")
@AegunudAnnotatsioon(Reason = "This is deprectaed",Developer = "ABDUL")
@Target({ElementType.METHOD, ElementType.LOCAL_VARIABLE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface AegunudAnnotatsioon {
    String Developer() default "Rahul";
    String Reason();
}
