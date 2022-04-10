package pl.edu.wszib.http2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.http2.service.common.CrudService;
import pl.edu.wszib.http2.service.common.ProduktDao;
import pl.edu.wszib.http2.service.exception.NotFoundException;
import pl.edu.wszib.http2.service.model.CV;
import pl.edu.wszib.http2.service.model.Filtr;
import pl.edu.wszib.http2.service.model.Produkt;
import pl.edu.wszib.http2.service.model.Produkt;

import java.util.List;

@Service
public class ProduktService {

  @Autowired
  private ProduktDao dao;

  public List<Produkt> list(Filtr filtr) {
    if (filtr.getMin() == null && filtr.getMax() == null) {
      return dao.findAll();
    } else if (filtr.getMin() == null) {
      return dao.findAllByCenaLessThan(filtr.getMax()); //max
    } else if (filtr.getMax() == null) {
      return dao.findAllByCenaGreaterThan(filtr.getMin());
    } else {
      return dao.findAllByCenaBetween(filtr.getMin(), filtr.getMax());
    }
  }

  public Produkt get(Integer id) {
    return dao.findById(id)
            .orElseThrow(() -> new NotFoundException());
  }

  public List<Produkt> list() {
    return dao.findAll();
  }

  public void delete(Integer id) {
    dao.deleteById(id);
  }

  public Produkt create (Produkt newProdukt) {
    newProdukt.setId(null);
    return dao.save(newProdukt);
  }

  public Produkt update(Produkt updateProdukt) {
    Produkt existing = get(updateProdukt.getId());
    return dao.save(updateProdukt);
  }
  
}
