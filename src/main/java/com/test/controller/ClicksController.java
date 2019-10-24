package com.test.controller;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.service.ClicksService;
import com.test.utils.R;

public class ClicksController {

	@Autowired
	private ClicksService clicksService;

	@RequestMapping("/deleteSome")
	public void deleteSome(ServletRequest request, ServletResponse response) throws IOException {
		PrintWriter printWriter = response.getWriter();
		String ids = request.getParameter("clickIds");
		String[] clickIds = ids.split(",");
		Boolean flag = false;
		for (int i = 0; i < clickIds.length; i++) {
			Boolean delete = clicksService.deleteById(Integer.parseInt(clickIds[i]));
			if (delete) {
				flag = true;
			} else {
				flag = false;
			}
		}

		R r = R.modify(flag);

		String json = gson.toJson(r);
		printWriter.print(json);
	}
}
