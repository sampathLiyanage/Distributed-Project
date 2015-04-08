package webservice;

import app.Util;

import javax.xml.ws.Endpoint;

/**
 * Created by Sampath on 4/7/2015.
 */
public class FileServicePublisher {
        public void publish() {
            Endpoint.publish("http://"+ Util.IP+":"+ (Util.PORT+1) +"/fileService", new FileService());
        }
}
