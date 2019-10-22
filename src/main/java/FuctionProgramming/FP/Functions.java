package FuctionProgramming.FP;

import FuctionProgramming.Model.Content;
import FuctionProgramming.Model.Question;
import FuctionProgramming.Model.User;
import FuctionProgramming.Model.Vote;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

@FunctionalInterface
interface TriFunction <U,L,Z,K> {

    K fin(U u,L l,Z z);
}

public class Functions {

    //1-user per Month
    //2-questions Per Month

    public static Function<List<User>,List<Pair<LocalDateTime,Long>>> questionsPerMonth =
            (UserList)->  UserList.stream()
                                .flatMap(u->u.getContentList().stream())
                                .map(q->q.getCreationDate())
                              .collect(groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
                              .sorted((e1,e2) ->e2.getKey().compareTo(e1.getKey()))
                               .map(a->new Pair<LocalDateTime,Long>(a.getKey(),a.getValue()))
                               .collect(Collectors.toList());

    //3-top Ten Users Vote
    public static Function<List<Vote>, List<Pair<User,Long>>> getTopTenUsersByVote = (votes) ->
            votes
                    .stream()
                    .collect(Collectors.groupingBy(Vote::getUser, counting()))
                    .entrySet().stream()
                    .sorted((u1,u2) -> (int) (u2.getValue() - u1.getValue()))
                    .map(u -> new Pair<User,Long>(u.getKey(),u.getValue()))
                    .limit(10)
                    .collect(Collectors.toList());


    //4-top Ten Users On Question
    //5-Average Of Answers Per Questions
    //6-Questions Without Answers
    //7-Average Of Answers Per User Per Month
    //8-Moderate on Bad Word
    //9-Moderate (Repeated)
    //10-top K Questions by vote
    //11- Top K tags
    public static BiFunction<List<Question>, Integer, List<String>> getKTags = (ques,k) ->
            ques
            .stream()
            .map(Content::getTags)
            .flatMap(t -> Arrays.stream(t.split(",")))
            .collect(groupingBy(Function.identity(), counting()))
            .keySet().stream()
            .limit(k)
            .collect(Collectors.toList());
    //12- Answer Per Month
    //13-Comment Per Month
    //14-Search
    static List<String> stopWords = List.of("of","the","we","are");
    public static BiFunction<List<Question>, String, List<Question>> search = (ques, searchString) ->
            ques.stream()
            .filter(q -> Functions.isFound.apply(q.getTitle(),Functions.searchStrRegex.apply(searchString)))
            .filter(q -> Functions.isFound.apply(q.getBody(),Functions.searchStrRegex.apply(searchString)))
            .collect(Collectors.toList());

    static Function<String, String> searchStrRegex = (searchStr) -> ".*".concat(Stream.of(searchStr.split(" ")).filter(w -> !stopWords.contains(w)).collect(Collectors.joining(".*")));
    static BiFunction<String, String, Boolean> isFound = (strToSearch, searchStr) -> Pattern.compile(searchStr).matcher(strToSearch).find();


     //15-My Top K Questions
}

