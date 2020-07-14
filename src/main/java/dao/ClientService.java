package dao;

import model.Client;
import model.DVD;

import java.util.List;
//todo delete example
public class ClientService {
    private ClientDAO clientsDAO = new ClientDAO();
    public ClientService(){}
    public Client findClient(int id) { return clientsDAO.findById(id);}
    public void saveClient(Client client) { clientsDAO.save(client); }
    public void deleteClient(int clientId) { clientsDAO.delete(clientId);}
    public void updateClient(String fn, String sn, int tel, int clientId) { clientsDAO.update(fn, sn, tel, clientId);}
    public void updateClient(Client client) { clientsDAO.update(client);}
    public List<Client> findAllClients() { return clientsDAO.findAllClients(); }
    public DVD findDVD(int id) { return clientsDAO.findDVDById(id);}
    public void deleteDVD(int id) { clientsDAO.deleteDVD(id);}
    public List<DVD> findAllDVD() {return clientsDAO.findAllDVD();}
    public List<DVD> findDVDbyClient(int clientId){ return clientsDAO.findDVDbyClient(clientId);}
    public void updateDVD(DVD dvd) { clientsDAO.update(dvd); }
}
