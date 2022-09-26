package com.saraya.springBootJPA.controller.copy;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public class TeamController {
	
	
	@PostMapping("")
	public String createTeam() {
		return "redirect:/teams";
	}
	@GetMapping()
	public String getOneTeam(@PathVariable Integer id ) {
		return "teams/details";
	}
	
	@GetMapping("/{id}/edit")
	public String editFormTeam(@PathVariable Integer id ) {
		return "teams/form-teams";
	}

}
