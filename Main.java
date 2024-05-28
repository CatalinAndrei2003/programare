public class Main {
    public static void main(String[] args) {
        String file_in = "input_tema.txt";
        String file_out = "output_tema.txt";
        PhoneBook phoneBook = new PhoneBook();
        try {
            phoneBook.readAndSave(file_in, file_out);
        }catch (PhoneAppException ex) {
            ex.printStackTrace();
        }
        phoneBook.print(System.out);
        System.out.println("DONE.");
    }
}
