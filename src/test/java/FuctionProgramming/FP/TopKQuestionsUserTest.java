package FuctionProgramming.FP;

import FuctionProgramming.Model.Content;
import FuctionProgramming.Model.Question;
import FuctionProgramming.Model.User;
import FuctionProgramming.Model.Vote;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.graalvm.compiler.options.OptionType.User;

public class TopKQuestionsUserTest {
    User u1;
    @Before
    public void SetUp(){
        u1= new User("Eduardo","","","",
                LocalDateTime.now(),null);
        User u2 = new User("Voter","","","",
                LocalDateTime.now(),null);

        List<Content> q = new ArrayList<Content>(){{
        add(new Question("Second Best Question","","",LocalDateTime.now(),u1));
        add(new Question("Best Question","","",LocalDateTime.now(),u1));


        }};
        List<Vote> v1 = new ArrayList<Vote>(){{
            add(new Vote(1,u2));
            add(new Vote(1,u2));
            add(new Vote(1,u2));
            add(new Vote(1,u2));
            add(new Vote(1,u2));
            add(new Vote(1,u2));
        }};
        List<Vote> v2 = new ArrayList<Vote>(){{
            add(new Vote(1,u2));
            add(new Vote(1,u2));
            add(new Vote(-1,u2));
            add(new Vote(1,u2));
            add(new Vote(-1,u2));
            add(new Vote(1,u2));
        }};
        q.get(0).setVoteList(v1);
        q.get(1).setVoteList(v2);
        u1.setContentList(q);
    }
    @Test
    public void TestTopKQuestionsUser(){
        List<Pair<Content,Integer>> topQuestions = Functions.TopKQuestionsUser.apply(u1,2);
        Assert.assertEquals(topQuestions.size(),2);
        Assert.assertEquals(topQuestions.get(0).getKey().getTitle(), "Best Question");
    }

}
