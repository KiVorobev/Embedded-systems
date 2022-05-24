package controller;

import entity.Scanner;
import extraclasses.RequestToEnter;
import io.javalin.http.Context;
import service.ScannerService;

public class ScannerController {
    private static final ScannerService scannerService = new ScannerService();

    public static void addScanner(Context context) {
        Scanner scanner = context.bodyAsClass(Scanner.class);
        scannerService.add(scanner);
        context.json(scanner);
    }

    public static void removeScannerByInnerId(Context context) {
        Long id = Long.parseLong(context.pathParam("innerId"));
        scannerService.removeByInnerId(id);
        context.status(200);
    }

    public static void removeScannerByHardwareNumber(Context context) {
        String hardwareNumber = context.pathParam("hardwareNumber");
        scannerService.removeByHardwareNumber(hardwareNumber);
        context.status(200);
    }

    public static void update(Context context) {
        Scanner scanner = context.bodyAsClass(Scanner.class);
        scannerService.update(scanner.getRole(), scanner.getInnerId());
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


}
