public class EX10_JinkouToukei {
    public static void main(String[] args) {
        FileIn fi = new FileIn();

        String line;
        String[] region = new String[8];
        int totalPopulation = 0;
        int[] area = new int[8];
        int[] population = new int[8];
        int count = 0;
        boolean ret;

        /* ファイルオープン */
        try {
            fi.open(args[0]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ファイル名を指定してください");
            System.exit(1);
        }

        System.out.println("*** 地域別人口統計 ***");
        System.out.println("*.........*.........*.........*.........");
        System.out.println("地域\t 面積\t人口　人口密度　人口比率");
        System.out.println("----------------------------------------");

        /* 各データを配列に格納する */
        while ((line = fi.readLine()) != null) {
            String[] data = line.split(" ");
            if (data.length != 3) {
                System.out.println("エラー！データが正しくありません: " + line);
                System.exit(1);
            }
            region[count] = data[0];
            area[count] = Integer.parseInt(data[1]);
            population[count] = Integer.parseInt(data[2]);
            totalPopulation += population[count];
            count++;
        }
        /* 人口密度、人口比率を計算して地域別人口統計表を表示する */
        for (int i = 0; i < count ; i++){
            double populationDensity = (double) population[i] * 10000 / area[i];
            double populationRatio = (double) population[i] / totalPopulation * 100;
            System.out.printf("%3s\t%5d\t%4d   %7.2f    %5.2f%n", region[i], area[i], population[i], populationDensity, populationRatio);
        }

        /* ファイルクローズ */
        ret = fi.close();
        if (ret == false) {
            System.out.print("プログラムを異常終了します");
            System.exit(1);
        }
    }
}
