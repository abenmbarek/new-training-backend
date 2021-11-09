package org.exoplatform.services.utils;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import exo.platform.models.Client;

public class AddonServices implements AddonServicesInterface {

	@Override
	public List<Client> getAllClients() throws Exception {
		// TODO Auto-generated method stub
		
		List<Client> list = new ArrayList<Client>() ;
		for(int i=0;i<10;i++) {
			Client c = new Client();
			c.setId(i);
			c.setName("item "+i);
			list.add(c) ;
		}
		return list ;
	}
}
