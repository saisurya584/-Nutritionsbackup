package com.cg.nutritions.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.nutritions.entity.Gender;
import com.cg.nutritions.entity.Payment;
import com.cg.nutritions.entity.Role;
import com.cg.nutritions.entity.UserTable;
import com.cg.nutritions.exceptions.ResourceNotFoundException;
import com.cg.nutritions.repository.PaymentRepository; 
//@SpringBootTest

@ExtendWith(MockitoExtension.class)
public class PaymentTest {
	private static final Class<NullPointerException> expeted = null;
    @InjectMocks
//@Autowired
   private PaymentServiceImpl paymentService;

    @Mock
//@Autowired
   private PaymentRepository paymentRepository; 

    @Test
       public void testCreatePayment() throws Exception {
           Payment p = new Payment();
           p.setPymentId((long) 1);
           p.setPlanId((long) 6);
           p.setDiscount(20);
           p.setCreatedAt(LocalDate.parse("2023-03-11"));
           p.setUpdatedAt(LocalDate.parse("2023-01-04"));

           
           UserTable u = new UserTable();
           u.setUserId(23L);
           u.setUserName("Akash");
           u.setAllergicTool("xyz");
           u.setContactNo("9900123100");
           u.setDob(LocalDate.of(1999, 11, 21));
           u.setEmail("xyz12@gmail.com");
           u.setGender(Gender.MALE);
           u.setHeight(5.8);
           u.setMedicalCondition("Normal");
           u.setName("AkashKumar");
           u.setPassword("Abc1234567");
           u.setRole(Role.ADMIN);
           u.setSleepTime(LocalTime.parse("15:53:16"));
           u.setWakeupTime(LocalTime.parse("06:53:16"));
           u.setWeight(73.5);
           u.setWorkoutTime(2);

           Mockito.when(paymentRepository.save(p)).thenReturn(p);
           paymentService.addPayment(p);
           assertNotNull(p.getCreatedAt());
           assertNotNull(p.getUpdatedAt());
         //  assertEquals(1, p.getPymentId());
           assertEquals(20.0, p.getDiscount(), 0);

       }
   @Test
   public void updatePaymentTest() {
     // arrange
     Payment payment = new Payment();
     payment.setPymentId(1L);
     payment.setPlanId(2L);
     payment.setDiscount(0.1);
     payment.setUser_id(null);

     when(paymentRepository.findById(1L)).thenReturn(Optional.of(payment));

     // act
     try {
       Payment updatedPayment = paymentService.updatePayment(payment, 1L);

     } catch (ResourceNotFoundException ex) {
       // assert
       assertNotNull(ex.getMessage());
     }
   }

   @Test
   public void showPayment()
   {
        Payment payment = new Payment();
       List<Payment> list=new ArrayList<>();
       list.add(payment);
        when(paymentRepository.findAll()).thenReturn(list);
       List<Payment> expected= paymentService.showPayments();
       assertEquals(1, expected.size());

   }

   @Test
   public void DiscountTest() {
     // arrange
     Payment payment = new Payment();
     payment.setPymentId(1L);
     payment.setPlanId(2L);
     payment.setDiscount(0.1);
     payment.setUser_id(null);

     when(paymentRepository.findById(1L)).thenReturn(Optional.of(payment));

     // act
     try {
       Payment dis = paymentService.addOffer((double) 1L,payment);

     } catch (ResourceNotFoundException ex) {
       // assert
       assertNotNull(ex.getMessage());
     }
   }


   @Test
   public void showPayments() {
     // arrange
     Payment payment = new Payment();
     payment.setPymentId(1L);
     payment.setPlanId(2L);
     payment.setDiscount(0.1);
     payment.setUser_id(null);

     when(paymentRepository.findById(1L)).thenReturn(Optional.of(payment));

     // act
     try {
       Payment f = paymentService.findPaymentById((long)1L);

     } catch (ResourceNotFoundException ex) {
       // assert
       assertNotNull(ex.getMessage());
     }
   }



}
