package Model;

import java.io.Serializable;
import java.util.Set;
import java.util.Vector;

public class Admin extends Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    public Admin(String mail, String password) {
        super(mail, password);
    }
}
