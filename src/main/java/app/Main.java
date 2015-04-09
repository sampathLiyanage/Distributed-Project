package app;

import webservice.FileServicePublisher;

import javax.swing.*;
import java.net.SocketException;

/**
 * Created by Tharindu on 2015-03-06.
 */
public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                GUI.init();
            }
        });

    }
}
