package realtime.videocall.app.services;

import realtime.videocall.app.entities.*;
import realtime.videocall.app.repositories.IUserRepository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

@Service
public class UserService {
    @Autowired
    private IUserRepository _userRepository;

    public User getUserById(Long id) {
        return _userRepository.findById(id).orElse(null);
    }

    public boolean getUserByEmail(String email, String password) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        Session session = factory.openSession();
        try {
            String emailHQL = "select count(u) from User u where u.emailID=:email and u.password=:password";

            Query<Long> emailQuery = session.createQuery(emailHQL, Long.class);
            emailQuery.setParameter("email", email);
            emailQuery.setParameter("password", password);

            return (emailQuery.uniqueResult() > 0) ? true : false;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void save(User user) {
        _userRepository.save(user);
    }
}
