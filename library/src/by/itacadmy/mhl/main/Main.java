package by.itacadmy.mhl.main;

import by.itacadmy.mhl.controller.Controller;
import by.itacadmy.mhl.service.impl.ServiceException;

public class Main {

	public static void main(String[] args) throws ServiceException {

		Controller controller = new Controller();

		String userRequest = null;
		String userResponse = null;

		userRequest = "logination login=login password=ytrewq";
		userResponse = controller.doAction(userRequest);
		System.out.println(userResponse);
		System.out.println();
		
		userRequest = "view_all_catalog";
		userResponse = controller.doAction(userRequest);
		System.out.println(userResponse);
		
//		userRequest = "registration login=login password=zxcbb name=Poly surname=Edison email=edison@mail.ru role=user";
//		userResponse = controller.doAction(userRequest);
//		System.out.println(userResponse);

//		userRequest = "relogination";
//		userResponse = controller.doAction(userRequest);
//		System.out.println(userResponse);
//		System.out.println();

//		userRequest = "find_by_author author=Bloch";
//		userResponse = controller.doAction(userRequest);
//		System.out.println(userResponse);
//
//		userRequest = "find_by_category category=Java";
//		userResponse = controller.doAction(userRequest);
//		System.out.println(userResponse);

//		userRequest = "add_note id=199 category=JS title=Java_Script author=Wolf";
//		userResponse = controller.doAction(userRequest);
//		System.out.println(userResponse);

//		userRequest = "edit_note id=199 id=199 category=JSSS title=Java_Script author=Wolf";
//		userResponse = controller.doAction(userRequest);
//		System.out.println(userResponse);

	}

}
