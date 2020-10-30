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

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationObject  {
    private Long id;
    private String  reservationcode;
    private List<Flight> flights=new ArrayList<>();




   
}
