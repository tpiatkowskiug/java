import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.File;

public class TwrorzenieFolderu {
    public static void main(String[] args) throws IOException {
    	File folder = new File("nowyFolder");  
    	if(!folder.exists()){
    		folder.mkdirs();
    		//Files.createDirectory(Paths.get("nowyFolder"));
    	}
    }
}

