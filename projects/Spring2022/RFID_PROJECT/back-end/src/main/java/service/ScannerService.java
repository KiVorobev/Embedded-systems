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

    public void removeByInnerId(Long id) {
        scannerDAO.removeScannerByInnerId(id);
    }

    public void removeByHardwareNumber(String hardwareNumber) {
        scannerDAO.removeScannerByNumber(hardwareNumber);
    }

    public void update(Role newRole, Long innerId) {
        scannerDAO.updateScanner(newRole, innerId);
    }

    public Scanner findByHardwareNumber(String hardwareNumber) {
        return scannerDAO.findScannerByNumber(hardwareNumber);
    }

    public boolean verifyEnter(String hardwareNumber, Long personId) throws DoesntExistException {
        Scanner scanner = scannerDAO.findScannerByNumber(hardwareNumber);
        User user = userService.getById(personId);
        if (user.getRole().priority >= scanner.getRole().priority) {
            enterHistoryDAO.addActivity(new EnterHistory(LocalDateTime.now()), user.getId());
            return true;
        } else return false;
    }
}
