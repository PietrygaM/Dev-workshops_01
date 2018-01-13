/*#### Warsztat: Kostka do gry

W grach planszowych i papierowych RPG używa się wielu rodzajów kostek do gry, nie tylko tych dobrze znanych, sześciennych. Jedną z popularniejszych kości jest np. kostka dziesięciościenna, a nawet stuścienna! Jako że w grach kośćmi rzuca się często, pisanie za każdym razem np. _"rzuć dwiema kostkami dziesięciościennymi, a do wyniku dodaj 20"_ byłoby nudne, trudne i marnowałoby ogromne ilości papieru. W takich sytuacjach używa się kodu _"rzuć 2D10+20"_.

Kod takiej kostki wygląda następująco:

### xDy+z

gdzie:
* __y__ &ndash; rodzaj kostek, których należy użyć (np. D6, D10),
* __x__ &ndash; liczba rzutów kośćmi; jeśli rzucamy raz, ten parametr jest pomijalny,
* __z__ &ndash; liczba, którą należy dodać (lub odjąć) do wyniku rzutów (opcjonalnie).

__Przykłady:__

* __2D10+10__: 2 rzuty D10, do wyniku dodaj 10,
* __D6__: zwykły rzut kostką sześcienną,
* __2D3__: rzut dwiema kostkami trójściennymi,
* __D12-1__: rzut kością D12, od wyniku odejmij 1.

Napisz funkcję, która:

* przyjmie w parametrze taki kod w postaci String,
* rozpozna wszystkie dane wejściowe:
    * rodzaj kostki,
    * liczbę rzutów,
    * modyfikator,
* wykona symulację rzutów i zwróci wynik.

Typy kostek występujące w grach: D3, D4, D6, D8, D10, D12, D20, D100.*/

package Zadanie_04;

import java.util.Random;
import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) {

		String text = scanText("Podaj parametry losowania");
		int[] tmpArray = dataChecker(text);
		System.out.println("Wynik twojego losowania kostką "+text+" to "+ cubeCounter(tmpArray));
		
	}

	// Metoda jako parametr przyjmuje String recomendation który jest
	// wyświetlany na ekranie
	// następnie pozwala na wpisanie lini tekstu która zostanie zwrócona w
	// formie String
	public static String scanText(String recomendation) {
		System.out.println(recomendation);
		Scanner scan = new Scanner(System.in);
		String text = scan.nextLine();
		return text;
	}

	// Metoda jako parametr przyjmuje String text, sprawdza czy dane do
	// losowania zostały przyjęte poprawnie i zwraca tablicę 3-elementową
	// w której poszczególne pozycje to [0]- ilośc rzutów, [1] - rodzaj kostki,
	// [2] - opcjonalna wartość dodawana/odejmowana
	public static int[] dataChecker(String text) {

		char[] charText = text.toCharArray();
		int dIndex = -1;
		int plusIndex = -1;

		for (int i = 0; i < charText.length; i++) {
			if (charText[i] == 'D') {
				dIndex = i;
			}
			if (charText[i] == '+' || charText[i] == '-') {
				plusIndex = i;
			}
		}
		
		int[] array = new int[3];

		if (dIndex == 0 && plusIndex == -1) {
			array[0] = 1;
			array[1] = Integer.parseInt(text.substring(1, charText.length));
			array[2] = 0;
		} else if (dIndex != 0 && plusIndex == -1) {
			array[0] = Integer.parseInt(text.substring(0, dIndex));
			array[1] = Integer.parseInt(text.substring(dIndex + 1, charText.length));
			array[2] = 0;

		} else if (dIndex == 0 && plusIndex != -1) {
			array[0] = 1;
			array[1] = Integer.parseInt(text.substring(1, plusIndex));
			array[2] = Integer.parseInt(text.substring(plusIndex + 1, charText.length));
		} else {
			array[0] = Integer.parseInt(text.substring(0, dIndex));
			array[1] = Integer.parseInt(text.substring(dIndex + 1, plusIndex));
			array[2] = Integer.parseInt(text.substring(plusIndex + 1, charText.length));
		}	
		return array;
	}

	// Metoda losująca kostką. Jako parametr przyjmuje dowolną liczbę naturalną
	// i zwraca losową wartość z przedziału (1-number)
	public static int cubeThrower(int number) {
		Random r = new Random();
		int randomNumber = r.nextInt(number) + 1;
		return randomNumber;
	}

	// Metoda obliczająca, która jako parametr przyjmuje tablicę 3-elementową,
	// oblicza wynik i zwraca go.
	public static int cubeCounter(int[] number) {
		int score = number[0]*cubeThrower(number[1])+number[2];
		return score;
	}

}
