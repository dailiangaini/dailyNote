package dailiang.daily.note;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Date: 2018-12-23 17:59
 * @Description:
 */
public class Tools {


    /**
     * 获取该月共有多少天
     * @param year
     * @param mouth
     * @return
     */
    public static int getDayNumOfMouth(int year, int mouth){
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year); // 2010年
        c.set(Calendar.MONTH, mouth-1); // 6 月
       return c.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取该日期为周几
     * @param date
     * @return
     */
    public static String getWeekOfDate(Date date) {
        String[] weekDays = { "周日", "周一", "周二", "周三", "周四", "周五", "周六" };
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return weekDays[w];
    }

    /**
     * 获取日期表达
     * @param year
     * @param mouth
     * @param day
     * @return
     */
    public static String getDateString(int year, int mouth, int day){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(year);
        stringBuffer.append("-");
        if(mouth < 10 ){
            stringBuffer.append("0");
        }
        stringBuffer.append(mouth);
        stringBuffer.append("-");
        if(day < 10 ){
            stringBuffer.append("0");
        }
        stringBuffer.append(day);
        return stringBuffer.toString();
    }

    /**
     * 获取该年第一周有几天
     * @return
     */
    public static int getDaysOfFirstWeek(int year) throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(year + "-01-01");
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
       return 7 - cal.get(Calendar.DAY_OF_WEEK) + 2;
    }

    /**
     * 获得月份大写
     * @param mouth
     * @return
     */
    public String getMouthUpcase(int mouth){
        switch (mouth){
            case 1:
                return "一";
            case 2:
                return "二";
            case 3:
                return "三";
            case 4:
                return "四";
            case 5:
                return "五";
            case 6:
                return "六";
            case 7:
                return "七";
            case 8:
                return "八";
            case 9:
                return "九";
            case 10:
                return "十";
            case 11:
                return "十一";
            case 12:
                return "十二";
        }
        return "";
    }

    /**
     * 向目标文件写入String
     * @param filePath
     * @param str
     */
    public static void writeString2File(String filePath, String str){
        File f = new File(filePath);//新建一个文件对象，如果不存在则创建一个该文件
        FileWriter fw;
        try {
            fw = new FileWriter(f);
            fw.write(str);//将字符串写入到指定的路径下的文件中
            fw.close();
        } catch (IOException e) { e.printStackTrace(); }
    }



}
