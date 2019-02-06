package org.exoplatform.stock.services.rest;

import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.services.log.Log;
import org.exoplatform.services.rest.resource.ResourceContainer;
import org.exoplatform.stock.dao.ClientOrderDao;

import javax.ws.rs.Path;

@Path("clientOrder")
public class ClientOrderRestService implements ResourceContainer {

    private static Log log= ExoLogger.getLogger(ClientOrderRestService.class);

    private ClientOrderDao clientOrderDao;
}
