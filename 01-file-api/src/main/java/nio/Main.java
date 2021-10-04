package nio;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.UserPrincipal;
import java.util.Set;

/*
* Java has two file APIs.

1. The original java.io.File API, available since Java 1.0 (1996).

2. The newer java.nio.file.Path API, available since Java 1.7 (2011)
*
* - NIO is a better API (improved), but IO is still in regular use (it's not deprecated)
* */
public class Main {

    public static void main(String[] args) throws URISyntaxException, IOException {
        // Java11+  : Path.of()

        Path path = Path.of("/home/nenad");
        System.out.println(path);

        path = Path.of("//home//nenad");
        System.out.println(path);

        path = Path.of("/", "home", "nenad");
        System.out.println(path);

        path = Path.of("/", "home", "nenad").resolve("Documents"); // resolve == getChild()
        System.out.println(path);

        path = Path.of(new URI("file:///home/nenad/Documents/class.odt"));
        System.out.println(path);

        // Java < 11 equivalent: Paths.get()
        path = Paths.get("/home/nenad");
        System.out.println(path);

        // Path.of - as of Java 11, this method should be used
        final String filePath = "/home/nenad/Documents/Learning/java-learning-examples/01-file-api/README.md";
        path = Path.of(filePath);
        doesFileExist(path);
        getLastModificationDate(path);
        printOwnerOfTheFile(path);

        createFiles(path.getParent());
        printPosixPermissions(filePath);
    }
    /*
    *
    * Two important points, however:

    - Constructing a path object or resolving a child, does not mean the file or directory actually exists.
    * The path is merely a reference to a potential file. So, you’ll have to separately verify its existence.

    - Pre Java-11, Path.of was called Paths.get, which you’ll need to use if you’re stuck on older Java versions
    *  or building a library that needs some backward compatibility. Starting with Java 11, Paths.get internally
    *  redirects to Path.of.
    *
    * */

    public static void doesFileExist(Path path) {
        System.out.println(Files.exists(path));
    }


    public static void getLastModificationDate(Path path) throws IOException {
        FileTime lastModifiedTime = Files.getLastModifiedTime(path);
        System.out.println("lastModifiedTime = " + lastModifiedTime);
    }

    // Java 12+
    public static long compareFiles(Path path) {
        // long mismatchIndex = Files.mismatch(path, Paths.get("/some/path/file.txt"));
        // System.out.println("mismatch = " + mismatchIndex);
        // returns position of the mismatch (fist byte that differs)
        return 0L;
    }

    public static void printOwnerOfTheFile(Path path) throws IOException {
        UserPrincipal owner = Files.getOwner(path);
        System.out.println("owner = " + owner);
    }


    // create temp file
    public void createTempFiles(Path path) throws IOException {
        Path tempFile1 = Files.createTempFile("somePrefixOrNull", ".jpg");
        System.out.println("tempFile1 = " + tempFile1);

        Path tempFile2 = Files.createTempFile(path.getParent(), "somePrefixOrNull", ".jpg");
        System.out.println("tempFile2 = " + tempFile2);

        Path tmpDirectory = Files.createTempDirectory("prefix");
        System.out.println("tmpDirectory = " + tmpDirectory);
        /*
        * When creating temp files, you can specify a prefix (first param) and a suffix (second param). Both can be null.
        The prefix will be prefixed (duh!) to the temp file name, the suffix is essentially the file extension, and if you
        * leave it out a default extension of ".tmp" will be used.
        *
        * Instead of the default temp directory, you can also specify your own directory where you want the temp file to be created.
        *
        * Note: Temp files, contrary to popular belief, do not delete themselves. You have to make sure to explicitly delete them,
        *  when creating them in unit tests or when running in production.
        * */
    }

    public static void createFiles(Path path) throws IOException {
        Path newDirectory = Files.createDirectories(path.getParent().resolve("some/new/dir")); // resolve returns path of the parent object
        System.out.println("newDirectory = " + newDirectory);

        Path newFile = Files.createFile(newDirectory.resolve("emptyFile.txt"));
        System.out.println("newFile = " + newFile);
    }

    // for Unix-based systems (Linux, macOS)
    public static void printPosixPermissions(final String filePath){
        Path path = Path.of(filePath);
        try {
            Set<PosixFilePermission> permissions = Files.getPosixFilePermissions(path);
            System.out.println("permissions = " + permissions);
        } catch (UnsupportedOperationException | IOException e) {
            System.err.println("Looks like you're not running on a posix file system");
        }
    }
}
