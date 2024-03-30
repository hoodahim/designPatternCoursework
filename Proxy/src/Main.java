public class Main {
    public static void main(String [] args){

        IDocument document1 = new Document("This is unprotected document!", "upd01");
        IDocument document2_p = new DocumentProxy("This is protected document", "pd02");

        Library library = new Library();
        library.addToLibrary(document1);
        library.addToLibrary(document2_p);

        User user1 = new User("hasAccess");
        User user2 = new User("NoAccess");

        AccessControlService accessControlService = AccessControlService.instantiate();
        accessControlService.addToList(user1, document2_p);

        System.out.println(document1.getContent(user2));
        System.out.println(document2_p.getContent(user2));

        System.out.println(document1.getContent(user1));
        System.out.println(document2_p.getContent(user1));

        System.out.println(document1.getTime());
        System.out.println(document2_p.getTime());

        User user3 = new User("hasAccess");

        System.out.println(document2_p.getContent(user3));


    }
}
