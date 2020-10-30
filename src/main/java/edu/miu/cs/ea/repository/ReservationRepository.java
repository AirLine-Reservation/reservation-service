package edu.miu.cs.ea.repository;

import edu.miu.cs.ea.domain.Reservation;
import edu.miu.cs.ea.domain.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation,Long> {
    @Query("select r from Reservation r where r.reserver.userName= :userName")
    List<Reservation> ownReservations(String userName);

    @Query("select r from Reservation r " +
            "where r.reserver.userName= :userName  and r.id= :id")
    Reservation reservationDetails(String userName,Long id);

    @Transactional
    @Modifying
    @Query("delete from Reservation r " +
            "where r.reserver.userName= :userName  and r.id= :id")
    void deleteReservation(String userName,Long id);
}
