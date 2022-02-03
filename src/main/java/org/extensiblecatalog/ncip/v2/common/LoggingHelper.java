package org.extensiblecatalog.ncip.v2.common;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import org.apache.logging.log4j.Level;
import org.extensiblecatalog.ncip.v2.service.PhysicalAddressType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.extensiblecatalog.ncip.v2.service.ServiceException;

public class LoggingHelper {
    protected static final int ARRAY_SIZE = 1024;
    private static final Logger logger = LoggerFactory.getLogger(LoggingHelper.class);


    public LoggingHelper() {
    }

    public static <S extends InputStream> S copyAndLogStream(Logger log, Level level, S inputStream) {

        boolean isEnabled = true;
        if (isEnabled) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

            try {
                boolean chunk = false;
                byte[] data = new byte[1024];

                int chunk1;
                while(-1 != (chunk1 = inputStream.read(data))) {
                    byteArrayOutputStream.write(data, 0, chunk1);
                }
            } catch (IOException var9) {
                log.warn("IOException copying the initiation message's InputStream for logging.", var9);
            }

            InputStream loggingCopy = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            StringWriter strWriter = new StringWriter();

            try {
                ToolkitHelper.prettyPrintXML(loggingCopy, strWriter);
                logger.info(strWriter.toString());
            } catch (ServiceException var8) {
                log.warn("ServiceException prettyPrinting the InputStream to a String for logging.", var8);
            }
            return (S) (new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
        } else {
            return inputStream;
        }
    }
}
