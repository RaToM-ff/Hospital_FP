package ua.nure.hospital.utils;

import com.google.common.io.ByteStreams;
import com.google.common.io.Files;
import org.apache.log4j.Logger;
import ua.nure.hospital.command.common.LoginCommand;

import javax.servlet.annotation.MultipartConfig;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

@MultipartConfig
public class FileSaver {

    public static Logger logger = Logger.getLogger(LoginCommand.class);


    public String save(InputStream file, String absoluteSavePath,
                              String relativeSavePath, String fileName) {
        String path = absoluteSavePath + fileName + ".pdf";
            try {
                java.nio.file.Files.write(Paths.get(path), ByteStreams.toByteArray(file));
            } catch (IOException exception) {
                logger.warn(exception.getMessage());
            }
        return relativeSavePath + fileName + ".pdf";
    }
}
