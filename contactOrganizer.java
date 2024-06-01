import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
public class contactOrganizer {
    public static int idCounter = 001;

    //------------------------------ create array-----------------------------------//
    public static String[] codeArray = new String[0];
    public static String[] nameArray = new String[0];
    public static String[] companyArray = new String[0];
    public static double[] salaryArray = new double[0];
    public static String[] contactArray = new String[0];
    public static String[] birthArray = new String[0];

    public static void homePage() {
        Scanner input = new Scanner(System.in);

        System.out.println("\n\n          /$$ /$$$$$$$$ /$$$$$$$  /$$$$$$ /$$$$$$$$ /$$   /$$ /$$$$$$$");
		System.out.println("          |__/| $$_____/| $$__  $$|_  $$_/| $$_____/| $$$ | $$| $$__  $$");
		System.out.println("           /$$| $$      | $$  \\ $$  | $$  | $$      | $$$$| $$| $$  \\ $$");
		System.out.println("          | $$| $$$$$   | $$$$$$$/  | $$  | $$$$$   | $$ $$ $$| $$  | $$");
		System.out.println("          | $$| $$__/   | $$__  $$  | $$  | $$__/   | $$  $$$$| $$  | $$");
		System.out.println("          | $$| $$      | $$  \\ $$  | $$  | $$      | $$\\  $$$| $$  | $$");
		System.out.println("          | $$| $$      | $$  | $$ /$$$$$$| $$$$$$$$| $$ \\  $$| $$$$$$$/");
		System.out.println("          |__/|__/      |__/  |__/|______/|________/|__/  \\__/|_______/");
		
		
		System.out.println("\n\n\n  _____            _             _              ____                         _");
		System.out.println(" / ____|          | |           | |            / __ \\                       (_)");
		System.out.println("| |     ___  _ __ | |_ __ _  ___| |_ ____     | |  | |_ __ __ _  __ _ _ __  _ _______ _ __");
		System.out.println("| |    / _ \\| `_ \\| __/ _` |/ __| __/  __|    | |  | | `__/ _` |/ _` | `_ \\| |_  / _ \\ `__|");
		System.out.println("| |___| ( ) | | | | || | | | |__| |_\\__  \\    | |__| | | | |_| | |_| | | | | |/ /  __/ |");
		System.out.println(" \\_____\\___/|_| |_|\\__\\__,_|\\___|\\__|____/     \\____/|_|  \\__, |\\__,_|_| |_|_/___\\___|_|");
		System.out.println("                                                           __/ |");
		System.out.println("                                                          |___/");
		System.out.println("============================================================================================================");
		
	


        System.out.println("\n[01] Add Contacts");
        System.out.println("[02] Update Contacts");
        System.out.println("[03] Delete Contacts");
        System.out.println("[04] Search Contacts");
        System.out.println("[05] View Sorted Contacts");
        System.out.println("[06] Exist");
        System.out.print("\nEnter option to continue : ");
        int option = input.nextInt();
        clearConsole();

        switch(option) {
            case 1: addContacts();
            clearConsole();
             break;
            
            case 2: updateContacts();
            clearConsole();
             break;
            case 3: deleteContacts(); break;
            case 4:searchContacts();break;
            case 5: viewSortedContacts(); break; 
            case 6: 
            System.out.println("        Exiting the program.....");
            System.exit(0); 
            break;
            default: System.out.println("Invalid option.");
        }
    }
//----------------------- Extend array--------------------------------------//
    public static void extendArrays() {
        String[] tempCustomerCodeArray = new String[codeArray.length + 1];
        String[] tempNameArray = new String[nameArray.length + 1];
        String[] tempCompanyArray = new String[companyArray.length + 1];
        double[] tempSalaryArray = new double[salaryArray.length + 1];
        String[] tempContactArray = new String[contactArray.length + 1];
        String[] tempBirthArray = new String[birthArray.length + 1];

        for (int i = 0; i < codeArray.length; i++) {
            tempCustomerCodeArray[i] = codeArray[i];
            tempNameArray[i] = nameArray[i];
            tempCompanyArray[i] = companyArray[i];
            tempSalaryArray[i] = salaryArray[i];
            tempContactArray[i] = contactArray[i];
            tempBirthArray[i] = birthArray[i];
        }

        codeArray = tempCustomerCodeArray;
        nameArray = tempNameArray;
        companyArray = tempCompanyArray;
        salaryArray = tempSalaryArray;
        contactArray = tempContactArray;
        birthArray = tempBirthArray;
    }

