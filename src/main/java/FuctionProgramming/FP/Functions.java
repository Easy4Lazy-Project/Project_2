package FuctionProgramming.FP;

import FuctionProgramming.Model.*;
import FuctionProgramming.Model.Content;
import FuctionProgramming.Model.Question;
import FuctionProgramming.Model.User;

import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
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

public class Functions  {

    //1-user per Month
    public static Function<List<User>,List<Pair<YearMonth,Long>>> newUsersPerMonth =
            (UserList)->  UserList.stream()
                    .map(q-> YearMonth.from(q.getCreationDate()))
                    .collect(groupingBy(Function.identity(), Collectors.counting()))
                    .entrySet().stream()
                    .sorted((e1,e2) -> e2.getKey().compareTo(e1.getKey()))
                    .map(u -> new Pair<>(u.getKey(), u.getValue()))
                    .collect(Collectors.toList());
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
    public static Function<List<Content>,Integer> totalNumberOfAnswers =
            (QuestionList) ->  QuestionList.stream()
                    .map(q -> q.getAnswerList().size())
                    .reduce((e1,e2) -> e1 + e2)
                    .get();
    public static Function<List<Content>,Integer> totalNumberOfQuestions =
            (QuestionList) ->  QuestionList.stream()
                    .collect(Collectors.toList()).size();

    public static Function<List<Content>,Double> averageQuestionsPerAnswer =
            (QuestionList) -> Double.valueOf(totalNumberOfAnswers.apply(QuestionList)/totalNumberOfQuestions.apply(QuestionList));
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
                    .map(p-> new Question(Functions.ModerateBadWord.apply(p.getTitle(),setOfWord),Functions.ModerateBadWord.apply(p.getBody(),setOfWord) , p.getTags(), p.getCreationDate(), p.getUser()))
                    .map(s->(Content)s)
                    .findFirst()
                    .get();


    private static BiFunction< String , Set<String>, String > ModerateBadWord=
            (content,setOfWord) ->List.of(content).stream()
                    .flatMap(s-> Arrays.stream(s.split(" ")))
                    .filter(a->! setOfWord.contains(a))
                    .collect(Collectors.joining(" "));

    //9-Moderate (Repeated)
    public static Function<Content,  Content > ModerateRepeatedWordFormContent =
            (content ) -> List.of(content).stream()
                    .map(p-> new Question(Functions.ModerateRepeatedWord.apply(p.getTitle()),Functions.ModerateRepeatedWord.apply(p.getBody()) , p.getTags(), p.getCreationDate(), p.getUser()))
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
    public static Function<List<Content>,List<Pair<YearMonth,Long>>> answersPerMonth =
            (QuestionList)->  QuestionList.stream()
                    .flatMap(q -> q.getAnswerList().stream())
                    .map(a -> YearMonth.from(a.getCreationDate()))
                    .collect(groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
                    .sorted((e1,e2) ->e2.getKey().compareTo(e1.getKey()))
                    .map(a-> new Pair<>(a.getKey(), a.getValue()))
                    .collect(Collectors.toList());
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

