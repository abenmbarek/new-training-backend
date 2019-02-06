package org.exoplatform.stock.services.utils;

import org.exoplatform.stock.dao.ClientDao;
import org.exoplatform.stock.entity.Client;

import java.util.List;

public class ClientService {

    private ClientDao clientDao;

    /**
     *
     * @param clientDao
     */
    public ClientService(ClientDao clientDao){
        this.clientDao=clientDao;
    }

    public List<Client> getAddClient(){
        return this.clientDao.findAll();
    }
}
