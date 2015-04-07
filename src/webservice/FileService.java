package webservice;

/**
 * Created by Sampath on 4/7/2015.
 */

import app.Neighbour;
import app.NodeSender;
import app.Util;
import app.Node;

import javax.jws.WebService;
import java.util.HashSet;

@WebService(endpointInterface = "webservice.FileServiceInterface")
public class FileService implements FileServiceInterface {
    @Override
    public void searchFile(String filename, String searcherIp, int searcherPort, int hops) {
        Neighbour tempNeighbour = new Neighbour(searcherIp,searcherPort);
        FileServiceInterface fs = tempNeighbour.getFileService();

        hops = hops - 1; // decrement hop count

        String basicQuery = "SER " + searcherIp + " " + searcherPort + " " + filename;
        if (Node.checkInRecentQueries(basicQuery)) {
              System.out.println("query discarded");
              return;
        }

        HashSet<String> availableFileNames = Node.checkForFileAvailability(filename);
        int numberOfFiles = availableFileNames.size();

        if (numberOfFiles > 0) { // if i have similar files
            String fileString = "";
            for (String s : availableFileNames) {
                s = s.replace(" ", "_"); // replace spaces in filename with underscore
                fileString += s + " ";
            }
            fileString = fileString.substring(0, fileString.length() - 1); // strip last space
            fs.fileFound(numberOfFiles, fileString, Util.IP, Util.PORT);

            } else if (hops > 0){ // if i don't have
                    Node.forwardSearchRequest(searcherIp, searcherPort, filename, hops);
            }
    }

    @Override
    public void fileFound(int numberOfFiles, String fileString, String ownerIp, int ownerPort) {
                System.out.println("Files found: " + fileString + " (in " + ownerIp + ":" + ownerPort+")");
    }
}
