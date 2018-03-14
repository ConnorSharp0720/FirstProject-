import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Lab 9
 *
 * Test suite for the RPSArena class.
 *
 * @author Stephen
 * @version 2018-03-12
 *
 */
public class RPSArenaTest {

    /**
     * The RPSArena instance to test.
     */
    private static RPSArena arena;

    /**
     * Creates a RPSArena instance for testing.
     */
    @BeforeClass
    public static void initialize()
    {
        arena = new RPSArena();
    }
    
    /**
     * Tests the constructor and the contestant lists
     */
    @Test
    public void testContestantList() {
        String expectedRock = "GEO - george: contestant from north throwing rock\n" +
                "JIL - jill: contestant from south throwing rock\n";
        String expectedPaper = "BET - betty: contestant from west throwing paper\n";
        String expectedScissors = "RAT - ratthew: contestant from east throwing scissors\n";
        Assert.assertEquals("Contestant Map was not created properly.", expectedRock,
                arena.listContestantsWithHandChoice(HandChoice.ROCK));
        Assert.assertEquals("Contestant Map was not created properly.", expectedPaper,
                arena.listContestantsWithHandChoice(HandChoice.PAPER));
        Assert.assertEquals("Contestant Map was not created properly.", expectedScissors,
                arena.listContestantsWithHandChoice(HandChoice.SCISSORS));
    }

    /**
     * Tests getting the abbreviations.
     */
    @Test
    public void testContestantAbbreviations() {
        String expected = "[GEO, JIL, RAT, BET]";
        Assert.assertEquals("Contestant Map Keys were not created properly.", expected,
                arena.getContestantAbbreivations().toString());
    }
    
    // TODO: finish tests:
    
    /**
     * Tests getting the contestants that exist in the map.
     */
    
    
    /**
     * Tests getting a contestant that does not exist in the map.
     */
    
    
    /**
     * Tests a contestant battle ending in a tie.
     */
    
    
    /**
     * Tests a contestant battle ending in contestantA winning.
     */
    
    
    /**
     * Tests a contestant battle ending in contestantB winning.
     */
    
}
