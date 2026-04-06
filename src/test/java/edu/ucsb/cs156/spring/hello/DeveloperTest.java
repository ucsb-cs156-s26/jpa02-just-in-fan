package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        // TODO: Replace Chris G. with your name as shown on
        // <https://bit.ly/cs156-s26-teams>
        assertEquals("Justin", Developer.getName());
    }

    @Test
    public void getGithubUsername_returns_correct_githubId() {
        // TODO: Replace chrisg with your GitHub username as shown on
        // <https://bit.ly/cs156-s26-teams>
        assertEquals("just-in-fan", Developer.getGithubId());
    }

    @Test
    public void getTeam_returns_correct_team() {
        Team team = Developer.getTeam();
        assertEquals("s26-02", team.getName());
        assertTrue(team.getMembers().contains("Justin"), "Team should contain Justin");
        assertTrue(team.getMembers().contains("Andrew B."), "Team should contain Andrew B.");
        assertTrue(team.getMembers().contains("Arman"), "Team should contain Arman");
        assertTrue(team.getMembers().contains("David Chen"), "Team should contain David Chen");
        assertTrue(team.getMembers().contains("Kai"), "Team should contain Kai");
        assertTrue(team.getMembers().contains("Kevin"), "Team should contain Kevin");
    }
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
