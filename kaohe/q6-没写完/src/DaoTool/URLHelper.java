package DaoTool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class URLHelper {
    private static URLHelper get;
    private static String temp;

    URLHelper(String url) {
        URL u;
        HttpURLConnection httpURLConnection;
        BufferedReader bf;
        String readLine;
        try {
            u = new URL(url);
            httpURLConnection = (HttpURLConnection) u.openConnection();
            int responce = httpURLConnection.getResponseCode();
            if (responce == 200) {
                bf = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8"));
                while ((readLine = bf.readLine()) != null) {
                    temp = temp + readLine + "\r\n";
                }
            } else {
                System.out.println(responce);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    URLHelper() {
        //DO_NOTHING
    }

    public static String start(String URL) {
        URLHelper myHp = new URLHelper(URL);
        return myHp.temp;
    }
}
