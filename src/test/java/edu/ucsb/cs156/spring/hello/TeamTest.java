package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

   
    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_same() {
        Team team1 = new Team("Team 01");
        assertTrue(team1.equals(team1));
    }

    @Test
    public void equals_differentClass() {
        Team team1 = new Team("Team 01");
        assertFalse(team1.equals(new String("string")));
    }

    @Test
    public void equals_sameNameandMembers() {
        Team team1 = new Team("Team 01");
        team1.addMember("Jun");
        team1.addMember("Raymond");
        
        Team team2 = new Team("Team 01");
        team2.addMember("Jun");
        team2.addMember("Raymond");
        
        assertTrue(team1.equals(team2));
    }

    @Test
    public void equals_sameNameDiffMembers() {
        Team team1 = new Team("Team 01");
        team1.addMember("Jun");
        team1.addMember("Raymond");

        Team team3 = new Team("Team 01");
        team3.addMember("Scott");
        team3.addMember("Vincent");
        
        assertFalse(team1.equals(team3));
    }

    @Test
    public void equals_diffName() {
        Team team1 = new Team("Team 01");
        team1.addMember("Jun");
        team1.addMember("Raymond");

        Team team4 = new Team("Team 02");
        team4.addMember("Jun");
        team4.addMember("Raymond");
        
        assertFalse(team1.equals(team4));
    }

    @Test
    public void hashcodeTest() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
        assertEquals(t1.hashCode(), t2.hashCode());
    }

    @Test 
    public void hashcodeOtherTest() {
        Team t = new Team();
        int result = t.hashCode();
        int expectedResult = 1;
        assertEquals(expectedResult, result);
    }

}
