package FuctionProgramming.FP;

import FuctionProgramming.Model.Answer;
import FuctionProgramming.Model.Content;
import FuctionProgramming.Model.Question;
import FuctionProgramming.Model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
public class AverageofAnswersPerUserPerMonthTest {

    //Function 7
    List<User> userList = new ArrayList<>();
    List<Content> contentList = new ArrayList<>();

    @Before
    public void SetUp(){
        userList.add(new User("Ed","Gz","eduardo@mum.edu","123",
                   LocalDateTime.now(),null));
        userList.add(new User("Hd","","hd@mum.edu","123",
                LocalDateTime.now(),null));
        userList.add(new User("Dn","","Dn@mum.edu","123",
                LocalDateTime.now(),null));

        contentList.add(new Question("title","","",LocalDateTime.now(),userList.get(0)));
        List<Answer> ans1 = new ArrayList<Answer>(){{
            add(new Answer("Answer #1 ","",
                    LocalDateTime.of(2019,01,10,9,2),null,null));
            add(new Answer("Answer #2 ","",
                    LocalDateTime.of(2019,01,10,9,2),null,null));
            add(new Answer("Answer #2 ","",
                    LocalDateTime.of(2019,01,10,9,2),null,null));
            add(new Answer("Answer #3 ","",
                    LocalDateTime.of(2019,02,10,9,2),null,null));
            add(new Answer("Answer #4 ","",
                    LocalDateTime.of(2019,02,10,9,2),null,null));
            add(new Answer("Answer #5 ","",
                    LocalDateTime.of(2019,02,10,9,2),null,null));
            add(new Answer("Answer #6 ","",
                    LocalDateTime.of(2019,02,10,9,2),null,null));
        }};
        contentList.get(0).setAnswerList(ans1);


    }
    @Test
    public void testFunction(){
        System.out.println(Functions.AverageofAnswersPerUserPerMonth.apply(userList,contentList));
        List<Pair<Integer,Long>> expected = new ArrayList<>();
        expected.add(new Pair<Integer, Long>(1, (long) 1));
        expected.add(new Pair<Integer, Long>(2, (long) 1));
        List<Pair<Integer,Long>> actual =  Functions.AverageofAnswersPerUserPerMonth.apply(userList,contentList);

        assertEquals(actual.size() , 2);
        assertEquals(actual.get(0).getKey().intValue(), 1);
        assertEquals(actual.get(0).getValue().longValue(),(long) 1);
        assertEquals(actual.get(1).getKey().intValue(),2);
        assertEquals(actual.get(1).getValue().longValue(),(long) 1);
    }
}
