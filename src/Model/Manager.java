package Model;
import Enum.*;

public class Manager extends Employee{
    Faculty faculty;
    public Manager(String mail, String password, Faculty falculty){
        super(mail, password);
        this.faculty = falculty;
    }

}