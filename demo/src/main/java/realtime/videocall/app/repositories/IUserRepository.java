package realtime.videocall.app.repositories;

import realtime.videocall.app.entities.*;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
}