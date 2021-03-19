import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class demo {

    private static Logger log= LogManager.getLogger(demo.class.getName());
    public static void main(String[] args)
    {
        System.out.println("hello");

        log.error("Object is not present");
        log.fatal("This is fatal");
        log.debug("I am debugig");
        log.info("Object is  present");

    }
}
