import org.apache.commons.lang.WordUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TittleCase implements Command {
    @Override
    public String transform(String targetLine) {

        try {
            String holder = targetLine.replaceAll("[^A-Za-z]+", " ");
            int a = 0;
            String rest = "";
            Pattern whitespace = Pattern.compile("\\s\\w\\s");
            Matcher matcher = whitespace.matcher(holder);
            if (matcher.find()) {
                a = (matcher.start() + 2);
                rest = holder.substring(a);
                holder = holder.replace(holder.substring(a), ".");

            }

            holder = WordUtils.capitalize(holder + rest);

            return holder;

        } catch (NullPointerException e) {
            return "No more lines";
        }
    }
}

