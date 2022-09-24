package org.launchcode.techjobs.oo.test;

import org.junit.Before;
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

//    @Before
//    public void createTestJob() {
//        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
//    }

    //ER: TEST THE EMPTY CONSTRUCTOR: Create two jobs. 'job1' 'id' should not equal '2'. Tested to fail first.
    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();

        assertNotEquals(2, job1.getId());
    }

    //ER: TEST THAT A NEW JOB INSTANCE HAS THE CORRECT TYPES OF PARAMETERS AND VALIDATE THE PARAMETERS
    @Test
    public void testJobConstructorSetsAllFields() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(testJob instanceof Job);
        assertTrue(testJob.getEmployer() instanceof Employer);
        assertTrue(testJob.getLocation() instanceof Location);
        assertTrue(testJob.getPositionType() instanceof PositionType);
        assertTrue(testJob.getCoreCompetency() instanceof CoreCompetency);

        assertEquals("Product tester", testJob.getName());
        assertEquals("ACME", testJob.getEmployer().toString());
        assertEquals("Desert", testJob.getLocation().toString());
        assertEquals("Quality control", testJob.getPositionType().toString());
        assertEquals("Persistence", testJob.getCoreCompetency().toString());
    }

    //ER: TEST THAT THE 'equals()' METHOD RETURNS 'false' WHEN TWO JOB 'id's  DON'T MATCH
    @Test
    public void testJobsForEquality() {
        Job testJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job testJob2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(testJob1.equals(testJob2));
    }

    //ER: TEST THAT 'toString' METHOD IN 'Job' CLASS RETURNS NEW LINE FOR FIRST AND LAST CHARS
    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String jobString = testJob.toString();
        char firstChar = jobString.charAt(0);
        char lastChar = jobString.charAt(jobString.length() - 1);


        assertEquals('\n', firstChar);
        assertEquals('\n', lastChar);
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String jobString = testJob.toString();


        //id line
        String idLabel = jobString.substring(1, 5);
        String id = jobString.substring(5, 6);
        String idBlankLine = jobString.substring(6,7);

        assertEquals("ID: ", idLabel);
        assertEquals("1", id);
        assertEquals("\n", idBlankLine);

        //name line
        String nameLabel = jobString.substring(7,13);
        String name = jobString.substring(13, 27);
        String nameBlankLine = jobString.substring(27,28);

        assertEquals("Name: ", nameLabel);
        assertEquals("Product tester", name);
        assertEquals("\n", nameBlankLine);

        //employer line
        String employerLabel = jobString.substring(28,38);
        String employer = jobString.substring(38, 42);
        String employerBlankLine = jobString.substring(42,43);

        assertEquals("Employer: ", employerLabel);
        assertEquals("ACME", employer);
        assertEquals("\n", employerBlankLine);

        //location line
        String locationLabel = jobString.substring(43,53);
        String location = jobString.substring(53, 59);
        String locationBlankLine = jobString.substring(59,60);

        assertEquals("Location: ", locationLabel);
        assertEquals("Desert", location);
        assertEquals("\n", locationBlankLine);

        //positionType line
        String positionTypeLabel = jobString.substring(60,75);
        String positionType = jobString.substring(75,90);
        String positionTypeBlankLine = jobString.substring(90,91);

        assertEquals("Position Type: ", positionTypeLabel);
        assertEquals("Quality control", positionType);
        assertEquals("\n", positionTypeBlankLine);

        //coreCompetency line
        String coreCompetencyLabel = jobString.substring(91,108);
        String coreCompetency = jobString.substring(108,119);
        String coreCompetencyBlankLine = jobString.substring(119,120);

        assertEquals("Core Competency: ", coreCompetencyLabel);
        assertEquals("Persistence", coreCompetency);
        assertEquals("\n", coreCompetencyBlankLine);

    }

    @Test
    public void testToStringHandlesEmptyField() {
//        Job testJobWithBlankEmployer = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
//        String jobString = testJobWithBlankEmployer.toString();
//
//        String nameValue = jobString.substring(13, 31);
//        String employerValue = jobString.substring(42, 60);
//        String locationValue = jobString.substring(71, 89);
//        String positionTypeValue = jobString.substring(105, 123);
//        String coreCompetencyValue = jobString.substring(141, 159);
//
//        assertEquals("Data not available", nameValue);
//        assertEquals("Data not available", employerValue);
//        assertEquals("Data not available", locationValue);
//        assertEquals("Data not available", positionTypeValue);
//        assertEquals("Data not available", coreCompetencyValue);

        Job testJob = new Job("Product tester", new Employer(""), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String jobString = testJob.toString();

        String employerValue = jobString.substring(38, 56);
        assertEquals("Data not available", employerValue);

    }

}
