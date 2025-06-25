package io;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.Instant;

public class FilesDemo {

    public static void append() {

        // Example: Writing String using Files.writeString(Path, CharSequence) - Java11+
        String str = "Last updated:" + Instant.now().toString() + "\n";
        Path path = Paths.get("files_writestring_append.txt");

        try {
            // Combining CREATE and APPEND allows it to create the file if it doesn't exist,
            // or append if it does.
            Files.writeString(path,
                    str,
                    StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        append();
    }
}
