package ajurakudroot.postgre;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class PostgreDB {

    private static final String FOLDER = "PostgreDB/";

    private static PostgreDB postgreDB;

    private PostgreDB() {

    }

    public static PostgreDB getInstance() {
        if (postgreDB == null) {
            postgreDB = new PostgreDB();
        }
        return postgreDB;
    }

    public String getTableData(String tableName) {
        try {
            JsonArray data = new Gson().fromJson(new String(Files.readAllBytes(Path.of(path(tableName)))), JsonArray.class);
            return data == null ? null : data.toString();
        } catch (IOException e) {
            return null;
        }
    }

    public boolean createTable(String tableName) {
        try {
            return new File(path(tableName)).createNewFile();
        } catch (IOException e) {
            return false;
        }
    }

    public boolean deleteTable(String tableName) {
        return new File(path(tableName)).delete();
    }

    public void addRow(String tableName, String row) {
        try {
            JsonArray data = new Gson().fromJson(new String(Files.readAllBytes(Path.of(path(tableName)))), JsonArray.class);
            if (data == null) {
                data = new JsonArray();
            }
            data.add(row);
            String json = data.getAsString();
            if (!(json.startsWith("[") && json.endsWith("]"))) {
                json = "[" + json + "]";
            }
            Files.writeString(Path.of(path(tableName)), json);
        } catch (IOException e) {
            throw new RuntimeException("Whoopsie");
        }
    }

    private String path(String tableName) {
        return FOLDER + tableName + ".json";
    }

    /*
    Path fileName = Path.of("demo.txt");
        String content  = "hello world !!";
        Files.writeString(fileName, content);

        String actual = Files.readString(fileName);
        System.out.println(actual);
     */

}
