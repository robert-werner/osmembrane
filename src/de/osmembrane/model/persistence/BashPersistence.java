package de.osmembrane.model.persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import java.util.Observable;

import de.osmembrane.Application;
import de.osmembrane.exceptions.ControlledException;
import de.osmembrane.exceptions.ExceptionSeverity;
import de.osmembrane.model.parser.IParser;
import de.osmembrane.model.parser.ParseException;
import de.osmembrane.model.parser.ParserFactory;
import de.osmembrane.model.persistence.FileException.Type;
import de.osmembrane.model.pipeline.AbstractFunction;

/**
 * Writes and Reads Bash-Files (normally used on UNIX systems).
 * 
 * @author jakob_jarosch
 */
public class BashPersistence extends AbstractPersistence {

	private static final Class<? extends IParser> PARSER =  FileType.BASH.getParserClass();

	@Override
	public void save(URL filename, Object data) throws FileException {
		if (!(data instanceof List<?>)) {
			Application.handleException(new ControlledException(this,
					ExceptionSeverity.UNEXPECTED_BEHAVIOR,
					"BashPersistence#save() got a wrong"
							+ " object, object is the following instance:\n"
							+ data.getClass()));
		}

		try {
			File file = new File(filename.toString());
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);

			@SuppressWarnings("unchecked")
			String output = ParserFactory.getInstance().getParser(PARSER)
					.parsePipeline((List<AbstractFunction>) data);

			bw.write(output);
			bw.close();
			fw.close();

		} catch (IOException e) {
			throw new FileException(Type.NOT_WRITABLE, e);
		}
	}

	@Override
	public Object load(URL filename) throws FileException {
		try {
			InputStreamReader isr = new InputStreamReader(filename.openStream());
			BufferedReader br = new BufferedReader(isr);

			StringBuilder fileContent = new StringBuilder();
			String line;
			while ((line = br.readLine()) != null) {
				fileContent.append(line);
			}
			br.close();
			isr.close();

			List<AbstractFunction> functions = ParserFactory.getInstance()
					.getParser(PARSER).parseString(fileContent.toString());

			return functions;

		} catch (FileNotFoundException e) {
			throw new FileException(Type.NOT_FOUND, e);
		} catch (IOException e) {
			throw new FileException(Type.NOT_READABLE, e);
		} catch (ParseException e) {
			throw new FileException(Type.SYNTAX_PROBLEM, e);
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		return;
	}
}