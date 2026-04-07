package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void equals_case1() {
        // Case 1: Same Object
        assert(team.equals(team));
    }

    @Test
    public void equals_case2() {
        // Case 2: Different Class
        assert(!team.equals("Not a Team"));
    }

    @Test
    public void equals_case3_1() {
        // Case 3: Cast the other object to this class, and compare all of the fields, TT
        Team other = new Team("test-team");
        team.addMember("Justin");
        other.addMember("Justin");
        assert(team.equals(other));
    }

    @Test
    public void equals_case3_2() {
        // Case 3: Cast the other object to this class, and compare all of the fields, TT
        Team other = new Team("test-team");
        team.addMember("Justin");
        other.addMember("Not Justin");
        assert(!team.equals(other));
    }

    @Test
    public void equals_case3_3() {
        // Case 3: Cast the other object to this class, and compare all of the fields, TT
        Team other = new Team("bad-team");
        team.addMember("Justin");
        other.addMember("Justin");
        assert(!team.equals(other));
    }

    @Test
    public void equals_case3_4() {
        // Case 3: Cast the other object to this class, and compare all of the fields, TT
        Team other = new Team("bad-team");
        team.addMember("Justin");
        other.addMember("Not Justin");
        assert(!team.equals(other));
    }

    @Test
    public void hash_test() {
        assertEquals(team.getName().hashCode() | team.getMembers().hashCode(), team.hashCode());
    }
   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
