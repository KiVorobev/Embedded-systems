package service;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class RfidRequest {
    int controlNumber;
    int hardwareNumber;
    int usefulBytesCount;
    byte[] rfidCardNumber;
}
