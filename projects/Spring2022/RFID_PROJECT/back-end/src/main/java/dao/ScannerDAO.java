package dao;

import entity.Scanner;
import enums.Role;

import java.util.List;

public interface ScannerDAO {

    void addScanner(Scanner scanner);

    void removeScannerByInnerId(Long innerId);

    void removeScannerByNumber(String hardwareNumber);

    void updateScanner(Role newRole, Long innerId);

    Scanner findScannerByNumber(String hardwareNumber);

    List<Scanner> getAllScanners();

}
