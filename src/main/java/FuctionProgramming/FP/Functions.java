package FuctionProgramming.FP;

import FuctionProgramming.Model.*;
import FuctionProgramming.Model.Content;
import FuctionProgramming.Model.Question;
import FuctionProgramming.Model.User;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

@FunctionalInterface
interface TriFunction <U,L,Z,K> {

    K fin(U u,L l,Z z);
}

public class Functions  {

    //1-user per Month
    //2-questions Per Month

    public static Function<List<User>,List<Pair<LocalDateTime,Long>>> questionsPerDate =
            (UserList)->  UserList.stream()
                    .flatMap(u->u.getContentList().stream())
                    .map(q->q.getCreationDate())
                    .collect(groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
                    .sorted((e1,e2) ->e2.getKey().compareTo(e1.getKey()))
                    .map(a-> new Pair<>(a.getKey(), a.getValue()))
                    .collect(Collectors.toList());

    //3-top Ten Users Vote
    //4-top Ten Users On Question
    //5-Average Of Answers Per Questions
    //6-Questions Without Answers
    //7-Average Of Answers Per User Per Month
    public static BiFunction<List<User>,List<Content>, List<Pair<Integer,Long>>> AverageofAnswersPerUserPerMonth =
            (users, content) -> content.stream()
                .flatMap(c -> c.getAnswerList().stream())
                .collect(groupingBy(Answer::getCreationMonth, Collectors.counting())).entrySet().stream()
            .map(a-> new Pair<Integer,Long>(a.getKey(),(a.getValue()/users.size())))
            .collect(Collectors.toList());
    //8-Moderate on Bad Word

    public static BiFunction<Content, Set<String>, Content > ModerateBadWordFromContent =
            (content,setOfWord) ->List.of(content).stream()
                    .map(p-> new Question(p.getTitle(),Functions.ModerateBadWord.apply(p.getBody(),setOfWord) , p.getTags(), p.getCreationDate(), p.getUser()))
                    .map(s->(Content)s)
                    .findFirst()
                    .get();


    public static BiFunction< String , Set<String>, String > ModerateBadWord=
            (content,setOfWord) ->List.of(content).stream()
                    .flatMap(s-> Arrays.stream(s.split(" ")))
                    .filter(a->! setOfWord.contains(a))
                    .collect(Collectors.joining(" "));

    //9-Moderate (Repeated)
    public static Function<Content,  Content > ModerateRepeatedWordFormContent =
            (content ) ->List.of(content).stream()
                    .map(p-> new Question(p.getTitle(),Functions.ModerateRepeatedWord.apply(p.getBody()) , p.getTags(), p.getCreationDate(), p.getUser()))
                    .map(s->(Content)s)
                    .findFirst()
                    .get();

    public static Function< String , String > ModerateRepeatedWord=
            (c)->List.of(c).stream()
                    .flatMap(a->Arrays.stream(a.split(" ")))
                    .flatMap(s->Arrays.stream(s.split("@",1 )))
                    .distinct()
                    .collect(Collectors.joining(" "));


    //10-top K Questions by vote
    //11- Top K tags
    //12- Answer Per Month
    //13-Comment Per Month
    public static BiFunction<List<User>,Integer, List<Pair<Integer,Long>>> CommentsPerMonth =
            (users, year) -> users.stream()
                            .flatMap(q -> q.getContentList().stream())
                            .flatMap(c->c.getCommentList().stream())
                            .filter(c -> c != null)
                            .filter(q-> q.getCreationDate().getYear() == year)
            .collect(groupingBy(Comment::getCreationMonth,
                    Collectors.counting())).entrySet().stream()
            .map(q -> new Pair<Integer,Long>(q.getKey(), q.getValue()))
            .collect(Collectors.toList());

     /*                       .map(q -> new HashMap<Integer,Content>(){{
                                put(q.getCreationDate().getMonthValue(),q);
                            }}.entrySet().stream().findFirst().get())
            .map(q-> q.getValue())

      */
    //14-Search
    //15-My Top K Questions
    public static BiFunction<User,Integer, List<Pair<Content,Integer>>> TopKQuestionsUser =
            (user, k) -> user.getContentList().stream()
                    .map(c -> new Pair<Content,Integer>(c, c.getVoteList().stream()
                            .map(v -> v.getVote())
                            .reduce((v1,v2) -> v1+v2).get()
                    )

                    ).collect(Collectors.toList())
                    .stream()
                    .sorted(new PairQuestionComparator())
                    .limit(k)
                    .collect(Collectors.toList());

}

