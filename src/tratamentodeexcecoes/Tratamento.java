package tratamentodeexcecoes;

import tratamentodeexcecoes.model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Tratamento {


    public static void tratamento() {
        Scanner input = new Scanner(System.in);
        try {
            String[] vect = input.nextLine().split(" ");
            int position = input.nextInt();
            System.out.println(vect[position]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage() + " - Invalid position");
            e.printStackTrace();
            input.nextLine();
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage() + " - Input invalido ");
        } finally {
            input.close();
        }
        System.out.println("Fanalizado !");
    }

    public static void tratamentoMuitoRuim() throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Room number: ");
        int number = sc.nextInt();
        System.out.println("Check-in date: (dd/MM/yyyy):)");
        Date checkIn = sdf.parse(sc.next());
        System.out.println("Check-out date: (dd/MM/yyyy):)");
        Date checkOut = sdf.parse(sc.next());

        if (!checkOut.after(checkIn)) {
            System.out.println("Error in reservation: Check-out date must be after check-in date");
        } else {
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println();

            System.out.println("Enter data to update the reservation");
            System.out.println("Check-in date: (dd/MM/yyyy):)");
            checkIn = sdf.parse(sc.next());
            System.out.println("Check-out date: (dd/MM/yyyy):)");
            checkOut = sdf.parse(sc.next());

            reservation.updadeDates(checkIn, checkOut);
            System.out.println("Reservation: " + reservation);
        }
        sc.close();
    }

}
