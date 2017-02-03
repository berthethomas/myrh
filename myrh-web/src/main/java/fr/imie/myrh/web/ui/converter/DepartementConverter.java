package fr.imie.myrh.web.ui.converter;

import fr.imie.myrh.dao.model.Departement;
import fr.imie.myrh.web.ui.bean.DepartementViewController;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@FacesConverter("departementConverter")
public class DepartementConverter implements Converter {

	Logger log = Logger.getLogger("DepartementConverter");

	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		if (value != null && value.trim().length() > 0) {
			try {
				DepartementViewController service = (DepartementViewController) fc.getExternalContext()
						.getApplicationMap().get("departementViewController");
				return service.getDepartementItems().get(Integer.parseInt(value));
			} catch (NumberFormatException e) {
				throw new ConverterException(
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
			}
		} else {
			return null;
		}
	}

	public String getAsString(FacesContext fc, UIComponent uic, Object object) {
		if (object != null) {
			return String.valueOf(((Departement) object).getId());
		} else {
			return null;
		}
	}
}