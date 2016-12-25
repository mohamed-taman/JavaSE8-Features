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
package eg.com.tm.java8.features.nashorn;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 *
 * @author mohamed_taman
 */
public class JSFromFile {

    public static void main(String[] args) throws FileNotFoundException {

        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("nashorn");

        File f = new File("src/main/resources/scripts/readurl.js");
        Reader reader = new FileReader(f);

        String result;
        try {
            result = (String) engine.eval(reader);
            System.out.println(result);
        }
        catch (ScriptException e) {
            System.out.println("There was a JavaScript error");
        }

    }

}
