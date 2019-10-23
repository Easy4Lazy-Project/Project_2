package FuctionProgramming.FP;

import java.util.Comparator;

public class PairQuestionComparator implements Comparator<Pair> {
    @Override
    public int compare(Pair t1, Pair t2) {
        return (int) t1.getValue() - (int) t2.getValue();
    }
}
