package JavaVision;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

public class Python {
    private static final String pythonVersion = "python3.9";
    public static InputStream getInputStream(String command) throws IOException {
        ProcessBuilder pb = new ProcessBuilder();
        String[] fullCommand = new String[]{pythonVersion, command};
        pb.command(fullCommand);

        Process process = pb.start();
        return process.getInputStream();
    }
    public static InputStream getInputStreamArg(String command, String arg) throws IOException {
        ProcessBuilder pb = new ProcessBuilder();
        String[] fullCommand = new String[]{pythonVersion, command, arg};
        pb.command(fullCommand);

        Process process = pb.start();
        return process.getInputStream();
    }

    public static String run(String command) throws IOException{
        return getString(getInputStream(command).readAllBytes());
    }

    public static String getString(byte[] array){
        return new String(array, Charset.defaultCharset());
    }
}
