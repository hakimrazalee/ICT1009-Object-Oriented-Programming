package Tank;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class matchHistory {
    private String username;
    private String timeStamp;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd HH:mm");
    LocalDateTime now = LocalDateTime.now();

    public String setScore(String username, String lives){
        this.username = username;
        this.timeStamp = dtf.format(now);
        if(username.length()>=11){
            username = username.substring(0, 10);
        }
        if(username.length() > 0){
            username = stringPadding(username,10);
        } else {
            username = "<<Blank>>";
        }


        username = username.toUpperCase();
        return String.format("%-15s%5s%20s",timeStamp,lives, username);


    }

    public List<String> getList(String path){
        try {
            List<String> allLines = Files.readAllLines(Path.of(path));
            return allLines;
        }catch(Exception e) {
            return null;
        }
    }

    public String loadScore(String path) {
        try {
            List<String> allLines = Files.readAllLines(Path.of(path));
            for (String line : allLines) {
                return line;
            }
        }catch(Exception e){
            return "                 No recent matches!";
        }
//         catch (Exception e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }
        return "                 No recent matches!";
    }

    public int getLength(String path){
        try {
            List<String> allLines = Files.readAllLines(Path.of(path));
            return allLines.size();
        }catch(Exception e){
            return 0;
        }
    }

    private String stringPadding(String inputString, int length){
        if (inputString.length() >= length) {
            return inputString;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() < length - inputString.length()) {
            sb.append(' ');
        }
        sb.append(inputString);

        return sb.toString();
    }

}
