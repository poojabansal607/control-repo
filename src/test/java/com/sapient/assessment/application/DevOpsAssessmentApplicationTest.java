package com.sapient.assessment.application;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by djai10 on 10/4/2016.
 */
public class DevOpsAssessmentApplicationTest {

    @Test
    public void testInitializeDB(){
        DevOpsAssessmentApplication testClass = new DevOpsAssessmentApplication();

        try {
            testClass.run("server", "D:\\devops-assessment\\src\\main\\resources\\devops-assessment.yml");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}