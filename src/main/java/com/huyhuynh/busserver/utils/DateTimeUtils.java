package com.huyhuynh.busserver.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateTimeUtils {

    public static final String DATE_FORMATTER = "yyyy-MM-dd";
    public static final String DATE_TIME_DB_FORMATTER = "yyyy-MM-ddTHH:mm:ss";

    /**
     * Cập nhật ngày trong chuỗi DateTime nhưng giữ nguyên phần thời gian.
     * @param dateTimeString Chuỗi datetime (định dạng: yyyy-MM-dd'T'HH:mm:ss)
     * @return Chuỗi datetime với ngày hiện tại và thời gian giữ nguyên
     */
    public static String updateToCurrentDate(String dateTimeString) {
        if (dateTimeString == null || !dateTimeString.contains("T")) {
            return dateTimeString;
        }

        // Lấy ngày hiện tại (yyyy-MM-dd)
        String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern(DATE_FORMATTER));

        // Lấy phần thời gian từ chuỗi gốc
        String timePart = dateTimeString.substring(dateTimeString.indexOf("T")); // Lấy từ "T06:00:00"

        // Ghép ngày hiện tại + thời gian cũ
        return currentDate + timePart;
    }


    /**
     * Chuyển đổi ngày tháng từ định dạng cũ sang định dạng mới
     * @param dateStr Ngày tháng cần chuyển đổi (chuỗi)
     * @param fromFormat Định dạng gốc của dateStr (ví dụ: "dd/MM/yyyy")
     * @param newFormat Định dạng mong muốn (ví dụ: "yyyy-MM-dd"), mặc định là "yyyy-MM-dd"
     * @return Chuỗi ngày tháng với định dạng mới hoặc null nếu có lỗi
     */
    public static String formatDateString(String dateStr, String fromFormat, String newFormat) {
        if (dateStr == null || fromFormat == null) {
            return dateStr;
        }
        if (newFormat == null) {
            newFormat = "yyyy-MM-dd"; // Định dạng mặc định
        }

        try {
            // Tạo formatter từ định dạng đầu vào
            DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern(fromFormat);
            // Tạo formatter từ định dạng đầu ra
            DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern(newFormat);

            // Parse chuỗi thành LocalDate
            LocalDate date = LocalDate.parse(dateStr, inputFormatter);

            // Format sang định dạng mới
            return date.format(outputFormatter);
        } catch (DateTimeParseException e) {
            System.err.println("Lỗi khi parse ngày tháng: " + e.getMessage());
            return dateStr;
        }
    }

    /**
     * Lấy ngày hiện tại và format theo định dạng yyMMdd
     * @return Chuỗi ngày tháng theo định dạng yyMMdd (VD: 250329 cho ngày 29/03/2025)
     */
    public static String getCurrentDateyyMMdd() {
        // Lấy ngày hiện tại
        LocalDate today = LocalDate.now();
        // Định dạng yyMMdd
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMdd");
        // Trả về ngày đã format
        return today.format(formatter);
    }
}
