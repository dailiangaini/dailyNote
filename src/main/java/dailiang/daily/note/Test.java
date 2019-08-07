package dailiang.daily.note;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Auther: dailiang
 * @Date: 2018-12-23 17:52
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        int year = 2019;
        int mouth = 1;
        int days = 30;
        String filePath = "/Users/dailiang/Desktop/1.md";
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year); // 2010年
        c.set(Calendar.MONTH, mouth-1); // 6 月
        days = c.getActualMaximum(Calendar.DAY_OF_MONTH);

        System.out.println("------------" + c.get(Calendar.YEAR) + "年" +
                (c.get(Calendar.MONTH) + 1) + "月的天数和周数-------------");
        System.out.println("天数：" + c.getActualMaximum
                (Calendar.DAY_OF_MONTH));

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(simpleDateFormat.format(new Date()));
        try {
            Date date = simpleDateFormat.parse("2018-12-23");
            System.out.println(simpleDateFormat.format(date));
            System.out.println(Tools.getDayNumOfMouth(2018,12));
            System.out.println(Tools.getWeekOfDate(date));
            System.out.println(Tools.getDateString(2018, 1 ,2));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Tools.writeString2File(filePath, Tools.getDateString(2018, 1 ,2));
    }

}
