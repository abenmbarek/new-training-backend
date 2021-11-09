package org.exoplatform.services.utils;
import org.exoplatform.entity.Client;

import java.util.List;

public interface ClientServiceInterface {

    List<Client> getClients() ;//throws Exception;
    Client addClient(Client c) ;//throws Exception;
    void deleteClient(long id);
    Client updateClient(long id,Client c);
}
