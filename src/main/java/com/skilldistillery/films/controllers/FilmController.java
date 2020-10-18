package com.skilldistillery.films.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.dao.DatabaseAccessor;
import com.skilldistillery.film.entities.Film;

@Controller
public class FilmController {
	@Autowired
	private DatabaseAccessor db;

	@RequestMapping(path = "index.do")
	public String index() {
		return "WEB-INF/home.jsp";
	}

	@RequestMapping(path = "findFilmByID.do", params = "filmId", method = RequestMethod.GET)
	public ModelAndView filmByID(@RequestParam("filmId") Integer a) {
		ModelAndView mv = new ModelAndView();
		Film f;
		try {
			f = db.findFilmById(a);
			mv.addObject("film", f);
			mv.setViewName("WEB-INF/filmByIDForm.jsp");
		} catch (Exception e) {
			mv.setViewName("WEB-INF/filmByIDForm.jsp");
//			e.printStackTrace();
		}
		return mv;
	}

	@RequestMapping(path = "createFilm.do", method = RequestMethod.POST)
	public ModelAndView addFilm(Film film) {
		ModelAndView mv = new ModelAndView();
		try {
			db.createFilm(film);
			mv.setViewName("WEB-INF/addFilm.jsp");
		} catch (Exception e) {
			mv.setViewName("WEB-INF/addFilm.jsp");
//			e.printStackTrace();
		}
		return mv;
	}

	@RequestMapping(path = "deleteFilm.do", params = "filmIdDelete", method = RequestMethod.GET)
	public ModelAndView deleteFilm(@RequestParam("filmIdDelete") Integer a) {
		ModelAndView mv = new ModelAndView();
		db.deleteFilm(a);
		mv.setViewName("WEB-INF/home.jsp");
		return mv;
	}

	@RequestMapping(path = "saveFilm.do", method = RequestMethod.GET)
	public ModelAndView updateFilm() {
		ModelAndView mv = new ModelAndView();
		// TODO Might need change.
//		Film f = db.updateFilm();
		mv.setViewName("WEB-INF/home.jsp");
		return mv;
	}
}