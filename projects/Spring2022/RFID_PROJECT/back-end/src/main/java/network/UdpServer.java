package network;

import service.RfidRequest;
import service.ScannerService;
import service.hash.CustomHasher;
import service.hash.Hasher;
import service.network.Parser;
import service.network.RfidMessageParser;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.file.Path;
import java.util.logging.Logger;

public class UdpServer implements Runnable {

    private static final Logger LOGGER = Logger.getLogger(UdpServer.class.getName());

    private byte[] receivingDataBuffer = new byte[256];
    private byte[] sendingDataBuffer = new byte[256];
    private ScannerService scannerService;
    private Parser<RfidRequest> rfidRequestParser;

    private Hasher hasher;

    public UdpServer() {
        scannerService = new ScannerService();
        rfidRequestParser = new RfidMessageParser();
        hasher = new CustomHasher();
    }

    @Override
    public void run() {
        File file = Path.of("txt.txt").toFile();
        try (DatagramSocket datagramSocket = new DatagramSocket(1234);
             FileOutputStream outputStream = new FileOutputStream(file);) {
            while (true) {
                DatagramPacket inputPacket = new DatagramPacket(receivingDataBuffer, receivingDataBuffer.length);
                LOGGER.info("Waiting for reqeust!");
                datagramSocket.receive(inputPacket);
                LOGGER.info("Size: " + inputPacket.getLength());
                LOGGER.info("Request done");
                InetAddress inetAddress = inputPacket.getAddress();
                int port = inputPacket.getPort();

                RfidRequest rfidRequest = rfidRequestParser.parse(inputPacket.getData());

                LOGGER.info("Message from Misha: " + rfidRequest.toString());

                //todo Change number to sys properties
                boolean isAllowedToEnter = scannerService.verifyEnter(rfidRequest);
                byte responseCode = isAllowedToEnter ? (byte)7 : (byte)13;

                outputStream.write(rfidRequest.toString().getBytes());
                outputStream.write(System.lineSeparator().getBytes());
                StringBuilder messageToCard = new StringBuilder();
                messageToCard.append((isAllowedToEnter) ? "good" : "bad");

                int hash = hasher.hash(rfidRequest.getRfidCardNumber());
                ByteBuffer buffer = ByteBuffer.allocate(4);
                buffer.putInt(hash);
//                buffer.put(responseCode);
//                LOGGER.info("Hashed key: " + hash);
//                System.out.println(rfidRequest.getRfidCardNumber());
//                System.out.println(hash);
//                messageToCard.append(hash);
//                sendingDataBuffer = messageToCard.toString().getBytes();
                buffer.flip();

                ByteBuffer flippedByteBuffer = ByteBuffer.allocate(5);
                for (int i = 3; i >= 0; i--) {
                    flippedByteBuffer.put(buffer.get(i));
                }
                flippedByteBuffer.put(responseCode);
                flippedByteBuffer.flip();

                DatagramPacket outputPacket = new DatagramPacket(flippedByteBuffer.array(), 5, inetAddress, port);
                datagramSocket.send(outputPacket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
