/*
 * Copyright (C) 2016 mohamed_taman
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
package eg.com.tm.java8.features.miscellaneous;

import java.nio.file.Files;
import java.nio.file.Path;
import static java.nio.file.Paths.get;
import java.util.Optional;
import java.util.stream.Stream;

/**
 *
 * @author mohamed_taman
 */
public class SearchFile {
    
    public static void main(String[] args) {
		
		Path path = get("src/main", "resources","files", "hamlet.txt");
		
                String searchTerm = "To be, or not to be";
		
		try (Stream<String> lines = Files.lines(path)) {
			
			Optional<String> line = lines.filter(l -> l.contains(searchTerm)).findFirst();
			if (line.isPresent()) {
				System.out.println("Found: " + line.get());
			} else {
				System.out.println("Not found");
			}
			
		} catch (Exception e) {
			System.out.println("There was an error: " + e.getMessage());
		}
		
	}		
    
}
