package saleh.is.smart.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import saleh.is.smart.app.domain.Address;
import saleh.is.smart.app.domain.ContactBook;
import saleh.is.smart.app.domain.Patient;

public class Application {
    public static void main(String[] args) {
        /*Patient patient = new Patient();
        patient.speak();*/

        // make patient as spring bean
        String beanPath = "beans/beans.xml";

        ApplicationContext context = new ClassPathXmlApplicationContext(beanPath);

        ContactBook contacts = (ContactBook) context.getBean("contactbook");

        System.out.println(contacts);




        ((ClassPathXmlApplicationContext)context).close();
    }
}
