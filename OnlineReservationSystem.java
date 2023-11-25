import java.util.ArrayList;
import java.util.Scanner;

class User {
    String username;
    String password;

    User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

class Reservation {
    String trainNumber;
    String trainName;
    String classType;
    String dateOfJourney;
    String from;
    String to;

    Reservation(String trainNumber, String trainName, String classType, String dateOfJourney, String from, String to) {
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.classType = classType;
        this.dateOfJourney = dateOfJourney;
        this.from = from;
        this.to = to;
    }
}

class Ticket {
    String pnr;
    User user;
    Reservation reservation;

    Ticket(String pnr, User user, Reservation reservation) {
        this.pnr = pnr;
        this.user = user;
        this.reservation = reservation;
    }
}

public class OnlineReservationSystem {
    private static ArrayList<User> users = new ArrayList<>();
    private static ArrayList<Ticket> tickets = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a sample user
        users.add(new User("Vinod", "Vinod21"));

        // Main menu
        while (true) {
            System.out.println("1. Login");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    User loggedInUser = login();
                    if (loggedInUser != null) {
                        reservationSystem(loggedInUser);
                    }
                    break;
                case 2:
                    System.out.println("Exiting the system. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static User login() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your username: ");
        String username = scanner.next();
        System.out.print("Enter your password: ");
        String password = scanner.next();

        for (User user : users) {
            if (user.username.equals(username) && user.password.equals(password)) {
                System.out.println("Login successful!");
                return user;
            }
        }

        System.out.println("Invalid username or password. Please try again.");
        return null;
    }

    private static void reservationSystem(User user) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Reservation System, " + user.username + "!");

        while (true) {
            System.out.println("1. Reservation Form");
            System.out.println("2. Cancellation Form");
            System.out.println("3. Logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    makeReservation(user);
                    break;
                case 2:
                    cancelReservation(user);
                    break;
                case 3:
                    System.out.println("Logging out. Goodbye, " + user.username + "!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void makeReservation(User user) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter train number: ");
        String trainNumber = scanner.next();
        System.out.print("Enter class type: ");
        String classType = scanner.next();
        System.out.print("Enter date of journey: ");
        String dateOfJourney = scanner.next();
        System.out.print("Enter from: ");
        String from = scanner.next();
        System.out.print("Enter to: ");
        String to = scanner.next();

        // For simplicity, assuming train name is based on the train number
        String trainName = "Train " + trainNumber;

        Reservation reservation = new Reservation(trainNumber, trainName, classType, dateOfJourney, from, to);
        String pnr = generatePNR();
        Ticket ticket = new Ticket(pnr, user, reservation);

        tickets.add(ticket);

        System.out.println("Reservation successful! Your PNR number is: " + pnr);
    }

    private static void cancelReservation(User user) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your PNR number: ");
        String pnr = scanner.next();

        for (Ticket ticket : tickets) {
            if (ticket.user.equals(user) && ticket.pnr.equals(pnr)) {
                displayTicketInfo(ticket);
                System.out.print("Press 'OK' to confirm cancellation: ");
                String confirmation = scanner.next();
                if (confirmation.equalsIgnoreCase("OK")) {
                    tickets.remove(ticket);
                    System.out.println("Cancellation successful!");
                    return;
                } else {
                    System.out.println("Cancellation aborted.");
                    return;
                }
            }
        }

        System.out.println("No reservation found with the given PNR number.");
    }

    private static void displayTicketInfo(Ticket ticket) {
        System.out.println("PNR Number: " + ticket.pnr);
        System.out.println("Train Number: " + ticket.reservation.trainNumber);
        System.out.println("Train Name: " + ticket.reservation.trainName);
        System.out.println("Class Type: " + ticket.reservation.classType);
        System.out.println("Date of Journey: " + ticket.reservation.dateOfJourney);
        System.out.println("From: " + ticket.reservation.from);
        System.out.println("To: " + ticket.reservation.to);
    }

    private static String generatePNR() {
        // For simplicity, a random PNR is generated in this example.
        return String.valueOf((int) (Math.random() * 100000));
    }
}
