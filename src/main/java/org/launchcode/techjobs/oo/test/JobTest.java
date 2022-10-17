package org.launchcode.techjobs.oo.test;

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
        assertFalse(jobTestOne.equals( jobTestTwo));
}
    @Test
    public void testJobConstructorSetsAllFields(){
        Job jobTestThree = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(jobTestThree.getName() instanceof String);
        assertTrue(jobTestThree.getEmployer() instanceof Employer);
        assertTrue(jobTestThree.getLocation() instanceof Location);
        assertTrue(jobTestThree.getPositionType() instanceof PositionType);
        assertTrue(jobTestThree.getCoreCompetency() instanceof CoreCompetency);

        assertEquals("Product tester", jobTestThree.getName());
        assertEquals("ACME", jobTestThree.getEmployer().getValue());
        assertEquals("Desert", jobTestThree.getLocation().getValue());
        assertEquals("Quality control", jobTestThree.getPositionType().getValue());
        assertEquals("Persistence", jobTestThree.getCoreCompetency().getValue());
    }
    @Test
    public void testJobsForEquality(){
        Job jobTestThree = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job jobTestFour = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(jobTestThree.equals(jobTestFour));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job jobTestThree = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
         assertEquals("\n", jobTestThree.toString().charAt(0));
         assertEquals("\n", jobTestThree.toString().charAt(jobTestThree.toString().length() - 1));
    }
    @Test
    public void  testToStringContainsCorrectLabelsAndData(){
        Job jobTestThree = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals("\nID: " + jobTestThree.getId() + "\nName: Product tester" +
                "\nEmployer: ACME" +
                "\nLocation: Desert" +
                "\nPosition Type: Quality control" +
                "\nCore Competency: Persistence\n"  , jobTestThree.toString());
    }
    @Test
    public void testToStringHandlesEmptyField(){
        Job jobTestFive = new Job("Product tester", new Employer(""), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals("\nID: " + jobTestFive.getId() +
                "\nName: Product tester" +
                "\nEmployer: Data not available" +
                "\nLocation: Desert\nPosition Type: Quality control" +
                "\nCore Competency: Data not available" +
                "\n"  , jobTestFive.toString());
    }

}
