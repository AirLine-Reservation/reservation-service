package edu.miu.cs.ea.controller;

import edu.miu.cs.ea.domain.Flight;
import edu.miu.cs.ea.domain.Reservation;
import edu.miu.cs.ea.domain.User;
//import edu.miu.cs.ea.repository.FlightRepository;
import edu.miu.cs.ea.service.ReservationService;
import edu.miu.cs.ea.service.UserService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agent")
public class AgentController {
    @Autowired
    ReservationService reservationService;
    @Autowired
    UserService userService;

    @GetMapping("/reservation/")
    public List<Reservation> ownReservations(Authentication authentication){
        String username=authentication.getName();
        return reservationService.ownReservations(username);
    }

//
////    @Autowired
////    FlightRepository flightRepository;
//
//    @GetMapping("/reservation/")
//    public List<Reservation> ownReservations(Authentication authentication){
//        String username=authentication.getName();
//        return reservationService.ownReservations(username);
//    }
//    @PostMapping("/reservation/{userName}")
//    public Reservation makeReservation(
//            @RequestBody List<Flight> flights,
//            @PathVariable("userName") String userName,Authentication authentication){
//        Reservation reservation=new Reservation();
//        User reserver= userService.findByUserName(authentication.getName()).get();
//        User passenger= userService.findByUserName(userName).get();
//        reservation.setPassenger(passenger);
//        String random = RandomStringUtils.random(6, false, true);
//        reservation.setReservationcode(random);
//        reservation.setReserver(reserver);
//        reservation.setFlights(flights);
//        reservation.setPaystatus("unpaid");// set unpaid status
//
//        return reservationService.save(reservation);
//    }
//
//    @GetMapping("/reservation/{id}")
//    public @ResponseBody  Reservation reservations(@PathVariable("id") Long id,Authentication authentication){
//
//        return reservationService.reservationDetails(authentication.getName(),id);
//    }
////    @GetMapping("/reservation/{id}/ticket")
////    public @ResponseBody  List<Ticket> getTicketByReservation(@PathVariable("id") Long id){
////        Reservation reservation=new Reservation();
////        reservation.setId(id);
////
////        return ticketRepository.findTicketsByReservation(reservation);
////    }
//
//    @DeleteMapping ("/reservation/{id}")
//    public void cancelReservation(@PathVariable("id") Long id,Authentication authentication){
//        reservationService.deleteReservation(authentication.getName(),id);
//    }
//
//    @PutMapping("/reservation/")
//    public Reservation confirm(@RequestBody Reservation reservation,Authentication authentication){
//        reservation=reservationService.findById(reservation.getId());
//        reservation.setPaystatus("paid");
////        List<Flight> flights=reservation.getFlights();
////        Reservation finalReservation = reservation;
////        flights.forEach(flight->{
////            Ticket t=new Ticket();
////            t.setReservation(finalReservation);
////            t.setFlight(flight);
////
////            String random = RandomStringUtils.random(20, false, true);
////            t.setTicketnbr(random);
////            ticketRepository.save(t);
////        });
//        return reservationService.save(reservation);
//    }
}
