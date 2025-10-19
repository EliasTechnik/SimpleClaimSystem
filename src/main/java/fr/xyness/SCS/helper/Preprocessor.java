package fr.xyness.SCS.helper;

import java.util.ArrayList;
import java.util.List;

public class Preprocessor {

    public static String[] preprocessArgs(String[] args){
        String combined = "";
        Boolean inQuotes = false;
        List<String> newArgs = new ArrayList<>();

        for(int i=0; i<args.length; i++){
            if(args[i].startsWith("\"")){
                //combine until we find the end
                inQuotes = true;
                combined = args[i].replace("\"","");
            } else if (args[i].endsWith("\"")) {
                //found the end
                combined = combined + " " +args[i].replace("\"","");
                inQuotes = false;
                newArgs.add(combined);
            } else if (inQuotes) {
                combined = combined + " " +args[i];
            }else{
                newArgs.add(args[i]);
            }
        }

        String[] rArgs = new String[newArgs.size()];
        return newArgs.toArray(rArgs);
    }

    public static int getAlpha(String colorHex){
        if(colorHex.length() == 8 ){
            return Integer.parseInt(colorHex.substring(0, 2), 16);
        }
        else{
            return 0xFF;
        }
    }

    public static String getRGBString(String colorHex){
        if(colorHex.length() == 8 ){
            return colorHex.substring(2);
        }
        else{
            return colorHex;
        }
    }

    public static int getRGB(String colorHex){
        return Integer.parseInt(getRGBString(colorHex), 16);
    }
}
