package controller;

import entity.Scanner;
import extraclasses.RequestToEnter;
import io.javalin.http.Context;
import service.ScannerService;
import util.ViewUtil;

import java.util.List;
import java.util.Map;

public class ScannerController {
    private static final ScannerService scannerService = new ScannerService();

    public static void addScanner(Context context) {
        Scanner scanner = context.bodyAsClass(Scanner.class);
        scannerService.add(scanner);
        context.json(scanner);
        context.status(200);
    }


    public static void removeScannerByHardwareNumber(Context context) {
        String hardwareNumber = context.pathParam("hardwareNumber");
        scannerService.removeByHardwareNumber(hardwareNumber);
        context.status(200);
    }

    public static void update(Context context) {
        Scanner scanner = context.bodyAsClass(Scanner.class);
        scannerService.update(scanner.getRole(), scanner.getHardwareNumber());
    }

    public static Scanner findScannerByHardwareNumber(Context context) {
        String hardwareNumber = context.pathParam("hardwareNumber");
        Scanner scanner = scannerService.findByHardwareNumber(hardwareNumber);
        context.json(scanner);
        return scanner;
    }

    public static void verifyEnter(Context context) {
        try {
            RequestToEnter requestToEnter = context.bodyAsClass(RequestToEnter.class);
            boolean result = scannerService.verifyEnter(requestToEnter.getHardwareNumber(), requestToEnter.getPersonId());
            if (result) context.result("Allowed");
            else context.result("Not allowed");
        } catch (Exception e) {
            context.result(e.getMessage());
        }
    }

    public static void renderScannerPage(Context context) {
        Map<String, Object> model = ViewUtil.getBaseModel();
        List<Scanner> scannerList = scannerService.getAllScanners();
        model.put("scanners", scannerList);
        context.render("templates/scanners.ftl", model);
    }

    public static void renderAddScannerPage(Context context) {
        Map<String, Object> model = ViewUtil.getBaseModel();
        List<Scanner> scannerList = scannerService.getAllScanners();
        model.put("scanners", scannerList);
        context.render("templates/add_scanner.ftl", model);
    }

    public static void renderRemovePage(Context context) {
        context.render("templates/delete_scanner.ftl");
    }


}
