package service;

import dao.McuDAO;
import dao.McuDAOImpl;
import entity.MCU;

public class MCUService {

    private McuDAO mcuDAO;

    public MCUService() {
        mcuDAO = new McuDAOImpl();
    }

    public void addMCU(MCU mcu) {
        mcuDAO.add(mcu);
    }

    public MCU findByAddress(String address) {
        return mcuDAO.findByAddress(address);
    }
}
