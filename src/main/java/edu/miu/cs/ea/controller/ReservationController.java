package edu.miu.cs.ea.controller;

import edu.miu.cs.ea.domain.Flight;
import edu.miu.cs.ea.domain.Reservation;
import edu.miu.cs.ea.domain.User;
//import edu.miu.cs.ea.repository.FlightRepository;
import edu.miu.cs.ea.service.FlightService;
import edu.miu.cs.ea.service.ReservationService;
import edu.miu.cs.ea.service.UserService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
    @Autowired
    ReservationService reservationService;
    @Autowired
    UserService userService;

    @Autowired
    FlightService flightService;




    @GetMapping("/")
    public List<Reservation> ownReservations(Authentication authentication){
        String username=authentication.getName();
        System.out.println("hello");
        return reservationService.ownReservations(username);
    }
     @PostMapping("/")//passenger
    public Reservation makeReservation(@RequestBody List<Integer> ids,Authentication authentication){
       List<Flight> flights=flightService.getAllFlights(ids);
         System.out.println("##### "+flights.size());
         flights.forEach(flight->{
             System.out.println(flight.getId());
         });
        Reservation reservation=new Reservation();
        User passenger= userService.findByUserName(authentication.getName()).get();//fetch passenger from database using username
        reservation.setPassenger(passenger);//set passenger on reservation
         String random = RandomStringUtils.random(6, false, true);
         reservation.setReservationcode(random);
         reservation.setReserver(passenger);
         reservation.setFlights(flights);
        reservation.setPaystatus("unpaid");// set unpaid status

        return reservationService.save(reservation);
    }
    @PostMapping("/{userName}")//agent
    public Reservation makeReservation(
            @RequestBody List<Flight> flights,
            @PathVariable("userName") String userName,Authentication authentication){
        Reservation reservation=new Reservation();
        User reserver= userService.findByUserName(authentication.getName()).get();
        User passenger= userService.findByUserName(userName).get();
        reservation.setPassenger(passenger);
        String random = RandomStringUtils.random(6, false, true);
        reservation.setReservationcode(random);
        reservation.setReserver(reserver);
        reservation.setFlights(flights);
        reservation.setPaystatus("unpaid");// set unpaid status

        return reservationService.save(reservation);
    }


    @GetMapping("/{id}")
    public @ResponseBody  Reservation reservations(@PathVariable("id") Long id,Authentication authentication){

        return reservationService.reservationDetails(authentication.getName(),id);
    }
    @DeleteMapping ("/{id}")
    public void cancelReservation(@PathVariable("id") Long id,Authentication authentication){
        reservationService.deleteReservation(authentication.getName(),id);
    }

    @PutMapping("/")
    public Reservation confirm(@RequestBody Reservation reservation,Authentication authentication){
        reservation=reservationService.findById(reservation.getId());
        reservation.setPaystatus("paid");
        return reservationService.save(reservation);
    }
}
