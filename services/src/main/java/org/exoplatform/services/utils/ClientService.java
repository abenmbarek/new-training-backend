package org.exoplatform.services.utils;


import org.exoplatform.dao.ClientDao;
import org.exoplatform.entity.Client;
import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.services.log.Log;

import java.util.List;

public class ClientService implements ClientServiceInterface{

    private ClientDao clientDao;

    private static final Log LOG = ExoLogger.getExoLogger(Client.class);

    /**
     *
     * @param clientDao
     */
    public ClientService(ClientDao clientDao){
        this.clientDao=clientDao;
    }

    @Override
    public List<Client> getClients() {
        return this.clientDao.findAll();
    }

    @Override
    public Client addClient(Client c) {
        Client client = new  Client(  c.getPrenom(),  c.getName(),  c.getAdresse(),  c.getEmail());
        Client res = null;
        try {
            res = clientDao.create(client);
        }catch (Exception e) {
            LOG.error("Cannot create the client", e);
        }
    return res;
    }

    @Override
    public void deleteClient(long id) {
        Client client = this.clientDao.find(id);
        try {
         this.clientDao.delete(client);
    }catch (Exception e) {
            LOG.error("Cannot delete the client", e);
        }
    }

    @Override
    public Client updateClient(long id,Client c) {

        Client client = this.clientDao.find(id);
        client.setEmail(c.getEmail());
        client.setAdresse(c.getAdresse());
        client.setName(c.getName());
        client.setPrenom(c.getPrenom());
        Client res = null;
        try {
           res =this.clientDao.update(client);
        }catch (Exception e) {
            LOG.error("Cannot update the client", e);
        }
        return res;
    }
}