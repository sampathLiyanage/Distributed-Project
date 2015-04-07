package webservice;

/**
 * Created by Sampath on 4/7/2015.
 */

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

//Service Endpoint Interface
@WebService
@SOAPBinding(style = Style.RPC)
public interface FileServiceInterface {
    @WebMethod void searchFile(String name, String finderIp, int finderPort, int hopCount);
    @WebMethod void fileFound(int noOfFiles, String name, String ownerIp, int ownerPort);
}