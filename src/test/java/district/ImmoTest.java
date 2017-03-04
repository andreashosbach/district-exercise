package district;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

public class ImmoTest {

	private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private PrintStream out;

	@Before
	public void setup() {
		out = new PrintStream(outContent);
	}

	@Test
	public void test_Exit() {
		InputStream in = new ByteArrayInputStream("3".getBytes());
		Immo2 immo = new Immo2(in, out);

		immo.run();
		out.flush();

		assertThat(outContent.toString(), is("1: New House\n2: Find House\n3: Exit\n"));
	}

	@Test
	public void test_Invalid() {
		InputStream in = new ByteArrayInputStream("d\n3".getBytes());
		Immo2 immo = new Immo2(in, out);

		immo.run();
		out.flush();

		assertThat(outContent.toString(), containsString("Input invalid\n"));
	}

	@Test
	public void test_AddHouse() {
		InputStream in = new ByteArrayInputStream("1\n1\n10.4\n0\n3".getBytes());
		Immo2 immo = new Immo2(in, out);

		immo.run();

		out.flush();
		assertThat(outContent.toString(),
				containsString("Please enter height:\nPlease enter roof type\n0: flat\n1: steep\n"));
	}

	@Test
	public void test_FindHouse_Found() {
		InputStream in = new ByteArrayInputStream("1\n1\n10\n0\n2\n1\n3".getBytes());
		Immo2 immo = new Immo2(in, out);

		immo.run();

		out.flush();
		assertThat(outContent.toString(), containsString("Enter number: \nFound: "));
	}

	@Test
	public void test_FindHouse_NotFound() {
		InputStream in = new ByteArrayInputStream("1\n1\n10\n0\n2\n2\n3".getBytes());
		Immo2 immo = new Immo2(in, out);

		immo.run();

		out.flush();
		assertThat(outContent.toString(), containsString("Enter number: \nNot found\n"));
	}
}