    //-----------------------------view contacts-------------------------------------//

    public static void viewSortedContacts() {
        Scanner input = new Scanner(System.in);
        System.out.println("+-------------------------------------------------+");
        System.out.println("|             View Sorted Contacts                |");
        System.out.println("+-------------------------------------------------+");
        System.out.println("Choose sorting criteria:");
        System.out.println("[1] Sort by Name");
        System.out.println("[2] Sort by Salary");
        System.out.println("[3] Sort by Birthday");
        System.out.print("Enter option: ");
        int option = input.nextInt();

        switch(option) {
            case 1: sortAndDisplayByName(); break;
            case 2: sortAndDisplayBySalary(); break;
            case 3: sortAndDisplayByBirthday(); break;
            default: System.out.println("Invalid option.");
        }

        System.out.print("\nDo you want to stay here (Y/N)? : ");
        char ch = input.next().charAt(0);
        if (ch == 'Y' || ch == 'y') {
            viewSortedContacts();
        } else {
            homePage();
        }
    }

    //---------------- sorting and displaying contacts-----------------//
    public static void sortAndDisplayByName() {
        System.out.println("                        +-------------------------------------------------+");
        System.out.println("                        |                 List By Name                    |");
        System.out.println("                        +-------------------------------------------------+");
        
        for (int i = 0; i < nameArray.length - 1; i++) {
            for (int j = 0; j < nameArray.length - i - 1; j++) {
                if (nameArray[j].compareTo(nameArray[j + 1]) > 0) {
                  
                    String tempName = nameArray[j];
                    nameArray[j] = nameArray[j + 1];
                    nameArray[j + 1] = tempName;
    
                    String tempCustomerCode = codeArray[j];
                    codeArray[j] = codeArray[j + 1];
                    codeArray[j + 1] = tempCustomerCode;
    
                    String tempCompany = companyArray[j];
                    companyArray[j] = companyArray[j + 1];
                    companyArray[j + 1] = tempCompany;
    
                    double tempSalary = salaryArray[j];
                    salaryArray[j] = salaryArray[j + 1];
                    salaryArray[j + 1] = tempSalary;
    
                    String tempContact = contactArray[j];
                    contactArray[j] = contactArray[j + 1];
                    contactArray[j + 1] = tempContact;
    
                    String tempBirth = birthArray[j];
                    birthArray[j] = birthArray[j + 1];
                    birthArray[j + 1] = tempBirth;
                }
            }
        }
    
       
      

        System.out.println("\n+------------------------------------------------------------------------------------------------------------+");
        System.out.println("| Contact Id  |    Name        |     Phone Number   |     Company    |     Salary         |       Birthday   |");
        System.out.println("+------------------------------------------------------------------------------------------------------------+");

        for (int i = 0; i < nameArray.length; i++) {
            System.out.printf("| %-12s| %-15s| %-19s| %-16s| %-18s|%-18s|\n",codeArray[i],nameArray[i],contactArray[i],companyArray[i],salaryArray[i],birthArray[i]);
        }
        System.out.println("+------------------------------------------------------------------------------------------------------------+");

            // System.out.println("Code: " + codeArray[i]);
            // System.out.println("Name: " + nameArray[i]);
            // System.out.println("Contact: " + contactArray[i]);
            // System.out.println("Company: " + companyArray[i]);
            // System.out.println("Salary: " + salaryArray[i]);
            // System.out.println("Birth: " + birthArray[i]);
            // System.out.println("------------------------");


        }
    
    
    //---------------------------- sort by salary-----------------------------------------------//

