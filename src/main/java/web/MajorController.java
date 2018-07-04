package web;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dto.MajorScores;
import service.MajorService;

@Controller
@RequestMapping(value = "/major")
public class MajorController {

	@Autowired
	private MajorService majorService ;
	
	
	@RequestMapping(value = "/commitScores")
	@ResponseBody
	public boolean commitScores(@RequestBody MajorScores majorScores){
		boolean commitSuccess = majorService.commitScores(majorScores);
		System.out.println("commitSuccess:"+commitSuccess);
		
		return commitSuccess ;
	}
	
}
