/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2012, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.gatein.portal.samples.ipc;


import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class ProducerPublicRenderParameterPortlet extends GenericPortlet {

    public void doView(RenderRequest request, RenderResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        String publicParameter = request.getParameter("publicParameter");

        if (publicParameter != null) {
            writer.write("<pre>  getParameter(\"publicParameter\") = " + publicParameter + "</p>");
        }

        PortletURL actionUrl = response.createActionURL();
        String form ="<form method=\"post\" action=\"" + actionUrl + "\">" +
                "<pre>  set(\"publicParameter\") = <input type=\"text\" value=\"\" name=\"newPublicParameter\" />" +
                "<input type=\"submit\" value=\"Set\" /></pre>" +
                "</form>";
        writer.write(form);
        writer.close();
    }

    public void processAction(ActionRequest request, ActionResponse response) throws PortletException, IOException {
        String newPublicParameter = request.getParameter("newPublicParameter");
        response.setRenderParameter("publicParameter", newPublicParameter);
    }
}
