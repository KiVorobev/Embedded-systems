import controller.EnterHistoryController;
import controller.MCUController;
import controller.ScannerController;
import controller.UserController;
import io.javalin.Javalin;
import util.PropertiesUtil;

import static io.javalin.plugin.rendering.template.TemplateUtil.model;

public class Application {

    public static void main(String[] args) {
        Javalin app = Javalin.create().start(Integer.parseInt(PropertiesUtil.get("port")));

        app.get("/user/get/{id}", UserController::getUser);
        app.get("/user/edit/{id}", UserController::editUser);
        app.before("/user/get/{id}", ctx -> {
            System.out.println("before");
        });
        app.post("/user/add", UserController::addUser);
        app.delete("/user/delete/{id}", UserController::deleteUser);
        app.post("/user/update", UserController::updateUser);

        app.get("/scanner/put" , ScannerController::renderAddScannerPage);
        app.get("/scanner/remove" , ScannerController::renderRemovePage);
        app.post("/scanner/add", ScannerController::addScanner);
        app.get("/scanner/get/{hardwareNumber}", ScannerController::findScannerByHardwareNumber);
        app.delete("/scanner/delete/{hardwareNumber}", ScannerController::removeScannerByHardwareNumber);
        app.post("/scanner/update", ScannerController::update);

        app.post("/mcu/add", MCUController::addMCU);
        app.get("/mcu/get/{address}", MCUController::findByAddress);

//        Imitation of websocket MCU request to enter the user:
        app.post("/mcu/enter", ScannerController::verifyEnter);

        app.ws("/websocket", ws -> {
            ws.onConnect(ctx -> System.out.println("Connected"));
        });

        app.get("/start", EnterHistoryController::getAllLastActivities);
        app.delete("/user/delete/activities/{id}", EnterHistoryController::deleteActivityList);

        app.get("/scanners", ScannerController::renderScannerPage);
        app.get("/*", context -> {
            context.redirect("/start");
        });


    }
}