    public static void sortAndDisplayBySalary() {
    
            System.out.println("                        +-------------------------------------------------+");
            System.out.println("                        |                 List By Salary                  |");
            System.out.println("                        +-------------------------------------------------+");

        for (int i = 0; i < salaryArray.length; i++) {
            for (int j = 0; j < salaryArray.length - i - 1; j++) {
                
                if (salaryArray[j] > salaryArray[j + 1]) {
                    double tempSalary = salaryArray[j];
                    salaryArray[j] = salaryArray[j + 1];
                    salaryArray[j + 1] = tempSalary;
    
                    String tempCode = codeArray[j];
                    codeArray[j] = codeArray[j + 1];
                    codeArray[j + 1] = tempCode;
    
                    String tempName = nameArray[j];
                    nameArray[j] = nameArray[j + 1];
                    nameArray[j + 1] = tempName;
    
                    String tempPhone = contactArray[j];
                    contactArray[j] = contactArray[j + 1];
                    contactArray[j + 1] = tempPhone;
    
                    String tempCompany = companyArray[j];
                    companyArray[j] = companyArray[j + 1];
                    companyArray[j + 1] = tempCompany;
    
                    String tempBirthday = birthArray[j];
                    birthArray[j] = birthArray[j + 1];
                    birthArray[j + 1] = tempBirthday;
                }
            }
        }
        System.out.println("\n+------------------------------------------------------------------------------------------------------------+");
        System.out.println("| Contact Id  |    Name        |     Phone Number   |     Company    |     Salary         |       Birthday    | ");
        System.out.println("+------------------------------------------------------------------------------------------------------------+");
        for (int i = 0; i < salaryArray.length; i++) {
           System.out.printf("| %-12s| %-15s| %-19s| %-16s| %-18s|%-18s|\n",codeArray[i],nameArray[i],contactArray[i],companyArray[i],salaryArray[i],birthArray[i]);
        }
        System.out.println("+------------------------------------------------------------------------------------------------------------+");
           // System.out.println("Code: " + codeArray[i] + ", Name: " + nameArray[i] + ", Phone: " + contactArray[i] + ", Company: " + companyArray[i] + ", Salary: " + salaryArray[i] + ", Birthday: " + birthArray[i]);
        }
    
    // -----------------------------sort by birthday----------------------------------//

    public static void sortAndDisplayByBirthday() {
        Scanner input=new Scanner(System.in);
        System.out.println("                    +-------------------------------------------------+");
        System.out.println("                    |                 List By Birthday                |");
        System.out.println("                    +-------------------------------------------------+");


        for (int i = 0; i < birthArray.length - 1; i++) {
            for (int j = 0; j < birthArray.length - i - 1; j++) {
                if (birthArray[j].compareTo(birthArray[j + 1]) > 0){
                    
                    String tempBirthday = birthArray[j];
                    birthArray[j] = birthArray[j + 1];
                    birthArray[j + 1] = tempBirthday;
    
                
                    String tempCode = codeArray[j];
                    codeArray[j] = codeArray[j + 1];
                    codeArray[j + 1] = tempCode;
    
                    String tempName = nameArray[j];
                    nameArray[j] = nameArray[j + 1];
                    nameArray[j + 1] = tempName;
    
                    String tempPhone = contactArray[j];
                    contactArray[j] = contactArray[j + 1];
                    contactArray[j + 1] = tempPhone;
    
                    String tempCompany = companyArray[j];
                    companyArray[j] = companyArray[j + 1];
                    companyArray[j + 1] = tempCompany;
    
                    Double tempSalary = salaryArray[j];
                    salaryArray[j] = salaryArray[j + 1];
                    salaryArray[j + 1] = tempSalary;
                }
            }
        }
    
        System.out.println("\n+------------------------------------------------------------------------------------------------------------+");
        System.out.println("| Contact Id  |    Name        |     Phone Number   |     Company    |     Salary         |       Birthday   | ");
        System.out.println("+------------------------------------------------------------------------------------------------------------+");
       
        for (int i = 0; i < birthArray.length; i++) {
            System.out.printf("| %-12s| %-15s| %-19s| %-16s| %-18s|%-18s|\n",codeArray[i],nameArray[i],contactArray[i],companyArray[i],salaryArray[i],birthArray[i]);
        }
        System.out.println("+------------------------------------------------------------------------------------------------------------+");

        

            //System.out.println("Code: " + codeArray[i] + ", Name: " + nameArray[i] + ", Phone: " +contactArray[i] + ", Company: " + companyArray[i] + ", Salary: " + salaryArray[i] + ", Birthday: " +birthArray[i]);
        }

    

