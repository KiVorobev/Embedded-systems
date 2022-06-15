package dao;

import entity.Scanner;
import enums.Role;

import java.util.List;

public interface ScannerDAO {

    void addScanner(Scanner scanner);

    void removeScannerByNumber(String hardwareNumber);

    void updateScanner(Role newRole, String hardwareNumber);

    Scanner findScannerByNumber(String hardwareNumber);

    List<Scanner> getAllScanners();

}
