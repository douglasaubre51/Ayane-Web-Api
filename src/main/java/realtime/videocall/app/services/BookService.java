package realtime.videocall.app.services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import realtime.videocall.app.repositories.IBookRepository;

import realtime.videocall.app.entities.*;
@Service
public class BookService {
    @Autowired
    IBookRepository _repository;

    public List<Books> getAllBooks(){
        SessionFactory factory=new Configuration().configure().buildSessionFactory();
        Session session=factory.openSession();
        
        try{
            String getAllBooksQuery="select * from Books";

            Query<Books> bookList=session.createQuery(getAllBooksQuery,Books.class);
            return bookList.list();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    } 

    public Books getBook(String name){
        SessionFactory factory=new Configuration().configure().buildSessionFactory();
        Session session=factory.openSession();
        
        try{
            String getAllBooksQuery="select * from Books b where b.name=:name";

            Query<Books> book=session.createQuery(getAllBooksQuery,Books.class);
            book.setParameter("name",name);
            return book.uniqueResult();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
