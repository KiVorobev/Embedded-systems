import controller.EnterHistoryController;
import controller.MCUController;
import controller.ScannerController;
import controller.UserController;
import io.javalin.Javalin;

import static io.javalin.plugin.rendering.template.TemplateUtil.model;

public class Application {

    public static void main(String[] args) {
        Javalin app = Javalin.create().start(7000);

        app.get("/user/get/{id}", UserController::getUser);
        app.before("/user/get/{id}", ctx -> {
            System.out.println("before");
        });
        app.post("/user/add", UserController::addUser);
        app.delete("/user/delete/{id}", UserController::deleteUser);
        app.post("/user/update", UserController::updateUser);

        app.post("/scanner/add", ScannerController::addScanner);
        app.get("/scanner/get/{hardwareNumber}", ScannerController::findScannerByHardwareNumber);
        app.delete("/scanner/delete/{innerId}", ScannerController::removeScannerByInnerId);
        app.post("/scanner/update", ScannerController::update);

        app.post("/mcu/add", MCUController::addMCU);
        app.get("/mcu/get/{address}", MCUController::findByAddress);

//        Imitation of websocket MCU request to enter the user:
        app.post("/mcu/enter", ScannerController::verifyEnter);

        app.ws("/websocket", ws -> {
            ws.onConnect(ctx -> System.out.println("Connected"));
        });

        app.get("/model", ctx -> {
            ctx.render("test.ftl", model("user", "Kirill", "name", "Lol", "surname", "Vorobyov"));
        });

        app.get("/start", EnterHistoryController::getAllLastActivities);

        app.get("/scanners", ScannerController::renderScannerPage);

    }
}
