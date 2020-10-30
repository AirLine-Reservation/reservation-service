package edu.miu.cs.ea.domain;
//
//import com.fasterxml.jackson.annotation.JsonBackReference;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import lombok.*;
//import org.hibernate.annotations.BatchSize;
//import org.hibernate.annotations.Fetch;
//import org.hibernate.annotations.FetchMode;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.util.Date;
//
////
////@Entity
//@Data
//@Setter
//@Getter
//@AllArgsConstructor
//@NoArgsConstructor
//
//public class Flight implements Serializable {
//
//
//	private Integer id;
//
//
//	private AirLine airLine;
//
//	private AirPort origin;
//
//	private AirPort destination;
//
//	private String flightNumber;
//	private Integer capacity;
//	private Double price;
//	private Date arrivalDate;
//	private Date arrivalTime;
//	private Date departureDate;
//	private Date departureTime;
//
////	public Flight(Integer id, AirLine airLine, AirPort origin, AirPort destination,
////				  String flightNumber, Integer capacity, Double price,
////				  Date arrivalDate, Date arrivalTime, Date departureDate, Date departureTime) {
////		this.id = id;
////		this.airLine = airLine;
////		this.origin = origin;
////		this.destination = destination;
////		this.flightNumber = flightNumber;
////		this.capacity = capacity;
////		this.price = price;
////		this.arrivalDate = arrivalDate;
////		this.arrivalTime = arrivalTime;
////		this.departureDate = departureDate;
////		this.departureTime = departureTime;
////	}
//
//
//	@Override
//	public String toString() {
//		return "Flight{" +
//				"id=" + id +
//				'}';
//	}
//}


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

//
//@Entity
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Flight implements Serializable {


	private Integer id;



	private String flightNumber;

	private String arrivalDate;
	private String arrivalTime;
	private String departureDate;
	private String departureTime;

}

