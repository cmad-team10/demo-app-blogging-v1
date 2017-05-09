import org.junit.Test;

import com.glarimy.cmad.library.api.Book;
import com.glarimy.cmad.library.api.Library;
import com.glarimy.cmad.library.service.GlarimyLibrary;


public class BookTest {
	
	private static Library library = new GlarimyLibrary();
	
	@Test
	public void testBookInsert(){
		Book book = new Book();
		book.setIsbn(123456789);
		book.setTitle("Java Adv111");
		library.add(book);
	}
}
