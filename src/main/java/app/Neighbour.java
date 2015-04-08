package app;

import webservice.FileServiceInterface;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Tharindu Wijewardane on 2015-03-06.
 */
public class Neighbour {
    public Neighbour() {
    }

    public Neighbour(String ipAddress, int port) {
        this.ipAddress = ipAddress;
        this.port = port;
    }

    String ipAddress;
    int port;

    @Override
    public int hashCode() {
        return (ipAddress + port).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Neighbour) {
            return ((Neighbour) obj).ipAddress.equalsIgnoreCase(this.ipAddress) && ((Neighbour) obj).port == this.port;
        }
        return false;
    }

    public FileServiceInterface getFileService(){
        URL url = null;
        try {
            url = new URL("http://"+ipAddress +":" + (port+1) + "/fileService?wsdl");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        QName qname = new QName("http://webservice/", "FileServiceService");

        Service service = Service.create(url, qname);

        FileServiceInterface fileService = service.getPort(FileServiceInterface.class);
        return fileService;
    }
}
