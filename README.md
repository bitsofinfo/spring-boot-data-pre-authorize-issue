# spring-boot-data-pre-authorize-issue

https://github.com/spring-projects/spring-security/issues/4069

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