    // -----------------------Search contacts--------------------------------------//
    public static void searchContacts() {
        Scanner input = new Scanner(System.in);
        System.out.println("        +-------------------------------------------------+");
        System.out.println("        |             Search Contact in the list          |");
        System.out.println("        +-------------------------------------------------+");

        if (codeArray.length == 0) {
            System.out.println("No contacts to delete.");
            homePage();
            return;
        }

        System.out.print("\nEnter the name or phone number of the contact you want to search: ");
        String searchKey = input.next();
        int contactIndex = searchContact(searchKey);

        if (contactIndex == -1) {
            System.out.println("Contact not found.");
            homePage();
            return;
           
        }

        
        System.out.println("        Code: " + codeArray[contactIndex]);
        System.out.println("        Name: " + nameArray[contactIndex]);
        System.out.println("        Contact: " + contactArray[contactIndex]);
        System.out.println("        Company: " + companyArray[contactIndex]);
        System.out.println("        Salary: " + salaryArray[contactIndex]);
        System.out.println("        Birth: " + birthArray[contactIndex]);

        System.out.print("\nDo you want to search for another contact (Y/N)? : ");
        char ch = input.next().charAt(0);
        if (ch == 'Y' || ch == 'y') {
            searchContacts();
        } else {
            homePage();
        }
    }

    // -----------------------------Delete Contact--------------------------------//
    public static void deleteContacts() {
        Scanner input = new Scanner(System.in);
        System.out.println("            +-------------------------------------------------+");
        System.out.println("            |           Delete Contact from the list           |");
        System.out.println("            +-------------------------------------------------+");

        if (codeArray.length == 0) {
            System.out.println("No contacts to delete.");
            homePage();
            return;
        }

      
        System.out.print("\nEnter the name or phone number of the contact you want to delete: ");
        String searchKey = input.next();
        int contactIndex = searchContact(searchKey);

        if (contactIndex == -1) {
            System.out.println("Contact not found.");
            homePage();
            return;
        }

        System.out.println("        Code: " + codeArray[contactIndex]);
        System.out.println("        Name: " + nameArray[contactIndex]);
        System.out.println("        Contact: " + contactArray[contactIndex]);
        System.out.println("        Company: " + companyArray[contactIndex]);
        System.out.println("        Salary: " + salaryArray[contactIndex]);
        System.out.println("        Birth: " + birthArray[contactIndex]);

        System.out.print("\nDo you want to delete this contact (Y/N)? : ");
        char ch = input.next().charAt(0);

        if (ch == 'Y' || ch == 'y') {
           
            for (int i = contactIndex; i < codeArray.length - 1; i++) {
                codeArray[i] = codeArray[i + 1];
                nameArray[i] = nameArray[i + 1];
                companyArray[i] = companyArray[i + 1];
                salaryArray[i] = salaryArray[i + 1];
                contactArray[i] = contactArray[i + 1];
                birthArray[i] = birthArray[i + 1];
            }

          
            int newSize = codeArray.length - 1;
            String[] newcodeArray = new String[newSize];
            String[] newNameArray = new String[newSize];
            String[] newCompanyArray = new String[newSize];
            double[] newSalaryArray = new double[newSize];
            String[] newContactArray = new String[newSize];
            String[] newBirthArray = new String[newSize];

           
            for (int i = 0; i < newSize; i++) {
                newcodeArray[i] = codeArray[i];
                newNameArray[i] = nameArray[i];
                newCompanyArray[i] = companyArray[i];
                newSalaryArray[i] = salaryArray[i];
                newContactArray[i] = contactArray[i];
                newBirthArray[i] = birthArray[i];
            }

           
            codeArray = newcodeArray;
            nameArray = newNameArray;
            companyArray = newCompanyArray;
            salaryArray = newSalaryArray;
            contactArray = newContactArray;
            birthArray = newBirthArray;

            System.out.println("\n     Contact deleted successfully.");
        } else {
            System.out.println("\nContact deletion canceled.");
		}
		
         System.out.print("Do you want to continue deleting? (Y/N): ");
         char x = input.next().charAt(0);
      
        if (x == 'Y' || x == 'y') {
            deleteContacts();
        } else {
           homePage();
        }
    }

