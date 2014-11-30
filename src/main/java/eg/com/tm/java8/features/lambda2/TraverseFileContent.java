/*
 * Copyright (C) 2014 mohamed_taman
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package eg.com.tm.java8.features.lambda2;

import java.io.IOException;
import static java.lang.System.out;
import static java.nio.file.Files.exists;
import static java.nio.file.Files.readAllLines;
import static java.nio.file.LinkOption.NOFOLLOW_LINKS;
import java.nio.file.Path;
import static java.nio.file.Paths.get;
import java.util.Iterator;
import java.util.List;
import static java.util.logging.Level.SEVERE;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;

/**
 *
 * @author mohamed_taman
 */
public class TraverseFileContent {

    private static final Logger logger = getLogger(TraverseFileContent.class.getName());

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {

            Path path = get("src/main", "resources", "data.txt");

            if (exists(path, NOFOLLOW_LINKS)) {

                logger.config(path.toAbsolutePath().toString());

                List<String> lines = readAllLines(path);

                // Traversing with for each
                for (String line : lines)
                    out.println(line);
                
                // Traversing with iterator
                Iterator<String> itr = lines.iterator();

                while (itr.hasNext())
                    out.println(itr.next());
                
                //------------------------------------
                // Traversing with lambda new forEach
                lines.forEach(line -> out.print(line));

                // or with streams
                lines.stream().forEach(line -> out.print(line));

            } else {

                logger.log(SEVERE, "{0} , Doesn't exists", path.toAbsolutePath());
            }
        }
        catch (IOException ex) {
            logger.severe(ex.getMessage());
        }
    }
}
