package kr.ac.hansung.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.hansung.model.Offer;
import kr.ac.hansung.service.OfferService;

@Controller
public class OfferController {
	
	@Autowired
	private OfferService offerService;
	
	@RequestMapping("/offers")
	public String showOffers(Model model) {
		List<Offer> offers = offerService.getCurrent();
		model.addAttribute("offers", offers);
		
		return "offers";
	}
	
	@RequestMapping("/createoffer")
	public String createOffer(Model model) {
		
		model.addAttribute("offer", new Offer());
		
		return "createoffer";
	}
	
	@RequestMapping("/createoffer1")
	public String createOffer1(Model model) {
		
		List<Offer> offers = offerService.getCurrent();
		model.addAttribute("offers", offers);
		
		return "createoffer1";
	}
	
	@RequestMapping("/createoffer2")
	public String createOffer2(Model model) {
		
		List<Offer> offers = offerService.getCurrent();
		model.addAttribute("offers", offers);
		
		return "createoffer2";
	}
	
	@RequestMapping("/createoffer3")
	public String createOffer3(Model model) {
		
		List<Offer> offers = offerService.getCurrent();
		model.addAttribute("offers", offers);
		
		return "createoffer3";
	}
	
	@RequestMapping("/docreate")
	public String doCreate(Model model, @Valid Offer offer, BindingResult result) {
		
		if(result.hasErrors()) {
			System.out.println("===Form data dose not validated");
			List<ObjectError> errors = result.getAllErrors();
			for(ObjectError error:errors) {
				System.out.println(error.getDefaultMessage());
			}
			
			return "createoffer";
		}
		
		offerService.insert(offer);
		
		return "offercreated";
	}
	
}
