/*Warsztat: Gra w zgadywanie liczb.

Napisz prostą grę w zgadywanie liczb. Komputer musi wylosować liczbę w zakresie od 1 do 100. Następnie:

    Zadać pytanie: "Zgadnij liczbę" i pobrać liczbę z klawiatury.
    Sprawdzić, czy wprowadzony napis, to rzeczywiście liczba i w razie błędu wyświetlić komunikat "To nie jest liczba", po czym wrócić do pkt. 1
    Jeśli liczba podana przez użytkownika jest mniejsza niż wylosowana, wyświetlić komunikat "Za mało!", po czym wrócić do pkt. 1.
    Jeśli liczba podana przez użytkownika jest większa niż wylosowana, wyświetlić komunikat "Za dużo!", po czym wrócić do pkt. 1.
    Jeśli liczba podana przez użytkownika jest równa wylosowanej, wyświetlić komunikat "Zgadłeś!", po czym zakończyć działanie programu.

Przykład:

Zgadnij liczbę: cześć
To nie jest liczba.
Zgadnij liczbę: 50
Za mało!
Zgadnij liczbę: 75
Za dużo!
Zgadnij liczbę: 63
Zgadłeś!*/


package Zadanie_01;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) {
			
		Random random= new Random();
		int number = random.nextInt(101);
		int answer = -1;
		
		Scanner scanner=new Scanner(System.in);
		
		
		while (number != answer) {
			System.out.println("Zgadnij liczbę");
			try {
				answer = scanner.nextInt();
				if (answer > number) {
					System.out.println("Za dużo");
				} else if ( answer< number){
					System.out.println("Za mało");
				} 
			} catch (InputMismatchException e) {
				System.out.println("To nie jest liczba");
				//scanner.nextLine();
			}

		}
		System.out.println("Zgadłeś");
		scanner.close();

	}

		
		
}
