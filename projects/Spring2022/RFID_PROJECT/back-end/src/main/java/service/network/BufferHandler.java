package service.network;

import java.nio.ByteBuffer;

public class BufferHandler {

    public ByteBuffer createBufferWithHashAndResponse(int hash, byte responseCode) {
        ByteBuffer buffer = ByteBuffer.allocate(4);
        buffer.putInt(hash);
        buffer.flip();

        ByteBuffer flippedByteBuffer = ByteBuffer.allocate(5);

        for (int i = 3; i >= 0; i--) {
            flippedByteBuffer.put(buffer.get(i));
        }

        flippedByteBuffer.put(responseCode);
        flippedByteBuffer.flip();
        
        return flippedByteBuffer;
    }
}