    public static void updateContacts() {

        Scanner input = new Scanner(System.in);

        System.out.println("            +-------------------------------------------------+");
        System.out.println("            |           Update Contact to the list            |");
        System.out.println("            +-------------------------------------------------+");

        if (codeArray.length == 0) {
            System.out.println("No contacts to update.");
            homePage();
            return;
        }
    
        System.out.print("Enter the customer name or phone number: ");
        String searchKey = input.next();
        input.nextLine(); 
    
        int contactIndex = searchContact(searchKey);
    
        if (contactIndex == -1) {
            System.out.println("Contact not found.");
            updateContacts();
            return;
        }
    
       
        System.out.println("        Contact ID : " + codeArray[contactIndex]);
        System.out.println("        Name       : " + nameArray[contactIndex]);
        System.out.println("        Contact    : " + contactArray[contactIndex]);
        System.out.println("        Company    : " + companyArray[contactIndex]);
        System.out.println("        Salary     : " + salaryArray[contactIndex]);
        System.out.println("        birth      : " + birthArray[contactIndex]);
    
        System.out.println("\nWhat do you want to update.....?");
        System.out.println("[1] Name");
        System.out.println("[2] Phone Number");
        System.out.println("[3] Company");
        System.out.println("[4] Salary");
        System.out.println("[5] birthday ");
        System.out.print("Enter option: ");
        int option = input.nextInt();
        input.nextLine(); 
    
        switch (option) {
            case 1:
                System.out.println("update Name");
                System.out.println("===========");
                System.out.print("Enter new name: ");
                String newName = input.nextLine();
                nameArray[contactIndex] = newName;
                break;
            case 2:
            System.out.println("update Phone number");
            System.out.println("==========================");
                System.out.print("Enter new phone number: ");
                String newContact = input.nextLine();
                contactArray[contactIndex] = newContact;
                break;
            case 3:
            System.out.println("update company name");
            System.out.println("====================");
                System.out.print("Enter new company name: ");
                String newCompany = input.nextLine();
                companyArray[contactIndex] = newCompany;
                break;
            case 4:
            System.out.println("update Salary");
            System.out.println("===========");
                System.out.print("Enter new salary: ");
                double newSalary = input.nextDouble();
                salaryArray[contactIndex] = newSalary;
                break;
            case 5:
            System.out.println("update Birth ");
            System.out.println("===========+=======");
                System.out.print("Enter new birth: ");
                String newbirth = input.nextLine();
                birthArray[contactIndex] = newbirth;
                break;
            default:
                System.out.println("Invalid option.");
        }
    
        System.out.println("\n       Contact updated successfully.");
        System.out.print("Do you want to update another contact (Y/N)? : ");
        char ch = input.next().charAt(0);
        if (ch == 'Y' || ch == 'y') {
            updateContacts();
        } else {
            homePage();
        }
    }

    
//----------------------Search--------------------------//
public static int searchContact(String searchKey) {
    for (int i = 0; i < contactArray.length; i++) {
        if (nameArray[i].equals(searchKey) || contactArray[i].equals(searchKey)) {
            return i; 
        }
    }
    return -1; 
}

    
    // --------------------------------birthday validation------------------------//
    public static boolean isValidBirthday(String birthday) {
        try {
            LocalDate birthDate = LocalDate.parse(birthday);
            LocalDate currentDate = LocalDate.now();
    
            if (birthDate.isAfter(currentDate)) {
                //System.out.println("Birthday cannot be in the future.");
                return false;
            }
    
            return true;
        } catch (DateTimeParseException e) {
           // System.out.println("Invalid date format. Please enter the date in YYYY-MM-DD format.");
           
           
            return false;
        }
    }


    // ------------------------------------name validate-----------------------------//
    
    public static boolean isValidName(String name) {
       
        if (name.isEmpty()) {
            return false;
        }
    
    
        for (char c : name.toCharArray()) {
            if (!Character.isLetter(c) && c != ' ') {
                return false;
            }
        }
    
        return true;
    }



    // ---------------------------salary validation----------------------//
    public static boolean isValidSalary(double salary){
        return salary > 0; 
    }

    // -------------------------contact validation---------------------------//
    public static boolean isValidateContact(String contact) {
        if (contact.length() != 10 || contact.charAt(0) != '0') {
            return false;
        }
        for (int i = 0; i < contact.length(); i++) {
            if (!Character.isDigit(contact.charAt(i))) {
                return false;
            }
        }
        return true;
    }
        

