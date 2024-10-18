import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BrowserHistory {
    private ArrayList<String> history;

    public BrowserHistory() {
        history = new ArrayList<>();
    }

    public void view() {
        if (history.isEmpty()) {
            System.out.println("History kosong.");
        } else {
            System.out.println("History Browser:");
            Collections.reverse(history);
            for (int i = 0; i < history.size(); i++) {
                System.out.println((i + 1) + ". " + history.get(i));
            }
            Collections.reverse(history); // Kembalikan urutan ke aslinya
        }
    }

    public void browse(String website) {
        history.add(website);
        System.out.println("Website '" + website + "' ditambahkan ke history.");
    }

    public void back() {
        if (history.isEmpty()) {
            System.out.println("Tidak ada history untuk dihapus.");
        } else {
            String removedSite = history.remove(history.size() - 1);
            System.out.println("Website '" + removedSite + "' dihapus dari history.");
        }
    }

    public static void main(String[] args) {
        BrowserHistory browser = new BrowserHistory();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. View History");
            System.out.println("2. Browse Website");
            System.out.println("3. Back");
            System.out.println("4. Exit");

            System.out.print("Pilih opsi (1-4): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Membersihkan newline

            switch (choice) {
                case 1:
                    browser.view();
                    break;
                case 2:
                    System.out.print("Masukkan URL website: ");
                    String website = scanner.nextLine();
                    browser.browse(website);
                    break;
                case 3:
                    browser.back();
                    break;
                case 4:
                    System.out.println("Keluar dari program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opsi tidak valid. Silakan coba lagi.");
            }
        }
    }
}
