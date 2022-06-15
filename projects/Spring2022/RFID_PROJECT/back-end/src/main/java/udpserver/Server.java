package udpserver;

import exception.DoesntExistException;
import io.javalin.Javalin;
import service.ScannerService;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.*;
import java.nio.file.Path;

public class Server implements Runnable {

    private byte[] receivingDataBuffer = new byte[256];
    private byte[] sendingDataBuffer = new byte[256];
    private ScannerService scannerService;

    public Server() {
        scannerService = new ScannerService();
    }

    @Override
    public void run() {
        File file = Path.of("server_log.txt").toFile();
        try (DatagramSocket datagramSocket = new DatagramSocket(1234);
             FileOutputStream outputStream = new FileOutputStream(file)) {
            while (true) {
                DatagramPacket inputPacket = new DatagramPacket(receivingDataBuffer, receivingDataBuffer.length);
                datagramSocket.receive(inputPacket);
                InetAddress inetAddress = inputPacket.getAddress();
                int port = inputPacket.getPort();
                String requestFromCard = new String(inputPacket.getData(), 0, inputPacket.getLength());
                String hardwareNumber = "hardwareNumber";
                String cardId = "cardId";
                boolean isAllowedToEnter = scannerService.verifyEnter(hardwareNumber, cardId);
                outputStream.write(requestFromCard.getBytes());
                outputStream.write(System.lineSeparator().getBytes());
                String messageToCard = "Message";
                sendingDataBuffer = messageToCard.getBytes();
                DatagramPacket outputPacket = new DatagramPacket(sendingDataBuffer, sendingDataBuffer.length, inetAddress, port);
                datagramSocket.send(outputPacket);
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DoesntExistException e) {
            System.out.println("User doesn't exist");
            e.printStackTrace();
        }
    }
}
