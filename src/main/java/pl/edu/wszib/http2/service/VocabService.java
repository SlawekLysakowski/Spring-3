package pl.edu.wszib.http2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.http2.service.common.VocabDao;
import pl.edu.wszib.http2.service.exception.NotFoundException;;
import pl.edu.wszib.http2.service.model.Vocab;

import java.util.List;

@Service
public class VocabService {

  @Autowired
  private VocabDao dao;

  public Vocab get(Integer id) {
    return dao.findById(id)
            .orElseThrow(() -> new NotFoundException());
  }

  public List<Vocab> list() {
    return dao.findAll();
  }

  public void delete(Integer id) {
    dao.deleteById(id);
  }

  public Vocab create (Vocab newVocab) {
      newVocab.setId(null);
    return dao.save(newVocab);
  }

  public Vocab update(Vocab updateVocab) {
    Vocab existing = get(updateVocab.getId());
    return dao.save(updateVocab);
  }

}
