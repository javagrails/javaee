package spring.concepts.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.concepts.app.beans.Bird;
import spring.concepts.app.domain.ContactBook;

/**
 * A Spring Application
 */
public class Application {

  public static void main(String[] args) {
    main1();
    main2();
  }

  public static void main1() {
    // normal java class run
        /*Person person = new Person();
        person.talk();*/

    // access by bean.xml
    //ApplicationContext context = new FileSystemXmlApplicationContext("beans.xml");
    ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    Bird bird1 = (Bird) context.getBean("bird");
    Bird bird2 = (Bird) context.getBean("bird");

    bird1.setName("Crow");
    System.out.println(bird1);
    System.out.println(bird2);

    //Food food = (Food) context.getBean("food");
    //System.out.println(food);

    ((ClassPathXmlApplicationContext) context).close();
  }

  public static void main2() {
        /*Patient patient = new Patient();
        patient.speak();*/

    // make patient as spring bean
    String beanPath = "beans/beans.xml";

    ApplicationContext context = new ClassPathXmlApplicationContext(beanPath);

    ContactBook contacts = (ContactBook) context.getBean("contactbook");

    System.out.println(contacts);
    ((ClassPathXmlApplicationContext) context).close();
  }
}
