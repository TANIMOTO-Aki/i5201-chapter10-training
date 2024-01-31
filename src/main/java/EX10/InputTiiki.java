public class InputTiiki {

    /* 地域名が全角3文字であるか確認するメソッド */
    public boolean isValidRegion(String region) {
        if (region.length() != 3) {             // 文字列が３文字か確認する
            return false;
        }
        /* 各文字が全角かどうかを確認する */
        for (int i = 0; i < region.length(); i++) {
            char c = region.charAt(i);
            if (c < 0x3000 || c > 0xFFFF) {     //文字コード0x3000～0xFFFFが全角文字
                return false;
            }
        }
        return true;
    }

    /* 面積が入力条件に当てはまっているか確認するメソッド */
    public boolean isValidArea(String area) {
        if (area.isEmpty()) {
            return false;
        }
        try {
            int areaValue = Integer.parseInt(area);
            return areaValue > 0 && areaValue < 1000000;    //0や未入力、6桁以上はエラー
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /* 人口が入力条件に当てはまっているか確認するメソッド */
    public boolean isValidPopulation(String population) {
        if (population.isEmpty()) {
            return false;
        }
        try {
            int populationValue = Integer.parseInt(population);
            return populationValue > 0 && populationValue < 100000; //0や未入力、5桁以上はエラー
        } catch (NumberFormatException e) {
            return false;
        }
    }
}