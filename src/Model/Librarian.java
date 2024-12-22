package Model;
import uniUtil.*;

import java.io.Serializable;
import java.sql.Struct;
import java.util.HashMap;
import java.util.Vector;

public class Librarian extends Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    public Librarian(String mail, String password){
        super(mail, password);
    }
}
