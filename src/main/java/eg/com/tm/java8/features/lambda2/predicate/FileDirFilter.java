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
package eg.com.tm.java8.features.lambda2.predicate;

import java.io.IOException;
import static java.lang.System.currentTimeMillis;
import static java.lang.System.out;
import java.nio.file.DirectoryStream;
import static java.nio.file.Files.getAttribute;
import static java.nio.file.Files.isDirectory;
import static java.nio.file.Files.isHidden;
import static java.nio.file.Files.newDirectoryStream;
import static java.nio.file.LinkOption.NOFOLLOW_LINKS;
import java.nio.file.Path;
import static java.nio.file.Paths.get;
import java.nio.file.attribute.FileTime;
import static java.nio.file.attribute.FileTime.fromMillis;
import static java.util.concurrent.TimeUnit.DAYS;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;

/**
 *
 * @author mohamed_taman
 */
public class FileDirFilter {

    private static final Path path = get("src/main", "resources", "eg/com/tm/java8/features/lambda2");

    private static final Logger logger = getLogger(FileDirFilter.class.getName());

    private static void predicateInInnerClass() {

        Predicate<Path> dirsFilter = new Predicate<Path>() {

            @Override
            public boolean test(Path t) {
                return isDirectory(t, NOFOLLOW_LINKS);
            }
        };

        try (DirectoryStream<Path> dirStream = newDirectoryStream(path)) {
            for (Path file : dirStream) {
                if (dirsFilter.test(file)) {
                    out.println(file.getFileName());
                }
            }
        }
        catch (IOException ex) {
            logger.log(Level.SEVERE, null, ex);
        }

    }

    private static void predicateWithLambda() {

        Predicate<Path> noFilter = (p) -> true;

        logger.info("All Path contents");
        doFilterAndPrintPath(noFilter);
        out.println("--------------------------------------------");

        logger.info("Print dirs only");
        
        doFilterAndPrintPath((p) -> isDirectory(p, NOFOLLOW_LINKS));
        
        out.println("--------------------------------------------");

        Predicate<Path> hiddenFilter = (p) -> {
            boolean hidden = false;
            try {
                hidden = isHidden(p);
            }
            catch (IOException e) {
            }
            return hidden;
        };

        logger.info("Print hidden files/dirs only");
        doFilterAndPrintPath(hiddenFilter);
        out.println("--------------------------------------------");

        Predicate<Path> timeFilter = (p) -> {
            
            long currentTime = 0, modifiedTime = 0;
         
            try {
                currentTime = fromMillis(currentTimeMillis()).to(DAYS);
                modifiedTime = ((FileTime) getAttribute(p, "basic:lastModifiedTime",
                        NOFOLLOW_LINKS)).to(DAYS);

            }
            catch (IOException e) {
            }
            
            return currentTime == modifiedTime;
        };

        logger.info("Print today modified files/dirs only");
        
        doFilterAndPrintPath(timeFilter);
        
        logger.info("--------------------------------------------");

    }

    private static void doFilterAndPrintPath(Predicate<Path> pred) {
        try {
            newDirectoryStream(path).forEach(p -> {
                if (pred.test(p)) {
                    out.println(p.getFileName());
                }
            });
        }
        catch (IOException ex) {
            logger.log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        predicateInInnerClass();
        
        predicateWithLambda();

    }

}
