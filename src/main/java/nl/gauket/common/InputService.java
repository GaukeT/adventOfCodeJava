package nl.gauket.common;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import static nl.gauket.common.InputWriter.checkIfInputExists;
import static nl.gauket.common.InputWriter.writeToFile;

public class InputService extends Timer {
    private static final String url = "https://adventofcode.com/%s/day/%s/input";
    private final String session = System.getProperty("session");

    public void prepareDailyInput(int year, int day) {
        if (!checkIfInputExists(year, day)) {
            // get input from AOC
            start();
            downloadInputFromServer(year, day);
            stop("Download file from server in");
        }
    }

    private void downloadInputFromServer(int year, int day) {
        String urlAoc = String.format(url, year, day);

        if (!requestInputFromServer(urlAoc, year, day))
            throw new RuntimeException("Something went wrong downloading input from AOC server");
    }

    private boolean requestInputFromServer(String urlAoc, int year, int day) {
        HttpURLConnection con = null;
        try {
            URL url = new URL(urlAoc);
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Cookie", "session=" + session);

            int status = con.getResponseCode();

            if (status == 200) {
                InputStream in = con.getInputStream();
                writeToFile(year, day, in);
            } else {
                throw new IOException("Something went wrong downloading input from AOC server | response code: " + status);
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
