package macaroni;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MacaroniFetcher {

    private final static String MACARONIES_LOCATION = "macaronies/";

    private final Map<MacaroniumType, Macaronium> macaroniums;

    public MacaroniFetcher() {
        this.macaroniums = fetchAllMacaroniums();
    }

    public Macaronium getByType(MacaroniumType type) {
        return macaroniums.get(type);
    }

    private Map<MacaroniumType, Macaronium> fetchAllMacaroniums() {
        List<MacaroniumType> macaroniTypes = Arrays.stream(MacaroniumType.values()).toList();

        Map<MacaroniumType, Macaronium> macaroniums = new HashMap<>();
        for (MacaroniumType type: macaroniTypes) {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(MACARONIES_LOCATION + type.getType() + ".json");
            assert inputStream != null;
            macaroniums.put(type, new Gson().fromJson(String.join("", new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8)).lines().toList()), Macaronium.class));
        }
        return macaroniums;
    }

}