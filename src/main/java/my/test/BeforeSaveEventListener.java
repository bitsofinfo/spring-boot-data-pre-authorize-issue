package my.test;

import org.springframework.data.rest.core.event.AbstractRepositoryEventListener;

public class BeforeSaveEventListener extends AbstractRepositoryEventListener<Object> {

	
	public BeforeSaveEventListener() {
	}
	
	@Override
	public void onBeforeCreate(Object entity) {
		
		System.out.println("onBeforeCreate " + entity.toString());
	}
	
	@Override
	public void onBeforeSave(Object entity) {
		
		System.out.println("onBeforeSave " + entity.toString());

	}

	@Override
	public void onAfterDelete(Object entity) {
		System.out.println("onAfterDelete " + entity.toString());
	}

	@Override
	public void onAfterSave(Object entity) {
		System.out.println("onAfterSave " + entity.toString());

	}
	
	@Override
	public void onAfterCreate(Object entity) {
		System.out.println("onAfterCreate " + entity.toString());
	}
}