package Model;
import java.io.Serializable;

public abstract class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private String username;
    private String password;


    // Конструктор, принимающий только username и password
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Геттеры
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // Метод toString
    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    // Метод equals для сравнения пользователей по username
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        User user = (User) obj;
        return username.equals(user.username);
    }

    // Метод hashCode
    @Override
    public int hashCode() {
        return username.hashCode();
    }
}
