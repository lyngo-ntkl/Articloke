package Support;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.Part;
import java.io.File;
import java.nio.file.FileSystems;

public class Utils {

    public static String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }

    public static File getFolderUpload(String location, ServletContext sce) {
        String root = sce.getAttribute("root").toString();
        File folderUpload = new File(root + "\\src\\main\\webapp\\Image\\" + location);
        if (!folderUpload.exists()) {
            folderUpload.mkdirs();
        }
        return folderUpload;
    }
}
