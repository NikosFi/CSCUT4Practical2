
import java.io.*;
import java.util.*;


/**
 * NOTE FOR THE REVIEWER! --> The tittle case is not going to work if you don't download
 * the org.apache.commons.lang.WordUtils. I haven't figure out yet how to create a Maven or
 * Gradle project in order to add the dependency and make it feasible for everyone to run.
 * If you try to compile the program in cmd (for windows at least) this error will be pointed.
 *
 * If you want actually to test though and see how the WordUtils works,
 * please add the org.apache.commons.lang.WordUtils in your classpath and run the program with
 * predefined arguments utilizing your IDE. (Saemi showed how you can do this in Eclipse,Netbeans,Intelij)
 */
public class FilesInOut {
    public static void main(String[] args) throws IOException {


        //Initialize classes
        Command upperCase = new UpperCase();
        Command tittleCase = new TittleCase();
        Command formatDates = new FormatDates();

        String line = "";
        List<String> arr = new ArrayList<String>();

        try {
            String temp = "";

            String inputFileName = args[1];
            String outputfileName = args[2];
            File inputFile = new File(inputFileName);
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            line = (reader.readLine());
            PrintWriter fw = new PrintWriter(outputfileName);

            while (line != null) {

                if (args[0].equals("-t")) {
                    temp = tittleCase.transform(line) + formatDates.transform(line);
                    fw.println(temp);//appends the string to the file
                }

                if (args[0].equals("-u")) {
                    temp = upperCase.transform(line) + formatDates.transform(line);
                    fw.println(temp);
                }

                if (args[0].equals("-h")) {
                    temp = tittleCase.transform(line) + formatDates.transform(line);
                    arr.add(temp);
                }

                line = (reader.readLine());
                temp = temp.concat(temp);

            }
            if (args[0].equals("-h")) {
                fw.println("<html>");
                fw.println("<head>");
                fw.println("</head>");
                fw.println("<body>");
                fw.println("<p style=\"color:green;\">" + "\n");
                for (String element : arr) {
                    fw.println( "\t" + element + "<br>" );
                }
                fw.println();// the names and dates added
                fw.println("</p>");
                fw.println("</body>");
                fw.println("</html>");
                fw.close();

            }
            fw.close();
        } catch (IOException ioe) {
            System.err.println("IOException: " + ioe.getMessage());
        }

    }
}

//        String inputFileName = "";
//        String upperCaseFlag = "";
//        String fwName = "";
//
//            if (args[0].toUpperCase().equals("-U")) {
//                upperCaseFlag = args[0];
//                inputFileName = args[1];
//                outputfileName = args[2];
//            } else {
//                inputFileName = args[0];
//                outputfileName = args[1];
//            }
//
//        try {
//            File inputFile = new File(inputFileName);
//            Scanner inFile = new Scanner(inputFile);
//            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
//            String line = reader.readLine();
//            Date d = null;
//            while (line != null) { //Taking the dates from the names
//                SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy"); //format what we have
//                SimpleDateFormat resformatter = new SimpleDateFormat("dd/MM/yyyy"); //format that we want
//                String value = line.replaceAll("[^0-9]", ""); //takes the date (erases any int)
//                d = formatter.parse(value); //parse the date from the old format to the new one
//                String name = line.replaceAll("[\\d.]", ""); //takes the full name (erases any non-int)
//                if (upperCaseFlag.toUpperCase().equals("-U")) { //if -U flag, then turn name to uppercase
//                    name = name.toUpperCase();
//                } else {
//                    name = name.substring(0, 1).toUpperCase() + name.substring(1);
//                }
//                appendData(name, outputfileName, resformatter, d); //APENDING THE DATA INTO THE NEW FILE
//                line = reader.readLine(); //go to the next line of the file
//            }
//        } catch (IOException | ParseException e) {
//            System.err.println("IOException: " + e.getMessage() + "not found");
//        }
//    }
//
//    public static void appendData(String name, String fwName, SimpleDateFormat resformatter, Date d) {
//        try {
//            FileWriter fw = new FileWriter(fwName, true); //the true will append the new data
//            fw.write(name + resformatter.format(d));//appends the string to the file
//            fw.write("\n"); // new line
//            fw.close();
//        } catch (IOException ioe) {
//            System.err.println("IOException: " + ioe.getMessage());
//        }
