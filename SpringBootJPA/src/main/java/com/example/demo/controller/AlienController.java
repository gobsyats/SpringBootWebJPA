package com.example.demo.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.AlienRepo;
import com.example.demo.model.Alien;

//@Controller
@RestController
public class AlienController {

	@Autowired
	AlienRepo repo;
	
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	/*
	@RequestMapping("/addAlien")
	public String addAlien(Alien alien) {
		repo.save(alien);
		return "home.jsp";
	}
	*/
	
	@PostMapping(path = "/alien", consumes = {"application/json"})
	public Alien addAlien(@RequestBody Alien alien) {
		repo.save(alien);
		return alien;
	}
	
	/*
	@RequestMapping("/getAlien")
	public ModelAndView getAlien(@RequestParam int aid) {
		ModelAndView mv = new ModelAndView("showAlien.jsp");
		Alien alien = repo.findById(aid).orElse(new Alien());
		//mv.setViewName("showAlien");
		System.out.println("JAVA tech experts");
		System.out.println(repo.findByTech("JAVA"));
		System.out.println("Emp with ids greater than 102");
		System.out.println(repo.findByAidGreaterThan(102));
		System.out.println("Emp with ids less than 104");
		System.out.println(repo.findByAidLessThan(104));
		System.out.println("sorted by tech");
		System.out.println(repo.findByTechSorted("JAVA"));
		mv.addObject(alien);
		return mv;
	}
	*/
	
	//Rest service - fetch all aliens
	//@RequestMapping(path="/aliens")
	//@ResponseBody //Tell dispatcher service that
	//the returning type is data
	@GetMapping(path="/aliens")
	public List<Alien> getAliens() {
		return repo.findAll();
	}
	
	//Rest service - fetch specific alien
	//@ResponseBody //Tell dispatcher service that
	//the returning type is data
	@RequestMapping("/aliens/{aid}")
	public Optional<Alien> getAlien(@PathVariable("aid") int aid) {
		return repo.findById(aid);
	}
	
	//Rest service - delete specific alien
	@DeleteMapping("/aliens/{aid}")
	public String deleteAlien(@PathVariable int aid) {
		Alien alien = repo.getOne(aid);
		repo.delete(alien);
		return "Alien deleted";
	}
	
	//Rest service - delete specific alien
	@PutMapping(path="/alien", consumes= {"application/json"})
	public Alien saveOrUpdateAlien(@RequestBody Alien alien) {
			repo.save(alien);
			return alien;
		}
	
	
	
}
