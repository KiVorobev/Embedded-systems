import controller.*;
import io.javalin.Javalin;
import network.UdpServer;
import util.PropertiesUtil;

public class Application {

    public static void main(String[] args) {
        Javalin app = Javalin.create(config -> {
            config.contextPath = "/";
            config.enableDevLogging();
        }).start(Integer.parseInt(PropertiesUtil.get("port")));
        Thread serverThread = new Thread(new UdpServer());
        serverThread.start();

        app.get("/start", EnterHistoryController::getAllLastActivities);
        app.get("/scanners", ScannerController::renderScannerPage);
        app.get("/user/put", UserController::renderAddUserPage);
        app.get("/user/search", UserController::renderSearchUserPage);
        app.get("/rejected", DismissedEnterHistoryController::renderAllLastActivityPage);


        app.get("/user/get/{id}", UserController::getUser);
        app.get("/user/edit/{id}", UserController::editUser);
        app.post("/user/add", UserController::addUser);
        app.delete("/user/delete/{id}", UserController::deleteUser);
        app.post("/user/update", UserController::updateUser);
        app.delete("/user/delete/activities/{id}", EnterHistoryController::deleteActivityList);
        app.post("/search", UserController::getUserByCardId);

        app.get("/scanner/put", ScannerController::renderAddScannerPage);
        app.get("/scanner/remove", ScannerController::renderRemovePage);
        app.post("/scanner/add", ScannerController::addScanner);
        app.get("/scanner/get/{hardwareNumber}", ScannerController::findScannerByHardwareNumber);
        app.delete("/scanner/delete/{hardwareNumber}", ScannerController::removeScannerByHardwareNumber);
        app.post("/scanner/update", ScannerController::update);

        app.post("/mcu/add", MCUController::addMCU);
        app.get("/mcu/get/{address}", MCUController::findByAddress);

        app.get("/*", context -> {
            context.redirect("/start");
        });
    }
}
