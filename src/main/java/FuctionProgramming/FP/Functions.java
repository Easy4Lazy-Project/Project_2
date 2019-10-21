package FuctionProgramming.FP;

import FuctionProgramming.Model.Question;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

@FunctionalInterface
interface TriFunction <U,L,Z,K> {

    K fin(U u,L l,Z z);
}

public class Functions {

    //1-user per Month
    //2-questions Per Month

    static Function<List<Question>,List<Pair<LocalDateTime,Long>>> questionsPerMonth =
            (QuestionList)->  QuestionList.stream()
                              .map(q->q.getCreationDate())
                              .collect(groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
                              .sorted((e1,e2) ->e2.getKey().compareTo(e1.getKey()))
                               .map(a->new Pair<LocalDateTime,Long>(a.getKey(),a.getValue()))
                               .collect(Collectors.toList());

    //3-top Ten Users Vote
    //4-top Ten Users On Question
    //5-Average Of Answers Per Questions
    //6-Questions Without Answers
    //7-Average Of Answers Per User Per Month
    //8-Moderate on Bad Word
    //9-Moderate (Repeated)
    //10-top K Questions by vote
    //11- Top K tags
    //12- Answer Per Month
    //13-Comment Per Month
    //14-Search
    //15-My Top K Questions
}

