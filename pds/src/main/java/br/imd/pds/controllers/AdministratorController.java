package br.imd.pds.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.imd.pds.model.Administrator;
import br.imd.pds.service.ManagementAdministratorService;

@Controller
@RequestMapping(value = "/admin")
public class AdministratorController {
	
	@Autowired
	private ManagementAdministratorService managementAdministrator;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getAdministrator(@PathVariable Long id) {
		return "admin/view";
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String listAdministrator(Model model) {
		model.addAttribute("admin", managementAdministrator.listAdministrator());
		return "admin/list";
	}
	
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String administratorForm(Model model) {
		model.addAttribute("admin", new Administrator());
		return "admin/newAdministrator";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String newAdministrator(Administrator administrator) {
		try {
			managementAdministrator.insertAdministrator(administrator);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "admin/list";
	}

}
