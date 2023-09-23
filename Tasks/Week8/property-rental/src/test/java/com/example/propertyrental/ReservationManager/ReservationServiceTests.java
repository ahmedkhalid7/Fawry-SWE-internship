package com.example.propertyrental.ReservationManager;

import com.example.propertyrental.PaymentServices.PaymentContext;

import com.example.propertyrental.PropertyModels.Property;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ReservationServiceTests {

    @Mock
    private PaymentContext paymentContext;

    @InjectMocks
    private ReservationService reservationService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        reservationService = new ReservationService(paymentContext);
    }

    @Test
    public void testFindProperty() {
        Property propertyMock = mock(Property.class);
        when(propertyMock.getAddress()).thenReturn("123 Main St");
        reservationService.addProperty(propertyMock);

        Property foundProperty = reservationService.findProperty("123 Main St");

        assertThat(foundProperty).isEqualTo(propertyMock);
    }

    @Test
    public void testAddProperty() {
        Property propertyMock = mock(Property.class);

        reservationService.addProperty(propertyMock);

        assertThat(reservationService.getProperties()).contains(propertyMock);
    }

//    @Test
//    public void testReserveProperty() {
//        Property propertyMock = mock(Property.class);
//        when(propertyMock.getAddress()).thenReturn("123 Main St");
//        when(propertyMock.isBooked()).thenReturn(false);
//        when(propertyMock.getPrice()).thenReturn(100.0);
//
//        reservationService.addProperty(propertyMock);
//        reservationService.reserveProperty("123 Main St");
//
//        assertThat(propertyMock.isBooked()).isTrue();
//        verify(paymentContext).pay(propertyMock);
//    }

    @Test
    public void testReserveProperty_PropertyNotFound() {
        assertThatThrownBy(() -> reservationService.reserveProperty("456 Elm St"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Property not found");
        verifyNoInteractions(paymentContext);
    }

    @Test
    public void testReserveProperty_PropertyAlreadyBooked() {
        Property propertyMock = mock(Property.class);
        when(propertyMock.getAddress()).thenReturn("123 Main St");
        when(propertyMock.isBooked()).thenReturn(true);

        reservationService.addProperty(propertyMock);

        assertThatThrownBy(() -> reservationService.reserveProperty("123 Main St"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Property is already booked");
        verifyNoInteractions(paymentContext);
    }


//    @Test
//    public void testCancelReservation() {
//        Property propertyMock = mock(Property.class);
//        when(propertyMock.getAddress()).thenReturn("123 Main St");
//        when(propertyMock.isBooked()).thenReturn(true);
//
//        reservationService.addProperty(propertyMock);
//        reservationService.cancelReservation("123 Main St");
//
//        assertThat(propertyMock.isBooked()).isFalse();
//        verify(paymentContext).refund(propertyMock);
//    }

    @Test
    public void testCancelReservation_PropertyNotFound() {
        assertThatThrownBy(() -> reservationService.cancelReservation("456 Elm St"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Property not found");
        verifyNoInteractions(paymentContext);
    }
}