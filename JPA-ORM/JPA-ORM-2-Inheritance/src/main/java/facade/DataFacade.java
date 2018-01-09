/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Book;
import static entities.Book_.isbn;
import entities.EBook;
import entities.PaperBook;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author mathiasjepsen
 */
public class DataFacade {

    EntityManagerFactory emf;

    public DataFacade(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Book createBook(Book book) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(book);
            em.getTransaction().commit();
            return book;
        } finally {
            em.close();
        }
    }

    public void deleteBook(Integer isbn) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(em.find(Book.class, isbn));
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Book updateBook(Book updatedBook) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Book oldBook = em.find(Book.class, updatedBook.getIsbn());
            
            if (oldBook.getClass() == EBook.class) {
                EBook oldEBook = (EBook) oldBook;
                EBook updatedEBook = (EBook) updatedBook;
                oldEBook.setAuthor(updatedBook.getAuthor());
                oldEBook.setPrice(updatedBook.getPrice());
                oldEBook.setTitle(updatedBook.getTitle());
                oldEBook.setDownloadURL(updatedEBook.getDownloadURL());
                oldEBook.setSizeMB(updatedEBook.getSizeMB());
                oldBook = oldEBook;
            } else {
                PaperBook oldPaperBook = (PaperBook) oldBook;
                PaperBook updatedPaperBook = (PaperBook) updatedBook;
                oldPaperBook.setAuthor(updatedPaperBook.getAuthor());
                oldPaperBook.setPrice(updatedPaperBook.getPrice());
                oldPaperBook.setTitle(updatedPaperBook.getTitle());
                oldPaperBook.setInStock(updatedPaperBook.isInStock());
                oldPaperBook.setShippingWeight(updatedPaperBook.getShippingWeight());
                oldBook = oldPaperBook;
            }

            em.getTransaction().commit();
            return oldBook;
        } finally {
            em.close();
        }
    }

    public Book getBook(Integer isbn) {
        EntityManager em = getEntityManager();
        try {
            Book book = em.find(Book.class, isbn);
            return book;
        } finally {
            em.close();
        }
    }

    public List<Book> getBooks() {
        EntityManager em = getEntityManager();
        try {
            List<Book> books = em.createQuery("SELECT b FROM Book b").getResultList();
            return books;
        } finally {
            em.close();
        }
    }

}
