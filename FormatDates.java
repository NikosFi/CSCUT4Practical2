import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class FormatDates implements Command {
    @Override
    public String transform(String targetLine) {
        String holder = "";
        Date d = null;
        SimpleDateFormat resFormatter = new SimpleDateFormat("dd/MM/yyyy"); //format that we want
      if(!targetLine.equals("")) {
          try {
              SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy"); //format what we have
              holder = targetLine.replaceAll("[^0-9]", ""); //takes the date (erases any int)
              d = formatter.parse(holder); //parse the date from the old format to the new one


          } catch (ParseException e) {
              e.printStackTrace();
          } catch (NullPointerException e) {
              return "no more lines";
          }
      }

        return resFormatter.format(d);
    }
}
