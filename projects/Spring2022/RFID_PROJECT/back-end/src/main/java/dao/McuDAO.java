package dao;

import entity.MCU;

public interface McuDAO {

    void add(MCU mcu);

    MCU findByAddress(String address);
}
