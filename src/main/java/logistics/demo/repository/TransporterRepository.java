package logistics.demo.repository;

import logistics.demo.model.Transporter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//repositório deve ser uma interface pois entende JpaRepository
@Repository
public interface  TransporterRepository extends JpaRepository<Transporter, Long> {
    
}
