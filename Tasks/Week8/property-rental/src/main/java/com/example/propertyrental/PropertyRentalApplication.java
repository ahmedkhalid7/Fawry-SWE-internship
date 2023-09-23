package com.example.propertyrental;

import com.example.propertyrental.PropertyModels.Apartment;
import com.example.propertyrental.PropertyModels.House;
import com.example.propertyrental.PropertyModels.Property;
import com.example.propertyrental.ReservationManager.ReservationService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.example.propertyrental.PaymentServices.PaymentContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class PropertyRentalApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(PropertyRentalApplication.class, args);
		PaymentContext paymentContext = context.getBean(PaymentContext.class);

		ReservationService reservationService = new ReservationService(paymentContext);

		// add properties to the reservation service
		Property property1 = new Apartment(500, "123 Main St");
		Property property2 = new House(100, "456 Elm St");
		reservationService.addProperty(property1);
		reservationService.addProperty(property2);

		// Reserve a property
		reservationService.reserveProperty("123 Main St");

		// Cancel a reservation
		reservationService.cancelReservation("123 Main St");
	}
}