import com.andersen.AnnotatedClass;
import com.andersen.TraceApplication;
import com.andersen.TraceInvocationHandler;
import net.sf.cglib.proxy.Enhancer;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestTracer {

    private Logger logger = Logger.getLogger(TestTracer.class);

    @Test
    public void testAnnotation() {
//        logger.info("Start test.");
//        Enhancer enhancer = new Enhancer();
//        enhancer.setSuperclass(AnnotatedClass.class);
//        enhancer.setCallback(new TraceInvocationHandler());
//        AnnotatedClass annotatedClass = (AnnotatedClass) enhancer.create();
//        annotatedClass.annotatedMethod("Igor", 27);
//        annotatedClass.notAnnotatedMethod(27, "Igor");
        ApplicationContext context = new AnnotationConfigApplicationContext(TraceApplication.class);
        AnnotatedClass annotatedClass = (AnnotatedClass) context.getBean("annotatedClass");
        annotatedClass.annotatedMethod("Igor", 27);
        annotatedClass.notAnnotatedMethod(27, "Igor");
    }
}
