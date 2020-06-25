package hub.guzio.MinecraftFTP.commands;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

//Wget command. Usage: /wget <URL> [filename] OR /wget %dir% <dirname>

//Copyright (C) Guzio 2020. All rights reserved.
//License still apply, though, I just wanted to type "All rights reserved".
//*UNLESS OTHERWISE NOTED!!!
//(i.e. if you changed something, don't hesitate to add your name)

public class Wget {
    public static void main(String[] args) throws Exception{
        URL website = new URL("https://google.com");
        try (InputStream in = website.openStream()) {
            Files.copy(in, Path.of("google.html"), StandardCopyOption.REPLACE_EXISTING);
        }
    }
}