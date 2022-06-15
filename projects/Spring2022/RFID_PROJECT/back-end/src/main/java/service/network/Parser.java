package service.network;

public interface Parser<T> {

    T parse(byte[] byteArray);
}
