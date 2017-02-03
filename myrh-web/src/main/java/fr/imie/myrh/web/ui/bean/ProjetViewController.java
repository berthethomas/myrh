package fr.imie.myrh.web.ui.bean;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.imie.myrh.dao.ifc.IProjetDAO;
import fr.imie.myrh.dao.impl.ProjetDAOImpl;
import fr.imie.myrh.dao.model.Projet;

@ManagedBean(name = "projetViewController")
@SessionScoped
public class ProjetViewController implements Serializable {

	private static final long serialVersionUID = -3509727654835269071L;

	Logger log = Logger.getLogger("ProjetViewController");

	private List<Projet> projetItems;
	private Projet projet;

	private final IProjetDAO _projetDaoService = new ProjetDAOImpl();

	@ManagedProperty(value = "#{projet}")
	private ProjetForm projetform;

	public ProjetForm getProjetform() {
		return projetform;
	}

	public void setProjetform(ProjetForm projetform) {
		this.projetform = projetform;
	}

	@PostConstruct
	public void init() {
		// log.log(Level.INFO, "hello");
		projetItems = (List<Projet>) _projetDaoService.findAll();

	}

	public List<Projet> getProjetItems() {
		return projetItems;
	}

	public void setProjetItems(List<Projet> projetItems) {
		this.projetItems = projetItems;
	}

	public String addProjet() {
		log.log(Level.INFO, "ADDPROJET");
		Projet model = new Projet();
		model.setCode(projetform.getCode());
		model.setDate_debut(projetform.getDate_debut());
		model.setDate_fin(projetform.getDate_fin());
		model.setDescription(projetform.getDescription());

		_projetDaoService.createProjet(model);

		return "success";
	}

	public void removeProjet(Long id) {

		// System.out.println(id);
		log.log(Level.INFO, "hello " + id);

		projet = _projetDaoService.findById(id);
		log.log(Level.INFO, "hello " + projet.getCode());

		_projetDaoService.deleteProjet(projet);

		projet = _projetDaoService.findById(id);
		log.log(Level.INFO, "hello3 " + projet.getCode());

	}

	public void generateFormProjet(Long id) {

		projet = _projetDaoService.findById(id);

		projetform.setId(id);
		projetform.setCode(projet.getCode());
		projetform.setDate_debut(projet.getDate_debut());
		projetform.setDate_fin(projet.getDate_fin());
		projetform.setDescription(projet.getDescription());

	}

	public String updateProjet(ProjetForm projetForm) {

		projet = _projetDaoService.findById(projetForm.getId());

		projet.setCode(projetform.getCode());
		projet.setDate_debut(projetform.getDate_debut());
		projet.setDate_fin(projetform.getDate_fin());
		projet.setDescription(projetform.getDescription());

		_projetDaoService.updateProjet(projet);
		// FacesContext.getCurrentInstance().getViewRoot().getViewMap().remove(departementForm);

		return "success";
	}

}
