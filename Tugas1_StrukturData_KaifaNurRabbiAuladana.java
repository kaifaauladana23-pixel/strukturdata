import java.util.Arrays;
import java.util.LinkedList;

public class Tugas1_StrukturData_KaifaNurRabbiAuladana {
    public static void main(String[] args) {
//1. Buatlah sebuah deklarasi variabel dengan tipe data integer yang bernama ‘StrukturBaris’? (15 Poin)
    int StrukturBaris;

    StrukturBaris = 100;

    System.out.println("Ini adalah Interger: " + StrukturBaris);
//2. Buatlah sebuah deklarasi variabel dengan tipe data string yang bernama ‘KataBaru’ yang berisi kata ‘Deklarasi tipe data String’? (15 Poin)
    String KataBaru;

    KataBaru = "Deklarasi tipe data String";

    System.out.println("Ini adalah String: " + KataBaru);
// 3. Buatlah pendeklarasian array satu dimensi dengan nama ‘empatAngka’, tipe data integer, yang berisi angka (07, 10, 20, 23)? 
    int [] empatAngka = {07,10,20,23};
    for (int i = 0; i < empatAngka.length; i++) {
        System.out.println("Array ke-" + i + " : " + empatAngka[i]);
        
    }

// 4. Buatlah pendeklarasian array dua dimensi dengan nama ‘Angka’, tipe data String, yang terdiri dari tiga baris dan tiga kolom, 
// isi baris dan kolom berisi angka berikut (1, 3, 5, 14, 19, 20, 22, 27, 29) 
    String [][] Angka = {
        {"1","3","5"},
        {"14","19","20"},
        {"22","27","29"}
    };
    System.out.println("\n" + "Angka");
    for(String[] kaifa : Angka){
        System.out.println(Arrays.toString(kaifa));
    }

// 5. Buatlah deklarasi linked list dengan nama 'listAngka' yang memiliki list (22, 19, 44, 60, 72), 
    LinkedList <Integer> listAngka = new LinkedList<Integer>();
    listAngka.add(22);
    listAngka.add(19);
    listAngka.add(44);
    listAngka.add(60);
    listAngka.add(72);
    System.out.println("listangka: " + listAngka);
    }
}
