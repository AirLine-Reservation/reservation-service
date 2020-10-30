package edu.miu.cs.ea.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@Setter
@Getter
@AllArgsConstructor
public class Reservation  implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String  reservationcode;
//    @ManyToMany
    @ElementCollection
    @Column(length = 20000)
    private List<Flight> flights=new ArrayList<>();
    @OneToOne
    //@JsonIgnore
    private User passenger;
    @OneToOne
    //@JsonIgnore
    private User reserver;
    private String paystatus;


    public Reservation() {
    }
}
