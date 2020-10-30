//package edu.miu.cs.ea.service;
//
//import edu.miu.cs.ea.domain.Passenger;
//import edu.miu.cs.ea.domain.Reservation;
//import edu.miu.cs.ea.repository.ReservationRepository;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.ContextConfiguration;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.times;
//
//@SpringBootTest
//public class ReservationServiceTest {
//    @Autowired
//    ReservationService reservationService;
//    @MockBean
//    ReservationRepository reservationRepository;
//
//    @Test
//    void findById() {
//        Long id=1L;
//        Reservation r=new Reservation();
//        Optional<Reservation> res= Optional.of(r);
//        Mockito.when(reservationRepository.findById(id)).thenReturn(res);
//        assertEquals(res.get(), reservationService.findById(id));
//    }
//    @Test
//    void findReservationsByPassenger(){
//        List<Reservation> ls=new ArrayList<>();
//        Mockito.when(reservationRepository.findReservationsByPassenger(new Passenger()))
//                .thenReturn(ls);
//        assertEquals(ls.size(), reservationService.findReservationsByPassenger(new Passenger()).size());
//    }
//    @Test
//    void save(){
//        Reservation r=new Reservation();
//        Mockito.when(reservationRepository.save(new Reservation()))
//                .thenReturn(r);
//        assertEquals(r, reservationService.save(new Reservation()));
//    }
//    @Test
//    void deleteFLight() {
//        Long id=1L;
//        reservationService.deleteById(id);
//        Mockito.verify(reservationRepository, times(1)).deleteById(id);
//    }
//
//}
