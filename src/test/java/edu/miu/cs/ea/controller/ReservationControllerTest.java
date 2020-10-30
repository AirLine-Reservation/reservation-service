//package edu.miu.cs.ea.controller;
//
//import edu.miu.cs.ea.domain.Passenger;
//import edu.miu.cs.ea.domain.Reservation;
//import edu.miu.cs.ea.service.ReservationService;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.RequestBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@ExtendWith(SpringExtension.class)
//@WebMvcTest(ReservationController.class)
//public class ReservationControllerTest {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    ReservationController reservationController;
//
//    @MockBean
//    ReservationService reservationService;
//
//
//    @Test
//    void findReservationBuId() throws Exception {
//        RequestBuilder request= MockMvcRequestBuilders.get("/reservation/1");
//        Reservation res=new Reservation();
//        res.setId(1L);
//        Mockito.when(reservationService.findById(1L))
//                .thenReturn(res);
//        MvcResult result= mockMvc.perform(request).andReturn();
//        assertEquals(res+"",""+result.getResponse().getContentAsString());
//    }
//    @Test
//    void findReservationsByPassenger() throws Exception {
//        List<Reservation> ls=new ArrayList<>();
//        Mockito.when(reservationService.findReservationsByPassenger(new Passenger()))
//                .thenReturn(ls);
//        assertEquals(ls.size(), reservationController.ownReservations(1L).size());
//    }
//    @Test
//    void save() throws Exception {
//        RequestBuilder request= MockMvcRequestBuilders.post("/reservation/");
//
//        Reservation res=new Reservation();
//        res.setId(1L);
//        Mockito.when(reservationService.save(res))
//                .thenReturn(res);
//        MvcResult result= mockMvc.perform(request).andReturn();
//        assertEquals(res+"",""+result.getResponse().getContentAsString());
//    }
//}
