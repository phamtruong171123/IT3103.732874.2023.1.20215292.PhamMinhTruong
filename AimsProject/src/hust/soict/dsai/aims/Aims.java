package hust.soict.dsai.aims;

import java.util.*;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;

public class Aims {

    public static void main(String[] args) {
        int choice;
        Store store = new Store();
        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Director 1", "Category 1", "DVD Title 1", 15.0f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Director 2", "Category 2", "DVD Title 2", 20.0f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Director 3", "Category 3", "DVD Title 3", 25.0f);

        CompactDisc cd1 = new CompactDisc("CD Title 1", "Category 1", 12.0f, "Artist 1");
        CompactDisc cd2 = new CompactDisc("CD Title 2", "Category 2", 18.0f, "Artist 2");
        CompactDisc cd3 = new CompactDisc("CD Title 3", "Category 3", 22.0f, "Artist 3");
        Track track1 = new Track("hello", 12);
        Track track3 = new Track("hello1", 13);
        Track track2 = new Track("hello2", 14);
        cd1.addTrack(track1);
        cd1.addTrack(track2);
        cd1.addTrack(track3);

        Book book1 = new Book("Book Title 1", "Category 1", 8.0f);
        Book book2 = new Book("Book Title 2", "Category 2", 10.0f);
        Book book3 = new Book("Book Title 3", "Category 3", 14.0f);
        Book book4 = new Book("Book Title 4", "Category 4", 16.0f);

        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(cd1);
        store.addMedia(cd2);
        store.addMedia(cd3);
        store.addMedia(book1);
        store.addMedia(book2);
        store.addMedia(book3);
        store.addMedia(book4);

        Scanner scanner = new Scanner(System.in);
        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Đọc dòng trống

            switch (choice) {
                case 1:
                    store.printStore();
                    storeProcess(store, cart);
                    break;
                case 2:
                    int updateChoice;
                    do {
                        System.out.println("Update Store Menu:");
                        System.out.println("1. Add a media to the store");
                        System.out.println("2. Remove a media from the store");
                        System.out.println("0. Back to the main menu");
                        System.out.print("Please choose an option: ");
                        updateChoice = scanner.nextInt();
                        scanner.nextLine(); // Đọc dòng trống

                        switch (updateChoice) {
                            case 1:
                                System.out.println("Choose the type of Media to add(CD/DVD/BOOK)");
                                String type = scanner.nextLine();
                                if (type.equalsIgnoreCase("CD")) {
                                    System.out.println("Please enter title, category, cost, and artist:(Separate by space)");
                                    String title = scanner.nextLine();
                                    String category = scanner.nextLine();
                                    float cost = scanner.nextFloat();
                                    scanner.nextLine(); // Đọc dòng trống
                                    String artist = scanner.nextLine();
                                    CompactDisc cd = new CompactDisc(title, category, cost, artist);
                                    System.out.print("Enter number of Tracks:");
                                    int number = scanner.nextInt();
                                    scanner.nextLine(); // Đọc dòng trống
                                    for (int i = 0; i < number; i++) {
                                        System.out.println("Enter Track " + (i + 1) + " information:");
                                        String titleTrack = scanner.nextLine();
                                        int length = scanner.nextInt();
                                        scanner.nextLine(); // Đọc dòng trống
                                        Track track = new Track(titleTrack, length);
                                        cd.addTrack(track);
                                    }
                                    store.addMedia(cd);
                                } else if (type.equalsIgnoreCase("DVD")) {
                                    System.out.println("Please enter director, category, title, cost:(Separate by space)");
                                    String director = scanner.nextLine();
                                    String category = scanner.nextLine();
                                    String title = scanner.nextLine();
                                    float cost = scanner.nextFloat();
                                    scanner.nextLine(); // Đọc dòng trống
                                    String artist = scanner.nextLine();
                                    DigitalVideoDisc dvd = new DigitalVideoDisc(director, category, title, cost);
                                    store.addMedia(dvd);
                                } else if (type.equalsIgnoreCase("BOOK")) {
                                    System.out.println("Please enter title, category, and cost :(Separate by space)");
                                    String title = scanner.nextLine();
                                    String category = scanner.nextLine();
                                    float cost = scanner.nextFloat();
                                    scanner.nextLine(); // Đọc dòng trống
                                    Book book = new Book(title, category, cost);
                                    store.addMedia(book);
                                }
                                break;
                            case 2:
                                System.out.print("Enter title to delete: ");
                                String deleteTitle = scanner.nextLine();
                                store.removeMedia(store.searchStore(deleteTitle));
                                break;
                            case 0:
                                System.out.println("Returning to the main menu.");
                                break;
                            default:
                                System.out.println("Invalid choice. Please choose again.");
                        }
                    } while (updateChoice != 0);

                    break;
                case 3:

                    cartMenu(cart);

                    break;
                case 0:

                    System.out.println("Exiting AIMS. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }

        } while (choice != 0);
    }

    public static void storeMenu(Store store) {
        
        System.out.println("Option:");
        System.out.println("_________________________");
        System.out.println("1. See a media's detail");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current Cart");
        System.out.println("0. Back");
        System.out.println("_________________________");
        System.out.println("Please choose a number: 0-1-2-3-4");
        
        }
    
    
    public static void mediaDetailsMenu() {
        System.out.println("Option:");
        System.out.println("_________________________");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("_________________________");
        System.out.println("Please choose a number: 0-1-2");
    }
    
    public static void showMenu() {

        System.out.println("Aims:");
        System.out.println("_________________________");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("_________________________");
        System.out.println("Please choose a number: 0-1-2-3");
    }
    
    public static void storeProcess(Store store, Cart cart) {
        Scanner scanner = new Scanner(System.in);
        int storeChoice;
        do {
            storeMenu(store);
            storeChoice = scanner.nextInt();
            scanner.nextLine(); // Đọc dòng trống
    
            switch (storeChoice) {
                case 1:
                    String title;
                    Media media;
                    do {
                        System.out.println("Enter Media's title: ");
                        title = scanner.nextLine();
                        media = store.searchStore(title);
                        if (media == null)
                            System.out.println("Title does not exist! Please retype");
                    } while (media == null);
                    System.out.println(media.toString());
                    mediaDetailsMenuProcess(media, cart);
                    break;
                case 2:
                    do {
                        System.out.println("Enter Media's title: ");
                        title = scanner.nextLine();
                        media = store.searchStore(title);
                        if (media == null)
                            System.out.println("Title does not exist! Please retype");
                    } while (media == null);
                    cart.addMedia(media);
                    break;
                case 3:
                do {
                    System.out.println("Enter Media's title: ");
                    title = scanner.nextLine();
                    media = store.searchStore(title);
                
                    if (media == null) {
                        System.out.println("Title does not exist! Please retype");
                    } else {
                        if (media instanceof Playable) {
                            ((Playable) media).play();
                        } else {
                            System.out.println("Please enter the title of a CD/DVD");
                        }
                    }
                } while (media == null || !(media instanceof Playable));
                
                    break;
                case 4:
                    cartMenu(cart);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        } while (storeChoice != 0);
    }
    
    public static void mediaDetailsMenuProcess(Media media, Cart cart) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            mediaDetailsMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Đọc dòng trống
    
            switch (choice) {
                case 1:
                    cart.addMedia(media);
                    break;
                case 2:
                    if (media instanceof Playable)
                        ((Playable) media).play();
                    else {
                        System.out.println("Book cannot play!");
                    }
                    break;
                default:
                    System.out.println("Please enter a valid number!");
                    break;
            }
        } while (choice != 0);
    }
    
