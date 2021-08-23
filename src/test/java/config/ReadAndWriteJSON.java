package config;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadAndWriteJSON {

    public static void writeJson(String values, String nameFile) throws IOException {
        FileWriter file = new FileWriter("src/test/"+ nameFile +".json");
        file.write(values);
        file.flush();
    }

    public static String readJson(String fileName) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        FileReader reader = new FileReader("src/test/"+ fileName +".json");
        return parser.parse(reader).toString();
    }


}
