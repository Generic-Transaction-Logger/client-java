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
package com.erbjuder.logger.client.logmessage.util;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Stefan Andersson
 */
public class MimeTypes {
    
    public static final String PLAIN_TEXT = "text/plain";
    public static final String BASE64 = "application/base64";
    public static final Set<String> MIME_TYPES = new HashSet<String>();
    
    static {
        MIME_TYPES.add(MimeTypes.BASE64);
        MIME_TYPES.add(MimeTypes.PLAIN_TEXT);
    }
}
