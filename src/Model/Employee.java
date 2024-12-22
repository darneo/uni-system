package Model;

import java.io.Serializable;
import java.util.HashMap;

public class Employee extends User implements Serializable {
    private static final long serialVersionUID = 1L;
    private HashMap<Employee, String> Notions;

    public Employee(String mail, String password) {
        super(mail, password);
    }

}