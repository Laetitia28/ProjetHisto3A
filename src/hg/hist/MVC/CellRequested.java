package hg.hist.MVC;

public class CellRequested {

	private String name;
	private boolean isSelected;
	private double areaSup;
	private double areaInf;
	private double sphericitySup;
	private double sphericityInf;
	private double borderSup;
	private double borderInf;
	private String neighbourhood;

	public CellRequested() {
		super();
	}
	
	public CellRequested(String name, boolean isSelected, double areaSup,
			double areaInf, double sphericitySup, double sphericityInf,
			double borderSup, double borderInf , String neighbourhood) {
		super();
		this.name = name;
		this.isSelected = isSelected;
		this.areaSup = areaSup;
		this.areaInf = areaInf;
		this.sphericitySup = sphericitySup;
		this.sphericityInf = sphericityInf;
		this.borderSup = borderSup;
		this.borderInf = borderInf;
		this.borderInf = borderInf;
		this.neighbourhood =  neighbourhood;
	}




	
	@Override
	public String toString() {
		return "CellRequested [name=" + name + ", isSelected=" + isSelected
				+ ", areaSup=" + areaSup + ", areaInf=" + areaInf
				+ ", sphericitySup=" + sphericitySup + ", sphericityInf="
				+ sphericityInf + ", borderSup=" + borderSup + ", borderInf="
				+ borderInf + ", neighbourhood=" + neighbourhood + "]";
	}

	public String toShow() {
		return "name=" + name +", areaSup=" + areaSup + ", areaInf=" + areaInf
				+ ", sphericitySup=" + sphericitySup + ", sphericityInf="
				+ sphericityInf + ", borderSup=" + borderSup + ", borderInf="
				+ borderInf + "neighbourhood="+ neighbourhood + "]";
	}
	public String getNeighbourhood() {
		return neighbourhood;
	}

	public void setNeighbourhood(String neighbourhood) {
		this.neighbourhood = neighbourhood;
	}
	
	public double getAreaSup() {
		return areaSup;
	}

	public void setAreaSup(double areaSup) {
		this.areaSup = areaSup;
	}

	public double getAreaInf() {
		return areaInf;
	}

	public void setAreaInf(double areaInf) {
		this.areaInf = areaInf;
	}

	public double getSphericitySup() {
		return sphericitySup;
	}

	public void setSphericitySup(double sphericitySup) {
		this.sphericitySup = sphericitySup;
	}

	public double getSphericityInf() {
		return sphericityInf;
	}

	public void setSphericityInf(double sphericityInf) {
		this.sphericityInf = sphericityInf;
	}

	public double getBorderSup() {
		return borderSup;
	}

	public void setBorderSup(double borderSup) {
		this.borderSup = borderSup;
	}

	public double getBorderInf() {
		return borderInf;
	}

	public void setBorderInf(double borderInf) {
		this.borderInf = borderInf;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isSelected() {
		return isSelected;
	}
	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}
	
}
