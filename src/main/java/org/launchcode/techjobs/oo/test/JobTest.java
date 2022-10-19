package org.launchcode.techjobs.oo.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
@Test
    public void testSettingJobId(){
    Job jobTestOne = new Job();
    Job jobTestTwo = new Job();
        assertEquals(jobTestOne.getId(),jobTestTwo.getId(), 1);
        assertNotEquals(jobTestOne.getId(),jobTestTwo.getId());
}
    @Test
    public void testJobConstructorSetsAllFields(){
        Job jobTestThree = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(jobTestThree.getName() instanceof String);
        assertEquals("Product tester", jobTestThree.getName());
        assertTrue(jobTestThree.getEmployer() instanceof Employer);
        assertEquals("ACME", jobTestThree.getEmployer().getValue());
        assertTrue(jobTestThree.getLocation() instanceof Location);
        assertEquals("Desert", jobTestThree.getLocation().getValue());
        assertTrue(jobTestThree.getPositionType() instanceof PositionType);
        assertEquals("Quality control", jobTestThree.getPositionType().getValue());
        assertTrue(jobTestThree.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Persistence", jobTestThree.getCoreCompetency().getValue());
    }
    @Test
    public void testJobsForEquality(){
        Job jobTestThree = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job jobTestFour = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Assert.assertFalse(jobTestThree.equals(jobTestFour));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job jobTestThree = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
         assertEquals(jobTestThree.toString().charAt(0),"\n");
         assertEquals(jobTestThree.toString().charAt(jobTestThree.toString().length() - 1), "\n");
    }
    @Test
    public void  testToStringContainsCorrectLabelsAndData(){
        Job jobTestThree = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals("ID: " + jobTestThree.getId() +
                "\n" + "Name: Product tester" +
                "\n" + "Employer: Data not available" +
                "\n" + "Location: Desert" +
                "\n" + "Position Type: Quality control" +
                "\n" + "Core Competency: Data not available" +
                "\n"  , jobTestThree.toString());
    }
    @Test
    public void testToStringHandlesEmptyField(){
        Job jobTestFive = new Job("Product tester", new Employer(""), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals("\n" +
                "ID: " + jobTestFive.getId() +
                "\n" + "Name: Product tester" +
                "\n" + "Employer: Data not available" +
                "\n" + "Location: Desert" +
                "\n" + "Position Type: Quality control" +
                "\n" + "Core Competency: Data not available" +
                "\n"  , jobTestFive.toString());
    }

}
