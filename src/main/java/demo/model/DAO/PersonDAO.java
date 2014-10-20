package demo.model.DAO;

import java.util.List;
import demo.model.Person;
 
public interface PersonDAO {
 
    public void save(Person p);
     
    public List<Person> list();
     
}