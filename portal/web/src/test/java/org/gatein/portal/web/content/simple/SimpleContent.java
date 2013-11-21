/*
 * Copyright (C) 2012 eXo Platform SAS.
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
package org.gatein.portal.web.content.simple;

import java.io.Serializable;
import java.util.Collections;
import java.util.Locale;
import java.util.Map;

import javax.xml.namespace.QName;

import juzu.Response;
import org.gatein.portal.content.RenderTask;
import org.gatein.portal.content.WindowContent;
import org.gatein.portal.content.WindowContentContext;
import org.gatein.portal.content.Result;
import org.w3c.dom.Element;

/**
 * @author Julien Viet
 */
class SimpleContent extends WindowContent<SimpleState> {

    /** . */
    private final String id;

    /** . */
    private String windowState;

    /** . */
    private String mode;

    SimpleContent(String id, String windowState, String mode) {
        this.id = id;
        this.windowState = windowState;
        this.mode = mode;
    }

    @Override
    public RenderTask createRender(WindowContentContext<SimpleState> window) {
        return new RenderTask() {
            @Override
            public Result execute(Locale locale) {
                return new Result.Fragment(
                        Collections.<Map.Entry<String, String>>emptyList(),
                        Collections.<Element>emptyList(),
                        "the_title",
                        "<div id=\"" + id +  "\">the_content</div>");
            }
        };
    }

    @Override
    public Result processAction(WindowContentContext<SimpleState> window, String windowState, String mode, Map<String, String[]> interactionState) {
        throw new UnsupportedOperationException("todo");
    }

    @Override
    public Response serveResource(WindowContentContext<SimpleState> window, String id, Map<String, String[]> resourceState) {
        throw new UnsupportedOperationException("todo");
    }

    @Override
    public String resolveTitle(Locale locale) {
        throw new UnsupportedOperationException("todo");
    }

    @Override
    public String getParameters() {
        return null;
    }

    @Override
    public void setParameters(String s) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isSupportedWindowState(String ws) {
        return true;
    }

    @Override
    public String getWindowState() {
        return windowState;
    }

    @Override
    public void setWindowState(String ws) {
        this.windowState = ws;
    }

    @Override
    public boolean isSupportedMode(String mode) {
        return true;
    }

    @Override
    public String getMode() {
        return mode;
    }

    @Override
    public void setMode(String m) {
        this.mode = m;
    }

    @Override
    public Map<String, String[]> computePublicParameters(Map<QName, String[]> parameters) {
        return Collections.emptyMap();
    }

    @Override
    public Iterable<Map.Entry<QName, String[]>> getPublicParametersChanges(Map<String, String[]> changes) {
        return Collections.emptyList();
    }

    @Override
    public WindowContent<SimpleState> copy() {
        return new SimpleContent(id, windowState, mode);
    }
}
