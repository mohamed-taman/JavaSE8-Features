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
package eg.com.tm.java8.features.lambda2.mthdRefs;

import java.io.IOException;
import static java.lang.System.out;
import java.nio.file.Files;
import static java.nio.file.Files.exists;
import static java.nio.file.Files.newDirectoryStream;
import static java.nio.file.Files.notExists;
import java.nio.file.LinkOption;
import static java.nio.file.LinkOption.NOFOLLOW_LINKS;
import java.nio.file.Path;
import static java.nio.file.Paths.get;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;

/**
 *
 * @author mohamed_taman
 */
public class MethodReference {

    private static final Path path = get("src/main", "resources",
                                         "eg/com/tm/java8/features/lambda2");

    private static final Logger logger = getLogger(MethodReference.class.getName());

    private void doFilterAndPrintPath(Predicate<Path> pred) {
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

    private void doPrint() {

        // Static method reference
        doFilterAndPrintPath(FilesDirTests::isAccessible);

        // Instance method reference
        doFilterAndPrintPath(this::isNotExists);

    }

    private boolean isNotExists(Path p) {
        return notExists(p, new LinkOption[]{NOFOLLOW_LINKS});
    }

    private boolean isExists(Path p) {
        return exists(p, new LinkOption[]{NOFOLLOW_LINKS});
    }

    public static void main(String[] args) {

        MethodReference mr = new MethodReference();

        mr.doFilterAndPrintPath(mr::isExists);

        mr.doPrint();

    }

}
