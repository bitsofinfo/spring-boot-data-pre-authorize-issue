package my.test;

import java.io.Serializable;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;

@NoRepositoryBean
public interface ParentRepository1<T, ID extends Serializable> extends PagingAndSortingRepository<T, ID> {


    @Override
    @PostAuthorize("hasPermission(returnObject, 'READ')")
    T findOne(ID id);

	@Override
	@PreAuthorize("hasPermission(#c,'CREATE,UPDATE')")
	<S extends T> S save(@P("c") S data);

	
}
