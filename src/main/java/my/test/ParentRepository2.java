package my.test;

import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ParentRepository2<T> extends ParentRepository1<T, Integer> {

}
