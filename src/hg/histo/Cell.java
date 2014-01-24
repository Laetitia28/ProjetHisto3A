package hg.histo;

public class Cell {

		private String scene_name;
		private String scene_id; 
		
		private double scene_ver;
		private double cntrl_tag;
		private double inner_x;
		private double inner_y;
		
		private String level_name;
		private String class_name;
		
		private double  integrated_Intensity;
		private double border_Length;
		private double sphericity;
		private double mean_Layer_1;
		private double mean_Layer_2;
		private double mean_Layer_3;
		private double min_PixelValue_Layer_1;
		private double max_PixelValue_Layer_1;
		private double range_Layer_1;
		
		private double standard_Deviation_Layer_1;
		private double standard_Deviation_Layer_2;
		private double standard_Deviation_Layer_3;
		
		private double hsi_Transformation_Hue;
		private double hsi_Transformation_Saturation;
		private double area_pxl;
		private double border_Lenght_pxl;
		private double ratio_Lenght_Width;
		private double border_Index;
		private double elliptic_Fit;
		
		private double roundness;
		private double shape_Index;
		private double glcm_Homogeneity_quick_8_11_Layer_1_0A;
		private double glcm_Homogeneity_quick_8_11_Layer_2_0A;
		private double glcm_Homogeneity_quick_8_11_Layer_3_0A;
		
		private double glcm_Homogeneity_quick_8_11_Layer_1_45A;
		private double glcm_Homogeneity_quick_8_11_Layer_2_45A;
		private double glcm_Homogeneity_quick_8_11_Layer_3_45A;
		
		private double glcm_Homogeneity_quick_8_11_Layer_1_90A;
		private double glcm_Homogeneity_quick_8_11_Layer_2_90A;
		private double glcm_Homogeneity_quick_8_11_Layer_3_90A;
		
		private double glcm_Homogeneity_quick_8_11_Layer_1_135A;
		private double glcm_Homogeneity_quick_8_11_Layer_2_135A;
		private double glcm_Homogeneity_quick_8_11_Layer_3_135A;
		
		private double x_Center_Pxl;
		private double y_Center_Pxl;

		public Cell(){
			this.scene_name="scene_name";
			this.scene_id="001"; 
			
			this.scene_ver=0;
			this.cntrl_tag = 0;
			this.inner_x = 0;
			this.inner_y = 0;
			
			this.level_name = "level_name";
			this.class_name = "class_name";
			
			this.integrated_Intensity = 0;
			this.border_Length = 0;
			this.sphericity = 0;
			this.mean_Layer_1 = 0;
			this.mean_Layer_2 = 0;
			this.mean_Layer_3 = 0;
			this.min_PixelValue_Layer_1 = 0;
			this.max_PixelValue_Layer_1 = 0;
			this.range_Layer_1 = 0;
			
			this.standard_Deviation_Layer_1 = 0;
			this.standard_Deviation_Layer_2 = 0;
			this.standard_Deviation_Layer_3 = 0;
			
			this.hsi_Transformation_Hue = 0;
			this.hsi_Transformation_Saturation = 0;
			this.area_pxl = 0;
			this.border_Lenght_pxl = 0;
			this.ratio_Lenght_Width = 0;
			this.border_Index = 0;
			this.elliptic_Fit = 0;
			
			this.roundness = 0;
			this.shape_Index = 0;
			this.glcm_Homogeneity_quick_8_11_Layer_1_0A = 0;
			this.glcm_Homogeneity_quick_8_11_Layer_2_0A = 0;
			this.glcm_Homogeneity_quick_8_11_Layer_3_0A = 0;
			
			this.glcm_Homogeneity_quick_8_11_Layer_1_45A = 0;
			this.glcm_Homogeneity_quick_8_11_Layer_2_45A = 0;
			this.glcm_Homogeneity_quick_8_11_Layer_3_45A = 0;
			
			this.glcm_Homogeneity_quick_8_11_Layer_1_90A = 0;
			this.glcm_Homogeneity_quick_8_11_Layer_2_90A = 0;
			this.glcm_Homogeneity_quick_8_11_Layer_3_90A = 0;
			
			this.glcm_Homogeneity_quick_8_11_Layer_1_135A = 0;
			this.glcm_Homogeneity_quick_8_11_Layer_2_135A = 0;
			this.glcm_Homogeneity_quick_8_11_Layer_3_135A = 0;
			
			this.x_Center_Pxl = 0;
			this.y_Center_Pxl = 0;
		}

