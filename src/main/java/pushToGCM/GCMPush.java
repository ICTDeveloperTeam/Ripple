/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package pushToGCM;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import javax.ejb.Stateless;

/**
 *
 * @author YusukeKato
 */
@Stateless
public class GCMPush {
    private static final String GCM_ENDPOINT_URL = "https://android.googleapis.com/gcm/send";
    private static final String API_KEY = "{API-KEY(Google APIsのコンソールで得られる文字列)}";
    private static final String CHARSET = "UTF-8";
    private static final int BUFFER_SIZE = 1024;
    
    public static void main(String[] args) throws IOException {
        String registationId = "{REGISTATION_ID(Androidでregistした際に得られる、スゴク長い文字列)}";
        String message = "Androidへの送信メッセージ";
        GCMPush.push(registationId, message);
    }
    public static String push(String registationId, String message) throws IOException {
        URL url = new URL(GCM_ENDPOINT_URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + CHARSET);
        connection.setRequestProperty("Authorization", "key=" + API_KEY);
        String postParameter = "registration_id=" + URLEncoder.encode(registationId, CHARSET) + "&collapse_key=update&data.message=" + URLEncoder.encode(message, CHARSET);
        PrintStream ps = new PrintStream(connection.getOutputStream());
        ps.print(postParameter);
        int responseCode = connection.getResponseCode();
        if (200 != responseCode) {
            String errorMessage = streamToString(connection.getErrorStream());
            throw new IOException("status = " + responseCode + ", message = " + errorMessage);
        }
        return streamToString(connection.getInputStream());
    }
    
    private static String streamToString(InputStream in) throws IOException {
        byte[] buffer = new byte[BUFFER_SIZE];
        int readed = in.read(buffer);
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        while (readed > 0) {
            bout.write(buffer, 0, readed);
            readed = in.read(buffer);
        }
        return new String(bout.toByteArray(), CHARSET);
    }
}
