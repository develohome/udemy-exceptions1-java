package tratamentodeexcecoes;

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

}
