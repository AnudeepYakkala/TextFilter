import java.util.Scanner;

/**
 * This project has three functions.
 * The first one takes in a passage and a keyword and censors out the key word
 * from the passage (replacing the keyword with X's).
 * The second one takes in a passage and takes in two words. It replaces all the
 * instance of the first word in the passage with the second word.
 * The third takes in personal information such as email, name and phone number
 * and censors them accordingly with *'s.
 *
 * @author Anudeep Yakkala, ayakkala@purdue.edu
 * @version 09/22/18
 */
public class TextFilter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Print hello message
        System.out.println("Welcome to TextFilter!");

        // Value to keep track of if the user wants to keep filtering text
        boolean keepFiltering;

        do {
            // Print options for the user to select
            System.out.println("Please select one of the following filtering options: \n");
            System.out.println("1. Filter Word\n" +
                    "2. Find-And-Replace\n" +
                    "3. Censor Information");

            // Save their choice
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {

                // PART 1 - Censoring Words


                String passage = "";  // The text to be filtered
                System.out.println("Please enter the passage you would like filtered: ");

                passage = scanner.nextLine();

                String word;  // The word to be censored from the text phrase
                System.out.println("Please enter the word you would like to censor: ");

                word = scanner.nextLine();
                word = word.replaceAll(" ", "_");
                System.out.println("Uncensored: ");
                System.out.println(passage);

                passage = " " + passage + " ";
                passage = passage.replaceAll(" ", "_");
                String censor = "";
                for (int i = 0; i < word.length(); i++) {
                    censor += "X";
                }
                passage = passage.replaceAll(" ", "_");
                passage = passage.replaceAll(("_" + word + "_"), ("_" + censor + "_"));
                passage = passage.replaceAll(("_" + word + ","), ("_" + censor + ","));
                passage = passage.replaceAll(("_" + word + "!"), ("_" + censor + "!"));
                passage = passage.replaceAll(("_" + word + "\\."), ("_" + censor + "."));
                passage = passage.replaceAll(("_" + word + "\\?"), ("_" + censor + "?"));
                passage = passage.substring(1, passage.length() - 1);
                passage = passage.replaceAll("_", " ");
                System.out.println("Censored: ");
                System.out.println(passage);


            } else if (choice == 2) {

                // PART 2 - Replacing Words


                String passage = "";  // The text to be filtered
                System.out.println("Please enter the passage you would like filtered: ");


                passage = scanner.nextLine();

                String replace;  // The word to be filtered from the text phrase
                System.out.println("Please enter the word you would like to replace: ");

                replace = scanner.nextLine();
                replace = replace.replaceAll(" ", "_");

                String insert;  // The word to be inserted in the text phrase
                System.out.println("Please enter word you would like to insert: ");

                insert = scanner.nextLine();

                System.out.println("Uncensored: ");
                System.out.println(passage);


                passage = " " + passage + " ";
                passage = passage.replaceAll(" ", "_");
                passage = passage.replaceAll(" ", "_");
                passage = passage.replaceAll(("_" + replace + "_"), ("_" + insert + "_"));
                passage = passage.replaceAll(("_" + replace + ","), ("_" + insert + ","));
                passage = passage.replaceAll(("_" + replace + "!"), ("_" + insert + "!"));
                passage = passage.replaceAll(("_" + replace + "\\."), ("_" + insert + "."));
                passage = passage.replaceAll(("_" + replace + "\\?"), ("_" + insert + "?"));
                passage = passage.substring(1, passage.length() - 1);
                passage = passage.replaceAll("_", " ");

                System.out.println("Censored: ");
                System.out.println(passage);


            } else if (choice == 3) {

                // PART 3 - Censoring Personal Information


                /*
                 * DO NOT ALTER THIS CODE! This formatting is imperative to the completion of this task.
                 *
                 * Keep asking for input until the user enters an empty line
                 * If they enter an empty line and the phrase is empty, keep waiting for input
                 */
                String passage = "";  // String for holding text to be filtered

                System.out.println("Please enter the phrase you would like to censor information from: ");

                while (true) {

                    // Obtain a line from the user
                    String temp = scanner.nextLine();

                    if (!passage.isEmpty() && temp.isEmpty()) {
                        break;
                    } else if (passage.isEmpty() && temp.isEmpty()) {
                        continue;
                    }


                    // Add the contents of temp into the phrase
                    passage += temp;


                    // Append a newline character to each line for parsing
                    // This will separate each line the user enters
                    // To understand how input is formatted in Part 3, please refer to the handout.
                    passage += '\n';
                }

                // Print the uncensored passage
                System.out.println("Uncensored: ");
                System.out.println(passage);

                String censoredName = "";
                String censoredEmail = "";
                String censoredPhone = "";
                String[] lines = passage.split("\\n");
                String[] splitBySpace;
                String type;
                String value;
                String firstNameStars = "";
                String lastNameStars = "";
                String emailNameStars = "";
                String domainStars = "";
                String output = "";
                for (int i = 0; i < lines.length; i++) {
                    splitBySpace = lines[i].split("\\s", 2);
                    type = splitBySpace[0];
                    value = splitBySpace[1];
                    switch (type) {
                        case "Name:": {
                            String[] splitName = value.split("\\s");
                            for (int j = 0; j < splitName[0].length() - 1; j++) {
                                firstNameStars += "*";
                            }
                            for (int k = 0; k < splitName[1].length() - 1; k++) {
                                lastNameStars += "*";
                            }
                            splitName[0] = splitName[0].substring(0, 1) + firstNameStars;
                            splitName[1] = lastNameStars + splitName[1].substring(splitName[1].length() - 1);
                            firstNameStars = "";
                            lastNameStars = "";
                            censoredName = splitName[0] + " " + splitName[1];
                            output += type + " " + censoredName + '\n';
                            break;
                        }
                        case "Email:": {
                            String[] splitbyAt = value.split("@");
                            String[] splitDomain = splitbyAt[1].split("\\.");
                            for (int j = 0; j < splitbyAt[0].length() - 1; j++) {
                                emailNameStars += "*";
                            }
                            for (int k = 0; k < splitDomain[0].length() - 1; k++) {
                                domainStars += "*";
                            }
                            splitbyAt[0] = splitbyAt[0].substring(0, 1) + emailNameStars;
                            splitbyAt[1] = splitDomain[0].substring(0, 1) + domainStars + "." + splitDomain[1];
                            emailNameStars = "";
                            domainStars = "";
                            censoredEmail = splitbyAt[0] + "@" + splitbyAt[1];
                            output += type + " " + censoredEmail + '\n';
                            break;
                        }
                        case "Phone:": {
                            censoredPhone = "***-***-" + value.substring(8, 12);
                            output += type + " " + censoredPhone + '\n';
                            break;
                        }
                        default: {
                            output += type + " " + value + '\n';
                        }
                    }

                }
                passage = output;
                // Print the censored passage
                System.out.println("Censored: ");
                System.out.println(passage);

            } else {

                // They entered a number that was not 1, 2 or 3
                System.out.println("The option you chose was invalid!");

            }


            System.out.println("Would you like to keep filtering? Yes/No");


            String repeat;
            do {
                repeat = scanner.nextLine();
                if (repeat.equals("Yes")) {
                    keepFiltering = true;
                } else {
                    keepFiltering = false;
                }
            } while (repeat.isEmpty());
        } while (keepFiltering);

        System.out.println("Thank you for using TextFilter!");

    }

}
