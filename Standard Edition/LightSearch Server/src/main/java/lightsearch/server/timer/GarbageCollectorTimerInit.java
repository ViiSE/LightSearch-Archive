/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lightsearch.server.timer;

/**
 *
 * @author ViiSE
 */
public class GarbageCollectorTimerInit {
    
    public static GarbageCollectorTimer garbageCollectorTimer() {
        return new GarbageCollectorTimerDefaultImpl();
    }
}
