/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.generic.logger.client.logmessage.interfaces;

import java.io.Serializable;

/**
 *
 * @author ds38745
 */
public interface LogMessageData extends Serializable {

    public String getContentDescription();

    public void setContentDescription(String contentDescription);

    public String getContent();

    public void setContent(String content);

    public String getContentMimeType();

    public void setContentMimeType(String contentMimeType);
}
