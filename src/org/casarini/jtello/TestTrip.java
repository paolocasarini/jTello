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
package org.casarini.jtello;

import java.util.concurrent.TimeUnit;

public class TestTrip {

    public static void main(String args[]) throws Exception {
        System.out.println("Tello trip test...");
        
        Tello tello = new Tello();
        tello.connect();
        tello.init();
        TimeUnit.SECONDS.sleep(1);
        
        tello.takeOff();
        TimeUnit.SECONDS.sleep(5);
        
        tello.rotate(90);
        tello.rotate(-180);
        tello.up(20);
        tello.down(20);
        tello.right(20);
        tello.left(20);
        tello.forward(20);
        tello.back(20);
        TimeUnit.SECONDS.sleep(1);
        
        tello.land();
        TimeUnit.SECONDS.sleep(1);
        
        tello.disconnect();
        
    }
}