package com.skilldistillery.films.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.dao.DatabaseAccessor;
import com.skilldistillery.film.entities.Film;

@Controller
public class FilmController {
	private DatabaseAccessor db;

	@RequestMapping(path = "index.do", method = RequestMethod.GET)
	public ModelAndView filmByID() {
		ModelAndView mv = new ModelAndView();
		// TODO Might need change.
//		Film f = db.getFilmByID(id);
		mv.setViewName("WEB-INF/home.jsp");
		return mv;
	}

//	@RequestMapping(path = "index.do", method = RequestMethod.GET)
//	public ModelAndView addFilm() {
//		ModelAndView mv = new ModelAndView();
//		// TODO Might need change.
//		Film f = db.createFilm();
//		mv.setViewName("WEB-INF/home.jsp");
//		return mv;
//	}
//
//	@RequestMapping(path = "index.do", method = RequestMethod.GET)
//	public ModelAndView deleteFilm() {
//		ModelAndView mv = new ModelAndView();
//		// TODO Might need change.
//		Film f = db.deleteFilm();
//		mv.setViewName("WEB-INF/home.jsp");
//		return mv;
//	}
//
//	@RequestMapping(path = "index.do", method = RequestMethod.GET)
//	public ModelAndView updateFilm() {
//		ModelAndView mv = new ModelAndView();
//		// TODO Might need change.
//		Film f = db.updateFilm();
//		mv.setViewName("WEB-INF/home.jsp");
//		return mv;
//	}
}