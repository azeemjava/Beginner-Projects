package in.tritonlabs.templates.service;

import java.util.List;
import java.util.Optional;
import in.tritonlabs.templates.entity.Templates;
import in.tritonlabs.templates.request.TemplatesRequest;

public interface ITemplateService {

	public List<Templates> findAll();

	public Optional<Templates> findId(long id);

	public Optional<Templates> create(TemplatesRequest temp);

	public Templates update(Templates temp, long id);

	public String delete(long id);

	public String deleteAll();

}
