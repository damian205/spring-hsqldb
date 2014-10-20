package demo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
 
import demo.model.DAO.PersonDAO;
import demo.model.Person;

@RestController
@RequestMapping(value = "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
public class HelloWorldController {

    @RequestMapping
    public String sayHello(){
        return "Hello World";
    }
    
    @RequestMapping(value = "/database")
    public String databaseTest(){
    	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        
        PersonDAO personDAO = context.getBean(PersonDAO.class);
         
        Person person = new Person();
        person.setName("Pankaj"); person.setCountry("India");
         
        personDAO.save(person);
         
        System.out.println("Person::"+person);
         
        List<Person> list = personDAO.list();
         
        String result = new String();
        for(Person p : list){
        	result = result + "Person List::"+p;
        }
        //close resources
        context.close();  
        return result;
    }
}