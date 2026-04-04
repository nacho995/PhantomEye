package com.phantomeye.service;

import org.springframework.stereotype.Service;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

@Service
public class PortScannerService {

    public List<Integer> scanPorts(String ip, List<Integer> ports) {
        List<Integer> openPorts = new ArrayList<>();
        for (int port : ports) {
            try (Socket socket = new Socket(ip, port)) {
                openPorts.add(port);
            } catch (Exception e) {
                // Port is closed
            }
        }
        return openPorts;
    }
}
