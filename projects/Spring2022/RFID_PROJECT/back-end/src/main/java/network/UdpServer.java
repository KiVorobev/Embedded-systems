package network;

import service.RfidRequest;
import service.ScannerService;
import service.hash.CustomHasher;
import service.hash.Hasher;
import service.network.BufferHandler;
import service.network.Parser;
import service.network.RfidMessageParser;

import java.io.IOException;
import java.net.*;
import java.nio.ByteBuffer;

public class UdpServer implements Runnable {

    private final byte[] receivingDataBuffer = new byte[2048];
    private ScannerService scannerService;
    private Parser<RfidRequest> rfidRequestParser;
    private BufferHandler bufferHandler;

    private static final byte SUCCESS_CODE = 7;
    private static final byte ERROR_CODE = 13;

    private Hasher hasher;

    public UdpServer() {
        scannerService = new ScannerService();
        rfidRequestParser = new RfidMessageParser();
        hasher = new CustomHasher();
        bufferHandler = new BufferHandler();
    }

    @Override
    public void run() {
        try (DatagramSocket datagramSocket = new DatagramSocket(1234)) {
            while (true) {
                DatagramPacket inputPacket = new DatagramPacket(receivingDataBuffer, receivingDataBuffer.length);
                datagramSocket.receive(inputPacket);

                RfidRequest rfidRequest = rfidRequestParser.parse(inputPacket.getData());

                boolean isAllowedToEnter = scannerService.verifyEnter(rfidRequest);
                byte responseCode = isAllowedToEnter ? SUCCESS_CODE : ERROR_CODE;

                int hash = hasher.hash(rfidRequest.getRfidCardNumber());

                ByteBuffer responseBuffer = bufferHandler.createBufferWithHashAndResponse(hash, responseCode);

                DatagramPacket outputPacket = new DatagramPacket(
                        responseBuffer.array(),
                        5,
                        fetchSocketAddress(inputPacket));
                datagramSocket.send(outputPacket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private SocketAddress fetchSocketAddress(DatagramPacket packet) {
        return new InetSocketAddress(packet.getAddress(), packet.getPort());
    }
}
