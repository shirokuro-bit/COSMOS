package cosmos;

import java.io.File;
import java.io.FilenameFilter;

public class GetFileName {
    private final File[] files;
    public GetFileName() {
        FilenameFilter filter = (dir, name) -> {
            return name.endsWith("mp4");
        };
        /*FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                if (name.endsWith("mp4")) {
                    return true;
                } else {
                    return false;
                }
            }
        };*/

        files = new File("movie").listFiles(filter);
    }

    public File[] getFiles() {
        return files;
    }
}
