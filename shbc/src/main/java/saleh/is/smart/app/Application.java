package saleh.is.smart.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import saleh.is.smart.app.domain.Patient;

public class Application {
    public static void main(String[] args) {
        /*Patient patient = new Patient();
        patient.speak();*/

        // make patient as spring bean
        String beanPath = "beans.xml";

        ApplicationContext context = new ClassPathXmlApplicationContext(beanPath);

        Patient patient = (Patient) context.getBean("patient");
        //patient.speak();
        System.out.println(patient);




        ((ClassPathXmlApplicationContext)context).close();
    }
}
