package in.tritonlabs.templates.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import in.tritonlabs.templates.entity.Question;
import in.tritonlabs.templates.entity.Templates;
import in.tritonlabs.templates.repository.ITemplatesRepositroy;
import in.tritonlabs.templates.request.TemplatesRequest;
import in.tritonlabs.templates.service.ITemplateService;

@Service
public class TemplatesServiceImpl implements ITemplateService{

	@Autowired
	ITemplatesRepositroy templateRepo;

//--------------------- findAll ----------------------------------

	public List<Templates> findAll() {
		return templateRepo.findAll();
	}

//--------------------- findById ----------------------------------

	public Optional<Templates> findId(long id) {
		if (templateRepo.existsById(id)) {
			return templateRepo.findById(id);
		} else {
			return Optional.empty();
		}
	}

//-------------------------- save  ------------------------------

	public Optional<Templates> create(TemplatesRequest temp) {

		Templates template = new Templates();
		template.setTemplatesName(temp.getTemplatesName());
		template.setTotalMark(temp.getTotalMark());

		List<Question> que = temp.getQuestion();
		Question quest0 = que.get(0);
		Question quest1 = que.get(1);


		quest0.setTemplates(template);
		quest0.setQuestion(quest0.getQuestion());
		quest0.setWeightage(quest0.getWeightage());
		
		quest1.setTemplates(template);
		quest1.setQuestion(quest1.getQuestion());
		quest1.setWeightage(quest1.getWeightage());


		que.add(quest0);
		que.add(quest1);


		template.setQuestion(que);

		if (templateRepo.existsById(template.getId())) {
			return Optional.empty();

		} else {
			return Optional.of(templateRepo.save(template));

		}
	}

//------------------------- update ---------------------------------------

	public Templates update(Templates temp, long id) {

		Optional<Templates> templateFind = templateRepo.findById((long) id);
		Templates templateGet = templateFind.get();
		List<Question> questListTemp = templateGet.getQuestion();
		Question questGetPosition0 = questListTemp.get(0);
		Question questGetPosition1 = questListTemp.get(1);


		long questId0 = questGetPosition0.getId();
		long questId1 = questGetPosition1.getId();


		// This Is Get Question Id In That Same Template id.

		// -----------------------------------------//

		Templates template = new Templates();
		template.setId(id);
		template.setTemplatesName(temp.getTemplatesName());
		template.setTotalMark(temp.getTotalMark());

		List<Question> questList = temp.getQuestion();
		Question quest0 = questList.get(0);
		Question quest1 = questList.get(1);
		
		quest0.setId(questId0);
		quest0.setTemplates(template);
		quest0.setQuestion(quest0.getQuestion());
		quest0.setWeightage(quest0.getWeightage());

		quest1.setId(questId1);
		quest1.setTemplates(template);
		quest1.setQuestion(quest1.getQuestion());
		quest1.setWeightage(quest1.getWeightage());

		
		questList.add(quest0);
		questList.add(quest1);


		template.setQuestion(questList);

		return templateRepo.save(template);

	}

//-------------------- deleteById --------------------------------------------

	public String delete(long id) {
		if (templateRepo.existsById(id)) {
			templateRepo.deleteById(id);
			return "Deleted";
		} else {
			return "Does not record";
		}

	}

//-------------------- deleteAll --------------------------------------------

	public String deleteAll() {

		templateRepo.deleteAll();
		
		return "Deleted All";

	}

//-------------------------------------------------------

}