		public String toString(){
			StringBuffer sb = new StringBuffer("");
			//sb.append("scene_name :" + this.scene_name + "\n");
			//sb.append("scene_id :" + this.scene_id + "\n");
			
			//sb.append("scene_ver :" + this.scene_ver+"\n");
			//sb.append("cntrl_tag :" + this.cntrl_tag+"\n");
			
			//sb.append("inner_x :" + this.inner_x+"\n");
			//sb.append("inner_y :" + this.inner_y+"\n");
			
			sb.append("level_name :" + this.level_name+"\n");
			sb.append("class_name :" + this.class_name+"\n");
			
			//sb.append("integrated_Intensity :" + this.integrated_Intensity+"\n");
			sb.append("border_Length :" + this.border_Length+"\n");
			sb.append("sphericity :" + this.sphericity+"\n");
			/*
			sb.append("mean_Layer_1 :" + this.mean_Layer_1+"\n");
			sb.append("mean_Layer_2 :" + this.mean_Layer_2+"\n");
			sb.append("mean_Layer_3 :" + this.mean_Layer_3+"\n");
			
			sb.append("min_PixelValue_Layer_1 :" + this.min_PixelValue_Layer_1+"\n");
			sb.append("max_PixelValue_Layer_1 :" + this.max_PixelValue_Layer_1+"\n");
			sb.append("range_Layer_1 :" + this.range_Layer_1+"\n");
			
			sb.append("standard_Deviation_Layer_1 :" + this.standard_Deviation_Layer_1+"\n");
			sb.append("standard_Deviation_Layer_2 :" + this.standard_Deviation_Layer_2+"\n");
			sb.append("standard_Deviation_Layer_3 :" + this.standard_Deviation_Layer_3+"\n");
			
			sb.append("hsi_Transformation_Hue :" + this.hsi_Transformation_Hue+"\n");
			sb.append("hsi_Transformation_Saturation :" + this.hsi_Transformation_Saturation+"\n");
			*/
			sb.append("area_pxl :" + this.area_pxl+"\n");
			sb.append("border_Lenght_pxl :" + this.border_Lenght_pxl+"\n");
			/*
			sb.append("ratio_Lenght_Width :" + this.ratio_Lenght_Width+"\n");
			sb.append("border_Index :" + this.border_Index+"\n");
			
			sb.append("elliptic_Fit :" + this.elliptic_Fit+"\n");
			
			sb.append("roundness :" + this.roundness+"\n");
			sb.append("shape_Index :" + this.shape_Index+"\n");
			sb.append("glcm_Homogeneity_quick_8_11_Layer_1_0A :" + this.glcm_Homogeneity_quick_8_11_Layer_1_0A+"\n");
			sb.append("glcm_Homogeneity_quick_8_11_Layer_2_0A :" + this.glcm_Homogeneity_quick_8_11_Layer_2_0A+"\n");
			sb.append("glcm_Homogeneity_quick_8_11_Layer_3_0A :" + this.glcm_Homogeneity_quick_8_11_Layer_3_0A+"\n");
			
			sb.append("glcm_Homogeneity_quick_8_11_Layer_1_45A :" + this.glcm_Homogeneity_quick_8_11_Layer_1_45A+"\n");
			sb.append("glcm_Homogeneity_quick_8_11_Layer_2_45A :" + this.glcm_Homogeneity_quick_8_11_Layer_2_45A+"\n");
			sb.append("glcm_Homogeneity_quick_8_11_Layer_3_45A :" + this.glcm_Homogeneity_quick_8_11_Layer_3_45A+"\n");
			
			sb.append("glcm_Homogeneity_quick_8_11_Layer_1_90A :" + this.glcm_Homogeneity_quick_8_11_Layer_1_90A+"\n");
			sb.append("glcm_Homogeneity_quick_8_11_Layer_2_90A :" + this.glcm_Homogeneity_quick_8_11_Layer_2_90A+"\n");
			sb.append("glcm_Homogeneity_quick_8_11_Layer_3_90A :" + this.glcm_Homogeneity_quick_8_11_Layer_3_90A+"\n");
			
			sb.append("glcm_Homogeneity_quick_8_11_Layer_1_135A :" + this.glcm_Homogeneity_quick_8_11_Layer_1_135A+"\n");
			sb.append("glcm_Homogeneity_quick_8_11_Layer_2_135A :" + this.glcm_Homogeneity_quick_8_11_Layer_2_135A+"\n");
			sb.append("glcm_Homogeneity_quick_8_11_Layer_3_135A :" + this.glcm_Homogeneity_quick_8_11_Layer_3_135A+"\n");
			
			sb.append("x_Center_Pxl :" + this.x_Center_Pxl+"\n");
			sb.append("y_Center_Pxl :" + this.y_Center_Pxl+"\n");
*/
			
			return sb.toString();
		}
		// GETTERS AND SETTERS
		public String getScene_name() {
			return scene_name;
		}

