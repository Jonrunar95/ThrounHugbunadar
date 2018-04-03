/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.SearchController.search;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Notandi
 */
public class SearchControllerTest {
    
    public SearchControllerTest() {
    }

    /**
     * Test of search method, of class SearchController.
     */
    @Test
    public void testSearch() {
        boolean[] boxes = {false,false,false,false,false,false,false,false,false,false};
        search(boxes, "Hótel");
    }
    
}
