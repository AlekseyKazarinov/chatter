package sweater.repos;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "usr")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    private boolean active;

    // аннотация помогает формировать доп. таблицу, хранящую enum
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    // описывает, что данное поле хранится в отдельной таблце, для которого
    // не описывалась колонка, соединяется через JoinColumn
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    private Set<Role> roles;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setActive(boolean b) {
        active = b;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
