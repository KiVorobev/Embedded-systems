package service;

import dao.EnterHistoryDAO;
import dao.EntityHistoryDAOImpl;
import dao.ScannerDAO;
import dao.ScannerDAOImpl;
import entity.EnterHistory;
import entity.Scanner;
import entity.User;
import enums.Role;
import exception.DoesntExistException;

import java.time.LocalDateTime;
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

    public Scanner findByHardwareNumber(String hardwareNumber) {
        return scannerDAO.findScannerByNumber(hardwareNumber);
    }

    public boolean verifyEnter(String hardwareNumber, String cardId) throws DoesntExistException {
        Scanner scanner = scannerDAO.findScannerByNumber(hardwareNumber);
        User user = userService.getByCardId(cardId);
        if (user.getRole().priority >= scanner.getRole().priority) {
            enterHistoryDAO.addActivity(new EnterHistory(LocalDateTime.now()), user.getId(), scanner);
            return true;
        } else return false;
    }

    public List<Scanner> getAllScanners() {
        return scannerDAO.getAllScanners();
    }
}
