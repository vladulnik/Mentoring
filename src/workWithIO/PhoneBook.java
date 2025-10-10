package workWithIO;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class PhoneBook {
    private static final String SEP = ";";

    public static void addContact(String fileName, String name, String phone, String email) {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName, true), StandardCharsets.UTF_8))) {
            if (name == null || phone == null || email == null || name.contains(SEP) || phone.contains(SEP) || email.contains(SEP)) {
                System.err.println("Invalid input");
                return;
            }

            writer.write(name + SEP + phone + SEP + email);
            writer.newLine();

        } catch (IOException e) {
            System.err.println("Error while writing the file: " + e.getMessage());
        }
    }

    public static void listContacts(String fileName) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8))) {
            String line;
            boolean any = false;

            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                System.out.println(line);
                any = true;
            }

            if (!any) {
                System.out.println("No info");
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.err.println("Error while reading the file: " + e.getMessage());
        }
    }

    public static void findByName(String fileName, String keyword) {
        if (keyword == null) {
            System.out.println("Incorrect request");
            return;
        }

        String key = keyword.toLowerCase();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8))) {
            String line;
            boolean found = false;

            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] parts = line.split(SEP, 3);

                if (parts.length > 3) continue;
                String name = parts[0].trim();

                if (name.toLowerCase().equals(key)) {
                    System.out.println(line);
                    found = true;
                }

                if (!found)
                    System.out.println("No info");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.err.println("Error while reading the file: " + e.getMessage());
        }
    }

    public static void updateEmailByPhone(String fileName, String phone, String newEmail) {
        String tmpName = fileName + ".tmp";
        int updated = 0;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(tmpName), StandardCharsets.UTF_8))) {
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    writer.newLine();
                    continue;
                }

                String[] parts = line.split(SEP, 3);

                if (parts.length == 3) {
                    String name = parts[0].trim();
                    String ph = parts[1].trim();
                    String mail = parts[2].trim();

                    if (ph.equals(phone)) {
                        mail = newEmail;
                        updated++;
                    }

                    writer.write(name + SEP + ph + SEP + mail);
                    writer.newLine();
                } else {
                    writer.write(line);
                    writer.newLine();
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return;
        } catch (IOException e) {
            System.err.println("Error while updating: " + e.getMessage());
            return;
        }

        File orig = new File(fileName);
        File tmp = new File(tmpName);
        if (!orig.delete()) {
            System.err.println("Cant delete source file while updating");
        }
        if (!tmp.renameTo(orig)) {
            System.err.println("Cant update tmp file");
        }
        System.out.println("Updated: " + updated);
    }

    public static void deleteByPhone(String fileName, String phone) {
        String tmpName = fileName + ".tmp";
        int deleted = 0;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(tmpName), StandardCharsets.UTF_8))) {
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    writer.newLine();
                    continue;
                }

                String[] parts = line.split(SEP, 3);

                if (parts.length == 3) {
                    String ph = parts[1].trim();

                    if (ph.equals(phone))
                        deleted++;
                    else {
                        writer.write(line);
                        writer.newLine();
                    }
                } else {
                    writer.write(line);
                    writer.newLine();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return;
        } catch (IOException e) {
            System.err.println("Error while deleting: " + e.getMessage());
            return;
        }

        File orig = new File(fileName);
        File tmp = new File(tmpName);

        if (!orig.delete()) {
            System.err.println("Cant delete origin file while");
        }
        if (!tmp.renameTo(orig)) {
            System.err.println("Cant rename tmp file");
        }
        System.out.println("Deleted: " + deleted);
    }
}
