package io.permut.controller;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.lang.*;



import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;





@Path("/permut")

public class PermutController {
	
	@GET
	@Path("/{number}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> Permutation(@PathParam("number") String number){
		List<String> permuts = new ArrayList<String>();
		List<String> combos = generateCombos(number);
		
		for (String s : combos) {
			permuts.add(s);
		}
            
        	return permuts;
		
}

	private List<String> generateCombos(String number) {
		 // This will hold the final list of combinations
        List<String> combos = new LinkedList<String>();

        // Call the helper method with an empty prefix and the entire 
        // phone number as the remaining part.
        generateCombosHelper(combos, "", number);
        
        
        return combos;
        
	}

	private void generateCombosHelper(List<String> combos, String prefix, String remaining) {
		// The current digit we are working with
		final String mappings[][] = {
		        {"0"}, {"1"}, {"2","A", "B", "C"}, {"3","D", "E", "F"}, {"4","G", "H", "I"},
		        {"5","J", "K", "L"}, {"6","M", "N", "O"}, {"7","P", "Q", "R", "S"}, 
		        {"8","T", "U", "V"}, {"9","W", "X", "Y", "Z"}
		    };
        int digit = Integer.parseInt(remaining.substring(0, 1));

        if (remaining.length() == 1) {
            // We have reached the last digit in the phone number, so add 
            // all possible prefix-digit combinations to the list
            for (int i = 0; i < mappings[digit].length; i++) {
                combos.add(prefix + mappings[digit][i]);
            }
        } else {
            // Recursively call this method with each possible new 
            // prefix and the remaining part of the phone number.
            for (int i = 0; i < mappings[digit].length; i++) {
                generateCombosHelper(combos, prefix + mappings[digit][i], 
                        remaining.substring(1));
            }
        }

		
	}

}
		
	
        
		
		
		
	

	