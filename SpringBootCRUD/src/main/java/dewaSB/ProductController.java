package dewaSB;

import java.util.*;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.*;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
 
 
@RestController
public class ProductController {
 
    @Autowired
    private ProductService service;
    
    @Autowired
    private ProductModelAssembler assembler;
     
    @GetMapping("/products") //
   	CollectionModel<EntityModel<Product>> all() {

		List<EntityModel<Product>> products = service.listAll().stream()
				                              .map(assembler::toModel)
				                              .collect(Collectors.toList());

		return CollectionModel.of(products, linkTo(methodOn(ProductController.class).all()).withSelfRel());
	}
    
    @PostMapping("/products")
    ResponseEntity<?> newEmployee(@RequestBody Product newEmployee) {
    	
    	EntityModel<Product> entityModel = assembler.toModel(service.save(newEmployee));

    	  return ResponseEntity //
    	      .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
    	      .body(entityModel);
		
	}

	@GetMapping("/products/{id}")
	EntityModel<Product> one(@PathVariable Integer id) {

		Product product = service.get(id)
				          .orElseThrow(() -> new ProductNotFoundException(id));
		
		return assembler.toModel(product);
	}

	@PutMapping("/products/{id}")
	 ResponseEntity<?> replaceProduct(@RequestBody Product newProduct, @PathVariable Integer id) {

		
		Product updatedProduct = service.get(id)
			      .map(product -> {
			    	  product.setFirstname(newProduct.getFirstname());
			    	  product.setLastname(newProduct.getLastname());
			    	  product.setPrice(newProduct.getPrice());
			        return service.save(product);
			      })
			      .orElseGet(() -> {
			    	newProduct.setId(id);
			        return service.save(newProduct);
			      });
		
		EntityModel<Product> entityModel = assembler.toModel(service.save(updatedProduct));

  	  return ResponseEntity //
  	      .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
  	      .body(entityModel);
		
		
	}

	@DeleteMapping("/products/{id}")
	ResponseEntity<?> deleteEmployee(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

    
}
