package gora2;

import java.util.Scanner;

class Gora { //клас гора, з об'єктів якого буде складатись масив
    String naz, mis; //Назва гори, місце
    int hig; //Висота
}

public class GoraList2 {
    public static Gora[] setGoraArr(int np) {
        Scanner ns = new Scanner(System.in, "UTF-8");
        Gora[] gor = new Gora[np];
        System.out.println("Введіть характеристики гір:");
        for (int i = 0; i < gor.length; i++) {
            gor[i] = new Gora();

            System.out.println("Назву " + (i + 1) + " гори: ");
            gor[i].naz = ns.nextLine();

            System.out.println("Локацію " + (i + 1) + " гори: ");
            gor[i].mis = ns.nextLine();

            System.out.println("Висоту " + (i + 1) + " гори: ");
            gor[i].hig = ns.nextInt();

            ns.nextLine();
        }
        return gor;
    }

    public static void showArray(Gora[] vvl) {
        for (int i = 0; i < vvl.length; i++) {
            System.out.println((i + 1) + ")" + " Назва: " + vvl[i].naz + "\t" + "Локація: " + vvl[i].mis + "\t" + "Висота: " + vvl[i].hig);
        }
    }

    public static void showGora(Gora vvl) {
        System.out.println("Назва: " + vvl.naz + "\t" + "Локація: " + vvl.mis + "\t" + "Висота: " + vvl.hig);
    }

    public static int NumMax(Gora[] gor) {
        int maxnum = 0;
        int max = gor[maxnum].hig;
        for (int i = 0; i < gor.length; i++) {
            if (gor[i].hig > max) {
                max = gor[i].hig;
                maxnum = i;
            }
        }
        return maxnum;
    }

    public static double countSize(Gora[] gor) {
        int count = gor.length; // рахунок арефметичного
        for (int i = 0; i < gor.length; i++) { //перебір масиву
            if (gor[i].hig >= 1000) { //якщо гора вища або = 1000 м
                count = i; //отримаємо висоту гори
            }
        }
        return count;
    }

    public static void sortBubbleSize(Gora[] gor) {
        for(int i = 0; i < gor.length - 1; i++) {
            for (int j = 0; j < gor.length - 1 - i; j++){
                if(gor[j].hig > gor[j + 1].hig) {
                    Gora ger = gor[j];
                    gor[j] = gor[j + 1];
                    gor[j + 1] = ger;
                }
            }
        }
    }

    public static Gora arraySearch(Gora[] gor, String name) {
        int num = -1;
        for (int i = 0; i < gor.length; i++) {
            if (name.equalsIgnoreCase(gor[i].naz)) num = i;
        }
        if (num != -1) {
            return gor[num];
        } else return null;
    }

    public static void arrayEdit(Gora[] gor, int editind, int editint) {
        Scanner zd = new Scanner(System.in, "UTF-8");

        for (int i = 0; i < gor.length; i++) {
            if (i == editind) {
                System.out.println((editind + 1) + ")" + " Назва: " + gor[editind].naz + " " + "Локація: " + gor[editind].mis + " " + "Висота: " + gor[editind].hig + "\n");
            }
        }

        switch (editint) {
            case 1 -> {
                System.out.println("На що змінюємо: ");
                gor[editind].naz = zd.nextLine();
            }
            case 2 -> {
                System.out.println("На що змінюємо: ");
                gor[editind].mis = zd.nextLine();
            }
            case 3 -> {
                System.out.println("На що змінюємо: ");
                gor[editind].hig = zd.nextInt();
            }
        }
    }

    public static void main(String[] args) {

        Scanner ns = new Scanner(System.in, "UTF-8");
        System.out.println("Введіть кількість гір => ");
        int n = ns.nextInt();
        Gora[] gora1 = setGoraArr(n);
        System.out.println("\nХарактеристика гір");
        showArray(gora1);

        ns.nextLine();

        int nummax = NumMax(gora1);
        System.out.println("Гора з найбільшою висотою");
        showGora(gora1[nummax]);

        ns.nextLine();

        System.out.println("Вершини із висотою понад 1000 м: " + countSize(gora1));

        ns.nextLine();

        sortBubbleSize(gora1);
        System.out.println("\nВідсортований масив\n");
        showArray(gora1);

        ns.nextLine();

        System.out.println("Введіть назву гори");
        String Gname = ns.nextLine();
        Gora gfind = arraySearch(gora1, Gname);
        if (gfind != null) {
            showGora(gfind);
        } else {
            System.out.println("Такої гори немає");
        }

        ns.nextLine();

        System.out.println("Редагування, який запис редагуємо?\n");
        showArray(gora1);
        int editind = ns.nextInt() - 1;
        System.out.println("Що саме редагуємо? введіть номер: \t 1) Назву \t 2) Локацію \t 3) Висота ");
        int editint = ns.nextInt();
        arrayEdit(gora1, editind, editint);
        showGora(gora1[editind]);
    }
}