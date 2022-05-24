package controller;

import dao.McuDAO;
import entity.MCU;
import io.javalin.http.Context;
import service.MCUService;


public class MCUController {

    private static final MCUService mcuService = new MCUService();

    public static void addMCU(Context context) {
        MCU mcu = context.bodyAsClass(MCU.class);
        mcuService.addMCU(mcu);
        context.result("Success");
    }

    public static MCU findByAddress(Context context) {
        String address = context.pathParam("address");
        MCU mcu = mcuService.findByAddress(address);
        context.json(mcu);
        return mcu;
    }

}
