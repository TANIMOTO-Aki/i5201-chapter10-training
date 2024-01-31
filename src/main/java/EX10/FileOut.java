import java.io.*;

public class FileOut {
    BufferedWriter bw = null;
    /* ファイルのオープンを行う */
    public boolean open(String filename) {
        boolean sts = true;
        try {
            bw = new BufferedWriter(new FileWriter(filename));
        } catch (IOException e) {
            System.out.println("ファイル名に誤りがあります\n" + e);
            sts = false;
        }
        return sts;
    }

    /* ファイルへのデータ書き込みを行う */
    public boolean writeln(String str) {
        boolean sts = true;
        try {
            bw.write(str + "\n");
        } catch (IOException e) {
            System.out.println("書き込みエラー\n" + e);
            sts = false;
        }
        return sts;
    }

    /* ファイルのクローズを行う */
    public boolean close(){
        boolean sts = true;
        try {
            bw.close();
        } catch(IOException e) {
            System.out.println("ファイルのクローズエラー\n" + e);
            sts = false;
        }
        return sts;
    }
}
