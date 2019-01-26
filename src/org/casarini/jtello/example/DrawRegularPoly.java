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
package org.casarini.jtello.example;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.casarini.jtello.Tello;

public class DrawRegularPoly {

    public static void main(String args[]) throws Exception {
        System.out.println("Tello draw regular poly...");
        
        Tello tello = new Tello();
        tello.connect();
        tello.init();
        TimeUnit.SECONDS.sleep(1);
        
        tello.takeOff();
        TimeUnit.SECONDS.sleep(5);

        drawRegularPoly(tello, 5, 40);
        TimeUnit.SECONDS.sleep(1);
        
        tello.land();
        TimeUnit.SECONDS.sleep(1);
        
        tello.disconnect();
        
    }
    
    public static void drawRegularPoly(Tello tello, int sides, int length) throws IOException {
    	for (int i = 0; i < sides; i++) {
    		tello.forward(length);
    		tello.rotate(360 / sides);
    	}
    }
}
