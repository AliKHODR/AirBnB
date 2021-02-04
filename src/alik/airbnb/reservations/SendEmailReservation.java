package alik.airbnb.reservations;

public class SendEmailReservation {

    public static void sendEmail(Reservation reservation){
        reservation.setValidated(false);
    }
}
