import java.io.*;
import java.nio.charset.Charset;

public class KeyIn {
    String buf = null;
    BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in,
                    Charset.forName(System.getProperty("native.encoding"))));
    
    /* キーボードから入力した文字列を返す */
    public String readKey() {
        try {
            buf = br.readLine();
        } catch (IOException e ) {
            System.out.println(e);
            System.exit(1);
        }
        return buf;
    }

    /* msgで指定された文字列をプロンプトとして表示する */
    public String readKey(String msg) {
        System.out.print(msg + "=");
        return readKey();
    }
}