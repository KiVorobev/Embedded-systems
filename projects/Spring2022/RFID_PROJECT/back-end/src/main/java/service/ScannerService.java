package service;

import dao.EnterHistoryDAO;
import dao.EntityHistoryDAOImpl;
import dao.ScannerDAO;
import dao.ScannerDAOImpl;
import entity.Scanner;
import entity.User;
import enums.Role;

import java.util.List;


public class ScannerService {

    private ScannerDAO scannerDAO;
    private UserService userService;
    private EnterHistoryDAO enterHistoryDAO;

    public ScannerService() {
        scannerDAO = new ScannerDAOImpl();
        userService = new UserService();
        enterHistoryDAO = new EntityHistoryDAOImpl();
    }

    public void add(Scanner scanner) {
        scannerDAO.addScanner(scanner);
    }

    public void removeByHardwareNumber(String hardwareNumber) {
        scannerDAO.removeScannerByNumber(hardwareNumber);
    }

    public void update(Role newRole, String hardwareNumber) {
        scannerDAO.updateScanner(newRole, hardwareNumber);
    }

    public List<Scanner> getAllScanners() {
        return scannerDAO.getAllScanners();
    }

    public Scanner findByHardwareNumber(String hardwareNumber) {
        return scannerDAO.findScannerByNumber(hardwareNumber);
    }

    public boolean verifyEnter(String hardwareNumber, String cardId) {
        Scanner scanner = scannerDAO.findScannerByNumber(hardwareNumber);
        if (scanner == null) return false;
        User user = userService.getByCardId(cardId);
        if (user == null) return false;
        if (userService.getUserPriorityByCardId(user) >= getScannerPriority(scanner)) {
            enterHistoryDAO.addActivity(user.getId(), scanner);
            return true;
        } else return false;
    }

    private int getScannerPriority(Scanner scanner) {
        return scanner.getRole().priority;
    }

}
