package my.test;

import java.io.Serializable;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;

public class MyPermissionEvaluator implements PermissionEvaluator {

	@Override
	public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
		
		System.out.println("MyPermissionEvaluator hasPermission_1() called: targetDomainObject=" + (targetDomainObject != null ? targetDomainObject.getClass().getName() : "(targetDomainObject=null)"));
		
		return true;
	}

	@Override
	public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType,
			Object permission) {
		
		System.out.println("MyPermissionEvaluator hasPermission_2() called: targetId=" + (targetId != null ? targetId.getClass().getName() : "(targetId=null)"));
		
		return false;
	}

}
