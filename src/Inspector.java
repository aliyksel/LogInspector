import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alyuksel.builder.AfterDateCmdBuilder;
import com.alyuksel.builder.Builder;
import com.alyuksel.builder.FileCmdBuilder;
import com.alyuksel.builder.SearchCmdBuilder;
import com.commands.AfterDateCmd;
import com.commands.Command;
import com.commands.FileCommand;

public class Inspector {

	static List<Builder> buildList = new ArrayList<Builder>();

	public static void main(String[] args) {

		buildList.add(new SearchCmdBuilder());
		buildList.add(new AfterDateCmdBuilder());

		List<Command> cmdList = new ArrayList<Command>();

		String output = null;

		try {
			String[] arg;
			for (int i = 0; i < args.length; i++) {
				arg = args[i].split("=");
				if (arg[0].equals("output")) {
					output = arg[1];
				}
			}

			for (Builder build : buildList) {
				build.build(args, cmdList);
			}

			FileCommand fileCmd = new FileCmdBuilder().build(args);

			PrintStream writer = new PrintStream(output);

			String line;
			boolean b;
			while ((line = fileCmd.getLine()) != null) {
				try {
					b = true;
					for (Command cmd : cmdList) {
						if (!cmd.execute(line)) {
							b = false;
							break;
						}
					}
					if (b) {
						writer.print(fileCmd.getFileName());
						writer.print("|");
						writer.println(line);
					}
				} catch (Exception e) {
					System.out.println(line);
					e.printStackTrace();
				}

			}

			writer.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
