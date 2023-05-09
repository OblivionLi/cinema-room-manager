package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        start(scanner);
    }

    public static void start(Scanner scanner) {
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();

        System.out.println("Enter the number of seats in each row:");
        int seats = scanner.nextInt();

        String[][] cinemaRoom = createCinemaRoom(rows, seats);

        while (true) {
            showOptions();
            int option = scanner.nextInt();

            if (option == 0) {
                break;
            }

            switch (option) {
                case 1:
                    displayCinemaRoom(seats, cinemaRoom);
                    break;
                case 2:
                    buyTicket(scanner, cinemaRoom);
                    break;
                case 3:
                    showStatistics(cinemaRoom, rows, seats);
                    break;
                default:
                    break;
            }
        }
    }

    public static boolean buyTicket(Scanner scanner, String[][] cinemaRoom) {
        System.out.println("Enter a row number:");
        int rowNumber = scanner.nextInt();
        scanner.nextLine(); // consume newline character

        System.out.println("Enter a seat number in that row:");
        int seatNumber = scanner.nextInt();
        scanner.nextLine(); // consume newline character

        int rowNumberIndex = rowNumber - 1;
        int seatNumberIndex = seatNumber - 1;

        if (rowNumberIndex < 0 || rowNumberIndex >= cinemaRoom.length ||
            seatNumberIndex < 0 || seatNumberIndex >= cinemaRoom[0].length
        ) {
            System.out.println("Wrong input!");
            return buyTicket(scanner, cinemaRoom);
        } else if (cinemaRoom[rowNumberIndex][seatNumberIndex].equals("B")) {
            System.out.println("That ticket has already been purchased!");
            return buyTicket(scanner, cinemaRoom);
        }

        int ticketPrice = 10;
        if (rowNumber > cinemaRoom.length / 2) {
            ticketPrice = 8;
        }

        cinemaRoom[rowNumberIndex][seatNumberIndex] = "B";
        System.out.println("Ticket price: $" + ticketPrice);
        return true;
    }

    public static void showStatistics(String[][] cinemaRoom, int... rowsSeats) {
        System.out.println("Number of purchased tickets: " + getNoOfPurchasedTickets(cinemaRoom));
        System.out.println("Percentage: " + String.format("%.2f", getPercentageOfBoughtTickets(cinemaRoom, rowsSeats)) + "%");
        System.out.println("Current income: $" + getIncome(cinemaRoom));
        System.out.println("Total income: $" + getTotalIncome(rowsSeats));
    }

    public static int getTotalIncome(int... rowsSeats) {
        if (rowsSeats[0] < 1) {
            return 0;
        }

        int firstHalfRowsIncome = (rowsSeats[0] / 2) * rowsSeats[1] * 10;
        int secondHalfRowsIncome = (rowsSeats[0] - rowsSeats[0] / 2) * rowsSeats[1] * 8;

        return firstHalfRowsIncome + secondHalfRowsIncome;
    }

    public static int getIncome(String[][] cinemaRoom) {
        int income = 0;
        for (int i = 0; i < cinemaRoom.length; i++) {
            for (int j = 0; j < cinemaRoom[i].length; j++) {
                if (cinemaRoom[i][j].equals("B")) {
                    if (i < cinemaRoom.length / 2) {
                        income += 10;
                    } else {
                        income += 8;
                    }
                }
            }
        }

        return income;
    }

    public static double getPercentageOfBoughtTickets(String[][] cinemaRoom, int... rowsSeats) {
        int noOfPurchasedTickets = getNoOfPurchasedTickets(cinemaRoom);
        if (noOfPurchasedTickets == 0 || rowsSeats[0] == 0) {
            return 0.00;
        }

        return 1.0 * noOfPurchasedTickets / (rowsSeats[0] * rowsSeats[1]) * 100;
    }

    public static int getNoOfPurchasedTickets(String[][] cinemaRoom) {
        int noOfPurchasedTickets = 0;
        for (int i = 0; i < cinemaRoom.length; i++) {
            for (int j = 0; j < cinemaRoom[i].length; j++) {
                if (cinemaRoom[i][j].equals("B")) {
                    noOfPurchasedTickets++;
                }
            }
        }

        return noOfPurchasedTickets;
    }

    public static void showOptions() {
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
    }

    public static void displayCinemaRoom(int seats, String[][] cinemaRoom) {
        System.out.println("Cinema:");
        System.out.print("  ");
        for (int i = 1; i <= seats; i++) {
            if (i != seats) {
                System.out.print(i + " ");
            } else {
                System.out.println(i);
            }
        }

        for (int i = 0; i < cinemaRoom.length; i++) {
            System.out.print(i+1);
            for (int j = 0; j < cinemaRoom[i].length; j++) {
                System.out.print(" " + cinemaRoom[i][j]);
            }
            System.out.println();
        }
    }

    public static String[][] createCinemaRoom(int rows, int seats) {
        String[][] cinemaRoom = new String[rows][seats];
        for (int i = 0; i < cinemaRoom.length; i++) {
            for (int j = 0; j < cinemaRoom[i].length; j++) {
                cinemaRoom[i][j] = "S";
            }
        }

        return cinemaRoom;
    }
}
