import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String [] args) throws CloneNotSupportedException {
        List<Recommendation> recommendations = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int input;
        do {
            displayMenu();
            getInput();
            input = scanner.nextInt();
            switch (input) {
                case 1:
                    if (recommendations.isEmpty()) {
                        System.out.println("No recommendations added!\n");
                    } else {
                        for (Recommendation r : recommendations) {
                            System.out.println(r);
                        }
                    }
                    break;
                case 2:
                    System.out.println("Enter target Audience recommendation you want to modify:");
                    String targetString = scanner.next();
                    System.out.println("Enter recommendation's ID: ");
                    int idInput = scanner.nextInt();
                    for (Recommendation r : recommendations) {
                        if (r.getTargetAudience().equalsIgnoreCase(targetString) && r.getId() == idInput) {
                            System.out.println("Enter new target Audience for recommendation!");
                            String newTargetAudience = scanner.next();
                            System.out.println("Do you want make copy of recommendation and modify?(Y/N)");
                            String answerInput = scanner.next();
                            if (answerInput.equalsIgnoreCase("y")) {
                                Recommendation clonedRecommendation = r.clone();
                                clonedRecommendation.setTargetAudience(newTargetAudience);
                                recommendations.add(clonedRecommendation);
                                break;
                            } else if (answerInput.equalsIgnoreCase("n")) {
                                r.setTargetAudience(newTargetAudience);
                                break;
                            } else {
                                System.out.println("Invalid input!");
                                break;
                            }
                        }
                    }
//                    System.out.println("No such recommendations!\n");
                    break;
                case 3:
                    System.out.println("Enter Author name:");
                    String author = scanner.next();
                    System.out.println("Enter Title:");
                    String title = scanner.next();
                    System.out.println("Write Genre:");
                    String genre = scanner.next();
                    System.out.println("Write Publication year:");
                    int year = scanner.nextInt();
                    Book book = new Book(author, title, genre, year);
                    System.out.println("""
                            1. Add the book to new Recommendation.
                            2. Make a copy of the existing recommendation and add the book.
                            3. Add the book to existing recommendation.""");
                    getInput();
                    int choice = scanner.nextInt();
                    if (choice == 1) {
                        System.out.println("Enter the new recommendation target Audience:");
                        String inputTarget = scanner.next();
                        Recommendation recommendation = new Recommendation(inputTarget);
                        recommendation.addBookToList(book);
                        recommendations.add(recommendation);
                        break;
                    } else {
                        System.out.println("Enter recommendation target Audience:");
                        String inputTarget = scanner.next();
                        System.out.println("Enter recommendation's ID: ");
                        int idInput1 = scanner.nextInt();
                        if (choice == 2) {
                            for (Recommendation recommendation : recommendations) {
                                if (recommendation.getTargetAudience().equalsIgnoreCase(inputTarget) && recommendation.getId() == idInput1) {
                                    Recommendation clonedRecommendation = recommendation.clone();
                                    clonedRecommendation.addBookToList(book);
                                    recommendations.add(clonedRecommendation);
                                    break;
                                }
                            }
                        } else if (choice == 3) {
                            for (Recommendation recommendation : recommendations) {
                                if (recommendation.getTargetAudience().equalsIgnoreCase(inputTarget) && recommendation.getId() == idInput1) {
                                    recommendation.addBookToList(book);
                                    break;
                                }
                            }
                        }
                        else {
                            System.out.println("No such recommendation found!");
                        }
                    }
//                    System.out.println("No valid choice selected!\n");
                    book = null;
                    break;
                case 4:
                    System.out.println("Enter recommendation target audience:");
                    String targetInput = scanner.next();
                    System.out.println("Enter recommendation's ID: ");
                    int idInput2 = scanner.nextInt();
                    boolean recommendationCorrect = false;
                    for (Recommendation recommendation:recommendations){
                        if (recommendation.getTargetAudience().equalsIgnoreCase(targetInput) && recommendation.getId() == idInput2){
                            recommendationCorrect = true;
                            System.out.println("Enter the book author!");
                            String inputAuthor = scanner.next();
                            System.out.println("Enter the book title!");
                            String inputTitle = scanner.next();
                            for(Book b:recommendation.getBookList()){
                                if (b.getTitle().equalsIgnoreCase(inputTitle) && b.getAuthor().equalsIgnoreCase(inputAuthor)){
                                    System.out.println("Do you want to make a copy of recommendation and remove the book!(Y/N)");
                                    String inputChoice = scanner.next();
                                    if (inputChoice.equalsIgnoreCase("y")){
                                        Recommendation clonedRecommendation = recommendation.clone();
                                        clonedRecommendation.removeBookFromList(inputAuthor, inputTitle);
                                        recommendations.add(clonedRecommendation);
                                        break;
                                    }
                                    else {
                                        recommendation.removeBookFromList(inputAuthor,inputTitle);
                                        break;
                                    }
                                }
                            }

                        }
                    }
                    if(!recommendationCorrect){
                        System.out.println("No such target audience in recommendation list!");
                    }
                    else System.out.println("No book found with provided author and title!");
                    break;
                case 5:
                    System.out.println("Write target audience for recommendation.");
                    String search = scanner.next();
                    System.out.println("Enter recommendation's ID: ");
                    int idInput3 = scanner.nextInt();
                    for (Recommendation recommendation:recommendations){
                        if (recommendation.getTargetAudience().equalsIgnoreCase(search) && recommendation.getId()==idInput3){
                            if (!recommendation.getBookList().isEmpty()){
                                for (Book b: recommendation.getBookList()){
                                    System.out.println(b);
                                }
                            }
                        }
                    }
//                    System.out.println("No such recommendation found!\n");
                    break;
                case 6:
                    System.out.println("Enter recommendation's target audience: ");
                    String targetAudience = scanner.next();
                    if (!targetAudience.isEmpty()){
                        Recommendation newRecommendation = new Recommendation(targetAudience);
                        recommendations.add(newRecommendation);
                        break;
                    }
                    System.out.println("Provide valid recommendation");
                    break;
                default:
                    System.out.println("Invalid input!");
            }
        }while (input!=0);
    }

    public static void displayMenu(){
        System.out.println("Please Select from the menu: \n" +
                "1. View recommendations.\n" +
                "2. Modify Recommendation.\n" +
                "3. Add a new Book to recommendations.\n" +
                "4. Remove a book from recommendation.\n" +
                "5. View books in a recommendation.\n" +
                "6. Add recommendation.");
    }


    public static void getInput(){
        System.out.println("Enter your choice (0 to EXIT!): ");
    }

}
