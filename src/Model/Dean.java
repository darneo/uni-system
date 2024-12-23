package Model;

import java.io.Serializable;
import java.util.Vector;
import Enum.*;
import uniUtil.*;

public class Dean extends Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    // Конструктор
    public Dean(String mail, String password) {
        super(mail, password);
    }

}
