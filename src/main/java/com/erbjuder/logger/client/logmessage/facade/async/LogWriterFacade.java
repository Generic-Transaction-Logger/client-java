/* 
 * Copyright (C) 2014 erbjuder.com
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.erbjuder.logger.client.logmessage.facade.async;

import com.erbjuder.logger.client.logmessage.impl.LogMessageContainerImpl;
import com.erbjuder.logger.client.logmessage.interfaces.LogMessage;
import com.erbjuder.logger.client.logmessage.interfaces.LogMessageContainer;
import com.erbjuder.logger.client.logmessage.util.LoggerPropertyKeys;
import com.erbjuder.logger.client.logmessage.util.LoggerPropertyUtil;
import com.erbjuder.logger.client.logmessage.util.LoggerPropertyValues;
import com.erbjuder.logger.client.logmessage.writer.impl.LogWriterGlassFishAsync;
import com.erbjuder.logger.client.logmessage.writer.impl.LogWriterJavaStandaloneAsync;
import com.erbjuder.logger.client.logmessage.writer.impl.LogWriterSAPPIAsync;
import com.erbjuder.logger.client.logmessage.writer.impl.LogWriterWebsphereAsync;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Stefan Andersson
 */
public class LogWriterFacade implements Serializable {

    public void write(LogMessageContainer logMessageContainer) {

        try {
            String environment = LoggerPropertyUtil.getProperty(LoggerPropertyKeys.LOGGING_IN_ENVIRONMENT);
            if (LoggerPropertyValues.LOGGING_IN_ENVIRONMENT_STANDALONE.equalsIgnoreCase(environment)) {
                new LogWriterJavaStandaloneAsync().write(logMessageContainer);
            } else if (LoggerPropertyValues.LOGGING_IN_ENVIRONMENT_GLASSFISHV3.equalsIgnoreCase(environment)) {
                new LogWriterGlassFishAsync().write(logMessageContainer);
            } else if (LoggerPropertyValues.LOGGING_IN_ENVIRONMENT_WEBSPHEREV6.equalsIgnoreCase(environment)) {
                new LogWriterWebsphereAsync().write(logMessageContainer);
            }  else if (LoggerPropertyValues.LOGGING_IN_ENVIRONMENT_SAP_PI_V73.equalsIgnoreCase(environment)) {
                new LogWriterSAPPIAsync().write(logMessageContainer);
            } else {
                Logger.getLogger(LogWriterFacade.class.getName()).log(Level.SEVERE, "Invalid logger.propperies! No prop value=[ LOGGING_IN_ENVIRONMENT ]");
            }

        } catch (Exception ex) {
            Logger.getLogger(LogWriterFacade.class.getName()).log(Level.SEVERE, ex.getMessage());

        }

    }

    public void write(LogMessage logMessage) {
        this.write(new LogMessageContainerImpl(logMessage));
    }
}