		public void setScene_name(String scene_name) {
			this.scene_name = scene_name;
		}

		public String getScene_id() {
			return scene_id;
		}

		public void setScene_id(String scene_id) {
			this.scene_id = scene_id;
		}

		public double getScene_ver() {
			return scene_ver;
		}

		public void setScene_ver(double scene_ver) {
			this.scene_ver = scene_ver;
		}

		public double getCntrl_tag() {
			return cntrl_tag;
		}

		public void setCntrl_tag(double cntrl_tag) {
			this.cntrl_tag = cntrl_tag;
		}

		public double getInner_x() {
			return inner_x;
		}

		public void setInner_x(double inner_x) {
			this.inner_x = inner_x;
		}

		public double getInner_y() {
			return inner_y;
		}

		public void setInner_y(double inner_y) {
			this.inner_y = inner_y;
		}

		public String getLevel_name() {
			return level_name;
		}

		public void setLevel_name(String level_name) {
			this.level_name = level_name;
		}

		public String getClass_name() {
			return class_name;
		}

		public void setClass_name(String class_name) {
			this.class_name = class_name;
		}

		public double getBorder_Length() {
			return border_Length;
		}

		public void setBorder_Length(double border_Length) {
			this.border_Length = border_Length;
		}

		public double getIntegrated_Intensity() {
			return integrated_Intensity;
		}

		public void setIntegrated_Intensity(double integrated_Intensity) {
			this.integrated_Intensity = integrated_Intensity;
		}

		public double getSphericity() {
			return sphericity;
		}

		public void setSphericity(double sphericity) {
			this.sphericity = sphericity;
		}

		public double getMean_Layer_1() {
			return mean_Layer_1;
		}

		public void setMean_Layer_1(double mean_Layer_1) {
			this.mean_Layer_1 = mean_Layer_1;
		}

		public double getMean_Layer_2() {
			return mean_Layer_2;
		}

		public void setMean_Layer_2(double mean_Layer_2) {
			this.mean_Layer_2 = mean_Layer_2;
		}

		public double getMean_Layer_3() {
			return mean_Layer_3;
		}

		public void setMean_Layer_3(double mean_Layer_3) {
			this.mean_Layer_3 = mean_Layer_3;
		}

		public double getMin_PixelValue_Layer_1() {
			return min_PixelValue_Layer_1;
		}

		public void setMin_PixelValue_Layer_1(double min_PixelValue_Layer_1) {
			this.min_PixelValue_Layer_1 = min_PixelValue_Layer_1;
		}

		public double getMax_PixelValue_Layer_1() {
			return max_PixelValue_Layer_1;
		}

		public void setMax_PixelValue_Layer_1(double max_PixelValue_Layer_1) {
			this.max_PixelValue_Layer_1 = max_PixelValue_Layer_1;
		}

		public double getRange_Layer_1() {
			return range_Layer_1;
		}

		public void setRange_Layer_1(double range_Layer_1) {
			this.range_Layer_1 = range_Layer_1;
		}

		public double getStandard_Deviation_Layer_1() {
			return standard_Deviation_Layer_1;
		}

		public void setStandard_Deviation_Layer_1(double standard_Deviation_Layer_1) {
			this.standard_Deviation_Layer_1 = standard_Deviation_Layer_1;
		}

		public double getStandard_Deviation_Layer_2() {
			return standard_Deviation_Layer_2;
		}

