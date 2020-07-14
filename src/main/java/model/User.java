package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collections;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String login;

    @Column
    private String password;

    @ElementCollection(targetClass = ROLE.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<ROLE> roles;

    public User() {
    }

    public User(int id, String login, String password, ROLE role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.roles = Collections.singleton(role);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<ROLE> getRoles() {
        return roles;
    }

    public void setRoles(Set<ROLE> roles) {
        this.roles = roles;
    }

    public enum ROLE {
        USER, ADMIN, UNKNOWN
    }
}
