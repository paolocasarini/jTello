/**
 *  This file is part of jTello.
 *  
 *  Copyright © 2019 Paolo Casarini <paolo@casarini.org>
 *
 *  jTello is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  jTello is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *  
 *  You should have received a copy of the GNU General Public License
 *  along with jTello.  If not, see <https://www.gnu.org/licenses/>.
 */
package org.casarini.jtello.util;
import java.util.Scanner;

import org.casarini.jtello.Tello;

public class Console {
    
    public static void main(String args[]) throws Exception {
        String command = "";
        String result = "";
        Scanner scanner = new Scanner(System.in, "UTF-8");
        Tello tello = new Tello();
        tello.connect();
        
        while (!"bye".equals(command)) {
            System.out.print("jTello$ ");       
            command = scanner.nextLine();
            
            result = tello.sendCommand(command);
            System.out.println(result);
        }
        scanner.close();
    }
}
