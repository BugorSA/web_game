package dao;

import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import static java.util.Objects.nonNull;

public class UserDAO {

    public User getById(int id) {

        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        User user = session.get(User.class, id);
        session.close();

        return user;
    }


    public void save(User user) {

        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }

    public User.ROLE getRoleByLoginPassword(final String login, final String password) {
        User.ROLE result = User.ROLE.UNKNOWN;
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<User> users = (List<User>) session.createQuery("FROM User ").list();
        User user1 = new User();
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                if (user.getPassword().equals(password)) {
                      user1 = user;
                }
            }
        }
        session.close();
        if (nonNull(user1.getLogin()))
            result = user1.getRoles().iterator().next();
        return result;
    }

    public boolean userIsExist(final String login, final String password) {

        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<User> users = (List<User>) session.createQuery("FROM User ").list();
        if (users.size() == 0)
            return false;
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                if (user.getPassword().equals(password)) {
                    session.close();
                    return true;
                }
            }
        }
        session.close();

        return false;
    }

    public List<User> findAllUser() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<User> users = (List<User>) session.createQuery("FROM User ").list();
        session.close();
        return users;
    }
}