    public static void cartMenu(Cart cart) {
        Scanner scanner = new Scanner(System.in);
        int cartChoice;
        
        do {
            for (Media media : cart.getItemOrdered()) {
                System.out.println(media.toString());
            }
            System.out.println(cart.totalCost());
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Filter medias in cart");
            System.out.println("2. Sort medias in cart");
            System.out.println("3. Remove media from cart");
            System.out.println("4. Play a media");
            System.out.println("5. Place order");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3-4-5");
    
            cartChoice = scanner.nextInt();
            scanner.nextLine(); 
    
            switch (cartChoice) {
                case 1:
                   
                    break;
                case 2:
                    System.out.println("Sort by:");
                    System.out.println("1. Title");
                    System.out.println("2. Cost");
    
                    int sortChoice = scanner.nextInt();
                    scanner.nextLine();

                    if (sortChoice == 1)
                        Collections.sort(cart.getItemOrdered(), Media.COMPARE_BY_TITLE_COST);
                    else
                        Collections.sort(cart.getItemOrdered(), Media.COMPARE_BY_COST_TITLE);

                    
                    break;
                case 3:
                    System.out.println("Enter title to delete: ");
                    String deleteTitle = scanner.nextLine();
                    cart.removeMedia(cart.Search(deleteTitle));
                    break;
                case 4:
                    System.out.println("Enter title to play: ");
                    String title = scanner.nextLine();
                    Media media = cart.Search(title);
    
                    if (media instanceof Playable)
                        ((Playable) media).play();
                    break;
                case 5:
                    System.out.println("Order successfully! Your total cost is: " + cart.totalCost() + " $");
                    cart.getItemOrdered().clear(); // xóa giỏ hàng
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
    
        } while (cartChoice != 0);
    }

}
