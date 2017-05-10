import java.util.concurrent.ThreadLocalRandom;

import org.junit.Test;

import com.glarimy.cmad.library.api.Book;
import com.glarimy.cmad.library.api.Library;
import com.glarimy.cmad.library.service.GlarimyLibrary;


public class BookTest {
	
	private static Library library = new GlarimyLibrary();
	
	@Test
	public void testBookInsert(){
       //TODO
		Book testdata = new Book();
		testdata.setIsbn(12356);
		testdata.setTitle("ram");
		GlarimyLibrary test1 = new GlarimyLibrary();
		test1.add(testdata);
	}
}
