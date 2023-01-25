package tests;

import models.Milestone;
import org.testng.Assert;
import org.testng.annotations.Test;


public class MilestoneTest {
    @Test
    public void lombokTest1(){
        Milestone milestone1 = new Milestone();
        milestone1.setName("ML_01");
        milestone1.setId(1);
        milestone1.setCompleted(true);
        Milestone milestone2 = new Milestone();
        milestone2.setName("ML_01");
        milestone2.setId(1);
        milestone2.setCompleted(true);
        System.out.println(milestone1.toString());
        System.out.println(milestone2.toString());
        Assert.assertTrue(milestone2.equals(milestone1));
    }
    @Test
    public void lombokTest2(){
        Milestone milestone1 = Milestone.builder()
                .name("ML_02")
                .id(3)
                .completed(true)
                .build();
        System.out.println(milestone1.toString());
        Milestone milestone2 = Milestone.builder()
                .name("ML_02")
                .id(3)
                .completed(true)
                .build();
        System.out.println(milestone2.toString());
        Assert.assertTrue(milestone2.equals(milestone1));
    }
}
