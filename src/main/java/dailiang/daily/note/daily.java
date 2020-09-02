package dailiang.daily.note;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Date: 2018-12-23 18:20
 * @Description:
 */
public class daily {
    public static void main(String[] args) throws Exception {
        int year = 2022;
        //int mouth = 10;
        for (int mouth = 1; mouth <= 12; mouth++) {
            String baseDir = "/Users/dailiang/Desktop/" + year + "/";
            if(!new File(baseDir).exists()){
                new File(baseDir).mkdirs();
            }
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
}
