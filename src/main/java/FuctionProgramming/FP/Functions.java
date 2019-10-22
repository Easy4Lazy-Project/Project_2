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
    //get vote list from user list
    public static Function<List<User>, List<Vote>> getVotesFromUserList = (users) ->
            users.stream()
                    .filter(u -> u.getContentList()!=null)
                    .flatMap(u-> u.getContentList().stream())
                    .filter(c -> c.getAnswerList() != null)
                    .flatMap(c -> c.getAnswerList().stream())
                    .filter(a -> a.getVoteList() != null)
                    .flatMap(a -> a.getVoteList().stream())
                    .collect(Collectors.toList());

    public static Function<List<User>, List<Pair<User,Long>>> getTopTenUsersByVote = (users) ->
            Functions.getVotesFromUserList.apply(users)
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
    //get vote list from user list
    public static Function<List<User>, List<Content>> getQuesFromUserList = (users) ->
            users.stream()
                    .filter(u -> u.getContentList() != null)
                    .flatMap(u->u.getContentList().stream())
                    .collect(Collectors.toList());
    public static BiFunction<List<User>, Integer, List<String>> getKTags = (users,k) ->
            Functions.getQuesFromUserList.apply(users)
            .stream()
            .map(Content::getTags)
            .flatMap(t -> Arrays.stream(t.split(",")))
            .collect(groupingBy(Function.identity(), counting()))
                    .entrySet().stream()
                    .sorted((c1,c2)-> (int) (c2.getValue() - c1.getValue()))
            .map(c -> c.getKey())
            .limit(k)
            .collect(Collectors.toList());
    //12- Answer Per Month
    //13-Comment Per Month
    //14-Search
    // Search returns any possible search string
    public static List<String> stopWords = Arrays.asList("of","the","we","are","[]","(",")");
    public static BiFunction<List<User>, String, List<Content>> search = (users, searchString) ->
            Functions.getQuesFromUserList.apply(users).stream()
            .filter(q -> Functions.isFound.apply(q.getTitle(),Functions.searchStrRegex.apply(searchString)) ||
                    Functions.isFound.apply(q.getBody(),Functions.searchStrRegex.apply(searchString)))
           // .filter(q -> Functions.isFound.apply(q.getBody(),Functions.searchStrRegex.apply(searchString)))
            .collect(Collectors.toList());

    public static Function<String, String> searchStrRegex = (searchStr) -> Stream.of(searchStr.split(" ")).filter(w -> !stopWords.contains(w)).collect(Collectors.joining("|"));
    public static BiFunction<String, String, Boolean> isFound = (strToSearch, searchStr) -> Pattern.compile(searchStr).matcher(strToSearch).find();


     //15-My Top K Questions
}

