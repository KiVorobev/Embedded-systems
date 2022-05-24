package dao;

import entity.Scanner;
import enums.Role;

public interface ScannerDAO {

    void addScanner(Scanner scanner);

    void removeScannerByInnerId(Long innerId);

    void removeScannerByNumber(String hardwareNumber);

    void updateScanner(Role newRole, Long innerId);

    Scanner findScannerByNumber(String hardwareNumber);

}
