package nl.gauket.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class adventOfCodeService {
    private static final String SESSION =
            "53616c7465645f5f481d3cbf6d9d7f2dde93d32a687cf41eb3a3a34326c627699e9c87f082ce13ec57759e6b35fb4f1e";
    private static final String url = "https://adventofcode.com/%s/day/%s/input";
    InputWriter inputWriter;

    public adventOfCodeService() {
        this.inputWriter = new InputWriter();
    }

    public void prepareDailyInput(int year, int day) {
        if (!inputWriter.checkIfInputExists(year, day)) {
            // get input from AOC
            if (!downloadInputFromServer(year, day)) throw new RuntimeException("Something went wrong downloading input from AOC server");
        }
    }

    private boolean downloadInputFromServer(int year, int day) {
        String urlAoc = String.format(url, year, day);
        return requestInputFromServer(urlAoc, year, day);
    }

    private boolean requestInputFromServer(String urlAoc, int year, int day) {
        HttpURLConnection con = null;
        try {
            URL url = new URL(urlAoc);
            con = (HttpURLConnection) url.openConnection();

            con.setRequestMethod("GET");
            con.setRequestProperty("Cookie", "session="+SESSION);

            int status = con.getResponseCode();

            if (status == 200) {
                inputWriter.writeToFile(year, day,
                        new BufferedReader(new InputStreamReader(con.getInputStream())));
            } else {
                throw new IOException("Something went wrong downloading input from AOC server");
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (con != null) {
                con.disconnect();
            }
        }
    }
}
