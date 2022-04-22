package pl.edu.wszib.http2.service.common;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.http2.service.model.Vocab;
@Repository
public interface VocabDao extends JpaRepository<Vocab, Integer> {


}
