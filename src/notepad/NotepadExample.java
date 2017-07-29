package notepad;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NotepadExample {
	Pattern start, epn, notepad, notepadSheet, fileOption, save, saveWith, continueWith, saveButton;
	Screen screen;

	@BeforeTest
	public void startUp() {
		System.out.println("-----> Test started");
		screen = new Screen();

		/* images needed to open and perform some tasks in notepad */
		start = new Pattern("D:\\amit\\Java_programs\\Sikuli_TestProject_OpenNotePad\\libs\\start.PNG");
		epn = new Pattern("D:\\amit\\Java_programs\\Sikuli_TestProject_OpenNotePad\\libs\\enterProgramname.PNG");

		notepad = new Pattern("D:\\amit\\Java_programs\\Sikuli_TestProject_OpenNotePad\\libs\\notepad\\notepad.PNG");
		notepadSheet = new Pattern(
				"D:\\amit\\Java_programs\\Sikuli_TestProject_OpenNotePad\\libs\\notepad\\notepadSheet.PNG");
		fileOption = new Pattern(
				"D:\\amit\\Java_programs\\Sikuli_TestProject_OpenNotePad\\libs\\notepad\\fileOption.PNG");
		save = new Pattern("D:\\amit\\Java_programs\\Sikuli_TestProject_OpenNotePad\\libs\\notepad\\save.PNG");
		saveWith = new Pattern("D:\\amit\\Java_programs\\Sikuli_TestProject_OpenNotePad\\libs\\notepad\\saveWith.PNG");
		continueWith = new Pattern(
				"D:\\amit\\Java_programs\\Sikuli_TestProject_OpenNotePad\\libs\\notepad\\continue.PNG");

		saveButton = new Pattern("D:\\amit\\Java_programs\\Sikuli_TestProject_OpenNotePad\\libs\\saveButton.PNG");
	}

	/* open notepad */
	@Test
	public void openNotepad() throws FindFailed {

		System.out.println("-----> Executing test");

		/* clicking start button */
		screen.click(start);

		/* typing notepad in search programs and files */
		screen.type(epn, "notepad");

		/* clicking searched notepad */
		screen.click(notepad);

		/* typing string to opened notepad */
		screen.type(notepadSheet, "writing into notepad");
		screen.type(notepadSheet, "\t" + "use of enter key and using paste function! ");
		screen.type(notepadSheet, Key.ENTER);
		screen.paste("You can also use paste function to paste anything into the area you want.");

		/* clicking file option to save the notepad */
		screen.click(fileOption);

		/* clicking save button */
		screen.click(save);

		/* clicking text box to enter the file name */
		screen.click(saveWith);
		screen.type("A", Key.CTRL);
		screen.type(Key.BACKSPACE);
		screen.type(saveWith, "save_with_any_name_you_want");

		/* clicking save button */
		screen.click(saveButton);

		/*
		 * code for checking if file exists with same name try { if
		 * (screen.click(continueWith) == 1) { screen.click(continueWith); } } catch
		 * (Exception exception) { throw (exception); }
		 */
	}

	@AfterTest
	public void end() {
		System.out.println("-----> Test completed");
	}
}
