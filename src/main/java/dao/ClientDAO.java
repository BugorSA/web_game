package dao;

import model.Client;
import model.DVD;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

//todo delete example
public class ClientDAO {

    public Client findById(int id) {
        //Вообще хорошо бы предоставить работу с сессией на уровне сервиса
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Client client = session.get(Client.class, id);
        session.close();
        return client;
    }

    public void save(Client client) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(client);
        transaction.commit();
        session.close();
    }

    public void update(String fn, String sn, int tel, int clientId) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.get(Client.class, clientId).setFirstName(fn);
        session.get(Client.class, clientId).setSecondName(sn);
        session.get(Client.class, clientId).setTelephone(tel);
        transaction.commit();
        session.close();
    }
    public void update(Client client) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(client);
        transaction.commit();
        session.close();
    }
    public void update(DVD dvd) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(dvd);
        transaction.commit();
        session.close();
    }

    public void delete(int clientId) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Client clients = session.get(Client.class, clientId);
        session.delete(clients);
        transaction.commit();
        session.close();
    }

    public DVD findDVDById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        DVD dvd = session.get(DVD.class, id);
        session.close();
        return dvd;
    }

    public List<Client> findAllClients() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<Client> client = (List<Client>) session.createQuery("FROM Client").list();
        session.close();
        return client;
    }

    public void deleteDVD(int id){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        DVD dvd = session.get(DVD.class, id);
        session.delete(dvd);
        transaction.commit();
        session.close();
    }

    public List<DVD> findAllDVD(){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<DVD> dvd = (List<DVD>) session.createQuery("FROM DVD").list();
        session.close();
        return dvd;
    }

    public List<DVD> findDVDbyClient(int clientsId){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<DVD> dvds = (List<DVD>) session.createQuery("FROM DVD WHERE client.clientId = " + clientsId).list();
        session.close();
        return dvds;
    }
}
