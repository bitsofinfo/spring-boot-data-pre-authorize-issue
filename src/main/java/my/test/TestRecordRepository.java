package my.test;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "testrecords", path = "testrecords")
public interface TestRecordRepository extends ParentRepository2<TestRecord> {

	
}