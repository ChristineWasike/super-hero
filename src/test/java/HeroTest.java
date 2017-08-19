import org.junit.*;
import static org.junit.Assert.*;
import java.time.LocalDateTime;


public class HeroTest {

    @Test //test for hero instance
    public void Hero_instantiatesCorrectly_true() {
        Hero myHero = new Hero("Spiderman", 35, "spiderwebs", "kryptonite" );
        assertEquals(true, myHero instanceof Hero);
    }

    @Test //name instantiates too
    public void Hero_instantiatesWithName_String() {
        Hero myHero = new Hero("Spiderman", 35, "spiderwebs", "kryptonite" );
        assertEquals("Spiderman", myHero.getName());
    }

    @Test  //age instatniates too

    public void getAge_instantiatesWithAge_35() {
        Hero myHero = new Hero("Spiderman", 35, "spiderwebs", "kryptonite");
        Integer expected = 35;
        assertEquals(expected, myHero.getAge());
    }

    @Test //power instantiates too
    public void getPower_instantiatesWithPower_String() {
        Hero myHero = new Hero("Spiderman", 35, "spiderwebs", "kryptonite");
        assertEquals("spiderweb", myHero.getPower());
    }

    @Test //weakness instantiates too
    public void getWeakness_instantiatesWithWeakness_String() {
        Hero myHero = new Hero("Spiderman", 35, "spiderwebs", "kryptonite");
        assertEquals("kryptonite", myHero.getWeakness());
    }

    @Test //hero on mission
    public void getMission_isFalseAfterInstantiation_false() {
        Hero myHero = new Hero("Spiderman", 35, "spiderwebs", "kryptonite");
        assertEquals(false, myHero.getMission());
    }

    @Test //time of creating hero
    public void getCreatedAt_instantiesWithCurrentTime_today() {
        Hero myHero = new Hero("Spiderman", 35, "spiderwebs", "kryptonite");
        assertEquals(LocalDateTime.now().getDayOfWeek(), myHero.getCreateAt().getDayOfWeek());
    }
}


