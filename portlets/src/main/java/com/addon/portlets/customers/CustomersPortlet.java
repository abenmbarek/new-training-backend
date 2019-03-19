package com.addon.portlets.customers;

import javax.portlet.*;
import java.io.IOException;

public class CustomersPortlet extends GenericPortlet {
    @Override
    protected void doView(RenderRequest request, RenderResponse response) throws IOException, PortletException {
        PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher("/html-pages/customers.html");
        dispatcher.include(request, response);
    }
}
