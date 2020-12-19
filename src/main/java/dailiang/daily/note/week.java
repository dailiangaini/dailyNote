package dailiang.daily.note;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Date: 2018-12-23 18:20
 * @Description:
 */
public class week {

    public static void main(String[] args) throws Exception {
        int year = 2021;
        String baseDir = "/Users/dailiang/Desktop/";
        if(!new File(baseDir).exists()){
            new File(baseDir).mkdirs();
        }
        String filePath = baseDir + year + "年--项目周进度.md";

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();

        int daysOfThisYerFirstWeek = Tools.getDaysOfFirstWeek(year);
        System.out.println(daysOfThisYerFirstWeek);
        int daysOfNextYerFirstWeek = Tools.getDaysOfFirstWeek(year+1);

        Date startDate = simpleDateFormat.parse(year + "-01-01");
        Date endDate = simpleDateFormat.parse((year + 1) + "-01-01");
        cal.setTime(endDate);
        cal.add(Calendar.DAY_OF_YEAR, daysOfNextYerFirstWeek);
        endDate = cal.getTime();
        System.out.println(endDate);

        cal.setTime(startDate);
        String startDateStr = simpleDateFormat.format(startDate);
        cal.add(Calendar.DAY_OF_YEAR, daysOfThisYerFirstWeek -1);
        String endDateStr = simpleDateFormat.format(endDate);
        StringBuffer stringBuffer = new StringBuffer();
        while (cal.getTime().before(endDate)){
            stringBuffer.append(startDateStr);
            stringBuffer.append(" -- ");
            stringBuffer.append(endDateStr);
            stringBuffer.append("\n");
            stringBuffer.append("```");
            stringBuffer.append("\n");
            stringBuffer.append("计划:");
            stringBuffer.append("\n");
            stringBuffer.append("\n");
            stringBuffer.append("实际:");
            stringBuffer.append("\n");
            stringBuffer.append("\n");
            stringBuffer.append("```");
            stringBuffer.append("\n");
            cal.add(Calendar.DAY_OF_YEAR, 1);
            startDateStr = simpleDateFormat.format(cal.getTime());
            cal.add(Calendar.DAY_OF_YEAR, 6);
            endDateStr = simpleDateFormat.format(cal.getTime());
        }
        Tools.writeString2File(filePath, stringBuffer.toString());
    }
}
