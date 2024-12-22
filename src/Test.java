
import Controller.UserController;
import Model.User;
import View.*;
import Enum.*;

import java.util.Vector;
import Model.*;
import data.*;
import Controller.*;
import uniUtil.*;

import static data.Database.*;

public class Test {
    public static void main(String[] args) {
        Database.NewsDB = new Vector <>();
        Database.saveNewsDB();
    }
}
