# Springboot-REST-API-Tutorial
How to implement Pagenation?
      import org.springframework.data.domain.Pageable 
     
       Pageable pageable=PageRequest.of(page, size);
       Page<Employee> pagesOfEmp = employeeRepository.findAll(pageable); //Employee will be replaced with your entity and pagenation will be implemented

              Now we can customize it to return many other information.
    /*
		 * this pagesOfEmp object contains many things like all the record
		 * page size, number of pages etc. so extract all these properties
		 * and set into a object
		 * */

tamplate class to create objects with properties.
@Getter
@Setter
@NoArgsConstructor
public class PostResponse {
	private List<Employee> content;
	private int pageSize;
	private int pageNumber;
	private long totalElement;
	private int totalPage;
	private boolean isLastPage;
}

now extract required properties from Pageable type object and set it into owr Template object

PostResponse response=new PostResponse();
		response.setContent(pagesOfEmp.getContent());
		response.setPageNumber(pagesOfEmp.getNumber());
		response.setPageSize(pagesOfEmp.getSize());
		response.setTotalElement(pagesOfEmp.getTotalElements());
		response.setTotalPage(pagesOfEmp.getTotalPages());
		response.setLastPage(pagesOfEmp.isLast());


This repository contains learning material for springboot rest api which includes pagenation, exception handling, Swagger api documentations etc.
