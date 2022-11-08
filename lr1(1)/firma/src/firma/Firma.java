package firma;
import java.util.Scanner;
class Sotrudnik{
    String fam, im, otch, doljnost;
    int oklad;
}


public class Firma {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "cp1251");
        System.out.println("Введіть кількість співробітників =>");
        int kol = sc.nextInt();
        sc.nextLine();

        Sotrudnik[] sort = new Sotrudnik[kol];

        System.out.println("Введіть інформацію про кожного співробітника:");

        for (int i = 0; i < sort.length; i++) {
            sort[i] = new Sotrudnik();
            System.out.print("Введіть прізвище " + (i + 1) + " співробітника => ");
            sort[i].fam = sc.nextLine();
            System.out.print("Введіть його ім'я => ");
            sort[i].im = sc.nextLine();
            System.out.print("Введіть його по батькові => ");
            sort[i].otch = sc.nextLine();

            System.out.print("Введіть його посаду => ");
            sort[i].doljnost = sc.nextLine();

            System.out.print("Введіть його оклад => ");
            sort[i].oklad = sc.nextInt();
            sc.nextLine();
            System.out.println("\nСпівробітники фірми:\n фам\tім'я\tотч\t посада \tОклад");
            for (Sotrudnik s : sort) {
                System.out.print(s.fam + "\t" + s.im + "\t" + s.otch
                        + "\t" + s.doljnost + "\t\t" + s.oklad + "\n");
            }

        }
    }
}
