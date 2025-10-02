package org.example;

public class App 
{
    public enum Rank {VANG, BAC, DONG, CHOI_XAU}

    private App() {}

    private static String Ranking(Rank rank) {
        switch (rank) {
            case VANG -> {
                return "Vàng";
            }
            case BAC -> {
                return "Bạc";
            }
            case DONG -> {
                return "Đồng";
            }
            default -> {
                return "Chơi xấu";
            }
        }
    }

    public static String classify(int goals, double fairPlay, int fans) {
        if(fairPlay < 3.0) {
            return Ranking(Rank.CHOI_XAU);
        }
        if(goals >=5 && fairPlay >= 7.0 && fans >= 50000) {
            return Ranking(Rank.VANG);
        }
        if(goals >= 3 && fairPlay >= 5.0 && fans >= 20000) {
            return Ranking(Rank.BAC);
        }
        return Ranking(Rank.DONG);
    }
}
