package com.cg.nutritions.services;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
 
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
 
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.nutritions.exceptions.ResourceNotFoundException;
import com.cg.nutritions.repository.NutritionPlanRepository;
 
@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class NutritionPlanTest {
 
    @InjectMocks
    private NutritionPlanServiceImpl nutritionplan;

    @Mock
    private NutritionPlanRepository nutritionrepository;


    public void testCreateNutritionPlan()
    {
        NutritionPlanTest n=new NutritionPlanTest();
        n.setplanId((long) 1);
        n.setplanName("anau");
        n.setdescription("nutrirtion plan");
        n.setcreatedAt(LocalDate.parse("2023-03-12"));
        n.setupdatedAt(LocalDate.parse("2023-03-18"));
        n.setprice(1200.11);
    }

     public <n> void showNutritionlan() throws ResourceNotFoundException
     {
         NutritionPlanTest n=new NutritionPlanTest();
         List<NutritionPlanTest> list=new ArrayList<>();
         list.add(n);
         when(nutritionrepository.findAll());
         List<n> exce=(List<n>) nutritionplan.showListOfNutritionPlans();
         assertEquals(1,exce.size());         

     }
 
    private void setprice(double d) {
        // TODO Auto-generated method stub

    }
 

    private void setupdatedAt(LocalDate parse) {
        // TODO Auto-generated method stub

    }
 

    private void setcreatedAt(LocalDate parse) {
        // TODO Auto-generated method stub

    }
 

    private void setdescription(String string) {        // TODO Auto-generated method stub

    }
 

    private void setplanName(String string) {
        // TODO Auto-generated method stub

    }
 

    private void setplanId(long l) {
        // TODO Auto-generated method stub

    }


}

