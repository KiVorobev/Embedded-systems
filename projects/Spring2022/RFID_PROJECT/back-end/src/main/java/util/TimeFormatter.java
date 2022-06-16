package util;
import entity.EnterHistory;
import java.time.format.DateTimeFormatter;

public final class TimeFormatter {

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");

    private TimeFormatter() {
    }

    public static String formatToString(EnterHistory oldFormatData) {
        return oldFormatData.getEnterActivity().format(formatter);
    }

}
