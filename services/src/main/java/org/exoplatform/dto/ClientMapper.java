package org.exoplatform.dto;

import org.exoplatform.entity.Client;

public class ClientMapper {

    public static ClientDto clientToDto(Client entity){
        ClientDto res = new ClientDto();

        if(entity != null){
            res.setClientId(entity.getClientId());
            res.setAdresse(entity.getAdresse());
            res.setName(entity.getName());
            res.setEmail(entity.getEmail());
            res.setPrenom(entity.getPrenom());
            if(entity.getArticles() != null)
            res.setArticles(entity.getArticles());
        }
        return res;
    }


}
