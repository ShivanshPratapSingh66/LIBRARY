package Library;
import java.util.Scanner;

public class books {

    book theBooks[] = new book[50];
    public static int count;
    Scanner sc = new Scanner(System.in);
    // / METHOD 1- TO COMPARE BOOKS ;
            public int compareBookObjects(book b1,book b2){
                //IF BOOK NAME MATCHES .....
                if(b1.bookName.equalsIgnoreCase(b2.bookName))
                {
                    System.out.println("Book of this Name Already Exists :");
                    return 0;
                }
                // IF SERIAL MATCHES ....
                if(b1.sNo==b2.sNo)
                {
                    System.out.println("Book of this Serial number Already Exits : ");
                    return 0;
                }
                return 1;

            }
    // METHOD 2 - TO ADD BOOK ;
    public void addBook(book b)
    {
        for(int i=0;i<count;i++)
        {
            if(this.compareBookObjects(b,this.theBooks[i])==0)
                return;
        }
        if(count<50)
        {
            theBooks[count]=b;
            count++;
        }else System.out.println("No Space to Add more books : ");


    }
    // METHOD 3 - TO SEARCH BOOK BY SERIAL NUMBER
    public void searchBySno()
    {
        System.out.println("\t\t\t\t SEARCH BY SERIAL NUMBER \n ");
        // CLASS DATA MEMBERS .....
        int sNo;
        System.out.println("Enter Serial no of Book :  ");
        sNo= sc.nextInt();
        int flag=0;
        System.out.println("S.No\t\tName\tAuthor\t\tAvailable Qty \t\t Total Qty");
        for(int i=0;i<count;i++)
        {
            if(sNo==theBooks[i].sNo)
            {
                System.out.println(theBooks[i].sNo+"\t\t" +
                        theBooks[i].bookName+"\t\t" +
                        theBooks[i].authorName+"\t\t" +
                        theBooks[i].bookQtyCopy+"\t\t" +
                        theBooks[i].bookQty);
                flag++;
                return;
            }
        }
        if(flag==0)
            System.out.println("No book for Serial no "+sNo+ " Found :");
    }
    // METHOD 4 - TO SEARCH AUTHOR BY NAME
    public void searchByAuthorName()
    {
        System.out.println("\t\t\t\tSEARCH BY AUTHOR'S NAME ");
        sc.nextLine();
        System.out.println("Enter Author Name : ");
        String authorName = sc.nextLine();
        int flag=0;
        System.out.println(
                "S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");
        for(int i=0;i<count;i++)
        {
            // IF AUTHOR MATCHES ANY OF ITS BOOK
            if(authorName.equalsIgnoreCase(theBooks[i].authorName))
            {
                // print below related details
                System.out.println(theBooks[i].sNo+"\t\t" +
                        theBooks[i].bookName+"\t\t" +
                        theBooks[i].authorName+"\t\t" +
                        theBooks[i].bookQtyCopy+"\t\t" +
                        theBooks[i].bookQty);
                flag++;
            }
        }
        // else no book matches for author
        if(flag==0)
            System.out.println("No Books Of "+authorName+"Found.");
    }
    // METHOD 5 - TO DISPLAY AAL BOOKS
    public void showAllBooks()
    {
        System.out.println("\t\t\t\tSHOWING ALL BOOKS\n");
        System.out.println("S.No\t\tName\tAuthor\t\tAvailable Qty \t\t Total Qty");
        for(int i=0;i<count;i++)
        {

                System.out.println(theBooks[i].sNo+"\t\t" +
                        theBooks[i].bookName+"\t\t" +
                        theBooks[i].authorName+"\t\t" +
                        theBooks[i].bookQtyCopy+"\t\t" +
                        theBooks[i].bookQty);
        }
    }
    // METHOD - 6 TO EDIT THE BOOKS
    public void upgradeBookQty()
    {

        System.out.println(
                "\t\t\t\tUPGRADE QUANTITY OF A BOOK\n");
        System.out.println("Enter Serial No of Book");

        int sNo = sc.nextInt();

        for (int i = 0; i < count; i++) {

            if (sNo == theBooks[i].sNo) {

                // Display message
                System.out.println(
                        "Enter No of Books to be Added:");

                int addingQty = sc.nextInt();
                theBooks[i].bookQty += addingQty;
                theBooks[i].bookQtyCopy += addingQty;

                return;
            }
        }
    }

    // Method 7
    // To create menu
    public void dispMenu()
    {

        // Displaying menu
        System.out.println(
                "----------------------------------------------------------------------------------------------------------");
        System.out.println("Press 1 to Add new Book.");
        System.out.println("Press 0 to Exit Application.");
        System.out.println(
                "Press 2 to Upgrade Quantity of a Book.");
        System.out.println("Press 3 to Search a Book.");
        System.out.println("Press 4 to Show All Books.");
        System.out.println("Press 5 to Register Student.");
        System.out.println(
                "Press 6 to Show All Registered Students.");
        System.out.println("Press 7 to Check Out Book. ");
        System.out.println("Press 8 to Check In Book");
        System.out.println(
                "-------------------------------------------------------------------------------------------------------");
    }

    // Method 8
    // To search the library
    public int isAvailable(int sNo)
    {

        for (int i = 0; i < count; i++) {
            if (sNo == theBooks[i].sNo) {
                if (theBooks[i].bookQtyCopy > 0) {

                    System.out.println(
                            "Book is Available.");
                    return i;
                }
                System.out.println("Book is Unavailable");
                return -1;
            }
        }

        System.out.println("No Book of Serial Number "
                + " Available in Library.");
        return -1;
    }

    // Method 9
    // To remove the book from the library
    public book checkOutBook()
    {

        System.out.println(
                "Enter Serial No of Book to be Checked Out.");
        int sNo = sc.nextInt();

        int bookIndex = isAvailable(sNo);

        if (bookIndex != -1) {
            theBooks[bookIndex].bookQtyCopy--;
            return theBooks[bookIndex];
        }
        return null;
    }

    // Method 10
    // To add the Book to the Library
    public void checkInBook(book b)
    {
        for (int i = 0; i < count; i++) {
            if (b.equals(theBooks[i])) {
                theBooks[i].bookQtyCopy++;
                return;
            }
        }
    }
}
