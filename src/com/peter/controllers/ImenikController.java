package com.peter.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.peter.models.Zaposleni;
import com.peter.models.ZaposleniDAO;

/**
 * @author peter
 * Controller class with a method for every HTTP Request, which provides our jsp Views 
 * from /Imenik/WebContent/WEB-INF/jsps/ with content obtained from ZaposleniDAO. 
 */
@Controller
public class ImenikController {
	ApplicationContext context = new ClassPathXmlApplicationContext(
			"/com/peter/config/deo-context.xml");
	private ZaposleniDAO zaposleniDAO = context.getBean("zaposleniDAO",
			ZaposleniDAO.class);

	/**
	 * @param model
	 * @return index.jsp
	 * Added list of all employees to the model, which can be accessed from view.
	 */
	@RequestMapping("/")
	public String showImenik(Model model) {
		List<Zaposleni> zaposleniList = zaposleniDAO.getAllZaposleni();
		model.addAttribute("zaposleniList", zaposleniList);
		return "index";
	}

	/**
	 * @param model
	 * @param id
	 * @return
	 * This HTTP Request is given with the parameter. The parameter is an id of a record which is deleted. 
	 * Afterwards redirection to showImenik is made. 
	 */
	@RequestMapping(value = "/izbrisi", params = "id")
	public String deleteZaposleni(Model model, @RequestParam("id") Long id) {
		zaposleniDAO.deleteById(id);
		return "redirect:/";
	}

	/**
	 * @param model
	 * @return
	 * New employee is being saved in model, which will be displayed in form of edit.jsp.
	 */
	@RequestMapping(value = "/dodaj", method = RequestMethod.GET)
	public String newZaposleni(Model model) {
		model.addAttribute("zaposleni", new Zaposleni());
		return "edit";
	}
	
	/**
	 * @param model
	 * @param id
	 * @return
	 * Selected employee is being saved in model, which will be displayed in form of edit.jsp.
	 */
	@RequestMapping(value = "/popravi", params = "id", method = RequestMethod.GET)
	public String editZaposleni(Model model, @RequestParam("id") Long id) {
		Zaposleni zaposleni = zaposleniDAO.findById(id);
		model.addAttribute("zaposleni", zaposleni);
		return "edit";
	}

	/**
	 * @param model
	 * @param zaposleni
	 * @param result
	 * @return
	 * If form completion doesn't pass thru object validation, then errors are displayed.
	 * If form completion is valid, the employee is saved or edited, and redirection to list page is made. 
	 */
	@RequestMapping(value = "/dodaj", method = RequestMethod.POST)
	public String saveNewZaposleni(Model model, @Valid Zaposleni zaposleni,
			BindingResult result) {
		if (result.hasErrors()) {
			return "edit";
		}
		zaposleniDAO.create(zaposleni);

		return "redirect:/";
	}


}
