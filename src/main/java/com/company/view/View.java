package com.company.view;

/**
 * This interface defines different Views for different models in application.
 * 
 * @author amipatil
 *
 */
public interface View {

	public static interface UserView {

		public static interface External { }

		public static interface Internal extends External { }

//		 * View to define desierilization of request body for POST call. any fields
//		 * other than defined by this view, will be just ignored.
		public static interface Post { }

		public static interface PUT { }
	}

}
