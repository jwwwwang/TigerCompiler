package Parse;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;



public class CupTest {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		String filename = "E:\\java_workspace\\tCompiler\\src\\Testcases\\Official\\Good\\queens.tig";
		ErrorMsg.ErrorMsg errorMsg = new ErrorMsg.ErrorMsg(filename);
		InputStream inp = new FileInputStream(filename);
		Yylex lexer = new Yylex(inp, errorMsg);
		Grm p = new Grm(lexer, errorMsg);
		try {
			p.debug_parse();
	          Absyn.Print printer =new Absyn.Print(System.out);
	          printer.prExp(p.parseResult,0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
