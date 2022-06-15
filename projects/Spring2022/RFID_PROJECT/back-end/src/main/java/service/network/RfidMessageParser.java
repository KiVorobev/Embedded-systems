package service.network;

import service.RfidRequest;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class RfidMessageParser implements Parser<RfidRequest> {

    @Override
    public RfidRequest parse(byte[] byteArray) {
        for (int i = 0; i< byteArray.length; i++) {
            System.out.printf("0x%02X ", byteArray[i]);
        }
        System.out.println();
        ByteBuffer byteBuffer = ByteBuffer.wrap(byteArray);
        byteBuffer = byteBuffer.slice();
//        System.out.println("");
        RfidRequest result = new RfidRequest();
        result.setControlNumber(byteBuffer.get());
        result.setHardwareNumber(byteBuffer.get());
        result.setUsefulBytesCount(byteBuffer.get());
        result.setRfidCardNumber(
                Arrays.copyOfRange(byteBuffer.array(),
                        3,
                        result.getUsefulBytesCount() + 3)
        );
        return result;
    }
}