		public void setStandard_Deviation_Layer_2(double standard_Deviation_Layer_2) {
			this.standard_Deviation_Layer_2 = standard_Deviation_Layer_2;
		}

		public double getStandard_Deviation_Layer_3() {
			return standard_Deviation_Layer_3;
		}

		public void setStandard_Deviation_Layer_3(double standard_Deviation_Layer_3) {
			this.standard_Deviation_Layer_3 = standard_Deviation_Layer_3;
		}

		public double getHsi_Transformation_Hue() {
			return hsi_Transformation_Hue;
		}

		public void setHsi_Transformation_Hue(double hsi_Transformation_Hue) {
			this.hsi_Transformation_Hue = hsi_Transformation_Hue;
		}

		public double getArea_pxl() {
			return area_pxl;
		}

		public void setArea_pxl(double area_pxl) {
			this.area_pxl = area_pxl;
		}

		public double getHsi_Transformation_Saturation() {
			return hsi_Transformation_Saturation;
		}

		public void setHsi_Transformation_Saturation(
				double hsi_Transformation_Saturation) {
			this.hsi_Transformation_Saturation = hsi_Transformation_Saturation;
		}

		public double getBorder_Lenght_pxl() {
			return border_Lenght_pxl;
		}

		public void setBorder_Lenght_pxl(double border_Lenght_pxl) {
			this.border_Lenght_pxl = border_Lenght_pxl;
		}

		public double getRatio_Lenght_Width() {
			return ratio_Lenght_Width;
		}

		public void setRatio_Lenght_Width(double ratio_Lenght_Width) {
			this.ratio_Lenght_Width = ratio_Lenght_Width;
		}

		public double getBorder_Index() {
			return border_Index;
		}

		public void setBorder_Index(double border_Index) {
			this.border_Index = border_Index;
		}

		public double getElliptic_Fit() {
			return elliptic_Fit;
		}

		public void setElliptic_Fit(double elliptic_Fit) {
			this.elliptic_Fit = elliptic_Fit;
		}

		public double getRoundness() {
			return roundness;
		}

		public void setRoundness(double roundness) {
			this.roundness = roundness;
		}

		public double getShape_Index() {
			return shape_Index;
		}

		public void setShape_Index(double shape_Index) {
			this.shape_Index = shape_Index;
		}

		public double getGlcm_Homogeneity_quick_8_11_Layer_1_0A() {
			return glcm_Homogeneity_quick_8_11_Layer_1_0A;
		}

		public void setGlcm_Homogeneity_quick_8_11_Layer_1_0A(
				double glcm_Homogeneity_quick_8_11_Layer_1_0A) {
			this.glcm_Homogeneity_quick_8_11_Layer_1_0A = glcm_Homogeneity_quick_8_11_Layer_1_0A;
		}

		public double getGlcm_Homogeneity_quick_8_11_Layer_2_0A() {
			return glcm_Homogeneity_quick_8_11_Layer_2_0A;
		}

		public void setGlcm_Homogeneity_quick_8_11_Layer_2_0A(
				double glcm_Homogeneity_quick_8_11_Layer_2_0A) {
			this.glcm_Homogeneity_quick_8_11_Layer_2_0A = glcm_Homogeneity_quick_8_11_Layer_2_0A;
		}

		public double getGlcm_Homogeneity_quick_8_11_Layer_1_45A() {
			return glcm_Homogeneity_quick_8_11_Layer_1_45A;
		}

		public void setGlcm_Homogeneity_quick_8_11_Layer_1_45A(
				double glcm_Homogeneity_quick_8_11_Layer_1_45A) {
			this.glcm_Homogeneity_quick_8_11_Layer_1_45A = glcm_Homogeneity_quick_8_11_Layer_1_45A;
		}

		public double getGlcm_Homogeneity_quick_8_11_Layer_3_0A() {
			return glcm_Homogeneity_quick_8_11_Layer_3_0A;
		}

		public void setGlcm_Homogeneity_quick_8_11_Layer_3_0A(
				double glcm_Homogeneity_quick_8_11_Layer_3_0A) {
			this.glcm_Homogeneity_quick_8_11_Layer_3_0A = glcm_Homogeneity_quick_8_11_Layer_3_0A;
		}

