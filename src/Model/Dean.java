package Model;
import com.sun.net.httpserver.Request;

import java.io.Serializable;
import java.util.Vector;
import Enum.*;

public class Dean extends Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    Faculty faculty;
    private Vector<Request> Requests;
    private Vector<Request> SignedRequests;
    private Vector<Request> UnSignedRequests;

    public Dean(String mail, String password, Faculty faculty) {
        super(mail, password);
        this.faculty = faculty;
    }

    public void signRequest(Request request){
        this.Requests.add(request);
    }
}
