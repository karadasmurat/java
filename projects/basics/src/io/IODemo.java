package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Console;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class Cat implements Serializable { // NOT Serializable
    private Tail tail = new Tail();
}

class Tail implements Serializable {
    private Fur fur = new Fur();
}

class Fur {
}

class Gorilla implements Serializable {
}

public class IODemo {

    void charStreams() throws IOException {

        InputStream in = new FileInputStream("data.txt");
        in.close();

        // Option 1: Explicitly constructs the bridge
        Reader reader = new InputStreamReader(new FileInputStream("data.txt"));
        reader.close();

        // Option 2: Convenience class
        Reader reader2 = new FileReader("data.txt");
        reader2.close();

        BufferedReader br = new BufferedReader(reader2);
        br.close();
    }

    void saveToFile(List<Gorilla> gorillas, File dataFile) throws IOException {
        try (var oos = new ObjectOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(dataFile)))) {
            for (Gorilla gorilla : gorillas)
                oos.writeObject(gorilla);
        }
    }

    List<Gorilla> readFromFile(File dataFile) throws IOException,
            ClassNotFoundException {
        var gorillas = new ArrayList<Gorilla>();
        try (var in = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream(dataFile)))) {
            while (true) {
                var object = in.readObject();
                if (object instanceof Gorilla g)
                    gorillas.add(g);
            }
        } catch (EOFException e) {
            // File end reached
        }
        return gorillas;
    }

    public static void inputOutputStreams() {
        InputStream in;
        try {
            InputStream fis = new FileInputStream("file.txt");
            BufferedInputStream bis = new BufferedInputStream(fis);
            int data = bis.read();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try (InputStream in2 = new BufferedInputStream(new FileInputStream("file.txt"))) {
            try {
                int data = in2.read();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void info(Path path) throws IOException {
        if (Files.exists(path))
            System.out.println("Absolute Path: " + path.toAbsolutePath());

    }

    public static void infoIO(File file) {
        if (file.exists()) {
            System.out.println("Absolute Path: " + file.getAbsolutePath());
            System.out.println("Is Directory: " + file.isDirectory());
            System.out.println("Parent Path: " + file.getParent());
            if (file.isFile()) {
                System.out.println("Size: " + file.length());
                System.out.println("Last Modified: " + file.lastModified());
            } else {
                for (File subfile : file.listFiles()) {
                    System.out.println(" " + subfile.getName());
                }
            }
        }
    }

    public static void infoNIO(Path path) throws IOException {
        if (Files.exists(path)) {
            System.out.println("Absolute Path: " + path.toAbsolutePath());
            System.out.println("Is Directory: " + Files.isDirectory(path));
            System.out.println("Parent Path: " + path.getParent());
            if (Files.isRegularFile(path)) {
                System.out.println("Size: " + Files.size(path));
                System.out.println("Last Modified: " + Files.getLastModifiedTime(path));
            } else {
                try (Stream<Path> stream = Files.list(path)) {
                    stream.forEach(p -> System.out.println(" " + p.getFileName()));
                }
            }
        } else {
            System.out.println("File does not exist" + path);
        }
    }

    public static void printPathInformation(Path path) {
        System.out.println("Absolute Path: " + path.toAbsolutePath());
        System.out.println("Filename is: " + path.getFileName());
        System.out.println(" Root is: " + path.getRoot());
        Path currentParent = path;
        while ((currentParent = currentParent.getParent()) != null)
            System.out.println(" Current parent is: " +
                    currentParent);
        System.out.println();
    }

    public static void printParentRecursive(Path path) {
        if (path == null) {
            return;
        }
        System.out.println("Current path: " + path);
        System.out.println("Current file: " + path.getFileName());
        printParentRecursive(path.getParent());
    }

    void copyStream(InputStream in, OutputStream out) throws IOException {
        int b;
        while ((b = in.read()) != -1) {
            out.write(b);
        }
    }

    void copyStream(Reader in, Writer out) throws IOException {
        int b;
        while ((b = in.read()) != -1) {
            out.write(b);
        }
    }

    void copyStreamv2(InputStream in, OutputStream out) throws IOException {
        int batchSize = 1024;
        var buffer = new byte[batchSize];
        int lengthRead;
        while ((lengthRead = in.read(buffer, 0, batchSize)) > 0) {
            out.write(buffer, 0, lengthRead);
            out.flush();
        }
    }

    void copyTextFile(File src, File dest) throws IOException {
        try (var reader = new BufferedReader(new FileReader(src));
                var writer = new BufferedWriter(new FileWriter(dest))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
        }
    }

    public static void main(String[] args) {

        Path filePath = Paths.get("data/file.txt");
        Path dirPath = Paths.get("data/folder");

        try {
            Files.createFile(filePath); // Creates an empty file at data/file.txt
            Files.createDirectory(dirPath); // Creates a directory at data/folder
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // file.separator is a system property that returns the file separator for the
        // current OS
        // For example, on Windows it returns "\"
        // and on Unix/Linux it returns "/"
        // This is useful for writing cross-platform code
        System.out.println(System.getProperty("file.separator"));

        // 1. File I/O
        // Many older libraries use File
        File file0 = new File("test0.txt");

        try {
            File zooFile1 = new File("createdUsingFileConstructor.txt");
            if (zooFile1.createNewFile()) {
                System.out.println("File created: " + zooFile1.getName());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        File zooFile2 = new File("/home/tiger", "data/stripes.txt");
        File parent = new File("/home/tiger");
        File zooFile3 = new File(parent, "data/stripes.txt");

        // Since Path is an interface, we can’t create an instance directly.
        Path path0 = Path.of("test1.txt");

        // Paths is a utility class that provides static methods to create Path
        Path zooPath1 = Paths.get("/home", "tiger", "data",
                "stripes.txt");
        Path path1 = Paths.get("output.txt");

        // Switching Between File and Path
        // File to Path
        Path path2 = file0.toPath();
        // Path to File
        File file1 = path0.toFile();
        try {
            Files.createFile(path1);

        } catch (IOException e) {
            System.out.println("File already exists");
            infoIO(path1.toFile());
        }

        try {
            infoNIO(zooPath1);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        var p = Path.of("/Users/mk/raccoon.image");
        System.out.println("Path is: " + p);
        for (int i = 0; i < p.getNameCount(); i++) {
            System.out.println(" Element " + i + " is: " +
                    p.getName(i));
        }
        System.out.println();
        System.out.println("subpath(0,3): " + p.subpath(0, 3)); // Users/mk/raccoon.image
        System.out.println("subpath(1,2): " + p.subpath(1, 2)); // mk
        System.out.println("subpath(1,3): " + p.subpath(1, 3)); //

        // var q = p.subpath(0, 4); // RuntimeERR: IllegalArgumentException
        // var x = p.subpath(1, 1); // RuntimeERR: IllegalArgumentException

        var rel = Path.of("src/main/raccoon.image");
        printPathInformation(rel);

        System.out.println("Absolute Path: " + rel.toAbsolutePath());
        printParentRecursive(rel);

        Path home = Path.of("/Users/mk");
        Path javaLib = Path.of("/Library/Java");
        Path workingDir = Path.of("dev");
        var p5 = home.resolve(workingDir); // /Users/mk/dev
        var p6 = home.resolve(javaLib); // /Library/Java
        System.out.println(p5);
        System.out.println(p6);

        // relativize
        // if you are pointed at a path in the file system, what steps would you need to
        // take to reach the other path?
        var target = Path.of("target"); // is this a file or a directory?
        var src = Path.of("src/main/java");

        // how to start from the Path target and reach to src?
        System.out.println(target.relativize(src)); // ../src/main/java
        // how to start from the Path src and reach to target?
        System.out.println(src.relativize(target)); // ../../../target

        // normalize
        // remove redundant elements from the path
        var p1 = Path.of("./armadillo/../shells.txt");
        System.out.println(p1.normalize()); // shells.txt

        var p3 = Path.of("../../fish.txt");

        // normalize removes only the ones that can be reduced.
        System.out.println(p3.normalize()); // ../../fish.txt

        Path dirPath2 = Paths.get("new1/new2/folder/data.txt");

        try {
            // Files.createDirectory(dirPath2); //
            Files.createDirectories(dirPath2); //
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            Files.copy(dirPath2, Path.of("new1/new2/folder/data_copy.txt"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            Files.move(Path.of("C:\\zoo"), Path.of("C:\\zoo-new"), StandardCopyOption.REPLACE_EXISTING);

            Files.move(Path.of("C:\\user\\addresses.txt"),
                    Path.of("C:\\zoo-new\\addresses2.txt"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            Files.delete(Path.of("/vulture/feathers.txt"));
            Files.deleteIfExists(Path.of("/pigeon"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(Files.mismatch(
                    Path.of("/animals/monkey.txt"),
                    Path.of("/animals/wolf.txt")));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try (var br = new BufferedReader(new FileReader("zoodata.txt"))) {
            System.out.println(br.readLine());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try (var ois = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream("zoo-data.ser")))) {
            System.out.print(ois.readObject());
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        PrintStream ps;
        try {
            ps = new PrintStream(new FileOutputStream("log.txt"));
            ps.println("App started");
            ps.printf("Status: %d%%\n", 100);
            ps.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try (Stream<String> s = Files.lines(Path.of("log.txt"))) {
            s.filter(f -> f.startsWith("WARN:"))
                    .map(f -> f.substring(5))
                    .forEach(System.out::println);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            Files.readAllLines(Path.of("birds.txt")).forEach(System.out::println);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        Console console = System.console();
        if (console != null) {
            String userInput = console.readLine("Username:");
            char[] pass = console.readPassword("Password:");

            console.writer().println("You entered: " + userInput + Arrays.toString(pass));
            console.format("It has %d animals and employs %d people", 391, 25);
            console.flush();
        } else {
            System.err.println("Console not available");
        }

        InputStream is;
        try {
            is = new FileInputStream("example.txt");
            System.out.print((char) is.read()); // L

            if (is.markSupported()) {
                is.mark(100); // Marks up to 100 bytes
                System.out.print((char) is.read()); // I
                System.out.print((char) is.read()); // O
                is.reset(); // Resets stream to position before I
            }

            System.out.print((char) is.read()); // I
            System.out.print((char) is.read()); // O
            System.out.print((char) is.read()); // N
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(Files.isDirectory(Path.of("docsLINK"))); // true
        System.out.println(Files.isDirectory(Path.of("noTargetLINK"))); // FALSE
        System.out.println(Files.isSymbolicLink(Path.of("noTargetLINK"))); // true

        var path = Path.of("/turtles/sea.txt");
        BasicFileAttributes data;
        try {
            data = Files.readAttributes(path, BasicFileAttributes.class);
            System.out.println("Is a directory? " + data.isDirectory());
            System.out.println("Is a regular file? " + data.isRegularFile());
            System.out.println("Is a symbolic link? " + data.isSymbolicLink());
            System.out.println("Size (in bytes): " + data.size());
            System.out.println("Last modified: " + data.lastModifiedTime());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("File I/O");
        new File("/tempdirectory").delete();

        var source = Path.of("data/names.csv");
        try {
            List<String> allLines = Files.readAllLines(source);
            System.out.println("All lines: " + allLines);
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }

        // 2. Buffered I/O
        // 3. Object I/O
        // 4. Random Access I/O
        // 5. Memory-mapped I/O

        // File I/O
        // Buffered I/O
        // Object I/O
        // Random Access I/O
        // Memory-mapped I/O
    }

}
