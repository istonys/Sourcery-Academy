import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainClass {

  public static void printBonusDatesBetween(int fromYear, int toYear) {
    Calendar fromCalendar = Calendar.getInstance();
    Calendar toCalendar = Calendar.getInstance();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    fromCalendar.set(Calendar.YEAR, fromYear);
    fromCalendar.set(Calendar.MONTH, Calendar.JANUARY);
    int firstFromDay = fromCalendar.getActualMinimum(Calendar.DAY_OF_MONTH);
    fromCalendar.set(Calendar.DAY_OF_MONTH, firstFromDay);

    toCalendar.set(Calendar.YEAR, toYear);
    toCalendar.set(Calendar.MONTH, Calendar.DECEMBER);
    int lastToDay = toCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    toCalendar.set(Calendar.DAY_OF_MONTH, lastToDay);

    while (!fromCalendar.after(toCalendar)) {
      String date = dateFormat.format(fromCalendar.getTime());
      String tempDate = date.replace("-", "");
      if (isPalindrome(tempDate)) {
        System.out.println(date);
      }
      fromCalendar.add(Calendar.DATE, 1);
    }
  }

  public static boolean isPalindrome(String date) {
    return date.equals(reverseDate(date));
  }

  public static String reverseDate(String date) {
    StringBuilder reversed = new StringBuilder();
    for (int i = date.length() - 1; i >= 0; i--) {
      reversed.append(date.charAt(i));
    }

    return reversed.toString();
  }

  public static void main(String[] args) {
    printBonusDatesBetween(2010, 2015);
  }
}
