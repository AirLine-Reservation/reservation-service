package edu.miu.cs.ea.service;

import edu.miu.cs.ea.domain.Reservation;
import edu.miu.cs.ea.domain.User;

import java.util.List;
import java.util.Optional;

public interface ReservationService {
    Reservation save(Reservation reservation);
    List<Reservation> ownReservations(String userName);
    Reservation reservationDetails(String userName,Long id);
    void deleteReservation(String userName,Long id);
    Reservation findById(Long id);
}