		public double getGlcm_Homogeneity_quick_8_11_Layer_2_45A() {
			return glcm_Homogeneity_quick_8_11_Layer_2_45A;
		}

		public void setGlcm_Homogeneity_quick_8_11_Layer_2_45A(
				double glcm_Homogeneity_quick_8_11_Layer_2_45A) {
			this.glcm_Homogeneity_quick_8_11_Layer_2_45A = glcm_Homogeneity_quick_8_11_Layer_2_45A;
		}

		public double getGlcm_Homogeneity_quick_8_11_Layer_3_45A() {
			return glcm_Homogeneity_quick_8_11_Layer_3_45A;
		}

		public void setGlcm_Homogeneity_quick_8_11_Layer_3_45A(
				double glcm_Homogeneity_quick_8_11_Layer_3_45A) {
			this.glcm_Homogeneity_quick_8_11_Layer_3_45A = glcm_Homogeneity_quick_8_11_Layer_3_45A;
		}

		public double getGlcm_Homogeneity_quick_8_11_Layer_1_90A() {
			return glcm_Homogeneity_quick_8_11_Layer_1_90A;
		}

		public void setGlcm_Homogeneity_quick_8_11_Layer_1_90A(
				double glcm_Homogeneity_quick_8_11_Layer_1_90A) {
			this.glcm_Homogeneity_quick_8_11_Layer_1_90A = glcm_Homogeneity_quick_8_11_Layer_1_90A;
		}

		public double getGlcm_Homogeneity_quick_8_11_Layer_2_90A() {
			return glcm_Homogeneity_quick_8_11_Layer_2_90A;
		}

		public void setGlcm_Homogeneity_quick_8_11_Layer_2_90A(
				double glcm_Homogeneity_quick_8_11_Layer_2_90A) {
			this.glcm_Homogeneity_quick_8_11_Layer_2_90A = glcm_Homogeneity_quick_8_11_Layer_2_90A;
		}

		public double getGlcm_Homogeneity_quick_8_11_Layer_3_90A() {
			return glcm_Homogeneity_quick_8_11_Layer_3_90A;
		}

		public void setGlcm_Homogeneity_quick_8_11_Layer_3_90A(
				double glcm_Homogeneity_quick_8_11_Layer_3_90A) {
			this.glcm_Homogeneity_quick_8_11_Layer_3_90A = glcm_Homogeneity_quick_8_11_Layer_3_90A;
		}

		public double getGlcm_Homogeneity_quick_8_11_Layer_1_135A() {
			return glcm_Homogeneity_quick_8_11_Layer_1_135A;
		}

		public void setGlcm_Homogeneity_quick_8_11_Layer_1_135A(
				double glcm_Homogeneity_quick_8_11_Layer_1_135A) {
			this.glcm_Homogeneity_quick_8_11_Layer_1_135A = glcm_Homogeneity_quick_8_11_Layer_1_135A;
		}

		public double getGlcm_Homogeneity_quick_8_11_Layer_2_135A() {
			return glcm_Homogeneity_quick_8_11_Layer_2_135A;
		}

		public void setGlcm_Homogeneity_quick_8_11_Layer_2_135A(
				double glcm_Homogeneity_quick_8_11_Layer_2_135A) {
			this.glcm_Homogeneity_quick_8_11_Layer_2_135A = glcm_Homogeneity_quick_8_11_Layer_2_135A;
		}

		public double getGlcm_Homogeneity_quick_8_11_Layer_3_135A() {
			return glcm_Homogeneity_quick_8_11_Layer_3_135A;
		}

		public void setGlcm_Homogeneity_quick_8_11_Layer_3_135A(
				double glcm_Homogeneity_quick_8_11_Layer_3_135A) {
			this.glcm_Homogeneity_quick_8_11_Layer_3_135A = glcm_Homogeneity_quick_8_11_Layer_3_135A;
		}

		public double getY_Center_Pxl() {
			return y_Center_Pxl;
		}

		public void setY_Center_Pxl(double y_Center_Pxl) {
			this.y_Center_Pxl = y_Center_Pxl;
		}

		public double getX_Center_Pxl() {
			return x_Center_Pxl;
		}

		public void setX_Center_Pxl(double x_Center_Pxl) {
			this.x_Center_Pxl = x_Center_Pxl;
		}
		
	}

