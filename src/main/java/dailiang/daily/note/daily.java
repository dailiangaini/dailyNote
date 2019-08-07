package dailiang.daily.note;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Date: 2018-12-23 18:20
 * @Description:
 */
public class daily {
    public static void main(String[] args) throws Exception {
        int year = 2019;
        int mouth = 10;
        String baseDir = "/Users/dailiang/Desktop/";
        String filePath = baseDir + mouth + "月份工作日志.md";
        int days = Tools.getDayNumOfMouth(year, mouth);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        StringBuffer stringBuffer = new StringBuffer();
        for (int day = 1; day <= days ; day++) {
            String dateString = Tools.getDateString(year, mouth, day);
            Date date = simpleDateFormat.parse(dateString);
            String weekOfDay = Tools.getWeekOfDate(date);
            stringBuffer.append("###");
            stringBuffer.append(" ");
            stringBuffer.append(dateString);
            stringBuffer.append(" ");
            stringBuffer.append(weekOfDay);
            stringBuffer.append("\n");
            stringBuffer.append("```");
            stringBuffer.append("\n");
            stringBuffer.append("```");
            stringBuffer.append("\n");
        }
        Tools.writeString2File(filePath, stringBuffer.toString());
    }
}
