package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String login;

    public List<Game> getGameList() {
        return gameList;
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Game> gameList;

    @Column
    private String password;

    @ElementCollection(targetClass = ROLE.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<ROLE> roles;

    public User() {
    }

    public User(String login, String password, ROLE role) {
        this.login = login;
        this.password = password;
        this.roles = Collections.singleton(role);
        this.gameList = new ArrayList<>();
    }

    public void addGame(Game game){
        game.setUser(this);
        gameList.add(game);
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Set<ROLE> getRoles() {
        return roles;
    }

    public int getId() {
        return id;
    }

    public enum ROLE {
        USER, ADMIN, UNKNOWN
    }
}
