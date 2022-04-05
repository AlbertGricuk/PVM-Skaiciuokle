package lt.ku.pvm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home() {
		return "main";
	}
	
	@PostMapping("/output")
	public String kmi(
			@RequestParam("pavadinimas") String pavadinimas,
			@RequestParam("vieneto_kaina_su_pvm") Double vieneto_kaina_su_pvm,
			@RequestParam("kiekis") Integer kiekis,
			Model model) {
		
		int pvm = 21;
		double vieneto_kaina_be_pvm = Math.round((vieneto_kaina_su_pvm - vieneto_kaina_su_pvm / 100 * 21)*100) / 100.00;
		double vieneto_pvm = Math.round((vieneto_kaina_su_pvm / 100 * 21)*100) / 100.00;
		double bendra_kaina_be_pvm = Math.round((vieneto_kaina_su_pvm - (vieneto_kaina_su_pvm / 100 * 21)) * kiekis * 100) / 100.00;
		double bendras_pvm_kiekis = Math.round((vieneto_kaina_su_pvm / 100 * 21) * kiekis * 100) / 100.00;
		double visa_suma_su_pvm = Math.round(vieneto_kaina_su_pvm * kiekis * 100) / 100.00;
		
		
		model.addAttribute("pavadinimas", pavadinimas);
		model.addAttribute("vieneto_kaina_su_pvm", vieneto_kaina_su_pvm);
		model.addAttribute("kiekis", kiekis);
		model.addAttribute("vieneto_kaina_be_pvm", vieneto_kaina_be_pvm);
		model.addAttribute("vieneto_pvm", vieneto_pvm);
		model.addAttribute("bendra_kaina_be_pvm", bendra_kaina_be_pvm);
		model.addAttribute("bendras_pvm_kiekis", bendras_pvm_kiekis);
		model.addAttribute("visa_suma_su_pvm", visa_suma_su_pvm);
		return "output";
	}
}