package realtime.videocall.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import realtime.videocall.app.entities.*;

public interface IBookRepository extends JpaRepository<Books,Long>{

}