    public static void addContacts() {
        Scanner input = new Scanner(System.in);

        System.out.println("+-------------------------------------------------+");
        System.out.println("|           Add Contact to the list               |");
        System.out.println("+-------------------------------------------------+");

        do {
           
            String customerCode = "C" + String.format("%03d", idCounter++);
        
        System.out.println(" " + customerCode);
        System.out.println("=============");
            
            // if (isDuplicateCustomerCode(customerCode)) {
            //     System.out.println("Customer code already exists. Please enter a unique customer code.");
            //     continue;
            // }
            String name;
            do {
                System.out.print("Name      : ");
                name = input.next();

                if (!isValidName(name)) {
                    System.out.println("Invalid name ");
                    System.out.print("Do you want to enter new Name  (Y/N) : ");

                    char ch = input.next().charAt(0);
                    if (ch == 'Y' || ch == 'y') {
                        System.out.print("\033[4A");
                        System.out.print("\033[0J");

                    } else if (ch == 'N' || ch == 'n') {
                        homePage();
                        break;
                    }

                }
            } while (!isValidName(name));

            String contact;
            
            do {
                System.out.print("Contact : ");
                contact = input.next();
                if (isDuplicatecontact(contact)) {
                    System.out.println("contact number already exists. Please enter a unique contact number.");
                    System.out.print("\nDo you want to input contact again ?(Y/N) :");
                    
                    char ch = input.next().charAt(0);
                    if(ch=='Y'|ch=='y'){
                        System.out.print("\033[4A");
                        System.out.print("\033[0J");

                    }

                    continue;
                }
                if (!isValidateContact(contact)) {
                    System.out.println("Invalid phone number ");
                    System.out.print("\nDo you want to input contact again ?(Y/N) : ");
                    
                    char ch = input.next().charAt(0);
                    if(ch=='Y'|ch=='y'){
                        System.out.print("\033[4A");
                        System.out.print("\033[0J");

                    }else if(ch=='N'|ch=='n'){
                        homePage();
                        break;
                    }

                }

            } while (!isValidateContact(contact)|| isDuplicatecontact(contact));
            System.out.print("Company : ");
            String company = input.next();
            double salary;
            do {

                System.out.print("Salary : ");
                salary = input.nextDouble();
                if(!isValidSalary(salary)){
                    System.out.println("Invalid salary...");
                    System.out.print("\nDo you want to input salary again ?(Y/N) : ");
                    char ch = input.next().charAt(0);
                    if(ch=='Y'|ch=='y'){
                        System.out.print("\033[4A");
                        System.out.print("\033[0J");

                    }else if(ch=='N'|ch=='n'){
                        homePage();
                        break;
                    }

                }


            }while(!isValidSalary(salary));

           String birthday;
           do{

            System.out.print("Birth (YYYY-MM-DD): ");
             birthday = input.next();
             if (!isValidBirthday(birthday)) {
                System.out.println("Invalid birthday...");
                    System.out.print("\nDo you want to input birthday again ?(Y/N) : ");
                    char ch = input.next().charAt(0);
                    if(ch=='Y'|ch=='y'){
                        System.out.print("\033[5A");
                        System.out.print("\033[0J");

                    }else if(ch=='N'|ch=='n'){
                        homePage();
                        break;
                    }

                }

        } while (!isValidBirthday(birthday));
           
            

            extendArrays();

            codeArray[codeArray.length - 1] = customerCode;
            nameArray[nameArray.length - 1] = name;
            companyArray[companyArray.length - 1] = company;
            salaryArray[salaryArray.length - 1] = salary;
            contactArray[contactArray.length - 1] = contact;
            birthArray[birthArray.length - 1] = birthday;

            System.out.println("     " + " \n             Contact has been  added successfully...             ");
            System.out.print("Do you want to add another contact (Y/N)? : ");

            char ch = input.next().charAt(0);
         if (ch == 'Y' || ch == 'y') {
                    addContacts();
                    break;
                }else if (ch == 'N' || ch == 'n') {
                homePage();
                break;
            
        } 
    }
        while (true);
    }

    //-----------------------------------duplicate code---------------------------------------//
    // public static boolean isDuplicateCustomerCode(String customerCode) {
    //     for (String code : codeArray) {
    //         if (code.equals(customerCode)) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }

    //-----------------------------------duplicate check phone number---------------------------------------//
    public static boolean isDuplicatecontact(String contact) {
        for (String code : contactArray) {
            if (code.equals(contact)) {
                return true;
            }
        }
        return false;
    }

    // -----------------------------------console method---------------------------------//
    public final static void clearConsole() {
                 try {
                        final String os = System.getProperty("os.name");
                            if (os.contains("Windows")) {
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                } else {
                    System.out.print("\033[H\033[2J");
                        System.out.flush();
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }
    


    public static void main(String[] args) {
       
        homePage();
    }
}
