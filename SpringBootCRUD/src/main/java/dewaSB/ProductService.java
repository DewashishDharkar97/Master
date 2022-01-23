package dewaSB;

import java.util.List;

import javax.transaction.Transactional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
 
@Service
@Transactional
public class ProductService {
 
    @Autowired
    private ProductRepository repo;
     
    public List<Product> listAll() {
        return repo.findAll();
    }
     
    public Product save(Product product) {
        return repo.save(product);
    }
     
    public Optional<Product> get(Integer id) {
    	
        return repo.findById(id);
    }
     
    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
