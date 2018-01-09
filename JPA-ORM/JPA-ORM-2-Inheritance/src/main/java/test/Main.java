package test;

import entities.Book;
import entities.EBook;
import entities.PaperBook;
import facade.DataFacade;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author mathiasjepsen
 */
public class Main {
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_exam");
        DataFacade df = new DataFacade(emf);
        
        EBook ebook = new EBook();
        ebook.setAuthor("Lovro");
        ebook.setPrice(230);
        ebook.setTitle("Lovro's Adventures");
        ebook.setDownloadURL("lovro@downloadnow.com");
        ebook.setSizeMB(1024);
        
        PaperBook paperbook = new PaperBook();
        paperbook.setAuthor("Thomas");
        paperbook.setPrice(432);
        paperbook.setTitle("Thomas' Misadventures");
        paperbook.setInStock(true);
        paperbook.setShippingWeight(968);
        
        df.createBook(ebook);
        df.createBook(paperbook);
                
        ebook.setAuthor("New Lovro");
        ebook.setPrice(700);
        ebook.setTitle("New Lovro's Adventures");
        ebook.setDownloadURL("lovronew@downloadnew.new");
        ebook.setSizeMB(9393939);
        df.updateBook(ebook);
        
//        EBook foundBook = (EBook) df.getBook(1);
//        System.out.println("EBook Title: " + foundBook.getTitle());
//        System.out.println("EBook Author: " + foundBook.getAuthor());
//        System.out.println("EBook Price: " + foundBook.getPrice());
//        System.out.println("EBook url: " + foundBook.getDownloadURL());
//        System.out.println("EBook size: \n" + foundBook.getSizeMB());
        
//        PaperBook foundPaperBook = (PaperBook) df.getBook(2);
//        System.out.println("PaperBook Title: " + foundPaperBook.getTitle());
//        System.out.println("PaperBook Author: " + foundPaperBook.getAuthor());
//        System.out.println("PaperBook Price: " + foundPaperBook.getPrice());
//        System.out.println("PaperBook in stock: " + foundPaperBook.isInStock());
//        System.out.println("PaperBook weight: " + foundPaperBook.getShippingWeight());
        
        List<Book> books = df.getBooks();
        
        for (Book book : books) {
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author : " + book.getAuthor());
            System.out.println("Price: " + book.getPrice());
            if (book.getClass() == EBook.class) {
                EBook ebook2 = (EBook) book;
                System.out.println("URL: " + ebook2.getDownloadURL());
                System.out.println("Size: " + ebook2.getSizeMB() + "\n");
            } else {
                PaperBook paperBook2 = (PaperBook) book;
                System.out.println("Available: " + paperBook2.isInStock());
                System.out.println("Weight: " + paperBook2.getShippingWeight() + "\n");
            }
        }
    }
    
}
