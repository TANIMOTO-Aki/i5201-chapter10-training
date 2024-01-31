public class EX10_InputTiiki {
    public static void main(String[] args) {
        final String SEPARATOR = " ";
        final int MAX_ATTEMPTS = 8;
        boolean ret;
        String buf;
        int count = 0;

        KeyIn ki = new KeyIn();
        FileOut fo = new FileOut();
        InputTiiki it = new InputTiiki();

        /* ファイルオープン */
        try {
            fo.open(args[0]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ファイル名を指定してください");
            System.exit(1);
        }

        /* データ入力 */
        System.out.println("--- 地域データ入力開始 ---");
        for (int i = 1; i <= MAX_ATTEMPTS; i++) {
            /* 地域の入力 */
            String region = ki.readKey("地域（未入力で終了）\t");
            if (region.isEmpty())break;         //未入力の場合終了する
            /* 地域が全角３文字でない場合エラー表示+再入力 */
            while (!it.isValidRegion(region)) {
                System.out.println("！！！地域入力エラー！！！");
                region = ki.readKey("地域（全角３文字）\t");
            }

            /* 面積の入力 */
            String area;
            do {
                area = ki.readKey("面積（km2）\t\t");
                /* 面積が未入力、０、６桁以上の場合エラー+再入力 */
                if (!it.isValidArea(area)) {
                    System.out.println("！！！面積入力エラー！！！");
                }
            } while (!it.isValidArea(area));

            /* 人口の入力 */
            String population;
            do {
                population = ki.readKey("人口（万人）\t\t");
                /* 人口が未入力、０、５桁以上の場合エラー+再入力 */
                if (!it.isValidPopulation(population)) {
                    System.out.println("！！！人口入力エラー！！！");
                }
            } while (!it.isValidPopulation(population));

            buf = region + SEPARATOR + area + SEPARATOR + population;
            fo.writeln(buf);
            count++;
        }

        /* ファイルクローズ */
        ret = fo.close();
        if (ret == false) {
            System.out.print("プログラムを異常終了します");
            System.exit(1);
        }

        System.out.println("--- 地域データ入力終了 ---");
        System.out.println("地域ファイル入力件数 ＝ " + count + " 件");
    }
}
