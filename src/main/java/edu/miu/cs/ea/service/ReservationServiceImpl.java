package edu.miu.cs.ea.service;

import edu.miu.cs.ea.domain.Reservation;
import edu.miu.cs.ea.domain.User;
import edu.miu.cs.ea.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements  ReservationService{
    @Autowired
    ReservationRepository reservationRepository;
    @Override
    public Reservation save(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public  List<Reservation> ownReservations(String userName) {
        return reservationRepository.ownReservations(userName);
    }

    @Override
    public Reservation reservationDetails(String userName, Long id) {
        return reservationRepository.reservationDetails(userName,id);
    }

    @Override
    public void deleteReservation(String userName, Long id) {
        Reservation r=reservationRepository.findById(id).get();
        if(r.getReserver().getUserName().equalsIgnoreCase(userName))
         reservationRepository.deleteById(id);
    }

    @Override
    public Reservation findById(Long id) {
        Optional<Reservation> reservation = reservationRepository.findById(id);
        System.out.println(reservation.get().getId()+"#######");
        return reservation.get();
    }


}
