package hg.hist.MVC;

import hg.histo.CellRequested;

import java.util.ArrayList;
import java.util.List;

public class ControllerRequest {
	private List<CellRequested> listRequested = new ArrayList<CellRequested>();
	
	
	private double default_AreaSup;
	private double default_AreaInf;
	private double default_SphericitySup;
	private double default_SphericityInf;
	private double default_BorderSup ;
	private double default_BorderInf ;
	
	
	

	
	
	public ControllerRequest() {
		super();
		this.listRequested = new ArrayList<CellRequested>();
		 default_AreaSup = 0;
		 default_AreaInf = 0;
		 default_SphericitySup = 0;
		  default_SphericityInf = 0;
		  default_BorderSup = 0 ;
		  default_BorderInf  = 0;
	}


	public List<CellRequested> getListRequested() {
		return listRequested;
	}
	public void setListRequested(List<CellRequested> listRequested) {
		this.listRequested = listRequested;
	}
	public double getDefault_AreaSup() {
		return default_AreaSup;
	}
	public void setDefault_AreaSup(double default_AreaSup) {
		this.default_AreaSup = default_AreaSup;
	}
	public double getDefault_AreaInf() {
		return default_AreaInf;
	}
	public void setDefault_AreaInf(double default_AreaInf) {
		this.default_AreaInf = default_AreaInf;
	}
	public double getDefault_SphericitySup() {
		return default_SphericitySup;
	}
	public void setDefault_SphericitySup(double default_SphericitySup) {
		this.default_SphericitySup = default_SphericitySup;
	}
	public double getDefault_SphericityInf() {
		return default_SphericityInf;
	}
	public void setDefault_SphericityInf(double default_SphericityInf) {
		this.default_SphericityInf = default_SphericityInf;
	}
	public double getDefault_BorderSup() {
		return default_BorderSup;
	}
	public void setDefault_BorderSup(double default_BorderSup) {
		this.default_BorderSup = default_BorderSup;
	}
	public double getDefault_BorderInf() {
		return default_BorderInf;
	}
	public void setDefault_BorderInf(double default_BorderInf) {
		this.default_BorderInf = default_BorderInf;
	}
	

}
