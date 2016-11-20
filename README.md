# spring-boot-data-pre-authorize-issue

```
./gradlew bootRun
```


## POST a new record; (MyPermissionEvaluator will be called with NULL targetObject

```
curl -X POST -H "Content-Type: application/json" -H "Authorization: Basic dXNlcjoxMjM=" -H "Cache-Control: no-cache" -d '{
   "firstname":"spring",
   "lastname":"buggy"
 }' "http://localhost:8080/testrecords"
 
```

```
onBeforeCreate id: null Firstname:spring Lastname: buggy ID:my.test.TestRecord@5b864879
MyPermissionEvaluator hasPermission_1() called: targetDomainObject=(targetDomainObject=null)
onAfterCreate id: 1 Firstname:spring Lastname: buggy ID:my.test.TestRecord@5b864879
```


## PATCH the record; (MyPermissionEvaluator will be called with NON-NULL targetObject on `findOne`, followed by NULL targetObject on `save`

```
curl -X PATCH -H "Content-Type: application/json" -H "Authorization: Basic dXNlcjoxMjM=" -H "Cache-Control: no-cache" -d '{
   "firstname":"spring",
   "lastname":"buggy"
 }' "http://localhost:8080/testrecords/1"
 
```

```
MyPermissionEvaluator hasPermission_1() called: targetDomainObject=my.test.TestRecord
onBeforeSave id: 1 Firstname:spring Lastname: buggy ID:my.test.TestRecord@a17f455
MyPermissionEvaluator hasPermission_1() called: targetDomainObject=(targetDomainObject=null)
onAfterSave id: 1 Firstname:spring Lastname: buggy ID:my.test.TestRecord@a17f455
```

----------

Note the only way this works if if you have *no-intermediary repository interfaces* between `PagingAndSortingRepository` and your end repository interface... which if we have to do that sort of defeats the purpose of being able to extend our own intermediary interfaces after PagingAndSortingRepository

such as this... works as expected

```
@RepositoryRestResource(collectionResourceRel = "testrecords", path = "testrecords")
public interface TestRecordRepository extends PagingAndSortingRepository<TestRecord,Integer> {


    @Override
    @PostAuthorize("hasPermission(returnObject, 'READ')")
    TestRecord findOne(Integer id);

	@Override
	@PreAuthorize("hasPermission(#c,'CREATE,UPDATE')")
	TestRecord save(@P("c") TestRecord data);
	
}
```
